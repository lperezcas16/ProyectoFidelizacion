package co.edu.unbosque.model;

import java.io.Serializable;

public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pareja;
	private String tienda;
	private double valorCompra;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo registro de compra.<br>
	 * 
	 * @param pareja      Hace referencia al nombre de la pareja con la que el
	 *                    usuario realizó la compra, valor usado en primera
	 *                    instancia para la inicializacion del atributo. pareja !=
	 *                    null, pareja != "".
	 * @param tienda      Hace referencia a la tienda donde se realizó la compra,
	 *                    valor usado en primera instancia para la inicializacion
	 *                    del atributo. tienda != null, tienda != "".
	 * @param valorCompra Es el valor total gastado en la compra, valor usado en
	 *                    primera instancia para la inicializacion del atributo.
	 *                    valorCompra != null, valorCompra != "".
	 */
	public Compra(String pareja, String tienda, double valorCompra) {
		this.pareja = pareja;
		this.tienda = tienda;
		this.valorCompra = valorCompra;
	}

	/**
	 * Este metodo devuelve el valor del atributo nombre de la pareja. <b>post</b>Se
	 * devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el nombre de la pareja en formato de cadena de caracteres.
	 */
	public String getPareja() {
		return pareja;
	}

	/**
	 * Este metodo establece el valor del nombre de la pareja. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pareja Este parametro representa el nuevo valor en formato de cadena
	 *               de caracteres que va a tener el nombre de la pareja. pareja !=
	 *               null, pareja != "".
	 */
	public void setPareja(String pareja) {
		this.pareja = pareja;
	}

	/**
	 * Este metodo devuelve el valor del atributo del nombre de la tienda.
	 * <b>post</b>Se devuelve el valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el nombre de la tienda en formato de cadena de caracteres.
	 */
	public String getTienda() {
		return tienda;
	}

	/**
	 * Este metodo establece el valor del nombre de la tienda. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param tienda Este parametro representa el nuevo valor en formato de cadena
	 *               de caracteres que va a tener el nombre de la tienda. tienda !=
	 *               null, tienda != "".
	 */
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	/**
	 * Este metodo devuelve el valor de la compra. <b>post</b>Se devuelve el valor
	 * guardado en el atributo.<br>
	 * 
	 * @return Retorna la cantidad total de la compra en formato de double.
	 */
	public double getValorCompra() {
		return valorCompra;
	}

	/**
	 * Este metodo establece el valor total de la compra. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param valorCompra Este parametro representa el nuevo valor en formato double
	 *                    que va a tener el valor de la compra. valorCompra != null,
	 *                    valorCompra != "".
	 */
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	/**
	 * Este metodo devuelve la representacion del objecto en una cadena de
	 * caracteres.
	 */
	@Override
	public String toString() {
		return "Compra [pareja=" + pareja + ", tienda=" + tienda + ", valorCompra=" + valorCompra + "]";
	}

}
