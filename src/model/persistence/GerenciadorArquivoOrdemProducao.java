package model.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.entities.OrdemProducao;
import model.entities.Produto;

public abstract class GerenciadorArquivoOrdemProducao {

    private static final String ARQUIVO_ORDEM_PRODUCAO = "lista-ordem-producao.txt";

    public static void criarArquivoSeNaoExistir() {
        File arquivo = new File(ARQUIVO_ORDEM_PRODUCAO);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void lerArquivo(ArrayList<OrdemProducao> listaOrdemProducao) throws IOException{
        listaOrdemProducao.clear();
        try (FileReader fileReader = new FileReader(ARQUIVO_ORDEM_PRODUCAO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linhaAtualDoArquivo;
            while ((linhaAtualDoArquivo = bufferedReader.readLine()) != null) {
                OrdemProducao tempOrdemProducao = new OrdemProducao();
                tempOrdemProducao.fromString(linhaAtualDoArquivo);
                listaOrdemProducao.add(tempOrdemProducao);
            }
        } 
    }

    public static void salvarOrdemProducaoNoArquivo(ArrayList<OrdemProducao> listaOrdemProducao) throws IOException{
        try (FileWriter fileWriter = new FileWriter(ARQUIVO_ORDEM_PRODUCAO);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for(OrdemProducao tempOrdemProducao : listaOrdemProducao) {
                bufferedWriter.write(tempOrdemProducao.toString() + "\n");
            }
        }
    }
    public static Map<Produto, Integer> filtrarListaOrdemProducao(List<OrdemProducao> listaOrdemProducao) {
        Map<Produto, Integer> mapaEstoque = new HashMap<>();

        for (OrdemProducao ordemProducao : listaOrdemProducao) {
            Produto produto = ordemProducao.getProduto();
            int quantidade = ordemProducao.getQuantidade();

            if (mapaEstoque.containsKey(produto)) {
                quantidade += mapaEstoque.get(produto);
            }
            mapaEstoque.put(produto, quantidade);
        }

        return mapaEstoque;
    }

}
