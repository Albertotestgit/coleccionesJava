/*
4. A partir igualmente de un ArrayList con 20 valores aleatorios entre (0, 100):
       a) Ordenar la lista, mostrar su contenido,  
       b) guardar  de la lista los valores no repetidos mediante una  colección auxiliar de tipo TreeSet y muestra el contenido de esta.
       
        Comprobar que los valores no se repiten y que están ordenados.
*/
package ejeArrayList.eje04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class Eje04 {

	public static void main(String[] args) {
		  Random rd = new Random();	
	        
		  
		    ArrayList<Integer> lista = new ArrayList<Integer>();
		    
		    // Relleno con valores entre 0 y 100
		    for (int i = 1; i <=20; i++) {
		      lista.add(rd.nextInt(50));
		    }
		    
		    Collections.sort(lista);
		  
		    System.out.println(lista);
		    
		    TreeSet <Integer> conjunto = new TreeSet<Integer>(lista);
		    
		    System.out.println(conjunto);
		
	}

}
