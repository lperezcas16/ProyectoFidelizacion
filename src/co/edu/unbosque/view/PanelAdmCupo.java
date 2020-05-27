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
	public PanelAdmCupo(String nombre) {
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

	/**
	 * Este metodo devuelve el valor del String <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * nombre
	 * 
	 * @return Retorna el atributo en formato de String.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo establece el valor del String <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor que va a tener el
	 *               String != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de ImageIcon.
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor que va a tener el
	 *               ImageIcon != "".
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de ImageIcon.
	 */
	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el nuevo valor que va
	 *                              a tener el ImageIcon != "".
	 */
	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de Icon.
	 */
	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_boton_regresar Este parametro representa el nuevo valor que va a
	 *                             tener el Icon != "".
	 */
	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JButton.
	 */
	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el nuevo valor que va a tener
	 *                       el JButton != "".
	 */
	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JButton.
	 */
	public JButton getBoton_validar_cupo() {
		return boton_validar_cupo;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_validar_cupo Este parametro representa el nuevo valor que va a
	 *                           tener el JButton != "".
	 */
	public void setBoton_validar_cupo(JButton boton_validar_cupo) {
		this.boton_validar_cupo = boton_validar_cupo;
	}

	/**
	 * Este metodo devuelve el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */

	public JTextField getCampo_texto_cupo() {
		return campo_texto_cupo;
	}

	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_texto_cupo Este parametro representa el nuevo valor que va a
	 *                         tener el JTextField != "".
	 */
	public void setCampo_texto_cupo(JTextField campo_texto_cupo) {
		this.campo_texto_cupo = campo_texto_cupo;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de ImageIcon.
	 */
	public ImageIcon getImagen_validar_cupo() {
		return imagen_validar_cupo;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_validar_cupo Este parametro representa el nuevo valor que va a
	 *                            tener el ImageIcon != "".
	 */
	public void setImagen_validar_cupo(ImageIcon imagen_validar_cupo) {
		this.imagen_validar_cupo = imagen_validar_cupo;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de Icon.
	 */
	public Icon getIcono_validar_cupo() {
		return icono_validar_cupo;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_validar_cupo Este parametro representa el nuevo valor que va a
	 *                           tener el Icon != "".
	 */

	public void setIcono_validar_cupo(Icon icono_validar_cupo) {
		this.icono_validar_cupo = icono_validar_cupo;
	}

}
