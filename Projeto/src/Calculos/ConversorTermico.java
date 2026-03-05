package Calculos;

public class ConversorTermico extends ConversorGenérico {

	public ConversorTermico(double valorEntrada, int unidadeOrigem, int unidadeDestino, String usuario) {
        super(valorEntrada, unidadeOrigem, unidadeDestino, usuario);  // O super chama o construtor da superclasse
    }

    @Override
    public void calcularConversao() {
        double resultado = 0;
        int unidadeOrigem = getUnidadeOrigem();
        int unidadeDestino = getUnidadeDestino();

        // Mapeamento das unidades: 1 -> Celsius, 2 -> Fahrenheit, 3 -> Kelvin
        if (unidadeOrigem == 1 && unidadeDestino == 2) {  // Celsius -> Fahrenheit
            resultado = (getValorEntrada() * 9/5) + 32;
        } else if (unidadeOrigem == 1 && unidadeDestino == 3) {  // Celsius -> Kelvin
            resultado = getValorEntrada() + 273.15;
        } else if (unidadeOrigem == 2 && unidadeDestino == 1) {  // Fahrenheit -> Celsius
            resultado = (getValorEntrada() - 32) * 5/9;
        } else if (unidadeOrigem == 3 && unidadeDestino == 2) {  // Kelvin -> Fahrenheit
            resultado = (getValorEntrada() - 273.15) * 9/5 + 32;
        } else {
            System.out.println("Conversão não suportada!");
            return;
        }

        setValorSaida(resultado);
        System.out.println("Resultado da Conversão: " + resultado + " " + obterNomeUnidadeDestino(unidadeDestino));
    }

    // Método auxiliar para mapear o número da unidade para o nome
    private String obterNomeUnidadeDestino(int unidadeDestino) {
        switch (unidadeDestino) {
            case 1: return "Celsius";
            case 2: return "Fahrenheit";
            case 3: return "Kelvin";
            default: return "Unidade desconhecida";
        }
    }
}