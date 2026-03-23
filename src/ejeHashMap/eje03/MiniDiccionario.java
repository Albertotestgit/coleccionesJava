package ejeHashMap.eje03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MiniDiccionario {

	public static void main(String[] args) {

		var diccionario = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);

		// 10 Palabra
		diccionario.put("hola", "hello");
		diccionario.put("mesa", "table");
		diccionario.put("mientras", "while");
		diccionario.put("casa", "house");
		diccionario.put("sol", "sun");
		diccionario.put("luna", "moon");
		diccionario.put("ventana", "window");
		diccionario.put("lápiz", "pen");
		diccionario.put("ratón", "mouse");
		diccionario.put("abrir", "open");
		diccionario.put("cerrar", "close");
		diccionario.put("comer", "eat");
		diccionario.put("correr ", "run");
		diccionario.put("cantar ", "sing");
		diccionario.put("leer", "read");
		diccionario.put("escribir", "write");
		diccionario.put("tamaño", "size");
		diccionario.put("pantalla", "screen");
		diccionario.put("blanco", "white");
		diccionario.put("árbol", "tree ");

		System.out.println(" Seleccionado palabras...");
		ArrayList<String> seleccionadas = obtenerPalabras(diccionario, 40);

		int puntos = 0;
		for (String palabra : seleccionadas) {
			System.out.println(" Palabra en Español:" + palabra);
			System.out.print(" Palabra en Inglés :");
			String palabraUsuario = sc.nextLine();
			if (diccionario.get(palabra).equalsIgnoreCase(palabraUsuario)) {
				System.out.println("Repuesta correcta");
				puntos++;
			} else {
				System.out.println("Respuesta incorrecta");
			}
		}
		System.out.println(" Total de punto =" + puntos);

	}

	private static ArrayList<String> obtenerPalabras(HashMap<String, String> diccionario, int numPalabras) {

		var listaEspañol = new ArrayList<String>(diccionario.keySet());
		var listaSeleccioanda = new ArrayList<String>();
		var rd = new Random();

		for (int i = 1; i <= numPalabras; i++) {
			boolean nueva = false;
			do {
				int posicion = rd.nextInt(listaEspañol.size());
				String palabra = listaEspañol.get(posicion);
				if (!listaSeleccioanda.contains(palabra)) {
					listaSeleccioanda.add(palabra);
					nueva = true;
				}
			} while (!nueva);
		}

		return listaSeleccioanda;
	}

	private static ArrayList<String> obtenerPalabras2(HashMap<String, String> diccionario, int numPalabras) {
		
		List <String> resu = new ArrayList<String>(diccionario.keySet());		
		// Barajeo
		Collections.shuffle(resu);
		// 
		resu = resu.subList(0, numPalabras);
		
		return new ArrayList <String>(resu);
	}
	
}








































