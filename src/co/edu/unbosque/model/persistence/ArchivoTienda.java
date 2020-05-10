package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Tiendas;

//Hola
public class ArchivoTienda {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Tienda;

	/**
	 * Este es el constructor de la clase ArchivoTienda el cual tiene la funcion
	 * de verificar la existencia del archivo. <b>post</b> Se debe hacer la
	 * validación de que el archivo existe o no existe.<br>
	 */
	public ArchivoTienda() {
		archivo_Tienda = new File(".\\Base de Datos T.dat");
		if (!archivo_Tienda.exists()) {
			try {
				archivo_Tienda.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						"Advertencia", JOptionPane.WARNING_MESSAGE);
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

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public File getArchivo_Tienda() {
		return archivo_Tienda;
	}

	public void setArchivo_Tienda(File archivo_Tienda) {
		this.archivo_Tienda = archivo_Tienda;
	}

}