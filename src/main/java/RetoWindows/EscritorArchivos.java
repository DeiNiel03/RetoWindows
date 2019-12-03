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
	public void escribirArchivoTXT(String nombreArchivo, int lineas, Scanner reader) {
		String path = "biblioteca" + File.separator + nombreArchivo; //archivoPrueba.txt
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path, true); // se pone true para escribir al final del archivo
            pw = new PrintWriter(fichero);
            System.out.println("Escribe las lineas");
            String linea = reader.nextLine();
            for (int i = 0; i < lineas; i++) {
            	linea = reader.nextLine();
            	pw.println(linea);
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
	
	public void escribirCSV(String nombreArchivo) {
		
	}
	
	public void escribirXML(String nombreArchivo) {
		
	}
}