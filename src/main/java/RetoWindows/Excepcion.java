package RetoWindows;

public class Excepcion extends Exception{
	
	public Excepcion() {
		
	}
	
	public String ErrorEntrada() {
		return "El texto de la busqueda debe ser unicamente alphanumerico, intentelo de nuevo";
	}
}