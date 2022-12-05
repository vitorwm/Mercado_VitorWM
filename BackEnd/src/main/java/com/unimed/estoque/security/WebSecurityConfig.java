package com.unimed.estoque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.unimed.estoque.security.jwt.JWTAuthenticationFilter;
import com.unimed.estoque.security.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity //aqui informo que é uma classe de segurança WebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JWTAuthenticationFilter jWTAuthenticationFilter;

    /*
    Método que devolve a instância do objeto que sabe devolver o padrão de codificação
    Não está relacionado com o JWT
    O método será utilizado para codificar a senha do usuário gerando um hash
    */

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

    //Metodo padrão para configurar o custom com o metodo de codificar a senha
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    //Metodo padrão: Método obrigatório para conseguir trabalhar com a autenticação no login
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    //Método que tem a configuração global de acessos e permissões por rotas
    protected void configure(HttpSecurity http) throws Exception{

        // parte padrão da configuração
        http
        .cors().and().csrf().disable()
        .exceptionHandling()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
    
    
    /*
     * Daqui para baixo é onde serão feitas validações específicas do projeto
     * Aqui será informadas as rotas que não vão precisar de autenticação
     */

        .antMatchers(HttpMethod.POST,"/api/mercado/usuarios" , "/api/mercado/usuarios/login")
        .permitAll() //Informa que todos podem acessar sem necessitar de autenticação

        .anyRequest()
        .authenticated(); //Informa que todas as demais requisições devem ser autenticadas
        

        //Aqui é informado que antes de qualquer requisição htto o sistema deve usar o filtro de autenticação jWTAuthenticationFilter
        http.addFilterBefore(jWTAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


    }
}
