package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import conf.Conexao;

public class ClienteDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public ClienteDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn() // uma linha só
                    .createStatement().executeQuery("SELECT * FROM cliente");   // uma linha só
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Cliente cliente){
        try {
            String SQL = "INSERT INTO cliente(nome, email, endereco, cpf, telefone) " +
                    "VALUES (?, ?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getTelefone());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Cliente cliente){
        try {
            String SQL = "DELETE FROM cliente WHERE cliente_id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, cliente.getClienteId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Cliente cliente){
        try {
            String SQL = "UPDATE cliente SET " +
                        "nome= ?, email= ?, endereco= ?, cpf= ?, telefone= ?" +   // A FALTA DE ESPAÇO 
                        "WHERE cliente_id=?";                                     //NÃO DEU ERRO DE SINTAXE
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail()); 
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getTelefone());
            ps.setInt(6, cliente.getClienteId());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet retornarClienteVenda(int vendaId) {
        try {
            String sql = "SELECT c.* FROM cliente c INNER JOIN venda v ON c.cliente_id = v.cliente_id WHERE v.venda_id = ?";
            
            PreparedStatement ps = conexao.getConn().prepareStatement(sql);
            ps.setInt(1, vendaId);
            
            return ps.executeQuery();  // Retorna o ResultSet com os dados do cliente
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    } 
}