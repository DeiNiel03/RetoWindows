package RetoWindows;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Conversion {
	
	public void printTxt(String output, String data, String titulo) {
		FileWriter fichero = null;
		PrintWriter escritor = null;
		File ruta = new File("generados");
		if (!ruta.exists() || !ruta.isDirectory()) {
			ruta.mkdir();
		}
		try {
			fichero = new FileWriter(ruta + File.separator + output);
			escritor = new PrintWriter(fichero);
			escritor.println();
			escritor.println(titulo.toUpperCase());
			escritor.println("======================================================================");
			escritor.println();
			escritor.println(data);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				fichero.close();
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
		}
		
	}

}
