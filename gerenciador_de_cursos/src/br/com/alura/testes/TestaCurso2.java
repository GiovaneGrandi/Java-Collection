package br.com.alura.testes;

import java.util.List;

import br.com.alura.modelo.Aula;
import br.com.alura.modelo.Curso;

public class TestaCurso2 {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21)); //Ao tentar modificar a lista dessa forma (que não é mais permitida graças ao unmodifiableList) o console retornara ume exceção a "UnsupportedOperationException" fazendo com que seja impossível modificar (adicionar, remover...) a lista dessa forma mais suja
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21)); //O jeito definitivo de se alterar (no caso adicionar) aulas para a lista do objeto "Curso" é através de um método próprio para isso, com o método adicionado na classe "Conta" adicionar itens na lista fica muito mais simples
		//Com o método "unmodifiableList" n´so obrigamos todos que quiserem adicionar um item na lista a usarem esse método "adiciona" para que seja bem sucedida a adição
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		System.out.println(javaColecoes.getAulas()); 
		
	}

}