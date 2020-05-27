package co.edu.unbosque.model;

import java.io.Serializable;

public class Horarios implements Serializable {

	private static final long serialVersionUID = 2683151777163081395L;
	private Tiendas tienda;
	private String fecha;
	private String hora;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param tienda Hace referencia a la tienda donde se realizó la compra, valor
	 *               usado en primera instancia para la inicializacion del atributo.
	 *               tienda != null, tienda != "".
	 * @param fecha  Hace referencia a la fecha del nuevo horario registrado. fecha
	 *               != null, fecha != "".
	 * @param hora   Hace referencia a la hora del nuevo horario registrado. hora !=
	 *               null, hora != "".
	 */
	public Horarios(Tiendas tienda, String fecha, String hora) {
		this.tienda = tienda;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Tiendas getTienda() {
		return tienda;
	}

	/**
	 * Este metodo establece los valores de un objeto tienda. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param tienda Este parametro representa el nuevo valor en formato tienda del
	 *               atributo. tienda != null, tienda != "".
	 */
	public void setTienda(Tiendas tienda) {
		this.tienda = tienda;
	}

	/**
	 * Este metodo devuelve el valor del atributo fecha. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la fecha en formato de cadena de caracteres.
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Este metodo establece el valor de la fecha. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param fecha Este parametro representa el nuevo valor en formato de cadena de
	 *              caracteres que va a tener la fecha. fecha != null, fecha != "".
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Este metodo devuelve el valor del atributo hora. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna la hora en formato de cadena de caracteres.
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Este metodo establece el valor de la hora. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param hora Este parametro representa el nuevo valor en formato de cadena de
	 *             caracteres que va a tener la hora. hora != null, hora != "".
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Este metodo devuelve la representacion del objecto en una cadena de
	 * caracteres.
	 */
	@Override
	public String toString() {
		return "Tienda=" + tienda + " Fecha= " + fecha + " Hora= " + hora;
	}

	/**
	 * Este metodo compara los horarios para que no hayan dos parejas con el mismo
	 * horario.<b>post</b>Se validaria que en el momento de crear un nuevo horario
	 * no se cruce con otro anteriormente establecido con otra pareja.
	 * 
	 * @param t Este parametro representa los horarios que ya estan registrados en
	 *          el sistema.
	 * @return Se retorna verdadero si ya existe el horario en el sistema y false si
	 *         es lo opuesto.
	 */
	public boolean compara(Horarios t) {
		boolean iguales = false;
		if (this.tienda.getNombre().equals(t.tienda.getNombre())
				&& this.tienda.getDireccion().equals(t.tienda.getDireccion())
				&& this.tienda.getHorario_apertura().compareTo(t.tienda.getHorario_apertura()) == 0
				&& this.tienda.getHorario_cierre().compareTo(t.tienda.getHorario_cierre()) == 0
				&& this.fecha.compareTo(t.fecha) == 0 && this.hora.compareTo(t.hora) == 0) {
			iguales = true;
		} else {
			iguales = false;
		}
		return iguales;
	}

}
