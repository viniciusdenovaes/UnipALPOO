package teste;

import controller.Controller;
import model.Model;
import model.implementation.model_determinado.ModelDeterminado;
import model.implementation.model_random.ModelRandom;
import view.View;
import view.implementation.jframe.ViewJanela;
import view.implementation.terminal.ViewTerminal;

public class Teste {
	
	public static void main(String[] args) {
		
		// model com um numero determinado e view pelo terminal
		//new Controller(new ModelDeterminado(50), new ViewTerminal()).init();
		
		// model com um numero aleatorio (com seed) e view pelo terminal
		//new Controller(new ModelRandom(50), new ViewTerminal()).init();
		
		// model com um numero aleatorio (com seed) e view pelo terminal
		new Controller(new ModelRandom(50), new ViewJanela()).init();
	}

}
