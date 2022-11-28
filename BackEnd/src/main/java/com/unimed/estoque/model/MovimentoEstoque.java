package com.unimed.estoque.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MovimentoEstoque {

//#region Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer id;
    
    private TipoMovimento tipoMovimentacao;
    
   
    private Double valorVenda;
    
    private Integer qtdeMovimentada;

    private LocalDate data;

    @ManyToOne
    private Produto produto;    
    
//#endregion

//#region Get e Set
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoMovimento getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimento tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Double getValorVenda() {
        return this.valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQtdeMovimentada() {
        return this.qtdeMovimentada;
    }

    public void setQtdeMovimentada(Integer qtdeMovimentada) {
        this.qtdeMovimentada = qtdeMovimentada;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

        
//#endregion
}
