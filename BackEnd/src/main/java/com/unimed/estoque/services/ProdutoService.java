package com.unimed.estoque.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimed.estoque.model.Produto;
import com.unimed.estoque.model.exception.ResourceNotFoundException;
import com.unimed.estoque.repository.ProdutoRepository;
import com.unimed.estoque.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna todos os produtos cadastrados
     * @return Lista de produtos
     */
    public List<ProdutoDTO> obterTodos(){
        //return produtoRepository.obterTodos();
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto,ProdutoDTO.class))
        .collect(Collectors.toList());
    }

     /**
     * Metodo para retornar um produto basedo no id
     * 
     * @param id do produto a ser pesquisado
     * @return Retorna um produto
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        //return produtoRepository.obterPorId(id);
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto inexistente");
        }   
        
        ProdutoDTO produtoDto = new ModelMapper().map(produto.get(),  ProdutoDTO.class);
        return Optional.of(produtoDto);
    }

    /**
     * Adiciona um novo produto
     * 
     * @param produto a ser adicionado
     * @return Produto adicionado
     */
    public ProdutoDTO adicionarProduto(ProdutoDTO produtoDto){

        produtoDto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        return produtoDto;

       // return produtoRepository.adicionar(produto);
    }

    /**
     * Remove um produto baseado em seu id
     * 
     * @param id do produto a ser removido
     */
    public void remover(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if  (produto.isEmpty()){
            throw new ResourceNotFoundException("Produto inexistente");
        }
        produtoRepository.deleteById(id);
    }

    /**
     * Metodo para atualizar um produto
     * 
     * @param id do produto que será atualizado
     * @param produto a ser atualizado
     * @return o produto atualizado     
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
        //regra de negocio
        produtoDto.setId(id);

        ModelMapper mapper = new ModelMapper();

        Produto produto =  mapper.map(produtoDto, Produto.class);

        produtoRepository.save(produto);

        return produtoDto;

        //return produtoRepository.atualizar(produto); 
    }


}
