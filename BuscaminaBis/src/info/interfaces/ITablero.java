package info.interfaces;

import info.implementacion.consola.Celdas;

public interface ITablero {
		
	public void cargarTablero();
	public void dibujarTablero();
	public Celdas[][] getTableroCargado();
	public int devolverTamanio();
	public int devolverCantMinas();
	
	
	
	
	
}
