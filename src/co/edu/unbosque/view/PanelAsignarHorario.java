package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class PanelAsignarHorario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> combobox_tiendas, combobox_parejas;
	private JDateChooser calendario;
	private JButton boton_agregar;
	private String nombre;
	private ImageIcon imagen, imagen_boton;
	private Icon icon_boton;
	private Color color_azul = new Color(36, 67, 87);
	private Color color_naranja = new Color(255, 145, 77);

	public PanelAsignarHorario(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		setBackground(color_azul);
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

		combobox_tiendas = new JComboBox<Object>();
		combobox_tiendas.setBounds(110, 190, 200, 30);
		combobox_tiendas.setBackground(Color.white);
		combobox_tiendas.setForeground(color_naranja);
		add(combobox_tiendas);

		combobox_parejas = new JComboBox<Object>();
		combobox_parejas.setBounds(110, 285, 200, 30);
		combobox_parejas.setBackground(Color.white);
		combobox_parejas.setForeground(color_naranja);
		add(combobox_parejas);

		boton_agregar = new JButton();
		boton_agregar.setBounds(130, 380, 150, 30);
		add(boton_agregar);

		imagen_boton = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_horario.png"));
		icon_boton = new ImageIcon(imagen_boton.getImage().getScaledInstance(180, 30, Image.SCALE_SMOOTH));

	}

	public JComboBox<Object> getCombobox_tiendas() {
		return combobox_tiendas;
	}

	public void setCombobox_tiendas(JComboBox<Object> combobox_tiendas) {
		this.combobox_tiendas = combobox_tiendas;
	}

	public JComboBox<Object> getCombobox_parejas() {
		return combobox_parejas;
	}

	public void setCombobox_parejas(JComboBox<Object> combobox_parejas) {
		this.combobox_parejas = combobox_parejas;
	}

	public JDateChooser getCalendario() {
		return calendario;
	}

	public void setCalendario(JDateChooser calendario) {
		this.calendario = calendario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBoton_agregar() {
		return boton_agregar;
	}

	public void setBoton_agregar(JButton boton_agregar) {
		this.boton_agregar = boton_agregar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public Color getColor_azul() {
		return color_azul;
	}

	public void setColor_azul(Color color_azul) {
		this.color_azul = color_azul;
	}

	public Color getColor_naranja() {
		return color_naranja;
	}

	public void setColor_naranja(Color color_naranja) {
		this.color_naranja = color_naranja;
	}

	public ImageIcon getImagen_boton() {
		return imagen_boton;
	}

	public void setImagen_boton(ImageIcon imagen_boton) {
		this.imagen_boton = imagen_boton;
	}

	public Icon getIcon_boton() {
		return icon_boton;
	}

	public void setIcon_boton(Icon icon_boton) {
		this.icon_boton = icon_boton;
	}

}
