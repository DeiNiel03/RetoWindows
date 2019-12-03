package RetoWindows;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dnl.utils.text.table.TextTable;

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
		
		// muestra el menu hasta que se eliga una opcion v�lida
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
	    System.out.println("SELECCIONA UNA OPCI�N");
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
		    	String archivo;
		    	int lineas;
		    	boolean continuar = true;
		    	
		    	System.out.println("Introduce el nombre del archivo en el que quieres escribir: ");
		    	archivo = reader.next();
		    	while(continuar) {
		    		try {
		    			System.out.println("Numero de lineas que quieres escribir: ");
		    			lineas = reader.nextInt();
		    			escritorArchivos.escribirArchivoTXT(archivo + ".txt", lineas, reader);
		    			continuar = false;
		    		} catch(InputMismatchException e) {
		    			System.out.println("Valor no valido");
		    			reader.nextLine();
		    		}
		    	}
		    	break;
		    case "4":
		    	ArrayList<String> resul = lectorArchivos.leerArchivoCSV("films_score.csv");
		    	mostrarCSV(resul);
		    	break;
		    case "5":
		    	escritorArchivos.escribirCSV("films_score.csv", reader);
		    	break;
		    case "6":
		    	resultado = lectorArchivos.leerArchivoXML("books.xml");
		    	System.out.println(resultado);
		    	break;
		    case "7":
		    	ArrayList<String> resultado = lectorArchivos.leerArchivoCSV("films_score.csv");
		    	lectorArchivos.leerCVSFormatoFilms("peliculasPruebacsv.txt", resultado);
		    	break;
		    case "8":
		    	resultado = lectorArchivos.leerArchivoXML3("books.xml");
		    	conversion.printTxt("pruebaXMLtoTXT.txt", resultado, "Libros");
		    	break;
		    case "9":
		    	System.exit(0);
		    	break;
		    default:
		    	System.out.println("Selecci�n invalida. Debe introducir un numero entre 1 y 6. \n");
	    }
	}
	
	private void mostrarCSV(ArrayList<String> contenido) {
		String[][] contenidoFormato;
		String[] titulos = null;
		String[] contenidoLinea = null;
		String linea = null;
		
		linea = contenido.get(0).replaceAll("[\\[\\]]", "");
		titulos = linea.split(",");
		contenido.remove(0);
		contenidoFormato = new String[titulos.length][contenido.size()];
		
		for(int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(0).replaceAll("[\\[\\]]", "");
			contenidoLinea = linea.split(",");
			for(int j = 0; j < titulos.length; i++) {
				contenidoFormato[j][i] = contenidoLinea[j];
			}
		}
		TextTable tt = new TextTable(titulos, contenidoFormato);
		tt.printTable();
	}
}