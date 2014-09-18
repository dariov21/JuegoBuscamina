package info.implementacion.consola;

public class Celdas {
	private String valor;
	private String estado;
	
	public Celdas() {
		this.valor = "0";
		this.estado ="*";
	}

	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
