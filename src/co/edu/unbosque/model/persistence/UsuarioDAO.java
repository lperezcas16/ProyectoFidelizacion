package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {
	private ArchivoUsuario archivo_Usuario;

	public UsuarioDAO(ArchivoUsuario archivo_Usuario) {
		this.archivo_Usuario = archivo_Usuario;
	}

	/**
	 * M�todo para eliminar a un usuario del array de usuarios, a partir del
	 * usuario,
	 * 
	 * @param Usuario
	 * @param Listado
	 *            de usuarios
	 */
	public void eliminarUsuario(String usuario, ArrayList<Usuario> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUsuario().equals(usuario)) {
				usuarios.remove(i);
				archivo_Usuario.escribirEnArchivo(usuarios);
			}
		}
	}

	/**
	 * M�todo para agregar usuarios e el array de usuarios.
	 * 
	 * @param N�mero
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
	 * @param Contrase�a
	 * @param Lista
	 *            de usuarios
	 */
	public void agregarUsuario(String numerocedula, String nombre,
			String genero, String correo, String numeroTarjeta,
			long cupoTarjeta, ArrayList<String> parejas, String usuario,
			String contrase�a, ArrayList<Usuario> usuarios) {
		Usuario nuevo = new Usuario(numerocedula, nombre, genero, correo,
				numeroTarjeta, cupoTarjeta, parejas, usuario, contrase�a);

		usuarios.add(nuevo);
		archivo_Usuario.escribirEnArchivo(usuarios);

	}

	public void buscarUsuario(String usuario, ArrayList<Usuario> usuarios) {

	}

	public ArchivoUsuario getArchivo_Usuario() {
		return archivo_Usuario;
	}

	public void setArchivo_Usuario(ArchivoUsuario archivo_Usuario) {
		this.archivo_Usuario = archivo_Usuario;
	}

}
