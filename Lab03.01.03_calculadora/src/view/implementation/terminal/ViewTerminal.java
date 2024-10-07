package view.implementation.terminal;

import java.awt.event.ActionListener;
import java.util.Scanner;

import entities.Operacao;
import view.View;

public class ViewTerminal implements View {
	
	ActionListener acaoCalcular;
	
	int numA;
	int numB;
	Operacao operacao;
	
	@Override
	public void init() {
		
		System.out.println("Bem vindo à calculadora");
		System.out.println("Escolha o primeiro numero");
		System.out.println("        a operação");
		System.out.println("        o segundo numero");
		
		this.numA = getNumeroValido("Entre com o primeiro numero");
		this.operacao = getOperacaoValida();
		this.numB = getNumeroValido("Entre com o segundo numero");
		
		this.acaoCalcular.actionPerformed(null);
		
	}

	@SuppressWarnings("resource")
	static private int getNumeroValido(String msg) {
		System.out.println(msg);
		String numeroEscrito = new Scanner(System.in).nextLine();
		try {
			int numero = Integer.parseInt(numeroEscrito);
			return numero;
		}catch (NumberFormatException e) {
			System.out.println("Entrada " + numeroEscrito + " nao é um número");
			System.out.println("Tente novamente");
			return getNumeroValido(msg);
		}
	}

	@SuppressWarnings("resource")
	static private Operacao getOperacaoValida() {
		boolean entradaValida = false;
		while(!entradaValida) {
			System.out.println("Entre com a operacao: ");
			System.out.println("                      '+' para soma");
			System.out.println("                      '-' para subtração");
			System.out.println("                      '*' para multiplicação");
			System.out.println("                      '/' para divisão");
			
			String entrada = new Scanner(System.in).nextLine();
			if(entrada.strip().equals("+")) return Operacao.SOMA;
			if(entrada.strip().equals("-")) return Operacao.SUBTRACAO;
			if(entrada.strip().equals("*")) return Operacao.MULTIPLICACAO;
			if(entrada.strip().equals("/")) return Operacao.DIVISAO;
			
			System.out.println("Entrada inválida: " + entrada);
			System.out.println("Tente novamente");
			
		}
		return null;
	}

	@Override
	public void addActionCalcular(ActionListener al) {
		this.acaoCalcular = al;
	}

	@Override
	public Operacao getOperacao() {
		return this.operacao;
	}

	@Override
	public int getNumeroA() {
		return this.numA;
	}

	@Override
	public int getNumeroB() {
		return this.numB;
	}

	@Override
	public void mostrarResultado(int resultado) {
		System.out.println("O resultado da operação " + this.numA + " " + this.operacao + " " + this.numB + " será: " + resultado);
	}

	@Override
	public void mostrarErro(String msg) {
		System.out.println("Erro na operação: " + msg);
	}

	@Override
	public void close() {
		System.exit(0);
	}
	

}
