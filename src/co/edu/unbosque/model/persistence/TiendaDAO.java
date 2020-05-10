package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Tiendas;

public class TiendaDAO {
	private ArchivoTienda archivo_Tienda;

	/**
	 * Metodo para poder llamar la clase Archivo mediante el parametro archivo
	 * 
	 * @param archivo_Tienda
	 *            el atributo que tendrán el sistema para llamar la clase
	 *            archivo archivo != null, archivo != “ “
	 */
	public TiendaDAO(ArchivoTienda archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}

	/**
	 * Este es el metodo agregarUsuario de la clase UsuarioDAO el cual se le
	 * asigna la inicialización de los atributos y objectos. De esta manera el
	 * objecto toma el valor. Este método se llama automaticamente cuando se
	 * esta validando el proceso inscripcion del usuario en el registro , para
	 * la creacion del arrayList. <b>post</b> Se debe hacer la creacion de los
	 * parametros para realizar el registro <br>
	 * 
	 * @param nombre
	 *            el atributo que tendrán el sistema para ingresar el nombre
	 * @param direccion
	 *            el atributo que tendrán el sistema para ingresar la direccion
	 * @param horario_apertura
	 *            el atributo que tendrán el sistema para ingresar el horario de
	 *            apertura
	 * @param horario_cierre
	 *            el atributo que tentra el sistema para ingresar el horario de
	 *            cierre
	 * 
	 * @return Boolean true si se agrego la tienda, false si no se agrego la
	 *         tienda
	 */
	public boolean agregarTienda(String nombre, String direccion,
			String horario_apertura, String horario_cierre,
			ArrayList<Tiendas> lista_tiendas) {
		Tiendas nuevo = new Tiendas(nombre, direccion, horario_apertura,
				horario_cierre);
		if (buscarTienda(nombre, lista_tiendas) == null) {
			lista_tiendas.add(nuevo);
			archivo_Tienda.escribirEnArchivo(lista_tiendas);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo EliminarTienda , eliminala tienda mediante elnonbre registrado y
	 * el arraylist de la clase tienda
	 * 
	 * @param nombre
	 *            el atributo que tendrá el sistema para validar la tienda
	 * @param lista_tiendas
	 *            el atributo que tendrá el sistema para llamar el arraylist
	 * @return si es puedo realizar la eliminación true o no se pudo realizar
	 *         false
	 */
	public boolean eliminarTienda(String nombre,
			ArrayList<Tiendas> lista_tiendas) {
		try {
			Tiendas e = buscarTienda(nombre, lista_tiendas);
			lista_tiendas.remove(e);
			archivo_Tienda.getArchivo_Tienda().delete();
			archivo_Tienda.getArchivo_Tienda().createNewFile();
			archivo_Tienda.escribirEnArchivo(lista_tiendas);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo buscarTienda, busca una tienda mediante el nombre en el arraylist.
	 * 
	 * @param nombre
	 *            el atributo que tendrán el sistema para validar la tienda
	 * @param lista_tiendas
	 *            el atributo que tendrán el sistema para llamar el arraylist de
	 *            tiendas
	 * @return si es encontrado o no encontrado en el sistema
	 */
	public Tiendas buscarTienda(String nombre, ArrayList<Tiendas> lista_tiendas) {
		Tiendas encontrado = null;

		if (!lista_tiendas.isEmpty()) {
			for (int i = 0; i < lista_tiendas.size(); i++) {
				if (lista_tiendas.get(i).getNombre().equals(nombre)) {
					encontrado = lista_tiendas.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Metodo para poder ver las tiendas registradas en el sistema
	 * 
	 * @param lista_tiendas
	 *            Lista de la cual se obtendra la informacion de las tiendas
	 * @return texto Cadena de texto con la informacion obtenida
	 */
	public String verTiendas(ArrayList<Tiendas> lista_tiendas) {
		String texto = "";
		for (int i = 0; i < lista_tiendas.size(); i++) {
			texto = lista_tiendas.toString();
		}
		return texto;
	}

	/**
	 * Metodo para poder ver una persona registrada en el sistema mediante la
	 * cedula
	 * 
	 * @param nombre
	 *            el atributo que tendrán el sistema para validar el nombre
	 * @param lista_tiendas
	 *            el atributo que tendrán el sistema para llamar el arraylist
	 *            tiendas
	 * @return texto cadena de texto con la informacion de la tienda
	 */
	public String verUnaTienda(String nombre, ArrayList<Tiendas> lista_tiendas) {
		String texto = "";
		texto = texto.concat(buscarTienda(nombre, lista_tiendas).toString());
		return texto;
	}

}
