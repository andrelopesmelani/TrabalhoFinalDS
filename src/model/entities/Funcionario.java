package model.entities;

public abstract class Funcionario {

    private String nome;
    protected float valorHora;
    protected float horasTrab;

    public Funcionario() {
    }

    public Funcionario(String nome, float valorHora, float horasTrab) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrab = horasTrab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(float horasTrab) {
        this.horasTrab = horasTrab;
    }

    @Override
    public String toString() {
        return "Nome=" + nome +
               ", Valor da hora=" + valorHora +
               ", Horas trabalhadas=" + horasTrab;
    }

    public String exibirDados() {
        return "\nNome: " + nome +
               "\nValor da hora: R$ " + valorHora +
               "\nHoras trabalhadas: " + horasTrab + "h";
    }

    public void fromString(String linha) {
        String[] dadosFuncionario = linha.split(", ");

        this.nome = dadosFuncionario[0].split("=")[1];
        this.valorHora = Float.parseFloat(dadosFuncionario[1].split("=")[1]);
        this.horasTrab = Float.parseFloat(dadosFuncionario[2].split("=")[1]);
    }
}
