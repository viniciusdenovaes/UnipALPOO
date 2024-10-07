package model;

import entities.Resultado;

public interface Model {
	
	void init();
	Resultado getResultadoFromNumero(int numero);
	int getQuantidadesJogadas();

}
