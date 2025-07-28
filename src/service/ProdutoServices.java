package service;
import model.Produto;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ProdutoServices {

    public static void adicionarProduto(List<Produto> produtos, Scanner sc) {
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

                boolean checkId = false;
                for (Produto p : produtos) {
                    if (p.getId() == id) {
                        checkId = true;
                        break;
                    }
                }
                if (checkId) {
                    System.out.println("--ID JÁ EXISTENTE, DIGITE OUTRO--");
                }
                else {
                    break;
                }
            }
            System.out.println("--QUANTIDADE: ");
            int quantidade = sc.nextInt();
            sc.nextLine();
            Produto prod = new Produto(nome, id, quantidade);
            produtos.add(prod);
        }
    }

    public static void listarProdutos (List<Produto> produtos) {
        System.out.println("--PRODUTOS CADASTRADOS--");
        System.out.println(produtos);
    }
    public static void removerProduto (List<Produto> produtos, Scanner sc) {
        System.out.println(produtos);

        System.out.println("--ESCOLHA UM ITEM POR ID PARA REMOVER: ");
        int idRemove = sc.nextInt();


        boolean idRemoveEncontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == idRemove){
                idRemoveEncontrado = true;

                System.out.println("--DESEJA MESMO REMOVER ESSE ITEM (S/N)? " + produtos);
                char escolha = sc.next().toLowerCase().charAt(0);

                if (escolha == 's') {
                produtos.remove(idRemove);
                System.out.println("--REMOVENDO PRODUTO--");
                }
                else {
                    System.out.println("--OPERAÇÃO CANCELADA");
                }
                break;
            }
        }
        if (!idRemoveEncontrado) {
            System.out.println("--PRODUTO NÃO ENCONTRADO--");
        }
        System.out.println("--ESTOQUE ATUALIZADO--");
        System.out.println(produtos);
    }

    public static void buscarProduto(List<Produto> produtos, Scanner sc) {
        Produto produtoEncontrado = null;
        System.out.println("--ESCREVA O ID DO PRODUTO QUE VOCÊ QUER BUSCAR: ");
        int idBuscar = sc.nextInt();

        for (Produto p : produtos)
            if (p.getId() == idBuscar) {
                produtoEncontrado = p;
                break;
            }

        if (produtoEncontrado != null) {
            System.out.println("--SEU PRODUTO FOI ACHADO COM SUCESSO: " + produtoEncontrado);
        } else {
            System.out.println("--PRODUTO NÃO ENCONTRADO...");
        }


    }
    public static void alterarQuantidade(List<Produto> produtos, Scanner sc) {
        Produto produtoAlterar = null;
        System.out.println("--INFORME O ID DO PRODUTO QUE VOCÊ QUER ALTERAR A QUANTIDADE: ");
        int idAlterar = sc.nextInt();
        sc.nextLine();

        for (Produto p : produtos)
            if (p.getId() == idAlterar) {
                produtoAlterar = p;
            }
        if (produtoAlterar != null) {
            System.out.println("--INFORME A OPERAÇÃO QUE VOCÊ DESEJA (+/-): ");
            char operacaoEstoque = sc.nextLine().charAt(0);

            if (operacaoEstoque == '+') {
                System.out.println("--INFORME QUANTOS ITENS VOCÊ QUER ADICIONAR: ");
                int adicionarEstoque = sc.nextInt();
                produtoAlterar.aumentarEstoque(adicionarEstoque);
                System.out.println("--LISTA ATUALIZADA--");

            } else if (operacaoEstoque == '-') {
                System.out.println("--INFORME QUANTOS ITENS VOCÊ QUER TIRAR: ");
                int diminuirEstoque = sc.nextInt();
                produtoAlterar.diminuirEstoque(diminuirEstoque);
                System.out.println("--LISTA ATUALIZADA--");
            } else {
                System.out.println("--ESSA OPERAÇÃO NÃO EXISTE--");
            }
        }
        else {
            System.out.println("--PRODUTO NÃO ENCONTRADO");
        }
    }
}
