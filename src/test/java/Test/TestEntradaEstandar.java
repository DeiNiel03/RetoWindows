package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.Test;

import RetoWindows.LectorEntradaEstandar;

public class TestEntradaEstandar {

	Scanner reader = new Scanner(System.in);
	LectorEntradaEstandar entradaEstandar = new LectorEntradaEstandar(reader);
	
	@Test
	public void testEntradaEstandar() {
		LectorEntradaEstandar lectorMock = mock(LectorEntradaEstandar.class);
		when(lectorMock.lector("Introduzca el nombre del fichero que quiere buscar:")).thenReturn("entrada");
		assertEquals(true, entradaEstandar.comprobarEntrada());
	}
	
	@Test
	public void testEntradaEstandar2() {
		LectorEntradaEstandar lectorMock = mock(LectorEntradaEstandar.class);
		when(lectorMock.lector("Introduzca el nombre del fichero que quiere buscar:")).thenReturn("entrada?'");
		assertEquals(false, entradaEstandar.comprobarEntrada());
	}
	
}