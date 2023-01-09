package br.com.alura.testes;

import java.util.List;

import br.com.alura.modelo.Aula;
import br.com.alura.modelo.Curso;

public class TestaCurso {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
//		List<Aula> aulas = javaColecoes.getAulas(); //Ao escrever apenas "javaColecoes.getAulas();" e abrir o quick fix no atalho "Ctrl + 1" é possível pedir para o compilador guardar esse comando em uma nova variavel, assim poupando tempo de criar uma nova lista e nomea-la
//		//Aqui nós criamos uma referencia para guardar a invocação do método "getAulas" do nosso objeto do tipo "Curso" "javaColecoes"
//		
//		System.out.println(aulas); //Mostrando a lista vazia pois ainda não foi adicionado nenhuma referencia nela
		
//		aulas.add(new Aula("Trabalhando com ArrayList", 21)); //Aqui ao invés de criar uma referencia do tipo "Aula" e depois adiciona-la na lista foi preferivel criar o objeto já na chamada da adição da lista, assim poupando código
		
		
		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21)); //Existe essa forma de resumir o código acima, ao invés de criarmos uma referencia a lista e então depois adicinarmos uma aula a essa lista é possível fazer isso tudo em uma única linha porém ainda não é a versão definitiva de se fazer isso porque não queremos que outras classes mexam nas "aulas" da classe "Curso"
		
//		System.out.println(aulas); //Essa referencia imprime já a lista com a aula que foi adicionada
		
		System.out.println(javaColecoes.getAulas()); //E aqui é impresso a mesma coisa porque só existe uma lista, porém existem duas referencias que levam a ela, seja o "getAulas" ou a referencia em que guardamos esse método a "aulas" por isso o retorno das duas chamadas sempre será o mesmo, afinal elas apontam para o mesmo objeto
		
//		System.out.println(aulas == javaColecoes.getAulas()); //Testando para ver se as duas referencias são do mesmo objeto e o console nos retorna "true"
	}

}