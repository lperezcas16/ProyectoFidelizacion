package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ContraseñaExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener {

	private Ventana view;
	private String numeros = "[0-9]+";
	private ArchivoUsuario archivo_Usuario;
	private UsuarioDAO usuarioDAO;

	public Controller() {
		super();
		archivo_Usuario = new ArchivoUsuario();
		usuarioDAO = new UsuarioDAO(archivo_Usuario);
		view = new Ventana();
		actionListener(this);
	}

	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
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

	}

	public void actionPerformed(ActionEvent event) {

		// Panel 1
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}

		if (view.getPanel1().getBoton_registrar() == event.getSource()) {
			inscribirUsuario();
		}

		// Panel Administrar Cuenta
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_info_pareja() == event.getSource()) {

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

		// Panel Asignar Horario
		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario() == event.getSource()) {

		}

		if (view.getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda() == event.getSource()) {

		}

		// Panel Agregar Pareja
		if (view.getPanel_us_inicio().getPnl_adm_cuentas()
				.getBoton_agregar_pareja() == event.getSource()) {
			// view.getPanel_us_inicio().getPestañas().setTabComponentAt(0,
			// view.getPanel_us_inicio().getPnl_agrega());
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase NombresExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param n
	 *            Este parametro representa al nombre y apellido ingresado por
	 *            el usuario que debe de evaluarse para ver si tiene la
	 *            excepcion
	 * @return Si no se lanza la excepcion se devolveria el nombre o apellido
	 *         ingresado
	 * @throws NombresExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas al
	 *             nombre y apellido
	 */
	public String nombres(String n) throws NombresExcepcion {

		if (n.matches(numeros)) {
			throw new NumberFormatException(
					"El formato del nombre  es incorrecto");
		} else {
			return n;
		}
	}

	/**
	 * Este metodo corresponde a la especificacion de la excepcion creada, junto
	 * con las restricciones y el mensaje que se lanza si se llega a efectuar la
	 * excepcion <b>pre</b> Es necesario que anteriormente se haya creado la
	 * clase ContraseñaExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c
	 *            Este parametro representa a la contraseña ingresado por el
	 *            usuario que debe de evaluarse para ver si tiene la excepcion.
	 *            n != null, n != " ".
	 * @return Si no se lanza la excepcion se devolveria la contraseña ingresado
	 * @throws CedulaExcepcion
	 *             Esta excepcion corresponde a las limitaciones impuestas a la
	 *             contraseña
	 */
	public String comprobarContraseña(String c) throws ContraseñaExcepcion {

		if (c.length() >= 8) {
			return c;
		} else {
			throw new ContraseñaExcepcion(
					"La contraseña debe de tener por lo menos 8 caracteres");
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
			nombres(nombre);
			comprobarContraseña(contraseña);
			if (!nombre.isEmpty() && !correo.isEmpty() && !usuario.isEmpty()
					&& !contraseña.isEmpty() && !genero.isEmpty()) {
				if (comprobarExistenciaUsuario(correo, usuario, lista_usuarios)) {

					usuarioDAO.agregarUsuario(nombre, genero, correo, usuario,
							contraseña, numeroTarjeta, cupoTarjeta, parejas,
							tipoUsuario, lista_usuarios);
				} else {
					JOptionPane.showMessageDialog(null,
							"Los datos ingresados ya pertenecen a un usuario");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Digite todos los datos solicitados");
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
		String numeroTargeta = Integer.toString(valor1)
				+ Integer.toString(valor2);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getNumeroTarjeta().equals(numeroTargeta)) {
				valor1 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				valor2 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				numeroTargeta = Integer.toString(valor1)
						+ Integer.toString(valor2);
			}
		}
		return numeroTargeta;
	}

	public boolean comprobarExistenciaUsuario(String correo, String usuario,
			ArrayList<Usuario> lista_usuarios) {
		boolean comprobar = true;

		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equals(correo)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				comprobar = false;
			}
		}

		return comprobar;
	}

}
