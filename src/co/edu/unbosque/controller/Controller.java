package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Solusoft;
import co.edu.unbosque.model.Tiendas;
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
	private TiendaDAO tiendaDAO;
	private ArchivoTienda archivo_tienda;
	private ArrayList<Tiendas> lista_tiendas;
	private ArrayList<Usuario> lista_usuarios;
	private ArrayList<String> parejas;
	private Usuario usuario;

	public Controller() {
		super();
		solusoft = new Solusoft();
		view = new Ventana();
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);
		lista_usuarios = new ArrayList<Usuario>();
		archivo_tienda = new ArchivoTienda();
		tiendaDAO = new TiendaDAO(archivo_tienda);
		lista_tiendas = new ArrayList<Tiendas>();
		parejas = new ArrayList<String>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		actionListener(this);

	}

	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		// LISTENER PANEL PRINCIPAL
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
		// LISTENERS PANEL USUARIO
		view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda().addActionListener(controller);
		// LISTENERS PANEL ADMINISTRADOR
		view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja()
				.addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda().addActionListener(controller);
		// LISTENERS PANEL SELECCIONAR TIENDA
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		// LISTENERS PANEL VER INFO PAREJA
		view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja()
				.getBoton_regresar().addActionListener(controller);

	}

	public void actionPerformed(ActionEvent event) {

		// ACCION INGRESAR AL SISTEMA
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}
		// ACCION REGISTRAR USUARIO
		if (view.getPanel1().getBoton_registrar() == event.getSource()) {
			String nombre, correo, usuario, contraseña, genero = "", numeroTarjeta, tipoUsuario;
			long cupoTarjeta;
			boolean comprobacion = true;
			nombre = view.getPanel1().getCampo_nombre().getText();
			correo = view.getPanel1().getCampo_correo().getText();
			usuario = view.getPanel1().getCampo_usuario().getText();
			numeroTarjeta = solusoft.generarNumeroCuenta(lista_usuarios);
			cupoTarjeta = 0;
			tipoUsuario = "Usuario";
			contraseña = new String(view.getPanel1().getCampo_contrasena2()
					.getPassword());
			Pattern pattern = Pattern
					.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			// Se valida el email
			Matcher mather = pattern.matcher(correo);

			if (view.getPanel1().getC1().isSelected() == true) {
				genero = "Mujer";
			}
			if (view.getPanel1().getC2().isSelected() == true) {
				genero = "Hombre";
			}

			if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty()
					|| contraseña.isEmpty() || genero.isEmpty()) {
				view.mostrarMensajes("CAMPOS_FALSE");
				comprobacion = false;
			} else {
				String numeros = "[0-9]+";
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
				if (solusoft.comprobarExistenciaUsuario(correo, usuario,
						lista_usuarios)) {
					Usuario nuevo = new Usuario(nombre, genero, correo,
							usuario, contraseña, numeroTarjeta, cupoTarjeta,
							parejas, tipoUsuario);

					usuarioDAO.agregarUsuario(nombre, genero, correo, usuario,
							contraseña, numeroTarjeta, cupoTarjeta, parejas,
							tipoUsuario, lista_usuarios);
					solusoft.enviarCorreo(nuevo);
					view.mostrarMensajes("USUARIO_TRUE");
				} else {
					view.mostrarMensajes("USUARIO_FALSE");
				}
			}
		}

		// Panel Administrar Cuenta
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_ojo_oculto().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta()
					.setVisible(false);

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_info_pareja() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_ver_info_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_ojo_oculto().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta()
					.setVisible(false);

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_ojo_oculto() == event.getSource()) {

			if (view.getPanel_us_inicio()
					.getPnl_adm_cuentas()
					.getBoton_ojo_oculto()
					.getIcon()
					.equals(view.getPanel_us_inicio().getPnl_adm_cuentas()
							.getIcono_ojo_oculto())) {
				view.getPanel_us_inicio()
						.getPnl_adm_cuentas()
						.getBoton_ojo_oculto()
						.setIcon(
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getIcono_ojo());

			} else if (view
					.getPanel_us_inicio()
					.getPnl_adm_cuentas()
					.getBoton_ojo_oculto()
					.getIcon()
					.equals(view.getPanel_us_inicio().getPnl_adm_cuentas()
							.getIcono_ojo())) {
				view.getPanel_us_inicio()
						.getPnl_adm_cuentas()
						.getBoton_ojo_oculto()
						.setIcon(
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getIcono_ojo_oculto());
			}

		}

		// Panel Ver Info Pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_ver_info_pareja().getBoton_regresar() == event
				.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_ver_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_info_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getBoton_ojo_oculto().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo()
					.setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta()
					.setVisible(true);

			// Filas de la Tabla
			for (int i = 0; i < usuario.getParejas().size(); i++) {

				String nombre = usuario.getParejas().get(i);
				// Falta el cupo

				Object[] datos_filas = { nombre };
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getPnl_ver_info_pareja().getModel()
						.addRow(datos_filas);

			}

		}

		// Panel Asignar Horario
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getCombobox_parejas().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getBoton_agregar_horario().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getBoton_seleccionar_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getCalendario()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner()
					.setVisible(false);

			SimpleDateFormat dp = new SimpleDateFormat("HH:mm");

			String t = dp.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getSpinner().getValue());

			// Filas de la Tabla
			// for (int i = 0; i < lista_tiendas.size(); i++) {

			// String nombre = lista_tiendas.get(i).getNombre();
			// String direccion = lista_tiendas.get(i).getDireccion();
			// String hora_apertura =
			// lista_tiendas.get(i).getHorario_apertura();
			// String hora_cierre = lista_tiendas.get(i).getHorario_cierre();

			// Object[] datos_filas = { nombre, direccion, hora_apertura,
			// hora_cierre };
			// view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getModel()
			// .addRow(datos_filas);

			// }

		}

		// Panel Seleccionar Tienda

		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda() == event
				.getSource()) {

			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
					.setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getTable().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda()
					.getBoton_agregar_nueva_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getScroll().setVisible(false);

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda() == event.getSource()) {
			boolean comprobacion = true;
			String nombre_tienda = view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_nombre().getText();
			String direccion_tienda = view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_direccion().getText();

			SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
			String hora_apertura = sdf.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_apertura()
					.getValue());
			String hora_cierre = sdf.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_cierre().getValue());
			int hora_Apertura = Integer.parseInt(hora_apertura);

			int hora_Cierre = Integer.parseInt(hora_cierre);
			if (nombre_tienda.isEmpty() || direccion_tienda.isEmpty()) {
				view.mostrarMensajes("CAMPOS_FALSE");
				comprobacion = false;
			} else {
				String numeros = "[0-9]+";
				if (nombre_tienda.matches(numeros)) {
					view.mostrarMensajes("NOMBRE_FALSE");
					comprobacion = false;
				} else if (hora_Apertura > hora_Cierre) {
					view.mostrarMensajes("HORARIO_FALSE");
					comprobacion = false;
				}
			}

			if (comprobacion) {
				if (solusoft.comprobarExistenciaTienda(nombre_tienda,
						direccion_tienda, lista_tiendas)) {
					tiendaDAO.agregarTienda(nombre_tienda, direccion_tienda,
							hora_apertura, hora_cierre, lista_tiendas);
					view.mostrarMensajes("TIENDA_TRUE");
					view.getPanel_us_inicio().getPnl_asignar_horarios()
							.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
							.setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios()
							.getPnl_seleccionar_tienda().getTable()
							.setVisible(true);
					view.getPanel_us_inicio().getPnl_asignar_horarios()
							.getPnl_seleccionar_tienda()
							.getBoton_agregar_nueva_tienda().setVisible(true);
					view.getPanel_us_inicio().getPnl_asignar_horarios()
							.getPnl_seleccionar_tienda()
							.getBoton_agregar_tienda().setVisible(true);
					view.getPanel_us_inicio().getPnl_asignar_horarios()
							.getPnl_seleccionar_tienda().getScroll()
							.setVisible(true);
				} else {
					view.mostrarMensajes("TIENDA_FALSE");
				}
			}
		}

	}

}
