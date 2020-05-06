package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class TiendaDAO {
	private ArchivoTienda archivo_Tienda;

	public TiendaDAO(ArchivoTienda archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}

	public void buscarUsuario(String cedula, ArrayList<Usuario> clientes) {

	}

	public void eliminarUsuario(String cedula, ArrayList<Usuario> clientes) {

	}

	public void agregarUsuario(String cedula, ArrayList<Usuario> clientes) {

	}

	public ArchivoTienda getArchivo_Tienda() {
		return archivo_Tienda;
	}

	public void setArchivo_Tienda(ArchivoTienda archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}

}
