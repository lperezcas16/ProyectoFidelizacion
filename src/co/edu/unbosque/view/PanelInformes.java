package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformes extends JPanel {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ImageIcon imagen;
	private JTextField campo_usuario, campo_tienda;
	private JComboBox<String> combo_eleccion, combo_estadistica;
	private JLabel etiqueta;
	private JButton boton_generar_pfd, boton_vista_previa;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre se agregar una imagen al fondo del panel con las respectivas
	 *               propiedades != "".
	 */
	public PanelInformes(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
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
		etiqueta = new JLabel("Introducir nombre del usuario");
		etiqueta.setForeground(Color.white);
		etiqueta.setBounds(290, 270, 250, 45);
		etiqueta.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(etiqueta);

		campo_usuario = new JTextField();
		campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_usuario.setBounds(315, 390, 210, 45);
		campo_usuario.setVisible(false);
		add(campo_usuario);

		combo_estadistica = new JComboBox<String>();
		combo_estadistica.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		combo_estadistica.setBounds(320, 330, 200, 40);
		combo_estadistica.addItem("Selecciona");
		combo_estadistica.addItem("Edad");
		combo_estadistica.addItem("Todos los usuarios");

		combo_estadistica.addItem("Tiendas");

		add(combo_estadistica);

		boton_generar_pfd = new JButton("Generar informe");
		boton_generar_pfd.setBounds(150, 460, 200, 45);
		boton_generar_pfd.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_generar_pfd);
		boton_generar_pfd.setVisible(false);

		boton_vista_previa = new JButton("Vista previa");
		boton_vista_previa.setBounds(420, 460, 300, 45);
		boton_vista_previa.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_vista_previa);
		boton_vista_previa.setVisible(false);

	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JTextField.
	 */
	public JTextField getCampo_usuario() {
		return campo_usuario;
	}

	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_usuario Este parametro representa el nuevo valor que va a tener
	 *                      el JTextField != "".
	 */
	public void setCampo_usuario(JTextField campo_usuario) {
		this.campo_usuario = campo_usuario;
	}

	/**
	 * Este metodo devuelve el valor del JComboBox. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JCombobox.
	 */

	public JComboBox<String> getCombo_eleccion() {
		return combo_eleccion;
	}

	/**
	 * Este metodo establece el valor del JComboBox. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param combo_eleccion Este parametro representa el nuevo valor que va a tener
	 *                       el JComboBox != "".
	 */
	public void setCombo_eleccion(JComboBox<String> combo_eleccion) {
		this.combo_eleccion = combo_eleccion;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton() {
		return boton_generar_pfd;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton Este parametro representa el nuevo valor que va a tener el
	 *              JButton != "".
	 */
	public void setBoton(JButton boton) {
		this.boton_generar_pfd = boton;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_vista_previa() {
		return boton_vista_previa;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_vista_previa Este parametro representa el nuevo valor que va a
	 *                           tener el JButton != "".
	 */
	public void setBoton_vista_previa(JButton boton_vista_previa) {
		this.boton_vista_previa = boton_vista_previa;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_generar_pfd() {
		return boton_generar_pfd;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_generar_pfd Este parametro representa el nuevo valor que va a
	 *                          tener el JButton != "".
	 */
	public void setBoton_generar_pfd(JButton boton_generar_pfd) {
		this.boton_generar_pfd = boton_generar_pfd;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JTextField.
	 */
	public JTextField getCampo_tienda() {
		return campo_tienda;
	}

	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_tienda Este parametro representa el nuevo valor que va a tener
	 *                     el JTextField != "".
	 */
	public void setCampo_tienda(JTextField campo_tienda) {
		this.campo_tienda = campo_tienda;
	}

	/**
	 * Este metodo devuelve el valor del JComboBox. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JCombobox.
	 */
	public JComboBox<String> getCombo_estadistica() {
		return combo_estadistica;
	}

	/**
	 * Este metodo establece el valor del JComboBox. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param combo_estadistica Este parametro representa el nuevo valor que va a
	 *                          tener el JComboBox != "".
	 */
	public void setCombo_estadistica(JComboBox<String> combo_estadistica) {
		this.combo_estadistica = combo_estadistica;
	}

	/**
	 * Este es el metodo visibilidadComponentes el cual se inicianilizan las tablas
	 * De esta manera cada componente se crea con una ubicacion, u se le agregar una
	 * imagen si es el caso y se agrega el panel Este método se llama
	 * automaticamente cuando se crea el objeto del panel que lo contiene .
	 * <b>post</b>Son visibles los componentes en el panell<br>
	 * 
	 * @param b Este parametro representa el nuevo calor que tendra la visibilidad
	 *          de los componentes de este panel.
	 */
	public void visibilidadComponentes(boolean b) {

		boton_generar_pfd.setVisible(b);
		boton_vista_previa.setVisible(b);
	}

}