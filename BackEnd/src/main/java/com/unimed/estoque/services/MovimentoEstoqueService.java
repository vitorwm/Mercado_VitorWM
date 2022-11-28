package com.unimed.estoque.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unimed.estoque.model.MovimentoEstoque;
import com.unimed.estoque.model.MovimentoEstoqueLucroProduto;
import com.unimed.estoque.model.MovimentoEstoqueTipoProduto;
import com.unimed.estoque.model.Produto;
import com.unimed.estoque.model.TipoMovimento;
import com.unimed.estoque.model.TipoProduto;
import com.unimed.estoque.model.exception.ResourceNotFoundException;
import com.unimed.estoque.repository.MovimentoEstoqueRepository;
import com.unimed.estoque.repository.ProdutoRepository;
import com.unimed.estoque.shared.MovimentoEstoqueDTO;


@Service
public class MovimentoEstoqueService {

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna todos as movimentacoes cadastrados
     * @return Lista de movimentacoes
     */
    public List<MovimentoEstoqueDTO> obterTodos(){
        //return produtoRepository.obterTodos();
        List<MovimentoEstoque> movimentacao = movimentoEstoqueRepository.findAll();
        return movimentacao.stream()
        .map(movimentoEstoque -> new ModelMapper().map(movimentoEstoque,MovimentoEstoqueDTO.class))
        .collect(Collectors.toList());
    }

     /**
     * Metodo para retornar uma movimentacao basedo no id
     * 
     * @param id da movimentacao a ser pesquisado
     * @return Retorna uma movimentacao
     */
    public Optional<MovimentoEstoqueDTO> obterPorId(Integer id){
        //return produtoRepository.obterPorId(id);
        Optional<MovimentoEstoque> movimentoEstoque = movimentoEstoqueRepository.findById(id);

        if(movimentoEstoque.isEmpty()){
            throw new ResourceNotFoundException("Movimento inexistente");
        }   
        
        MovimentoEstoqueDTO movimentacaoDto = new ModelMapper().map(movimentoEstoque.get(),  MovimentoEstoqueDTO.class);
        return Optional.of(movimentacaoDto);
    }

    /**
     * Metodo para retornar uma movimentacao de um produto baseado no id
     * 
     * @param id do produto a ser pesquisado
     * @return Retorna uma movimentacao do produto
     */
    public List<MovimentoEstoque> obterPorIdProduto(Integer id){
        //return produtoRepository.obterPorId(id);
        List<MovimentoEstoque> movimentoEstoque = movimentoEstoqueRepository.findAll()
        .stream()
        .filter(movimento -> movimento.getProduto().getId() == id)
        .collect(Collectors.toList());
        
        if(movimentoEstoque.isEmpty()){
            throw new ResourceNotFoundException("Movimento inexistente");
        }   
               
        return movimentoEstoque;
    }



    /**
     * Metodo para retornar uma movimentacao de produtos baseado no tipo
     * 
     * @param tipo do produto a ser pesquisado
     * @return Retorna uma movimentacao do produto com a quantidade baixada no estoque e o estoque atual
     */
    public List<MovimentoEstoqueTipoProduto> obterPorTipoProduto(TipoProduto tipo){
        //return produtoRepository.obterPorId(id);
        
        List<MovimentoEstoqueTipoProduto> resultado = new ArrayList<MovimentoEstoqueTipoProduto>();

        List<MovimentoEstoque> movimentoEstoque = movimentoEstoqueRepository.findAll()
        .stream()
        .filter(movimento -> movimento.getProduto().getTipo() == tipo)
        .collect(Collectors.toList());
        
        if(movimentoEstoque.isEmpty()){
            throw new ResourceNotFoundException("Movimento inexistente");
        } 

        List<MovimentoEstoque> movimentoPorProduto = new ArrayList<>(
            movimentoEstoque.stream()
            .collect(Collectors.toCollection(
              () -> new TreeSet<MovimentoEstoque>((p1, p2) -> p1.getProduto().getId().compareTo(p2.getProduto().getId())) 
            ))
        );
        
        Integer totalMovimentado = 0;

        for (MovimentoEstoque itemProduto : movimentoPorProduto) {
            
            for (MovimentoEstoque item : movimentoEstoque) {
                if (item.getProduto().getId() == itemProduto.getProduto().getId())
                {
                    if (item.getTipoMovimentacao() == TipoMovimento.SAIDA)
                    {
                        totalMovimentado+=item.getQtdeMovimentada();
                    }
                }
            }
            MovimentoEstoqueTipoProduto movimento = new MovimentoEstoqueTipoProduto(
                itemProduto.getProduto().getId(), 
                itemProduto.getProduto().getDescricao(), 
                itemProduto.getProduto().getEstoque(), 
                totalMovimentado, 
                itemProduto.getProduto().getvalorFornecedor(),
                itemProduto.getProduto().getTipo()); 
            resultado.add(movimento);
            totalMovimentado = 0;
        }

        return resultado;
    }



    /**
     * Metodo para retornar uma movimentacao de produtos baseado no tipo
     * 
     * @param tipo do produto a ser pesquisado
     * @return Retorna uma movimentacao do produto com a quantidade baixada no estoque e o estoque atual
     */
    public List<MovimentoEstoqueLucroProduto> obterLucroPorProduto(){
        //return produtoRepository.obterPorId(id);
        
        List<MovimentoEstoqueLucroProduto> resultado = new ArrayList<MovimentoEstoqueLucroProduto>();

        List<MovimentoEstoque> movimentoEstoque = movimentoEstoqueRepository.findAll();
        
        
        if(movimentoEstoque.isEmpty()){
            throw new ResourceNotFoundException("Movimento inexistente");
        } 

        List<MovimentoEstoque> movimentoPorProduto = new ArrayList<>(
            movimentoEstoque.stream()
            .collect(Collectors.toCollection(
              () -> new TreeSet<MovimentoEstoque>((p1, p2) -> p1.getProduto().getId().compareTo(p2.getProduto().getId())) 
            ))
        );
        
        Integer totalMovimentado = 0;
        Double totalComercializado = 0.0;

        for (MovimentoEstoque itemProduto : movimentoPorProduto) {
            
            for (MovimentoEstoque item : movimentoEstoque) {
                if (item.getProduto().getId() == itemProduto.getProduto().getId())
                {
                    if (item.getTipoMovimentacao() == TipoMovimento.SAIDA)
                    {
                        totalMovimentado+=item.getQtdeMovimentada();
                        totalComercializado += (item.getQtdeMovimentada() * item.getValorVenda());
                    }
                }
            }


            MovimentoEstoqueLucroProduto movimento = new MovimentoEstoqueLucroProduto(
                itemProduto.getProduto().getId(), 
                itemProduto.getProduto().getDescricao(), 
                itemProduto.getProduto().getEstoque(), 
                totalMovimentado, 
                (totalComercializado - (itemProduto.getProduto().getvalorFornecedor() * totalMovimentado)),
                itemProduto.getProduto().getTipo()); 
            resultado.add(movimento);

            totalMovimentado = 0;
            totalComercializado = 0.0;
        }

        return resultado;
    }


    /**
     * Adiciona um novo movimento
     * 
     * @param produto a ser adicionado
     * @return Produto adicionado
     */
    public MovimentoEstoqueDTO adicionarMovimentacao(MovimentoEstoqueDTO movimentacaoDto){
        movimentacaoDto.setId(null);
      
        Optional<Produto> produtoOpt = produtoRepository.findById(movimentacaoDto.getProduto().getId());

        if(produtoOpt.isEmpty()){
            throw new ResourceNotFoundException("Produto inexistente");
        }

        Produto produto = produtoOpt.get();
        //Verifica estoque se for baixa
        if (movimentacaoDto.getTipoMovimentacao() == TipoMovimento.SAIDA)
        {
            //verifica se o estoque permite a baixa solicitada
            if ((produto.getEstoque() - movimentacaoDto.getQtdeMovimentada()) < 0)
            {
                throw new ResourceNotFoundException("O estoque deste produto não permite essa movimentação");
            }
            else
            {
                //decrementa o estoque do produto                
                produto.setEstoque(produto.getEstoque() - movimentacaoDto.getQtdeMovimentada());
            }
        }
        else
        {
            //se for entrada de estoque, atualiza o preço de venda e incrementa o estoque
            produto.setEstoque(produto.getEstoque() + movimentacaoDto.getQtdeMovimentada());
            //produto.setvalorFornecedor(movimentacaoDto.getValorVenda());
        }


        ModelMapper mapper = new ModelMapper();
        MovimentoEstoque movimentoEstoque = mapper.map(movimentacaoDto, MovimentoEstoque.class);
        movimentoEstoque = movimentoEstoqueRepository.save(movimentoEstoque);
        movimentacaoDto.setId(movimentoEstoque.getId());
        return movimentacaoDto;
    }

    /**
     * Remove uma movimentacao baseado em seu id
     * 
     * @param id da movimentacao a ser removida
     */
    public void remover(Integer id){
        Optional<MovimentoEstoque> movimentoEstoque = movimentoEstoqueRepository.findById(id);
        if  (movimentoEstoque.isEmpty()){
            throw new ResourceNotFoundException("Movimentacao inexistente");
        }
        movimentoEstoqueRepository.deleteById(id);
    }

    /**
     * Metodo para atualizar uma movimentacao
     * 
     * @param id da mocimentacao que será atualizada
     * @param movimentacao a ser atualizada
     * @return a movimentacao atualizada     
     */
    public MovimentoEstoqueDTO atualizar(Integer id, MovimentoEstoqueDTO movimentacaoDto){
        //regra de negocio
        movimentacaoDto.setId(id);

        ModelMapper mapper = new ModelMapper();

        MovimentoEstoque movimentoEstoque =  mapper.map(movimentacaoDto, MovimentoEstoque.class);

        movimentoEstoqueRepository.save(movimentoEstoque);

        return movimentacaoDto;
    }


}
