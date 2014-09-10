package info.elegirEjecucion;

import info.implementacionTableroConsola.UsuarioConsola;
import info.intefaces.buscamina.IUsuario;

public class FactoryUsuario {
	
	public static IUsuario getIUsuario(String tipo){
		
		if(tipo.equalsIgnoreCase("consola")){
			return new UsuarioConsola();
		}
		return null;
		
	}

}
