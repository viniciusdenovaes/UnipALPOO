package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entidade.Pato;

public class ViewJanela extends JFrame implements View{
	
	JTabbedPane tabedPane = new JTabbedPane();
	
	String nomeAbaBusca = "Busca";
	BuscaPanel buscaPanel = new BuscaPanel();
	
	 JPanel createDummyPanel(String mensagem) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(mensagem);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JButton(mensagem));
        panel.add(new JButton(mensagem));
        panel.add(new JButton(mensagem));
        panel.add(filler);
		return panel;
	}
	
	public void init() {
		
		tabedPane.addTab(nomeAbaBusca, buscaPanel);
		
		
		tabedPane.addTab("dummy 1", createDummyPanel("Dummy 1"));
		tabedPane.addTab("dummy 2", createDummyPanel("Dummy 2"));
		tabedPane.addTab("dummy 3", createDummyPanel("Dummy 3"));
		
		add(tabedPane);
		
		addWindowListener(new AcaoJanela());
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
	}

	@Override
	public void mostrarPatos(List<Pato> patos) {
		buscaPanel.mostrarResultado(patos);
		
	}

	@Override
	public void addBuscaPatoByNameListener(ActionListener al) {
		buscaPanel.addBuscaListener(al);
		
	}

	@Override
	public String pegaNomePatoBuscaByNome() {
		return buscaPanel.pegaNomeBusca();
	}

	@Override
	public void addBuscaPatoByIdListener(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pegaIdPatoBuscaById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addApagaPatoByIdListener(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pegaIdApagaPatoById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdicionaPatoListener(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pegaNomeAddPato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pegaIdAddPato() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class AcaoJanela implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			int o = JOptionPane.showConfirmDialog(null,
		             "Confirmar", "Quer realmente fechar?", JOptionPane.YES_NO_OPTION);			
			if(o==0) {
				System.exit(0);
			}
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new ViewJanela().init();
	}

}
