package RetoWindows;

import java.util.Scanner;
import java.util.regex.Pattern;


public class EntradaEstandar {
	
	String entrada = "";
	
	public Boolean ComprobarEntrada(LectorEntradaEstandar lectorEntrada, Scanner reader) {
		Excepcion excepcion = new Excepcion();
		Boolean valida = false;
		
		try {
			System.out.println("Introduzca el nombre del fichero que quiere buscar:");
			entrada = lectorEntrada.Lector(reader);
			valida = entrada.matches("[a-zA-Z0-9.]+");
			if(valida == true) {}
			else
				excepcion.ErrorEntrada();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return valida;
		}
		return valida;
	}
	
	public String DevolverEntrada() {
		return entrada;
	}
}