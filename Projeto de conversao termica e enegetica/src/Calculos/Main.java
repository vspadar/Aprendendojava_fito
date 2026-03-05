package Calculos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ConversorGenérico> historicoConversoes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = obterOpcaoUsuario();

            switch (opcao) {
                case 1:
                    realizarConversao();
                    break;

                case 2:
                    consultarHistorico();
                    break;

                case 3:
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n### Menu ###");
        System.out.println("1. Realizar Conversão");
        System.out.println("2. Consultar Histórico");
        System.out.println("3. Sair");
    }

    private static int obterOpcaoUsuario() {
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número válido.");
            scanner.next(); // Limpa o buffer
        }
        return scanner.nextInt();
    }

    private static void realizarConversao() {
        int tipoConversao = obterTipoConversao();
        double valorEntrada = obterValorEntrada();
        int unidadeOrigem = obterUnidade("origem", tipoConversao);
        int unidadeDestino = obterUnidade("destino", tipoConversao);
        String usuario = obterNomeUsuario();

        ConversorGenérico conversor = null;

        if (tipoConversao == 1) {
            conversor = new ConversorTermico(valorEntrada, unidadeOrigem, unidadeDestino, usuario);
        } else if (tipoConversao == 2) {
            conversor = new ConversorEnergetico(valorEntrada, unidadeOrigem, unidadeDestino, usuario);
        }

        if (conversor != null) {
            conversor.calcularConversao();
            historicoConversoes.add(conversor);
        }
    }

    private static void consultarHistorico() {
        if (historicoConversoes.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            System.out.println("\n### Histórico de Conversões ###");
            for (ConversorGenérico conversao : historicoConversoes) {
                System.out.println(conversao.getUsuario() + " - " + conversao.getValorEntrada() + " " + conversao.getUnidadeOrigem() +
                        " -> " + conversao.getValorSaida() + " " + conversao.getUnidadeDestino());
            }
        }
    }

    // Métodos Auxiliares para obter entradas
    private static int obterTipoConversao() {
        int tipo = 0;
        while (tipo != 1 && tipo != 2) {
            System.out.print("Escolha o tipo de conversão (1-Térmica / 2-Energetica): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite 1 para Térmica ou 2 para Energética.");
                scanner.next(); // Limpa o buffer
            }
            tipo = scanner.nextInt();
        }
        return tipo;
    }

    private static double obterValorEntrada() {
        double valor = -1;
        while (valor <= 0) {
            System.out.print("Digite o valor a ser convertido (positivo): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o buffer
            }
            valor = scanner.nextDouble();
        }
        return valor;
    }

    private static int obterUnidade(String tipoUnidade, int tipoConversao) {
        int opcao = -1;

        if (tipoConversao == 1) {
            if (tipoUnidade.equals("origem")) {
                System.out.println("Escolha a unidade de origem (Temperatura):");
                System.out.println("1. Celsius");
                System.out.println("2. Fahrenheit");
                System.out.println("3. Kelvin");
            } else {
                System.out.println("Escolha a unidade de destino (Temperatura):");
                System.out.println("1. Celsius");
                System.out.println("2. Fahrenheit");
                System.out.println("3. Kelvin");
            }
        } else if (tipoConversao == 2) {
            if (tipoUnidade.equals("origem")) {
                System.out.println("Escolha a unidade de origem (Energia):");
                System.out.println("1. Joules");
                System.out.println("2. Calorias");
                System.out.println("3. Volts");
            } else {
                System.out.println("Escolha a unidade de destino (Energia):");
                System.out.println("1. Joules");
                System.out.println("2. Calorias");
                System.out.println("3. Volts");
            }
        }

        while (opcao < 1 || opcao > 3) {
            System.out.print("Digite o número da opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next(); // Limpa o buffer
            }
            opcao = scanner.nextInt();
            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return opcao;
    }

    private static String obterNomeUsuario() {
        System.out.print("Digite seu nome: ");
        return scanner.next();
    }
}