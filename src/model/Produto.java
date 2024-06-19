package model;

public class Produto{
    private int produtoId;
    private String nome;
    private int quantidadeEstoque;
    private double precoUnidade;

    public Produto(int produtoId, String nome, int quantidadeEstoque, double precoUnidade) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoUnidade = precoUnidade;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(double precoUnidade) {
        this.precoUnidade = precoUnidade;
    }
    
}
