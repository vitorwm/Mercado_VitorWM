package com.unimed.estoque.security.jwt;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.unimed.estoque.security.services.CustomUserDetailsService;
import com.unimed.estoque.security.services.JWTService;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // Metodo principal onde toda requisição bate antes de chegar no endpoint
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // pega o token de dentro da requisição
        String token = obterToken(request);

        // pega o id do usuário que está dentro do token
        Optional<Integer> id = jwtService.obterIdUsuario(token);

        // Se não encontrou o id, é poque o usuário não mandou o token correto
        if (id.isPresent()) {

            // pega o usuário dono do token pelo seu id
            UserDetails usuario = customUserDetailsService.ObterUsuarioPorId(id.get());

            // Verificar se o usuário está autenticado ou não
            // também poderiam ser validadas as permissões
            UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(usuario, null,
                    Collections.emptyList());

            // mudando a autenticação para a propria requisição
            autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Repassa a autenticação para o contexto do security
            // a partir de agora o spring toma conta do resto
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }
        //Método padrão para filtar as regras do usuário
        filterChain.doFilter(request, response);

    }

    private String obterToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        // Verifica se veio alguma coisa sem ser espaçoes em branco dentro do token
        if (!StringUtils.hasText(token)) {
            return null;
        }

        return token.substring(7);

    }

}
