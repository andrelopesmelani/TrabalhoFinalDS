package controller;
import java.util.ArrayList;
import model.entities.Funcionario;

public abstract class ListaFuncionarios {

    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    public static void salvarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public static ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void verificarListaVazia() throws Exception {

        if (listaFuncionarios.isEmpty()) {
            throw new Exception("\nNão há funcionários cadastrados");
        }

    }

    public static Funcionario buscarFuncionario(String nome) throws Exception {

        for(Funcionario tempFuncionario : listaFuncionarios) {

            if (tempFuncionario.getNome().contains(nome)) {
                return tempFuncionario;
            }
        }

        throw new Exception("Funcionario " + nome + " não encontrado");
    }

    public static void apagarFuncionario(Funcionario funcionario) {
        listaFuncionarios.remove(funcionario);
    }


}
