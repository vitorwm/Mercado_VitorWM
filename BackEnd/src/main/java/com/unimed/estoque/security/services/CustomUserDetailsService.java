package com.unimed.estoque.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unimed.estoque.services.UsuarioService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    
    @Autowired
    private UsuarioService usuarioService;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    
   // User usuario = getUser(() -> usuarioService.obterPorEmail(email));
   // return usuario;

        return usuarioService.obterPorEmail(email).get();
}

public UserDetails ObterUsuarioPorId(Integer id) {
    return usuarioService.obterPorId(id).get();
}

//private User getUser(Supplier<Optional<User>> supplier){
//return supplier.get().orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//}

}
