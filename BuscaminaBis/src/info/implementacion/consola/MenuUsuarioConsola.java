package info.implementacion.consola;
import java.util.Scanner;

import info.interfaces.IMenuUsuario;
import info.interfaces.ITablero;


public class MenuUsuarioConsola implements IMenuUsuario {

	@Override
	public int elegirTablero() {
	
		int dim=0, op=1;
		Scanner sc = new Scanner(System.in);
		 
		do{ 
			
				System.out.println("Opciones de tama�os de tableros ");
				System.out.println(" 1- 8x8 (10 minas)  ");
				System.out.println(" 2- 10x10 (20 minas) ");
				System.out.print("Numero de opcion: ");
				op=sc.nextInt();
				
				switch(op){
				case 1: dim=8;
						break;
				case 2: dim=10;
						break;
				default: System.out.println("Error al ingresar opcion, eliga 1 o 2: ");
						 
						System.out.println("Desea intentarlo nuevamente 1-si / 2-no :");
						op=sc.nextInt();
					
				}
				
		 }while(op==1 & op==2);	
		return dim;		
	}

		
	

	@Override
	public void elegirCelda(ITablero tablero) {
		
		int f, c, op=1, cantCeldasJugadas=0;	
		int tamanio=tablero.devolverTamanio();
		int  celdasPorJugar=(tamanio*tamanio)-(tablero.devolverCantMinas());
		Scanner sc=new Scanner(System.in);
		
		
			
			while(op==1){
					System.out.print("N� fila de celda: ");
					f=sc.nextInt();
					
					System.out.print("N� columna de celda: ");
					c=sc.nextInt();
					

					if(f>7 | c>7){
						System.out.println("error de selección, debe seleccionar de 0 a 7");
						
					}else{
					
						op=TratarCeldaElegida(tablero, tamanio,f, c, op);
						tablero.dibujarTablero();
						cantCeldasJugadas++;
					
					}
					
					
					if(celdasPorJugar==cantCeldasJugadas){
						op=0;
					}
					
				}
		}
	
	
	
	public int TratarCeldaElegida(ITablero tablero, int tamanio,int f, int c, int op){
	   
				Celdas[][] tab=tablero.getTableroCargado();
	
	  
	  	
				if(tab[f][c].getValor()=="0"){
					tratarCeros(tab,tamanio, f, c);
					
					op=1;
		
				}else if(tab[f][c].getValor()=="M") {
					tratarMinas(tab,tamanio);
					
					op=0;			
				}else {
					tab[f][c].setEstado(tab[f][c].getValor());
					op=1;
				}
			return op;
				
			}
		
	

	

	private void tratarMinas(Celdas[][] tab,int tamanio) {
				
		for(int i=0; i<tamanio; i++){
			for(int j=0; j<tamanio; j++){
				
				if(tab[i][j].getValor()=="M"){
					tab[i][j].setEstado(tab[i][j].getValor());
													
				}
			}
		
		}
		System.out.println(":'( perdiste!!---NO TE RINDAS, INTENTALO DE NUEVO ");
				
	}


	
	


	private void tratarCeros(Celdas[][] tab,int tam,int f,int c){
       
		int f1=f,c2=c,tamF=0,tamC=0;
		
		
		if(f>0){
			f1=f-1;	
		}
		if(c>0){
			c2=c-1;
		}
		
		if(f!=tam-1){
			tamF=f+1;
		}else{
			tamF=f;
		}
		if(c!=tam-1){
			tamC=c+1;
		}else{
			tamC=c;
		}
		
		
		for(int i=f1; f<=tamF; i++){
			for(int j=c2; c<=tamC; j++){
				if(tab[i][j].getEstado()=="*"){
					tab[i][j].setEstado(tab[i][j].getValor());
				}
			}
		}
	}
}


