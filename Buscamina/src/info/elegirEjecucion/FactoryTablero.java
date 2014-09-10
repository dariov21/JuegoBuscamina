package info.elegirEjecucion;
import info.intefaces.buscamina.ITablero;
import info.implementacionTableroConsola.TableroConsola;

public class FactoryTablero {
	
	public static ITablero getITablero (String tipo){
	
		if(tipo.equalsIgnoreCase("consola")){
			return new TableroConsola();
			
		}
		return null;
	}

}
