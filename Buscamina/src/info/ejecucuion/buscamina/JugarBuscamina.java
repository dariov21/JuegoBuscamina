package info.ejecucuion.buscamina;
import info.implementacionTableroConsola.MenuUsuario;
import info.intefaces.buscamina.ITablero;
import info.intefaces.buscamina.IUsuario;
import info.elegirEjecucion.FactoryTablero;
import info.elegirEjecucion.FactoryUsuario;

public class JugarBuscamina {

	
	public static void main(String[] args) {
		
		
		ITablero t= FactoryTablero.getITablero(args[0]);
		IUsuario u=FactoryUsuario.getIUsuario(args[0]);
		
		int var=t.tamanioTablero();
		
	
		String tablero[][]= new String[var][var];
		tablero=t.cargarTablero();
		
		t.dibujarTablero();
		
		u.elegirCelda(tablero,var);
	
		
		
	
		
		

	}
	

}
