package com.unimed.estoque.view.model.response;

import com.unimed.estoque.model.TipoProduto;

public class MovimentoEstoqueTipoProdutoResponse {
    
//#region Atributos
    private Integer id;
            
    private String descricao;

    private Integer estoque;

    private Integer vendas;

    private Double valorFornecedor;

    private TipoProduto tipo;

//#endregion

//#endregion Get e Set
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getVendas() {
        return this.vendas;
    }

    public void setVendas(Integer vendas) {
        this.vendas = vendas;
    }

    public Double getValorFornecedor() {
        return this.valorFornecedor;
    }

    public void setValorFornecedor(Double valorFornecedor) {
        this.valorFornecedor = valorFornecedor;
    }

    public TipoProduto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

//#endregion
}
