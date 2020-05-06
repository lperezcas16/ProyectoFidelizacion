package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {
	
	private ArchivoUsuario archivo_Usuario;

	public UsuarioDAO(ArchivoUsuario archivo_Usuario) {
		this.archivo_Usuario = archivo_Usuario;
	}

	/**
	 * Método para eliminar a un usuario del array de usuarios, a partir del
	 * usuario,
	 * 
	 * @param Usuario
	 * @param Listado
	 *            de usuarios
	 * @return 
	 */
	public boolean eliminarUsuario(String usuario, ArrayList<Usuario> lista_Usuarios) {
		
		try {
			Usuario e = buscarUsuario(usuario, lista_Usuarios);
			lista_Usuarios.remove(e);
			archivo_Usuario.getArchivo_Usuarios().delete();
			archivo_Usuario.getArchivo_Usuarios().createNewFile();
			archivo_Usuario.escribirEnArchivo(lista_Usuarios);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para agregar usuarios e el array de usuarios.
	 * 
	 * @param Número
	 *            de cedula unico en el sistema
	 * @param Nombre
	 *            completo
	 * @param Genero
	 * @param Correo
	 *            electronico
	 * @param Numero
	 *            de tarjeta
	 * @param Cupo
	 *            en tarjeta
	 * @param Listado
	 *            de parejas asociadas
	 * @param Usuario
	 *            unico en el sistema
	 * @param Contraseña
	 * @param Lista
	 *            de usuarios
	 * @return 
	 */
	public boolean agregarUsuario(String numerocedula, String nombre,
			String genero, String correo, String numeroTarjeta,
			long cupoTarjeta, ArrayList<String> parejas, String usuario,
			String contraseña, ArrayList<Usuario> lista_usuarios) {
		Usuario nuevo = new Usuario(numerocedula, nombre, genero, correo,
				numeroTarjeta, cupoTarjeta, parejas, usuario, contraseña);
		if (buscarUsuario(usuario, lista_usuarios) == null) {
			lista_usuarios.add(nuevo);
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} else {
			return false;
		}
		

	}

	public Usuario  buscarUsuario(String usuario, ArrayList<Usuario> usuarios) {
		Usuario encontrado = null;

		if (usuarios.isEmpty()) {
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getUsuario().equals(usuario)) {
					encontrado = usuarios.get(i);
				}
			}
		}

		return encontrado;

	}

	public ArchivoUsuario getArchivo_Usuario() {
		return archivo_Usuario;
	}

	public void setArchivo_Usuario(ArchivoUsuario archivo_Usuario) {
		this.archivo_Usuario = archivo_Usuario;
	}

}
