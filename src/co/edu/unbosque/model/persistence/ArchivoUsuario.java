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

public class ArchivoUsuario {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo_Usuarios;

	/**
	 * Este es el constructor de la clase Archivo el cual tiene la funcion de
	 * verificar la existencia del archivo. <b>post</b> Se debe hacer la
	 * validación de que el archivo existe o no existe.<br>
	 * 
	 * @param archivo
	 *            El parametro corresponde al archivo del usuario. archivo !=
	 *            null, archivo != "".
	 */
	public ArchivoUsuario(File archivo) {
		this.archivo_Usuarios = archivo;
		if (!archivo_Usuarios.exists()) {
			try {
				archivo_Usuarios.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	/**
	 * Este metodo tiene la funcion de escribir el archivo mediante los
	 * parametros de la clase usuario .
	 * 
	 * @param lista_usuarios
	 *            El atributo que tendrán el sistema para ingresar el arraylist
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

	/**
	 * Este metodo devuelve en formato file el atributo archivo
	 * usuario.<b>post</b>Se devuelve el valor guardado en el atributo.
	 * 
	 * @return Retorna los datos guardados en el archivo correspondiente a los
	 *         usuarios inscritos.
	 */
	public File getArchivo_Usuarios() {
		return archivo_Usuarios;
	}

	/**
	 * Este metodo establece los datos pertenecientes al archivo de los
	 * usuarios. <b>post</b>Se fija un nuevo valor al atributo.<br>
	 * 
	 * @param archivo_Usuarios
	 *            Este parametro representa el valor que tomara el archivo de
	 *            los usuarios.
	 */
	public void setArchivo_Usuarios(File archivo_Usuarios) {
		this.archivo_Usuarios = archivo_Usuarios;
	}

}