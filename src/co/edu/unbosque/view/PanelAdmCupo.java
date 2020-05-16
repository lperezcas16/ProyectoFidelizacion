package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAdmCupo extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton_regresar, imagen_validar_cupo;
	private Icon icono_boton_regresar, icono_validar_cupo;
	private JButton boton_regresar, boton_validar_cupo;
	private JTextField campo_texto_cupo;

	public PanelAdmCupo(String nombre) {
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

		boton_regresar = new JButton();
		boton_regresar.setBounds(35, 380, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(
				imagen_boton_regresar.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH));

		campo_texto_cupo = new JTextField();
		campo_texto_cupo.setBounds(180, 315, 300, 30);
		add(campo_texto_cupo);

		boton_validar_cupo = new JButton();
		boton_validar_cupo.setBounds(550, 315, 150, 30);
		add(boton_validar_cupo);

		imagen_validar_cupo = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_confirmar.png"));
		icono_validar_cupo = new ImageIcon(
				imagen_validar_cupo.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH));

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

	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}

	public JButton getBoton_validar_cupo() {
		return boton_validar_cupo;
	}

	public void setBoton_validar_cupo(JButton boton_validar_cupo) {
		this.boton_validar_cupo = boton_validar_cupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getCampo_texto_cupo() {
		return campo_texto_cupo;
	}

	public void setCampo_texto_cupo(JTextField campo_texto_cupo) {
		this.campo_texto_cupo = campo_texto_cupo;
	}

	public ImageIcon getImagen_validar_cupo() {
		return imagen_validar_cupo;
	}

	public void setImagen_validar_cupo(ImageIcon imagen_validar_cupo) {
		this.imagen_validar_cupo = imagen_validar_cupo;
	}

	public Icon getIcono_validar_cupo() {
		return icono_validar_cupo;
	}

	public void setIcono_validar_cupo(Icon icono_validar_cupo) {
		this.icono_validar_cupo = icono_validar_cupo;
	}

}
