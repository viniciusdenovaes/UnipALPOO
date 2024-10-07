package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidade.Pato;

public class Janela extends JFrame{
	
	private static final Object[] nomeDasColunas = {"id", "nome"};
	DefaultTableModel dtm = new DefaultTableModel(nomeDasColunas, 0);
	JTable table = new JTable(dtm);
	JScrollPane scrollPane = new JScrollPane(table);
	
	public void init() {
		
		add(scrollPane);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	public void popularTable(List<Pato> patos) {
		patos = new ArrayList<>();
		for(int i=0; i<100; i++) {
			patos.add(new Pato("Pato "+i, i));
		}
		
		for(Pato p : patos) {
			Object[] rowData = {p.getId(), p.getNome()};
			dtm.addRow(rowData);
		}
		
	}
	
	public static void main(String[] args) {
		Janela j = new Janela();
		j.init();
		j.popularTable(null);
		
	}

}
