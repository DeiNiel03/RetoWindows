package RetoWindows;

import java.util.Scanner;

public class Menu {
	
	public int Menu(Scanner reader) {
		
		int option;
		String entrada;
		LectorArchivos lectorArchivos = new LectorArchivos();
		
		// muestra el menu de opciones
	    System.out.println("SELECCIONA UNA OPCI�N");
	    System.out.println("1 - Leer desde entrada estandar");
	    System.out.println("2 - Leer desde archivo");
	    System.out.println();
	    
	    // recoge la opcion seleccionada
	    option = reader.nextInt();

	    // Switch construct
	    switch (option) {
	    case 1:
			EntradaEstandar lectorEntrada = new EntradaEstandar();
			entrada = lectorEntrada.ComprobarEntrada(reader);
			System.out.println(entrada);
	      break;
	    case 2:
	    	System.out.println(lectorArchivos.leerArchivoTXT("archivoPrueba.txt"));
	      break;
	    default:
	    	System.out.println("Selecci�n invalida");
	    }
		return 0;
	}
}