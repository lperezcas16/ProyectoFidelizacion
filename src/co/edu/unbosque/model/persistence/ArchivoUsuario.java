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

import co.edu.unbosque.model.Usuario;

public class ArchivoUsuario {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Usuarios;

	/**
	 * Este es el constructor de la clase Archivo el cual tiene la funcion de
	 * verificar la existencia del archivo. <b>post</b> Se debe hacer la
	 * validación de que el archivo existe o no existe.<br>
	 */
	public ArchivoUsuario(File archivo) {
		this.archivo_Usuarios = archivo;
		if (!archivo_Usuarios.exists()) {
			try {
				archivo_Usuarios.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}

	}

	/**
	 * Este metodo tiene la funcion de escribir el archivo mediante los
	 * parametros de la clase usuario .
	 * 
	 * @param persona
	 *            el atributo que tendrán el sistema para ingresar el arraylist
	 *            de la clase usuario != null, persona != “ “
	 * 
	 */
	public void escribirEnArchivo(ArrayList<Usuario> lista_usuarios) {

		try {
			salida = new ObjectOutputStream(new FileOutputStream(
					archivo_Usuarios));
			salida.writeObject(lista_usuarios);
			salida.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo tiene la funcion de leer el archivo mediante el arraylist de
	 * usuario
	 * 
	 * @return El valor de retorno seria el arraylist que contiene los atributos
	 *         de la clase usuario
	 *
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> leerArchivo() {

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if (archivo_Usuarios.length() != 0) {
			try {

				entrada = new ObjectInputStream(new FileInputStream(
						archivo_Usuarios));
				listaUsuarios = (ArrayList<Usuario>) entrada.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return listaUsuarios;
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