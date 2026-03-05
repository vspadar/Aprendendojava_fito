package Calculos;
import java.util.Date;
	import java.util.Date;

	public abstract class ConversorGenérico {
	    private double valorEntrada;
	    private double valorSaida;
	    private int unidadeOrigem;  // Alterado para 'int' em vez de 'String'
	    private int unidadeDestino; // Alterado para 'int' em vez de 'String'
	    private Date dataHora;
	    private String usuario;

	    // Construtor
	    public ConversorGenérico(double valorEntrada, int unidadeOrigem, int unidadeDestino, String usuario) {
	        this.valorEntrada = valorEntrada;
	        this.unidadeOrigem = unidadeOrigem;
	        this.unidadeDestino = unidadeDestino;
	        this.usuario = usuario;
	        this.dataHora = new Date();  // Armazena a data e hora da conversão
	    }

	    // Getters e Setters
	    public double getValorEntrada() {
	        return valorEntrada;
	    }

	    public void setValorEntrada(double valorEntrada) {
	        this.valorEntrada = valorEntrada;
	    }

	    public double getValorSaida() {
	        return valorSaida;
	    }

	    public void setValorSaida(double valorSaida) {
	        this.valorSaida = valorSaida;
	    }

	    public int getUnidadeOrigem() {
	        return unidadeOrigem;
	    }

	    public void setUnidadeOrigem(int unidadeOrigem) {
	        this.unidadeOrigem = unidadeOrigem;
	    }

	    public int getUnidadeDestino() {
	        return unidadeDestino;
	    }

	    public void setUnidadeDestino(int unidadeDestino) {
	        this.unidadeDestino = unidadeDestino;
	    }

	    public Date getDataHora() {
	        return dataHora;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    // Método abstrato para ser sobrescrito nas subclasses
	    public abstract void calcularConversao();
	}