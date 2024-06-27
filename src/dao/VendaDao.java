package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Venda;
import conf.Conexao;
import java.sql.Date;

public class VendaDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public VendaDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn() // uma linha só
                    .createStatement().executeQuery("SELECT * FROM venda");   // uma linha só
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Venda venda){
        try {
            String SQL = "INSERT INTO venda (cliente_id, data, valor_total) " +
                    "VALUES (?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(2, venda.getCliente().getClienteId());
            ps.setDate(3, new java.sql.Date (venda.getData().getTime()));
            ps.setDouble(4, venda.getValorTotal());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Venda venda){
        try {
            String SQL = "DELETE FROM venda WHERE id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, venda.getVendaId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Venda venda){
        try {
            String SQL = "UPDATE venda SET " +
                        "cliente_id, data= ?, valor_total= ?" +
                        "WHERE id=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(2, venda.getCliente().getClienteId());
            ps.setDate(3, (Date) venda.getData());
            ps.setDouble(4, venda.getValorTotal());

                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet retornarVendasPorDia(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT count(*) FROM venda v WHERE data = ?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
} 

