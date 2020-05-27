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
	 * Este es el metodo agregarTienda de la clase TiendaDAO el cual se le
	 * asigna la inicialización de los atributos y objectos. De esta manera el
	 * objecto toma el valor. Este método se llama automaticamente cuando el
	 * usuario realiza el proceso de inscripcion de la tienda , para la creacion
	 * del arrayList. <b>post</b> Se debe hacer la creacion de los parametros
	 * para realizar el registro <br>
	 * 
	 * @param nombre
	 *            el atributo que tendrán el sistema para ingresar el nombre.
	 *            nombre != null, nombre != "".
	 * @param direccion
	 *            el atributo que tendrán el sistema para ingresar la direccion.
	 *            direccion != null, direccion != "".
	 * @param horario_apertura
	 *            el atributo que tendrán el sistema para ingresar el horario de
	 *            apertura. horario_apertura != null, horario_apertura != "".
	 * @param horario_cierre
	 *            el atributo que tendra el sistema para ingresar el horario de
	 *            cierre. horario_cierre != null, horario_cierre != "".
	 * @param lista_tiendas
	 *            el atributo que tendra el sistema con la lista de las tiendas.
	 *            lista_tiendas != null, lista_tiendas != "".
	 * 
	 * @return boolean true si se agrego la tienda, false si no se agrego la
	 *         tienda
	 */
	public boolean agregarTienda(String nombre, String direccion,
			String horario_apertura, String horario_cierre,
			ArrayList<Tiendas> lista_tiendas) {
		Tiendas nuevo = new Tiendas(nombre, direccion, horario_apertura,
				horario_cierre);
		if (buscarTienda(direccion, lista_tiendas) == null) {
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
	 *            el atributo que tendrá el sistema para validar la tienda.
	 *            nombre != null, nombre != "".
	 * @param lista_tiendas
	 *            el atributo que tendrá el sistema para llamar el arraylist.
	 *            lista_tiendas != null, lista_tiendas != "".
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
	 * @param direccion
	 *            el atributo que tendrán el sistema para validar la tienda.
	 *            direccion != null, direccion != "".
	 * @param lista_tiendas
	 *            el atributo que tendrán el sistema para llamar el arraylist de
	 *            tiendas. lista_tiendas != null, lista_tiendas != "".
	 * @return si es encontrado o no encontrado en el sistema
	 */
	public Tiendas buscarTienda(String direccion,
			ArrayList<Tiendas> lista_tiendas) {
		Tiendas encontrado = null;

		if (!lista_tiendas.isEmpty()) {
			for (int i = 0; i < lista_tiendas.size(); i++) {
				if (lista_tiendas.get(i).getNombre()
						.equalsIgnoreCase(direccion)) {
					encontrado = lista_tiendas.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Metodo para poder ordenar ascendentemente la lista de tiendas.
	 * <b>pre</b>Debe de estar inscrito por lo menos dos tiendas para poder
	 * compararlas.<br>
	 * 
	 * @param tiendas
	 *            Este parametro hace referencia a la lista de todas las tiendas
	 *            inscritas hasta el momento junto con toda su informacion.
	 *            tiendas != null, tiendas != "".
	 */
	public void ordenTiendasAsc(ArrayList<Tiendas> tiendas) {

		Tiendas aux, menor;
		for (int i = 0; i < tiendas.size(); i++) {
			menor = tiendas.get(i);
			int pos = i;
			// Selecciona el menor
			for (int j = i + 1; j < tiendas.size(); j++) {
				if (tiendas.get(j).getNombre()
						.compareToIgnoreCase(menor.getNombre()) < 0) {
					menor = tiendas.get(j);
					pos = j;
				}
			}
			// intercambia
			aux = tiendas.get(i);
			tiendas.remove(i);
			tiendas.add(i, menor);
			tiendas.remove(pos);
			tiendas.add(pos, aux);
			// array.get(pos)=temp;
			try {
				archivo_Tienda.getArchivo_Tienda().delete();
				archivo_Tienda.getArchivo_Tienda().createNewFile();
				archivo_Tienda.escribirEnArchivo(tiendas);

			} catch (IOException e1) {
				e1.printStackTrace();

			}

		}
	}

}
