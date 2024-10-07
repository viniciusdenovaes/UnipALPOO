package model.implementation.model_determinado;

import entities.Resultado;
import model.Model;

public class ModelDeterminado implements Model {
	
	int numeroResposta;
	int quatidadeJogadas = 0;
	
	public ModelDeterminado(int aNumeroResposta) {
		this.numeroResposta = aNumeroResposta;
	}

	@Override
	public void init() {
	}

	@Override
	public Resultado getResultadoFromNumero(int numero) {
		this.quatidadeJogadas++;
		     if(numero <  this.numeroResposta) return Resultado.MENOR;
		else if(numero >  this.numeroResposta) return Resultado.MAIOR;
		else                                   return Resultado.IGUAL;
	}

	@Override
	public int getQuantidadesJogadas() {
		return this.quatidadeJogadas;
	}
	
	

}
