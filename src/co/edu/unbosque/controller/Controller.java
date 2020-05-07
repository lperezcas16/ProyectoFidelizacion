package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.CedulaExcepcion;
import co.edu.unbosque.model.ContraseñaExcepcion;
import co.edu.unbosque.model.NombresExcepcion;
import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener {

	private Ventana view;
	String numeros = "[0-9]+";

	public Controller() {
		super();

		view = new Ventana();
		actionListener(this);
	}
	// METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	private void actionListener(ActionListener controller) {
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
		view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);

	}

	public void actionPerformed(ActionEvent event) {

		// Panel 1
		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}

		if (view.getPanel1().getBoton_registrar() == event.getSource()) {

		}

		// Panel Administrar Cuenta
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

			view.getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja().setVisible(true);
			view.getPanel_us_inicio().getPnl_adm_cuentas().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_cupo().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getLabel_tarjeta().setVisible(false);
			view.getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().setVisible(false);
		}
	}

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
			throw new NumberFormatException("El formato del nombre o apellido es incorrecto");
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

}
