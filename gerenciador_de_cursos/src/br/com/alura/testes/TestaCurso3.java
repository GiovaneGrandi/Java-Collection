package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.modelo.Aula;
import br.com.alura.modelo.Curso;

public class TestaCurso3 {
	
	public static void main(String[] args) {
		
        Curso javaColecoes = new Curso("Dominando as colecoes do Java",
                "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
        
        List<Aula> aulasImutaveis = javaColecoes.getAulas(); //Guardando a chamada do método "getAulas" do nosso curso em uma referencia para facilitar o código
        System.out.println(aulasImutaveis); //Imprimindo a lista pura, sem nenhuma modificação na ordem
                
//        Collections.sort(aulas);
//        System.out.println(aulas); //Ao tentar ordenar essa lista acaba sendo retornada a exceção "UnsupportedOperationException" que se dá por conta da nossa lista estar imodificavel, com o método "unmodifiableList" que utilizamos antes ninguém pode adicionar e remover itens da lista por terceiros mas ninguém pode ordena-la também
        
        List<Aula> aulas = new ArrayList<>(aulasImutaveis); //Uma maneira de solucionar o problema da nossa lista ser imutavel é criar uma cópia mutavel dela, ao passar a nossa lista como parametro no construtor de outra lista ela irá pegar todos os elementos que estão dentro da nossa lista para si também, porém por ela não ser alista própria do objetop cursos ela é mutavel e o código funciona normalmente
        
        Collections.sort(aulas);
        System.out.println(aulas); //Agora a lista consegue ficar ordenada como queríamos
        
        System.out.println(javaColecoes.getTempoTotal()); //Chamando o método a récem criado para descobrir o tempo total das aulas
        
        System.out.println(javaColecoes); //Chamando o toString recém criado da classe "Curso"

		
	}

}
