import controller.Controller;
import dao.DaoConcreto;
import view.ViewJanela;

public class Teste {
	
	public static void main(String[] args) {
		new Controller(new DaoConcreto(), new ViewJanela()).init();
	}

}
