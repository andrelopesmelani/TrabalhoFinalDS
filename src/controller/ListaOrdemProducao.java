package controller;

import java.util.ArrayList;

import model.entities.OrdemProducao;

public abstract class ListaOrdemProducao {

    private static ArrayList<OrdemProducao> listaOrdemProducao = new ArrayList<>();

    public static void salvarOrdemProdução(OrdemProducao ordemProducao) {
        listaOrdemProducao.add(ordemProducao);
    }

    public static ArrayList<OrdemProducao> getListaFuncionarios() {
        return listaOrdemProducao;
    }

    public static void verificarOrdemProduçãoVazia() throws Exception {

        if (listaOrdemProducao.isEmpty()) {
            throw new Exception("\nNão há Produtos na ordem de produção");
        }

    }

    public static OrdemProducao buscarProtutosOrdemProducao(String produto) throws Exception {

        for(OrdemProducao
         tempOrdemProdução : listaOrdemProducao) {

            if (tempOrdemProdução.getProduto().contains(produto)) {
                return tempOrdemProdução;
            }
        }

        throw new Exception("O Produto" + produto + " não encontrado na Ordem de Produção");
    }

    public static void apagarOrdemProdução(OrdemProducao ordemProducao) {
        listaOrdemProducao.remove(ordemProducao);
    }


}
