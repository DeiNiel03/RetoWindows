package RetoWindows;

import java.util.Scanner;
import java.util.regex.Pattern;


public class EntradaEstandar {
	
	public String ComprobarEntrada(Scanner reader) {
		String entrada = "";
		Excepcion excepcion = new Excepcion();
		Boolean valida = false;
		
		while(valida == false) {
			try {
				System.out.println("Introduzca el nombre del fichero que quiere buscar:");
				entrada = Lector(reader);
				valida = entrada.matches("[a-zA-Z0-9.]+");
				if(valida == true) {}
				else
					throw new Excepcion();
			}
			catch(Exception e) {
				System.out.println(excepcion.ErrorEntrada());
				reader.nextLine();
			}
		}
		return entrada;
	}
	
	public String Lector(Scanner reader) {
		String entrada;
		
		entrada = reader.next();
		return entrada;
	}
}