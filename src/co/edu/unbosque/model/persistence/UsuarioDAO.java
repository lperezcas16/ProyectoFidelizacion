package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.Horarios;
import co.edu.unbosque.model.Parejas;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {

	private ArchivoUsuario archivo_Usuario;

	/**
	 * Metodo para poder llamar la clase Archivo mediante el parametro archivo
	 * 
	 * @param archivo_Usuarios
	 *            el atributo que tendrán el sistema para llamar la clase
	 *            archivo archivo != null, archivo != “ “
	 */
	public UsuarioDAO(ArchivoUsuario archivo_Usuarios) {

		this.archivo_Usuario = archivo_Usuarios;
	}

	/**
	 * Este es el metodo agregarUsuario de la clase UsuarioDAO el cual se le
	 * asigna la inicialización de los atributos y objectos. De esta manera el
	 * objecto toma el valor. Este método se llama automaticamente cuando se
	 * esta validando el proceso inscripcion del usuario en el registro , para
	 * la creacion del arrayList. <b>post</b> Se debe hacer la creacion de los
	 * parametros para realizar el registro <br>
	 * 
	 * @param nombre
	 *            el atributo que tendrán el sistema para ingresar el nombre.
	 *            nombre != null, nombre != "".
	 * @param genero
	 *            el atributo que tendrán el sistema para ingresar el genero.
	 *            genero != null, genero != "".
	 * @param correo
	 *            el atributo que tendrán el sistema para ingresar el correo.
	 *            correo != null, correo != "".
	 * @param usuario
	 *            el atributo que tendra el sistema para ingresar el correo.
	 *            usuario != null, usuario != "".
	 * @param contraseña
	 *            el atributo que tendra el sistema para ingresar la contraseña.
	 *            contraseña != null, contraseña != "".
	 * @param numeroTarjeta
	 *            el atributo que tendra el sistema para ingresar el numero de
	 *            tarjeta. numeroTarjeta != null, numeroTarjeta != "".
	 * @param cupoTarjeta
	 *            el atributo que tendra el sistema para ingresar el cupo de
	 *            trajeta. cupoTarjeta != null, cupoTarjeta != "".
	 * @param parejas
	 *            el atributo que tendra el sistema para ingresar las parejas.
	 *            parejas != null, parejas != "";
	 * @param tipoUsuario
	 *            el atributo que tendra el sistema para ingresar el tipo de
	 *            usuario. tipoUsuario != null, tipoUsuario != "".
	 * @param lista_usuarios
	 *            el atributo que tendrán el sistema para llamar el arraylist
	 *            usuario. lista_usuarios != null,
	 * @param compras
	 *            el atributo que tendra el sistema para llamar el arraylist
	 *            compras. compras != null, compras != "". lista_usuarios != "".
	 * @param edad
	 *            el atributo que tendra el sistema para ingresar la edad. edad
	 *            != null, edad != "":
	 * @return boolean true si se agrego el usuario, false si no se agrego el
	 *         usuario
	 */

	public boolean agregarUsuario(String nombre, String genero, String correo,
			String usuario, String contraseña, String numeroTarjeta,
			long cupoTarjeta, ArrayList<Parejas> parejas,
			ArrayList<Compra> compras, String tipoUsuario, int edad,
			ArrayList<Usuario> lista_usuarios) {

		Usuario nuevo = new Usuario(nombre, genero, correo, usuario,
				contraseña, numeroTarjeta, edad, cupoTarjeta, parejas,
				tipoUsuario, compras);

		if (buscarUsuario(usuario, lista_usuarios) == null) {
			lista_usuarios.add(nuevo);
			archivo_Usuario.escribirEnArchivo(lista_usuarios);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo EliminarUsuario , elimina al usuario mediante el usuario
	 * registrado y el arraylist de la clase usuario
	 * 
	 * @param usuario
	 *            el atributo que tendrá el sistema para validar el usuario.
	 *            usuario != null, usuario != "".
	 * @param lista_usuario
	 *            el atributo que tendrá el sistema para llamar el arraylist.
	 *            lista_usuarios != null, lista_usuarios != "".
	 * @return si es puedo realizar la eliminación true o no se pudo realizar
	 *         false
	 */
	public boolean eliminarUsuario(String usuario,
			ArrayList<Usuario> lista_usuario) {
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
	 * @param correo
	 *            el atributo que tendrá el sistema para validar el usuario.
	 *            correo != null, correo != "".
	 * @param lista_usuario
	 *            el atributo que tendrá el sistema para llamar el arraylist.
	 *            lista_usuarios != null, lista_usuarios != "".
	 * @return si es puedo realizar la eliminación true o no se pudo realizar
	 *         false
	 */
	public boolean eliminarCorreo(String correo,
			ArrayList<Usuario> lista_usuario) {
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
	 * Metodo buscarUsuario, busca una persona mediante el usuario en el
	 * arraylist.
	 * 
	 * @param usuario
	 *            el atributo que tendrán el sistema para validar el usuario.
	 *            usuario != null, usuario != "".
	 * @param lista_usuarios
	 *            el atributo que tendrán el sistema para llamar el arraylist de
	 *            usuarios. lista_usuarios != null, lista_usuarios != "".
	 * @return si es encontrado o no encontrado en el sistema
	 */
	public Usuario buscarUsuario(String usuario,
			ArrayList<Usuario> lista_usuarios) {
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

	public Usuario buscarNombreUsuario(String nombre,
			ArrayList<Usuario> lista_usuarios) {
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
	 * @param correo
	 *            el atributo que tendrán el sistema para validar el usuario.
	 *            correo != null, correo != "".
	 * @param lista_usuarios
	 *            el atributo que tendrán el sistema para llamar el arraylist de
	 *            usuarios. lista_usuarios != null, lista_usuarios != "".
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
	 * Este metodo comprueba en el momento de inicio de sesion si en realidad el
	 * alias o correo si corresponden a un usuario ya registrado en el
	 * sistema.<b>post</b>Se inicia sesion si se valida correctamente la
	 * información ingresada<br>
	 * 
	 * @param usuario
	 *            Este parametro representa el correo o el alias ingresados por
	 *            el usuario al iniciar sesion. usuario != null, usuario != "".
	 * @param contraseña
	 *            Es la contraseña ingresada por el usuario. contraseña != null,
	 *            contraseña != "".
	 * @param lista_usuarios
	 *            Es el arraylist donde estan guardados todos los usuarios.
	 *            lista_usuarios != null, lista_usuarios != "".
	 * @return Si se comprueba que el usuario si esta registrado en el sistema
	 *         se devuelve verdadero.
	 */
	public boolean comprobarUsuario(String usuario, String contraseña,
			ArrayList<Usuario> lista_usuarios) {
		boolean esta = false;
		if (!lista_usuarios.isEmpty()) {
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if ((lista_usuarios.get(i).getUsuario().equals(usuario) || lista_usuarios
						.get(i).getCorreo().equalsIgnoreCase(usuario))
						&& lista_usuarios.get(i).getContraseña()
								.equals(contraseña)) {
					esta = true;
				}
			}
		}
		return esta;
	}

	/**
	 * Metodo que agrega una nueva pareja por medio de un usuario
	 * especifico.<b>pre</b>Se debió de crear anteriormente un cupo total para
	 * el usuario.<br>
	 * <b>post</b>Se agrega una nueva pareja en la cuenta del usuario.<br>
	 * 
	 * @param usuario
	 *            Este parametro representa el correo o el alias ingresados por
	 *            el usuario al iniciar sesion. usuario != null, usuario != "".
	 * @param nombre
	 *            Es el nombre de la pareja. nombre != null, nombre != "".
	 * @param cupo
	 *            Es el porcentaje de la cantidad establecida del cupo
	 *            disponible del usuario para la nueva pareja. cupo != null,
	 *            cupo != "".
	 * @param cantidad_cupo_asignado
	 *            Es la cantidad del cupo asignado a la pareja.
	 *            cantidad_cupo_asignado != null, cantidad_cupo_asignado != "".
	 * @param cantidad_cupo_restante
	 *            es la cantidad del cupo que le queda a la pareja. Este valor
	 *            es el mismo al cupo asignado desde un inicio pero va
	 *            disminuyendo frente a la addición de compras.
	 *            cantidad_cupo_restante != null, cantidad_cupo_restante != "".
	 * @param edad
	 *            Edad de la pareja que se saca a través de la fecha de
	 *            nacimiento. edad != null, edad != "".
	 * @param lista_usuarios
	 *            Es el arraylist donde estan guardados todos los usuarios.
	 *            lista_usuarios != null, lista_usuarios != "".
	 */
	public void agregarParejas(String usuario, String nombre, int cupo,
			double cantidad_cupo_asignado, double cantidad_cupo_restante,
			int edad, ArrayList<Usuario> lista_usuarios) {
		ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
		ArrayList<Horarios> lista_horarios = new ArrayList<Horarios>();
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if ((lista_usuarios.get(i).getUsuario().equals(usuario) || lista_usuarios
					.get(i).getCorreo().equalsIgnoreCase(usuario))) {
				lista_parejas = lista_usuarios.get(i).getParejas();

			}
		}

		Parejas nuevo = new Parejas(nombre, cupo, cantidad_cupo_asignado,
				cantidad_cupo_asignado, edad, lista_horarios);

		lista_parejas.add(nuevo);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if ((lista_usuarios.get(i).getUsuario().equals(usuario) || lista_usuarios
					.get(i).getCorreo().equalsIgnoreCase(usuario))) {
				lista_usuarios.get(i).setParejas(lista_parejas);

			}
		}
		archivo_Usuario.escribirEnArchivo(lista_usuarios);
	}

	/**
	 * Metodo que agrega un nuevo horario registrada a traves de un usuario
	 * especifico.<b>pre</b>Se debió de crear anteriormente un cupo total para
	 * el usuario y al menos una pareja.<br>
	 * <b>post</b>Se agrega un nuevo horario en la cuenta del usuario.<br>
	 * 
	 * @param usuario
	 *            Este parametro representa el correo o el alias ingresados por
	 *            el usuario al iniciar sesion. usuario != null, usuario != "".
	 * @param tienda_horarios
	 *            Representa todas las tiendas inscritas junto con toda su
	 *            información.
	 * @param pareja
	 *            Es el nombre de la pareja con la cual se asignó el horario.
	 *            parejas != null, parejas != "".
	 * 
	 * @param fecha
	 *            Es la fecha establecida para el horario nuevo. fecha != null,
	 *            fecha != "".
	 * @param hora
	 *            Es la hora del nuevo horario. hora != null, hora != "".
	 * @return Si se agregó correctamente el nuevo horario se devuelve
	 *         verdadero.
	 */
	public boolean agregarHorariosCompras(String usuario,
			Tiendas tienda_horarios, String pareja, String fecha, String hora) {
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
					lista_horarios.addAll(listaParejas.get(j)
							.getLista_horarios());
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
						if (listaParejas.get(j).getNombre()
								.equalsIgnoreCase(pareja)) {
							lista_horarios = listaParejas.get(j)
									.getLista_horarios();
							lista_horarios.add(horario);
							lista_usuarios.get(i).getParejas().get(j)
									.setLista_horarios(lista_horarios);
							archivo_Usuario.escribirEnArchivo(lista_usuarios);
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Metodo para poder ordenar ascendentemente la lista de usuarios a partir
	 * del alias. <b>pre</b>Debe de estar inscrito por lo menos dos usuarios
	 * para poder compararlas.<br>
	 * 
	 * @param lista_usuarios
	 *            Este parametro hace referencia a la lista de todos los
	 *            usuarios inscritos hasta el momento junto con toda su
	 *            informacion. lista_usuarios != null, lista_usuarios != "".
	 * @return Retorna verdadero si se logró borrar el anterior archivo y
	 *         escribir uno nuevo con el orden deseado.
	 */

	public boolean ordenAliasAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1
					&& aux.getUsuario().compareToIgnoreCase(
							lista_usuarios.get(k).getUsuario()) < 0) {

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

	/**
	 * Metodo para poder ordenar ascendentemente la lista de usuarios a partir
	 * del nombre. <b>pre</b>Debe de estar inscrito por lo menos dos usuarios
	 * para poder compararlas.<br>
	 * 
	 * @param lista_usuarios
	 *            Este parametro hace referencia a la lista de todos los
	 *            usuarios inscritos hasta el momento junto con toda su
	 *            informacion. lista_usuarios != null, lista_usuarios != "".
	 * @return Retorna verdadero si se logró borrar el anterior archivo y
	 *         escribir uno nuevo con el orden deseado.
	 */
	public boolean ordenNombreAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1
					&& aux.getNombre().compareToIgnoreCase(
							lista_usuarios.get(k).getNombre()) < 0) {

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

	/**
	 * Metodo para poder ordenar ascendentemente la lista de usuarios a partir
	 * del correo. <b>pre</b>Debe de estar inscrito por lo menos dos usuarios
	 * para poder compararlas.<br>
	 * 
	 * @param lista_usuarios
	 *            Este parametro hace referencia a la lista de todos los
	 *            usuarios inscritos hasta el momento junto con toda su
	 *            informacion. lista_usuarios != null, lista_usuarios != "".
	 * @return Retorna verdadero si se logró borrar el anterior archivo y
	 *         escribir uno nuevo con el orden deseado.
	 */
	public boolean ordenCorreoAsc(ArrayList<Usuario> lista_usuarios) {

		Usuario aux;
		int k;
		for (int i = 1; i < lista_usuarios.size(); i++) {
			aux = lista_usuarios.get(i);
			k = i - 1;
			while (k > -1
					&& aux.getCorreo().compareToIgnoreCase(
							lista_usuarios.get(k).getCorreo()) < 0) {

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

	/**
	 * Metodo que agrega una nueva compra registrada a traves de un usuario
	 * especifico.<b>pre</b>Se debió de crear anteriormente un cupo total para
	 * el usuario y al menos una pareja.<br>
	 * <b>post</b>Se agrega una nueva compra en la cuenta del usuario.<br>
	 * 
	 * @param usuario
	 *            Este parametro representa el correo o el alias ingresados por
	 *            el usuario al iniciar sesion. usuario != null, usuario != "".
	 * @param pareja
	 *            Es el nombre de la pareja con la cual se realizó la compra.
	 *            parejas != null, parejas != "".
	 * @param tienda
	 *            Es el nombre de la tienda en la cual se realizó la compra.
	 *            tienda != null, tienda != "".
	 * @param valorCompra
	 *            Es valor total gastado en la compra. valorCompra != null,
	 *            valorCompra != "".
	 */
	public void agregarCompras(String usuario, String pareja, String tienda,
			double valorCompra) {
		Compra compra = new Compra(pareja, tienda, valorCompra);
		ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		ArrayList<Compra> lista_compras = new ArrayList<Compra>();
		ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				lista_parejas = lista_usuarios.get(i).getParejas();
				for (int j = 0; j < lista_parejas.size(); j++) {
					if (lista_parejas.get(j).getNombre().equals(pareja)) {
						double cupoRestante = lista_parejas.get(j)
								.getCantidad_cupo_restante();
						double nuevoCupo = cupoRestante - valorCompra;
						lista_usuarios.get(i).getParejas().get(j)
								.setCantidad_cupo_restante(nuevoCupo);
					}
				}
			}
		}
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equalsIgnoreCase(usuario)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				lista_compras = lista_usuarios.get(i).getLista_compras();
				lista_compras.add(compra);
				lista_usuarios.get(i).setLista_compras(lista_compras);
			}
		}
		archivo_Usuario.escribirEnArchivo(lista_usuarios);
	}

}