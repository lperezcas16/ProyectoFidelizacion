package co.edu.unbosque.model;

public class CedulaExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase CedulaExcepcion el cual esta vacio De esta
	 * manera este método cumple con la función de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validación de la cedula para que
	 * sea de tipo Int, para el registro.<br>
	 */
	public CedulaExcepcion() {

		super();

	}

	/**
	 * 
	 * Este es el constructor de la clase CedulaExcepcion el cual se le asigna la
	 * inicialización de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este método se llama automaticamente cuando se esta validando el
	 * proceso de la cedula en el registro del usuario. <b>post</b> Se debe hacer la
	 * validación de la cedula para que sea de tipo Int, para su correcto registro
	 * <br>
	 * 
	 * @param s es el atributo que tendrán el sistema para validar la cédula s !=
	 *          null, s != “ “
	 * 
	 */
	public CedulaExcepcion(String s) {

		super(s);

	}
}