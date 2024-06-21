package model.entities;

public class Funcionario {
    private static int nextId = 1;
    private int id;
    private String nome;
    private String cargo;


    public Funcionario () {
        this.id = nextId++;
    }
    
    // Construtor da classe Produto
    public Funcionario(String nome, String cargo) {
        this.id = nextId++;
        this.nome = nome;
        this.cargo = cargo;
    
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", Nome=" + nome + 
        ", Cargo=" + cargo ;
    }

    public String exibirDados() {
        return  "\nID: " + id +
                "\nProduto: " + nome +
                "\nCargo: " + cargo;
    }

    public void fromString(String linha) {

        String[] dadosProduto = linha.split(", ");

        nome = dadosProduto[0].split("=")[1];
        cargo = dadosProduto[1].split("=")[1];

    }
}