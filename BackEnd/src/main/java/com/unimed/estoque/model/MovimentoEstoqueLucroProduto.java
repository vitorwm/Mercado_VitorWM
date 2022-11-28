package com.unimed.estoque.model;

public class MovimentoEstoqueLucroProduto {
   
//#region Atributos
    private Integer id;
                
    private String descricao;

    private Integer estoque;

    private Integer vendas;

    private Double lucroTotal;

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

    public Double getLucroTotal() {
        return this.lucroTotal;
    }

    public void setLucroTotal(Double lucroTotal) {
        this.lucroTotal = lucroTotal;
    }

    public TipoProduto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }


    public MovimentoEstoqueLucroProduto(Integer id, String descricao, Integer estoque, Integer vendas, Double lucroTotal, TipoProduto tipo) {
        this.id = id;
        this.descricao = descricao;
        this.estoque = estoque;
        this.vendas = vendas;
        this.lucroTotal = lucroTotal;
        this.tipo = tipo;
    }


//#endregion
}
