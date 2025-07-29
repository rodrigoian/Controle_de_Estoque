package UI;

import model.Produto;
import service.ProdutoServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class produtoMenu {
    Scanner sc = new Scanner(System.in);
    List<Produto> produtos = new ArrayList<>();

    public void menuPrincipal() {

        do {
            System.out.println("--CONTROLE DE ESTOQUE--;\n" +
                    "1 - ADICIONAR UM PRODUTO.;\n" +
                    "2 - LISTAR PRODUTOS.;\n" +
                    "3 - REMOVER UM PRODUTO.;\n" +
                    "4 - BUSCAR PRODUTO POR ID.;\n" +
                    "5 - ALTERAR A QUANTIDADE DO PRODUTO.;\n" +
                    "6 - SAIR");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> adicionarProdutoUi();
                case 2 -> listarProdutos();
                case 3 -> ProdutoServices.removerProduto(produtos, sc);
                case 4 -> ProdutoServices.buscarProduto(produtos, sc);
                case 5 -> ProdutoServices.alterarQuantidade(produtos, sc);
                case 6 -> {
                    System.out.println("--PROGRAMA ENCERRANDO...");
                    System.exit(0);
                }
                default -> System.out.println("--OPÇÃO INVÁLIDA--");

            }
        } while (true);
    }

    public void adicionarProdutoUi() {
        System.out.println("--QUANTOS PRODUTOS VOCÊ QUER ADICIONAR? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("--NOME: ");
            String nome = sc.nextLine().toUpperCase();

            int id;
            while (true) {
                System.out.println("--ID: ");
                id = sc.nextInt();
                sc.nextLine();

                boolean checkId = ProdutoServices.checkId(produtos, id);

                if (checkId) {
                    System.out.println("já existe, digite outro");
                } else {
                    break;
                }
            }
                System.out.println("--QUANTIDADE: ");
                int quantidade = sc.nextInt();
                sc.nextLine();


                Produto prod = new Produto(nome, id, quantidade);
                produtos.add(prod);
                System.out.println("--produto " + prod.getNome() + " adicionado--");
            }

    }

    public void listarProdutos() {
        System.out.println("--PRODUTOS CADASTRADOS--");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}

