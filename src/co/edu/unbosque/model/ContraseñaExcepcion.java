package co.edu.unbosque.model;

public class ContraseñaExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase ContraseñaExcepcion el cual esta vacio. De
	 * esta manera este método cumple con la función de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validación de la contraseña para
	 * que tenga una cantidad minima de caracteres.<br>
	 */
	public ContraseñaExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase ContraseñaExcepcion el cual se le asigna
	 * la inicialización de los atributos y objectos. De esta manera el objecto toma
	 * el valor. Este método se llama automaticamente cuando se esta validando el
	 * proceso de la contraseña en el proceso de registro del usuario. <b>post</b>
	 * Se debe hacer la validación de la contraseña para que tenga una cantidad
	 * minima de caracteres. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != “ “
	 * 
	 */
	public ContraseñaExcepcion(String mensaje) {
		super(mensaje);
	}

}
