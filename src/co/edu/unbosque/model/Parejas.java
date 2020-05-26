package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Parejas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int cupo;
	private double cantidad_cupo_asignado;
	private double cantidad_cupo_restante;
	private int edad;
	private ArrayList<Horarios> lista_horarios;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre                 Hace referencia al nombre de la pareja
	 *                               registrada, valor usado en primera instancia
	 *                               para la inicializacion del atributo. nombre !=
	 *                               null, nombre != "".
	 * @param cupo                   Hace referencia a un porcentaje especifica del
	 *                               cupo que el usuario le asigna a cada pareja,
	 *                               valor usado en primera instancia para la
	 *                               inicializacion del atributo. cupo != null, cupo
	 *                               != "".
	 * @param cantidad_cupo_asignado Hace referencia a la cantidad total asignada a
	 *                               la pareja, valor usado en primera instancia
	 *                               para la inicializacion del atributo.
	 *                               cantidad_cupo_asignado != null,
	 *                               cantidad_cupo_asignado != "".
	 * @param cantidad_cupo_restante Hace referencia a la cantidad restante del cupo
	 *                               asignada a la pareja que va variando frente a
	 *                               las compras registradas a su nombre, valor
	 *                               usado en primera instancia para la
	 *                               inicializacion del atributo.
	 *                               cantidad_cupo_restante != null,
	 *                               cantidad_cupo_restante != "".
	 * @param edad                   Representa la edad de la pareja, valor usado en
	 *                               primera instancia para la inicializacion del
	 *                               atributo. edad != null, edad != "".
	 * @param lista_horarios         Representa una lista de todos los horarios
	 *                               registrados por el usuario con la pareja en
	 *                               especifico. lista_horarios != null,
	 *                               lista_horarios != "".
	 */
	public Parejas(String nombre, int cupo, double cantidad_cupo_asignado, double cantidad_cupo_restante, int edad,
			ArrayList<Horarios> lista_horarios) {
		this.nombre = nombre;
		this.cupo = cupo;
		this.cantidad_cupo_asignado = cantidad_cupo_asignado;
		this.cantidad_cupo_restante = cantidad_cupo_restante;
		this.edad = edad;
		this.lista_horarios = lista_horarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public double getCantidad_cupo_asignado() {
		return cantidad_cupo_asignado;
	}

	public void setCantidad_cupo_asignado(double cantidad_cupo_asignado) {
		this.cantidad_cupo_asignado = cantidad_cupo_asignado;
	}

	public double getCantidad_cupo_restante() {
		return cantidad_cupo_restante;
	}

	public void setCantidad_cupo_restante(double cantidad_cupo_restante) {
		this.cantidad_cupo_restante = cantidad_cupo_restante;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Horarios> getLista_horarios() {
		return lista_horarios;
	}

	public void setLista_horarios(ArrayList<Horarios> lista_horarios) {
		this.lista_horarios = lista_horarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Parejas [nombre=" + nombre + ", cupo=" + cupo + ", cantidad_cupo_asignado=" + cantidad_cupo_asignado
				+ ", cantidad_cupo_restante=" + cantidad_cupo_restante + ", edad=" + edad + ", lista_horarios="
				+ lista_horarios + "]";
	}

}