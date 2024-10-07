package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidade.Pato;

public class BuscaPanel extends JPanel{
	
	JTextField fieldBusca = new JTextField(20);
	JButton botaoBusca = new JButton("Busca");
	
	Object[] nomeColunas = new String[] {"Id", "Nome"};
	MyDefaultTableModel dtm = new MyDefaultTableModel(nomeColunas, 0);
	JTable tabela = new JTable(dtm);
	JScrollPane tabelaPanel = new JScrollPane(tabela);
	
	public BuscaPanel() {
		setLayout(new BorderLayout());
		
		add(tabelaPanel, BorderLayout.CENTER);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBotoes.add(fieldBusca);
		panelBotoes.add(botaoBusca);
		add(panelBotoes, BorderLayout.PAGE_END);
		
		tabela.addMouseListener(new AcaoClicarTabela());
		
	}
	
	public void mostrarResultado(List<Pato> patos) {
		dtm.setNumRows(0);
		for(Pato p : patos) {
			Object[] row = new Object[] {p.getId(), p.getNome()};
			dtm.addRow(row);
		}
	}
	
	public String pegaNomeBusca() {
		return fieldBusca.getText();
	}
	
	public void addBuscaListener(ActionListener al) {
		botaoBusca.addActionListener(al);
	}
	
	class AcaoClicarTabela implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getClickCount()==2) {
				int row = tabela.getSelectedRow();
				int id = (int)dtm.getValueAt(row, 0);
				String nome = (String)dtm.getValueAt(row, 1);
				System.out.println("id : " + id + " nome " + nome);
			}
			
//			System.out.println("mouse cliik" + e.getClickCount());
		}

		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("mouse pressed");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
//			System.out.println("mouse relesead");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
//			System.out.println("mouse entered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
//			System.out.println("mouse exit");
		}
		
	}
	
	class MyDefaultTableModel extends DefaultTableModel{
		
		public MyDefaultTableModel(Object[] nomeColunas, int rowCount) {
			super(nomeColunas, rowCount);
		}
		
		@Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	}
	
	

}
