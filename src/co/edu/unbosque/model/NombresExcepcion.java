package co.edu.unbosque.model;

public class NombresExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase NombresExcepcion el cual esta vacio De
	 * esta manera este m�todo cumple con la funci�n de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validaci�n del nombre para que
	 * sea de tipo String.<br>
	 */
	public NombresExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase NombresExcepcion el cual se le asigna la
	 * inicializaci�n de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este m�todo se llama automaticamente cuando se esta validando el
	 * proceso del nombre del usuario. <b>post</b> Se debe hacer la validaci�n del
	 * nombres para que sea de tipo String <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != � �
	 * 
	 */
	public NombresExcepcion(String mensaje) {
		super(mensaje);
	}

}
