package br.com.alura.testes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestandoIterator {
	
    public static void main(String[] args) {
    	
    	//Usando como base um exercício da Alura para testar o funcionamento de um Iterator

        List<String> letras = new LinkedList<>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        //A tarefa é implementar uma maneira de chamar esses itens da lista usando a interface Iterator
        
        Iterator<String> iterador = letras.iterator(); //Criando um Iterator que guarda Strings e ele recebe o método iterator da lista
        while(iterador.hasNext()) { //Utilizando o while para que a cada próximo item disponível na lista ele execute o que está dentro das chaves /Na época em que se usava o Iteratos o for ainda não existia no Java
        	String proximaString = iterador.next(); //Guardando a próxima String disponível dentro de uma referencia, assim sempre que tiver uma próxima ela será guardada nessa referencia e exibida no sysout abaixo
        	System.out.println(proximaString);
        }
        
    }

}
