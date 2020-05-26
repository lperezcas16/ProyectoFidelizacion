package co.edu.unbosque.model;

import java.io.Serializable;

/**
 *
 */
public class Tiendas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1633332112137572466L;
	private String nombre;
	private String direccion;
	private String horario_apertura;
	private String horario_cierre;

	public Tiendas(String nombre, String direccion, String horario_apertura, String horario_cierre) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.horario_apertura = horario_apertura;
		this.horario_cierre = horario_cierre;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario_apertura() {
		return horario_apertura;
	}

	public void setHorario_apertura(String horario_apertura) {
		this.horario_apertura = horario_apertura;
	}

	public String getHorario_cierre() {
		return horario_cierre;
	}

	public void setHorario_cierre(String horario_cierre) {
		this.horario_cierre = horario_cierre;
	}

	@Override
	public String toString() {
		return "Nombre= " + nombre + " Direccion= " + direccion + " Horario  de apertura= " + horario_apertura
				+ " Horario de cierre= " + horario_cierre;
	}

}
