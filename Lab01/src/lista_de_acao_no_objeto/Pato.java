package lista_de_acao_no_objeto;

import java.util.ArrayList;
import java.util.List;

public class Pato {
	
	List<AcaoVoar> acaoVoarList = new ArrayList<>();
	
	public void addAcaoVoar(AcaoVoar aAcaoVoar){
		this.acaoVoarList.add(aAcaoVoar);
	}
	
	public void voar() {
		for(AcaoVoar acaoVoar : this.acaoVoarList) {
			acaoVoar.fazVoar();
		}
	}

}
