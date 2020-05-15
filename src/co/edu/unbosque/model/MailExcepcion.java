package co.edu.unbosque.model;

public class MailExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase MailExcepcion el cual esta vacio. De esta
	 * manera este m�todo cumple con la funci�n de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validaci�n del correo ingresado
	 * por el usuario para enviar correctamente un correo de validacion.<br>
	 */
	public MailExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase MailExcepcion el cual se le asigna la
	 * inicializaci�n de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este m�todo se llama automaticamente cuando se esta validando el
	 * correo ingregaso por el usuario durante el proceso de registro del usuario.
	 * <b>post</b> Se debe hacer la validaci�n del correo ingresado por el usuario
	 * para enviar correctamente un correo de validacion. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != � �
	 * 
	 */
	public MailExcepcion(String mensaje) {
		super(mensaje);
	}

}
