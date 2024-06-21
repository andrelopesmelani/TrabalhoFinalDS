package controller;
import java.util.ArrayList;
import model.entities.Produto;

public abstract class ListaProdutos {

    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public static void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public static void verificarListaVazia() throws Exception {

        if (listaProdutos.isEmpty()) {
            throw new Exception("\nNão há livros cadastrados");
        }

    }

    public static Produto buscarProduto(String nome) throws Exception {

        for(Produto tempProduto : listaProdutos) {

            if (tempProduto.getNome().contains(nome)) {
                return tempProduto;
            }
        }

        throw new Exception("Produto " + nome + " não encontrado");
    }

    public static void apagarProduto(Produto produto) {
        listaProdutos.remove(produto);
    }


}
