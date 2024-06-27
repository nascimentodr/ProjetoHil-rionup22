package service;

import dao.ProdutoDao;
import java.sql.ResultSet;
import model.Produto;

public class ProdutoService {
    
    private ProdutoDao produtoDao;
    
    public ProdutoService(){
        produtoDao = new ProdutoDao();
    }
    
        public ResultSet listar(){
        return produtoDao.listar();
    }
    
    public boolean inserir(Produto produto){
        
        if (produto.getNome() == "" || produto.getQuantidadeEstoque() == 0)
            return false;
        
        produtoDao.inserir(produto);
        return true;
    }
    
    public boolean excluir(Produto produto){
        if (produto.getProdutoId() == -1)
            return false;
        
        produtoDao.excluir(produto);
        return true;
    }
    
    public boolean editar(Produto produto){
        if (produto.getNome() == "" || produto.getQuantidadeEstoque() == 0)
            return false;
        
        produtoDao.editar(produto);
        return true;
    }
}
