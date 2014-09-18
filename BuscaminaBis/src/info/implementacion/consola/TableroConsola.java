package info.implementacion.consola;

import info.interfaces.ITablero;


public class TableroConsola implements ITablero {
	
	private int tamanio;
	private int minas;
	private Celdas tableroCargado[][];
	
	MenuUsuarioConsola mu=new MenuUsuarioConsola(); 
	
	
	public TableroConsola() {
		this.tamanio=mu.elegirTablero();
		this.minas=0;
		this.tableroCargado=new Celdas[tamanio][tamanio];
		for(int i=0; i<tamanio;i++){
			for(int j=0;j<tamanio;j++){
				Celdas c= new Celdas();
				this.tableroCargado[i][j]=c;
			}
		}
		
	}
	
	
	@Override
	public Celdas[][] getTableroCargado() {
		return tableroCargado;
	}

	
	@Override
	public int devolverTamanio() {
		return tamanio;
	}
	@Override
	public int devolverCantMinas() {
		return minas;
		
	}
	

	@Override
	public void cargarTablero() {
		cargarMinas();
		cargarNumeros();
		
		
	}

	private void cargarMinas() {
		
		int column,fila;
		int resgC=0,resgF=0, m=0;	
		
		
		//determino 1er celda a cargar
				
		column= (int) (Math.random()*tamanio);
		fila=(int)(Math.random()*tamanio);
		
		if(tamanio==8){
			minas=10;
		
		}else if (tamanio==10){
			minas=20;
		}
		
		//controlo que las minas solo sean las determinasdas por el tamañio
		
		while(m<=minas){
				
			//controlo que no se repita la misma celda para cargar una mina.
		
			while(resgC==column & resgF==fila){
				
				column= (int) (Math.random()*(tamanio-1));
				fila=(int)(Math.random()*(tamanio-1));
				
			}
			
			try{
				
				this.tableroCargado[fila][column].setValor("M");
							
							
			}catch(Exception e){
		    	System.out.println("Tiene un erron en "+e);
		    
			}
			m++;
			
			resgC=column;
			resgF=fila;
			
			column= (int) (Math.random()*tamanio);
			fila=(int)(Math.random()*tamanio);
			
		}
		
		
	}
	
	
	private void cargarNumeros() {
		for(int i=0; i<tamanio;i++){
			for(int j=0; j<tamanio;j++){
				if(this.tableroCargado[i][j].getValor()!="M"){
					cargar( i, j);
				}
			}
		}
	}				

	private void cargar(int i, int j){
		int f1=i,c2=j,tamF=0,tamC=0, minas=0;
		
		
		if(i>0){
			f1=i-1;	
		}			
		if(j>0){
			c2=j-1;
		}
		if(i!=tamanio-1){
			tamF=i+1;
		}else{
			tamF=i;
		}
		if(j!=tamanio-1){
			tamC=j+1;
		}else{
			tamC=j;
		}
		
		
		for(int f=f1; f<=tamF; f++){
			for(int c=c2; c<=tamC; c++){
				if(this.tableroCargado[f][c].getValor()=="M"){
					minas++;
				}
			}
		}
		String v=Integer.toString(minas);
		
		this.tableroCargado[i][j].setValor(v);
		

	}
	

	@Override
	public void dibujarTablero() {
		for(int i=0; i<this.tamanio; i++){
			for(int j=0; j<this.tamanio;j++){
				System.out.print(this.tableroCargado[i][j].getEstado());
			}
			System.out.println("");
		}
		
	}
	
	
	
	

}
