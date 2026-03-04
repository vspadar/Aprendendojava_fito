package geometria;

import java.util.Scanner;

public class Calculadora {

    // Propriedades encapsuladas 
    private double lado;
    private double base;
    private double altura;
    private double raio;
    private int opcao;

    //Menu De selecao de calculos 
    public void menu() {
        System.out.println("============ MENU ============");
        System.out.println("1 - Calcular Área do Quadrado");
        System.out.println("2 - Calcular Área do Retângulo");
        System.out.println("3 - Calcular Área do Círculo");
        System.out.println("4 - Calcular Área do Triângulo");
        System.out.println("0 - Sair");
        System.out.println("==============================");
    }

    // Método Executar
    public void executar() {
        Scanner sc = new Scanner(System.in);
        char continuar;
    // Método caso queira continuar
        do {

            menu();

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
        // Método switch case para selecionar a forma geometirca que deseja calcular a area
        switch (opcao) {

            case 1:
                System.out.print("Digite o lado do quadrado: ");
                lado = sc.nextDouble();
                double areaQuadrado = lado * lado;
                System.out.printf("Área do Quadrado: %.2f\n", areaQuadrado);
                break;

            case 2:
                System.out.print("Digite a base do retângulo: ");
                base = sc.nextDouble();
                System.out.print("Digite a altura do retângulo: ");
                altura = sc.nextDouble();
                double areaRetangulo = base * altura;
                System.out.printf("Área do Retângulo: %.2f\n", areaRetangulo);
                break;

            case 3:
                System.out.print("Digite o raio do círculo: ");
                raio = sc.nextDouble();
                double areaCirculo = 3.14 * (raio * raio);
                System.out.printf("Área do Círculo: %.2f\n", areaCirculo);
                break;
                
            case 4:
                System.out.print("Digite a base do triângulo: ");
                base = sc.nextDouble();
                System.out.print("Digite a altura do triângulo: ");
                altura = sc.nextDouble();
                System.out.printf("Área do Triângulo: %.2f\n", (base * altura) / 2);
                break;    
                
            case 0:
                System.out.println("Encerrando o programa...");
                break;

            default:
                System.out.println("Opção inválida!");
        }

        //Método while para saber se vai finalizar ou continuar o programa 
        System.out.print("\nDeseja calcular outro? (s/n): ");
        continuar = sc.next().charAt(0);

    } while (continuar == 's' || continuar == 'S');

    System.out.println("Programa finalizado.");
    sc.close();
  }
}
