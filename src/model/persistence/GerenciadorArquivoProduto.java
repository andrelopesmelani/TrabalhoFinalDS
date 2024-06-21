package model.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entities.Produto;

public abstract class GerenciadorArquivoProduto {

    private static final String ARQUIVO_PRODUTO = "lista-produtos.txt";

    
    public static void criarArquivoSeNaoExistir() {

        File arquivo = new File(ARQUIVO_PRODUTO);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        
        }
    }
    
    public static void lerArquivo(ArrayList<Produto> listaProdutos) throws IOException{

        listaProdutos.clear();

        try (FileReader fileReader = new FileReader(ARQUIVO_PRODUTO);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linhaAtualDoArquivo;
            
            while ((linhaAtualDoArquivo = bufferedReader.readLine()) != null) {
                
                Produto tempProduto = new Produto();

                tempProduto.fromString(linhaAtualDoArquivo);
               
                listaProdutos.add(tempProduto);

            }

        } 

    }

    public static void salvarProdutoNoArquivo(ArrayList<Produto> listaProdutos) throws IOException{

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_PRODUTO);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                for(Produto tempProduto : listaProdutos) {

                    bufferedWriter.write(tempProduto.toString() + "\n");

                }
        }

    }

}
