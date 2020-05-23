package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelIngresarCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> combobox_parejas, combobox_tiendas;
	private String nombre;
	private ImageIcon imagen, imagen_boton_agregar_compra;
	private JTextField campo_texto_dinero;
	private JButton boton_agregar_compra;
	private Icon icono_boton_agregar_compra;

	public PanelIngresarCompra(String nombre) {
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

		combobox_parejas = new JComboBox<Object>();
		combobox_parejas.setBounds(90, 58, 200, 30);
		add(combobox_parejas);

		combobox_tiendas = new JComboBox<Object>();
		combobox_tiendas.setBounds(90, 160, 200, 30);
		add(combobox_tiendas);

		campo_texto_dinero = new JTextField();
		campo_texto_dinero.setBounds(460, 58, 200, 30);
		add(campo_texto_dinero);

		boton_agregar_compra = new JButton();
		boton_agregar_compra.setBounds(460, 160, 200, 30);
		add(boton_agregar_compra);

		imagen_boton_agregar_compra = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_compra.png"));
		icono_boton_agregar_compra = new ImageIcon(
				imagen_boton_agregar_compra.getImage().getScaledInstance(250, 30, Image.SCALE_SMOOTH));

	}

	public JComboBox<Object> getCombobox_parejas() {
		return combobox_parejas;
	}

	public void setCombobox_parejas(JComboBox<Object> combobox_parejas) {
		this.combobox_parejas = combobox_parejas;
	}

	public JComboBox<Object> getCombobox_tiendas() {
		return combobox_tiendas;
	}

	public void setCombobox_tiendas(JComboBox<Object> combobox_tiendas) {
		this.combobox_tiendas = combobox_tiendas;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ImageIcon getImagen_boton_agregar_compra() {
		return imagen_boton_agregar_compra;
	}

	public void setImagen_boton_agregar_compra(ImageIcon imagen_boton_agregar_compra) {
		this.imagen_boton_agregar_compra = imagen_boton_agregar_compra;
	}

	public JTextField getCampo_texto_dinero() {
		return campo_texto_dinero;
	}

	public void setCampo_texto_dinero(JTextField campo_texto_dinero) {
		this.campo_texto_dinero = campo_texto_dinero;
	}

	public JButton getBoton_agregar_compra() {
		return boton_agregar_compra;
	}

	public void setBoton_agregar_compra(JButton boton_agregar_compra) {
		this.boton_agregar_compra = boton_agregar_compra;
	}

	public Icon getIcono_boton_agregar_compra() {
		return icono_boton_agregar_compra;
	}

	public void setIcono_boton_agregar_compra(Icon icono_boton_agregar_compra) {
		this.icono_boton_agregar_compra = icono_boton_agregar_compra;
	}

	public void visibilidadComponentes(boolean b) {
		boton_agregar_compra.setVisible(b);
		campo_texto_dinero.setVisible(b);
		combobox_parejas.setVisible(b);
		combobox_tiendas.setVisible(b);
	}

}
