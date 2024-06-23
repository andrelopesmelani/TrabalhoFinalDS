package controller;

import java.util.ArrayList;

import model.entities.Estoque;

public class ProdutosEstoque {
    
    private static ArrayList<ProdutosEstoque> estoques = new ArrayList<>();

    public static void salvarEstoque(Estoque estoque) {
        estoques.add(estoque);
    }

    public static ArrayList<ProdutosEstoque> getProdutosEstoque() {
        return estoques;
    }

    public static void verificarEstoqueVazil() throws Exception {

        if (estoques.isEmpty()) {
            throw new Exception("\nNão há Produtos no estoque cadastrados");
        }

    }

    public static Estoque buscarProdutoEstoque(String produto) throws Exception {

        for(Estoque tempEstoque : estoques) {

            if (tempEstoque.getProduto().contains(produto)) {
                return tempEstoque;
            }
        }

        throw new Exception(produto + " não encontrado no estoque");
    }

    public static void apagarProdutoEstoque(Estoque estoque) {
        estoques.remove(estoque);
    }




}
