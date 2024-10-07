package view.implementation.janela_radio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.Operacao;
import view.View;

@SuppressWarnings("serial")
public class ViewJanelaRadio extends JFrame implements View {
	
	JTextField textPrimeiroNumero = new JTextField(30);
	JTextField textSegundoNumero = new JTextField(30);
	
	JLabel labelResposta = new JLabel(" ");
	
	JRadioButton botaoSoma = new JRadioButton("+");
	JRadioButton botaoSubt = new JRadioButton("-");
	JRadioButton botaoMult = new JRadioButton("*");
	JRadioButton botaoDivi = new JRadioButton("/");
	
	JButton botaoIgual = new JButton("=");
	
	boolean primeiroNumeroValido = false;
	boolean segundoNumeroValido = false;
	boolean operacaoValida = false;

	public void init() {
		criaElementos();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void criaElementos() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel painelPergunta = new JPanel(new FlowLayout());
		add(painelPergunta);
		
		painelPergunta.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0; c.gridy = 0; c.weightx = 1.0; c.anchor = GridBagConstraints.LINE_START; c.fill = GridBagConstraints.HORIZONTAL;
		painelPergunta.add(textPrimeiroNumero, c);
		
		c.gridx = 2; c.gridy = 0; c.weightx = 1.0; c.anchor = GridBagConstraints.LINE_END; c.fill = GridBagConstraints.HORIZONTAL;
		painelPergunta.add(textSegundoNumero, c);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.PAGE_AXIS));
		painelBotoes.add(botaoSoma);
		painelBotoes.add(botaoSubt);
		painelBotoes.add(botaoMult);
		painelBotoes.add(botaoDivi);
		
		c.gridx = 1; c.gridy = 0; c.weightx = 0.0; c.anchor = GridBagConstraints.CENTER; c.fill = GridBagConstraints.NONE;
		painelPergunta.add(painelBotoes, c);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(botaoSoma);
		bg.add(botaoSubt);
		bg.add(botaoMult);
		bg.add(botaoDivi);
		
		
		add(painelPergunta);
		
		
		JPanel painelResposta = new JPanel(new BorderLayout());
		botaoIgual.setEnabled(false);
		
		painelResposta.add(botaoIgual, BorderLayout.LINE_START);
		painelResposta.add(labelResposta, BorderLayout.CENTER);
		
		add(painelResposta);
		
		this.textPrimeiroNumero.addKeyListener(new AcaoVerificaNumeros());
		this.textSegundoNumero.addKeyListener(new AcaoVerificaNumeros());
		this.botaoSoma.addActionListener(new AcaoVerificaOperacao());
		this.botaoSubt.addActionListener(new AcaoVerificaOperacao());
		this.botaoMult.addActionListener(new AcaoVerificaOperacao());
		this.botaoDivi.addActionListener(new AcaoVerificaOperacao());
	 
	}
	
	class AcaoVerificaNumeros implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			validaBotaoResposta();
		}
		
	}
	
	class AcaoVerificaOperacao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			validaBotaoResposta();
		}
		
	}
	
	class AcaoResposta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			int primeiroNumero, segundoNumero;
			try {
				primeiroNumero = Integer.parseInt(textPrimeiroNumero.getText());
				segundoNumero = Integer.parseInt(textSegundoNumero.getText());
			}catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
				labelResposta.setText("Um dos numeros esta invalido");
				return;
			}
			int res = 0;
			     if(botaoSoma.isSelected()) { res = primeiroNumero + segundoNumero; }
			else if(botaoSubt.isSelected()) { res = primeiroNumero - segundoNumero; }
			else if(botaoMult.isSelected()) { res = primeiroNumero * segundoNumero; }
			else if(botaoDivi.isSelected()) {
				if(segundoNumero == 0) {
					labelResposta.setText("Erro: divisao por zero");
				}
				res = primeiroNumero / segundoNumero; }
			else {
				labelResposta.setText("Escolha uma das opcoes");
				return;
			}
			
			labelResposta.setText(Integer.toString(res));
			
		}
		
	}
	
	private void validaBotaoResposta() {
		if(		validaNumero(this.textPrimeiroNumero) && 
				validaNumero(this.textSegundoNumero) && 
				validaOperacao()) {
			this.botaoIgual.setEnabled(true);
		}
		else {
			this.botaoIgual.setEnabled(false);
		}
	}

	
	
	private boolean validaNumero(JTextField tf) {
		try {
			Integer.parseInt(tf.getText());
			return true;
		}catch (NumberFormatException ex) {
			return false;
		}
	}
	
	private boolean validaOperacao() {
		if(		this.botaoSoma.isSelected() || 
				this.botaoSubt.isSelected() ||
				this.botaoMult.isSelected() ||
				this.botaoDivi.isSelected())
			return true;
		return false;
	}
	
	@Override
	public void addActionCalcular(ActionListener al) {
		this.botaoIgual.addActionListener(al);
	}

	@Override
	public Operacao getOperacao() {
		     if(botaoSoma.isSelected()) { return Operacao.SOMA; }
		else if(botaoSubt.isSelected()) { return Operacao.SUBTRACAO; }
		else if(botaoMult.isSelected()) { return Operacao.MULTIPLICACAO; }
		else if(botaoDivi.isSelected()) { return Operacao.DIVISAO; }
		return null;
	}

	@Override
	public int getNumeroA() {
		return Integer.parseInt(textPrimeiroNumero.getText());
	}

	@Override
	public int getNumeroB() {
		return Integer.parseInt(textSegundoNumero.getText());
	}

	@Override
	public void mostrarResultado(int resultado) {
		labelResposta.setText(Integer.toString(resultado));
	}

	@Override
	public void mostrarErro(String msg) {
		labelResposta.setText(msg);
	}

	@Override
	public void close() {
		this.botaoIgual.setEnabled(false);
	}
}
