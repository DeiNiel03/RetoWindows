package RetoWindows;

import java.util.Scanner;

public class Menu {
	
	String option, resultado;
	LectorArchivos lectorArchivos;
	EscritorArchivos escritorArchivos;
	LectorEntradaEstandar lectorEntradaEstandar;
	
	public Menu(Scanner reader) {
		lectorArchivos = new LectorArchivos();
		escritorArchivos = new EscritorArchivos();
		lectorEntradaEstandar = new LectorEntradaEstandar(reader);
		option = mostrarMenu(reader, option);
		ejecutarOpcion(option);
		while (option != "" ) {
			option = mostrarMenu(reader, option);
		    ejecutarOpcion(option);
		}
	}
	
	/**
	 * Muestra el menu de opciones
	 */
	public String mostrarMenu(Scanner reader, String option) {
	    System.out.println("SELECCIONA UNA OPCIÓN");
	    System.out.println("======================");
	    System.out.println("1 - Leer desde entrada estandar");
	    System.out.println("2 - Leer archivo TXT");
	    System.out.println("3 - Escribir archivo TXT");
	    System.out.println("4 - Leer archivo CSV");
	    System.out.println("5 - Escribir archivo CSV");
	    System.out.println("6 - Leer archivo XML");
	    System.out.println("7 - Escribir archivo XML");
	    System.out.println("8 - Salir");
	    System.out.println();
	    option = reader.next();
	    return option;
	}
	
	/**
	 * Ejecuta la opcion seleccionada
	 * @param option
	 */
	public void ejecutarOpcion(String option) {
		switch (option) {
		    case "1":
				Boolean valida = false;
				while(valida == false) {
					valida = lectorEntradaEstandar.comprobarEntrada();
				}
				resultado = lectorEntradaEstandar.devolverEntrada();
				System.out.println(resultado);
				break;
		    case "2":
		    	lectorArchivos.leerArchivoTXT("archivoPrueba.txt");
		    	System.out.println(resultado);
		    	break;
		    case "3":
		    	escritorArchivos.escribirArchivoTXT("archivoPrueba.txt");
		    	break;
		    case "4":
		    	resultado = lectorArchivos.leerArchivoTXT("archivoPrueba.txt");
		    	System.out.println(resultado);
		    	break;
		    case "5":
		    	// falta
		    	break;
		    case "6":
		    	resultado = lectorArchivos.leerArchivoXML("books.xml");
		    	System.out.println(resultado);
		    	break;
		    case "7":
		    	// falta
		    	break;
		    case "8":
		    	System.exit(0);
		    	break;
		    default:
		    	System.out.println("Selección invalida. Debe introducir un numero entre 1 y 6. \n");
	    }
	}
	
}