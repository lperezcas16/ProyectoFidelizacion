package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Tiendas;

public class ArchivoTienda {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Tienda;

	/**
	 * Este es el constructor de la clase ArchivoTienda el cual tiene la funcion
	 * de verificar la existencia del archivo. <b>post</b> Se debe hacer la
	 * validación de que el archivo existe o no existe.<br>
	 * 
	 * @param archivo
	 *            El parametro corresponde al archivo del usuario. archivo !=
	 *            null, archivo != "".
	 */
	public ArchivoTienda(File archivo) {
		this.archivo_Tienda = archivo;
		if (!archivo_Tienda.exists()) {
			try {
				archivo_Tienda.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	/**
	 * Este metodo tiene la funcion de escribir el archivo mediante los
	 * parametros de la clase tiendas
	 * 
	 * @param lista_Tiendas
	 *            el atributo que tendrán el sistema para ingresar el arraylist
	 *            de la clase tiendas != null, usuario != “ “
	 * 
	 */
	public void escribirEnArchivo(ArrayList<Tiendas> lista_Tiendas) {

		try {
			salida = new ObjectOutputStream(
					new FileOutputStream(archivo_Tienda));
			salida.writeObject(lista_Tiendas);
			salida.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo tiene la funcion de leer el archivo mediante el arraylist de
	 * tiendas
	 * 
	 * @return El valor de retorno seria el arraylist que contiene los atributos
	 *         de la clase Tiendas
	 *
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Tiendas> leerArchivo() {

		ArrayList<Tiendas> listaTiendas = new ArrayList<Tiendas>();
		if (archivo_Tienda.length() != 0) {
			try {

				entrada = new ObjectInputStream(new FileInputStream(
						archivo_Tienda));
				listaTiendas = (ArrayList<Tiendas>) entrada.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return listaTiendas;
	}

	/**
	 * Este metodo devuelve en formato file el atributo archivo
	 * tienda.<b>post</b>Se devuelve el valor guardado en el atributo.
	 * 
	 * @return Retorna los datos guardados en el archivo correspondiente a las
	 *         tiendas.
	 */
	public File getArchivo_Tienda() {
		return archivo_Tienda;
	}

	/**
	 * Este metodo establece los datos pertenecientes al archivo de las tiendas.
	 * <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param archivo_Tienda
	 *            Este parametro representa el valor que tomara el archivo de
	 *            las tiendas.
	 */
	public void setArchivo_Tienda(File archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}

}