package view;

import java.awt.event.ActionListener;
import java.util.List;

import entidade.Pato;

public interface View {
	
	public void init();
	
	public void mostrarPatos(List<Pato> patos);
	
	public void addBuscaPatoByNameListener(ActionListener al);
	public String pegaNomePatoBuscaByNome();
	
	public void addBuscaPatoByIdListener(ActionListener al);
	public String pegaIdPatoBuscaById();
	
	public void addApagaPatoByIdListener(ActionListener al);
	public String pegaIdApagaPatoById();
	
	public void addAdicionaPatoListener(ActionListener al);
	public String pegaNomeAddPato();
	public String pegaIdAddPato();
	
	
	

}
