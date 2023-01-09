package br.com.alura.modelo;

public class Aula implements Comparable<Aula> { //Assinando o contrato com a interface "Comparable" para que um objeto do tipo "Aula" possa se comparar com outro

	private String titulo;
	private int tempo;
	
	public Aula(String titulo, int tempo) { 
		this.titulo = titulo;
		this.tempo = tempo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getTempo() {
		return tempo;
	}
	
	@Override
	public String toString() { //Sobreescrevendo o método "toString" da classe "Object" para deixar a saída das referencias mais bonita
		return "[Aula: " + this.titulo + ", " + this.tempo + " minutos]";
	}

	@Override
	public int compareTo(Aula outraAula) {
		return this.titulo.compareTo(outraAula.titulo); //Delegando a comparação dos titulos para a classe "String", por ela já ter um método de comparação em ordem alfabética não precisamos bater cabeça com isso ao chamar o seu método próprio "compareTo"
	}
	
}

//O atalho "Ctrl = 3" serve para acessar o menu de "quick access" onde é possível procurar por "Generate Constructor Using Fields" que essa opção irá criar automaticamente um construtor utilizando os atributos pedidos como parametro