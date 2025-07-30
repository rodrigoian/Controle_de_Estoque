package service;
import model.Produto;
import java.util.List;
import java.util.Scanner;

public class ProdutoServices {

    public static boolean checkIdAdicionarProduto(List<Produto> produtos, int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Produto checkIdRemoverProduto(List<Produto> produtos, int idRemove) {
        for (Produto p : produtos) {
            if (p.getId() == idRemove) {
                produtos.remove(p);
                return p;
            }
        }
        return null;
    }

    public static Produto checkIdbuscarProduto(List<Produto> produtos, int idBuscar) {
        for (Produto p : produtos) {
            if (p.getId() == idBuscar) {
                return p;
            }
        }
        return null;
    }

    public static Produto checkIdAlterarQuantidade(List<Produto> produtos, int idAlterar) {
        for (Produto p : produtos) {
            if (p.getId() == idAlterar) {
                return p;
            }
        }
        return null;
    }
}
