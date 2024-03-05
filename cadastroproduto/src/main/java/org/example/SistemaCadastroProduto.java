package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastroProduto {
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    private Scanner scanner;

    public SistemaCadastroProduto(List<Produto> produtos) {
        this.produtos = produtos;
        scanner = new Scanner(System.in);
    }

    public void cadastrarProduto(Scanner scanner) {
        System.out.println("Nome do produto:");
        String nome = this.scanner.nextLine();

        while (nome.trim().isEmpty()) {
            System.out.println("Nome do produto não pode estar vazio. Digite novamente:");
            nome = this.scanner.nextLine();
        }

        System.out.println("Descrição do produto:");
        String descricao = this.scanner.nextLine();

        System.out.println("Categoria do produto:");
        String categoria = this.scanner.nextLine();

        double precoUnitario = 0;
        boolean precoValido = false;
        while (!precoValido) {
            System.out.println("Preço unitário do produto:");
            try {
                precoUnitario = this.scanner.nextDouble();
                if (precoUnitario >= 0) {
                    precoValido = true;
                } else {
                    System.out.println("Por favor, insira um valor numérico válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor numérico válido.");
                this.scanner.next();
            }
        }

        int quantidadeEmEstoque = 0;
        boolean quantidadeValida = false;
        while (!quantidadeValida) {
            System.out.println("Quantidade em estoque:");
            try {
                quantidadeEmEstoque = this.scanner.nextInt();
                if (quantidadeEmEstoque >= 0) {
                    quantidadeValida = true;
                } else {
                    System.out.println("Por favor, insira um valor numérico válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor numérico válido.");
                this.scanner.next();
            }
        }

        Produto produto = new Produto(nome, descricao, categoria, precoUnitario, quantidadeEmEstoque);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }


    public void editarProduto(Scanner scanner) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }

        this.scanner.nextLine();

        System.out.println("Digite o nome do produto que deseja editar:");
        String nomeProduto = this.scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                System.out.println("Digite o novo nome do produto:");
                String novoNome = this.scanner.nextLine();
                produto.setNome(novoNome);

                System.out.println("Digite a nova descrição do produto:");
                String novaDescricao = this.scanner.nextLine();
                produto.setDescricao(novaDescricao);

                System.out.println("Digite a nova categoria do produto:");
                String novaCategoria = this.scanner.nextLine();
                produto.setCategoria(novaCategoria);

                double novoPreco = 0;
                boolean precoValido = false;
                while (!precoValido) {
                    System.out.println("Digite o novo preço unitário do produto:");
                    try {
                        novoPreco = this.scanner.nextDouble();
                        if (novoPreco >= 0) {
                            precoValido = true;
                        } else {
                            System.out.println("Por favor, insira um valor numérico válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, insira um valor numérico válido.");
                        this.scanner.next();
                    }
                }
                produto.setPrecoUnitario(novoPreco);

                int novaQuantidade = 0;
                boolean quantidadeValida = false;
                while (!quantidadeValida) {
                    System.out.println("Digite a nova quantidade em estoque do produto:");
                    try {
                        novaQuantidade = this.scanner.nextInt();
                        if (novaQuantidade >= 0) {
                            quantidadeValida = true;
                        } else {
                            System.out.println("Por favor, insira um valor numérico válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, insira um valor numérico válido.");
                        this.scanner.next();
                    }
                }
                produto.setQuantidadeEmEstoque(novaQuantidade);

                System.out.println("Produto editado com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado!");
    }
    public void excluirProduto(Scanner scanner) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }

        scanner.nextLine();

        System.out.println("Digite o nome do produto que deseja excluir:");
        String nomeProduto = scanner.nextLine();

        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtos.remove(produto);
                System.out.println("Produto excluído com sucesso!");
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public void consultarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("Lista de produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Categoria: " + produto.getCategoria());
                System.out.println("Preço unitário: " + produto.getPrecoUnitario());
                System.out.println("Quantidade em estoque: " + produto.getQuantidadeEmEstoque());
                System.out.println("--------------------------");
            }
        }
    }


}
