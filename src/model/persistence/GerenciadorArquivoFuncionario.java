package model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entities.Funcionario;
import model.entities.Gerente;
import model.entities.Operador;

public abstract class GerenciadorArquivoFuncionario {

    private static final String ARQUIVO_FUNCIONARIO = "lista-funcionarios.txt";

    public static void criarArquivoSeNaoExistir() {
        File arquivo = new File(ARQUIVO_FUNCIONARIO);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void lerArquivo(ArrayList<Funcionario> listaFuncionarios) throws IOException {
        listaFuncionarios.clear();

        try (FileReader fileReader = new FileReader(ARQUIVO_FUNCIONARIO);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linhaAtualDoArquivo;

            while ((linhaAtualDoArquivo = bufferedReader.readLine()) != null) {
                if (linhaAtualDoArquivo.contains("Gerente")) {
                    Gerente gerente = new Gerente();
                    gerente.fromString(linhaAtualDoArquivo);
                    listaFuncionarios.add(gerente);
                } else if (linhaAtualDoArquivo.contains("Operador")) {
                    Operador operador = new Operador();
                    operador.fromString(linhaAtualDoArquivo);
                    listaFuncionarios.add(operador);
                }
            }

        }
    }

    public static void salvarFuncionarioNoArquivo(ArrayList<Funcionario> listaFuncionarios) throws IOException {
        try (FileWriter fileWriter = new FileWriter(ARQUIVO_FUNCIONARIO);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Funcionario tempFuncionario : listaFuncionarios) {
                if (tempFuncionario instanceof Gerente) {
                    bufferedWriter.write(((Gerente) tempFuncionario).toFullString() + "\n");
                } else if (tempFuncionario instanceof Operador) {
                    bufferedWriter.write(((Operador) tempFuncionario).toFullString() + "\n");
                }
              
            }
        }
    }
}
