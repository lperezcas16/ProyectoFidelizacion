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
//Hola
public class ArchivoTienda {
		private ObjectInputStream entrada;
		private ObjectOutputStream salida;
		private File archivo_Tienda;



		/**
		 * Este es el constructor de la clase ArchivoUsuario el cual tiene la funcion de
		 * verificar la existencia del archivo. <b>post</b> Se debe hacer la validaci�n
		 * de que el archivo existe o no existe.<br>
		 */
		public ArchivoTienda() {
			archivo_Tienda = new File(".\\Base de Datos Usuarios.dat");
			if (archivo_Tienda.exists()) {
				System.out.println("El archivo ya existe");
			} else {
				try {
					archivo_Tienda.createNewFile();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			}

		}

		/**
		 * Este metodo tiene la funcion de escribir el archivo mediante los parametros
		 * de la clase usuario.
		 * 
		 * @param lista_Usuarios el atributo que tendr�n el sistema para ingresar el arraylist
		 *                de la clase usuario != null, usuario != � �
		 * 
		 */
		public void escribirEnArchivo(ArrayList<Usuario> lista_Usuarios) {

			try {
				salida = new ObjectOutputStream(new FileOutputStream(archivo_Tienda));
				salida.writeObject(lista_Usuarios);
				salida.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/**
		 * Este metodo tiene la funcion de leer el archivo mediante el arraylist de
		 * usuarios
		 * 
		 * @return El valor de retorno seria el arraylist que contiene los atributos de
		 *         la clase Usuario
		 *
		 */
		@SuppressWarnings("unchecked")
		public ArrayList<Usuario> leerArchivo() {

			ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
			if (archivo_Tienda.length() != 0) {
				try {

					entrada = new ObjectInputStream(new FileInputStream(archivo_Tienda));
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
}