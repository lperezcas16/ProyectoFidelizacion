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

	}

	public void actionPerformed(ActionEvent event) {

		if (view.getPanel1().getBoton_entrar() == event.getSource()) {

		}

		if (view.getPanel1().getBoton_registrar() == event.getSource()) {

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
	 * CedulaExcepcion en el paquete co.edu.unbosque.model<br>
	 * 
	 * @param c Este parametro representa al numero de la cedula ingresado por el
	 *          usuario que debe de evaluarse para ver si tiene la excepcion. n !=
	 *          null, n != " ".
	 * @return Si no se lanza la excepcion se devolveria la cedula ingresado
	 * @throws CedulaExcepcion Esta excepcion corresponde a las limitaciones
	 *                         impuestas a la cedula
	 */
	public String comprobarCedula(String c) throws CedulaExcepcion {

		if (c.matches(numeros) && (c.length() >= 5 && c.length() <= 10)) {
			return c;
		} else {
			throw new CedulaExcepcion("El formato de la cédula es incorrecto");
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
