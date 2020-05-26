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

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre        Es el nombre del usuario. nombre != null, nombre != "".
	 * @param genero        Es el genero del usuario ingresado al registrarse.
	 *                      genero != null, genero != "".
	 * @param correo        Es el correo ingresado por el usuario al registrarse.
	 *                      correo != null, correo != "".
	 * @param usuario       Es el usuario o alias ingresado en el registro. usuario
	 *                      != null, usuario != "".
	 * @param contraseña    Es la contraseña ingresada por el usuario en el
	 *                      registro. contraseña != null, contraseña != "".
	 * @param numeroTarjeta Es el numero de la tarjeta de credito asignada a cada
	 *                      usuario. numeroTarjeta != null, numeroTarjeta != "".
	 * @param edad          Es la edad calculada a partir de la fecha de nacimiento
	 *                      ingresada por el usuario. edad != null, edad != "".
	 * @param cupoTarjeta   Es el cupo de la tarjeta de credito agregado y escogido
	 *                      por el usuario. cupoTarjeta != null, cupoTarjeta != "".
	 * @param parejas       Es la lista de las parejas que cada usuario contiene y
	 *                      agrega. parejas != null, parejas != "";
	 * @param tipoUsuario   Este atributo diferencia a los usuarios del
	 *                      administrador para que de esa manera se pueda acceder a
	 *                      la interfaz grafica generada para cada uno. tipoUsuario
	 *                      != null, tipoUsuario != "".
	 * @param lista_compras Es la lista de todas las compras agregadas por el
	 *                      usuario. lista_compras != null, lista_compras != "".
	 */
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