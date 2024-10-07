package calculos;

public class TesteCalculadora {
	
	public void testaCalculadora() {
		
		Calculadora calculadoraSoma = new Calculadora();
		calculadoraSoma.setOperacao(new OperacaoSoma());
		System.out.println("resultado de calculadoraSoma com 1 e 2 = " + calculadoraSoma.fazConta(1, 2));
		
		
		Calculadora calculadoraMulti = new Calculadora();
		calculadoraMulti.setOperacao(new Operacao() {
			@Override
			public double fazOperacao(double a, double b) {
				return a*b;
			}});
		System.out.println("resultado de calculadoraMulti com 1 e 2 = " + calculadoraMulti.fazConta(1, 2));
		
		
		Calculadora calculadoraDiv = new Calculadora();
		calculadoraDiv.setOperacao((a, b) -> a/b);
		System.out.println("resultado de calculadoraDiv com 1 e 2 = " + calculadoraDiv.fazConta(1, 2));
		
		
	}
	
	class OperacaoSoma implements Operacao{
		@Override
		public double fazOperacao(double a, double b) {
			return a+b;
		}
	}
	
	public static void main(String[] args) {
		new TesteCalculadora().testaCalculadora();
	}

}
