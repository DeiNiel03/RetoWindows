package RetoWindows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opencsv.CSVReader;

public class LectorArchivos {

	/**
	 * Devuelve el contenido del archivo TXT cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivoTXT(String nombreArchivo) {
		String path = "biblioteca" + File.separator + nombreArchivo; //archivoPrueba.txt
		BufferedReader buffer = null;
		String resultado = "";
		try {
			buffer = new BufferedReader(new FileReader(path));
			String linea = "";
			while ((linea = buffer.readLine()) != null) {
				resultado = resultado+linea +"\n";					
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return resultado;
	}

	/**
	 * Devuelve el contenido del archivo CSV cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public ArrayList<String> leerArchivoCSV(String nombreArchivo) {
		CSVReader reader = null;
		ArrayList<String> resultado = new ArrayList<String>();
		String path = "biblioteca" + File.separator + nombreArchivo; //films_score.csv
		try {
			reader = new CSVReader(new FileReader(path));
			String[] nextLine = null;
			while ((nextLine = reader.readNext()) != null) {
				resultado.add(Arrays.toString(nextLine));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}
		int largo = resultado.size();
		resultado.remove(largo - 1);
		return resultado;
	}

	public void leerCSVFormatoFilms(String nombreArchivo, ArrayList<String> res){

		String path = "biblioteca" + File.separator + nombreArchivo;
		FileWriter writer = null; 


		try {

			writer = new FileWriter(path); 
			for(String str: res) {
				writer.write(str + System.lineSeparator());

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Devuelve el contenido del archivo XML cuyo nombre se le pasa por parametro
	 * @param nombreArchivo
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivoXML(String nombreArchivo) {	
		String filePath = "biblioteca" + File.separator + nombreArchivo; //books.xml
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		String root = "";
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("book");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					root += "Author: " + eElement.getElementsByTagName("author").item(0).getTextContent() + "\n";
					root += "Title: " + eElement.getElementsByTagName("title").item(0).getTextContent() + "\n";
					root += "Genre: " + eElement.getElementsByTagName("genre").item(0).getTextContent() + "\n";
					root += "Price: " + eElement.getElementsByTagName("price").item(0).getTextContent() + "\n";
					root += "Publish Date: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent() + "\n";
					root += "Description: " + eElement.getElementsByTagName("description").item(0).getTextContent() + "\n";
					root += "----------------------------\n";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}

}