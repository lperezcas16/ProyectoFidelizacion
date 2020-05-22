package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Parejas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int cupo;
	private double cantidad_cupo;
	private ArrayList<Horarios> lista_horarios;


	public Parejas(String nombre, int cupo, double cantidad_cupo,
			ArrayList<Horarios> lista_horarios) {
		this.nombre = nombre;
		this.cupo = cupo;
		this.cantidad_cupo = cantidad_cupo;
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


	@Override
	public String toString() {
		return "Nombre= " + nombre + " Cupo= " + cupo + " Cantidad de cupo= " + cantidad_cupo + " Lista  de compras= "
				+ lista_horarios;
	}

}
