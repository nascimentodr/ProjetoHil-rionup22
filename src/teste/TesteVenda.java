
package teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Venda;
import service.VendaService;

public class TesteVenda {
    public void opcaoVenda() throws SQLException{
        int nova_opcao, idVenda, idCliente;
        String nome;
        
        Scanner teclado = new Scanner(System.in);
        VendaService vendaService = new VendaService(); // NÃO ESQUECER #########
        
        Venda v = new Venda(0, null, null, null, 0);
        
        
        System.out.println("1: Listar VENDAS");
        System.out.println("2: Adicionar uma VENDA");
        System.out.println("3: Editar uma VENDA");
        System.out.println("4: Deletar uma VENDA");
        System.out.println("5: Verificar quantidade de "
                + "vendas em um dia. Data: ano/mes/dia ");
        nova_opcao = teclado.nextInt();
        
        
        switch (nova_opcao){
            case 1:
                System.out.println("VAI LISTAR VENDAS");
                
                ResultSet rs = vendaService.listar();
                
                while(rs.next()){
                    System.out.print("Nº identificador: ");
                    System.out.println(rs.getString("venda_id"));
                    System.out.print("Data da venda: ");
                    System.out.println(rs.getDate("data"));
                    System.out.print("Valor da venda: R$");
                    System.out.println(rs.getDouble("valor_total"));
                    System.out.println("---------");
                    
                    // AINDA FALTA SABER COMO IRÁ EXIBIR OS PRODUTOS
                    // COMO INSERIR A LISTA DE PRODUTOS NA VENDA
                    
                    
                    /*Opções de vendas:
                        listar
                        inserir
                        editar
                        excluir
                        pesquisar vendas pelo id do cliente

                    */
                }
                        
                break;
                
            case 2:
                System.out.println("VAI ADICIONAR VENDA");
                System.out.println("");
                //será preciso perguntar o id do cliente.
                //caso ainda não seja cadastrado deverá ser efetuado
                //antes da venda.
                break;
                
            case 3:
                System.out.println("VAI EDITAR VENDA");
                break;
                
            case 4:
                System.out.println("VAI DELETAR UMA VENDA DO REGISTRO");
                break;
                
            case 5:
                System.out.println("VAI RETORNAR QUANTIDADE VENDAS DO DIA");
                break;
                
            default:
                System.out.println("OPÇÃO INVÁLIDA");
                
                
        }
        
        
        
    }
}
