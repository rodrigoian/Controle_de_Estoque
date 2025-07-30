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
                case 3 -> removerProduto();
                case 4 -> buscarProduto();
                case 5 -> alterarProdutos();
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

                boolean checkId = ProdutoServices.checkIdAdicionarProduto(produtos, id);

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
    public void removerProduto() {
        System.out.println("--ESCOLHA UM ITEM POR ID PARA REMOVER: ");
        int idRemove = sc.nextInt();

        Produto removido = ProdutoServices.checkIdRemoverProduto(produtos, idRemove);

        if (removido != null) {
            System.out.println("Produto " + removido.getNome() +
                    " foi removido com Sucesso.");
        }
        else {
            System.out.println("Produto não encontrado.");
            System.out.println();
        }
    }
    public void buscarProduto() {
        System.out.println("--ESCREVA O ID DO PRODUTO QUE VOCÊ QUER BUSCAR: ");
        int idBuscar = sc.nextInt();

        Produto produtoEncontrado = ProdutoServices.checkIdbuscarProduto(produtos, idBuscar);

        if (produtoEncontrado != null) {
            System.out.println("--SEU PRODUTO FOI ACHADO COM SUCESSO:\n " + produtoEncontrado);
        } else {
            System.out.println("--PRODUTO NÃO ENCONTRADO...");
            System.out.println();
        }
    }
    public void alterarProdutos() {
        System.out.println("--INFORME O ID DO PRODUTO QUE VOCÊ QUER ALTERAR A QUANTIDADE: ");
        int idAlterar = sc.nextInt();
        sc.nextLine();

        Produto produtoAlterar = ProdutoServices.checkIdAlterarQuantidade(produtos,idAlterar);

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

