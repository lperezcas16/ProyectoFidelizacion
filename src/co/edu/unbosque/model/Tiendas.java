package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 *
 */
public class Tiendas {

	private String nombre;
	private String direccion;
	private String horario_apertura;
	private String horario_cierre;
	private ArrayList<Usuario> usuarios;

	public Tiendas(String nombre, String direccion, String horario_apertura, String horario_cierre,
			ArrayList<Usuario> usuarios) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		usuarios = new ArrayList<Usuario>();
		this.usuarios = usuarios;
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

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
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

}
