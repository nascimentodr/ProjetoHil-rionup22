package model;
import java.util.Date;
import java.util.List;

public class Venda {
    private int vendaId;
    private Cliente cliente;
    private Date data;
    private List<VendaProduto> itensVendidos;

    public Venda(int vendaId, Cliente cliente, Date data, List<VendaProduto> itensVendidos) {
        this.vendaId = vendaId;
        this.cliente = cliente;
        this.data = data;
        this.itensVendidos = itensVendidos;
    }
    
    public double calcularValorTotal() {
    double valorTotal = 0.0;
    for (VendaProduto item : itensVendidos) {
        valorTotal += item.CalcularValorTotalItem();
    }
        return valorTotal;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<VendaProduto> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<VendaProduto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }
       
}
