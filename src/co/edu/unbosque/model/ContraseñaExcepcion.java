package co.edu.unbosque.model;

public class Contrase�aExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase Contrase�aExcepcion el cual esta vacio. De
	 * esta manera este m�todo cumple con la funci�n de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validaci�n de la contrase�a para
	 * que tenga una cantidad minima de caracteres.<br>
	 */
	public Contrase�aExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase Contrase�aExcepcion el cual se le asigna
	 * la inicializaci�n de los atributos y objectos. De esta manera el objecto toma
	 * el valor. Este m�todo se llama automaticamente cuando se esta validando el
	 * proceso de la contrase�a en el proceso de registro del usuario. <b>post</b>
	 * Se debe hacer la validaci�n de la contrase�a para que tenga una cantidad
	 * minima de caracteres. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != � �
	 * 
	 */
	public Contrase�aExcepcion(String mensaje) {
		super(mensaje);
	}

}
