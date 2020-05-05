package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

	private String numeroCedula;
	private String nombre;
	private String genero;
	private String correo;
	private String numeroTarjeta;
	private long cupoTargeta;
	private ArrayList<String> parejas;
	private String usuario;
	private String contraseña;
	private String tipo;

	public Usuario(String numerocedula, String nombre, String genero, String correo, String numeroTarjeta,
			long cupoTarjeta, ArrayList<String> parejas, String usuario, String contraseña) {
		this.numeroCedula = numerocedula;
		this.nombre = nombre;
		this.genero = genero;
		this.correo = correo;
		this.numeroTarjeta = numeroTarjeta;
		this.cupoTargeta = cupoTarjeta;
		this.usuario = usuario;
		this.contraseña = contraseña;
		parejas = new ArrayList<String>();
		this.parejas = parejas;
	}

	public Usuario(String nombre, String correo, String usuario, String contraseña) {
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
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

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public long getCupoTargeta() {
		return cupoTargeta;
	}

	public void setCupoTargeta(long cupoTargeta) {
		this.cupoTargeta = cupoTargeta;
	}

	public ArrayList<String> getParejas() {
		return parejas;
	}

	public void setParejas(ArrayList<String> parejas) {
		this.parejas = parejas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
