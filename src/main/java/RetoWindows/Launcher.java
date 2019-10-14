package RetoWindows;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		new Menu(reader);
	    reader.close();
	}
}