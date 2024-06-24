package model.entities;

import controller.CalcularSalario;
import controller.Trabalhavel;

public class Operador extends Funcionario implements Trabalhavel {

    private String funcao;

    public Operador(String nome, float valorHora, float horasTrab, String funcao) {
        super(nome, valorHora, horasTrab);
        this.funcao = funcao;
    }

    public Operador() {

    }

    public String getFuncao() {
        return funcao;
    }

    public void setfuncao(String funcao) {
        this.funcao = funcao;
    }

    
    public String trabalhar() {
        return "Olá, sou o operador!";
    }

    
    public String relatarProgresso() {
        return "Consegui produzir mais esse mês!";
    }

    public String toFullString() {
        return super.toString();
    }

    @Override
    public String toString() {
        return super.exibirDados() +
                "\nFunção: " + funcao +
                "\nSalário: " + CalcularSalario.salario(valorHora, horasTrab) +
                "\nTrabalho: " + trabalhar() +
                "\nRelato de Progresso: " + relatarProgresso();
    }

}
