package view.implementation.view_JFrame;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;

@SuppressWarnings("serial")
public class ViewJFrame extends JFrame implements View {

	JTextField textNumeroA = new JTextField(20);
	JTextField textNumeroB = new JTextField(20);
	JButton botaoResultado = new JButton("Resultado");
	JLabel labelResultado = new JLabel(" ");
	JLabel labelError = new JLabel(" ");
	
	@Override
	public void init() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(textNumeroA);
		add(textNumeroB);
		add(botaoResultado);
		add(labelResultado);
		add(labelError);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void addAcaoCalcular(ActionListener al) {
		this.botaoResultado.addActionListener(al);
	}

	@Override
	public void mostrarResultado(int resultado) {
		this.labelResultado.setText("Resultado: " + resultado);
	}

	@Override
	public int getNumeroA() {
		try {
			return Integer.parseInt(textNumeroA.getText());
		}catch (NumberFormatException e) {
			labelError.setText("Entrada de numero A nao eh valida");
			throw e;
		}
	}

	@Override
	public int getNumeroB() {
		try {
			return Integer.parseInt(textNumeroB.getText());
		}catch (NumberFormatException e) {
			labelError.setText("Entrada de numero B nao eh valida");
			throw e;
		}
	}

}
