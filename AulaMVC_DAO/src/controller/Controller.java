package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dao.Dao;
import entidade.Pato;
import view.View;

public class Controller {
	
	Dao model;
	View view;
	
	public Controller(Dao aModel, View aView) {
		this.model = aModel;
		this.view = aView;
	}
	
	public void init() {
		view.init();
		
		view.addBuscaPatoByNameListener(new AcaoBuscar());
	}
	
	
	
	
	
	class AcaoBuscar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = view.pegaNomePatoBuscaByNome();
			List<Pato> patos = model.buscaPatosByName(nome);
			view.mostrarPatos(patos);
			
			
		}
		
	}
	
	

}
