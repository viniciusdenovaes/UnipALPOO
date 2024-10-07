package view;

import java.awt.event.ActionListener;

import entities.Resultado;

public interface View {
	
	void init();
	void addActionJogar(ActionListener al);
	int getNumero();
	void mostrarResultado(Resultado resultado, int quantidadeTentativas);
	void terminarJogo(int quantidadeTentativas);

}
