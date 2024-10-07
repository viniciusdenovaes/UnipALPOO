package view.implementation.jframe;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.Resultado;
import view.View;

public class ViewJanela extends JFrame implements View {
	
	JLabel labelResposta = new JLabel(" ");
	JLabel labelTentativas = new JLabel(" ");
	JTextField fieldPergunta = new JTextField(10);
	JButton botao = new JButton("Tentar");
	
	int ultimaTentativa = -1;
	
	@Override
	public void init() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(new JLabel("Bem vindo ao jogo do Adivinha Numero"));
		add(new JLabel("Estou pensando em um numero entre 0 e 100, e vc deve adivinhar este numero"));
		add(new JLabel("Para cada tentativa eu vou dizer se é MENOR, MAIOR, ou IGUAL ao numero que estou pensando"));

		add(this.fieldPergunta);
		add(this.labelResposta);
		add(this.labelTentativas);
		add(this.botao);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void addActionJogar(ActionListener al) {
		this.botao.addActionListener(al);
		this.fieldPergunta.addActionListener(al);
	}

	@Override
	public int getNumero() {
		int numeroTentativa = Integer.parseInt(this.fieldPergunta.getText());
		this.ultimaTentativa = numeroTentativa;
		return numeroTentativa;
	}

	@Override
	public void mostrarResultado(Resultado resultado, int quantidadeTentativas) {
		if(resultado==Resultado.MENOR) {
			this.labelResposta.setText("Seu numero " + this.ultimaTentativa + " é MENOR que à resposta correta");
		}
		if(resultado==Resultado.MAIOR) {
			this.labelResposta.setText("Seu numero " + this.ultimaTentativa + " é MAIOR que à resposta correta");
		}
		if(resultado==Resultado.IGUAL) {
			this.labelResposta.setText("Seu numero " + this.ultimaTentativa + " é IGUAL à resposta correta");
		}
		
		this.labelTentativas.setText("Voce fez " + quantidadeTentativas + " tentativas");
		
		this.fieldPergunta.setText("");
	}

	@Override
	public void terminarJogo(int quantidadeTentativas) {
		this.botao.setEnabled(false);
		this.fieldPergunta.setEnabled(false);
	}

}
