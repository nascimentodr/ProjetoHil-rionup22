package model;

public class VendaProduto {
    private Venda venda;
    private Produto produto;
    private int quantidade;
    private double valorUnitario;
    private double valorTotalItem;

    public VendaProduto(Venda venda, Produto produto, int quantidade, double valorUnitario, double valorTotalItem) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotalItem = valorTotalItem;
    }
    
    //public double CalcularValorTotalItem(){
    //    return quantidade * valorUnitario;
    //}
    
    public void CalcularValorTotalItem() {
        this.valorTotalItem = quantidade * valorUnitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem(double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
 
}
