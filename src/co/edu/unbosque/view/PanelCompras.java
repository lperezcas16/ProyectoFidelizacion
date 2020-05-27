
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
	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de
	 *  generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel con las respectivas propiedades != "".
	 */
	public PanelCompras(String nombre) {
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
	/**
	 * Este metodo devuelve el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el  valor del String. != "".
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
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el  valor del ImageIcon. != "".
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
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param c_usuario_inicio Este parametro representa el  valor del ImageIcon. != "".
	 */
	public ImageIcon getImagen_boton_historial() {
		return imagen_boton_historial;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_historial Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon != "".
	 */
	public void setImagen_boton_historial(ImageIcon imagen_boton_historial) {
		this.imagen_boton_historial = imagen_boton_historial;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_ingresar_compra Este parametro representa el  valor del ImageIcon. != "".
	 */
	public ImageIcon getImagen_boton_ingresar_compra() {
		return imagen_boton_ingresar_compra;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_ingresar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon != "".
	 */
	public void setImagen_boton_ingresar_compra(ImageIcon imagen_boton_ingresar_compra) {
		this.imagen_boton_ingresar_compra = imagen_boton_ingresar_compra;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_historial Este parametro representa el  valor del JButton. != "".
	 */
	public JButton getBoton_historial() {
		return boton_historial;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_historial Este parametro representa el nuevo valor
	 *                 que va a tener el JButton != "".
	 */
	public void setBoton_historial(JButton boton_historial) {
		this.boton_historial = boton_historial;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ingresar_compra Este parametro representa el  valor del JButton. != "".
	 */
	public JButton getBoton_ingresar_compra() {
		return boton_ingresar_compra;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ingresar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el JButton != "".
	 */

	public void setBoton_ingresar_compra(JButton boton_ingresar_compra) {
		this.boton_ingresar_compra = boton_ingresar_compra;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_historial Este parametro representa el  valor del Icon. != "".
	 */
	public Icon getIcono_boton_historial() {
		return icono_boton_historial;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_historial Este parametro representa el nuevo valor
	 *                 que va a tener el Icon != "".
	 */
	public void setIcono_boton_historial(Icon icono_boton_historial) {
		this.icono_boton_historial = icono_boton_historial;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_ingresar_compra Este parametro representa el  valor del Icon. != "".
	 */
	public Icon getIcono_boton_ingresar_compra() {
		return icono_boton_ingresar_compra;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_ingresar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el Icon != "".
	 */
	public void setIcono_boton_ingresar_compra(Icon icono_boton_ingresar_compra) {
		this.icono_boton_ingresar_compra = icono_boton_ingresar_compra;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el  valor del ImageIcon. != "".
	 */
	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon != "".
	 */
	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el  valor del JButton. != "".
	 */
	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton != "".
	 */
	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_regresar Este parametro representa el  valor del Icon. != "".
	 */
	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el Icon != "".
	 */
	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del PanelIngresarCompra. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_ingresar_compra Este parametro representa el  valor del PanelIngresarCompra. != "".
	 */
	public PanelIngresarCompra getPnl_ingresar_compra() {
		return pnl_ingresar_compra;
	}

	/**
	 * Este metodo establece el valor del PanelIngresarCompra <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_ingresar_compra Este parametro representa el nuevo valor
	 *                 que va a tener el PanelIngresarCompra != "".
	 */
	public void setPnl_ingresar_compra(PanelIngresarCompra pnl_ingresar_compra) {
		this.pnl_ingresar_compra = pnl_ingresar_compra;
	}
	/**
	 * Este metodo devuelve el valor del PanelVerHistorial. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_ver_historial Este parametro representa el  valor del PanelVerHistorial. != "".
	 */
	public PanelVerHistorial getPnl_ver_historial() {
		return pnl_ver_historial;
	}

	/**
	 * Este metodo establece el valor del PanelVerHistorial <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_ver_historial Este parametro representa el nuevo valor
	 *                 que va a tener el PanelVerHistorial != "".
	 */
	public void setPnl_ver_historial(PanelVerHistorial pnl_ver_historial) {
		this.pnl_ver_historial = pnl_ver_historial;
	}
	/**
	 * Este es el metodo visibilidadComponentes el cual permite que 
	 * los campos sean visibles cuaando el método es llamado
	 * objeto.<b>post</b> quedan vacios los campos del panel .<br>
	 * @param b booleano que resive si son visibles o no los componentes seleccinados 
	 */
	public void visibilidadComponentes(boolean b) {
		boton_historial.setVisible(b);
		boton_ingresar_compra.setVisible(b);
		boton_regresar.setVisible(b);
	}
}
