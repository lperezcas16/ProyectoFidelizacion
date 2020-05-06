package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class ArchivoTienda {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Tienda;

	public ArchivoTienda() {
		archivo_Tienda = new File(".\\data\\Base de Datos Tienda.dat");
	}

	/**
	 * Método que escribe los datos del usuario en el archivo
	 * 
	 * @param Lista
	 *            de usuarios
	 */
	public void escribirEnArchivo(ArrayList<Usuario> usuarios) {
		try {
			salida = new ObjectOutputStream(
					new FileOutputStream(archivo_Tienda));
			salida.writeObject(usuarios);
			salida.close();
		} catch (FileNotFoundException e) {
			System.out
					.println("Error en la escritura del archivo, no se encontro: "
							+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error en la escritura del archivo: "
					+ e.getMessage());
		}
	}

	/**
	 * Método que lee el archivo * @return Lista de usuarios
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> leerArchivo() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		if (archivo_Tienda.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(
						archivo_Tienda));
				usuarios = (ArrayList<Usuario>) entrada.readObject();
			} catch (FileNotFoundException e) {
				System.out
						.println("Error en la lectura del archivo, no se encontró: "
								+ e.getMessage());
			} catch (IOException e) {
				System.out.println("Error en la lectura del archivo: "
						+ e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out
						.println("Error en la lectura del archivo, clase no encontrada: "
								+ e.getMessage());
			}
		}
		return usuarios;
	}

	public void cargarArchivo(ArrayList<Usuario> usuarios) {

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
