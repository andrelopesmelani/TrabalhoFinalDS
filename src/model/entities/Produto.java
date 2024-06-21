package model.entities;
public class Produto {
    private static int nextId = 1;
    private int id;
    private String nome;
    private String descricao;
    private float preco;

    public Produto () {
        this.id = nextId++;
    }
    
    // Construtor da classe Produto
    public Produto(String nome, String descricao, float preco) {
        this.id = nextId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", Produto=" + nome + 
        ", Descricao=" + descricao + ", Preco=R$" + preco;
    }

    public String exibirDados() {
        return  "\nID: " + id +
                "\nProduto: " + nome +
                "\nDescricao: " + descricao + 
               "\nPreço: " + preco;
    }

    public void fromString(String linha) {

        String[] dadosProduto = linha.split(", ");

        nome = dadosProduto[0].split("=")[1];
        descricao = dadosProduto[1].split("=")[1];

    }
}