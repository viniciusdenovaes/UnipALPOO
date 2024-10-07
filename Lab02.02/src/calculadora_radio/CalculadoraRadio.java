package calculadora_radio;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CalculadoraRadio extends JFrame {
	
	JTextField textPrimeiroNumero = new JTextField(30);
	JTextField textSegundoNumero = new JTextField(30);
	
	JLabel labelResposta = new JLabel(" ");
	
	JRadioButton botaoSoma = new JRadioButton("+");
	JRadioButton botaoSubt = new JRadioButton("-");
	JRadioButton botaoMult = new JRadioButton("*");
	JRadioButton botaoDivi = new JRadioButton("/");

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
		JButton botaoIgual = new JButton("=");
		botaoIgual.addActionListener(new AcaoResposta());
		painelResposta.add(botaoIgual, BorderLayout.LINE_START);
		painelResposta.add(labelResposta, BorderLayout.CENTER);
		
		add(painelResposta);
	 
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

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new CalculadoraRadio().init();
            }});
	}
}
