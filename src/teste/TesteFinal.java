package teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Cliente;
import model.Venda;
import service.ClienteService;

public class TesteFinal {
  
    
    public static void main(String[] args) throws SQLException {
        
        int opcao;
        
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("");
        System.out.println("MENU DE SELEÇÃO");
        System.out.println("Digite uma das opções para iniciar ");
        System.out.println("1: Operações envolvendo cliente");
        System.out.println("2: Operação envolvendo produto");
        System.out.println("3: Operação envolvendo venda ");
        System.out.println("4: Operação envolvendo Pagamento");
        System.out.print("Opção: ");
        opcao = teclado.nextInt();
        System.out.println("\n \n");
       
        
        switch(opcao){
            
            case 1: // PRONTO
                
                TesteCliente tc = new TesteCliente();
                tc.opcaoCliente();
                break;
                
            case 2:
                TesteProduto tp = new TesteProduto();
                tp.opcaoProduto();
                break;
                

            case 3:
                TesteVenda tv = new TesteVenda();
                tv.opcaoVenda();
                break;
            
            case 4:
                System.out.println("Operações de pagamento ");
                break;
            
            default:
                System.out.println("Opção incorreta.");
 
            
                       
        }
    }

}





/*package teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Cliente;
import service.ClienteService;

public class TesteFinal {

    
    public static void main(String[] args) {
        
        
        ClienteService clienteService = new ClienteService();
        
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("MENU DE SELEÇÃO");
        System.out.println("Digite uma das opções para iniciar ");
        System.out.println("1: Operações envolvendo cliente");
        System.out.println("2: Operação envolvendo produto");
        System.out.println("3: Operação envolvendo venda ");
        System.out.println("4: Operação envolvendo Pagamento");
        System.out.print("Opção: ");
        int opcao = teclado.nextInt();
        System.out.println("\n \n");
        
        switch(opcao){
            case 1:
                TesteCliente();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Opção inválida");
        }
        
        
        
        
    }


    private static void TesteCliente() {
        
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("1: Listar clientes");
        System.out.println("2: Editar um cliente");
        System.out.println("3: Excluir um cliente");
        System.out.println("4: Pesquisar um cliente pela venda.");
        int opcao = teclado.nextInt();
        switch(opcao){
            case 1:
                
                ResultSet rs = clienteService.listar();

                while(rs.next()){
                    System.out.print("Nº identificador: ");
                    System.out.println(rs.getString("id"));
                    System.out.print("Nome: ");
                    System.out.println(rs.getString("nome"));
                    System.out.print("Matrícula: ");
                    System.out.println(rs.getString("matricula"));
                    System.out.println("---------");
                
                }
                break;
                
            case 2:
                break;
            case 3:
                break;
                
            case 4:
                break;
                
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        
    }
    
}
*/