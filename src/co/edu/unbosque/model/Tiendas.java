package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 *
 */
public class Tiendas {

	private String nombre;
	private String direccion;
	private String horario;
	private ArrayList<Usuario> usuarios;

	public Tiendas(String nombre, String direccion, String horario,
			ArrayList<Usuario> usuarios) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.horario = horario;
		usuarios = new ArrayList<Usuario>();
		this.usuarios = usuarios;

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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
