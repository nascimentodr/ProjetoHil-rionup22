package service;

import dao.ClienteDao;
import java.sql.ResultSet;
import model.Cliente;

public class ClienteService {
    
    private ClienteDao clienteDao;
    
    public ClienteService(){
        clienteDao = new ClienteDao();
    }
    
    public ResultSet listar(){
        return clienteDao.listar();
    }
    
    public boolean inserir(Cliente cliente){
        
        if (cliente.getNome() == "" || cliente.getCPF() == "" || cliente.getTelefone() == "")
            return false;
        
        clienteDao.inserir(cliente);
        return true;
    }
    
    public boolean excluir(Cliente cliente){
        if (cliente.getClienteId() == -1)
            return false;
        
        clienteDao.excluir(cliente);
        return true;
    }
    
    public boolean editar(Cliente cliente){
        if (cliente.getNome() == "" || cliente.getCPF() == "" || cliente.getTelefone() == "")
            return false;
        
        clienteDao.editar(cliente);
        return true;
    }

    public ResultSet retornarClienteVenda(int vendaId){  
        return clienteDao.retornarClienteVenda(vendaId);
    } 
    
}