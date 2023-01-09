package br.com.alura.testes;

import java.util.*;

public class TesteEmptySet {

    public static void main(String[] args) {
    	
    	//Trecho de código tirado de um exercício da Alura para ilustrar a criação de um Set vazio:

        Set<String> nomes = Collections.emptySet(); //É possível criar um conjunto vazio 
        nomes.add("Paulo"); //Porém ao tentar adicionar algum elemento nele é retornado no console a exceção "UnsupportedOperationException", quando é criado um conjunto vazio ele está destinado a continuar vazio
        
        //Um conjunto vazio como esse pode acabar sendo útil em algumas situações, puxando para o nosso projeto de um gerenciador de cursos, caso um curso fosse cancelado ou deletado seria interessante retornar um conjunto vazio
    }

}