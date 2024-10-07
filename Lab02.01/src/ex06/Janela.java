package ex06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame{
	
	JTextField input;
	
	JLabel label;
	
	public void init() {
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		input = new JTextField(50);
		add(input);
		input.addActionListener(new AcaoLabel());
		
		label = new JLabel("teste");
		add(label);
		
		JButton botao = new JButton("Enter");
		add(botao);
		botao.addActionListener(new AcaoLabel());
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	class AcaoLabel implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Referencia para variavel de Janela
			String texto = input.getText();
			input.setText("");
			label.setText(texto);
		}
		
	}
	

}
