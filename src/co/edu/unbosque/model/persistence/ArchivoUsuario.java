package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class ArchivoUsuario {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Usuarios;
	private FileReader fr;
	private BufferedReader br;

	public ArchivoUsuario() {
		archivo_Usuarios = new File(".\\data\\Base de Datos Usuarios.dat");
	}

	/**
	 * Método que escribe los datos del usuario en el archivo
	 * 
	 * @param Lista
	 *            de usuarios
	 */
	public void escribirEnArchivo(ArrayList<Usuario> usuarios) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(
					archivo_Usuarios));
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
	public ArrayList<Usuario> leerArchivo() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		if (archivo_Usuarios.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(
						archivo_Usuarios));
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

	public File getArchivo_Usuarios() {
		return archivo_Usuarios;
	}

	public void setArchivo_Usuarios(File archivo_Usuarios) {
		this.archivo_Usuarios = archivo_Usuarios;
	}

}
