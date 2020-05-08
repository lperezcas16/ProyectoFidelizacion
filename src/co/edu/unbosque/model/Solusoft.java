package co.edu.unbosque.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Solusoft {
	
	
	
	public Solusoft () {
		
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
	
	/*
	
	*/
	
}
