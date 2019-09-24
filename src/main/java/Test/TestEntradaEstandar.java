package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.Test;

import RetoWindows.EntradaEstandar;
import RetoWindows.LectorEntradaEstandar;

public class TestEntradaEstandar {

	Scanner reader = new Scanner(System.in);

	EntradaEstandar entradaEstandar = new EntradaEstandar();
	
	@Test
	public void testEntradaEstandar() {
		LectorEntradaEstandar lectorMock = mock(LectorEntradaEstandar.class);
		when(lectorMock.Lector(reader)).thenReturn("entrada");
		
		assertEquals(true, entradaEstandar.ComprobarEntrada(lectorMock, reader));
	}
	
	@Test
	public void testEntradaEstandar2() {
		LectorEntradaEstandar lectorMock = mock(LectorEntradaEstandar.class);
		when(lectorMock.Lector(reader)).thenReturn("entrada?'");
		
		assertEquals(false, entradaEstandar.ComprobarEntrada(lectorMock, reader));
	}
	
	@Test
	public void testMostrarEntrada() {
		
	}
}