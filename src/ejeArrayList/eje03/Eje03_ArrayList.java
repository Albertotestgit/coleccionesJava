package ejeArrayList.eje03;



/**
 *     3. Realiza un programa que introduzca valores aleatorios (entre 0 y 100)
 *     en un ArrayList y que luego realice las siguientes operaciones: 
 *     mostrar el contenido, calcular la suma, 
 *     borrar aquellos números que serán pares
 *     y volver a mostrar el contenido, 
 *     remplazar los números divisibles por 3 con el valor 0 y 
 *     volver a mostrar el contenido, por último, si aparece un valor divisible entre cinco, 
 *     insertar en la posición anterior el valor 555 y volver a mostrar el contenido.
       El tamaño de la lista también será aleatorio y 
       podrá oscilar entre 10 y 20 elementos ambos inclusive.
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Eje03_ArrayList
{
    public static void main(String[] args) {
    	
    Random rd = new Random();	
        
    int nelementos = (int)(Math.random() * 11 + 20);
    nelementos = rd.nextInt(10, 21);

    ArrayList<Integer> lista = new ArrayList<Integer>();
    
    // Relleno con valores entre 0 y 100
    for (int i = 0; i < nelementos; i++) {
      lista.add(rd.nextInt(101));
    }
    
    System.out.println(" Contenido :"+lista);
   
    int suma = 0;
    for(int valor : lista) {
      suma += valor;
    }
    System.out.println("La suma total es : " + suma);
    
    // Forma usando Stream
    // suma = lista.stream().reduce(0,Integer::sum);
    
    
    
    
    // ELIMINO LOS PARES
    // Uso un Iterator
   
    Iterator  <Integer>  it= lista.iterator();
    while (it.hasNext()){
        if (it.next() % 2 == 0){
            it.remove();
        }
    }
        
    // Otra forma mas rápida
    lista.removeIf( valor -> valor % 2 == 0);
        
    System.out.println("Lista generada sin pares: " + lista);
    
    // CAMBIO LOS DIVISIBLES POR 3
    /*
    for (int i = 0; i < lista.size(); i++){
        if ( lista.get(i) % 3 == 0){
            lista.set(i, 0);
        }
    }    
    */
    // Otra forma más rapida
    lista.replaceAll( x -> (x % 3 == 0) ? 0: x);
    System.out.println("Lista procesada : " + lista);
    
    
    /// INSERTAR 555 si hay divisible entre 5 
    
     for (int i = 0; i < lista.size(); i++){
         int valor = lista.get(i);
        if ( valor != 0 && valor % 5 == 0){
            lista.add(i, 555);
            i++; // !!!!!  He insertado debo saltar
        }
    }  
    
    System.out.println("Lista generada: " + lista);
   
   }
}