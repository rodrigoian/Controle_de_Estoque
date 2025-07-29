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
        if (numero <= 0) {
            System.out.println("--DIGITE UM VALOR VÁLIDO");
            return;
        }
        this.quantidade += numero;
        System.out.println("--ESTOQUE AUMENTANDO COM SUCESSO--");
    }

    public void diminuirEstoque(int numero) {
        if (numero <= 0) {
            System.out.println("--DIGITE UM VALOR VÁLIDO--");
            return;
        }
        if (quantidade >= numero ) {
            this.quantidade -= numero;
            System.out.println("--ESTOQUE RETIRADO COM SUCESSO--");
        }
        else {
            System.out.println("--QUANTIDADE INSUFICIENTE NO ESTOQUE--");
        }
    }

    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");//fez a formatação dentro do toString mesmo
        String dataFormatada = dataHora.format(formato);//converteu pra String para que eu consiga colocar no "String.format"
        return String.format("Data %s | NOME: %s | ID: %d | QUANTIDADE: %d ",dataFormatada, getNome(), getId(), getQuantidade());
    }
}
