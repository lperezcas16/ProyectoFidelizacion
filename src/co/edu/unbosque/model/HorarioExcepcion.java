package co.edu.unbosque.model;

public class HorarioExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Este es el constructor de la clase HorarioExcepcion el cual esta vacio. De
	 * esta manera este método cumple con la función de hacer una sobrecarga de
	 * constructores. <b>post</b> Se debe hacer la validación de los horarios
	 * correspondientes a una tienda, para que el horario de apertura sea siempre
	 * antes del horario de cierre.<br>
	 */
	public HorarioExcepcion() {
		super();
	}

	/**
	 * 
	 * Este es el constructor de la clase HorarioExcepcion el cual se le asigna la
	 * inicialización de los atributos y objectos. De esta manera el objecto toma el
	 * valor. Este método se llama automaticamente cuando se esta validando el
	 * proceso de los horarios de apertura y cierre en el proceso de registro de una
	 * nueva tienda. <b>post</b> Se debe hacer la validación de los horarios
	 * correspondientes a una tienda, para que el horario de apertura sea siempre
	 * antes del horario de cierre. <br>
	 * 
	 * @param mensaje Este atributo corresponde al mensaje proporcionado si se
	 *                cumple la excepcion. mensaje != null, mensaje != “ “
	 * 
	 */
	public HorarioExcepcion(String mensaje) {
		super(mensaje);
	}

}
