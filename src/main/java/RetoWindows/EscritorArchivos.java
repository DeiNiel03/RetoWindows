package RetoWindows;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscritorArchivos {
	
	/**
	 * Escribe el texto que se le pasa al archivo TXT cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return 
	 */	
	public void escribirArchivoTXT(String nombreArchivo) {
		String path = "biblioteca" + File.separator + nombreArchivo; //archivoPrueba.txt
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, true); // se pone true para escribir al final del archivo
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 10; i++) {
            	pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
	
	public String preguntarContinuar(String respuesta, Scanner reader) {
		System.out.println("¿Introducir otra linea?(Y/N)");
        respuesta = reader.next();
		while (respuesta.toUpperCase() != "Y" || respuesta.toUpperCase() != "N") {
			System.out.println("Respuesta no válida. Introduzca Y/y o N/n");
			System.out.println("¿Introducir otra linea?(Y/N)");
            respuesta = reader.next();
		}
		return respuesta;
	}
	
	public void escribirCSV(String nombreArchivo, Scanner reader) {
		String path = "biblioteca" + File.separator + nombreArchivo;
        FileWriter fichero = null;
        PrintWriter pw = null;
        String year, score, title, respuesta = "Y";
        try {
            fichero = new FileWriter(path, true); // se pone true para escribir al final del archivo
            pw = new PrintWriter(fichero);
            while(respuesta.toUpperCase() == "Y") {
            	// pide los datos de una linea
                System.out.println("Introduce el año:");
                year = reader.next();
                System.out.println("Introduce la puntuacion:");
                score = reader.next();
                System.out.println("Introduce el titulo:");
                title = reader.next();
                // escribe una linea
                pw.println(year + ", " + score + ", " + "\"" + title + "\"");
                // preguntar continuar
                respuesta = preguntarContinuar(respuesta, reader);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public void escribirXML(String nombreArchivo) {
		
	}
}