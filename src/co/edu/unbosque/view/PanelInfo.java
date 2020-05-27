package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ImageIcon imagen;

	private JLabel label_nombre, label_genero, label_correo, label_usuario, label_tipo;
	private JButton boton_cerrar;

	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre se agregar una imagen al fondo del panel con las respectivas
	 *               propiedades != "".
	 */
	public PanelInfo(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(false);
	}

	/**
	 * Este es el metodo Gráfico el cual se le asigna la inicialización de los
	 * atributos y objectos que asignan el fondo al panel . De esta manera el
	 * objecto es creado con un valor inicial. Este método se llama automaticamente
	 * cuando se crea el objeto en la ventana . <b>post</b>Se debe llamar el metodo
	 * y dar un valor a los parametros a la hora de generar un nuevo horario.<br>
	 * 
	 * @param g se agregar una imagen al fondo del panel con las respectivas
	 *          propiedades != "".
	 */
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

	/**
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los
	 * componentes De esta manera cada componente se crea con una ubicacion, u se le
	 * agregar una imagen si es el caso y se agrega el panel Este método se llama
	 * automaticamente cuando se crea el objeto de la ventana que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {

		Color color_azul = new Color(36, 67, 87);
		Color color_naranja = new Color(225, 145, 77);

		label_nombre = new JLabel("SOLU-SOFT");
		label_nombre.setBackground(color_azul);
		label_nombre.setForeground(color_naranja);
		label_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_nombre.setBounds(260, 160, 500, 50);
		add(label_nombre);

		label_genero = new JLabel("agenero");
		label_genero.setBackground(color_azul);
		label_genero.setForeground(color_naranja);
		label_genero.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_genero.setBounds(260, 220, 500, 50);
		add(label_genero);

		label_correo = new JLabel("solusoftunbosque@gmail.com");
		label_correo.setBackground(color_azul);
		label_correo.setForeground(color_naranja);
		label_correo.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_correo.setBounds(260, 285, 500, 50);
		add(label_correo);

		label_usuario = new JLabel("Usuario Administrador");
		label_usuario.setBackground(color_azul);
		label_usuario.setForeground(color_naranja);
		label_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_usuario.setBounds(260, 345, 500, 50);
		add(label_usuario);

		label_tipo = new JLabel("Administrador");
		label_tipo.setBackground(color_azul);
		label_tipo.setForeground(color_naranja);
		label_tipo.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		label_tipo.setBounds(280, 420, 500, 50);
		add(label_tipo);

		boton_cerrar = new JButton("Cerrar sesion");
		boton_cerrar.setBounds(500, 150, 200, 50);
		boton_cerrar.setFont(new Font("Accidental Presidency", Font.BOLD, 25));
		add(boton_cerrar);
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_cerrar() {
		return boton_cerrar;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_cerrar Este parametro representa el nuevo valor que va a tener
	 *                     el JButton != "".
	 */
	public void setBoton_cerrar(JButton boton_cerrar) {
		this.boton_cerrar = boton_cerrar;
	}

}
