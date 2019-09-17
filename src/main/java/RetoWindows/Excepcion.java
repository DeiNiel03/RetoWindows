package RetoWindows;

public class Excepcion extends Exception{
	
	public Excepcion() {
		
	}
	
	public String ErrorEntrada() {
		return "El texto de la bus queda deve ser unicamente alphanumerico, intentelo de nuevo";
	}
}