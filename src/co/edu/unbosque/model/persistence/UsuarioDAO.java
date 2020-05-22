package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Horarios;
import co.edu.unbosque.model.Parejas;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {

	private ArchivoUsuario archivo_Usuario;

	/**
	 * Metodo para poder llamar la clase Archivo mediante el parametro archivo
	 * 
	 * @param archivo_Usuarios el atributo que tendrán el sistema para llamar la
	 *                         clase archivo archivo != null, archivo != “ “
	 */
	public UsuarioDAO(ArchivoUsuario archivo_Usuarios) {

		this.archivo_Usuario = archivo_Usuarios;
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
	 * @return Boolean true si se agrego el usuario, false si no se agrego el
	 *         usuario
	 */
	public boolean agregarUsuario(String nombre, String genero, String correo, String usuario, String contraseña,
			String numeroTarjeta, long cupoTarjeta, ArrayList<Parejas> parejas, String tipoUsuario,
			Date fechanacimiento, ArrayList<Usuario> lista_usuarios) {

		Usuario nuevo = new Usuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta, parejas,
				tipoUsuario, fechanacimiento);

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
	 * @param usuario       el atributo que tendrá el sistema para validar el
	 *                      usuario
	 * @param lista_usuario el atributo que tendrá el sistema para llamar el
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

	/**
	 * Metodo EliminarUsuarioPorCorreo , elimina al usuario mediante el usuario
	 * registrado y el arraylist de la clase usuario
	 * 
	 * @param correo        el atributo que tendrá el sistema para validar el
	 *                      usuario
	 * @param lista_usuario el atributo que tendrá el sistema para llamar el
	 *                      arraylist
	 * @return si es puedo realizar la eliminación true o no se pudo realizar false
	 */
	public boolean eliminarCorreo(String correo, ArrayList<Usuario> lista_usuario) {
		try {
			Usuario e = buscarCorreo(correo, lista_usuario);
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

	/**
	 * Metodo buscarUsuario, busca una persona mediante el usuario en el arraylist.
	 * 
	 * @param usuario        el atributo que tendrán el sistema para validar el
	 *                       usuario
	 * @param lista_usuarios el atributo que tendrán el sistema para llamar el
	 *                       arraylist de usuarios
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

	public Usuario buscarNombreUsuario(String nombre, ArrayList<Usuario> lista_usuarios) {
		Usuario encontrado = null;

		if (!lista_usuarios.isEmpty()) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (lista_usuarios.get(i).getNombre().equals(nombre)) {
					encontrado = lista_usuarios.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Metodo buscarUsuarioCorreo, busca una persona mediante el usuario en el
	 * arraylist.
	 * 
	 * @param correo         el atributo que tendrán el sistema para validar el
	 *                       usuario
	 * @param lista_usuarios el atributo que tendrán el sistema para llamar el
	 *                       arraylist de usuarios
	 * @return si es encontrado o no encontrado en el sistema
	 */
	public Usuario buscarCorreo(String correo, ArrayList<Usuario> lista_usuarios) {
		Usuario encontrado = null;

		if (!lista_usuarios.isEmpty()) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (lista_usuarios.get(i).getCorreo().equalsIgnoreCase(correo)) {
					encontrado = lista_usuarios.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Metodo para poder ver los usuarios registrados en el sistema
	 * 
	 * @param lista_usuarios Lista de la cual se obtendra la informacion de los
	 *                       usuarios
	 * @return texto Cadena de texto con la informacion obtenida
	 */
	public String verUsuarios(ArrayList<Usuario> lista_usuarios) {
		String texto = "";
		for (int i = 0; i < lista_usuarios.size(); i++) {
			texto = lista_usuarios.toString();
		}
		return texto;
	}

	/**
	 * Metodo para poder ver una persona registrada en el sistema mediante la cedula
	 * 
	 * @param usuario        el atributo que tendrán el sistema para validar el
	 *                       usuario
	 * @param lista_usuarios el atributo que tendrán el sistema para llamar el
	 *                       arraylist usuarios
	 * @return texto cadena de texto con la informacion del usuario
	 */
	public String verUnUsuario(String usuario, ArrayList<Usuario> lista_usuarios) {
		String texto = "";
		texto = texto.concat(buscarUsuario(usuario, lista_usuarios).toString());
		return texto;
	}

	public boolean comprobarUsuario(String usuario, String contraseña, ArrayList<Usuario> lista_usuarios) {
		boolean esta = false;
		if (!lista_usuarios.isEmpty()) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if ((lista_usuarios.get(i).getUsuario().equals(usuario)
						|| lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario))
						&& lista_usuarios.get(i).getContraseña().equals(contraseña)) {
					esta = true;
				}
			}
		}
		return esta;
	}

	public void agregarParejas(String usuario, String nombre, int cupo, double cantidad_cupo, String fechaNacimiento,
			int edad, ArrayList<Usuario> lista_usuarios) {
		ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
		ArrayList<Horarios> lista_horarios = new ArrayList<Horarios>();
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if ((lista_usuarios.get(i).getUsuario().equals(usuario)
					|| lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario))) {
				lista_parejas = lista_usuarios.get(i).getParejas();

			}
		}

		Parejas nuevo = new Parejas(nombre, cupo, cantidad_cupo, fechaNacimiento, edad, lista_horarios);

		lista_parejas.add(nuevo);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if ((lista_usuarios.get(i).getUsuario().equals(usuario)
					|| lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario))) {
				lista_usuarios.get(i).setParejas(lista_parejas);

			}
		}
		archivo_Usuario.escribirEnArchivo(lista_usuarios);
	}

	public boolean agregarHorariosCompras(String usuario, Tiendas tienda_horarios, String pareja, String fecha,
			String hora) {
		ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		ArrayList<Horarios> lista_horarios = new ArrayList<Horarios>();
		ArrayList<Parejas> listaParejas = new ArrayList<Parejas>();
		Horarios horario = new Horarios(tienda_horarios, fecha, hora);
		boolean yaEsta = false;
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				listaParejas = lista_usuarios.get(i).getParejas();
				for (int j = 0; j < listaParejas.size(); j++) {
					lista_horarios.addAll(listaParejas.get(j).getLista_horarios());
				}
			}
		}
		for (int i = 0; i < lista_horarios.size(); i++) {
			if (lista_horarios.get(i).compara(horario)) {
				yaEsta = true;
			}
		}
		if (!yaEsta) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario)
						|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
					listaParejas = lista_usuarios.get(i).getParejas();
					for (int j = 0; j < listaParejas.size(); j++) {
						if (listaParejas.get(j).getNombre().equalsIgnoreCase(pareja)) {
							lista_horarios = listaParejas.get(j).getLista_horarios();
							lista_horarios.add(horario);
							lista_usuarios.get(i).getParejas().get(j).setLista_horarios(lista_horarios);
							archivo_Usuario.escribirEnArchivo(lista_usuarios);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean ordenAliasAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1 && aux.getUsuario().compareToIgnoreCase(lista_usuarios.get(k).getUsuario()) < 0) {

				lista_usuarios.remove(k + 1);
				lista_usuarios.add(k + 1, lista_usuarios.get(k));
				k = k - 1;
			}

			lista_usuarios.remove(k + 1);
			lista_usuarios.add(k + 1, aux);

		}
		try {
			archivo_Usuario.getArchivo_Usuarios().delete();
			archivo_Usuario.getArchivo_Usuarios().createNewFile();
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public boolean ordenNombreAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1 && aux.getNombre().compareToIgnoreCase(lista_usuarios.get(k).getNombre()) < 0) {

				lista_usuarios.remove(k + 1);
				lista_usuarios.add(k + 1, lista_usuarios.get(k));
				k = k - 1;
			}

			lista_usuarios.remove(k + 1);
			lista_usuarios.add(k + 1, aux);

		}
		try {
			archivo_Usuario.getArchivo_Usuarios().delete();
			archivo_Usuario.getArchivo_Usuarios().createNewFile();
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public boolean ordenCorreoAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1 && aux.getCorreo().compareToIgnoreCase(lista_usuarios.get(k).getCorreo()) < 0) {

				lista_usuarios.remove(k + 1);
				lista_usuarios.add(k + 1, lista_usuarios.get(k));
				k = k - 1;
			}

			lista_usuarios.remove(k + 1);
			lista_usuarios.add(k + 1, aux);

		}
		try {
			archivo_Usuario.getArchivo_Usuarios().delete();
			archivo_Usuario.getArchivo_Usuarios().createNewFile();
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

}