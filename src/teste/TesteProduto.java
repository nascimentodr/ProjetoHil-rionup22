
package teste;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Produto;
import model.Venda;
import service.ProdutoService;


public class TesteProduto {
    public void opcaoProduto() throws SQLException{
        int nova_opcao, id, quantidadeEstoque;
        String nome;
        
        
        Scanner teclado = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoService(); // NÃO ESQUECER #########
        
        Produto p = new Produto(0, "", 0);
        
        
        
            System.out.println("1: Listar Produtos");
            System.out.println("2: Adicionar um Produto");
            System.out.println("3: Editar um Produto");
            System.out.println("4: Deletar um Produto");
            nova_opcao = teclado.nextInt();
            
            
            switch(nova_opcao){
                case 1:
                    System.out.println("Vai LISTAR os produtos");
                    
                    ResultSet rs = produtoService.listar();

                        while(rs.next()){
                            System.out.print("Nº identificador: ");
                            System.out.println(rs.getString("produto_id"));
                            System.out.print("Nome: ");
                            System.out.println(rs.getString("nome"));
                            System.out.print("Quantidade em estoque: ");
                            System.out.println(rs.getString("quantidade_de_estoque"));
                            System.out.println("---------");
                        }
                        
                    
                    
                    break;
                
                case 2:
                    System.out.println("Vai ADICIONAR");
                    System.out.println("Vai inserir");
                        
                    System.out.println("OK! Vamos precisar dos dados do PRODUTO.");
                    System.out.print("Nome do produto: ");
                    teclado.nextLine();    // Limpar o buffer
                    nome = teclado.nextLine();
                    System.out.println(nome);
                    System.out.println("Quantidade em estoque: ");
                    quantidadeEstoque = teclado.nextInt();
                    
                    p = new Produto(nome, quantidadeEstoque);
                    
                    produtoService.inserir(p);
                    break;
                    
                case 3:
                    System.out.println("Vai EDITAR");
                    
                    System.out.println("Qual o ID do PRODUTO que deseja editar? ");
                        id = teclado.nextInt();
                        System.out.println("Nome do produto: ");
                        teclado.nextLine();    // Limpar o buffer
                        nome = teclado.nextLine();
                        
                        System.out.println("Quantidade em estoque: ");
                        quantidadeEstoque = teclado.nextInt();
                        p = new Produto(nome, quantidadeEstoque);
                        p.setProdutoId(id);
                        produtoService.editar(p);
                    break;
                    
                case 4:
                    System.out.println("Vai DELETAR");
                    System.out.println("Qual o ID do PRODUTO que deseja deletar? ");
                    id = teclado.nextInt();
                    p.setProdutoId(id);
                    
                    produtoService.excluir(p);
                    break;
                 
                default:
                    System.out.println("OPÇÃO INVÁLIDA");  // TESTAR. ESQUECI DE INSERIR O DEFAULT
                    
            }
            
            
    }
}
