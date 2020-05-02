package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;

import co.edu.unbosque.view.View;

public class Controller {

	private View view;
	
	
	public Controller() {
		super();
		view=new View();
		setActionListener();
	}
	//METODO QUE SE ENCARGA DE AGREGAR LISTENERS A LA VISTA
	public void setActionListener() {
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
	}
	
}
