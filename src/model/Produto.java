package Produto;

public class Produto {
    private String nome;
    private Integer id;
    private Integer quantidade;

    public Produto(String nome, Integer id, Integer quantidade) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void aumentarEstoque(int numero) {
        this.quantidade = quantidade + numero;
    }

    public void diminuirEstoque(int numero) {
        this.quantidade = quantidade - numero;
    }

    public String toString() {
        return String.format("NOME: %s | ID: %d | QUANTIDADE: %d", getNome(), getId(), getQuantidade());
    }
}
