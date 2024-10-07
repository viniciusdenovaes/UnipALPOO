package entities;

public enum Operacao {
	SOMA("+", (a,b)->a+b), 
	SUBTRACAO("-", (a,b)->a-b), 
	MULTIPLICACAO("*", (a,b)->a*b), 
	DIVISAO("/", (a,b)->a/b);
	
	String simbolo;
	OperacaoMatematica operacaoMatematica;
	
	private Operacao(
			String aSimbolo, 
			OperacaoMatematica aOperacaoMatematica) {
		this.simbolo = aSimbolo;
		this.operacaoMatematica = aOperacaoMatematica;
	}
	
	public String getSimbolo() {
		return this.simbolo;
	}
	
	@Override
	public String toString() {
		return this.simbolo;
	}
	
	public int fazCalculo(int a, int b) throws ArithmeticException {
		System.out.println("fazendo " + a + " " + this + " " + b);
		
		if(this==Operacao.DIVISAO && b == 0) throw new ArithmeticException("Dividindo por Zero");
		
		return this.operacaoMatematica.fazOperacao(a, b);
	}
	
	interface OperacaoMatematica{
		int fazOperacao(int a, int b);
	}

}
