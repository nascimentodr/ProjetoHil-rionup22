package model;

public class Pagamento {
    private Venda venda;
    private String tipoPagamento;
    private String status;

    public Pagamento(Venda venda, String tipoPagamento, String status) {
        this.venda = venda;
        this.tipoPagamento = tipoPagamento;
        this.status = status;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
