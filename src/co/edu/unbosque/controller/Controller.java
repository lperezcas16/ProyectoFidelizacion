package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


<<<<<<< HEAD
import co.edu.unbosque.model.ContraseñaExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Tiendas;
=======
import co.edu.unbosque.model.Solusoft;
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoTienda;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.TiendaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener {

	private Ventana view;
	private Solusoft solusoft;
	private ArchivoUsuario archivo_Usuario;
	private UsuarioDAO usuarioDAO;
<<<<<<< HEAD
	private TiendaDAO tiendaDAO;
	private ArchivoTienda archivo_tienda;

	private ArrayList<Tiendas> lista_tiendas = new ArrayList<Tiendas>();
=======
	private ArrayList<Usuario> lista_usuarios;
	ArrayList<String> parejas;
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

	public Controller() {
		super();
		solusoft = new Solusoft();
		view = new Ventana();
		lista_usuarios = new ArrayList<Usuario>();
		parejas = new ArrayList<String>();
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);

<<<<<<< HEAD
		archivo_tienda = new ArchivoTienda();
		tiendaDAO = new TiendaDAO(archivo_tienda);
//		lista_tiendas = archivo_tienda.leerArchivo();

		view = new Ventana();
=======
		lista_usuarios = archivo_Usuario.leerArchivo();
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git
		actionListener(this);
//		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().crearTabla(tiendaDAO.verTienda(tiendas));

//		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().

	}

	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		// LISTENER PANEL PRINCIPAL
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
<<<<<<< HEAD
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
=======
		// LISTENERS PANEL ADMINISTRADOR
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

	}

	public void actionPerformed(ActionEvent event) {

		// ACCION INGRESAR AL SISTEMA
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}
		// ACCION REGISTRAR USUARIO
		if (view.getPanel1().getBoton_registrar() == event.getSource()) {

<<<<<<< HEAD
		// Panel Administrar Cuenta
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {
=======
			String nombre, correo, usuario, contraseña, genero = "", numeroTarjeta, tipoUsuario;
			long cupoTarjeta;
			String numeros = "[0-9]+";
			boolean comprobacion = true;
			nombre = view.getPanel1().getCampo_nombre().getText();
			correo = view.getPanel1().getCampo_correo().getText();
			usuario = view.getPanel1().getCampo_usuario().getText();
			numeroTarjeta = solusoft.generarNumeroCuenta(lista_usuarios);
			cupoTarjeta = 0;
			tipoUsuario = "Usuario";
			contraseña = new String(view.getPanel1().getCampo_contrasena2().getPassword());
			Pattern pattern = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			// Se valida el email
			Matcher mather = pattern.matcher(correo);

			if (view.getPanel1().getC1().isSelected() == true) {
				genero = "Mujer";
			}
			if (view.getPanel1().getC2().isSelected() == true) {
				genero = "Hombre";
			}

			if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty() || genero.isEmpty()) {
				view.mostrarMensajes("CAMPOS_FALSE");
				comprobacion = false;
			} else {
				if (nombre.matches(numeros)) {
					comprobacion = false;
					view.mostrarMensajes("NOMBRE_FALSE");
				} else if (contraseña.length() < 8) {
					comprobacion = false;
					view.mostrarMensajes("CONTRASEÑA_FALSE");
				} else if (mather.find() == false) {
					comprobacion = false;
					view.mostrarMensajes("CORREO_FALSE");
				}

			}
			if (comprobacion == true) {
				if (solusoft.comprobarExistenciaUsuario(correo, usuario, lista_usuarios)) {
					Usuario nuevo = new Usuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta, parejas,
							tipoUsuario);

					usuarioDAO.agregarUsuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta,
							parejas, tipoUsuario, lista_usuarios);
					solusoft.enviarCorreo(nuevo);
					view.mostrarMensajes("USUARIO_TRUE");
				} else {
					view.mostrarMensajes("USUARIO_FALSE");
				}
			}
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

		}

<<<<<<< HEAD
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {
=======
		// ACCION AGREGAR PAREJA
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource())

		{
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

		}

<<<<<<< HEAD
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto() == event.getSource()) {
=======
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

<<<<<<< HEAD
			if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
					.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto())) {
				view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
						.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo());
=======
		}
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

<<<<<<< HEAD
=======
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto() == event.getSource()) {

			if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
					.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto())) {
				view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
						.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo());

>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git
			} else if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
					.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo())) {
				view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
						.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto());
			}

		}

		// Panel Asignar Horario
		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda() == event.getSource()) {
<<<<<<< HEAD

			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getCombobox_parejas().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getCalendario().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().setVisible(false);

			SimpleDateFormat dp = new SimpleDateFormat("HH:mm");
			System.out.println(dp.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().getValue()));

			String t = dp.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().getValue());
			System.out.println(t);

			// Filas de la Tabla
			for (int i = 0; i < lista_tiendas.size(); i++) {

//				String nombre = arreglo_tiendas.get(i).getNombre();
//				String direccion = arreglo_tiendas.get(i).getDireccion();
//				String hora_apertura = arreglo_tiendas.get(i).getHorario_apertura();
//				String hora_cierre = arreglo_tiendas.get(i).getHorario_cierre();

//				Object[] datos_filas = { nombre, direccion, hora_apertura, hora_cierre };
//				view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getModel()
//						.addRow(datos_filas);

			}
=======
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git

		}

		// Panel Agregar Pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {
<<<<<<< HEAD
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta().setVisible(false);
		}

		// Panel Seleccionar Tienda

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
				.getBoton_agregar_nueva_tienda() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getPnl_nueva_tienda()
					.setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getTable()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getBoton_agregar_nueva_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getScroll()
					.setVisible(false);

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
				.getBoton_agregar_tienda() == event.getSource()) {

=======
			// view.getPanel_us_inicio().getPestañas().setTabComponentAt(0,
			// view.getPanel_us_inicio().getPnl_agrega());
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git
		}

<<<<<<< HEAD
	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto con
	 * las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la clase
	 * NombresExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param n Este parametro representa al nombre y apellido ingresado por el
	 *          usuario que debe de evaluarse para ver si tiene la excepcion
	 * @return Si no se lanza la excepcion se devolveria el nombre o apellido
	 *         ingresado
	 * @throws NombresExcepcion Esta excepcion corresponde a las limitaciones
	 *                          impuestas al nombre y apellido
	 */
	public String nombres(String n) throws NombresExcepcion {

		if (n.matches(numeros)) {
			throw new NumberFormatException("El formato del nombre  es incorrecto");
		} else {
			return n;
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto con
	 * las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la clase
	 * ContraseñaExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c Este parametro representa a la contraseña ingresado por el usuario
	 *          que debe de evaluarse para ver si tiene la excepcion. n != null, n
	 *          != " ".
	 * @return Si no se lanza la excepcion se devolveria la contraseña ingresado
	 * @throws CedulaExcepcion Esta excepcion corresponde a las limitaciones
	 *                         impuestas a la contraseña
	 */
	public String comprobarContraseña(String c) throws ContraseñaExcepcion {

		if (c.length() >= 8) {
			return c;
		} else {
			throw new ContraseñaExcepcion("La contraseña debe de tener por lo menos 8 caracteres");
		}
	}

	public void inscribirUsuario() {
		ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		String nombre = view.getPanel1().getCampo_nombre().getText();
		nombre = nombre.replace(" ", "");
		String correo = view.getPanel1().getCampo_correo().getText();
		correo = correo.replace(" ", "");
		String usuario = view.getPanel1().getCampo_usuario().getText();
		usuario = usuario.replace(" ", "");
		String contraseña = view.getPanel1().getCampo_contrasena().getText();
		contraseña = contraseña.replace(" ", "");
		String genero = "";
		if (view.getPanel1().getC1().isSelected()) {
			genero = "Mujer";
		} else if (view.getPanel1().getC2().isSelected()) {
			genero = "Hombre";
		}
		String numeroTarjeta = generarNumeroCuenta(lista_usuarios);
		long cupoTarjeta = 0;
		String tipoUsuario = "Usuario";
		ArrayList<String> parejas = new ArrayList<String>();
		try {

			if (!nombre.isEmpty() && !correo.isEmpty() && !usuario.isEmpty() && !contraseña.isEmpty()
					&& !genero.isEmpty()) {
				nombres(nombre);
				comprobarContraseña(contraseña);
				if (comprobarExistenciaUsuario(correo, usuario, lista_usuarios)) {

					usuarioDAO.agregarUsuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta,
							parejas, tipoUsuario, lista_usuarios);
					view.getPanel1().limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Los datos ingresados ya pertenecen a un usuario");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Digite todos los datos solicitados");
			}
		} catch (ContraseñaExcepcion e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (NombresExcepcion e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}

	}

	public String generarNumeroCuenta(ArrayList<Usuario> lista_usuarios) {

		int M = 10000000;
		int N = 99999999;
		int valor1 = (int) Math.floor(Math.random() * (N - M + 1) + M);
		int valor2 = (int) Math.floor(Math.random() * (N - M + 1) + M);
		String numeroTargeta = Integer.toString(valor1) + Integer.toString(valor2);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getNumeroTarjeta().equals(numeroTargeta)) {
				valor1 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				valor2 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				numeroTargeta = Integer.toString(valor1) + Integer.toString(valor2);
			}
		}
		return numeroTargeta;
	}

	public boolean comprobarExistenciaUsuario(String correo, String usuario, ArrayList<Usuario> lista_usuarios) {
		boolean comprobar = true;

		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equals(correo)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				comprobar = false;
			}
		}

		return comprobar;
=======
>>>>>>> branch 'master' of https://github.com/yeisonj/ProyectoCorte3.git
	}

}