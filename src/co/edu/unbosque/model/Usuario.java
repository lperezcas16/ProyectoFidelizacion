package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String genero;
	private String correo;
	private String usuario;
	private String contraseña;
	private String numeroTarjeta;
	private int edad;
	private long cupoTarjeta;
	private ArrayList<Parejas> parejas;
	private String tipoUsuario;
	private ArrayList<Compra> lista_compras;

	public Usuario(String nombre, String genero, String correo, String usuario, String contraseña, String numeroTarjeta,
			int edad, long cupoTarjeta, ArrayList<Parejas> parejas, String tipoUsuario,
			ArrayList<Compra> lista_compras) {
		this.nombre = nombre;
		this.genero = genero;
		this.correo = correo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.numeroTarjeta = numeroTarjeta;
		this.edad = edad;
		this.cupoTarjeta = cupoTarjeta;
		this.parejas = parejas;
		this.tipoUsuario = tipoUsuario;
		this.lista_compras = lista_compras;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getCupoTarjeta() {
		return cupoTarjeta;
	}

	public void setCupoTarjeta(long cupoTarjeta) {
		this.cupoTarjeta = cupoTarjeta;
	}

	public ArrayList<Parejas> getParejas() {
		return parejas;
	}

	public void setParejas(ArrayList<Parejas> parejas) {
		this.parejas = parejas;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public ArrayList<Compra> getLista_compras() {
		return lista_compras;
	}

	public void setLista_compras(ArrayList<Compra> lista_compras) {
		this.lista_compras = lista_compras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", genero=" + genero + ", correo=" + correo + ", usuario=" + usuario
				+ ", contraseña=" + contraseña + ", numeroTarjeta=" + numeroTarjeta + ", edad=" + edad
				+ ", cupoTarjeta=" + cupoTarjeta + ", parejas=" + parejas + ", tipoUsuario=" + tipoUsuario
				+ ", lista_compras=" + lista_compras + "]";
	}

}