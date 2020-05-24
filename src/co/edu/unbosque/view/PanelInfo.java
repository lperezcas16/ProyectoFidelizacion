package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PanelInfo extends JPanel {
	
	private String nombre;
	private ImageIcon imagen;

	private JLabel label_nombre, label_genero, label_correo,label_usuario, label_tipo;
	private JButton boton_cerrar;
	
	
	public PanelInfo(String nombre) {
		this.nombre=nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(false);
	}
	
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}
	
	public void inicializarComponentes() {
		
		Color color_azul = new Color(36,67,87);
		Color color_naranja = new Color(225,145,77);
		
		label_nombre = new JLabel("nombre");
		label_nombre.setBackground(color_azul);
		label_nombre.setForeground(color_naranja);
		label_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_nombre.setBounds(260,160,500,50);
		add(label_nombre);
		
		label_genero = new JLabel("Genero");
		label_genero.setBackground(color_azul);
		label_genero.setForeground(color_naranja);
		label_genero.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_genero.setBounds(260,220,500,50);
		add(label_genero);
		
		label_correo = new JLabel("Correo");
		label_correo.setBackground(color_azul);
		label_correo.setForeground(color_naranja);
		label_correo.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_correo.setBounds(260,285,500,50);
		add(label_correo);
		
		label_usuario = new JLabel("Usuario");
		label_usuario.setBackground(color_azul);
		label_usuario.setForeground(color_naranja);
		label_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_usuario.setBounds(260,345,500,50);
		add(label_usuario);
		
		label_tipo = new JLabel ("Administrador");
		label_tipo.setBackground(color_azul);
		label_tipo.setForeground(color_naranja);
		label_tipo.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_tipo.setBounds(280,420,500,50);
		add(label_tipo);
		
		boton_cerrar = new JButton("Cerrar sesion");
		boton_cerrar.setBounds(500,150,200,50);
		boton_cerrar.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		add(boton_cerrar);
	}

	public JButton getBoton_cerrar() {
		return boton_cerrar;
	}

	public void setBoton_cerrar(JButton boton_cerrar) {
		this.boton_cerrar = boton_cerrar;
	}

}
