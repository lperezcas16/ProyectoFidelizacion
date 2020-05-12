package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.HorarioExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Solusoft;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoTienda;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.TiendaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.Ventana;
import co.edu.unbosque.view.VentanaGraficas;

public class Controller implements ActionListener {

	private Ventana view;
	private VentanaGraficas view2;
	private Solusoft solusoft;
	private ArchivoUsuario archivo_Usuario;
	private UsuarioDAO usuarioDAO;
	private TiendaDAO tiendaDAO;
	private ArchivoTienda archivo_tienda;
	private ArrayList<Tiendas> lista_tiendas;
	private ArrayList<Usuario> lista_usuarios;
	private ArrayList<String> parejas;
	private Usuario usuario;
	private String numeros = "[0-9]+";

	public Controller() throws IOException {
		super();
		solusoft = new Solusoft();
		view = new Ventana();
		view2 = new VentanaGraficas();
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);
		lista_usuarios = new ArrayList<Usuario>();
		archivo_tienda = new ArchivoTienda();
		tiendaDAO = new TiendaDAO(archivo_tienda);
		lista_tiendas = new ArrayList<Tiendas>();
		parejas = new ArrayList<String>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		actionListener(this);

		// Tabla tiendas
		for (int i = 0; i < getTiendas().size(); i++) {

			String nombre = lista_tiendas.get(i).getNombre();
			String direccion = lista_tiendas.get(i).getDireccion();
			String hora_apertura = lista_tiendas.get(i).getHorario_apertura();
			String hora_cierre = lista_tiendas.get(i).getHorario_cierre();

			Object[] datos_filas = { nombre, direccion, hora_apertura, hora_cierre };
			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getModel()
					.addRow(datos_filas);

		}

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
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda().addActionListener(controller);
		// LISTENERS PANEL ADMINISTRADOR
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
		// LISTENERS PANEL SELECCIONAR TIENDA
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		// LISTENERS PANEL VER INFO PAREJA
		view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().getBoton_regresar();
		//LISTENERS PANEL INFORME
				view.getPanel_admin().getPanel_informe().getCombo_eleccion().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getCombo_Fecha().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getCombo_hora().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getCombo_tienda().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getCampo_usuario().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getBoton().addActionListener(controller);
				view.getPanel_admin().getPanel_informe().getBoton_vista_previa().addActionListener(controller);
				
				//LISTENERS PANEL TIENDA
				view.getPanel_admin().getPanel_tiendas().getBoton_eliminar().addActionListener(controller);
				view.getPanel_admin().getPanel_tiendas().getBoton_agregar_tienda().addActionListener(controller);
				view.getPanel_admin().getPanel_tiendas().getCombo_tiendas().addActionListener(controller);
				

			}

			public void actionPerformed(ActionEvent event) {
				
				// PANEL VISTA TIENDAS EN ADMINISTRADOR
				if(view.getPanel_admin().getPanel_tiendas().getCombo_tiendas() == event.getSource()) {
					try {
						
						switch ( view.getPanel_admin().getPanel_tiendas().getCombo_tiendas().getSelectedIndex()) {
						case 0:
							view.getPanel_admin().getPanel_tiendas().getCampo_buscar().setVisible(false);
							view.getPanel_admin().getPanel_tiendas().getSpinner().setVisible(false);
							break;
						case 1:
							view.getPanel_admin().getPanel_tiendas().getCampo_buscar().setVisible(false);
							view.getPanel_admin().getPanel_tiendas().getSpinner().setVisible(true);
							break;
						case 2:
							view.getPanel_admin().getPanel_tiendas().getCampo_buscar().setVisible(false);
							view.getPanel_admin().getPanel_tiendas().getSpinner().setVisible(true);
							break;
						case 3: 
							view.getPanel_admin().getPanel_tiendas().getCampo_buscar().setVisible(true);
							view.getPanel_admin().getPanel_tiendas().getSpinner().setVisible(false);
							break;
						}
					}catch( Exception e) {
						System.out.println("Error al cargar  todo ");
					}
				}
				
				//	PANEL VISTA PREVIA DE LAS GRÁFICAS
				
				if(view.getPanel_admin().getPanel_informe().getBoton_vista_previa() == event.getSource()) {

//					view.getPanel_admin().getPanel_informe().setVisible(false);
					view2.setVisible(true);

				}
				// PANEL DE ADMINISTRADOR GENERADOR DEL INFORME 
				
				if(view.getPanel_admin().getPanel_informe().getCombo_eleccion() == event.getSource()){	
					String aux,aux2;
					try {
				
					
					switch(view.getPanel_admin().getPanel_informe()
							.getCombo_eleccion().getSelectedIndex()){
					
					case 0: 
						view.getPanel_admin().getPanel_informe().getCombo_Fecha().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_tienda().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCampo_usuario().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_hora().setVisible(false);
						view.getPanel_admin().getPanel_informe().getBoton_generar_pfd().setVisible(false);
						view.getPanel_admin().getPanel_informe().getBoton_vista_previa().setVisible(false);
						
						break;
						// leer la lista de fechas registradas 
					case 1:
						
						view.getPanel_admin().getPanel_informe().getCombo_Fecha().setVisible(true);
						view.getPanel_admin().getPanel_informe().getCombo_tienda().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCampo_usuario().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_hora().setVisible(true);
						view.getPanel_admin().getPanel_informe().getBoton_generar_pfd().setVisible(true);
						view.getPanel_admin().getPanel_informe().getBoton_vista_previa().setVisible(true);
						
						// leer la lista de horarios según la fecha
						switch ( view.getPanel_admin().getPanel_informe().getCombo_Fecha().getSelectedIndex()){
							
						}
						break;
					case 2:
						
						view.getPanel_admin().getPanel_informe().getCombo_tienda().setVisible(true);
						view.getPanel_admin().getPanel_informe().getCombo_Fecha().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCampo_usuario().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_hora().setVisible(false);
						view.getPanel_admin().getPanel_informe().getBoton_generar_pfd().setVisible(true);
						view.getPanel_admin().getPanel_informe().getBoton_vista_previa().setVisible(true);
						break;
					case 3 :
						view.getPanel_admin().getPanel_informe().getCampo_usuario().setVisible(true);
						view.getPanel_admin().getPanel_informe().getCombo_Fecha().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_hora().setVisible(false);
						view.getPanel_admin().getPanel_informe().getCombo_tienda().setVisible(false);
						view.getPanel_admin().getPanel_informe().getBoton_generar_pfd().setVisible(true);
						view.getPanel_admin().getPanel_informe().getBoton_vista_previa().setVisible(true);
						break;
					}
					
				}catch( Exception e) {
				System.out.println("Error al cargar  todo ");
				}
//					
				}
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

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta().setVisible(false);

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta().setVisible(false);

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

		// Panel Ver Info Pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().getBoton_regresar() == event
				.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta().setVisible(true);

			// Filas de la Tabla
			for (int i = 0; i < usuario.getParejas().size(); i++) {

				String nombre = usuario.getParejas().get(i);
				// Falta el cupo

				Object[] datos_filas = { nombre };
				view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().getModel().addRow(datos_filas);

			}

		}

		// Panel Asignar Horario
		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getCombobox_parejas().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getCalendario().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().setVisible(false);

			SimpleDateFormat dp = new SimpleDateFormat("HH:mm");

			String t = dp.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getSpinner().getValue());

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

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda() == event.getSource()) {

			String nombre_tienda = view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_nombre().getText();
			String direccion_tienda = view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_direccion().getText();

			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String hora_a = sdf.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_apertura().getValue());
			String hora_c = sdf.format(view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_cierre().getValue());

			// Horas validacion
			SimpleDateFormat sdf2 = new SimpleDateFormat("HHmm");
			String hora_apertura = sdf2.format(view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getPnl_nueva_tienda().getSpinner_hora_apertura().getValue());
			String hora_cierre = sdf2.format(view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getPnl_nueva_tienda().getSpinner_hora_cierre().getValue());

			if (nombre_tienda.isEmpty() || direccion_tienda.isEmpty()) {
				view.mostrarMensajes("CAMPOS_FALSE");

			} else {

				try {

					comprobarHorarioTienda(hora_apertura, hora_cierre);
					if (tiendaDAO.agregarTienda(nombre_tienda, direccion_tienda, hora_a, hora_c, lista_tiendas)) {

						view.mostrarMensajes("TIENDA_TRUE");
						view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
								.getPnl_nueva_tienda().setVisible(false);
						view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getTable()
								.setVisible(true);
						view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
								.getBoton_agregar_nueva_tienda().setVisible(true);
						view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda()
								.getBoton_agregar_tienda().setVisible(true);
						view.getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getScroll()
								.setVisible(true);
					} else {
						view.mostrarMensajes("TIENDA_FALSE");
					}

				} catch (HorarioExcepcion e) {
					view.mostrarMensajes(e.getMessage());
				}

			}
		}

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto con
	 * las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la clase
	 * NombresExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param n Este parametro corresponde al nombre ingresado por el usuario que
	 *          debe de analizarse para ver si se efectua la excepcion.
	 * @throws NombresExcepcion Esta excepcion corresponde a las limitaciones
	 *                          impuestas al nombre
	 */
	public void comprobarNombre(String n) throws NombresExcepcion {
		if (n.matches(numeros)) {
			throw new NombresExcepcion("NOMBRE_FALSE");
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto con
	 * las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la clase
	 * HorarioExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param a Este parametro corresponde al horario de apertura ingresado por el
	 *          usuario que debe de analizarse para ver si se efectua la excepcion.
	 * @param c Este parametro corresponde al horario de cierre ingresado por el
	 *          usuario que debe de analizarse para ver si se efectua la excepcion.
	 * @throws HorarioExcepcion Esta excepcion corresponde a las limitaciones
	 *                          impuestas al horario de apertura y cierre.
	 */
	public void comprobarHorarioTienda(String a, String c) throws HorarioExcepcion {
		int hora_apertura = Integer.parseInt(a);

		int hora_cierre = Integer.parseInt(c);

		if (hora_apertura > hora_cierre) {
			throw new HorarioExcepcion("HORARIO_FALSE");
		}
	}

	public ArrayList<Tiendas> getTiendas() {
		return lista_tiendas;
	}

}
