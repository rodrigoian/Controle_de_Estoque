package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import service.ProdutoServices;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();

        do {
            System.out.println("--CONTROLE DE ESTOQUE--");
            System.out.println("1 - ADICIONAR UM PRODUTO.");
            System.out.println("2 - LISTAR PRODUTOS.");
            System.out.println("3 - REMOVER UM PRODUTO.");
            System.out.println("4 - BUSCAR PRODUTO POR ID.");
            System.out.println("5 - ALTERAR A QUANTIDADE DO PRODUTO.");
            System.out.println("6 - SAIR");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> ProdutoServices.adicionarProduto(produtos, sc);
                case 2 -> ProdutoServices.listarProdutos(produtos);
                case 3 -> ProdutoServices.removerProduto(produtos,sc);
                case 4 -> ProdutoServices.buscarProduto(produtos,sc);
                case 5 -> ProdutoServices.alterarQuantidade(produtos,sc);
                case 6 -> {
                    System.out.println("--PROGRAMA ENCERRANDO...");
                    System.exit(0);
                }
                default -> System.out.println("--OPÇÃO INVÁLIDA--");

            }
        } while (true);
    }
}