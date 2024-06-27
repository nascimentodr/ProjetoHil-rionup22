package model;

public class Pagamento {
    private int pagamento_id;
    private Venda venda;
    private String tipoPagamento;
    private String status_pagamento;

    public Pagamento(int pagamento_id, Venda venda, String tipoPagamento, String status_pagamento) {
        this.pagamento_id = pagamento_id;
        this.venda = venda;
        this.tipoPagamento = tipoPagamento;
        this.status_pagamento = status_pagamento;
    }

    public int getPagamento_id() {
        return pagamento_id;
    }

    public void setPagamento_id(int pagamento_id) {
        this.pagamento_id = pagamento_id;
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

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }


}