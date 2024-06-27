package service;

import dao.PagamentoDao;
import java.sql.ResultSet;
import model.Pagamento;

public class PagamentoService {

    private PagamentoDao pagamentoDao;
    
    public PagamentoService(){
        pagamentoDao = new PagamentoDao();
    }
    
    public ResultSet listar(){
        return pagamentoDao.listar();
    }
    
    public boolean inserir(Pagamento pagamento){
        
        if (pagamento.getVenda().getVendaId() == -1 || pagamento.getTipoPagamento() == "" || pagamento.getStatus_pagamento() == "")
            return false;
        
        pagamentoDao.inserir(pagamento);
        return true;
    }
    
    public boolean excluir(Pagamento pagamento){
        if (pagamento.getPagamento_id() == -1)
            return false;
        
        pagamentoDao.excluir(pagamento);
        return true;
    }
    
    public boolean editar(Pagamento pagamento){
        if (pagamento.getVenda().getVendaId() == -1 || pagamento.getTipoPagamento() == "" || pagamento.getStatus_pagamento() == "")
            return false;
        
        pagamentoDao.editar(pagamento);
        return true;
    }
}
