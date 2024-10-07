package model.implementation.model_default;

import entities.Operacao;
import model.Model;

public class ModelDefault implements Model {

	@Override
	public void init() {
	}

	@Override
	public int getResultado(Operacao op, int a, int b) throws ArithmeticException{
		try {
			return op.fazCalculo(a, b);
		}catch(ArithmeticException e) {
			throw e;
		}
	}

	@Override
	public void close() {
	}

}
