package co.edu.unbosque.model;

public class EdadExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase EdadExcepcion el cual esta vacio. De esta
	 * manera este m�todo cumple con la funci�n de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validaci�n de que la edad sea
	 * mayor o igual a 18. <br>
	 */
	public EdadExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase EdadExcepcion el cual se le asigna la
	 * inicializaci�n de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este m�todo se llama automaticamente cuando se esta validando la
	 * seleccion de un genero para el proceso de registro del usuario. <b>post</b>
	 * Se debe hacer la validaci�n de que la edad sea mayor o igual a 18. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != � �
	 * 
	 */
	public EdadExcepcion(String mensaje) {
		super(mensaje);
	}
}
