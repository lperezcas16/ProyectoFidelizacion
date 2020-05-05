package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener {

	private Ventana view;
	
	
	public Controller() {
		super();
		
		view = new Ventana();
		actionListener(this);
	}
	//METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA

	
	private void actionListener(ActionListener controller) {
		view.getPanel1().getBoton_entrar().addActionListener(controller);
		view.getPanel1().getBoton_registrar().addActionListener(controller);
		
	}

	public void actionPerformed(ActionEvent event) {
		
		if(view.getPanel1().getBoton_entrar()==event.getSource()) {
			
		}
		
		if (view.getPanel1().getBoton_registrar()==event.getSource()) {
			
		}
	}
	
}
