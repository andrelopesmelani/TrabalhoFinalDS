// Classe Fornecedor representa os fornecedores de matéria-prima
public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    
    // Construtor da classe Fornecedor
    public Fornecedor(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }
qidjpxms,po2k
xpom
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
