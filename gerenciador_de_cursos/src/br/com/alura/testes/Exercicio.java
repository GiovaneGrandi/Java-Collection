package br.com.alura.testes;

import java.util.HashMap;
import java.util.Map;

public class Exercicio {
	
	public static void main(String[] args) {
		
		//O exercicio pede para que criemos uma maneira de iterar sobre os valores desse map
		
        Map<Integer, String> pessoas = new HashMap<>();

        //Nesse caso as chaves são as idades e os valores são os nomes das pessoas
        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
        pessoas.keySet().forEach(idade -> {System.out.println(pessoas.get(idade));}); //Para conseguir iterar por esse map nós chamamos o método "keySet" do map que serve para criar um set com as chaves que estão nesse map
        //E então com esse set em mãos nós chamamos o método foreach para poder iteraqr dentro das keys do set, utilizando um lambda nós percorremos por cada chave "idade" e imprimimos o seu valor
		
	}

}
