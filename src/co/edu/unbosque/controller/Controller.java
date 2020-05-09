package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.ContraseñaExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Solusoft;
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

	private ArrayList<Tiendas> lista_tiendas = new ArrayList<Tiendas>();

	private ArrayList<Usuario> lista_usuarios;
	ArrayList<String> parejas;

	public Controller() {
		super();
		solusoft = new Solusoft();
		view = new Ventana();
		lista_usuarios = new ArrayList<Usuario>();
		parejas = new ArrayList<String>();
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);
		archivo_tienda = new ArchivoTienda();
		tiendaDAO = new TiendaDAO(archivo_tienda);
		view = new Ventana();
		lista_usuarios = archivo_Usuario.leerArchivo();
		actionListener(this);

	}

	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		// LISTENER PANEL PRINCIPAL
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
		// LISTENERS PANEL USUARIO
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		// LISTENERS PANEL ADMINISTRADOR
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);

	}

	public void actionPerformed(ActionEvent event) {

		// ACCION INGRESAR AL SISTEMA
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}
		// ACCION REGISTRAR USUARIO
		if (view.getPanel1().getBoton_registrar() == event.getSource()) {
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
					Usuario nuevo = new Usuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta,
							parejas, tipoUsuario);

					usuarioDAO.agregarUsuario(nombre, genero, correo, usuario, contraseña, numeroTarjeta, cupoTarjeta,
							parejas, tipoUsuario, lista_usuarios);
					solusoft.enviarCorreo(nuevo);
					view.mostrarMensajes("USUARIO_TRUE");
				} else {
					view.mostrarMensajes("USUARIO_FALSE");
				}
			}
		}

		// Panel Administrar Cuenta
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {
			
		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {
		}
		// ACCION AGREGAR PAREJA
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource())

		{

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto() == event.getSource()) {
			if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {

				if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
						.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto())) {
					view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
							.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo());

				}

				if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto() == event.getSource()) {

					if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
							.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto())) {
						view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
								.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo());

					} else if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().getIcon()
							.equals(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo())) {
						view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
								.setIcon(view.getPanel_us_inicio().getPnl_adm_cuentas().getIcono_ojo_oculto());
					}

				}

				// Panel Asignar Horario
				if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario() == event
						.getSource()) {

				}

				if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda() == event
						.getSource()) {

					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().setVisible(true);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getCombobox_parejas().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getCalendario().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().setVisible(false);

					SimpleDateFormat dp = new SimpleDateFormat("HH:mm");
					System.out.println(
							dp.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().getValue()));

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

				}

				// Panel Agregar Pareja
				if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {
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

					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
							.getPnl_nueva_tienda().setVisible(true);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getTable()
							.setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
							.getBoton_agregar_nueva_tienda().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
							.getBoton_agregar_tienda().setVisible(false);
					view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getScroll()
							.setVisible(false);

				}

			}

		}
	}
}