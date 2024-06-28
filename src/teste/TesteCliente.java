
package teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Cliente;
import model.Venda;
import service.ClienteService;

public class TesteCliente {
    
    
    public void opcaoCliente() throws SQLException{
            
        int novaOpcao, id, idVenda;
        String nome, email, endereco, cpf, telefone;
    
        
        
        Scanner teclado = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();  //  *** NÃO ESQUECER
                                                               //DE INSTANCIAR NAS OUTRAS

        Cliente c = new Cliente("", "", "", "", ""); // se for deletar não precisará instânciar
        
        
            System.out.println("1: Listar clientes");
            System.out.println("2: Adicionar um cliente");
            System.out.println("3: Editar um cliente");
            System.out.println("4: Deletar um cliente");
            System.out.println("5: Recuperar cliente através da venda");
            System.out.print("Opção: ");
            novaOpcao = teclado.nextInt();
            
            // Opções relacionadas a clientes
                switch(novaOpcao){
                    case 1:
                        System.out.println("Vai listar");

                        ResultSet rs = clienteService.listar();

                        while(rs.next()){
                            System.out.print("Nº identificador: ");
                            System.out.println(rs.getString("cliente_id"));
                            System.out.print("Nome: ");
                            System.out.println(rs.getString("nome"));
                            System.out.print("Email: ");
                            System.out.println(rs.getString("email"));
                            System.out.print("Endereco: ");
                            System.out.println(rs.getString("endereco"));
                            System.out.print("CPF: ");
                            System.out.println(rs.getString("cpf"));
                            System.out.print("Telefone: ");
                            System.out.println(rs.getString("telefone"));

                            System.out.println("---------");
                        }
                        
                        break;
                     
                    case 2:   // LEMBRAR DE TROCAR POR nextLine
                        System.out.println("Vai inserir");
                        
                        System.out.println("OK! Vamos precisar dos dados do cliente.");
                        System.out.println("Nome do cliente: ");
                        nome = teclado.next();
                        System.out.println("Email: ");
                        email = teclado.next();
                        System.out.println("Endereco completo: ");
                        endereco = teclado.next();
                        System.out.println("CPF: ");
                        cpf = teclado.next();   // pula direto para telefone.
                                                //erro ao dar espaços.
                        System.out.print("Telefone: ");
                        telefone = teclado.next();
                        
                        c = new Cliente(nome, email, 
                                endereco, cpf, telefone);
                        
                        clienteService.inserir(c);
                        break;
                        
                        
                        
                        
                    case 3: // concluído
                        System.out.println("Vai editar");
                        System.out.println("Qual o id do cliente que deseja editar? ");
                        id = teclado.nextInt();
                        System.out.println("Nome do cliente: ");
                        nome = teclado.next();
                        System.out.println("Email: ");
                        email = teclado.next();
                        System.out.println("Endereco completo: ");
                        endereco = teclado.next();
                        System.out.println("CPF: ");
                        cpf = teclado.next();
                        System.out.print("Telefone: ");
                        telefone = teclado.next();
                        
                        c = new Cliente(nome, email, endereco, cpf, telefone);
                        c.setClienteId(id);
              
                        clienteService.editar(c);
                        
                        break;
                        
                        
                    case 4:
                        System.out.println("Vai deletar cliente");
                        
                        System.out.println("Qual o id do cliente que deseja deletar? ");
                        id = teclado.nextInt();
                        c.setClienteId(id);
                        clienteService.excluir(c);
                        break;
                        
                        
                    
                    case 5:
                        System.out.println("Vai encontrar cliente através da venda");
                        System.out.println("Código id da venda: ");
                        idVenda = teclado.nextInt();
                        Venda v = new Venda(idVenda, null, null, null, 0);
                        
                        
                        
                        rs = clienteService.retornarClienteVenda(idVenda);
                        
                        while(rs.next()){
                            System.out.print("Nº identificador: ");
                            System.out.println(rs.getString("cliente_id"));
                            System.out.print("Nome: ");
                            System.out.println(rs.getString("nome"));
                            System.out.print("Email: ");
                            System.out.println(rs.getString("email"));
                            System.out.print("Endereco: ");
                            System.out.println(rs.getString("endereco"));
                            System.out.print("CPF: ");
                            System.out.println(rs.getString("cpf"));
                            System.out.print("Telefone: ");
                            System.out.println(rs.getString("telefone"));

                            System.out.println("---------");

                        }
                        
                        
                        break;
                    default:
                        System.out.println("Opcao inválida");
                }
                
        
        
        
    }
    
}
