package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import co.edu.unbosque.model.Contrase�aExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Solusoft;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener {

	private Ventana view;
	private Solusoft solusoft;
	private ArchivoUsuario archivo_Usuario;
	private UsuarioDAO usuarioDAO;
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

		lista_usuarios = archivo_Usuario.leerArchivo();
		actionListener(this);
	}

	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		// LISTENER PANEL PRINCIPAL
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
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

			
				String nombre, correo, usuario, contrase�a, genero = "", numeroTarjeta, tipoUsuario;
				long cupoTarjeta;
				nombre = view.getPanel1().getCampo_nombre().getText();
				correo = view.getPanel1().getCampo_correo().getText();
				usuario = view.getPanel1().getCampo_usuario().getText();
				numeroTarjeta = solusoft.generarNumeroCuenta(lista_usuarios);
				cupoTarjeta = 0;
				tipoUsuario = "Usuario";
				contrase�a  = new String(view.getPanel1().getCampo_contrasena().getPassword());
				
				
				if (view.getPanel1().getC1().isSelected()==true) {
					genero = "Mujer";
				} else if (view.getPanel1().getC2().isSelected()==true) {
					genero = "Hombre";
				}

				if (nombre.isEmpty() || correo.isEmpty() || usuario.isEmpty() || contrase�a.isEmpty()
						|| genero.isEmpty()) {
					view.mostrarMensajes("CAMPOS_FALSE");					
					
				} else {
					String numeros = "[0-9]+";
					if (nombre.matches(numeros)) {
						view.mostrarMensajes("NOMBRE_FALSE");
					} else if (contrase�a.length() >= 8) {
						view.mostrarMensajes("CONTRASE�A_FALSE");
					}
	
					if (solusoft.comprobarExistenciaUsuario(correo, usuario, lista_usuarios)) {

						usuarioDAO.agregarUsuario(nombre, genero, correo, usuario, contrase�a, numeroTarjeta,
								cupoTarjeta, parejas, tipoUsuario, lista_usuarios);

					} else {
						view.mostrarMensajes("USUARIO_FALSE");
					}
				}
				
			
		}

		// ACCION AGREGAR PAREJA
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja() == event.getSource()) {

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
		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda() == event.getSource()) {

		}

		// Panel Agregar Pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja() == event.getSource()) {
			// view.getPanel_us_inicio().getPesta�as().setTabComponentAt(0,
			// view.getPanel_us_inicio().getPnl_agrega());
		}

	}
	
	

	
}
