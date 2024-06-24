package controller;

public interface CalcularSalario {

    public static float salario(float valorHora, float horasTrab){
        return valorHora * horasTrab;
    }
    public static float salario(float valorHora, float horasTrab, float bonus){
        return (valorHora * horasTrab) + bonus;
    }

}

