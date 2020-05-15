package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String genero;
	private String correo;
	private String usuario;
	private String contrase�a;
	private String numeroTarjeta;
	private long cupoTarjeta;
	private ArrayList<Parejas> parejas;
	private String tipoUsuario;

	public Usuario(String nombre, String genero, String correo, String usuario,
			String contrase�a, String numeroTarjeta, long cupoTarjeta,
			ArrayList<Parejas> parejas, String tipoUsuario) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.correo = correo;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.numeroTarjeta = numeroTarjeta;
		this.cupoTarjeta = cupoTarjeta;
		this.parejas = new ArrayList<Parejas>();
		this.parejas = parejas;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String nombre, String correo, String usuario,
			String contrase�a) {
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public long getCupoTarjeta() {
		return cupoTarjeta;
	}

	public void setCupoTarjeta(long cupoTarjeta) {
		this.cupoTarjeta = cupoTarjeta;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return " Nombre = " + nombre + " Genero = " + genero + " Correo = "
				+ correo + " Usuario = " + usuario + " Contrase�a = "
				+ contrase�a + " NumeroTarjeta = " + numeroTarjeta
				+ " CupoTarjeta = " + cupoTarjeta + " Parejas = " + parejas
				+ " TipoUsuario = " + tipoUsuario + "\n";
	}

	public ArrayList<Parejas> getParejas() {
		return parejas;
	}

	public void setParejas(ArrayList<Parejas> parejas) {
		this.parejas = parejas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
