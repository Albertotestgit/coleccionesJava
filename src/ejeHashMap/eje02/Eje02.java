/**
 *  Implementa el control de acceso al área restringida de un programa.
 */
package ejeHashMap.eje02;

import java.util.HashMap;
import java.util.Scanner;

public class Eje02 {

	public static void main(String[] args) {
	    var datuser = new HashMap<String, String>();
        
		// Clave login, valor password
		datuser.put("root", "root");
		datuser.put("alumno", "alumno1");
		datuser.put("admin", "12345");
		datuser.put("master", "12345");

		String login;
		String passwd;
		String passwd_store;
		Scanner sc = new Scanner(System.in);
	
		
		
		boolean accesoConcedido = false;
		int intentos = 0;
		do {
			// Recupera la clave del almacenada
			System.out.print("Login:");
			login = sc.nextLine();
			System.out.print("Password:");
			passwd = sc.nextLine();
			passwd_store = datuser.get(login);
			if (passwd_store != null && passwd_store.equals(passwd)) {
				accesoConcedido = true;
			} else {
				System.out.println(" Usuario y clave incorrectos");
				intentos++;
			}
		} while (intentos < 3 && !accesoConcedido);
		
		if ( accesoConcedido ) {
			System.out.println(" Bienvenido al sistema");
		} else {
			System.out.println(" Superado el nº máximo de intentos");
		}

	}
}
