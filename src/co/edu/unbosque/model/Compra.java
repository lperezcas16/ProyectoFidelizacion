package co.edu.unbosque.model;

public class Compra {
	private Parejas cliente;
	private Tiendas tienda;
	private String valorCompra;
	public Compra(Parejas cliente, Tiendas tienda, String valorCompra) {
		this.cliente = cliente;
		this.tienda = tienda;
		this.valorCompra = valorCompra;
	}
	@Override
	public String toString() {
		return "Compra [cliente=" + cliente + ", tienda=" + tienda + ", valor="
				+ valorCompra + "]";
	}
	public Parejas getCliente() {
		return cliente;
	}
	public void setCliente(Parejas cliente) {
		this.cliente = cliente;
	}
	public Tiendas getTienda() {
		return tienda;
	}
	public void setTienda(Tiendas tienda) {
		this.tienda = tienda;
	}
	public String getValor() {
		return valorCompra;
	}
	public void setValor(String valor) {
		this.valorCompra = valor;
	}

}
