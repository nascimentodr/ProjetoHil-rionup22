package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;
import conf.Conexao;

public class ProdutoDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public ProdutoDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn() // uma linha só
                    .createStatement().executeQuery("SELECT * FROM produto");   // uma linha só
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void inserir(Produto produto){
        try {
            String SQL = "INSERT INTO produto(nome, quantidade_de_estoque) " +
                    "VALUES (?, ?) ";
            
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidadeEstoque());

                      
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(Produto produto){
        try {
            String SQL = "DELETE FROM produto WHERE produto_id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, produto.getProdutoId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(Produto produto){
        try {
            String SQL = "UPDATE produto SET " +
                        "nome= ?, quantidade_de_estoque= ? " + 
                        "WHERE produto_id=?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getQuantidadeEstoque());
            ps.setInt(3, produto.getProdutoId());

            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
