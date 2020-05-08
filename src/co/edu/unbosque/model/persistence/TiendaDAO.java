package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;
//Hola
public class TiendaDAO {
	private ArchivoTienda archivo_Tienda;

	public TiendaDAO(ArchivoTienda archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}
	
	public String verTienda(ArrayList<Tiendas> tiendas) {
		String texto = "";
		for (int i = 0; i < tiendas.size(); i++) {
			texto = tiendas.toString();
		}
		return texto;
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
