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

	public String getPareja() {
		return pareja;
	}

	public void setPareja(String pareja) {
		this.pareja = pareja;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	@Override
	public String toString() {
		return "Compra [pareja=" + pareja + ", tienda=" + tienda + ", valorCompra=" + valorCompra + "]";
	}

}
