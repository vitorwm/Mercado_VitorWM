package com.unimed.estoque.model;

public class MovimentoEstoqueTipoProduto {

//#region Atributos
    private Integer id;
        
    private String descricao;
    
    private Integer estoque;

    private Integer vendas;

    private Double valorFornecedor;

    private TipoProduto tipo;
    
//#endregion

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

    public MovimentoEstoqueTipoProduto(Integer id, String descricao, Integer estoque, Integer vendas, Double valorFornecedor, TipoProduto tipo) {
        this.id = id;
        this.descricao = descricao;
        this.estoque = estoque;
        this.vendas = vendas;
        this.valorFornecedor = valorFornecedor;
        this.tipo = tipo;
    }

}
