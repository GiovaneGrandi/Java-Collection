package br.com.alura.modelo;

public class Aluno {
	
	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		if(nome == null) { //Criando um if que irá verificar se o nome recebido no construtor não é "null" para que mais na frente não exista problemas envolvendo isso, essa prática de tentar prever problemas e já programar pensando em suas soluções é chamada de "programação defensiva"
			throw new NullPointerException("Nome não pode ser null");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public String toString() { //Reescrevendo o método "toString" para deixar a saída da chamada da classa "Aluno" mais útil
		return "[Aluno: " + this.nome + ", matrícula: " + this.numeroMatricula + "]";
	}
	
	@Override
	public boolean equals(Object obj) { //Reescrevendo o método "equals" para poder definir corretamente o que faz um aluno ser igual ao outro /Caso esse método não seja sobreescrito e nós façamos uma busca nos conjuntos iremos ter um problema pois caso criemos dois alunos identicos eles não serão vistos pelo Java como semelhantes
		Aluno outroAluno = (Aluno) obj; //Fazendo um cast para afirmar para o compilador que a classe que ele irá receber é do tipo "Aluno" já que não podemos mudar na assinatura do método
		return this.nome.equals(outroAluno.nome); //Nesse caso decidimos por dizer que os alunos são iguais caso eles tenham o mesmo nome, então delegamos essa verificação para o método "equals" da "String" que já faz a comparação para ver se duas palavras são iguais ou não
	}
	
	@Override
	public int hashCode() { //Rescrevendo o método que define a regra para o identificador dos objetos no conjunto, é uma regra que se você resscreve o método "equals" é obrigado a também resscrever o "hashCode"
//		return this.nome.charAt(0); //Como a nossa identificação dos alunos se dá pelo nome a regra usada para os identificadores é que eles vão receber um identificador que é igual a letra inicial de seu nome, como o "char" é tecnicamente um tipo númerico ele consegue retornar um int aqui, já que ele pegará a letra inicial do nome do aluno e retornará o código "Unicode" dessa letra
		//Essa ainda é uma regra muito simples para um "hashCode" afinal todo mundo que tiver a inicial igual estará no mesmo canto e exigirá muitas comparações diminuindo a velocidade de processamento única do "Set" por isso o ideal seria fazer um laço que somaria todos os caracteres do nome para que só aqueles que tivessem as exatas mesmas letras ficassem no mesmo lugar
		return this.nome.hashCode();
		//E tem como fazer esse laço com essa conta maluca de uma maneira extremamente simples, a classe "String" já tem um método para definir um "hashCode" assim para as palavras, por isso nós precisamos apenas delegar e chamar o método "hashCode" do atributo nome que é uma "String" e deixar que ele faça esse trabalho para nós, assim poupando muito código
		//Assim como os getters e setters também é possível pedir para o eclipse criar os métodos equals e hashCode para você
	}

}
