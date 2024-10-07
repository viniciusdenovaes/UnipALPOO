package model.implementation.model_random;

import java.util.Random;

import entities.Resultado;
import model.Model;

// Random uniformemente variado
public class ModelRandom implements Model {
	
	Random generator;
	
	int numeroResposta = -1;
	int quatidadeJogadas = 0;
	
	public ModelRandom() {
		this.generator = new Random();
	}

	public ModelRandom(long seed) {
		this.generator = new Random(seed);
	}

	@Override
	public void init() {
		this.numeroResposta = this.generator.nextInt(101);
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
