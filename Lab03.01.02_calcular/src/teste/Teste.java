package teste;

import controller.Controller;
import model.implementation.model_default.ModelMultiplicacao;
import model.implementation.model_default.ModelSoma;
import view.implementation.view_JFrame.ViewJFrame;
import view.implementation.view_terminal.ViewTerminal;

public class Teste {
	
	public static void main(String[] args) {
		
		// Teste com model soma e view do terminal
		//new Controller(new ModelSoma(), new ViewTerminal()).init();
		
		// Teste com model multiplicacao e view do terminal
		//new Controller(new ModelMultiplicacao(), new ViewTerminal()).init();
		
		// Teste com model multiplicacao e view do jframe
		new Controller(new ModelMultiplicacao(), new ViewJFrame()).init();
	}

}
