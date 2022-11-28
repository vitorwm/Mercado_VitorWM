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

import com.unimed.estoque.model.MovimentoEstoque;
import com.unimed.estoque.model.MovimentoEstoqueLucroProduto;
import com.unimed.estoque.model.MovimentoEstoqueTipoProduto;
import com.unimed.estoque.model.TipoProduto;
import com.unimed.estoque.services.MovimentoEstoqueService;
import com.unimed.estoque.shared.MovimentoEstoqueDTO;
import com.unimed.estoque.view.model.MovimentoEstoqueLucroProdutoResponse;
import com.unimed.estoque.view.model.MovimentoEstoqueRequest;
import com.unimed.estoque.view.model.MovimentoEstoqueResponse;
import com.unimed.estoque.view.model.MovimentoEstoqueTipoProdutoResponse;

@RestController
@RequestMapping("/api/mercado/estoque")

public class MovimentoEstoqueController {
    @Autowired
    private MovimentoEstoqueService movimentoEstoqueService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/movimentacoes")
    public ResponseEntity<List<MovimentoEstoqueResponse>> obterTodos(){
        List<MovimentoEstoqueDTO> movimentacao = movimentoEstoqueService.obterTodos();
        
        ModelMapper mapper = new ModelMapper();
        
        List<MovimentoEstoqueResponse> resposta = movimentacao.stream()
        .map(movimentoDto -> mapper.map(movimentoDto, MovimentoEstoqueResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/movimento")
    public ResponseEntity<MovimentoEstoqueResponse> adicionar(@RequestBody MovimentoEstoqueRequest movimentacao){
        ModelMapper mapper = new ModelMapper();
        MovimentoEstoqueDTO movimentoDto = mapper.map(movimentacao, MovimentoEstoqueDTO.class);
        movimentoDto = movimentoEstoqueService.adicionarMovimentacao(movimentoDto);
        return new ResponseEntity<>(mapper.map(movimentoDto, MovimentoEstoqueResponse.class),HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/consulta/{id}")
    public ResponseEntity<Optional<MovimentoEstoqueResponse>> obterPorId(@PathVariable Integer id){
        
        Optional<MovimentoEstoqueDTO> movimentoDto = movimentoEstoqueService.obterPorId(id);
        
        MovimentoEstoqueResponse movimentacao = new ModelMapper().map(movimentoDto.get(), MovimentoEstoqueResponse.class);
        
        return new ResponseEntity<>(Optional.of(movimentacao), HttpStatus.OK);


        
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/movimentoproduto/{id}")
    public ResponseEntity<List<MovimentoEstoqueResponse>> obterPorIdProduto(@PathVariable Integer id){
        
        List<MovimentoEstoque> movimentacao = movimentoEstoqueService.obterPorIdProduto(id);
        
        ModelMapper mapper = new ModelMapper();
        
        List<MovimentoEstoqueResponse> resposta = movimentacao.stream()
        .map(movimentoDto -> mapper.map(movimentoDto, MovimentoEstoqueResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/movimentoprodutoportipo/{tipo}")
    public ResponseEntity<List<MovimentoEstoqueTipoProdutoResponse>> obterPorTipoProduto(@PathVariable TipoProduto tipo){
        
        List<MovimentoEstoqueTipoProduto> movimentacao = movimentoEstoqueService.obterPorTipoProduto(tipo);
        
        ModelMapper mapper = new ModelMapper();
        
        List<MovimentoEstoqueTipoProdutoResponse> resposta = movimentacao.stream()
        .map(movimentoDto -> mapper.map(movimentoDto, MovimentoEstoqueTipoProdutoResponse.class))
        .collect(Collectors.toList());


        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/movimentofinanceiro")
    public ResponseEntity<List<MovimentoEstoqueLucroProdutoResponse>> obterLucroPorProduto(){
        
        List<MovimentoEstoqueLucroProduto> movimentacao = movimentoEstoqueService.obterLucroPorProduto();
        
        ModelMapper mapper = new ModelMapper();
        
        List<MovimentoEstoqueLucroProdutoResponse> resposta = movimentacao.stream()
        .map(movimentoDto -> mapper.map(movimentoDto, MovimentoEstoqueLucroProdutoResponse.class))
        .collect(Collectors.toList());


        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/excluimovimentacao/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        movimentoEstoqueService.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/modificamovimentacao/{id}")
    public ResponseEntity<MovimentoEstoqueResponse> atualizar(@RequestBody MovimentoEstoqueRequest movimentacaoReq,@PathVariable Integer id){
        ModelMapper mapper = new ModelMapper();
        MovimentoEstoqueDTO movimentoDto = mapper.map(movimentacaoReq, MovimentoEstoqueDTO.class);
        movimentoDto = movimentoEstoqueService.atualizar(id, movimentoDto);

        return new ResponseEntity<>(
            mapper.map(movimentoDto, MovimentoEstoqueResponse.class),
            HttpStatus.OK
        );
    }

   

}
