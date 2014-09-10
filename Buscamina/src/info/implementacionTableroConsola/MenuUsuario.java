package info.implementacionTableroConsola;

import java.util.Scanner;

public class MenuUsuario {
	
	
	private int dimensionTableroElegido(){
		int dim=0;
		
		 String op="si";
		 Scanner sc = new Scanner(System.in);
		
		 ConsultasConsola cc=new ConsultasConsola();
			
		 while(op.equalsIgnoreCase("si")){ 
			
				System.out.println("Opciones de tamaños de tableros ");
				System.out.println(" 1- 8x8 (10 minas)  ");
				System.out.println(" 2- 10x10 (64 minas) ");
				System.out.print("Numero de opcion: ");
				
				switch(cc.pedirNumeroConsola()){
				case 1:op="no"; dim=8;
						break;
				case 2: op="no";dim=10;
						break;
				default: System.out.println("Error al ingresar opcion: ");
						 
						System.out.println("Desea intentarlo nuevamente si / no :");
						op=sc.next();
					
				}
				
			}
		return dim;
		
	}

	
	public int getDimensionTablero(){
		return dimensionTableroElegido();
	}
	
}
