package calculadora_grid;

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
	
	@Override
	public String toString() {
		return this.simbolo;
	}
	
	int fazCalculo(int a, int b){
		System.out.println("fazendo " + a + " " + this + " " + " " + b);
		return this.operacaoMatematica.fazOperacao(a, b);
	}
	
	interface OperacaoMatematica{
		int fazOperacao(int a, int b);
	}

}
