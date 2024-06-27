package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.VendaProduto;
import conf.Conexao;

public class VendaProdutoDao {
    
    private Conexao conexao;
    private PreparedStatement ps;
    
    public VendaProdutoDao(){
        conexao = new Conexao();        
    }
    
    public ResultSet listar(){
        try {
            return conexao.getConn() // uma linha só
                    .createStatement().executeQuery("SELECT * FROM venda_produto");   // uma linha só
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void inserir(VendaProduto vendaProduto){
        try {
            String SQL = "INSERT INTO venda_produto (venda_id, produto_id, quantidade, valor_unidade, valor_total_item) " +
                    "VALUES (?, ?, ?, ?, ?)";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, vendaProduto.getVenda().getVendaId());
            ps.setInt(2, vendaProduto.getProduto().getProdutoId());
            ps.setInt(3, vendaProduto.getQuantidade());
            ps.setDouble(4, vendaProduto.getValorUnitario());
            ps.setDouble(5, vendaProduto.getValorTotalItem());
            
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir(VendaProduto vendaProduto){
        try {
            String SQL = "DELETE FROM venda_produto where venda_id = ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, vendaProduto.getVenda().getVendaId());           
                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void editar(VendaProduto vendaProduto){
        try {
            String SQL = "UPDATE venda_produto SET " +
                        "venda_id = ?, produto_id, quantidade= ?, valor_unidade= ?, valor_total_item= ?";
            
            ps = conexao.getConn().prepareStatement(SQL);
            
            ps.setInt(1, vendaProduto.getVenda().getVendaId());
            ps.setInt(2, vendaProduto.getProduto().getProdutoId());
            ps.setInt(3, vendaProduto.getQuantidade());
            ps.setDouble(4, vendaProduto.getValorUnitario());
            ps.setDouble(5, vendaProduto.getValorTotalItem());

                        
            ps.executeUpdate();
                        
            ps.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet retornarProdutoMaisVendido(){
        try {
            return conexao.getConn()
                    .createStatement().executeQuery("SELECT p.nome, vp.produto_id, SUM(vp.quantidade) as quantidade_total "
                            + "FROM venda_produto vp "
                            + "INNER JOIN venda v ON vp.venda_id = v.venda_id "
                            + "INNER JOIN produto p ON vp.produto_id = p.produto_id "
                            + "WHERE v.data = ? "
                            + "GROUP BY p.nome, vp.produto_id "
                            + "ORDER BY quantidade_total DESC "
                            + "LIMIT 1");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}  
