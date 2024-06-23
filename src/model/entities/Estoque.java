package model.entities;

public class Estoque {
    private String produto;
    private int id;
    private int quantidade;
    
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Estoque(String produto, int id, int quantidade) {
        this.produto = produto;
        this.id = id;
        this.quantidade = quantidade;
    }
    public Estoque() {

    }

    public String toString(){
        return "ID: " + id + ", Produto: " + produto + ", Quantidade: " + quantidade; 
    }

    public String exibirDados() {
        return  "\nID: " + id +
                "\nProduto: " + produto +
                "\nQuantidade: " + quantidade; 
  
    }
}
