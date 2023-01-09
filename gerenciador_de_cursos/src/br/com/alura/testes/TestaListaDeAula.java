package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.alura.modelo.Aula;

public class TestaListaDeAula {
	
	public static void main(String[] args) {
		
		Aula a1 = new Aula("Revisitando os ArrayLists", 21);
		Aula a2 = new Aula("Lista de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<>(); //Usando o "generics" para que seja criada uma lista que só aceita referencias do tipo "Aula", caso tentem colocar algo que não seja desse tipo, por exemplo uma "String" o código nem irá compilar
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		System.out.println("----------------");
		
		Collections.sort(aulas); //Organizando as aulas através do método "compareTo" feito na classe "Aula"
		//Ao contrário do que aconteceu com a lista de "String" caso não seja implementado um "compareTo" na classe "Aula" esse código não compila pois ele não saberá como essa lista deve ser organizada, a lista de "String" funcionava direto por já ter esse método implementado
		
		System.out.println("Utilizando o método sort para executar o compareTo de Aula: ");
		System.out.println(aulas);
		System.out.println("----------------");
		
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo)); //Esse código abreviado serve para nós mandarmos um método para retirar o que queremos comparar para o "Comparator" executar sua comparação (No caso ele usa o "getTempo" para pegar os tempos das aulas da lista e então consegue os comparar por serem do tipo "int")
		//Aqui já passamos a lista e um "Comparator" para poder organizar a lista de uma maneira diferente do "compareTo"
		
		System.out.println("Utilizando o método sort da Collections: ");
		System.out.println(aulas);
		System.out.println("----------------");
		
		aulas.sort(Comparator.comparing(Aula::getTempo)); //O método "sort" que recebe um "Comparator" da lista tem o mesmo resultado do "Collections" acima, ele pega todos os itens da lista e os rearranja de maneira que eles fiquem na ordem solicitada pelo "Comparator" 
		
		System.out.println("Utilizando o método sort da lista: ");
		System.out.println(aulas);
		System.out.println("----------------");
	}

}
