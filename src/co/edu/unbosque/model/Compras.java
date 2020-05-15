package co.edu.unbosque.model;

import java.io.Serializable;

/**
 *
 */
public class Compras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre_tienda;
	private String hora;
	
	public Compras(String nombre_tienda, String hora) {
		super();
		this.nombre_tienda = nombre_tienda;
		this.hora = hora;
	}
	public String getNombre_tienda() {
		return nombre_tienda;
	}
	public void setNombre_tienda(String nombre_tienda) {
		this.nombre_tienda = nombre_tienda;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
