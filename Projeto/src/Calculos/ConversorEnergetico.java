package Calculos;

public class ConversorEnergetico extends ConversorGenérico {

    public ConversorEnergetico(double valorEntrada, int unidadeOrigem, int unidadeDestino, String usuario) {
        super(valorEntrada, unidadeOrigem, unidadeDestino, usuario);  // O super chama o construtor da superclasse
    }

    @Override
    public void calcularConversao() {
        double resultado = 0;
        int unidadeOrigem = getUnidadeOrigem();
        int unidadeDestino = getUnidadeDestino();

        // Mapeamento das unidades: 1 -> Joules, 2 -> Calorias, 3 -> Volts
        if (unidadeOrigem == 1 && unidadeDestino == 2) {  // Joules -> Calorias
            resultado = getValorEntrada() * 0.239;
        } else if (unidadeOrigem == 2 && unidadeDestino == 1) {  // Calorias -> Joules
            resultado = getValorEntrada() / 0.239;
        } else if (unidadeOrigem == 1 && unidadeDestino == 3) {  // Joules -> Volts
            resultado = getValorEntrada() / 1.0;  // Simplificação para exemplo
        } else if (unidadeOrigem == 3 && unidadeDestino == 2) {  // Volts -> Calorias
            resultado = getValorEntrada() * 0.239;
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
            case 1: return "Joules";
            case 2: return "Calorias";
            case 3: return "Volts";
            default: return "Unidade desconhecida";
        }
    }
}
