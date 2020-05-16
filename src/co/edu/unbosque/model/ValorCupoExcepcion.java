package co.edu.unbosque.model;

public class ValorCupoExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase ValorCupoExcepcion el cual esta vacio. De
	 * esta manera este método cumple con la función de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validación de que el valor del
	 * cupo ingresado contenga unicamente numeros. <br>
	 */
	public ValorCupoExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase MailExcepcion el cual se le asigna la
	 * inicialización de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este método se llama automaticamente cuando se esta validando la
	 * seleccion de un genero para el proceso de registro del usuario. <b>post</b>
	 * Se debe hacer la validación de que el valor del cupo ingresado contenga
	 * unicamente numeros. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != “ “
	 * 
	 */
	public ValorCupoExcepcion(String mensaje) {
		super(mensaje);
	}

}
