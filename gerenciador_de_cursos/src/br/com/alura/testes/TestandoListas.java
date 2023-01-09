package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	
	public static void main(String[] args) {
		
		//Reforçando conhecimentos sobre ArrayList:
		
		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe aula";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		aulas.remove(0);
		
		System.out.println(aulas);
		
		for (String aula : aulas) { //O "foreach" se lê dessa maneira: "para cada String 'aula' dentro de 'aulas' execute isso:"
			System.out.println("Aula: " + aula);
		}
		
		String primeiraAula = aulas.get(0);
		
		System.out.println("A primeira aula é " + primeiraAula);
		
		for(int i = 0; i < aulas.size(); i++) { //O for usa a medida "menor" que o tamanho da lista por quê? porque o array tendo 2 casas preenchidas ele terá os itens de indice 0 e 1, e se fosse usada a medida "menor ou igual" o contador iria até o número 2 do qual está vazio e resultaria em uma excption, por isso que se usa o medidor "menor"
			System.out.println("Aula : " + aulas.get(i) );
		}
		
		System.out.println(aulas.size());
		
		aulas.forEach(aula -> { //O método "forEach" pode receber diversas execuções para suas iterações, porém quando se usa o forEach é mais sintático colocar poucas funcionalidades, pois se o código ficar muito extenso o código perderia o sentido e seria melhor fazer uma classe para tal execução
			System.out.println("Percorrendo:");
			System.out.println("Aula: " + aula);
		});
		
		aulas.add("Aumentando nosso conhecimento");
		
		System.out.println(aulas);
		
		Collections.sort(aulas); //Em alguns casos é melhor delegar a ordenação para a classe "Collections" do que fazer por conta da própria lista, pois se você usar o método "sort" da lista ele obrigatóriamente irá te pedir um "Comparable" o que não chega a ser necessário em alguns casos com o "Collections"
		
		System.out.println("Depois de ordenado:");
		System.out.println(aulas);
		
	}

}
