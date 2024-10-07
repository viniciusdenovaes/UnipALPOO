package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Operacao;
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
		
		this.view.addActionCalcular(new AcaoCalcula());
		this.view.init();
	}
	
	class AcaoCalcula implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			int a = view.getNumeroA();
			Operacao op = view.getOperacao();
			int b = view.getNumeroB();
			
			try {
				int resultado = model.getResultado(op, a, b);
				
				view.mostrarResultado(resultado);
			} catch(ArithmeticException ex) {
				view.mostrarErro(ex.getMessage());
			}
			
			model.close();
			view.close();
		}
		
	}
	
}




