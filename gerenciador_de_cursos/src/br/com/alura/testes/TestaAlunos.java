package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {
	
	public static void main(String[] args) {
		
		Collection<String> alunos = new HashSet<>(); //Criando um "conjunto" genérico utilizando a classe "Set" e usando o "HashSet" como  conjunto especifico 
		//O conjunto "HashSet" funciona no geral de maneira muito mais rápida que as listas, ele tem uma estrutura de dados espalhada da qual não é preciso passar item por item para achar um determinado elemento, o "HashSet" faz no máximo uma ou duas checagens para definir se um elemento está presente no conjunto ou não, porr isso métodos como "remove" e "contains" funcionam de uma maneira extremamente rápida nos conjuntos /Por isso o "HashSet" é altamente indicado para quem vai fazer muitas verificações em um conjunto de dados popr conta dessa alta velocidade
		//É possível ser ainda mais genérico na chamada de um conjunto/lista e ao invés de usar "List" ou "Set" podemos usar "Collection" já que praticamente todos os métodos que usamos são da classe mãe "Collection" assim nós poderiamos alterar entre conjuntos e listas de uma forma mais dinâmica graças ao polimorfismo
		
		alunos.add("Rodrigo Turini"); //Adicionando alunos para esse conjunto
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Alberto Souza"); //Caso eu insira elementos repetidos dentro de um conjunto eles não serão adicionados, o "Set" garante que nenhum item se repita dentro do conjunto
		
		System.out.println(alunos.size()); //Mesmo eu tendo adicionado 7 itens no conjunto ele imprime apenas 6, por um desses itens ser repetido, em casos de cadastramento ou locais onde não seria bom ter o mesmo elemento entrando no sistema diversas vezes o "Set" acaba sendo mais útil que a "List"
		
		System.out.println(alunos); //Ao imprimir o conjunto de "String" ele se comporta da mesma forma que uma lista porém sem a ordem de inserção dos itens, o "Set" não te garante que a ordem em que os itens foram colocados seja a mesma a ser exibida no console, por isso não é possível acessar os itens dos conjuntos através do índice como nas listas
		
//		for (String aluno : alunos) { //A única forma de se acessar os itens de um conjunto seria através do "foreach" onde nesse caso eu peço para exibir todos os alunos do conjunto no console
//			System.out.println(aluno);
//		}
		
		alunos.forEach(aluno -> {System.out.println(aluno);}); //O "Set" tem vários métodos em comum com a classe "List" pois os dois herdam da interface mãe "Collection", essa é uma maneira mais simples de escrever o for acima, usando o método "forEach" da classe e um "Lambda" para definir a ação que deve ser executada para cada item informado
		
		boolean giovaneEstaMatriculado = alunos.contains("Giovane Grandi"); //Com o método "contains" é possível verificar se determinado elemento existe no conjunto ou não, caso ele exista é retornado um "true" caso não é retornado "false"
		System.out.println(giovaneEstaMatriculado);
		
		alunos.remove("Sergio Lopes"); //Ao remover um item do conjunto é necessário informar o item específico que precisa ser removido, como a classe "Set" não tem nenhum getter ou não tem índice já que a ordem não é relevante para ela essa remoção precisa ser mais específica do que só uma posíção
		System.out.println(alunos); //Mostrando no console o conjunto com o aluno já removido
		
//		Collections.sort(alunos); //Os conjuntos não são aplicavéis no método "sort" da classe "Collections" pois esse método só serve para ordenar Listas
		
		List<String> alunosEmLista = new ArrayList<>(alunos); //Mesmo o nosso conjunto sendo chamado de forma genérica com o "Collection" caso o transformassemos em uma lista ele não funcionaria de maneira total pois as listas tem métodos exclusivos, então no caso de ter que transformar esse conjunto anterior em uma lista seria mais fácil criar uma nova lista do zero passando o conjunto anterior como parametro para criar uma cópia /As listas podem receber qualquer "Collection" como parametro
		//O método "sort" da classe "Collections" por exemplo só funciona com listas, então no caso de querer ordenar o conjunto seria necessário transforma-lo em lista e passar esse método
		
		Collections.sort(alunosEmLista);
		System.out.println(alunosEmLista);
		
	}

}
