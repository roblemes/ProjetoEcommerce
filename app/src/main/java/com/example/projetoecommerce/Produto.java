package com.example.projetoecommerce;

public class Produto {
    private String produtoNome, produtoMarca, produtoCategoria, produtoGarantia;
    private double produtoValor;
    private int produtoAvaliacao, produtoEstoque;

    public Produto() {
    }

    public Produto(String produtoNome, String produtoMarca, String produtoCategoria, double produtoValor, int produtoAvaliacao, int produtoEstoque) {
        this.produtoNome = produtoNome;
        this.produtoMarca = produtoMarca;
        this.produtoCategoria = produtoCategoria;
        this.produtoValor = produtoValor;
        this.produtoAvaliacao = produtoAvaliacao;
        this.produtoEstoque = produtoEstoque;
        this.produtoGarantia = produtoGarantia;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoMarca() {
        return produtoMarca;
    }

    public void setProdutoMarca(String produtoMarca) {
        this.produtoMarca = produtoMarca;
    }

    public String getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(String produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public int getProdutoAvaliacao() {
        return produtoAvaliacao;
    }

    public void setProdutoAvaliacao(int produtoAvaliacao) {
        this.produtoAvaliacao = produtoAvaliacao;
    }

    public int getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(int produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public String getProdutoGarantia() {
        return produtoGarantia;
    }

    public void setProdutoGarantia(String produtoGarantia) {
        this.produtoGarantia = produtoGarantia;
    }

    @Override
    public String toString() {
        return
                "Nome do produto: " + produtoNome + '\n' +
                "Marca: " + produtoMarca + '\n' +
                "Categoria: " + produtoCategoria + '\n' +
                "Valor: " + produtoValor + '\n' +
                "Avaliacao: " + produtoAvaliacao + '\n' +
                "Estoque: " + produtoEstoque + '\n' +
                "Garantia: " + produtoGarantia
                ;
    }
}
