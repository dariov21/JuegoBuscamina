package info.factory;

import info.implementacion.consola.MenuUsuarioConsola;
import info.implementacion.consola.TableroConsola;
import info.interfaces.IMenuUsuario;
import info.interfaces.ITablero;


public class FactoryElegirTipoJuego {

	public static ITablero getITablero(String tipoTablero){
		
		if(tipoTablero.equalsIgnoreCase("consola")){
			return new TableroConsola();
		}
		
		return null;
		
		}
	public static IMenuUsuario getIMenuUsuario(String tipoMenu){
		
		if(tipoMenu.equalsIgnoreCase("consola")){
			return new MenuUsuarioConsola();
		}
		
		return null;
		
		}
	
}
