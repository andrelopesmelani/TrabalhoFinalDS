package model.persistence;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entities.Funcionario;

public abstract class GerenciadorArquivoFuncionario {

    private static final String ARQUIVO_PRODUTO = "lista-funcionarios.txt";

    
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
    
    public static void lerArquivo(ArrayList<Funcionario> listaFuncionarios) throws IOException{

        listaFuncionarios.clear();

        try (FileReader fileReader = new FileReader(ARQUIVO_PRODUTO);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linhaAtualDoArquivo;
            
            while ((linhaAtualDoArquivo = bufferedReader.readLine()) != null) {
                
                Funcionario tempFuncionario = new Funcionario();

                tempFuncionario.fromString(linhaAtualDoArquivo);
               
                listaFuncionarios.add(tempFuncionario);

            }

        } 

    }

    public static void salvarFuncionarioNoArquivo(ArrayList<Funcionario> listaFuncionarios) throws IOException{

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_PRODUTO);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                for(Funcionario tempFuncionario : listaFuncionarios) {

                    bufferedWriter.write(tempFuncionario.toString() + "\n");

                }
        }

    }

}
