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

public class PanelAdmCuentas extends JPanel {

	private static final long serialVersionUID = 1L;

	// holajkfajdlfkjalkdsfje

	private String nombre;
	private ImageIcon imagen, imagen_ojo_oculto, imagen_ojo, imagen_boton_agregar, imagen_boton_info;
	private JButton boton_agregar_pareja, boton_info_pareja;
	private JLabel label_tarjeta, label_cupo;
	private Icon icono_ojo_oculto, icono_ojo, icono_boton_agregar, icono_boton_info;
	private JButton boton_ojo_oculto;

	private PanelAgregarPareja pnl_agregar_pareja;

	public PanelAdmCuentas(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicialzarComponentes();
		setVisible(false);

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
		label_cupo.setFont(new Font("Accidental Presidency", Font.BOLD, 60));
		label_cupo.setBounds(150, 320, 500, 50);
		add(label_cupo);

		label_tarjeta = new JLabel("fkadjfkladfadf");
		label_tarjeta.setBackground(color_azul);
		label_tarjeta.setForeground(color_naranja);
		label_tarjeta.setFont(new Font("Accidental Presidency", Font.BOLD, 30));
		label_tarjeta.setBounds(150, 170, 200, 30);
		add(label_tarjeta);

		boton_ojo_oculto = new JButton();
		boton_ojo_oculto.setBounds(370, 165, 40, 40);
		boton_ojo_oculto.setBorderPainted(false);
		add(boton_ojo_oculto);

		imagen_ojo_oculto = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/ojo oculto.png"));
		icono_ojo_oculto = new ImageIcon(imagen_ojo_oculto.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		imagen_ojo = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/ojo.png"));
		icono_ojo = new ImageIcon(imagen_ojo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		boton_agregar_pareja = new JButton();
		boton_agregar_pareja.setBounds(60, 440, 300, 30);
		add(boton_agregar_pareja);

		boton_info_pareja = new JButton();
		boton_info_pareja.setBounds(420, 440, 300, 30);
		add(boton_info_pareja);

		imagen_boton_agregar = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_pareja.png"));
		icono_boton_agregar = new ImageIcon(
				imagen_boton_agregar.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		imagen_boton_info = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_ver_info.png"));
		icono_boton_info = new ImageIcon(imagen_boton_info.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));
		
		pnl_agregar_pareja = new PanelAgregarPareja("/co/edu/unbosque/imagenes/fondo_agregar_pareja.png");
		pnl_agregar_pareja.setBounds(0, 0, 795, 572);
		add(pnl_agregar_pareja);
		
		pnl_agregar_pareja.getBoton_agregar_nueva_pareja().setIcon(pnl_agregar_pareja.getIcono_boton());

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

	public JButton getBoton_agregar_pareja() {
		return boton_agregar_pareja;
	}

	public void setBoton_agregar_pareja(JButton boton_agregar_pareja) {
		this.boton_agregar_pareja = boton_agregar_pareja;
	}

	public JButton getBoton_info_pareja() {
		return boton_info_pareja;
	}

	public void setBoton_info_pareja(JButton boton_info_pareja) {
		this.boton_info_pareja = boton_info_pareja;
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

	public ImageIcon getImagen_boton_agregar() {
		return imagen_boton_agregar;
	}

	public void setImagen_boton_agregar(ImageIcon imagen_boton_agregar) {
		this.imagen_boton_agregar = imagen_boton_agregar;
	}

	public ImageIcon getImagen_boton_info() {
		return imagen_boton_info;
	}

	public void setImagen_boton_info(ImageIcon imagen_boton_info) {
		this.imagen_boton_info = imagen_boton_info;
	}

	public Icon getIcono_boton_agregar() {
		return icono_boton_agregar;
	}

	public void setIcono_boton_agregar(Icon icono_boton_agregar) {
		this.icono_boton_agregar = icono_boton_agregar;
	}

	public Icon getIcono_boton_info() {
		return icono_boton_info;
	}

	public void setIcono_boton_info(Icon icono_boton_info) {
		this.icono_boton_info = icono_boton_info;
	}

	public PanelAgregarPareja getPnl_agregar_pareja() {
		return pnl_agregar_pareja;
	}

	public void setPnl_agregar_pareja(PanelAgregarPareja pnl_agregar_pareja) {
		this.pnl_agregar_pareja = pnl_agregar_pareja;
	}

}
