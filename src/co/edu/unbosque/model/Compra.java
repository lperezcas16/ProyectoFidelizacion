package co.edu.unbosque.model;

import java.io.Serializable;

public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pareja;
	private String tienda;
	private double valorCompra;

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
		return "Compra [pareja=" + pareja + ", tienda=" + tienda
				+ ", valorCompra=" + valorCompra + "]";
	}

}
