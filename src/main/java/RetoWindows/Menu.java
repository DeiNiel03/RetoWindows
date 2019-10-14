package RetoWindows;

import java.util.Scanner;

public class Menu {
	
	int option;
	LectorArchivos lectorArchivos;
	EscritorArchivos escritorArchivos;
	LectorEntradaEstandar lectorEntradaEstandar;
	
	public Menu(Scanner reader) {
		option = 0;
		lectorArchivos = new LectorArchivos();
		escritorArchivos = new EscritorArchivos();
		lectorEntradaEstandar = new LectorEntradaEstandar(reader);
		while (option != 5 ) {
			mostrarMenu();
		    option = reader.nextInt();
		    ejecutarOpcion(option);
		}
	}
	
	/**
	 * Muestra el menu de opciones
	 */
	public void mostrarMenu() {
	    System.out.println("SELECCIONA UNA OPCIÓN");
	    System.out.println("======================");
	    System.out.println("1 - Leer desde entrada estandar");
	    System.out.println("2 - Leer archivo TXT");
	    System.out.println("3 - Escribir archivo TXT");
	    System.out.println("4 - Leer archivo CSV");
	    System.out.println("5 - Leer archivo XML");
	    System.out.println("5 - Salir");
	    System.out.println();
	}
	
	/**
	 * Ejecuta la opcion seleccionada
	 * @param option
	 */
	public void ejecutarOpcion(int option) {
		switch (option) {
		    case 1:
				Boolean valida = false;
				while(valida == false) {
					valida = lectorEntradaEstandar.comprobarEntrada();
				}
				System.out.println(lectorEntradaEstandar.devolverEntrada());
				break;
		    case 2:
		    	System.out.println(lectorArchivos.leerArchivoTXT("archivoPrueba.txt"));
		    	break;
		    case 3:
		    	escritorArchivos.escribirArchivoTXT("archivoPrueba.txt");
		    	break;
		    case 4:
		    	System.out.println(lectorArchivos.leerArchivoCSV("films_score.csv"));
		    	break;
		    case 5:
		    	System.out.println(lectorArchivos.leerArchivoXML("books.xml"));
		    	break;
		    case 6:
		    	System.out.println("Salir");
		    	System.exit(0);
		    	break;
		    default:
		    	System.out.println("Selección invalida");
	    }
	}
}