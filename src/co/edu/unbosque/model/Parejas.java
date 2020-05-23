package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Parejas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int cupo;
	private double cantidad_cupo;
	private int edad;
	private ArrayList<Horarios> lista_horarios;

	public Parejas(String nombre, int cupo, double cantidad_cupo, int edad,
			ArrayList<Horarios> lista_horarios) {
		this.nombre = nombre;
		this.cupo = cupo;
		this.cantidad_cupo = cantidad_cupo;
		this.lista_horarios = lista_horarios;
		this.edad = edad;
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

	public double getCantidad_cupo() {
		return cantidad_cupo;
	}

	public void setCantidad_cupo(double cantidad_cupo) {
		this.cantidad_cupo = cantidad_cupo;
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

	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Parejas [nombre=" + nombre + ", cupo=" + cupo + ", cantidad_cupo=" + cantidad_cupo
				+ ", edad=" + edad + ", lista_horarios=" + lista_horarios
				+ "]";
	}

}
