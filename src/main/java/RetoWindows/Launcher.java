package RetoWindows;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		int option;
		String entrada;
		Scanner reader = new Scanner(System.in);
		LectorArchivos lectorArchivos = new LectorArchivos();
		
		// muestra el menu de opciones
	    System.out.println("SELECCIONA UNA OPCIÓN");
	    System.out.println("1 - Leer desde entrada estandar");
	    System.out.println("2 - Leer desde archivo");
	    System.out.println();
	    
	    // recoge la opcion seleccionada
	    option = reader.nextInt();

	    // Switch construct
	    switch (option) {
	    case 1:
			LectorEntrada lectorEntrada = new LectorEntrada();
			entrada = lectorEntrada.Lector(reader);
			System.out.println(entrada);
	      break;
	    case 2:
	    	System.out.println(lectorArchivos.leerArchivoTXT("archivoPrueba.txt"));
	      break;
	    default:
	      System.out.println("Selección invalida");
	    }
	    
	    reader.close();
		
	}
	
	
}