package service;

import dao.VendaDao;
import java.sql.ResultSet;
import model.Venda;

public class VendaService {
    
    private VendaDao vendaDao;
    
    public VendaService(){
        vendaDao = new VendaDao();
    }
    
    public ResultSet listar(){
        return vendaDao.listar();
    }
    
    public boolean inserir(Venda venda){
        
        if (venda.getCliente().getClienteId() == 0 || venda.getData() == null || venda.getValorTotal() == 0)
            return false;
        
        vendaDao.inserir(venda);
        return true;
    }
    
    public boolean excluir(Venda venda){
        
        if (venda.getVendaId() == -1)
            return false;
        
        vendaDao.excluir(venda);
        return true;
    }
    
    public boolean editar(Venda venda){
        if (venda.getCliente().getClienteId() == 0 || venda.getData() == null || venda.getValorTotal() == 0)
            return false;
        
        vendaDao.editar(venda);
        return true;
    } 
    
    public ResultSet retornarVendasPorDia(){
        return vendaDao.retornarVendasPorDia();
    }
}


    
