package RetoWindows;

import java.util.Scanner;

public class Menu {
	
	String option, resultado;
	LectorArchivos lectorArchivos;
	EscritorArchivos escritorArchivos;
	LectorEntradaEstandar lectorEntradaEstandar;
	Conversion conversion;
	
	public Menu(Scanner reader) {
		lectorArchivos = new LectorArchivos();
		escritorArchivos = new EscritorArchivos();
		lectorEntradaEstandar = new LectorEntradaEstandar(reader);
		conversion = new Conversion();
		
		// muestra el menu hasta que se eliga una opcion válida
		option = mostrarMenu(reader, option);
		ejecutarOpcion(reader, option);
		while (option != "" ) {
			option = mostrarMenu(reader, option);
		    ejecutarOpcion(reader, option);
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
	    System.out.println("8 - Convertir XML a TXT");
	    System.out.println("9 - Salir");
	    System.out.println();
	    option = reader.next();
	    return option;
	}
	
	/**
	 * Ejecuta la opcion seleccionada
	 * @param option
	 */
	public void ejecutarOpcion(Scanner reader, String option) {
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
		    	escritorArchivos.escribirCSV("films_score.csv", reader);
		    	break;
		    case "6":
		    	resultado = lectorArchivos.leerArchivoXML("books.xml");
		    	System.out.println(resultado);
		    	break;
		    case "7":
		    	// falta
		    	break;
		    case "8":
		    	resultado = lectorArchivos.leerArchivoXML3("books.xml");
		    	conversion.printTxt("pruebaXMLtoTXT.txt", resultado, "Libros");
		    	break;
		    case "9":
		    	System.exit(0);
		    	break;
		    default:
		    	System.out.println("Selección invalida. Debe introducir un numero entre 1 y 6. \n");
	    }
	}
	
}