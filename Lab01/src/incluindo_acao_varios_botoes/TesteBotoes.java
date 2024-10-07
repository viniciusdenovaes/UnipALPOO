package incluindo_acao_varios_botoes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TesteBotoes {
	
	public void testeBotoes() {
		
		JFrame janela = new JFrame();
		
		// Vamos incluir varios botoes, precisamos selecionar um layout
		janela.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// criando acao por inner class
		JButton botaoInnerClass = new JButton("Botao Inner class");
		janela.add(botaoInnerClass);
		botaoInnerClass.addActionListener(new AcaoBotao());
		
		// criando acao por classe anonima
		JButton botaoClasseAnonima = new JButton("Botao classe anonima");
		janela.add(botaoClasseAnonima);
		botaoClasseAnonima.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Classe Anonima: o botao foi pressionado");
			}
		});
		
		// criando acao por expressao lambda
		JButton botaoLambda = new JButton("Botao lambda expression");
		janela.add(botaoLambda);
		botaoLambda.addActionListener((ActionEvent e) -> System.out.println("Lambda Expression: o botao foi pressionado"));
		
		
		janela.pack(); 
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	class AcaoBotao implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Inner class: O Botao foi pressionado!");
		}
	}
	
	public static void main(String[] args) {
		new TesteBotoes().testeBotoes();
	}

}
