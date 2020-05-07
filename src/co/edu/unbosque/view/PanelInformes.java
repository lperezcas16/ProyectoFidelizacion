package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PanelInformes extends JPanel{
	
	private String nombre;
	private ImageIcon imagen;
	private JTextField campo_usuario;
	private Icon icono;
	private JComboBox<String> combo_Fecha, combo_hora, combo_eleccion, combo_tienda;
	private JButton boton;
	
	public PanelInformes(String nombre) {
		this.nombre=nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
		}
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}
	public void inicializarComponentes() {
		
		combo_eleccion = new JComboBox<String>();
		combo_eleccion.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		combo_eleccion.setBounds(350,270,110,45);
		combo_eleccion.addItem("Selecciona");
		combo_eleccion.addItem("Fecha");
		combo_eleccion.addItem("Tienda");
		combo_eleccion.addItem("Usuario");
		 add(combo_eleccion);
		 
		 combo_Fecha = new JComboBox<String>();
		 combo_Fecha.setBounds(250,360,90,45);
		 combo_Fecha.addItem("Fecha");
		 combo_Fecha.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 add(combo_Fecha);
		 combo_Fecha.setVisible(false);
		 
		 combo_hora = new JComboBox<String>();
		 combo_hora.setBounds(450,360,90,45);
		 combo_hora.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 combo_hora.addItem("Hora");
		 add(combo_hora);
		 combo_hora.setVisible(false);
		 
		 combo_tienda = new JComboBox<String>();
		 combo_tienda.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 combo_tienda.setBounds(360,360,90,45);
		 combo_tienda.addItem("Tienda");
		 add(combo_tienda);
		 combo_tienda.setVisible(false);
		 
		 campo_usuario = new JTextField();
		 campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 campo_usuario.setBounds(310,360,200,45);
		 add(campo_usuario);
		 campo_usuario.setVisible(false);
		 
		 boton = new JButton("Generar informe");
		 boton.setBounds(300,450,200,45);
		 boton.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 add(boton);
		 boton.setVisible(false);
		
	}
	

}
