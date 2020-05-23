package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton_historial, imagen_boton_ingresar_compra, imagen_boton_regresar;
	private JButton boton_historial, boton_ingresar_compra, boton_regresar;
	private Icon icono_boton_historial, icono_boton_ingresar_compra, icono_boton_regresar;
	private PanelIngresarCompra pnl_ingresar_compra;
	private PanelVerHistorial pnl_ver_historial;

	public PanelCompras(String nombre) {
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
		boton_historial = new JButton();
		boton_historial.setBounds(80, 100, 300, 30);
		add(boton_historial);

		imagen_boton_historial = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_ver_historial.png"));
		icono_boton_historial = new ImageIcon(
				imagen_boton_historial.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		boton_ingresar_compra = new JButton();
		boton_ingresar_compra.setBounds(420, 100, 300, 30);
		add(boton_ingresar_compra);

		imagen_boton_ingresar_compra = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_ingresar_compra.png"));
		icono_boton_ingresar_compra = new ImageIcon(
				imagen_boton_ingresar_compra.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		boton_regresar = new JButton();
		boton_regresar.setBounds(600, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(
				imagen_boton_regresar.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		pnl_ingresar_compra = new PanelIngresarCompra("/co/edu/unbosque/imagenes/fondo_ingresa_compra.png");
		pnl_ingresar_compra.setBounds(0, 200, 795, 310);
		add(pnl_ingresar_compra);

		pnl_ingresar_compra.getBoton_agregar_compra().setIcon(pnl_ingresar_compra.getIcono_boton_agregar_compra());

		pnl_ver_historial = new PanelVerHistorial();
		pnl_ver_historial.setBounds(0, 150, 795, 310);
		add(pnl_ver_historial);

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

	public ImageIcon getImagen_boton_historial() {
		return imagen_boton_historial;
	}

	public void setImagen_boton_historial(ImageIcon imagen_boton_historial) {
		this.imagen_boton_historial = imagen_boton_historial;
	}

	public ImageIcon getImagen_boton_ingresar_compra() {
		return imagen_boton_ingresar_compra;
	}

	public void setImagen_boton_ingresar_compra(ImageIcon imagen_boton_ingresar_compra) {
		this.imagen_boton_ingresar_compra = imagen_boton_ingresar_compra;
	}

	public JButton getBoton_historial() {
		return boton_historial;
	}

	public void setBoton_historial(JButton boton_historial) {
		this.boton_historial = boton_historial;
	}

	public JButton getBoton_ingresar_compra() {
		return boton_ingresar_compra;
	}

	public void setBoton_ingresar_compra(JButton boton_ingresar_compra) {
		this.boton_ingresar_compra = boton_ingresar_compra;
	}

	public Icon getIcono_boton_historial() {
		return icono_boton_historial;
	}

	public void setIcono_boton_historial(Icon icono_boton_historial) {
		this.icono_boton_historial = icono_boton_historial;
	}

	public Icon getIcono_boton_ingresar_compra() {
		return icono_boton_ingresar_compra;
	}

	public void setIcono_boton_ingresar_compra(Icon icono_boton_ingresar_compra) {
		this.icono_boton_ingresar_compra = icono_boton_ingresar_compra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}

	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}

	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}

	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}

	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}

	public PanelIngresarCompra getPnl_ingresar_compra() {
		return pnl_ingresar_compra;
	}

	public void setPnl_ingresar_compra(PanelIngresarCompra pnl_ingresar_compra) {
		this.pnl_ingresar_compra = pnl_ingresar_compra;
	}

	public PanelVerHistorial getPnl_ver_historial() {
		return pnl_ver_historial;
	}

	public void setPnl_ver_historial(PanelVerHistorial pnl_ver_historial) {
		this.pnl_ver_historial = pnl_ver_historial;
	}

	public void visibilidadComponentes(boolean b) {
		boton_historial.setVisible(b);
		boton_ingresar_compra.setVisible(b);
		boton_regresar.setVisible(b);
	}
}
