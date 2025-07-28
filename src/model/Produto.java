package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Produto {
    private String nome;
    private Integer id;
    private Integer quantidade;
    private LocalDateTime dataHora;

    public Produto(String nome, Integer id, Integer quantidade) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.dataHora = LocalDateTime.now();
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
        if (quantidade > 0) {
            this.quantidade = quantidade - numero;
        }
        else {
            System.out.println("--OPERAÇÃO NÃO REALIZADA POIS NÃO A HÁ PRODUTOS RESTANTES--");
        }
    }

    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");//fez a formatação dentro do toString mesmo
        String dataFormatada = dataHora.format(formato);//converteu pra String para que eu consiga colocar no "String.format"
        return String.format("Data %s | NOME: %s | ID: %d | QUANTIDADE: %d%n ",dataFormatada, getNome(), getId(), getQuantidade());
    }
}
