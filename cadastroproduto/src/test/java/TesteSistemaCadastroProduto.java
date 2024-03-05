import org.example.Produto;
import org.example.SistemaCadastroProduto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaCadastroProduto {

    @Test
    public void testeCadastrarProdutoValido(){
        Produto produto = new Produto("Sofá",
                "Sofá confortável para sala de estar",
                "Móveis para casa", 800.00,
                5);

        List<Produto> produtos = new ArrayList<>();
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        sistema.cadastrarProduto(new Scanner(System.in));

        Assert.assertEquals(1, sistema.getProdutos().size());
    }

    @Test
    public void testeEditarProduto(){
        Produto produto = new Produto("Cadeira",
                "Cadeira ergonômica para escritório",
                "Móveis para casa", 150.00,
                10);

        List<Produto> produtos = new ArrayList<>();
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        sistema.cadastrarProduto(new Scanner(System.in));
        Produto produtoEditado = new Produto("Cadeira de balanço",
                "Cadeira de balanço para jardim",
                "Móveis para casa",
                180.00,
                8);
        sistema.editarProduto(new Scanner(System.in));

        Assert.assertEquals("Cadeira de balanço", sistema.getProdutos().get(0).getNome());
        Assert.assertEquals("Cadeira de balanço para jardim", sistema.getProdutos().get(0).getDescricao());
        Assert.assertEquals(180.00, sistema.getProdutos().get(0).getPrecoUnitario(), 0.01);
        Assert.assertEquals(8, sistema.getProdutos().get(0).getQuantidadeEmEstoque());
    }

    @Test
    public void testeExcluirProduto(){
        Produto produto1 = new Produto("Mesa",
                "Mesa de jantar",
                "Móveis para casa",
                300.00,
                10);
        Produto produto2 = new Produto("Guarda-roupa",
                "Guarda-roupa com portas de correr",
                "Móveis para casa",
                600.00,
                5);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        sistema.excluirProduto(new Scanner(System.in));

        Assert.assertEquals(1, sistema.getProdutos().size());
        Assert.assertEquals("Mesa", sistema.getProdutos().get(0).getNome());
    }

    @Test
    public void testeConsultarProdutos(){
        Produto produto1 = new Produto("Cama",
                "Cama de casal",
                "Móveis para casa",
                800.00,
                10);
        Produto produto2 = new Produto("Escrivaninha",
                "Escrivaninha de estudo",
                "Móveis para casa",
                120.00,
                20);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        sistema.consultarProdutos();
    }

    @Test
    public void testeEditarProdutoInexistente(){
        Produto produto = new Produto("Sofá",
                "Sofá confortável para sala de estar",
                "Móveis para casa",
                800.00,
                5);

        List<Produto> produtos = new ArrayList<>();
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        sistema.editarProduto(new Scanner(System.in));

        Assert.assertTrue(produtos.isEmpty());
    }
}