package RetoWindows;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		String entrada;
		Scanner reader = new Scanner(System.in);
		LectorEntrada lectorEntrada = new LectorEntrada();
		
		entrada = lectorEntrada.Lector(reader);
	}
}