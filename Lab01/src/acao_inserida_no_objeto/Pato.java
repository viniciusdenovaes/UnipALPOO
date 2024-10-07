package acao_inserida_no_objeto;

public class Pato {
	
	// podemos ter a acao de voar como atributo
	AcaoVoar acaoVoar;
	
	// podemos passar qualquer acao de voar como parametro
	// para definir (ou redefinir) a acao de voar do pato
	public void setAcaoVoar(AcaoVoar aAcaoVoar){
		this.acaoVoar = aAcaoVoar;
	}
	
	// finalmente pode usar a acao de voar
	public void voar() {
		this.acaoVoar.fazVoar();
	}

}
