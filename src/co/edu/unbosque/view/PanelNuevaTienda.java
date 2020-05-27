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
	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel con las respectivas propiedades != "".
	 */
	public PanelNuevaTienda(String nombre) {

		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(false);
	}
	/**
	 * Este es el metodo Gráfico el cual se le asigna la inicialización de los
	 * atributos y objectos que asignan el fondo al panel 
	 * . De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto en la ventana .
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param g  se agregar una imagen al fondo del panel con las respectivas propiedades != "".
	 */
	public void paint(Graphics g) {

		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);
	}
	/**
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los componentes
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto de la ventana  que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
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
	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return  campo_texto_nombre; Este parametro representa el  valor del JTextField.  si no hay retorna null
	 */
	public JTextField getCampo_texto_nombre() {
		return campo_texto_nombre;
	}
	/**
	 * Este metodo establece el valor del c_usuario_inicio <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param  campo_texto_nombre; Este parametro representa el nuevo valor
	 *                 que va a tener el usuario de inicio. != "".
	 */
	public void setCampo_texto_nombre(JTextField campo_texto_nombre) {
		this.campo_texto_nombre = campo_texto_nombre;
	}
	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return campo_texto_direccion Este parametro representa el  valor del JTextField.  si no hay retorna null
	 */
	public JTextField getCampo_texto_direccion() {
		return campo_texto_direccion;
	}
	/**
	 * Este metodo establece el valor del c_usuario_inicio <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param campo_texto_direccion Este parametro representa el nuevo valor
	 *                 que va a tener el usuario de inicio. != "".
	 */
	public void setCampo_texto_direccion(JTextField campo_texto_direccion) {
		this.campo_texto_direccion = campo_texto_direccion;
	}
	/**
	 * Este metodo devuelve el valor del JSpinner. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return spinner_hora_apertura Este parametro representa el  valor del JSpinner.  si no hay retorna null
	 */
	public JSpinner getSpinner_hora_apertura() {
		return spinner_hora_apertura;
	}
	/**
	 * Este metodo establece el valor del JSpinner <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param spinner_hora_apertura Este parametro representa el nuevo valor
	 *                 que va a tener el JSpinner != "".
	 */
	public void setSpinner_hora_apertura(JSpinner spinner_hora_apertura) {
		this.spinner_hora_apertura = spinner_hora_apertura;
	}
	/**
	 * Este metodo devuelve el valor del JSpinner. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return spinner_hora_cierre Este parametro representa el  valor del JSpinner. si no hay retorna null
	 */
	public JSpinner getSpinner_hora_cierre() {
		return spinner_hora_cierre;
	}
	/**
	 * Este metodo establece el valor del JSpinner <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param spinner_hora_cierre Este parametro representa el nuevo valor
	 *                 que va a tener el JSpinner != "".
	 */
	public void setSpinner_hora_cierre(JSpinner spinner_hora_cierre) {
		this.spinner_hora_cierre = spinner_hora_cierre;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_validar_nueva_tienda Este parametro representa el  valor del JButton.  si no hay retorna null
	 */
	public JButton getBoton_validar_nueva_tienda() {
		return boton_validar_nueva_tienda;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_validar_nueva_tienda Este parametro representa el nuevo valor
	 *                 que va a tener el JButton != "".
	 */
	public void setBoton_validar_nueva_tienda(JButton boton_validar_nueva_tienda) {
		this.boton_validar_nueva_tienda = boton_validar_nueva_tienda;
	}

	
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return imagen Este parametro representa el  valor del ImageIcon.  si no hay retorna null
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon. != "".
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return imagen_boton_añadir Este parametro representa el  valor del ImageIcon si no hay retorna null
	public ImageIcon getImagen_boton_añadir() {
		return imagen_boton_añadir;
	}
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_añadir Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon != "".
	 */
	public void setImagen_boton_añadir(ImageIcon imagen_boton_añadir) {
		this.imagen_boton_añadir = imagen_boton_añadir;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return icono_boton_añadir Este parametro representa el  valor del Icon.  si no hay retorna null
	 */
	public Icon getIcono_boton_añadir() {
		return icono_boton_añadir;
	}
	/**
	 * Este metodo establece el valor del c_usuario_inicio <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_añadir Este parametro representa el nuevo valor
	 *                 que va a tener el Icon != "".
	 */
	public void setIcono_boton_añadir(Icon icono_boton_añadir) {
		this.icono_boton_añadir = icono_boton_añadir;
	}
	/**
	 * Este metodo devuelve el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return nombre Este parametro representa el  valor del String.  si no hay retorna null
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Este metodo establece el valor del String <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor
	 *                 que va a tener el String != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_regresar Este parametro representa el  valor del JButton.  si no hay retorna null
	 */
	public JButton getBoton_regresar() {
		return boton_regresar;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton. != "".
	 */
	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return imagen_boton_regresar Este parametro representa el  valor del ImageIcon.  si no hay retorna null
	 */
	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon. != "".
	 */
	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return icono_boton_regresar Este parametro representa el  valor del Icon.  si no hay retorna null
	 */
	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el Icon. != "".
	 */
	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}

}
