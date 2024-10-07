package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Resultado;
import model.Model;
import view.View;

public class Controller {
	
	Model model;
	View view;
	
	public Controller(Model aModel, View aView) {
		this.model = aModel;
		this.view = aView;
	}
	
	public void init() {
		this.model.init();
		
		this.view.addActionJogar(new AcaoTestaNumero());
		this.view.init();
	}
	
	class AcaoTestaNumero implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int numero = view.getNumero();
			Resultado resultado = model.getResultadoFromNumero(numero);
			int qtdJogadas = model.getQuantidadesJogadas();
			
			view.mostrarResultado(resultado, qtdJogadas);
			
			if(resultado == Resultado.IGUAL) { 
				view.terminarJogo(qtdJogadas);
			}
		
		}
		
	}
	
}




