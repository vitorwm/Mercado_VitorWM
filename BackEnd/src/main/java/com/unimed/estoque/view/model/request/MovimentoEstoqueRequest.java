package com.unimed.estoque.view.model.request;

import java.time.LocalDate;
import com.unimed.estoque.model.Produto;
import com.unimed.estoque.model.TipoMovimento;

public class MovimentoEstoqueRequest {

private TipoMovimento tipoMovimentacao;

    private Double valorVenda;

    private Integer qtdeMovimentada;

    private LocalDate data;

    private Produto produto;    

//#endregion

//#region Get e Set
    

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

    public void setData(String dateStr) {

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        this.data = dateStr == null ? null : LocalDate.parse(dateStr);
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
//#endregion
}
