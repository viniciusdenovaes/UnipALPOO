package acao_inserida_no_objeto;

public class TestaPato {
	public void testaPato() {
		
		Pato pato = new Pato();
		
		
		// setando como objeto anonimo de classe externa
		pato.setAcaoVoar(new AcaoVoarConcreta());
		System.out.println("\n1) Pato voando");
		pato.voar();
		System.out.println("\n");
		
		
		// setando como inner class
		pato.setAcaoVoar(new AcaoVoarInnerClass());
		System.out.println("\n2) Pato voando");
		pato.voar();
		System.out.println("\n");
		
		
		// setando como classe anonima
		pato.setAcaoVoar(new AcaoVoar() {
			@Override
			public void fazVoar() {
				System.out.println("Acao de classe anonima: faz voar");
			}
		});
		System.out.println("\n3) Pato voando");
		pato.voar();
		System.out.println("\n");
		
		
		// setando como expressao lambda (VOCE NAO PRECISA SABER EXPRESSOES lambda)
		pato.setAcaoVoar(() -> System.out.println("Acao como expressao lambda: faz voar"));
		System.out.println("\n4) Pato voando");
		pato.voar();
		System.out.println("\n");
		
		
	}
	
	// Definicao de inner class (uma classe dentro de outra classe)
	class AcaoVoarInnerClass implements AcaoVoar{
		@Override
		public void fazVoar() {
			System.out.println("Acao definida em classe interna: faz voar");
		}
	}
	
	
	
	public static void main(String[] args) {
		new TestaPato().testaPato();
	}

}
