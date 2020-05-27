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
	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel con las respectivas propiedades != "".
	 */
	public PanelIngresarCompra(String nombre) {
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
	/**
	 * Este metodo devuelve el valor del JComboBox<Object>. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return combobox_parejas Este parametro representa el  valor del JComboBox<Object>. si no hay retorna null
	 */
	public JComboBox<Object> getCombobox_parejas() {
		return combobox_parejas;
	}
	
	/**
	 * Este metodo establece el valor del JComboBox<Object>  <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param combobox_parejas Este parametro representa el nuevo valor
	 *                 que va a tener el JComboBox<Object>  != "".
	 */
	public void setCombobox_parejas(JComboBox<Object> combobox_parejas) {
		this.combobox_parejas = combobox_parejas;
	}
	/**
	 * Este metodo devuelve el valor del JJComboBox<Object>. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return combobox_tiendas Este parametro representa el  valor del JComboBox<Object>. si no hay retorna null
	 */
	public JComboBox<Object> getCombobox_tiendas() {
		return combobox_tiendas;
	}
	
	/**
	 * Este metodo establece el valor del JComboBox<Object> <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param combobox_tiendas Este parametro representa el nuevo valor
	 *                 que va a tener el JComboBox<Object> != "".
	 */
	public void setCombobox_tiendas(JComboBox<Object> combobox_tiendas) {
		this.combobox_tiendas = combobox_tiendas;
	}
	/**
	 * Este metodo devuelve el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return nombre Este parametro representa el  valor del String. si no hay retorna null
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
	 * Este metodo devuelve el valor del ImageIcon
	 *  <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return imagen Este parametro representa el  valor del ImageIcon si no hay retorna null
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon != "".
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return campo_texto_dinero Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon  si no hay retorna null
	 */
	public void setImagen_boton_agregar_compra(ImageIcon imagen_boton_agregar_compra) {
		this.imagen_boton_agregar_compra = imagen_boton_agregar_compra;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return campo_texto_dinero Este parametro representa el  valor del ImageIcon si no hay retorna null
	 */

	public JTextField getCampo_texto_dinero() {
		return campo_texto_dinero;
	}
	
	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el JTextField != "".
	 */
	public void setCampo_texto_dinero(JTextField campo_texto_dinero) {
		this.campo_texto_dinero = campo_texto_dinero;
	}
	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_agregar_compra Este parametro representa el  valor del JButton si no hay retorna null
	 */
	public JButton getBoton_agregar_compra() {
		return boton_agregar_compra;
	}
	
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el JButton != "".
	 */
	public void setBoton_agregar_compra(JButton boton_agregar_compra) {
		this.boton_agregar_compra = boton_agregar_compra;
	}
	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return icono_boton_agregar_compra Este parametro representa el  valor del Icon si no hay retorna null
	 */
	public Icon getIcono_boton_agregar_compra() {
		return icono_boton_agregar_compra;
	}
	
	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_agregar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el Icon != "".
	 */
	public void setIcono_boton_agregar_compra(Icon icono_boton_agregar_compra) {
		this.icono_boton_agregar_compra = icono_boton_agregar_compra;
	}
	/**
	 * Este es el metodo visibilidadComponentes el cual permite que 
	 * los campos sean visibles cuaando el método es llamado
	 * objeto.<b>post</b> quedan vacios los campos del panel .<br>
	 * @param b booleano que resive si son visibles o no los componentes seleccinados 
	 */
	public void visibilidadComponentes(boolean b) {
		boton_agregar_compra.setVisible(b);
		campo_texto_dinero.setVisible(b);
		combobox_parejas.setVisible(b);
		combobox_tiendas.setVisible(b);
	}

}
