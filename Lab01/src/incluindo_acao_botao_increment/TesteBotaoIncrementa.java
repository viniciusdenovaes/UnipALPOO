package incluindo_acao_botao_increment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TesteBotaoIncrementa {
	
	public void testeBotao() {
		
		JFrame janela = new JFrame();
		JButton botao = new JButton("Botao Incrementa");
		janela.add(botao);
		
		botao.addActionListener(new BotaoIncrementa());
		
		janela.pack(); 
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	class BotaoIncrementa implements ActionListener{
		int contador = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			contador++;
			System.out.println("O Botao foi pressionado " + contador + " vezes!");
		}
		
	}
	
	public static void main(String[] args) {
		new TesteBotaoIncrementa().testeBotao();
	}

}
