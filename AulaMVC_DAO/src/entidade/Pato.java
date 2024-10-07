package entidade;

public class Pato {
	
	String nome;
	int id;
	
	public Pato(String nome, int id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Pato [nome=" + nome + ", id=" + id + "]";
	}
	
	
	

}
