package info.implementacionTableroConsola;


import info.intefaces.buscamina.ITablero;
import info.intefaces.buscamina.IUsuario;

public class UsuarioConsola implements IUsuario{
	private int minas;
	
	TableroConsola tc=new TableroConsola();
	
	


	@Override
	public void elegirCelda(String tablero[][], int tamanio) {
		
		int c, f, op=1, cantCeldasJugadas=0;
		minas=tc.getMinas();
		
		
		//Acá me va a volver a mostrar el tamaño del tablero
		//tamanio=tc.tamanioTablero();
		
		
		String tableroAux[][]=new String[tamanio][tamanio];
		
		
		cargarConAst(tableroAux, tamanio);
		
		
		ConsultasConsola cc=new ConsultasConsola();
		while(op==1 ){
			
				System.out.print("N° Columna de celda: ");
				c=cc.pedirNumeroConsola();
				
				System.out.print("N° Fila de celda: ");
				f=cc.pedirNumeroConsola();
				
				
				
				if(tablero[f][c]=="M"){
					tratarMinas(tablero, tableroAux,tamanio);
					op=0;
		
				}else {
					
					tratarNumeros(tablero, tamanio, f, c, tableroAux);
					System.out.print("Desea continuar 1-si 2-no ");
					op=cc.pedirNumeroConsola();
				
					cantCeldasJugadas++;
				}
				
			}
		}
	

	private void cargarConAst(String[][] tableroAux, int tamanio) {
		for(int i=0;i<tamanio; i++){
			for(int j=0; j<tamanio; j++){
				tableroAux[i][j]="*";
			}
		}
		
	}

	
	private void tratarNumeros(String tablero[][],int tamanio, int f, int c, String tA[][]) {
		for(int i=0; i< tamanio;i++){
			for(int j=0; j<tamanio; j++){
				
				if(i==f & c==j){
					System.out.print(tablero[f][c]);
					tA[i][j]=tablero[f][c];
	
				}else if(tablero[i][j]!=tA[i][j]){
				
					System.out.print(tA[i][j]);
				
				}else{
					System.out.print(tablero[i][j]);
				}
			}
			System.out.println("");
		}
		
		
	}

	/*private void tratarVacios() {
		
		
	}*/

	private void tratarMinas(String tablero[][], String tA[][], int tamanio) {
		
				
		for(int i=0; i<tamanio; i++){
			for(int j=0; j<tamanio; j++){
				
				if(tablero[i][j]=="M"){
					
					System.out.print(tablero[i][j]);
					tA[i][j]="M";
					
				}else if(tablero[i][j]!=tA[i][j]){
				
					System.out.print(tA[i][j]);
				
				}else{
					
					System.out.print(tablero[i][j]);
				}
			}
			System.out.println("");
		}
		System.out.println(":'( perdiste!!---NO TE RINDAS, INTENTALO DE NUEVO ");
		

	}

	@Override
	public void elegirContinuarConjuego() {
		
		
	}



	
}
