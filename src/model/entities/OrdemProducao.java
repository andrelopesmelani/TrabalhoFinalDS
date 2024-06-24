package model.entities;

public class OrdemProducao extends Produto {
    private Produto produto;
    private int quantidade;

    public OrdemProducao () {
      
    }
    
    
    public OrdemProducao(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto=" + produto.getNome() + ", Quantidade=" + quantidade;
    }

    public String exibirDados() {
        return  "\nProduto: " + produto.getNome() +
                "\nQuantidade: " + quantidade;
    }

    
    public void fromString(String linha) {
        String[] dadosOrdem = linha.split(", ");
        
        String produtoString = dadosOrdem[0].split("=")[1];
        Produto produto = new Produto();
        produto.setNome(produtoString);
        this.produto = produto;
        
        String quantidadeString = dadosOrdem[1].split("=")[1];
        this.quantidade = Integer.parseInt(quantidadeString);
    }

}