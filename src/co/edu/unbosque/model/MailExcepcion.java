package co.edu.unbosque.model;

public class MailExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase MailExcepcion el cual esta vacio. De esta
	 * manera este método cumple con la función de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validación del correo ingresado
	 * por el usuario para enviar correctamente un correo de validacion.<br>
	 */
	public MailExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase MailExcepcion el cual se le asigna la
	 * inicialización de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este método se llama automaticamente cuando se esta validando el
	 * correo ingregaso por el usuario durante el proceso de registro del usuario.
	 * <b>post</b> Se debe hacer la validación del correo ingresado por el usuario
	 * para enviar correctamente un correo de validacion. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != “ “
	 * 
	 */
	public MailExcepcion(String mensaje) {
		super(mensaje);
	}

}
