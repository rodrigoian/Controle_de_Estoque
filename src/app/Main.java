
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Produto.Produto;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> Produtos = new ArrayList<>();

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
                case 1:
                    System.out.println("--QUANTOS PRODUTOS VOCÊ QUER ADICIONAR? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("--NOME: ");
                        String nome = sc.nextLine().toUpperCase();

                        System.out.println("--ID: ");
                        int id = sc.nextInt();

                        System.out.println("--QUANTIDADE: ");
                        int quantidade = sc.nextInt();
                        sc.nextLine();
                        Produto prod = new Produto(nome, id, quantidade);
                        Produtos.add(prod);
                    }
                    break;
                case 2:
                    System.out.println("--PRODUTOS CADASTRADOS--");
                    System.out.println(Produtos);
                    break;

                case 3:
                    System.out.println(Produtos);
                    System.out.println("--ESCOLHA UM ITEM POR ID PARA REMOVER: ");
                    int idParaRemover = sc.nextInt();
                    Produtos.removeIf(p -> p.getId() == idParaRemover);
                    System.out.println("--ESTOQUE ATUALIZADO--");
                    System.out.println(Produtos);
                    break;


                case 4:
                    Produto produtoEncontrado = null;
                    System.out.println("--ESCREVA O ID DO PRODUTO QUE VOCÊ QUER BUSCAR: ");
                    int idBuscar = sc.nextInt();

                    for (Produto p : Produtos)
                        if (p.getId() == idBuscar) {
                            produtoEncontrado = p;
                        }

                    if (produtoEncontrado != null) {
                        System.out.println("--SEU PRODUTO FOI ACHADO COM SUCESSO-- " + produtoEncontrado);
                    } else {
                        System.out.println("--PRODUTO NÃO ENCONTRADO...");
                    }
                    break;

                case 5:
                    Produto produtoAlterar = null;
                    System.out.println("--INFORME O ID DO PRODUTO QUE VOCÊ QUER ALTERAR A QUANTIDADE: ");
                    int idAlterar = sc.nextInt();
                    sc.nextLine();

                    for (Produto p : Produtos)
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
                        }
                        else {
                            System.out.println("--ESSA OPERAÇÃO NÃO EXISTE--");
                        }
                    }
                    else {
                        System.out.println("--ITEM NÃO ENCONTRADO--");
                    }
                    break;

                case 6:
                    System.out.println("--PROGRAMA ENCERRANDO...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("--OPÇÃO INVÁLIDA--");
            }
        } while (true);
    }
}