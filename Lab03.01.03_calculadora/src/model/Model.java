package model;

import entities.Operacao;

public interface Model {
	
	void init();
	int getResultado(Operacao op, int a, int b) throws ArithmeticException;
	void close();

}
