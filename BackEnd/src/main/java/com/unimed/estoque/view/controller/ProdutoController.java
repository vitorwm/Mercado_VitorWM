package com.unimed.estoque.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimed.estoque.services.ProdutoService;
import com.unimed.estoque.shared.ProdutoDTO;
import com.unimed.estoque.view.model.request.ProdutoRequest;
import com.unimed.estoque.view.model.response.ProdutoResponse;

@RestController
@RequestMapping("/api/mercado/produto")

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponse>> obterTodos(){
        List<ProdutoDTO> produtos = produtoService.obterTodos();
        
        ModelMapper mapper = new ModelMapper();
        
        List<ProdutoResponse> resposta = produtos.stream()
        .map(produtoDto -> mapper.map(produtoDto, ProdutoResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/novo")
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produto){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDto = mapper.map(produto, ProdutoDTO.class);
        produtoDto = produtoService.adicionarProduto(produtoDto);
        return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponse.class),HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/consulta/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id){
        
        Optional<ProdutoDTO> produtoDto = produtoService.obterPorId(id);
        
        ProdutoResponse produto = new ModelMapper().map(produtoDto.get(), ProdutoResponse.class);
        
        return new ResponseEntity<>(Optional.of(produto), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        produtoService.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/atualiza/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest produtoReq,@PathVariable Integer id){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);
        produtoDto = produtoService.atualizar(id, produtoDto);

        return new ResponseEntity<>(
            mapper.map(produtoDto, ProdutoResponse.class),
            HttpStatus.OK
        );
    }

}
