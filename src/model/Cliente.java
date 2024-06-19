package model;

public class Cliente {
    private int clienteId;
    private String nome;
    private String email;
    private String endereco;
    private String CPF;  // tive que alterar de int para String pois o valor no banco está salvo como String
    private String telefone; // idem

    public Cliente(int clienteId, String nome, String email, String endereco, String CPF, String telefone) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public Cliente(String nome, String email, String endereco, String CPF, String telefone) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.CPF = CPF;
        this.telefone = telefone;
    }
    
    

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}








/*
package model;

public class Cliente {
    private int clienteId;
    private String nome;
    private String email;
    private String endereco;
    private int CPF;
    private int telefone;

    public Cliente(int clienteId, String nome, String email, String endereco, int CPF, int telefone) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
}

*/