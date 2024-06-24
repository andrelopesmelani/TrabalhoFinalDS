package model.entities;

public class Produto {
    private String nome;
    private String descricao;
    private float preco;

    public Produto () {
    }
    
    public Produto(String nome, String descricao, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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
        return "Produto=" + nome + 
        ", Descricao=" + descricao + ", Preco=" + preco;
    }

    public String exibirDados() {
        return  "\nProduto: " + nome +
                "\nDescricao: " + descricao + 
               "\nPreço: " + preco;
    }

    public void fromString(String linha) {
        String[] dadosProduto = linha.split(", ");
    
    
        this.nome = dadosProduto[0].split("=")[1];
    
        this.descricao = dadosProduto[1].split("=")[1];
    

        String precoString = dadosProduto[2].split("=")[1];
        this.preco = Float.parseFloat(precoString);
    }
    


}