package com.unimed.estoque.services;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unimed.estoque.model.Usuario;
import com.unimed.estoque.repository.UsuarioRepository;
import com.unimed.estoque.security.services.JWTService;
import com.unimed.estoque.view.model.response.LoginResponse;

@Service
public class UsuarioService {
    
private static final String headerPrefix = "Bearer ";

@Autowired
private UsuarioRepository repositorioUsuario;

@Autowired
private PasswordEncoder passwordEncoder;

@Autowired
private JWTService jwtService;

@Autowired
private  AuthenticationManager authenticationManager;

public List<Usuario> obterTodos(){
    return repositorioUsuario.findAll();
}

public Optional<Usuario> obterPorId(Integer id){
    return repositorioUsuario.findById(id);
}  

public Optional<Usuario> obterPorEmail(String email){
    return repositorioUsuario.findByEmail(email);
}  

public Usuario adicionar (Usuario usuario){
    usuario.setId(null);

    if(obterPorEmail(usuario.getEmail()).isPresent()){
        throw new InputMismatchException("Já existe um usuário cadastrado com o email: "+usuario.getEmail());
    }
    //Aqui é codificada a senha para ser guardado o seu hash
    String senha = passwordEncoder.encode(usuario.getPassword());

    usuario.setPassword(senha);

    return repositorioUsuario.save(usuario);
} 


public LoginResponse logar(String email, String senha){

    //Aqui que a autenticação acontece
    Authentication autenticacao = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(email, senha , Collections.emptyList()));

    //Aqui passa a nova autenticaçao para o Spring Security cuidar
    SecurityContextHolder.getContext().setAuthentication(autenticacao);

    //Gera o token do usuário para devolver a ele
    //Bearer codigoToken
    String token = headerPrefix + jwtService.gerarToken(autenticacao);

    Usuario usuario = repositorioUsuario.findByEmail(email).get();

    return new LoginResponse(token, usuario);

}

}
