package service;

import dao.VendaProdutoDao;
import java.sql.ResultSet;
import model.VendaProduto;

public class VendaProdutoService {

    private VendaProdutoDao vendaProdutoDao;
    
    public VendaProdutoService(){
        vendaProdutoDao = new VendaProdutoDao();
    }
    
        public ResultSet listar(){
        return vendaProdutoDao.listar();
    }
    
    public boolean inserir(VendaProduto vendaProduto){
        
        if (vendaProduto.getVenda().getVendaId() == -1 ||vendaProduto.getProduto().getProdutoId() == -1 || vendaProduto.getQuantidade() == 0 
                || vendaProduto.getValorUnitario() == 0 || vendaProduto.getValorTotalItem() == 0) 
            return false;
        
        vendaProdutoDao.inserir(vendaProduto);
        return true;
    }
    
    public boolean excluir(VendaProduto vendaProduto){
        
        if (vendaProduto.getVenda().getVendaId() == -1)
            return false;
        
        vendaProdutoDao.excluir(vendaProduto);
        return true;
    }
    
    public boolean editar(VendaProduto vendaProduto){
        if (vendaProduto.getVenda().getVendaId() == -1 ||vendaProduto.getProduto().getProdutoId() == -1 || vendaProduto.getQuantidade() == 0 
                || vendaProduto.getValorUnitario() == 0 || vendaProduto.getValorTotalItem() == 0) 
            return false;
        
        vendaProdutoDao.editar(vendaProduto);
        return true;
    }
    
}
