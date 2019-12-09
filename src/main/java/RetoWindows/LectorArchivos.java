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

	public void leerCVSFormatoFilms(String nombreArchivo, ArrayList<String> res){

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
			root = "Root element: " + doc.getDocumentElement().getNodeName() + "\n";
			root += "----------------------------\n";
			NodeList nodeList = doc.getElementsByTagName("book");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				root += "Current Element: " + nNode.getNodeName() + "\n";
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					root += "Title: " + eElement.getElementsByTagName("author").item(0).getTextContent() + "\n";
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


	private String printNote2(NodeList nodeList) {
		String data = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).hasChildNodes()) {
				NodeList nodeList2 = nodeList.item(i).getChildNodes();
				for (int j = 0; j < nodeList2.getLength(); j++) {
					if (nodeList2.item(j).hasChildNodes()) {
						NodeList nodeList3 = nodeList2.item(j).getChildNodes();

						for (int count = 0; count < nodeList3.getLength(); count++) {
							Node tempNode = nodeList3.item(count);
							// make sure it's element node.
							if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
								// get node name and value
								data += tempNode.getNodeName() + ": "+ tempNode.getTextContent() + "\n";
								if (tempNode.hasAttributes()) {
									// get attributes names and values
									NamedNodeMap nodeMap = tempNode.getAttributes();
									for (int k = 0; k < nodeMap.getLength(); k++) {
										Node node = nodeMap.item(k);
										data += "attr name : " + node.getNodeName() + "\n";
										data += "attr value : " + node.getNodeValue() + "\n";
									}
								}
							}
						}
						data += "-------------------------------------\n";
					}
				}
			}
		}
		return data;
	}
	
	private String printNote3(NodeList nodeList) {
		String data = "";

		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).hasChildNodes()) {
				data = printNote3(nodeList.item(i).getChildNodes());
			} else {
				for (int count = 0; count < nodeList.getLength(); count++) {
					Node tempNode = nodeList.item(count);
					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
						data += tempNode.getNodeName() + ": "+ tempNode.getTextContent() + "\n";
						if (tempNode.hasAttributes()) {
							NamedNodeMap nodeMap = tempNode.getAttributes();
							for (int k = 0; k < nodeMap.getLength(); k++) {
								Node node = nodeMap.item(k);
								data += "attr name : " + node.getNodeName() + "\n";
								data += "attr value : " + node.getNodeValue() + "\n";
							}
						}
					}
				}
				
				data += "-------------------------------------\n";
			}

		}

		return data;
	}

	public String leerArchivoXML2(String nombreArchivo) {
		String data = "";
		String filePath = "biblioteca" + File.separator + nombreArchivo; //books.xml
		File xmlFile = new File(filePath);
		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			if (doc.hasChildNodes()) {
				NodeList nodeList = doc.getChildNodes();
				data = printNote3(nodeList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}