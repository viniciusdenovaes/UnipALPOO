package view.implementation.view_terminal;

import java.awt.event.ActionListener;
import java.util.Scanner;

import view.View;

public class ViewTerminal implements View {

	ActionListener acaoCalcular;
	
	@Override
	public void init() {
		this.acaoCalcular.actionPerformed(null);
	}
	
	@Override
	public void addAcaoCalcular(ActionListener acaoCalcular) {
		this.acaoCalcular = acaoCalcular;
	}

	@Override
	public void mostrarResultado(int resultado) {
		System.out.println("Resultado: " + resultado);
	}

	@Override
	public int getNumeroA() {
		return pegaNumeroValido();
	}

	@Override
	public int getNumeroB() {
		return pegaNumeroValido();
	}
	
	@SuppressWarnings("resource")
	static private int pegaNumeroValido() {
		try {
			System.out.println("Entre com um numero");
			return Integer.parseInt(new Scanner(System.in).nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Entrada deve ser um numero");
			return pegaNumeroValido();
		}
	}

}
