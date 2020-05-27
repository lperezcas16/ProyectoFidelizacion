package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

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

	/**
	 * Este metodo devuelve el valor del atributo nombre. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el nombre en formato de cadena de caracteres.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo establece el valor del nombre. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor en formato de cadena
	 *               de caracteres que va a tener el nombre. nombre != null, nombre
	 *               != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo devuelve el valor del atributo genero. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el genero en formato de cadena de caracteres.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Este metodo establece el valor del genero. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param genero Este parametro representa el nuevo valor en formato de cadena
	 *               de caracteres que va a tener el genero. genero != null, genero
	 *               != "".
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Este metodo devuelve el valor del atributo correo. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el correo en formato de cadena de caracteres.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Este metodo establece el valor del correo. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param correo Este parametro representa el nuevo valor en formato de cadena
	 *               de caracteres que va a tener el correo.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Este metodo devuelve el valor del atributo usuario o alias. <b>post</b>Se
	 * devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el usuario o alias en formato de cadena de caracteres.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Este metodo establece el valor del usuario o alias. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param usuario Este parametro representa el nuevo valor en formato de cadena
	 *                de caracteres que va a tener el usuario. usuario != null,
	 *                usuario != "".
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Este metodo devuelve el valor del atributo contraseña. <b>post</b>Se devuelve
	 * el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la contraseña en formato de cadena de caracteres.
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Este metodo establece el valor de la contraseña. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param contraseña Este parametro representa el nuevo valor en formato de
	 *                   cadena de caracteres que va a tener la contraseña.
	 *                   contraseña != null, contraseña != "".
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * Este metodo devuelve el valor del atributo del numero de la tarjeta de
	 * credito. <b>post</b>Se devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el numero de la tarjeta de credito en formato de cadena de
	 *         caracteres.
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * Este metodo establece el valor del numero de tarjeta de credito.
	 * <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param numeroTarjeta Este parametro representa el nuevo valor en formato de
	 *                      cadena de caracteres que va a tener el numero de la
	 *                      tarjeta de credito. numeroTarjeta != null, numeroTarjeta
	 *                      != "".
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	/**
	 * Este metodo devuelve el valor del atributo edad. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la edad en formato de entero.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Este metodo establece el valor de la edad. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param edad Este parametro representa el nuevo valor en formato entero que va
	 *             a tener la edad. edad != null, edad != "".
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Este metodo devuelve el valor del atributo del cupo de la tarjeta de credito.
	 * <b>post</b>Se devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el cupo de la tarjeta de credito en formato long.
	 */
	public long getCupoTarjeta() {
		return cupoTarjeta;
	}

	/**
	 * Este metodo establece el valor del cupo de la tarjeta de credito.
	 * <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param cupoTarjeta Este parametro representa el nuevo valor en formato long
	 *                    de caracteres que va a tener el cupo de la tarjeta.
	 *                    cupoTarjeta != null, cupoTarjeta != "".
	 */
	public void setCupoTarjeta(long cupoTarjeta) {
		this.cupoTarjeta = cupoTarjeta;
	}

	/**
	 * Este metodo devuelve todos los valores guardados en la lista de parejas.
	 * <b>post</b>Se devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la lista de horarios en formato de arraylist.
	 */
	public ArrayList<Parejas> getParejas() {
		return parejas;
	}

	/**
	 * Este metodo establece todos los valores guardados en la lista de parejas.
	 * <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param parejas Este parametro representa el nuevo valor en formato de
	 *                arraylist que va a tener la lista de parejas. parejas != null,
	 *                parejas != "";
	 */
	public void setParejas(ArrayList<Parejas> parejas) {
		this.parejas = parejas;
	}

	/**
	 * Este metodo devuelve el valor del atributo tipo de usuario. <b>post</b>Se
	 * devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el tipo de usuario en formato de cadena de caracteres.
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * Este metodo establece el valor del tipo de usuario. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param tipoUsuario Este parametro representa el nuevo valor en formato de
	 *                    cadena de caracteres que va a tener el tipo de usuario.
	 *                    tipoUsuario != null, tipoUsuario != "".
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * Este metodo devuelve todos los valores guardados en la lista de compras.
	 * <b>post</b>Se devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la lista de compras en formato de arraylist.
	 */
	public ArrayList<Compra> getLista_compras() {
		return lista_compras;
	}

	/**
	 * Este metodo establece todos los valores guardados en la lista de compras.
	 * <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param lista_compras Este parametro representa el nuevo valor en formato de
	 *                      arraylist que va a tener la lista de compras.
	 *                      lista_compras != null, lista_compras != "".
	 */
	public void setLista_compras(ArrayList<Compra> lista_compras) {
		this.lista_compras = lista_compras;
	}

	/**
	 * Este metodo devuelve la representacion del objecto en una cadena de
	 * caracteres.
	 */
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", genero=" + genero + ", correo=" + correo + ", usuario=" + usuario
				+ ", contraseña=" + contraseña + ", numeroTarjeta=" + numeroTarjeta + ", edad=" + edad
				+ ", cupoTarjeta=" + cupoTarjeta + ", parejas=" + parejas + ", tipoUsuario=" + tipoUsuario
				+ ", lista_compras=" + lista_compras + "]";
	}

}