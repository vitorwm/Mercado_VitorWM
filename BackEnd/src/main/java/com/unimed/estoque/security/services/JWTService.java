package com.unimed.estoque.security.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.unimed.estoque.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTService {

    //chave secreta utilixada pelo JWT para codificar e decodificar o token
    private static final String chavePrivadaJWT = "secretKey";

    /**
     * Metodo para gerar o token JWT
     * @param authentication Autenticação do usuário
     * @return Token
     */

    public String gerarToken(Authentication authentication ){

        //1 dia em millisegundos
        int tempoExpiração = 86400000;

        //Criacao da data de expiração do token com base no tempoExpiração
        //nesse caso pega a data atual e soma mais 1 dia em millisegundos
        Date dataExpiracao = new Date( new Date().getTime() +tempoExpiração);


        //aqui pegamos o usuário atual da autenticação
        Usuario user = (Usuario) authentication.getPrincipal();

        // aqui ele pega todos os dados e retorna um token do JWT
        return Jwts.builder()
        .setSubject(user.getId().toString())
        .setIssuedAt(new Date())
        .setExpiration(dataExpiracao)
        .signWith(SignatureAlgorithm.HS512, chavePrivadaJWT)
        .compact();
    }


    /**
     * Metodo para retornar o id do usuário dono do token
     * @param token token do usuário
     * @return id do usuário
     */    
    public Optional<Integer> obterIdUsuario(String token){

        try{
            // Retorna as permissões do token
            Claims claims = parse(token).getBody();

            //Retorna o id de dentro do token se entrar, caso contrário retorna null
            return Optional.ofNullable(Integer.parseInt(claims.getSubject()));

        }catch (Exception e){
            //se não encontrar nada, devolve um optional null
            return Optional.empty();

        }
    }
    
    // Metodo que sabe descobrir de dentro do token com base na chave privada quais as permissões do usuário
    private Jws<Claims> parse(String token){
        return Jwts.parser().setSigningKey(chavePrivadaJWT).parseClaimsJws(token);
    }
    
}
