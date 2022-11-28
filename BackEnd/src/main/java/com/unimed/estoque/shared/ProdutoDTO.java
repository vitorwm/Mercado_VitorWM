package com.unimed.estoque.shared;

import com.unimed.estoque.model.TipoProduto;

public class ProdutoDTO {

    private Integer id;
    
    private String descricao;
      
    private Integer estoque;
    
    private Double valorFornecedor;
    
    private TipoProduto tipo;


//#region Get e Set
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getvalorFornecedor() {
        return valorFornecedor;
    }

    public void setvalorFornecedor(Double valorFornecedor) {
        this.valorFornecedor = valorFornecedor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
//#endregion 
}
