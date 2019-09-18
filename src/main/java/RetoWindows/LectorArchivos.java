package RetoWindows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.xpath.XPathExpression;

import com.opencsv.CSVReader;

public class LectorArchivos {

	public static final char SEPARATOR=';';
	public static final char QUOTE='"';

	/**
	 * Devuelve el contenido del archivo TXT cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivoTXT(String nombreArchivo) {
		String path = System.getProperty("user.dir") + "\\" + nombreArchivo; //archivoPrueba.txt
		BufferedReader buffer = null;
		String resultado = "";
		try {
			buffer = new BufferedReader(new FileReader(path));
			String linea = "";

			while ((linea = buffer.readLine()) != null) {
				resultado=resultado+linea +"\n";					
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		return resultado;
	}

	/**
	 * Devuelve el contenido del archivo CSV cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivoCSV(String nombreArchivo) {

		CSVReader reader = null;
		String resultado = "";
		String path = System.getProperty("user.dir") + "\\" + nombreArchivo; //films_score.csv
		try {
			reader = new CSVReader(new FileReader(path));
			String[] nextLine=null;

			while ((nextLine = reader.readNext()) != null) {
				System.out.println(Arrays.toString(nextLine));
			}

		} catch (Exception e) {
			//Excepción que corresponda
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}

		return resultado;
	}
	
	/**
	 * Devuelve el contenido del archivo XML cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivoXML(String nombreArchivo) {
		
		String path = System.getProperty("user.dir") + "\\" + nombreArchivo; //books.xml
		String resultado = "";
		return resultado;
		
	}

}