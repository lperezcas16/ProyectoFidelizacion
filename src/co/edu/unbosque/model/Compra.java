package co.edu.unbosque.model;

public class Compra {
private Parejas cliente;
private Tiendas tienda;
private String valor;
public Compra(Parejas cliente, Tiendas tienda, String valor) {
	this.cliente = cliente;
	this.tienda = tienda;
	this.valor = valor;
}
@Override
public String toString() {
	return "Compra [cliente=" + cliente + ", tienda=" + tienda + ", valor="
			+ valor + "]";
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
	return valor;
}
public void setValor(String valor) {
	this.valor = valor;
}


}
