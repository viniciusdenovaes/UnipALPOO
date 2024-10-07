package ex03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{
	
	public void init() {
		
		setLayout(new FlowLayout());
		
		Contador c= new Contador();
		
		JButton botaoA= new JButton("Botao A");
		botaoA.addActionListener(new AcaoBotao("A", c));
		add(botaoA);
		
		JButton botaoB= new JButton("Botao B");
		botaoB.addActionListener(new AcaoBotao("B", c));
		add(botaoB);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	class Contador {
		
		private int contagem = 0;
		
		public int getContagem() {return contagem;}
		public void aumenta() {contagem++;}
		
	}
	
	class AcaoBotao implements ActionListener{
		
		private String nome;
		private Contador contador;
		
		public AcaoBotao(String aNome, Contador aCont) {
			this.nome = aNome;
			this.contador = aCont;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			contador.aumenta();
			int contagem = contador.getContagem();
			System.out.println("Botao "+nome+" pressionado. Os botoes foram pressionados "+contagem+" vezes");
		}
		
	}
	

}
