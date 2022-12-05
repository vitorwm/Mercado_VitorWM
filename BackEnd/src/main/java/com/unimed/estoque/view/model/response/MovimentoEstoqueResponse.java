package com.unimed.estoque.view.model.response;

import java.time.LocalDate;
import com.unimed.estoque.model.Produto;
import com.unimed.estoque.model.TipoMovimento;

public class MovimentoEstoqueResponse {

//#region Atributos
    private Integer id;
        
    private TipoMovimento tipoMovimentacao;

    private Double valorVenda;

    private Integer qtdeMovimentada;

    private LocalDate data;

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
