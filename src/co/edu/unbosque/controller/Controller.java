package co.edu.unbosque.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.ContraseñaExcepcion;
import co.edu.unbosque.model.CupoExcepcion;
import co.edu.unbosque.model.EdadExcepcion;
import co.edu.unbosque.model.Estadisticas;
import co.edu.unbosque.model.GeneroExcepcion;
import co.edu.unbosque.model.HorarioExcepcion;
import co.edu.unbosque.model.MailExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Parejas;
import co.edu.unbosque.model.Solusoft;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.ValorCupoExcepcion;
import co.edu.unbosque.model.persistence.ArchivoTienda;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.TiendaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.Informe;
import co.edu.unbosque.view.VentanaGraficas;
import co.edu.unbosque.view.View;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Controller implements ActionListener, MouseListener{
	private View view;
	private VentanaGraficas view2;
	private Informe informe;
	private Solusoft solusoft;
	
	private Estadisticas estadisticas;
	private ArchivoUsuario archivo_Usuario;
	private UsuarioDAO usuarioDAO;
	private TiendaDAO tiendaDAO;
	private ArchivoTienda archivo_tienda;
	private ArrayList<Tiendas> lista_tiendas;
	private ArrayList<Usuario> lista_usuarios;
	private Tiendas tienda_horarios;

	public Controller() throws IOException {
		super();
		solusoft = new Solusoft(null);
		view = new View(this);
		view2 = new VentanaGraficas();
		informe = new Informe(this);
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);
		lista_usuarios = new ArrayList<Usuario>();
		archivo_tienda = new ArchivoTienda();
		tiendaDAO = new TiendaDAO(archivo_tienda);
		lista_tiendas = new ArrayList<Tiendas>();
		lista_usuarios = archivo_Usuario.leerArchivo();
		lista_tiendas = archivo_tienda.leerArchivo();
		mouseListener(this);
		asignarTablaTiendas();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void actionPerformed(ActionEvent event) {
		// ACCION INGRESAR AL SISTEMA
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {
			ingresoSistema();
		}

		// ACCION REGISTRAR USUARIO
		if (view.getPanel1().getBoton_registrar() == event.getSource()) {
			registrarUsuario();
		}

		// INICIA SESIÓN USUARIO NORMAL

		// ----------------------------------------------------------------------------------------------------
		// PANEL ADMINISTRAR CUENTA

		// OJO del panel administrar cuenta de usuario inicio
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_ojo_oculto() == event.getSource()) {
			String nombreInicio = solusoft.getUsuario_inicio();
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
				String numero_tarjeta = "";
				for (int i = 0; i < lista_usuarios.size(); i++) {
					if (lista_usuarios.get(i).getUsuario().equals(nombreInicio)
							|| lista_usuarios.get(i).getCorreo()
									.equals(nombreInicio)) {
						numero_tarjeta = lista_usuarios.get(i)
								.getNumeroTarjeta();
					}
				}
				view.getPanel_us_inicio()
						.getPnl_adm_cuentas()
						.getLabel_tarjeta()
						.setText(
								"*" + numero_tarjeta.charAt(12)
										+ numero_tarjeta.charAt(13)
										+ numero_tarjeta.charAt(14)
										+ numero_tarjeta.charAt(15));
				// Ver el numero de tarjeta completo
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
				String numero_tarjeta = "";
				for (int i = 0; i < lista_usuarios.size(); i++) {
					if (lista_usuarios.get(i).getUsuario().equals(nombreInicio)
							|| lista_usuarios.get(i).getCorreo()
									.equals(nombreInicio)) {
						numero_tarjeta = lista_usuarios.get(i)
								.getNumeroTarjeta();
					}
				}
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getLabel_tarjeta().setText(numero_tarjeta);
			}
		}

		// Boton CERRAR SESIÓN del panel administrar cuenta de usuario inicio
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_cerrar_sesion() == event.getSource()) {
			view.getPanel_us_inicio().setVisible(false);
			view.getPanel1().setVisible(true);
			view.getPanel_admin().setVisible(false);
			solusoft.setUsuario_inicio(null);
			solusoft.setValorCupo(0);
			solusoft.setValorVariable(0);
		}

		// Boton ADMINISTRAR CUPO del panel administrar cuenta de usuario inicio
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_adm_cuota() == event
				.getSource()) {
			String nombreInicio = solusoft.getUsuario_inicio();
			// Si el cupo es 0
			long cupo = 0;
			for (int i = 0; i < lista_usuarios.size(); i++) {
				if (lista_usuarios.get(i).getUsuario().equals(nombreInicio)) {
					cupo = lista_usuarios.get(i).getCupoTarjeta();
				}
			}
			try {
				comprobarCupo(cupo);
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getPnl_adm_cupo().setVisible(true);
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.visibilidadComponentes(false);
			} catch (CupoExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			}
		}

		// PANEL ADMINISTRAR CUPO

		// Boton REGRESAR del panel administrar cupo
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
				.getBoton_regresar() == event.getSource()) {
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
					.getCampo_texto_cupo().setText("");
		}

		// Boton CONFIRMAR del panel administrar cupo
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
				.getBoton_validar_cupo() == event.getSource()) {
			String nombreInicio = solusoft.getUsuario_inicio();
			try {
				String cupo = view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getPnl_adm_cupo().getCampo_texto_cupo().getText();
				if (!cupo.isEmpty()) {
					comprobarValorCupo(cupo);
					long cupo_long = Long.parseLong(cupo);
					NumberFormat formatoImporte = NumberFormat
							.getCurrencyInstance(new Locale("en", "US"));
					int resultado = JOptionPane.showConfirmDialog(null,
							"Por favor confirmar el valor ingresado como cupo"
									+ "\n" + formatoImporte.format(cupo_long),
							"Confirmación", JOptionPane.YES_NO_OPTION);
					if (resultado == JOptionPane.YES_OPTION) {

						for (int i = 0; i < lista_usuarios.size(); i++) {
							if (lista_usuarios.get(i).getUsuario()
									.equals(nombreInicio)) {
								lista_usuarios.get(i).setCupoTarjeta(cupo_long);
								lista_usuarios.get(i).setNombre(
										lista_usuarios.get(i).getNombre());
								lista_usuarios.get(i).setContraseña(
										lista_usuarios.get(i).getContraseña());
								lista_usuarios.get(i).setCorreo(
										lista_usuarios.get(i).getCorreo());
								lista_usuarios.get(i).setGenero(
										lista_usuarios.get(i).getGenero());
								lista_usuarios.get(i).setNumeroTarjeta(
										lista_usuarios.get(i)
												.getNumeroTarjeta());
								lista_usuarios.get(i).setTipoUsuario(
										lista_usuarios.get(i).getTipoUsuario());
								lista_usuarios.get(i).setParejas(
										lista_usuarios.get(i).getParejas());
								lista_usuarios.get(i).setUsuario(nombreInicio);
							}
						}
						archivo_Usuario.getArchivo_Usuarios().delete();
						archivo_Usuario.getArchivo_Usuarios().createNewFile();
						archivo_Usuario.escribirEnArchivo(lista_usuarios);
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.getLabel_cupo()
								.setText(formatoImporte.format(cupo_long));
						solusoft.setValorCupo(Integer.parseInt(cupo));
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.getPnl_adm_cupo().setVisible(false);
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.visibilidadComponentes(true);
						agregarInfoUsuario(nombreInicio);
					} else {
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.getPnl_adm_cupo().getCampo_texto_cupo()
								.setText(null);
					}
				}
			} catch (ValorCupoExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			} catch (IOException e) {
				view.mostrarMensajes(e.getMessage());
			}
		}

		// Boton AGREGAR PAREJA del panel administrar cuenta de usuario inicio
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja() == event.getSource()) {
			String nombreInicio = solusoft.getUsuario_inicio();
			if (usuarioDAO.buscarUsuario(nombreInicio, lista_usuarios)
					.getCupoTarjeta() != 0) {
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getPnl_agregar_pareja().setVisible(true);
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.visibilidadComponentes(false);
			} else {
				view.mostrarMensajes("CUPO ES CERO");
			}
		}

		// Boton COMPRAS del panel administrar cuenta de usuario inicio
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_compra() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.visibilidadComponentes(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ingresar_compra().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ver_historial().setVisible(false);

		}
		// PANEL COMPRAS
		// Boton VER HISTORIAL del panel compras
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_historial() == event.getSource()) {
			verHistorialCompras();
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ver_historial().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ingresar_compra().visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ingresar_compra().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ver_historial().visibilidadComponentes(true);
		}

		// Boton INGRESAR COMPRA del panel compras
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_ingresar_compra() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ingresar_compra().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ver_historial().visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ver_historial().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.getPnl_ingresar_compra().visibilidadComponentes(true);
		}
		// PANEL INGRESAR COMPRA
		// Boton AGREGAR COMPRA del panel ingresar compra
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getPnl_ingresar_compra().getBoton_agregar_compra() == event
				.getSource()) {
			agregarCompras();
		}
		// Boton REGRESAR del panel compras
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_regresar() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(true);

		}

		// PANEL AGREGAR PAREJA

		// Boton REGRESAR del panel agregar pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_agregar_pareja().getBoton_regresar() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_agregar_pareja().getCampo_texto_nombre()
					.setText("");
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_agregar_pareja().getCampo_texto_cupo().setText("");
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(true);
		}

		// Boton AGREGAR PAREJA del panel agregar pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_agregar_pareja().getBoton_agregar_nueva_pareja() == event
				.getSource()) {
			agregarPareja();
		}

		// Boton VER INFORMACION PAREJAS del panel administrar cuenta de usuario
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_info_pareja() == event.getSource()) {
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_ver_info_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(false);
			asignarTablaParejas();
		}

		// PANEL VER INFORMACION PAREJAS

		// Boton REGRESAR del panel ver informacion parejas
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_ver_info_pareja().getBoton_regresar() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.getPnl_ver_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas()
					.visibilidadComponentes(true);
		}

		// -----------------------------------------------------------------------------
		// PANEL ASIGNAR HORARIOS

		// Boton SELECCIONAR TIENDA del panel asignar horarios de usuario inicio
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda() == event.getSource()) {

			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().visibilidadComponentes(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getBoton_agregar_horario().setEnabled(false);
			SimpleDateFormat dp = new SimpleDateFormat("HH:mm");

			String t = dp.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getSpinner().getValue());

		}

		// PANEL SELECCIONAR TIENDA

		// Boton CONFIRMAR SELECCION del panel seleccionar tienda
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_tienda() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.visibilidadComponentes(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setEnabled(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getBoton_agregar_horario().setEnabled(true);
		}
		// Boton REGRESAR del panel seleccionar tienda
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_regresar() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setEnabled(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.visibilidadComponentes(true);
		}
		// Boton AGREGAR NUEVA TIENDA del panel seleccionar tienda
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda() == event
				.getSource()) {
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
					.setVisible(true);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().visibilidadComponentes(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setEnabled(false);
		}
		// PANEL NUEVA TIENDA

		// Boton REGRESAR del panel nueva tienda
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_regresar() == event.getSource()) {
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
					.setVisible(false);
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().visibilidadComponentes(true);

		}

		// Boton CONFIRMAR SELECCION del panel nueva tienda
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda() == event.getSource()) {
			String nombre_tienda = view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_nombre().getText();
			String direccion_tienda = view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getCampo_texto_direccion().getText();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String hora_a = sdf.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_apertura()
					.getValue());
			String hora_c = sdf.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_cierre().getValue());
			// Horas validacion
			SimpleDateFormat sdf2 = new SimpleDateFormat("HHmm");
			String hora_apertura = sdf2.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_apertura()
					.getValue());
			String hora_cierre = sdf2.format(view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getPnl_seleccionar_tienda()
					.getPnl_nueva_tienda().getSpinner_hora_cierre().getValue());
			Boolean esta = false;
			for (int i = 0; i < lista_tiendas.size(); i++) {
				if (lista_tiendas.get(i).getDireccion()
						.equalsIgnoreCase(direccion_tienda)) {
					esta = true;
				}
			}
			if (!nombre_tienda.isEmpty() && !direccion_tienda.isEmpty()) {
				try {
					comprobarHorarioTienda(hora_apertura, hora_cierre);

					if (!esta
							&& tiendaDAO.agregarTienda(nombre_tienda,
									direccion_tienda, hora_a, hora_c,
									lista_tiendas)) {
						view.mostrarMensajes("TIENDA_TRUE");
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda().setVisible(true);
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda()
								.visibilidadComponentes(true);
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getBoton_agregar_horario().setEnabled(false);
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda()
								.getPnl_nueva_tienda().setVisible(false);
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda()
								.getPnl_nueva_tienda()
								.getCampo_texto_direccion().setText("");
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda()
								.getPnl_nueva_tienda().getCampo_texto_nombre()
								.setText("");
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.getPnl_compras().getPnl_ingresar_compra()
								.getCombobox_tiendas().removeAllItems();
						for (int i = 0; i < lista_tiendas.size(); i++) {
							view.getPanel_us_inicio()
									.getPnl_adm_cuentas()
									.getPnl_compras()
									.getPnl_ingresar_compra()
									.getCombobox_tiendas()
									.addItem(
											lista_tiendas
													.get(i)
													.getNombre()
													.concat(" - "
															+ lista_tiendas
																	.get(i)
																	.getDireccion()));
						}
						// primero borrra
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getPnl_seleccionar_tienda().getModel()
								.setRowCount(0);
						// luego carga
						lista_tiendas = archivo_tienda.leerArchivo();
						for (int i = 0; i < lista_tiendas.size(); i++) {
							String nombre = lista_tiendas.get(i).getNombre();
							String direccion = lista_tiendas.get(i)
									.getDireccion();
							String hora_ap = lista_tiendas.get(i)
									.getHorario_apertura();
							String hora_ci = lista_tiendas.get(i)
									.getHorario_cierre();
							Object[] datos_filas = { nombre, direccion,
									hora_ap, hora_ci };
							view.getPanel_us_inicio().getPnl_asignar_horarios()
									.getPnl_seleccionar_tienda().getModel()
									.addRow(datos_filas);
						}
					} else {
						view.mostrarMensajes("TIENDA_FALSE");
					}
				} catch (HorarioExcepcion e) {
					view.mostrarMensajes(e.getMessage());

				}
			} else {
				view.mostrarMensajes("CAMPOS_FALSE");
			}

		}
		// Boton AGREGAR HORARIO del panel asignar horarios de usuario inicio
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario() == event.getSource()) {
			String nombreInicio = solusoft.getUsuario_inicio();
			int numElementosPareja = view.getPanel_us_inicio()
					.getPnl_asignar_horarios().getCombobox_parejas()
					.getItemCount();

			if (numElementosPareja == 0) {
				view.mostrarMensajes("PAREJA_FALSE");
			} else {
				String pareja = (String) view.getPanel_us_inicio()
						.getPnl_asignar_horarios().getCombobox_parejas()
						.getSelectedItem();
				DateFormat formatoHora = new SimpleDateFormat("HH:mm");
				DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
				Date dateActual = new Date();
				String horaActual = formatoHora.format(dateActual);
				String fechaActual = formatoFecha.format(dateActual);
				String hora = formatoHora.format(view.getPanel_us_inicio()
						.getPnl_asignar_horarios().getSpinner().getValue());
				String fecha = null;
				if (view.getPanel_us_inicio().getPnl_asignar_horarios()
						.getCalendario().getDate() == null) {
					view.mostrarMensajes("FECHA_FALSE");
				} else {

					fecha = formatoFecha.format(view.getPanel_us_inicio()
							.getPnl_asignar_horarios().getCalendario()
							.getDate());
					if (fechaActual.compareTo(fecha) > 0) {
						view.mostrarMensajes("FECHA_PASADA_FALSE");
					} else if (fechaActual.compareTo(fecha) < 0) {
						if (hora.compareTo(tienda_horarios
								.getHorario_apertura()) > 0
								&& hora.compareTo(tienda_horarios
										.getHorario_cierre()) < 0) {
							if (usuarioDAO.agregarHorariosCompras(nombreInicio,
									tienda_horarios, pareja, fecha, hora)) {
								view.mostrarMensajes("HORARIO_TRUE");
							} else {
								view.mostrarMensajes("HORARIO_FALSE");
							}
						} else {
							view.mostrarMensajes("DISPONIBILIDAD_FALSE");
						}
					} else if (fechaActual.compareTo(fecha) == 0) {
						if (horaActual.compareTo(hora) < 0) {
							if (hora.compareTo(tienda_horarios
									.getHorario_apertura()) > 0
									&& hora.compareTo(tienda_horarios
											.getHorario_cierre()) < 0) {
								if (usuarioDAO.agregarHorariosCompras(
										nombreInicio, tienda_horarios, pareja,
										fecha, hora)) {
									view.getPanel_us_inicio()
											.getPnl_asignar_horarios()
											.getBoton_agregar_horario()
											.setEnabled(false);
									view.mostrarMensajes("HORARIO_TRUE");
								} else {
									view.mostrarMensajes("HORARIO_FALSE");
								}
							} else {
								view.mostrarMensajes("DISPONIBILIDAD_FALSE");
							}
						} else {
							view.mostrarMensajes("HORA_PASADA_FALSE");
						}
					}
				}
			}

		}

		// ------------------------------------------------------------------------------
		// ADMINISTRADOR MOSTRAR USUARIOS
		if (view.getPanel_admin().getPanel_usuarios().getBoton_ver_usuarios() == event
				.getSource()) {
			// primero borra la tabla
			view.getPanel_admin().getPanel_usuarios().getModel1()
					.setRowCount(0);

			// mostrar todos los usuarios
			for (int i = 0; i < lista_usuarios.size(); i++) {

				String nombre = lista_usuarios.get(i).getNombre();
				String correo = lista_usuarios.get(i).getCorreo();
				String alias = lista_usuarios.get(i).getUsuario();
				String genero = lista_usuarios.get(i).getGenero();
				String numerotarjeta = lista_usuarios.get(i).getNumeroTarjeta();
				long cupo = lista_usuarios.get(i).getCupoTarjeta();
				int edad = lista_usuarios.get(i).getEdad();
				NumberFormat formatoImporte = NumberFormat
						.getCurrencyInstance(new Locale("en", "US"));

				Object[] datos_filas = { nombre, alias, correo, edad, genero,
						numerotarjeta, formatoImporte.format(cupo) };
				view.getPanel_admin().getPanel_usuarios().getModel1()
						.addRow(datos_filas);
			}

		}

		// BOTON ADMINISTRADOR BUSCAR USUARIO
		if (view.getPanel_admin().getPanel_usuarios().getboton_buscar_usuario() == event
				.getSource()) {
			String buscar = view.getPanel_admin().getPanel_usuarios()
					.getCampo_buscar().getText();
			Usuario aux = null;
			if (!buscar.isEmpty()) {
				if (view.getPanel_admin().getPanel_usuarios().getCombo_buscar()
						.getSelectedItem().toString()
						.equalsIgnoreCase("Seleccione")) {
					view.mostrarMensajes("CampoBuscarUsuario_False");
					view.getPanel_admin().getPanel_usuarios().getCampo_buscar()
							.setText(null);
				}
				if (view.getPanel_admin().getPanel_usuarios().getCombo_buscar()
						.getSelectedItem().toString()
						.equalsIgnoreCase("Nombre")) {
					aux = usuarioDAO
							.buscarNombreUsuario(buscar, lista_usuarios);
					if (aux == null) {
						view.mostrarMensajes("BuscarUsuario_False");
					} else {
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.setRowCount(0);
						String nombre = aux.getNombre();
						String correo = aux.getCorreo();
						String alias = aux.getUsuario();
						String genero = aux.getGenero();
						String numerotarjeta = aux.getNumeroTarjeta();
						long cupo = aux.getCupoTarjeta();
						int edad = aux.getEdad();
						NumberFormat formatoImporte = NumberFormat
								.getCurrencyInstance(new Locale("en", "US"));

						Object[] datos_filas = { nombre, alias, correo, edad,
								genero, numerotarjeta,
								formatoImporte.format(cupo) };
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.addRow(datos_filas);
						view.getPanel_admin().getPanel_usuarios()
								.getCampo_buscar().setText(null);
					}
				}
				if (view.getPanel_admin().getPanel_usuarios().getCombo_buscar()
						.getSelectedItem().toString().equalsIgnoreCase("Alias")) {
					aux = usuarioDAO.buscarUsuario(buscar, lista_usuarios);
					if (aux == null) {
						view.mostrarMensajes("BuscarUsuario_False");
					} else {
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.setRowCount(0);
						String nombre = aux.getNombre();
						String correo = aux.getCorreo();
						String alias = aux.getUsuario();
						String genero = aux.getGenero();
						String numerotarjeta = aux.getNumeroTarjeta();
						long cupo = aux.getCupoTarjeta();
						int edad = aux.getEdad();
						NumberFormat formatoImporte = NumberFormat
								.getCurrencyInstance(new Locale("en", "US"));

						Object[] datos_filas = { nombre, alias, correo, edad,
								genero, numerotarjeta,
								formatoImporte.format(cupo) };
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.addRow(datos_filas);
						view.getPanel_admin().getPanel_usuarios()
								.getCampo_buscar().setText(null);
					}
				}
				if (view.getPanel_admin().getPanel_usuarios().getCombo_buscar()
						.getSelectedItem().toString()
						.equalsIgnoreCase("Correo")) {
					aux = usuarioDAO.buscarCorreo(buscar, lista_usuarios);
					if (aux == null) {
						view.mostrarMensajes("BuscarUsuario_False");
					} else {
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.setRowCount(0);
						String nombre = aux.getNombre();
						String correo = aux.getCorreo();
						String alias = aux.getUsuario();
						String genero = aux.getGenero();
						String numerotarjeta = aux.getNumeroTarjeta();
						long cupo = aux.getCupoTarjeta();
						int edad = aux.getEdad();
						NumberFormat formatoImporte = NumberFormat
								.getCurrencyInstance(new Locale("en", "US"));

						Object[] datos_filas = { nombre, alias, correo, edad,
								genero, numerotarjeta,
								formatoImporte.format(cupo) };
						view.getPanel_admin().getPanel_usuarios().getModel1()
								.addRow(datos_filas);
						view.getPanel_admin().getPanel_usuarios()
								.getCampo_buscar().setText(null);
					}
				}

			} else {
				view.mostrarMensajes("INFORMACION_FALSE");
			}

		}

		// BOTON ADMINISTRADOR VER PAREJAS
		if (view.getPanel_admin().getPanel_usuarios().getver_parejas() == event
				.getSource()) {
			int n = view.getPanel_admin().getPanel_usuarios().getTabla1()
					.getSelectedRow();
			int numero_filas = view.getPanel_admin().getPanel_usuarios()
					.getTabla1().getRowCount();

			if (numero_filas == 1) {
				String alias = view.getPanel_admin().getPanel_usuarios()
						.getTabla1().getValueAt(0, 1).toString();
				if (!usuarioDAO.buscarUsuario(alias, lista_usuarios)
						.getParejas().isEmpty()) {
					for (int i = 0; i < usuarioDAO
							.buscarUsuario(alias, lista_usuarios).getParejas()
							.size(); i++) {

						String nombre = usuarioDAO
								.buscarUsuario(alias, lista_usuarios)
								.getParejas().get(i).getNombre();
						double cupo = usuarioDAO
								.buscarUsuario(alias, lista_usuarios)
								.getParejas().get(i)
								.getCantidad_cupo_asignado();
						NumberFormat formatoImporte = NumberFormat
								.getCurrencyInstance(new Locale("en", "US"));
						Object[] datos_filas = { nombre,
								formatoImporte.format(cupo) };
						view.getPanel_admin().getPanel_usuarios().getModel2()
								.addRow(datos_filas);

					}
				} else {
					view.mostrarMensajes("REGISTRO_PAREJAS_FALSE");
					view.getPanel_admin().getPanel_usuarios().getModel2()
							.setRowCount(0);
				}
			} else {
				if (n >= 0) {
					Usuario aux = lista_usuarios.get(n);
					view.getPanel_admin().getPanel_usuarios().getModel2()
							.setRowCount(0);

					// mostrar todos los usuarios
					if (!usuarioDAO
							.buscarUsuario(aux.getUsuario(), lista_usuarios)
							.getParejas().isEmpty()) {
						for (int i = 0; i < aux.getParejas().size(); i++) {

							String nombre = aux.getParejas().get(i).getNombre();
							double cupo = aux.getParejas().get(i)
									.getCantidad_cupo_asignado();
							NumberFormat formatoImporte = NumberFormat
									.getCurrencyInstance(new Locale("en", "US"));
							Object[] datos_filas = { nombre,
									formatoImporte.format(cupo) };
							view.getPanel_admin().getPanel_usuarios()
									.getModel2().addRow(datos_filas);

						}
					} else {
						view.mostrarMensajes("REGISTRO_PAREJAS_FALSE");
						view.getPanel_admin().getPanel_usuarios().getModel2()
								.setRowCount(0);
					}
				} else if (n == -1) {
					view.mostrarMensajes("ELEGIR_USUARIO_FALSE");
				}

			}

		}

		// BOTON ADMINISTRADOR ELIMINAR USUARIOS

		if (view.getPanel_admin().getPanel_usuarios().getBoton_eliminar() == event
				.getSource())

		{

			int n = view.getPanel_admin().getPanel_usuarios().getTabla1()
					.getSelectedRow();

			if (n >= 0) {
				Usuario aux = lista_usuarios.get(n);
				usuarioDAO.eliminarUsuario(aux.getUsuario(), lista_usuarios);
				view.mostrarMensajes("ELIMINAR_USUARIO_TRUE");

				view.getPanel_admin().getPanel_usuarios().getModel1()
						.setRowCount(0);

				// BOTON VER USUARIOS
				for (int i = 0; i < lista_usuarios.size(); i++) {

					String nombre = lista_usuarios.get(i).getNombre();
					String correo = lista_usuarios.get(i).getCorreo();
					String alias = lista_usuarios.get(i).getUsuario();
					String genero = lista_usuarios.get(i).getGenero();
					String numerotarjeta = lista_usuarios.get(i)
							.getNumeroTarjeta();
					long cupo = lista_usuarios.get(i).getCupoTarjeta();
					int edad = lista_usuarios.get(i).getEdad();
					NumberFormat formatoImporte = NumberFormat
							.getCurrencyInstance(new Locale("en", "US"));

					Object[] datos_filas = { nombre, alias, correo, edad,
							genero, numerotarjeta, formatoImporte.format(cupo) };
					view.getPanel_admin().getPanel_usuarios().getModel1()
							.addRow(datos_filas);
				}
			} else if (n == -1) {
				view.mostrarMensajes("ELEGIR_USUARIO_FALSE");
			}

		}

		// BOTON ORDENAR USUARIOS POR NOMBRE
		if (view.getPanel_admin().getPanel_usuarios().getboton_orden_nombreu() == event
				.getSource()) {
			if (usuarioDAO.ordenNombreAsc(lista_usuarios)) {
				view.getPanel_admin().getPanel_usuarios().getModel1()
						.setRowCount(0);

				// BOTON VER USUARIOS
				for (int i = 0; i < lista_usuarios.size(); i++) {

					String nombre = lista_usuarios.get(i).getNombre();
					String correo = lista_usuarios.get(i).getCorreo();
					String alias = lista_usuarios.get(i).getUsuario();
					String genero = lista_usuarios.get(i).getGenero();
					String numerotarjeta = lista_usuarios.get(i)
							.getNumeroTarjeta();
					long cupo = lista_usuarios.get(i).getCupoTarjeta();
					int edad = lista_usuarios.get(i).getEdad();
					NumberFormat formatoImporte = NumberFormat
							.getCurrencyInstance(new Locale("en", "US"));

					Object[] datos_filas = { nombre, alias, correo, edad,
							genero, numerotarjeta, formatoImporte.format(cupo) };
					view.getPanel_admin().getPanel_usuarios().getModel1()
							.addRow(datos_filas);
				}
			} else {
				view.mostrarMensajes("ORDENAMIENTO_FALSE");
			}

		}

		// BOTON USUARIOS ORDENAR POR ALIAS
		if (view.getPanel_admin().getPanel_usuarios().getboton_orden_aliasu() == event
				.getSource()) {
			if (usuarioDAO.ordenAliasAsc(lista_usuarios)) {
				view.getPanel_admin().getPanel_usuarios().getModel1()
						.setRowCount(0);

				// BOTON VER USUARIOS
				for (int i = 0; i < lista_usuarios.size(); i++) {

					String nombre = lista_usuarios.get(i).getNombre();
					String correo = lista_usuarios.get(i).getCorreo();
					String alias = lista_usuarios.get(i).getUsuario();
					String genero = lista_usuarios.get(i).getGenero();
					String numerotarjeta = lista_usuarios.get(i)
							.getNumeroTarjeta();
					long cupo = lista_usuarios.get(i).getCupoTarjeta();
					int edad = lista_usuarios.get(i).getEdad();
					NumberFormat formatoImporte = NumberFormat
							.getCurrencyInstance(new Locale("en", "US"));

					Object[] datos_filas = { nombre, alias, correo, edad,
							genero, numerotarjeta, formatoImporte.format(cupo) };
					view.getPanel_admin().getPanel_usuarios().getModel1()
							.addRow(datos_filas);
				}
			} else {
				view.mostrarMensajes("ORDENAMIENTO_FALSE");
			}

		}

		// BOTON USUARIOS ORDENAR POR CORREO
		if (view.getPanel_admin().getPanel_usuarios().getboton_orden_correou() == event
				.getSource()) {
			if (usuarioDAO.ordenCorreoAsc(lista_usuarios)) {
				view.getPanel_admin().getPanel_usuarios().getModel1()
						.setRowCount(0);

				// BOTON VER USUARIOS
				for (int i = 0; i < lista_usuarios.size(); i++) {

					String nombre = lista_usuarios.get(i).getNombre();
					String correo = lista_usuarios.get(i).getCorreo();
					String alias = lista_usuarios.get(i).getUsuario();
					String genero = lista_usuarios.get(i).getGenero();
					String numerotarjeta = lista_usuarios.get(i)
							.getNumeroTarjeta();
					long cupo = lista_usuarios.get(i).getCupoTarjeta();
					int edad = lista_usuarios.get(i).getEdad();
					NumberFormat formatoImporte = NumberFormat
							.getCurrencyInstance(new Locale("en", "US"));

					Object[] datos_filas = { nombre, alias, correo, edad,
							genero, numerotarjeta, formatoImporte.format(cupo) };
					view.getPanel_admin().getPanel_usuarios().getModel1()
							.addRow(datos_filas);
				}
			} else {
				view.mostrarMensajes("ORDENAMIENTO_FALSE");
			}

		}

		// --------------------------------------------------------------------------
		// BOTON BUSCAR POR NOMBRE DE TIENDA

		if (view.getPanel_admin().getPanel_tiendas()
				.getboton_buscar_pornombre() == event.getSource()) {

			if (!view.getPanel_admin().getPanel_tiendas().getCampo_buscar()
					.getText().isEmpty()) {
				String n = view.getPanel_admin().getPanel_tiendas()
						.getCampo_buscar().getText();

				Tiendas aux = tiendaDAO.buscarTienda(n, lista_tiendas);
				view.getPanel_admin().getPanel_tiendas().getModel()
						.setRowCount(0);
				String nombre = aux.getNombre();
				String direccion = aux.getDireccion();
				String hora_ap = aux.getHorario_apertura();
				String hora_ci = aux.getHorario_cierre();

				Object[] datos_filas = { nombre, direccion, hora_ap, hora_ci };
				view.getPanel_admin().getPanel_tiendas().getModel()
						.addRow(datos_filas);

			} else {
				view.mostrarMensajes("INFORMACION_FALSE");
			}

		}

		// BOTON VER TIENDAS
		if (view.getPanel_admin().getPanel_tiendas().getBoton_ver_tiendas() == event
				.getSource()) {
			// primero borra la tabla
			view.getPanel_admin().getPanel_tiendas().getModel().setRowCount(0);
			// luego muestra las tiendas de nuevo
			lista_tiendas = archivo_tienda.leerArchivo();
			for (int i = 0; i < lista_tiendas.size(); i++) {

				String nombre = lista_tiendas.get(i).getNombre();
				String direccion = lista_tiendas.get(i).getDireccion();
				String hora_ap = lista_tiendas.get(i).getHorario_apertura();
				String hora_ci = lista_tiendas.get(i).getHorario_cierre();

				Object[] datos_filas = { nombre, direccion, hora_ap, hora_ci };
				view.getPanel_admin().getPanel_tiendas().getModel()
						.addRow(datos_filas);
			}
		}

		// AGREGAR NUEVA TIENDA EN ADMINISTRADR

		if (view.getPanel_admin().getPanel_tiendas().getBoton_agregar_tienda() == event
				.getSource()) {

			String nombre_tienda = view.getPanel_admin().getPanel_tiendas()
					.getCampo_nombre().getText();
			String direccion_tienda = view.getPanel_admin().getPanel_tiendas()
					.getCampo_direccion().getText();

			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String hora_a = sdf.format(view.getPanel_admin().getPanel_tiendas()
					.getSpinner_apertura().getValue());
			String hora_c = sdf.format(view.getPanel_admin().getPanel_tiendas()
					.getSpinner_cierre().getValue());

			// Horas validacion
			SimpleDateFormat sdf2 = new SimpleDateFormat("HHmm");
			String hora_apertura = sdf2.format(view.getPanel_admin()
					.getPanel_tiendas().getSpinner_apertura().getValue());
			String hora_cierre = sdf2.format(view.getPanel_admin()
					.getPanel_tiendas().getSpinner_cierre().getValue());

			if (nombre_tienda.isEmpty() || direccion_tienda.isEmpty()) {
				view.mostrarMensajes("CAMPOS_FALSE");

			} else {

				try {

					comprobarHorarioTienda(hora_apertura, hora_cierre);
					if (tiendaDAO.agregarTienda(nombre_tienda,
							direccion_tienda, hora_a, hora_c, lista_tiendas)) {

						view.mostrarMensajes("TIENDA_TRUE");
						// primero borra la info

						view.getPanel_admin().getPanel_tiendas().getModel()
								.setRowCount(0);
						// luego la muestra de nuevo
						lista_tiendas = archivo_tienda.leerArchivo();
						for (int i = 0; i < lista_tiendas.size(); i++) {

							String nombre = lista_tiendas.get(i).getNombre();
							String direccion = lista_tiendas.get(i)
									.getDireccion();
							String hora_ap = lista_tiendas.get(i)
									.getHorario_apertura();
							String hora_ci = lista_tiendas.get(i)
									.getHorario_cierre();

							Object[] datos_filas = { nombre, direccion,
									hora_ap, hora_ci };
							view.getPanel_admin().getPanel_tiendas().getModel()
									.addRow(datos_filas);
							//

						}

					} else {
						view.mostrarMensajes("TIENDA_FALSE");
					}

				} catch (HorarioExcepcion e) {
					view.mostrarMensajes(e.getMessage());
				}

			}
			view.getPanel_admin().getPanel_tiendas().getCampo_direccion()
					.setText("");
			view.getPanel_admin().getPanel_tiendas().getCampo_nombre()
					.setText("");

		}

		// PANEL VISTA TIENDAS EN ADMINISTRADOR

		// ELIMINAR TIENDA

		if (view.getPanel_admin().getPanel_tiendas().getBoton_eliminar() == event
				.getSource()) {

			if (view.getPanel_admin().getPanel_tiendas().getCombo_tiendas()
					.getSelectedItem() == "Por nombre") {

				if (view.getPanel_admin().getPanel_tiendas().getCampo_buscar()
						.getText().equals("")) {
					view.mostrarMensajes("ELIMINAR_TIENDA_VACIO");
				} else {
					if (tiendaDAO.eliminarTienda(view.getPanel_admin()
							.getPanel_tiendas().getCampo_buscar().getText(),
							lista_tiendas)) {
						view.mostrarMensajes("ELIMINAR_TIENDA_TRUE");
						view.getPanel_admin().getPanel_tiendas().getModel()
								.setRowCount(0);
						// luego la muestra de nuevo
						lista_tiendas = archivo_tienda.leerArchivo();
						for (int i = 0; i < lista_tiendas.size(); i++) {

							String nombre = lista_tiendas.get(i).getNombre();
							String direccion = lista_tiendas.get(i)
									.getDireccion();
							String hora_ap = lista_tiendas.get(i)
									.getHorario_apertura();
							String hora_ci = lista_tiendas.get(i)
									.getHorario_cierre();

							Object[] datos_filas = { nombre, direccion,
									hora_ap, hora_ci };
							view.getPanel_admin().getPanel_tiendas().getModel()
									.addRow(datos_filas);
						}
					} else {
						view.mostrarMensajes("ELIMINAR_TIENDA_FALSE");
					}
				}
			} else {
				int indec = view.getPanel_admin().getPanel_tiendas().getTabla()
						.getSelectedRow();

				if (indec >= 0) {
					Tiendas tienda = lista_tiendas.get(indec);
					tiendaDAO.eliminarTienda(tienda.getNombre(), lista_tiendas);
					view.mostrarMensajes("ELIMINAR_TIENDA_TRUE");
					view.getPanel_admin().getPanel_tiendas().getModel()
							.setRowCount(0);
					// luego la muestra de nuevo
					lista_tiendas = archivo_tienda.leerArchivo();
					for (int i = 0; i < lista_tiendas.size(); i++) {

						String nombre = lista_tiendas.get(i).getNombre();
						String direccion = lista_tiendas.get(i).getDireccion();
						String hora_ap = lista_tiendas.get(i)
								.getHorario_apertura();
						String hora_ci = lista_tiendas.get(i)
								.getHorario_cierre();

						Object[] datos_filas = { nombre, direccion, hora_ap,
								hora_ci };
						view.getPanel_admin().getPanel_tiendas().getModel()
								.addRow(datos_filas);
						//

					}
				} else if (indec == -1) {
					view.mostrarMensajes("ELEGIR_TIENDA_FALSE");
				}

			}

			view.getPanel_admin().getPanel_tiendas().getCampo_buscar()
					.setText(null);

		}

		// informe por usuario 
		if(view.getPanel_admin().getPanel_informe().getCombo_estadistica().getSelectedItem().equals("Por usuario")
				&&(view.getPanel_admin().getPanel_informe().getBoton_vista_previa()== event.getSource()) ){
			
			String nombre = view.getPanel_admin().getPanel_informe().getCampo_usuario().getText();
			
			
			
			informe.getPanel_informe_usuarios().setVisible(false);
			informe.setVisible(true);
			informe.getInforme_usuario_pareja().setVisible(true);
			
			
		}
		
		// panel informe por tiendas 
		if(view.getPanel_admin().getPanel_informe().getCombo_estadistica().getSelectedItem().equals("Tiendas")
				&&(view.getPanel_admin().getPanel_informe().getBoton_vista_previa()== event.getSource()) ){
			
				informe.getPanel_informe_usuarios().getModel2().setRowCount(0);
		
				for (int i = 0; i < lista_tiendas.size(); i++) {

					String nombre = lista_tiendas.get(i).getNombre();
					String direccion = lista_tiendas.get(i)
							.getDireccion();
					String hora_ap = lista_tiendas.get(i)
							.getHorario_apertura();
					String hora_ci = lista_tiendas.get(i)
							.getHorario_cierre();

					Object[] datos_filas = { nombre, direccion,
							hora_ap, hora_ci };
					informe.getPanel_informe_usuarios().getModel2().addRow(datos_filas);
					
				}
				informe.getInforme_usuario_pareja().setVisible(false);
				informe.setVisible(true);
				informe.getPanel_informe_usuarios().getScroll2().setVisible(true);
				informe.getPanel_informe_usuarios().getEtiqueta_tienda().setVisible(true);
				informe.getPanel_informe().getEtiqueta_usuario().setVisible(false);
				informe.getPanel_informe_usuarios().getScroll1().setVisible(false);
				informe.getPanel_informe_usuarios().setVisible(true);
				
			}
			
		
		
		// PANEL VISTA PREVIA DE LAS informe usuarios 
		if(view.getPanel_admin().getPanel_informe().getCombo_estadistica().getSelectedItem().equals("Todos los usuarios")
				&&(view.getPanel_admin().getPanel_informe().getBoton_vista_previa()== event.getSource()) ){
			informe.getPanel_informe_usuarios().getModel1().setRowCount(0);
			for (int i = 0; i < lista_usuarios.size(); i++) {
							String nombre = lista_usuarios.get(i).getNombre();
							String correo = lista_usuarios.get(i).getCorreo();
							String alias = lista_usuarios.get(i).getUsuario();
							String genero = lista_usuarios.get(i).getGenero();
							String numerotarjeta = lista_usuarios.get(i)
									.getNumeroTarjeta();
							long cupo = lista_usuarios.get(i).getCupoTarjeta();
							int edad = lista_usuarios.get(i).getEdad();
							NumberFormat formatoImporte = NumberFormat
									.getCurrencyInstance(new Locale("en", "US"));

							Object[] datos_filas = { nombre, alias, correo, edad,
									genero, numerotarjeta, formatoImporte.format(cupo) };
							informe.getPanel_informe().getModel1().addRow(datos_filas);
							
						}
					informe.getInforme_usuario_pareja().setVisible(false);
					informe.setVisible(true);
					informe.getPanel_informe_usuarios().getScroll1().setVisible(true);
					informe.getPanel_informe().setVisible(true);
					informe.getPanel_informe_usuarios().getEtiqueta_usuario().setVisible(true);
					informe.getPanel_informe_usuarios().getEtiqueta_tienda().setVisible(false);
					informe.getPanel_informe_usuarios().getScroll2().setVisible(false);
					}
				
			
						
		
		
		
			
 // MOSTRAR EN USUARIO EN EL INFORME
		
		// PANEL DE ADMINISTRADOR GENERADOR DEL INFORME
		if (view.getPanel_admin().getPanel_informe().getCombo_estadistica() == event.getSource()) {

			try {

				switch (view.getPanel_admin().getPanel_informe()
						.getCombo_estadistica().getSelectedIndex()) {
// "Seleccionar"
				case 0:

					view.getPanel_admin().getPanel_informe().setVisible(false);
					view.getPanel_admin().getPanel_informe()
							.visibilidadComponentes(false);

					break;
// "Edad"
				case 1:
					view.getPanel_admin().getPanel_informe().getCampo_usuario()
							.setVisible(false);
					view.getPanel_admin().getPanel_informe()
							.getBoton_generar_pfd().setVisible(true);
					view.getPanel_admin().getPanel_informe()
							.getBoton_vista_previa().setVisible(true);
					
					break;
//"Todos los usuarios"
				case 2:

					view.getPanel_admin().getPanel_informe().getCampo_usuario()
							.setVisible(false);
					view.getPanel_admin().getPanel_informe()
							.getBoton_generar_pfd().setVisible(true);
					view.getPanel_admin().getPanel_informe()
							.getBoton_vista_previa().setVisible(true);
					break;
//"Por usuario"	
				case 3:
					view.getPanel_admin().getPanel_informe().getCampo_usuario()
							.setVisible(true);
					view.getPanel_admin().getPanel_informe()
							.getBoton_generar_pfd().setVisible(true);
					view.getPanel_admin().getPanel_informe()
							.getBoton_vista_previa().setVisible(true);
					break;
//	"Por tienda"
				case 4:
					view.getPanel_admin().getPanel_informe().getCampo_usuario()
					.setVisible(false);
			view.getPanel_admin().getPanel_informe()
					.getBoton_generar_pfd().setVisible(true);
			view.getPanel_admin().getPanel_informe()
					.getBoton_vista_previa().setVisible(true);
					
					break;
				}

			} catch (Exception e) {
				System.out.println("Error al cargar  todo ");
			}
			//
		}

		// cerar sesion administrador
		if (view.getPanel_admin().getPanel_info().getBoton_cerrar() == event
				.getSource()) {

			view.getPanel_us_inicio().setVisible(false);
			view.getPanel1().setVisible(true);
			view.getPanel_admin().setVisible(false);
			view.getPanel1().limpiarCampos();

		}

	}

	public void asignarTablaTiendas() {
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getModel().setRowCount(0);
		lista_tiendas = archivo_tienda.leerArchivo();
		for (int i = 0; i < lista_tiendas.size(); i++) {

			String nombre = lista_tiendas.get(i).getNombre();
			String direccion = lista_tiendas.get(i).getDireccion();
			String hora_ap = lista_tiendas.get(i).getHorario_apertura();
			String hora_ci = lista_tiendas.get(i).getHorario_cierre();

			Object[] datos_filas = { nombre, direccion, hora_ap, hora_ci };
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getModel().addRow(datos_filas);

		}

	}

	public void asignarTablaParejas() {
		String nombreInicio = solusoft.getUsuario_inicio();
		view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja()
				.getModel().setRowCount(0);
		lista_usuarios = archivo_Usuario.leerArchivo();

		if (!usuarioDAO.buscarUsuario(nombreInicio, lista_usuarios)
				.getParejas().isEmpty()) {
			for (int i = 0; i < usuarioDAO
					.buscarUsuario(nombreInicio, lista_usuarios).getParejas()
					.size(); i++) {
				String nombre = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getParejas().get(i).getNombre();
				int cupo = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getParejas().get(i).getCupo();
				double cantidad_cupo_asignado = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getParejas().get(i).getCantidad_cupo_asignado();
				double cantidad_cupo_restante = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getParejas().get(i).getCantidad_cupo_restante();
				int edad = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getParejas().get(i).getEdad();
				NumberFormat formatoImporte = NumberFormat
						.getCurrencyInstance(new Locale("en", "US"));

				Object[] datos_filas = { nombre, edad, cupo,
						formatoImporte.format(cantidad_cupo_asignado),
						formatoImporte.format(cantidad_cupo_restante) };
				view.getPanel_us_inicio().getPnl_adm_cuentas()
						.getPnl_ver_info_pareja().getModel()
						.addRow(datos_filas);
			}
		}

	}

	public void registrarUsuario() {
		ArrayList<Parejas> parejas = new ArrayList<Parejas>();
		ArrayList<Compra> compras = new ArrayList<Compra>();
		String nombre, correo, usuario, contraseña, genero, numeroTarjeta, tipoUsuario;
		Date fechanacimiento = null;
		int edad = 0;
		nombre = correo = usuario = contraseña = genero = numeroTarjeta = tipoUsuario = "";

		long cupoTarjeta;
		nombre = view.getPanel1().getCampo_nombre().getText();
		correo = view.getPanel1().getCampo_correo().getText();
		usuario = view.getPanel1().getCampo_usuario().getText();
		numeroTarjeta = solusoft.generarNumeroCuenta(lista_usuarios);
		cupoTarjeta = 0;
		tipoUsuario = "Usuario";

		contraseña = new String(view.getPanel1().getCampo_contrasena()
				.getPassword());

		if (!nombre.isEmpty() && !correo.isEmpty() && !usuario.isEmpty()
				&& !contraseña.isEmpty()) {

			try {
				comprobarCorreo(correo);
				genero = comprobarGenero();
				comprobarNombre(nombre);
				comprobarContraseña(contraseña);
				edad = comprobarEdad(view.getPanel1().getCalendario().getDate());

				if (solusoft.comprobarExistenciaUsuario(correo, usuario,
						lista_usuarios)) {

					if (edad >= 18) {
						Usuario nuevo = new Usuario(nombre, genero, correo,
								usuario, contraseña, numeroTarjeta, edad,
								cupoTarjeta, parejas, tipoUsuario, compras);
						usuarioDAO.agregarUsuario(nombre, genero, correo,
								usuario, contraseña, numeroTarjeta,
								cupoTarjeta, parejas, compras, tipoUsuario,
								edad, lista_usuarios);
						solusoft.enviarCorreo(nuevo);
						view.mostrarMensajes("USUARIO_TRUE");
						view.getPanel1().limpiarCampos();
					} else {
						view.mostrarMensajes("EDAD_USUARIO_FALSE");
					}

				} else {
					view.mostrarMensajes("USUARIO_FALSE");
				}

			} catch (NombresExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			} catch (ContraseñaExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			} catch (MailExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			} catch (GeneroExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			} catch (EdadExcepcion e) {
				view.mostrarMensajes(e.getMessage());
			}

		} else {
			view.mostrarMensajes("CAMPOS_FALSE");
		}
	}

	public void agregarPareja() {
		String nombreInicio = solusoft.getUsuario_inicio();
		boolean yaEsta = false;
		String nombrePareja = view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_agregar_pareja().getCampo_texto_nombre().getText();
		String cupo = view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_agregar_pareja().getCampo_texto_cupo().getText();
		String numeros = "[0-9]+";

		if (!nombrePareja.isEmpty() && !cupo.isEmpty()) {

			if (cupo.matches(numeros)
					&& (Integer.parseInt(cupo) > 0 && Integer.parseInt(cupo) <= 100)) {

				int cupoI = Integer.parseInt(cupo);

				// Sacar la cantidad del cupo correspondiente de la persona
				double cupoD = Double.parseDouble(cupo);
				int cantidad_cupo = (int) (solusoft.getValorVariable() * (cupoD / 100));

				if (cantidad_cupo > 0) {

					try {
						int edad = comprobarEdad(view.getPanel_us_inicio()
								.getPnl_adm_cuentas().getPnl_agregar_pareja()
								.getCalendario().getDate());

						for (int i = 0; i < lista_usuarios.size(); i++) {
							if (lista_usuarios.get(i).getUsuario()
									.equals(nombreInicio)) {
								ArrayList<Parejas> lista = new ArrayList<Parejas>();
								lista = lista_usuarios.get(i).getParejas();
								for (int k = 0; k < lista.size(); k++) {
									if (lista_usuarios.get(i).getParejas()
											.get(k).getNombre()
											.equalsIgnoreCase(nombrePareja)) {
										yaEsta = true;
									}
								}
							}

						}
						if (!yaEsta) {
							if (edad >= 18) {

								usuarioDAO.agregarParejas(nombreInicio,
										nombrePareja, cupoI, cantidad_cupo,
										cantidad_cupo, edad, lista_usuarios);

								edad = 0;

								NumberFormat formatoImporte = NumberFormat
										.getCurrencyInstance(new Locale("en",
												"US"));

								JOptionPane.showMessageDialog(
										null,
										"El monto asignado a "
												+ nombrePareja
												+ " es "
												+ "\n"
												+ formatoImporte
														.format(cantidad_cupo),
										"Información",
										JOptionPane.INFORMATION_MESSAGE);

								solusoft.setValorVariable(solusoft
										.getValorVariable() - cantidad_cupo);
								view.getPanel_us_inicio()
										.getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.getLabel_cupo_restante()
										.setText(
												formatoImporte.format(solusoft
														.getValorVariable()));
								view.getPanel_us_inicio()
										.getPnl_adm_cuentas()
										.getLabel_cupo()
										.setText(
												formatoImporte.format(solusoft
														.getValorVariable()));

								JOptionPane
										.showMessageDialog(
												null,
												"El monto disponible es "
														+ formatoImporte
																.format(solusoft
																		.getValorVariable()),
												"Información",
												JOptionPane.INFORMATION_MESSAGE);

								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.getCampo_texto_cupo().setText(null);
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.getCampo_texto_nombre().setText(null);

								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.setVisible(false);
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.visibilidadComponentes(true);

								for (int i = 0; i < lista_usuarios.size(); i++) {
									if (lista_usuarios.get(i).getUsuario()
											.equals(nombreInicio)
											|| lista_usuarios.get(i)
													.getCorreo()
													.equals(nombreInicio)) {
										ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
										lista_parejas = lista_usuarios.get(i)
												.getParejas();
										view.getPanel_us_inicio()
												.getPnl_asignar_horarios()
												.getCombobox_parejas()
												.removeAllItems();
										view.getPanel_us_inicio()
												.getPnl_adm_cuentas()
												.getPnl_compras()
												.getPnl_ingresar_compra()
												.getCombobox_parejas()
												.removeAllItems();
										for (int k = 0; k < lista_parejas
												.size(); k++) {
											view.getPanel_us_inicio()
													.getPnl_asignar_horarios()
													.getCombobox_parejas()
													.addItem(
															lista_usuarios
																	.get(i)
																	.getParejas()
																	.get(k)
																	.getNombre());
											view.getPanel_us_inicio()
													.getPnl_adm_cuentas()
													.getPnl_compras()
													.getPnl_ingresar_compra()
													.getCombobox_parejas()
													.addItem(
															lista_usuarios
																	.get(i)
																	.getParejas()
																	.get(k)
																	.getNombre());
										}
									}
								}
							} else {
								view.mostrarMensajes("EDAD_FALSE");
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.getCampo_texto_cupo().setText(null);
								view.getPanel_us_inicio().getPnl_adm_cuentas()
										.getPnl_agregar_pareja()
										.getCampo_texto_nombre().setText(null);
							}
						} else {
							view.mostrarMensajes("NOMBRE_PAREJA_FALSE");
							view.getPanel_us_inicio().getPnl_adm_cuentas()
									.getPnl_agregar_pareja()
									.getCampo_texto_cupo().setText(null);
							view.getPanel_us_inicio().getPnl_adm_cuentas()
									.getPnl_agregar_pareja()
									.getCampo_texto_nombre().setText(null);
						}

					} catch (EdadExcepcion e) {
						view.mostrarMensajes(e.getMessage());
					}
				} else {
					view.mostrarMensajes("PORCENTAJE_CUPO_FALSE");
					view.getPanel_us_inicio().getPnl_adm_cuentas()
							.getPnl_agregar_pareja().getCampo_texto_cupo()
							.setText(null);
				}

			} else {
				view.mostrarMensajes("PORCENTAJE_CUPO_FALSE");
			}

		} else {
			view.mostrarMensajes("CAMPOS_FALSE");
		}

	}

	public void ingresoSistema() {

		String nombreInicio = view.getPanel1().getC_usuario_inicio().getText();
		String contraseñaInicio = new String(view.getPanel1()
				.getC_contrasena_inicio().getPassword());

		if (nombreInicio.isEmpty() || contraseñaInicio.isEmpty()) {
			view.mostrarMensajes("CAMPOS_FALSE");
		} else {
			if (usuarioDAO.comprobarUsuario(nombreInicio, contraseñaInicio,
					lista_usuarios)) {
				view.getPanel1().limpiarCampos();
				view.getPanel1().setVisible(false);
				view.getPanel_us_inicio().setVisible(true);
				agregarInfoUsuario(nombreInicio);
				solusoft = new Solusoft(nombreInicio);
				view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
						.getPnl_ingresar_compra().getCombobox_tiendas()
						.removeAllItems();
				for (int i = 0; i < lista_tiendas.size(); i++) {
					view.getPanel_us_inicio()
							.getPnl_adm_cuentas()
							.getPnl_compras()
							.getPnl_ingresar_compra()
							.getCombobox_tiendas()
							.addItem(
									lista_tiendas
											.get(i)
											.getNombre()
											.concat(" - "
													+ lista_tiendas.get(i)
															.getDireccion()));
				}
				for (int i = 0; i < lista_usuarios.size(); i++) {
					if (lista_usuarios.get(i).getUsuario().equals(nombreInicio)
							|| lista_usuarios.get(i).getCorreo()
									.equals(nombreInicio)) {
						ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
						lista_parejas = lista_usuarios.get(i).getParejas();
						view.getPanel_us_inicio().getPnl_asignar_horarios()
								.getCombobox_parejas().removeAllItems();
						view.getPanel_us_inicio().getPnl_adm_cuentas()
								.getPnl_compras().getPnl_ingresar_compra()
								.getCombobox_parejas().removeAllItems();
						for (int k = 0; k < lista_parejas.size(); k++) {
							view.getPanel_us_inicio()
									.getPnl_asignar_horarios()
									.getCombobox_parejas()
									.addItem(
											lista_usuarios.get(i).getParejas()
													.get(k).getNombre());
							view.getPanel_us_inicio()
									.getPnl_adm_cuentas()
									.getPnl_compras()
									.getPnl_ingresar_compra()
									.getCombobox_parejas()
									.addItem(
											lista_usuarios.get(i).getParejas()
													.get(k).getNombre());
						}
					}
				}
			} else if (nombreInicio.equals("admin")
					&& contraseñaInicio.equals("admin")) {
				view.getPanel1().setVisible(false);
				view.getPanel_admin().setVisible(true);
			}

			else {
				view.mostrarMensajes("INICIO_FALSE");
				nombreInicio = "";
				view.getPanel1().getC_contrasena_inicio().setText("");
			}
		}
	}

	public void agregarInfoUsuario(String nombre_ingresado) {

		String nombreInicio = solusoft.getUsuario_inicio();
		String numero_tarjeta = "";
		long numero_cupo = 0;

		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getUsuario().equals(nombre_ingresado)
					|| lista_usuarios.get(i).getCorreo()
							.equalsIgnoreCase(nombre_ingresado)) {
				numero_tarjeta = lista_usuarios.get(i).getNumeroTarjeta();
				nombreInicio = lista_usuarios.get(i).getUsuario();
				numero_cupo = lista_usuarios.get(i).getCupoTarjeta();
			}
		}

		view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta()
				.setText(numero_tarjeta);

		NumberFormat formatoImporte = NumberFormat
				.getCurrencyInstance(new Locale("en", "US"));
		view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo()
				.setText(formatoImporte.format(numero_cupo));

		// Asignar un valor a la variable valorCupo
		solusoft.valorCupo((int) usuarioDAO.buscarUsuario(nombreInicio,
				lista_usuarios).getCupoTarjeta());

		// Encontrar la cantidad restante del cupo despues de agregar las
		// parejas
		if (!usuarioDAO.buscarUsuario(nombreInicio, lista_usuarios)
				.getParejas().isEmpty()) {
			solusoft.setValorVariable(solusoft.getValorCupo());
			for (int i = 0; i < usuarioDAO
					.buscarUsuario(nombreInicio, lista_usuarios).getParejas()
					.size(); i++) {

				solusoft.setValorVariable(solusoft.getValorVariable()
						- usuarioDAO
								.buscarUsuario(nombreInicio, lista_usuarios)
								.getParejas().get(i)
								.getCantidad_cupo_asignado());
			}
		} else {
			solusoft.setValorVariable(solusoft.getValorCupo());
		}

		view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja()
				.getLabel_cupo_restante()
				.setText(formatoImporte.format(solusoft.getValorVariable()));
		view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo()
				.setText(formatoImporte.format(solusoft.getValorVariable()));

	}

	public void mouseListener(MouseListener controller) {
		view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getTable()
				.addMouseListener(controller);
	}

	@Override
	public void mouseClicked(MouseEvent a) {
		int seleccion = -1;
		seleccion = view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getTable()
				.rowAtPoint(a.getPoint());
		if (seleccion != -1) {
			tienda_horarios = new Tiendas(String.valueOf(view
					.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getTable()
					.getValueAt(seleccion, 0)), String.valueOf(view
					.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getTable()
					.getValueAt(seleccion, 1)), String.valueOf(view
					.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getTable()
					.getValueAt(seleccion, 2)), String.valueOf(view
					.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getTable()
					.getValueAt(seleccion, 3)));
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setEnabled(true);
		} else {// hola
			view.getPanel_us_inicio().getPnl_asignar_horarios()
					.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
					.setEnabled(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase NombresExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param n
	 *            Este parametro corresponde al nombre ingresado por el usuario
	 *            que debe de analizarse para ver si se efectua la excepcion.
	 * @throws NombresExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             nombre
	 */
	public void comprobarNombre(String n) throws NombresExcepcion {

		String numeros = "[0-9]+";
		if (n.matches(numeros)) {

			throw new NombresExcepcion("NOMBRE_FALSE");

		}

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase HorarioExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param a
	 *            Este parametro corresponde al horario de apertura ingresado
	 *            por el usuario que debe de analizarse para ver si se efectua
	 *            la excepcion.
	 * @param c
	 *            Este parametro corresponde al horario de cierre ingresado por
	 *            el usuario que debe de analizarse para ver si se efectua la
	 *            excepcion.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             horario de apertura y cierre.
	 */
	public void comprobarHorarioTienda(String a, String c)
			throws HorarioExcepcion {
		int hora_apertura = Integer.parseInt(a);

		int hora_cierre = Integer.parseInt(c);

		if (hora_apertura > hora_cierre) {
			throw new HorarioExcepcion("HORARIO_FALSE");
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase ContraseñaExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c
	 *            Este parametro corresponde a la contraseña ingresada por el
	 *            usuario que debe de analizarse para ver si se efectua la
	 *            excepcion.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas a la
	 *             contraseña donde tiene que tener por lo menos 8 caracteres.
	 */
	public void comprobarContraseña(String c) throws ContraseñaExcepcion {
		if (c.length() < 8) {
			throw new ContraseñaExcepcion("CONTRASEÑA_FALSE");

		}

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase MailExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param m
	 *            Este parametro corresponde a la correo ingresada por el
	 *            usuario que debe de analizarse para ver si se efectua la
	 *            excepcion.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             correo para poder validar si existe y de esa manera se
	 *             enviaria un correo de validación y de registro exitoso.
	 */
	public void comprobarCorreo(String correo) throws MailExcepcion {
		// Patrón para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// Se valida el email
		Matcher mather = pattern.matcher(correo);
		if (mather.find() == false) {
			throw new MailExcepcion("CORREO_FALSE");

		}

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase GeneroExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param g
	 *            Este parametro corresponde al genero seleccionado por el
	 *            usuario.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             genero, donde se debe se elegir el genero, ya sea mujer u
	 *             hombre, o saltaria el error.
	 */
	public String comprobarGenero() throws GeneroExcepcion {

		String g = "";
		if (view.getPanel1().getC1().isSelected()) {
			g = "Mujer";
		} else if (view.getPanel1().getC2().isSelected()) {
			g = "Hombre";
		} else {
			throw new GeneroExcepcion("GENERO_FALSE");
		}
		return g;

	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase CupoExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c
	 *            Este parametro corresponde a la cantidad que tiene actualmente
	 *            el usuario ingresado en su cupo.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             cupo, el cual debe de ser cero, o saltaria el error.
	 */
	public void comprobarCupo(long c) throws CupoExcepcion {

		if (c != 0) {
			throw new CupoExcepcion("CUPO_FALSE");
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase ValorCupoExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c
	 *            Este parametro corresponde a la cantidad correspondiente al
	 *            cupo ingresado por el usuario.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             cupo, el cual debe contener unicamente números.
	 */
	public void comprobarValorCupo(String c) throws ValorCupoExcepcion {
		String numeros = "[0-9]+";
		if (!c.matches(numeros)) {
			throw new ValorCupoExcepcion("VALOR_CUPO_FALSE");
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase EdadExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param n
	 *            Este parametro corresponde a la fecha ingresada por el usuario
	 *            por medio de un jcalendar.
	 * @throws HorarioExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas a la
	 *             edad, la cual debe de ser mayor o igual a 18.
	 */
	public int comprobarEdad(Date n) throws EdadExcepcion {
		int valorEdad = 0;
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");

		String y = year.format(n);
		int int_y = Integer.parseInt(y);

		String m = month.format(n);
		int int_m = Integer.parseInt(m);

		String d = day.format(n);
		int int_d = Integer.parseInt(d);

		LocalDate now = LocalDate.now();

		int calculoY = now.getYear() - int_y;
		int calculoM = now.getMonthValue() - int_m;
		int calculoD = now.getDayOfMonth() - int_d;

		valorEdad = calculoY - 1;

		if (calculoD < 0 && calculoM < 0 && calculoY < 18) {
			throw new EdadExcepcion("EDAD_FALSE");
		}
		return valorEdad;
	}

	public void agregarCompras() {
		String nombreInicio = solusoft.getUsuario_inicio();
		int numElementosPareja = view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_compras().getPnl_ingresar_compra()
				.getCombobox_parejas().getItemCount();
		int numElementosTienda = view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getPnl_compras().getPnl_ingresar_compra()
				.getCombobox_tiendas().getItemCount();
		if (numElementosPareja != 0) {
			if (numElementosTienda != 0) {
				String pareja = (String) view.getPanel_us_inicio()
						.getPnl_adm_cuentas().getPnl_compras()
						.getPnl_ingresar_compra().getCombobox_parejas()
						.getSelectedItem();
				String tienda = (String) view.getPanel_us_inicio()
						.getPnl_adm_cuentas().getPnl_compras()
						.getPnl_ingresar_compra().getCombobox_tiendas()
						.getSelectedItem();
				String valor_compra = view.getPanel_us_inicio()
						.getPnl_adm_cuentas().getPnl_compras()
						.getPnl_ingresar_compra().getCampo_texto_dinero()
						.getText();
				if (!valor_compra.isEmpty()) {
					try {
						double cupoDisponible = 0;
						ArrayList<Parejas> lista_parejas = new ArrayList<Parejas>();
						double valorCompra = Double.parseDouble(valor_compra);
						for (int i = 0; i < lista_usuarios.size(); i++) {
							if (lista_usuarios.get(i).getUsuario()
									.equals(nombreInicio)) {
								lista_parejas = lista_usuarios.get(i)
										.getParejas();
								for (int j = 0; j < lista_parejas.size(); j++) {
									if (lista_parejas.get(j).getNombre()
											.equals(pareja)) {
										cupoDisponible = lista_parejas.get(j)
												.getCantidad_cupo_restante();
									}
								}
							}
						}
						if (valorCompra > 0 && valorCompra <= cupoDisponible) {
							usuarioDAO.agregarCompras(nombreInicio, pareja,
									tienda, valorCompra);
							view.getPanel_us_inicio().getPnl_adm_cuentas()
									.getPnl_compras().getPnl_ingresar_compra()
									.getCampo_texto_dinero().setText(null);
							view.mostrarMensajes("COMPRA_TRUE");
						} else {
							view.mostrarMensajes("COMPRA_FALSE");
						}
					} catch (NumberFormatException e) {
						view.mostrarMensajes("VALOR_COMPRA_FALSE");
					}
				}
			} else {
				view.mostrarMensajes("SELECCION_TIENDA_FALSE");
			}
		} else {
			view.mostrarMensajes("PAREJA_FALSE");
		}
	}

	public void verHistorialCompras() {
		String nombreInicio = solusoft.getUsuario_inicio();
		view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getPnl_ver_historial().getModel().setRowCount(0);
		lista_usuarios = archivo_Usuario.leerArchivo();

		if (!usuarioDAO.buscarUsuario(nombreInicio, lista_usuarios)
				.getLista_compras().isEmpty()) {
			for (int i = 0; i < usuarioDAO
					.buscarUsuario(nombreInicio, lista_usuarios)
					.getLista_compras().size(); i++) {
				String nombreTienda = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getLista_compras().get(i).getTienda();
				String pareja = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getLista_compras().get(i).getPareja();
				double valorCompra = usuarioDAO
						.buscarUsuario(nombreInicio, lista_usuarios)
						.getLista_compras().get(i).getValorCompra();
				NumberFormat formatoImporte = NumberFormat
						.getCurrencyInstance(new Locale("en", "US"));

				Object[] datos_filas = { pareja, nombreTienda,
						formatoImporte.format(valorCompra) };
				view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
						.getPnl_ver_historial().getModel().addRow(datos_filas);
			}
		}
	}

	
	


}
