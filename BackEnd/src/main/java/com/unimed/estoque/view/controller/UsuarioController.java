package com.unimed.estoque.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimed.estoque.model.Usuario;
import com.unimed.estoque.services.UsuarioService;
import com.unimed.estoque.view.model.request.LoginRequest;
import com.unimed.estoque.view.model.response.LoginResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/mercado/usuarios")
public class UsuarioController {
 
    @Autowired
    private UsuarioService servicoUsuario;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Usuario> obterTodos(){
        return servicoUsuario.obterTodos();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Optional<Usuario> obter(@PathVariable("id") Integer id){
        return servicoUsuario.obterPorId(id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Usuario adicionar (@RequestBody Usuario usuario){
        return servicoUsuario.adicionar(usuario);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return servicoUsuario.logar(request.getEmail(), request.getPassword());
    }
}
