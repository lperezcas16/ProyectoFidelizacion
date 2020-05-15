package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Parejas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int cupo;
	private ArrayList<Compras>lista_compras ;
	
	public Parejas(String nombre, int cupo, ArrayList<Compras> lista_compras) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.lista_compras = lista_compras;
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
	public ArrayList<Compras> getLista_compras() {
		return lista_compras;
	}
	public void setLista_compras(ArrayList<Compras> lista_compras) {
		this.lista_compras = lista_compras;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Parejas [nombre=" + nombre + ", cupo=" + cupo
				+ ", lista_compras=" + lista_compras + "]";
	}

	
}
