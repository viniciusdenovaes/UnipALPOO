package calculos;

public class Calculadora {
	
	Operacao operacao;
	
	public void setOperacao(Operacao aOperacao) {
		this.operacao = aOperacao;
	}
	
	public double fazConta(double a, double b) {
		return this.operacao.fazOperacao(a, b);
	}

}
