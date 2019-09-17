package RetoWindows;

import java.util.Scanner;

public class LectorEntrada {
	
	public String Lector(Scanner reader) {
		String entrada;
		
		System.out.println("Introduzca el nombre del fichero que quiere buscar:");
		entrada = reader.next();
		return entrada;
	}
}