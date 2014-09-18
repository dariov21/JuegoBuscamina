package info.ejecucion;

import java.util.Scanner;

import info.factory.FactoryElegirTipoJuego;
import info.implementacion.consola.TableroConsola;
import info.interfaces.IMenuUsuario;
import info.interfaces.ITablero;

public class JugarBuscamina {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		ITablero t= FactoryElegirTipoJuego.getITablero(args[0]);
		IMenuUsuario mu=FactoryElegirTipoJuego.getIMenuUsuario(args[0]); 
		
		
		t.cargarTablero();
		mu.elegirCelda(t);
		
		
		
		

	}

}
