package service;
import model.Produto;
import java.util.List;
import java.util.Scanner;

public class ProdutoServices {

    public static boolean checkId(List<Produto> produtos, int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void removerProduto (List<Produto> produtos, Scanner sc) {
        System.out.println(produtos);

        System.out.println("--ESCOLHA UM ITEM POR ID PARA REMOVER: ");
        int idRemove = sc.nextInt();

        boolean idRemoveEncontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == idRemove){
                idRemoveEncontrado = true;

                System.out.println("--DESEJA MESMO REMOVER ESSE ITEM (S/N)? ");
                char escolha = sc.next().toLowerCase().charAt(0);

                if (escolha == 's') {
                produtos.remove(i);
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
