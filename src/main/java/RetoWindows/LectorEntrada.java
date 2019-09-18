package RetoWindows;

import java.util.Scanner;
import java.util.regex.Pattern;


public class LectorEntrada {
	
	public String Lector(Scanner reader) {
		String entrada = "";
		Excepcion excepcion = new Excepcion();
		Boolean valida = false;
		
		while(valida == false) {
			try {
				System.out.println("Introduzca el nombre del fichero que quiere buscar:");
				entrada = reader.next();
				valida = Pattern.matches("[A-Za-z0-9]+", entrada);
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
}