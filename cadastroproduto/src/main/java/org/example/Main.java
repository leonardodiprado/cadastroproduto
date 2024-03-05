package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        SistemaCadastroProduto sistema = new SistemaCadastroProduto(produtos);
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    sistema.cadastrarProduto(scanner);
                    break;
                case 2:
                    sistema.editarProduto(scanner);
                    break;
                case 3:
                    sistema.excluirProduto(scanner);
                    break;
                case 4:
                    sistema.consultarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Editar produto");
        System.out.println("3. Excluir produto");
        System.out.println("4. Consultar produtos");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção:");
    }

    private static int lerOpcao(Scanner scanner) {
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 0 && opcao <= 4) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida! Escolha outra.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Escolha outra");
            }
        }
    }
}