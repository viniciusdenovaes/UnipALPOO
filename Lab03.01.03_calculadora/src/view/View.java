package view;

import java.awt.event.ActionListener;

import entities.Operacao;

public interface View {
	
	void init();
	
	void addActionCalcular(ActionListener al);
	Operacao getOperacao();
	int getNumeroA();
	int getNumeroB();
	
	void mostrarResultado(int resultado);
	void mostrarErro(String msg);
	
	void close();

}
