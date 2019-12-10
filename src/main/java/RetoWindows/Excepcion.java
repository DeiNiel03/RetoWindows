package RetoWindows;

public class Excepcion extends Exception {
	
	public void errorEntrada() {
		throw new IllegalArgumentException("El texto de la busqueda debe ser unicamente alphanumerico, intentelo de nuevo.\n");
	}
}