package controller;

import java.util.ArrayList;

import model.entities.OrdemProducao;

public abstract class ListaOrdemProducao {

    private static ArrayList<OrdemProducao> listaOrdemProducao = new ArrayList<>();

    public static void salvarOrdemProducao(OrdemProducao ordemProducao) {
        listaOrdemProducao.add(ordemProducao);
    }

    public static ArrayList<OrdemProducao> getListaOrdemProducao() {
        return listaOrdemProducao;
    }

    public static void verificarOrdemProduçãoVazia() throws Exception {

        if (listaOrdemProducao.isEmpty()) {
            throw new Exception("\nNão há Produtos na ordem de produção");
        }

    }

    public static void apagarOrdemProducao(OrdemProducao ordemProducao) {
        listaOrdemProducao.remove(ordemProducao);
    }


}
