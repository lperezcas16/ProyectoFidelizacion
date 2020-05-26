package co.edu.unbosque.model;

import java.io.Serializable;

public class Tiendas implements Serializable {

	private static final long serialVersionUID = -1633332112137572466L;
	private String nombre;
	private String direccion;
	private String horario_apertura;
	private String horario_cierre;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre           Hace referencia al nombre de la tienda. nombre !=
	 *                         null, nombre != "".
	 * @param direccion        Hace referencia a la direccion que tiene la tienda.
	 *                         direccion != null, direccion != "".
	 * @param horario_apertura Hace referencia a la hora de apertura de la tienda.
	 *                         horario_apertura != null, horario_apertura != "".
	 * @param horario_cierre   Hace referencia a la hora de cierre de la tienda.
	 *                         horario_cierre != null, horario_cierre != "".
	 */
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
