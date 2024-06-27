package teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Cliente;
import model.Venda;
import service.ClienteService;

public class TesteFinal {
  
    
    public static void main(String[] args) throws SQLException {
        
        int opcao, novaOpcao, id, idVenda;
        String nome, email, endereco, cpf, telefone;
        
    ClienteService clienteService = new ClienteService();
    
    Cliente c = new Cliente("teste", "teste", "teste", "teste", "teste");
    
    id = 0;
    
        
        /* Create        
        Aluno a1 = new Aluno();
        a1.setNome("Marcos");
        a1.setMatricula("123");
        
        //alunoService.inserir(a1);
        */
        
        
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
            
            case 1:
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
                        
                        
                        
                    case 2:   // concluído
                        System.out.println("Vai inserir");
                        
                        System.out.println("OK! Vamos precisar dos dados do cliente.");
                        System.out.println("Nome do cliente: ");
                        nome = teclado.next();
                        System.out.println("Email: ");
                        email = teclado.next();
                        System.out.println("Endereco completo: ");
                        endereco = teclado.next();
                        System.out.println("CPF: ");
                        cpf = teclado.next();   // pula direto para telefone
                        
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
                break;
                
                
                
                
                
                // ACABAM AQUI OS AS OPÇÕES RELACIONADAS AOS CLIENTES

 
            
             
            case 2:
                System.out.print("Operações do produto");
                break;
                

            case 3:
                System.out.print("Operações de venda");
                break;
            
            case 4:
                System.out.print("Operações de pagamento ");
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