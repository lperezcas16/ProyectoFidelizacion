package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarPareja extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen;
	private JTextField campo_texto_nombre, campo_texto_cupo;
	private JButton boton_agregar_nueva_pareja;

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
		campo_texto_nombre.setBounds(100, 360, 200, 30);
		add(campo_texto_nombre);
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

}
