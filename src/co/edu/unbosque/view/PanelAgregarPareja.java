package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarPareja extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton;
	private JTextField campo_texto_nombre, campo_texto_cupo;
	private JButton boton_agregar_nueva_pareja;
	private Icon icono_boton;

	public PanelAgregarPareja(String nombre) {
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

		campo_texto_nombre = new JTextField();
		campo_texto_nombre.setBounds(130, 320, 200, 30);
		add(campo_texto_nombre);

		campo_texto_cupo = new JTextField();
		campo_texto_cupo.setBounds(460, 320, 200, 30);
		add(campo_texto_cupo);

		boton_agregar_nueva_pareja = new JButton();
		boton_agregar_nueva_pareja.setBounds(320, 420, 150, 30);
		add(boton_agregar_nueva_pareja);

		imagen_boton = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_nueva_pareja.png"));
		icono_boton = new ImageIcon(imagen_boton.getImage().getScaledInstance(185, 30, Image.SCALE_SMOOTH));
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

	public JTextField getCampo_texto_nombre() {
		return campo_texto_nombre;
	}

	public void setCampo_texto_nombre(JTextField campo_texto_nombre) {
		this.campo_texto_nombre = campo_texto_nombre;
	}

	public JTextField getCampo_texto_cupo() {
		return campo_texto_cupo;
	}

	public void setCampo_texto_cupo(JTextField campo_texto_cupo) {
		this.campo_texto_cupo = campo_texto_cupo;
	}

	public JButton getBoton_agregar_nueva_pareja() {
		return boton_agregar_nueva_pareja;
	}

	public void setBoton_agregar_nueva_pareja(JButton boton_agregar_nueva_pareja) {
		this.boton_agregar_nueva_pareja = boton_agregar_nueva_pareja;
	}

	public ImageIcon getImagen_boton() {
		return imagen_boton;
	}

	public void setImagen_boton(ImageIcon imagen_boton) {
		this.imagen_boton = imagen_boton;
	}

	public Icon getIcono_boton() {
		return icono_boton;
	}

	public void setIcono_boton(Icon icono_boton) {
		this.icono_boton = icono_boton;
	}

}