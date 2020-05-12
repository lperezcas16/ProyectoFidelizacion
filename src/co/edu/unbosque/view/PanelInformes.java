package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PanelInformes extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ImageIcon imagen;
	private JTextField campo_usuario;
	private JComboBox<String> combo_Fecha, combo_hora, combo_eleccion, combo_tienda;
	private JButton boton_generar_pfd, boton_vista_previa;
//	public PanelGraficos panel_graficas;
	
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
		 
		 boton_generar_pfd = new JButton("Generar informe");
		 boton_generar_pfd.setBounds(150,450,200,45);
		 boton_generar_pfd.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 add(boton_generar_pfd);
		 boton_generar_pfd.setVisible(false);
		 
		 boton_vista_previa = new JButton("Vista previa del informe");
		 boton_vista_previa.setBounds(420,450,300,45);
		 boton_vista_previa.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		 add(boton_vista_previa);
		 boton_vista_previa.setVisible(false);
		
	}
	public JTextField getCampo_usuario() {
		return campo_usuario;
	}
	public void setCampo_usuario(JTextField campo_usuario) {
		this.campo_usuario = campo_usuario;
	}
	public JComboBox<String> getCombo_Fecha() {
		return combo_Fecha;
	}
	public void setCombo_Fecha(JComboBox<String> combo_Fecha) {
		this.combo_Fecha = combo_Fecha;
	}
	public JComboBox<String> getCombo_hora() {
		return combo_hora;
	}
	public void setCombo_hora(JComboBox<String> combo_hora) {
		this.combo_hora = combo_hora;
	}
	public JComboBox<String> getCombo_eleccion() {
		return combo_eleccion;
	}
	public void setCombo_eleccion(JComboBox<String> combo_eleccion) {
		this.combo_eleccion = combo_eleccion;
	}
	public JComboBox<String> getCombo_tienda() {
		return combo_tienda;
	}
	public void setCombo_tienda(JComboBox<String> combo_tienda) {
		this.combo_tienda = combo_tienda;
	}
	public JButton getBoton() {
		return boton_generar_pfd;
	}
	public void setBoton(JButton boton) {
		this.boton_generar_pfd = boton;
	}
	public JButton getBoton_vista_previa() {
		return boton_vista_previa;
	}
	public void setBoton_vista_previa(JButton boton_vista_previa) {
		this.boton_vista_previa = boton_vista_previa;
	}
	public JButton getBoton_generar_pfd() {
		return boton_generar_pfd;
	}
	public void setBoton_generar_pfd(JButton boton_generar_pfd) {
		this.boton_generar_pfd = boton_generar_pfd;
	}
//	

}