package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmParejas extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_ojo_oculto, imagen_ojo;
	private JButton boton_agregar, boton_info;
	private JLabel label_tarjeta, label_cupo;
	private Icon icono_ojo_oculto, icono_ojo;
	private JButton boton_ojo_oculto, boton_ojo;

	public PanelAdmParejas(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicialzarComponentes();
		setVisible(true);

	}

	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

	public void inicialzarComponentes() {

		Color color_azul = new Color(36, 67, 87);
		Color color_naranja = new Color(255, 145, 77);

		label_cupo = new JLabel("$0");
		label_cupo.setBackground(color_azul);
		label_cupo.setForeground(color_naranja);
		label_cupo.setFont(new Font("Bernard MT Condensed", Font.BOLD, 60));
		label_cupo.setBounds(150, 320, 500, 50);
		add(label_cupo);

		label_tarjeta = new JLabel("fkadjfkladfadf");
		label_tarjeta.setBackground(color_azul);
		label_tarjeta.setForeground(color_naranja);
		label_tarjeta.setFont(new Font("Bernard MT Condensed", Font.BOLD, 30));
		label_tarjeta.setBounds(150, 170, 200, 30);
		add(label_tarjeta);

		boton_ojo_oculto = new JButton();
		boton_ojo_oculto.setBounds(370, 165, 40, 40);
		add(boton_ojo_oculto);

		imagen_ojo_oculto = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/ojo oculto.png"));
		icono_ojo_oculto = new ImageIcon(imagen_ojo_oculto.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		boton_ojo_oculto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		boton_ojo_oculto.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		boton_ojo_oculto.setContentAreaFilled(false);
		boton_ojo_oculto.setBorderPainted(false);
		boton_ojo_oculto.setIcon(icono_ojo_oculto);

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

	public JButton getBoton_agregar() {
		return boton_agregar;
	}

	public void setBoton_agregar(JButton boton_agregar) {
		this.boton_agregar = boton_agregar;
	}

	public JButton getBoton_info() {
		return boton_info;
	}

	public void setBoton_info(JButton boton_info) {
		this.boton_info = boton_info;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getLabel_tarjeta() {
		return label_tarjeta;
	}

	public void setLabel_tarjeta(JLabel label_tarjeta) {
		this.label_tarjeta = label_tarjeta;
	}

	public JLabel getLabel_cupo() {
		return label_cupo;
	}

	public void setLabel_cupo(JLabel label_cupo) {
		this.label_cupo = label_cupo;
	}

	public ImageIcon getImagen_ojo_oculto() {
		return imagen_ojo_oculto;
	}

	public void setImagen_ojo_oculto(ImageIcon imagen_ojo_oculto) {
		this.imagen_ojo_oculto = imagen_ojo_oculto;
	}

	public ImageIcon getImagen_ojo() {
		return imagen_ojo;
	}

	public void setImagen_ojo(ImageIcon imagen_ojo) {
		this.imagen_ojo = imagen_ojo;
	}

	public Icon getIcono_ojo_oculto() {
		return icono_ojo_oculto;
	}

	public void setIcono_ojo_oculto(Icon icono_ojo_oculto) {
		this.icono_ojo_oculto = icono_ojo_oculto;
	}

	public Icon getIcono_ojo() {
		return icono_ojo;
	}

	public void setIcono_ojo(Icon icono_ojo) {
		this.icono_ojo = icono_ojo;
	}

	public JButton getBoton_ojo_oculto() {
		return boton_ojo_oculto;
	}

	public void setBoton_ojo_oculto(JButton boton_ojo_oculto) {
		this.boton_ojo_oculto = boton_ojo_oculto;
	}

	public JButton getBoton_ojo() {
		return boton_ojo;
	}

	public void setBoton_ojo(JButton boton_ojo) {
		this.boton_ojo = boton_ojo;
	}

}
