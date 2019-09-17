package RetoWindows;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LectorArchivos {
	
	/**
	 * Devuelve el contenido del archivo cuya ruta se le pasa por parametro
	 * @param ruta
	 * @return el contenido del archivo en forma de string
	 */
	public String leerArchivo(String nombreArchivo) {
		String path = System.getProperty("user.dir") + "\\" + nombreArchivo; //BasesLegales.txt
		FileReader fileReader = null;
		BufferedReader buffer = null;
		String resultado = "";
		try {
			fileReader = new FileReader(path);
			buffer = new BufferedReader(fileReader);
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

}