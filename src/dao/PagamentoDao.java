package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pagamento;
import conf.Conexao;


public class PagamentoDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public PagamentoDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn() // uma linha só
                    .createStatement().executeQuery("SELECT * FROM pagamento");   // uma linha só
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(Pagamento pagamento){
        try {
            String SQL = "INSERT INTO pagamento(venda_id, tipo_pagamento, status_pagamento) " +
                    "VALUES (?, ?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            
            ps.setInt(1, pagamento.getVenda().getVendaId());
            ps.setString(2, pagamento.getTipoPagamento());
            ps.setString(3, pagamento.getStatus_pagamento());
            
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Pagamento pagamento){
        try {
            String SQL = "DELETE FROM pagamento WHERE id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, pagamento.getPagamento_id());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Pagamento pagamento){
        try {
            String SQL = "UPDATE pagamento SET " +
                        "tipo_pagamento = ?, status_pagamento = ?" + 
                        "WHERE id=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            

            ps.setString(2, pagamento.getTipoPagamento());
            ps.setString(3, pagamento.getStatus_pagamento());
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}