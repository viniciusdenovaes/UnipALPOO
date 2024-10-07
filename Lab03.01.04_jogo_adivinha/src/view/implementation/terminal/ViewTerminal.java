package view.implementation.terminal;

import java.awt.event.ActionListener;
import java.util.Scanner;

import entities.Resultado;
import view.View;

public class ViewTerminal implements View {
	
	ActionListener acaoJogar;
	boolean ganhou = false;
	
	@Override
	public void init() {
		
		System.out.println("Bem vindo ao jogo do Adivinha Numero");
		System.out.println("Estou pensando em um numero entre 0 e 100, e vc deve adivinhar este numero");
		System.out.println("Para cada tentativa eu vou dizer se é MENOR, MAIOR, ou IGUAL ao numero que estou pensando");
		
		while(!ganhou)
			this.acaoJogar.actionPerformed(null);
	}
	
	@Override
	public void addActionJogar(ActionListener al) {
		this.acaoJogar = al;
	}

	@Override
	public int getNumero() {
		System.out.println("Entre com um numero entre 0 e 100:");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int numero = Integer.parseInt(in.nextLine());
		return numero;
	}

	@Override
	public void mostrarResultado(Resultado resultado, int quantidadeTentativas) {
		if(resultado==Resultado.MENOR) {
			System.out.println("Seu numero é MENOR que à resposta correta");
		}
		if(resultado==Resultado.MAIOR) {
			System.out.println("Seu numero é MAIOR que à resposta correta");
		}
		if(resultado==Resultado.IGUAL) {
			System.out.println("Seu numero é IGUAL à resposta correta");
			ganhou = true;
		}
		System.out.println("Voce fez " + quantidadeTentativas + " tentativas");
	}

	@Override
	public void terminarJogo(int quantidadeTentativas) {
		System.out.println("Voce acertou em " + quantidadeTentativas + " tentativas");
	}

}
