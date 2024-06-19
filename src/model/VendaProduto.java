package model;

public class VendaProduto {
    private Venda venda;
    private Produto produto;
    private int quantidade;
    private double valorUnitario;

    public VendaProduto(Venda venda, Produto produto, int quantidade, double valorUnitario) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
    
    public double CalcularValorTotalItem() {
        return quantidade * valorUnitario;
    }
    
    public Venda getVendaId() {
        return venda;
    }

    public void setVendaId(Venda vendaId) {
        this.venda = vendaId;
    }

    public Produto getProdutoId() {
        return produto;
    }

    public void setProdutoId(Produto produtoId) {
        this.produto = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    
}
