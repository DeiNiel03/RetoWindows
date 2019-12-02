package RetoWindows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
}