package ex04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{
	
	public void init() {
		
		setLayout(new FlowLayout());
		
		Contador c= new Contador();
		
		JButton botaoAumenta= new JButton("Botao Aumenta");
		botaoAumenta.addActionListener(new AumentaContagem(c));
		add(botaoAumenta);
		
		JButton botaoReseta= new JButton("Botao Reseta");
		botaoReseta.addActionListener(new ResetaContagem(c));
		add(botaoReseta);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	class Contador {
		
		private int contagem = 0;
		
		public int getContagem() {return contagem;}
		public void aumenta() {contagem++;}
		public void reset() {contagem=0;}
		
	}
	
	class AumentaContagem implements ActionListener{
		
		private Contador contador;
		
		public AumentaContagem(Contador aCont) {
			this.contador = aCont;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			contador.aumenta();
			int contagem = contador.getContagem();
			System.out.println("Botao pressionado "+contagem+" vezes");
		}
		
	}
	
	class ResetaContagem implements ActionListener{
		
		private Contador contador;
		
		public ResetaContagem(Contador aCont) {
			this.contador = aCont;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			contador.reset();
			System.out.println("Contagem resetada");
		}
		
	}
	

}
