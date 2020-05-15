package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class PanelNuevaTienda extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField campo_texto_nombre, campo_texto_direccion;
	private JSpinner spinner_hora_apertura, spinner_hora_cierre;
	private JButton boton_validar_nueva_tienda, boton_regresar;
	private ImageIcon imagen, imagen_boton_añadir, imagen_boton_regresar;
	private Icon icono_boton_añadir, icono_boton_regresar;
	private String nombre;

	public PanelNuevaTienda(String nombre) {

		this.nombre = nombre;
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

		spinner_hora_apertura = new JSpinner();
		spinner_hora_apertura.setModel(new SpinnerDateModel());
		spinner_hora_apertura.setEditor(new JSpinner.DateEditor(
				spinner_hora_apertura, "HH:mm"));
		spinner_hora_apertura.setBounds(480, 230, 200, 30);
		add(spinner_hora_apertura);

		spinner_hora_cierre = new JSpinner();
		spinner_hora_cierre.setModel(new SpinnerDateModel());
		spinner_hora_cierre.setEditor(new JSpinner.DateEditor(
				spinner_hora_cierre, "HH:mm"));
		spinner_hora_cierre.setBounds(480, 400, 200, 30);
		add(spinner_hora_cierre);

		campo_texto_direccion = new JTextField();
		campo_texto_direccion.setBounds(90, 400, 200, 30);
		add(campo_texto_direccion);

		campo_texto_nombre = new JTextField();
		campo_texto_nombre.setBounds(90, 230, 200, 30);
		add(campo_texto_nombre);

		boton_validar_nueva_tienda = new JButton();
		boton_validar_nueva_tienda.setBounds(600, 480, 150, 30);
		add(boton_validar_nueva_tienda);

		imagen_boton_añadir = new ImageIcon(getClass().getResource(
				"/co/edu/unbosque/imagenes/boton_confirmar_seleccion.png"));
		icono_boton_añadir = new ImageIcon(imagen_boton_añadir.getImage()
				.getScaledInstance(200, 30, Image.SCALE_SMOOTH));

		boton_regresar = new JButton();
		boton_regresar.setBounds(35, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource(
				"/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(imagen_boton_regresar.getImage()
				.getScaledInstance(200, 30, Image.SCALE_SMOOTH));

	}

	public JTextField getCampo_texto_nombre() {
		return campo_texto_nombre;
	}

	public void setCampo_texto_nombre(JTextField campo_texto_nombre) {
		this.campo_texto_nombre = campo_texto_nombre;
	}

	public JTextField getCampo_texto_direccion() {
		return campo_texto_direccion;
	}

	public void setCampo_texto_direccion(JTextField campo_texto_direccion) {
		this.campo_texto_direccion = campo_texto_direccion;
	}

	public JSpinner getSpinner_hora_apertura() {
		return spinner_hora_apertura;
	}

	public void setSpinner_hora_apertura(JSpinner spinner_hora_apertura) {
		this.spinner_hora_apertura = spinner_hora_apertura;
	}

	public JSpinner getSpinner_hora_cierre() {
		return spinner_hora_cierre;
	}

	public void setSpinner_hora_cierre(JSpinner spinner_hora_cierre) {
		this.spinner_hora_cierre = spinner_hora_cierre;
	}

	public JButton getBoton_validar_nueva_tienda() {
		return boton_validar_nueva_tienda;
	}

	public void setBoton_validar_nueva_tienda(JButton boton_validar_nueva_tienda) {
		this.boton_validar_nueva_tienda = boton_validar_nueva_tienda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public ImageIcon getImagen_boton_añadir() {
		return imagen_boton_añadir;
	}

	public void setImagen_boton_añadir(ImageIcon imagen_boton_añadir) {
		this.imagen_boton_añadir = imagen_boton_añadir;
	}

	public Icon getIcono_boton_añadir() {
		return icono_boton_añadir;
	}

	public void setIcono_boton_añadir(Icon icono_boton_añadir) {
		this.icono_boton_añadir = icono_boton_añadir;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}

	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}

	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}

	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}

	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}

}
