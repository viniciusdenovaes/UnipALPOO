package model.implementation.model_default;

import model.Model;

public class ModelMultiplicacao implements Model{
	
	@Override
	public void init() {}

	@Override
	public int calcularNumeros(int a, int b) {
		return a*b;
	}

}
