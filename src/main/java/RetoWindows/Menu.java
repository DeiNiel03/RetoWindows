package RetoWindows;

import java.util.Scanner;

public class Menu {
	
	public int Menu(Scanner reader) {
		
		int option;
		String entrada;
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
	    	LectorEntradaEstandar lector = new LectorEntradaEstandar();
			EntradaEstandar entradaEstandar = new EntradaEstandar();
			Boolean valida = false;
			
			while(valida == false) {
				valida = entradaEstandar.ComprobarEntrada(lector, reader);
			}
			System.out.println(entradaEstandar.DevolverEntrada());
	      break;
	    case 2:
//	    	System.out.println(lectorArchivos.leerArchivoTXT("archivoPrueba.txt"));
	    	System.out.println(lectorArchivos.leerArchivoCSV("films_score.csv"));
	      break;
	    default:
	    	System.out.println("Selección invalida");
	    }
		return 0;
	}
}