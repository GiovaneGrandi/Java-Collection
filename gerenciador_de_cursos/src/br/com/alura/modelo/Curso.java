package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {
	
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>(); //Criando o atributo que irá armazenar as aulas desse curso e já o iniciando, assim cada objeto terá a sua lista exclusiva para guardar suas aulas
	//É uma boa prática sempre ser mais genérico nas referencias de listas para que a polimorfia possa atuar, caso chamassemos uma "ArrayList" utilizando uma referencia do tipo exclusivo "ArrayList" nós não conseguiriamos mudar essa "ArrayList" de jeito nenhum, ela nasceria e morreria assim
	//Agora nós a declarando através de uma referencia do tipo mais genérico "List" podemos transformar essa "ArrayList" em uma "LinkedList" ou em outros tipos de listas, isso no fim irá ficar a cargo do programador que chamar essa lista, ele terá a opção de escolher como tratar o retorno que chegará nele e isso só trás pontos positivos
	//Dessa maneira nós "escondemos" o tipo da nossa lista, por ele ser apenas declarado aqui no atributo de "Curso", caso queiramos mudar o tipo da lista apenas precisamos vir aqui e muda-la para a lista que desejarmos, não nos deixando refém de algum tipo especifico de lista
	
	private Set<Aluno> alunos = new HashSet<>(); //Criando um conjunto que irá armazenar os alunos dentro do curso
	//Além do "HashSet" também existem outros tipos de conjuntos, como o "LinkedHashSet" que ao contrário do HashSet ele exibe os elementos na mesma ordem em que eles foram adicionados
	//Também existe o "TreeSet" porém para ele ser usado é necessário que a classe que ele irá guardar tenha um "Comparable" já que ele guarda os elementos pela ordem natural da classe, no seu construtor ele pode também receber um "Comparator", esse conjunto tem uma pesquisa mais rápida que as listas porém não tão rápidas como as do "HashSet"
	
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>(); //A assinatura de uma "Map" nesse caso se lê dessa forma "dado um inteiro devolva um aluno correspondente" o nome do atributo se dá justamente a isso, o Map recebe um numero de matricula e devolve o aluno correspondente aquele numero /O "HashMap" é um dos mapas mais usados no mundo Java
	//A pesquisa utilizando o "HashMap" é muito rápida porque assim como o "HashSet" ele utiliza a tabela de espalhamento, fazendo assim que cada numero de matricula de cada referencia do tipo aluno esteja guardada em um lugar único, assim quando for requisitado que seja buscado o numero do aluno "x" ele irá diretamente a gaveta que o aluno "x" está guardado
	//Também é comum caso exista um sistema de matriculas onde 2 alunos podem ter a mesma matricula ver um map que recebe uma key e também um set/list de alunos, é possível ver coleções dentro de outras, como uma lista de sets, um set de lists e por aí vai
	
	public Curso(String nome, String instrutor) { //Criando um construtor que pede o nome do curso e o instrutor como parametros, preferimos deixar as aulas de fora do construtor para fins mais didáticos
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas); //Utilizando um método da classe "Collections" (unmodifiableList) que serve para pegar a lista informada (no caso a de aulas) e devolver uma lista que não é modificavel, ela é feita apenas para ser visualizada, assim não será possível modificar a lista utilizando o "getAulas" (como por exemplo ".getAulas().add")
	}
	
	public void adiciona(Aula aula) { //Criando um método para adicionar aulas na lista da classe "Curso"
		this.aulas.add(aula); //Acessando o método "add" da "List" por de baixo dos panos
	}
	
	public int getTempoTotal() { //Criando um método que servirá para ver o tempo total das aulas do curso juntas
		int tempoTotal = 0; //Criando uma variavel que começa com seu valor em zero
		for (Aula aula : aulas) {
			tempoTotal += aula.getTempo(); //E fazendo um laço que diz "para cada "Aula" dentro de "aulas" você pega o "tempoTotal" soma por ele mesmo mais o resultado do "aula.getTempo()" assim ele irá nos mostrar qual é o tempo totais das aulas através dessa soma simples 
		}
		return tempoTotal; //Retornando o valor em int para o método
	}
	//Esse método poderia ser feito de várias outras formas, uma delas seria criar o atributo "tempoTotal" na classe "Curso" e fazer com que para cada aula nova adicionada ele já adicionasse a soma do novo tempo de aula ao tempo total
	//Ou também poderia ser feito a partir de técnicas do Java 8 que deixam alguns códigos mais comprimidos, nesse caso se faria uso dos métodos "stream", "mapToInt" e "sum" dos quais eu não aprendi ainda
	
	@Override
	public String toString() { //Implementando um "toString" para a classe "Curso" onde mostramos informações mais relevantes
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + " minutos" + "]"; //A gente poderia também mostrar as aulas presentes na lista desse curso, porém não é uma boa prática ficar concatenando muitas coisas em um "toString", para isso nós teríamos que chamar a lista de aulas dentro do "toString" e acabaria ficando gigante
	}
	
	public void matricula(Aluno aluno) { //Criando um método para adicionar os alunos no conjunto
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno); //No método de matricula além de adicionar o aluno ao conjunto nós vamos adicionar ele ao "Map" também, ele irá pegar o número desse aluno adicionado e relacionar a variavel desse aluno, toda vez que pedirmos esse numero de matricula ele devolverá a referencia desse mesmo aluno, assim facilitando em muito suas buscas
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos); //Deixando o conjunto de alunos do objeto curso ser imutável assim como a lista de aulas, dessa vez utilizando o "unmodifiableSet"
	}
	
	public boolean estaMatriculado(Aluno aluno) { //Fazendo um método que irá retornar se o aluno "x" está no conjunto de matriculas ou não
		return this.alunos.contains(aluno); //Aqui nós delegamos essa verificação para o método "contains" que existe em qualquer "Collection"
	}
	
//	public Aluno buscaMatricula(int numero) { //Criando um método que serviria como uma ferramente de busca de alunos matriculados através de um número de matricula
//		for (Aluno aluno : alunos) { //Aqui eu faço um "foreach" para executar com cada aluno
//			if(aluno.getNumeroMatricula() == numero) { //E então faço um if, se o número do aluno for igual ao passado na busca, me devolva o aluno
//				return aluno;
//			}
//		}
//		throw new NoSuchElementException("Matricula " + numero + " não encontrada!"); //Caso o if de cima dê false, ele lança uma exception
//	}
	//Esse método é funcional porém ele demoraria muito para conseguir achar o aluno, afinal os "Set" tem uma busca rápida para elementos e não atributos desses elementos que já demandaria mais processamento, por isso nesses casos é mais interessante delegar essa tarefa para a interface "Map"
	
	public Aluno buscaMatricula(int numero) { //Criando um novo método de busca de matricual porém dessa vez conectado ao "Map"
		if(!matriculaParaAluno.containsKey(numero)) { //Aqui criamos um if, caso o nosso map NÃO contenha a chave especificada ele irá executar o if assim lançando uma exception
			throw new NoSuchElementException();
		} //Caso a condição acima seja false ele irá retornar o resultado da busca normalmente
		return matriculaParaAluno.get(numero); //Nós apenas estamos pedindo para ao invocar esse método que ele retorne a busca feito pelo nosso map através do método próprio "get" que recebe o numero que colocamos como parametro na assinatura, assim delegando a tarefa para não termos que fazer aquele for e consumir ainda mais processamento, dessa maneira é tudo mais simples e rápido
	}

}
