package view;

import java.awt.event.ActionListener;

public interface View {
	
	public void init();
	
	public void addAcaoCalcular(ActionListener acaoCalcular);
	
	public void mostrarResultado(int resultado);
	
	public int getNumeroA();
	public int getNumeroB();
}
