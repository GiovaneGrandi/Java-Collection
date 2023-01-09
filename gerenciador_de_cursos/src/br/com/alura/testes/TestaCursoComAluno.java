package br.com.alura.testes;

import java.util.Iterator;
import java.util.Set;

import br.com.alura.modelo.Aluno;
import br.com.alura.modelo.Aula;
import br.com.alura.modelo.Curso;

public class TestaCursoComAluno {
	
	public static void main(String[] args) {
		
        Curso javaColecoes = new Curso("Dominando as coleções do Java",
                "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
        
        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 56172);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);
        
        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);
        
        System.out.println("Todos os alunos matriculados: ");
        javaColecoes.getAlunos().forEach(aluno -> {System.out.println(aluno);}); //Fazendo um laço para mostrar todos os elementos presentes no conjunto utilizando o "Lambda"
        //Antes do Java 8 adicionar o foreach os programadores acessavam os itens de um conjunto dessa forma:
//        for(Aluno a : javaColecoes.getAlunos()) {
//        	System.out.println(a);
//        }
        
        //E existe uma forma ainda mais antiga de se fazer essas iterações, quando não existia o for antes do Java 5 se fazia assim:
        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterador = alunos.iterator(); //Toda coleção tem um método "iterator" porque ele é herdada da mãe de "Collection", a classe "Iterable"
        while(iterador.hasNext()) { //Esse while se lê da seguinte forma "enquanto o iterador ter um próximo item execute isso:"
        	Aluno proximo = iterador.next(); //O método "next" serve para ele devolver o próximo aluno do conjunto
        	System.out.println(proximo); //E aqui ele é mostrado no console
        } //É normal achar esse tipo de trecho de código em códigos mais antigos
        //Caso o iterator.next seja chamado novamente após o término do while, como não vai ter mais nenhum próximo elemento será retornado uma exceção "NoSuchElementException"
        
        System.out.println("O aluno: " + a1);
        System.out.println(javaColecoes.estaMatriculado(a1));

        Aluno turini = new Aluno("Rodrigo Turini", 34672); //Criando um aluno igual ao "a1"
        System.out.println("O a1 é equals ao Turini?");
        System.out.println(a1.equals(turini)); //Nesse caso usamos o método "equals" e funcionou, o Java interpretou esses dois alunos como iguais
        
//        System.out.println("E esse Turini, está matriculado?");
//        System.out.println(javaColecoes.estaMatriculado(turini)); //Porém na hora de buscar dois elementos iguais em um "Set" demonstra um dos problemas de se usar set, se fosse uma "List" o Java teria nos retornado "true", coisa que não aconteceu aqui, mas por que?
        //Os conjuntos usam um método organizaconal chamado de "tabela de espalhamento", eles pegam os elementos, definem um número para cada e então todos os objetos que tiverem o número "x" vão estar na gaveta do número "x" então ao pesquisar por um aluno ele não faz a busca em cada elemento, ele vai diretamente para a gaveta do número daquele aluno que está sendo buscado
        //Dito isso, por ele seguir a regra default para esses números ao criar um aluno identico novo ele recebe um número completamente diferente do outro aluno, por isso acontece a confusão
        
        System.out.println("E esse Turini, está matriculado?");
        System.out.println(javaColecoes.estaMatriculado(turini)); //Agora, após a implementação do "hashCode" na nossa classe o "Set" conseguiu comparar os dois elementos de maneira correta por eles terem a mesma inicial e ficarem na mesma "gaveta de dados"
		
        System.out.println(a1.hashCode() == turini.hashCode()); //Se os elementos forem iguais obrigatoriamente os seus identificadores (código de espalhamento) precisam ser iguais, nesse caso com o nosso método de "hashCode" os números dos dois alunos são iguais
        //Por isso é muito importante o relacionamento entre o "equals" e o "hashCode" o equals serve para definir "O que é considerado igual" para o Java e o HashCode serve para "Identificar como elementos iguais serão organizados" portanto mexer no equals sem mexer no hashCode irá gerar problemas no código, esses dois sempre precisam concordar um com o outro
        //SE DOIS ELEMENTOS FOREM EQUALS ELES *PRECISAM* TER O MESMO HASHCODE
	}

}
