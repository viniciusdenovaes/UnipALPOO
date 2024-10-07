package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {
	Model model;
	View view;
	
	public Controller(Model aModel, View aView){
		this.model = aModel;
		this.view = aView;
	}
	
	public void init(){
		view.addAcaoCalcular(new AcaoCalcular());
		
		model.init();
		view.init();
	}
	
	class AcaoCalcular implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			int numeroA = view.getNumeroA();
			int numeroB = view.getNumeroB();
			
			int result = model.calcularNumeros(numeroA, numeroB);
			
			view.mostrarResultado(result);
		}
	}
}
