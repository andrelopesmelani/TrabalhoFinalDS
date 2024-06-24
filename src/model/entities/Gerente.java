package model.entities;

import controller.CalcularSalario;
import controller.Trabalhavel;

public class Gerente extends Funcionario implements Trabalhavel {

    private String setor;
    private float bonus;

    public Gerente(String nome, float valorHora, float horasTrab, String setor, float bonus) {
        super(nome, valorHora, horasTrab);
        this.setor = setor;
        this.bonus = bonus;
    }

    public Gerente() {
       
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }


    public String trabalhar() {
        return "Olá, sou o gerente!";
    }

    public String relatarProgresso() {
        return "A equipe está trabalhando muito bem, vamos conseguir entregar dentro do prazo!";
    }

    
    public String toFullString() {
        return super.toString();
    }
    @Override
    public String toString() {
        return super.exibirDados() +
               "\nSetor: " + setor +
               "\nBonus anual: R$ " + bonus +
               "\nSalário: " + CalcularSalario.salario(valorHora, horasTrab, bonus) +
               "\nTrabalho: " + trabalhar() +
               "\nRelato de Progresso: " + relatarProgresso();
    }


}
