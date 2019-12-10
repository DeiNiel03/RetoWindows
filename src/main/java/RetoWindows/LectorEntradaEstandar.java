package RetoWindows;

import java.util.Scanner;

public class LectorEntradaEstandar {
	
	String entrada;
	Scanner reader;
	
	public LectorEntradaEstandar(Scanner reader) {
		this.reader = reader;
	}

	public String lector(String text) {
		System.out.println(text);
		String entrada = reader.next();
		return entrada;
	}
	
	public Boolean comprobarEntrada() {
		Excepcion excepcion = new Excepcion();
		Boolean valida = false;
		try {
			entrada = this.lector("Introduzca el nombre del fichero que quiere buscar:");
			valida = entrada.matches("[a-zA-Z0-9.]+");
			if(valida != true) {
				excepcion.errorEntrada();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return valida;
		}
		return valida;
	}
	
	public String devolverEntrada() {
		return entrada;
	}
}
