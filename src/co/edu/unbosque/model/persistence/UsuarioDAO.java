package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {

	private ArchivoUsuario archivo_Usuario;

	/**
	 * Metodo para poder llamar la clase Archivo medinate el parametro archivo
	 * 
	 * @param archivo el atributo que tendrán el sistema para llamar la clase
	 *                archivo archivo != null, archivo != “ “
	 */
	public UsuarioDAO(ArchivoUsuario archivo) {

		this.archivo_Usuario = archivo;
	}

	/**
	 * Metodo para poder ver una persona registrada en el sistema mediante la cedula
	 * 
	 * @param cedula  el atributo que tendrán el sistema para validar la cedula
	 *                cedula != null, cedula !
	 * @param persona el atributo que tendrán el sistema para llamar el arraylist
	 *                persona persona != null, persona !
	 * @return texto
	 */
	public String verUnUsuario(String usuario, ArrayList<Usuario> lista_usuarios) {
		String texto = "";
		texto = texto.concat(buscarUsuario(usuario, lista_usuarios).toString());
		return texto;
	}

	/**
	 * Metodo para poder ver las personas registrada en el sistema mediante la
	 * cedula
	 * 
	 * @param persona Este parametro representa que debe de ingresar un valor de que
	 *                corresponda al formato del ArrayList. persona != null, persona
	 *                != " ".
	 * @return texto
	 */
	public String verUsuario(ArrayList<Usuario> lista_usuarios) {
		String texto = "";
		for (int i = 0; i < lista_usuarios.size(); i++) {
			texto = lista_usuarios.toString();
		}
		return texto;
	}

	/**
	 * Metodo para buscarPersona una persona mediante la cedula en el arraylist.
	 * 
	 * @param usuario el atributo que tendrán el sistema para validar la cedula
	 *                cedula != null, cedula !
	 * @param persona el atributo que tendrán el sistema para llamar el arraylist
	 *                persona persona != null, persona !
	 * @return si es encontrado o no encontrado en el sistema
	 */
	public Usuario buscarUsuario(String usuario, ArrayList<Usuario> lista_usuarios) {
		Usuario encontrado = null;

		if (!lista_usuarios.isEmpty()) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (lista_usuarios.get(i).getUsuario().equals(usuario)) {
					encontrado = lista_usuarios.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Este es el metodo agregarUsuario de la clase UsuarioDAO el cual se le asigna
	 * la inicialización de los atributos y objectos. De esta manera el objecto toma
	 * el valor. Este método se llama automaticamente cuando se esta validando el
	 * proceso inscripcion del usuario en el registro , para la creacion del
	 * arrayList. <b>post</b> Se debe hacer la creacion de los parametros para
	 * realizar el registro <br>
	 * 
	 * @param nombre         el atributo que tendrán el sistema para ingresar el
	 *                       nombre
	 * @param genero         el atributo que tendrán el sistema para ingresar el
	 *                       genero
	 * @param correo         el atributo que tendrán el sistema para ingresar el
	 *                       correo
	 * @param usuario        el atributo que tentra el sistema para ingresar el
	 *                       correo
	 * @param contraseña     el atributo que tendra el sistema para ingresar la
	 *                       contraseña
	 * @param numeroTarjeta  el atributo que tendra el sistema para ingresar el
	 *                       numero de tarjeta
	 * @param cupoTarjeta    el atributo que tendra el sistema para ingresar el cupo
	 *                       de trajeta
	 * @param parejas        el atributo que tendra el sistema para ingresar las
	 *                       parejas
	 * @param tipoUsuario    el atributo que tendra el sistema para ingresar el tipo
	 *                       de usuario
	 * @param lista_usuarios el atributo que tendrán el sistema para llamar el
	 *                       arraylist usuario
	 * @return
	 */
	public boolean agregarUsuario(String nombre, String genero, String correo, String usuario, String contraseña,
			String numeroTarjeta, long cupoTarjeta, ArrayList<String> parejas, String tipoUsuario,
			ArrayList<Usuario> lista_usuarios) {

		Usuario nuevo = new Usuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta, parejas,
				tipoUsuario);

		if (buscarUsuario(usuario, lista_usuarios) == null) {
			lista_usuarios.add(nuevo);
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo EliminarUsuario , elimina al usuario mediante el usuario registrado y
	 * el arraylist de la clase usuario
	 * 
	 * @param usuario       el atributo que tendrán el sistema para validar el
	 *                      usuario
	 * @param lista_usuario el atributo que tendrán el sistema para llamar el
	 *                      arraylist
	 * @return si es puedo realizar la eliminación true o no se pudo realizar false
	 */
	public boolean eliminarUsuario(String usuario, ArrayList<Usuario> lista_usuario) {
		try {
			Usuario e = buscarUsuario(usuario, lista_usuario);
			lista_usuario.remove(e);
			archivo_Usuario.getArchivo_Usuarios().delete();
			archivo_Usuario.getArchivo_Usuarios().createNewFile();
			archivo_Usuario.escribirEnArchivo(lista_usuario);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

}