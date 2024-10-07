package teste;

import controller.Controller;
import model.implementation.model_default.ModelDefault;
import view.implementation.janela_grid.ViewJanelaGrid;
import view.implementation.janela_radio.ViewJanelaRadio;
import view.implementation.terminal.ViewTerminal;

public class Teste {
	
	public static void main(String[] args) {
		
		// model default e view pelo terminal
		//new Controller(new ModelDefault(), new ViewTerminal()).init();
		
		// model default e view pela JFrame Grid
		//new Controller(new ModelDefault(), new ViewJanelaGrid()).init();
		
		// model default e view pela JFrame Radio Button
		new Controller(new ModelDefault(), new ViewJanelaRadio()).init();
		
	}

}
