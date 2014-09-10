package info.implementacionTableroConsola;

import info.intefaces.buscamina.ITablero;

import java.util.Random;
import java.util.Scanner;

//en esta implementacion del tablero las minas estan representadas por 9.

public class TableroConsola implements ITablero {
	
	private int tamanio;
	private String tablero[][];
	private String tableroEnBlanco[][];
	private int minas=0;

	public int getMinas() {
		minas=cargarMinas();
		return minas;
	}


	MenuUsuario mu=new MenuUsuario();
	// metodos para obtener los valores de las variables de clase
	
	
	
	public String[][] getTablero() {
		return tablero;
	}
	

	
	@Override
	public int tamanioTablero(){
		
		tamanio=mu.getDimensionTablero();
		return tamanio;
						 
		}
		
	@Override	
	public String[][] cargarTablero(){
		//variables de método.
		inicializarTablero();
		cargarMinas();
		cargarNumeros();
		return tablero;
		
	}

	
	@Override
	public String[][] dibujarTablero(){
		
		for(int i=0; i<tamanio;i++){
			for(int j=0; j<tamanio; j++){
				System.out.print(this.tableroEnBlanco[i][j]="*");
			}
		 System.out.println("");
		}
		return tableroEnBlanco;
	}
	
	/* Métodos de clase
	 * inicializa la matriz, coloca 0 en cada celda.
	 * metodo que realizara la cargar de los numeros al rededor de la mina.
	 * 
	 * */
	
		private void inicializarTablero(){
			this.tablero=new String[tamanio][tamanio];
			this.tableroEnBlanco=new String[tamanio][tamanio];
		}
		
		private int cargarMinas(){	
			//variables de métodos
			
			int column,fila;
			int resgC=0,resgF=0, m=0, cantMinas=0;	
			
			
			//determino 1er celda a cargar
					
			column= (int) (Math.random()*this.tamanio);
			fila=(int)(Math.random()*this.tamanio);
			
			
			if(this.tamanio==8){
				cantMinas=10;
			
			}else if (this.tamanio==10){
				cantMinas=20;
			}
			
			//controlo que las minas solo sean las determinasdas por el tamañio
			while(m <cantMinas){
					
				//controlo que no se repita la misma celda para cargar una mina.
				while(resgC==column & resgF==fila){
					column= (int) (Math.random()*this.tamanio);
					fila=(int)(Math.random()*this.tamanio);
					
				}
				resgC=column;
				resgF=fila;
				
				try{
					this.tablero[fila][column]="M";
					m++;
								
				}catch(Exception e){
			    	System.out.println("Tiene un erron en "+e);
			    
				}
				column= (int) (Math.random()*this.tamanio);
				fila=(int)(Math.random()*this.tamanio);
				
			}
			return m;
		}
		
		
		
		//métdodo que cargar las minas al tablero
		
			
		//metodo que realizara la cargar de los numeros al rededor de la mina
		private void cargarNumeros(){
			
			/*tomo una casilla si al rededor de ella en un rango de 8 hay minas las cuento
			 * y coloco un número de acuerdo a la cantidad de minas que conte
			 */
				for(int i=0; i<this.tamanio;i++){
					for(int j=0; j<this.tamanio;j++){
						if(this.tablero[i][j]!="M"){
							cargar(i,j);
						}
					}
				}
		}
		
		
		private void cargar(int i,int j){
		
			int f1=i,c2=j,tamF=0,tamC=0;
			
			if(i>0){
				f1=i-1;	
			}			
			if(j>0){
				c2=j-1;
			}
			if(i!=this.tamanio-1){
				tamF=i+1;
			}else{
				tamF=i;
			}
			if(j!=this.tamanio-1){
				tamC=j+1;
			}else{
				tamC=j;
			}
			
			
			for(int f=f1; f<=tamF; f++){
				for(int c=c2; c<=tamC; c++){
					if(this.tablero[f][c]=="M"){
						minas++;
					}
				}
			}
			String v=Integer.toString(minas);
			this.tablero[i][j]=v;
			minas=0;
		}
				
}
		
