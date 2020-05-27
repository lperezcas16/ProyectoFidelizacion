package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class PanelAgregarPareja extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton, imagen_boton_regresar;
	private JTextField campo_texto_nombre, campo_texto_cupo;
	private JButton boton_agregar_nueva_pareja, boton_regresar;
	private Icon icono_boton, icono_boton_regresar;
	private JLabel label_cupo_restante;
	private JDateChooser calendario;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * 
	 * @param nombre se agregar una imagen al fondo del panel con las respectivas
	 *               propiedades != "".
	 */
	public PanelAgregarPareja(String nombre) {
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

		campo_texto_nombre = new JTextField();
		campo_texto_nombre.setBounds(130, 300, 200, 30);
		add(campo_texto_nombre);

		campo_texto_cupo = new JTextField();
		campo_texto_cupo.setBounds(460, 300, 200, 30);
		add(campo_texto_cupo);

		boton_agregar_nueva_pareja = new JButton();
		boton_agregar_nueva_pareja.setBounds(600, 480, 150, 30);
		add(boton_agregar_nueva_pareja);

		imagen_boton = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_nueva_pareja.png"));
		icono_boton = new ImageIcon(imagen_boton.getImage().getScaledInstance(185, 30, Image.SCALE_SMOOTH));

		boton_regresar = new JButton();
		boton_regresar.setBounds(35, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(
				imagen_boton_regresar.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH));

		Color color_azul = new Color(36, 67, 87);
		Color color_naranja = new Color(255, 145, 77);

		label_cupo_restante = new JLabel("$0");
		label_cupo_restante.setBackground(color_azul);
		label_cupo_restante.setForeground(color_naranja);
		label_cupo_restante.setFont(new Font("Accidental Presidency", Font.BOLD, 40));
		label_cupo_restante.setBounds(410, 125, 500, 50);
		add(label_cupo_restante);

		calendario = new JDateChooser("dd-MM-yyyy", "####-##-##", '_');
		calendario.setBounds(130, 410, 200, 30);
		calendario.setOpaque(true);
		calendario.setBackground(Color.WHITE);
		calendario.setMaxSelectableDate(new Date());
		calendario.setDateFormatString("dd-MM-yyyy");
		Calendar fecha = new GregorianCalendar();
		calendario.setCalendar(fecha);
		add(calendario);
	}

	/**
	 * Este metodo devuelve el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
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
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
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
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */

	public JTextField getCampo_texto_nombre() {
		return campo_texto_nombre;
	}

	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_texto_nombre Este parametro representa el nuevo valor que va a
	 *                           tener el JTextField != "".
	 */
	public void setCampo_texto_nombre(JTextField campo_texto_nombre) {
		this.campo_texto_nombre = campo_texto_nombre;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
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
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JButton.
	 */
	public JButton getBoton_agregar_nueva_pareja() {
		return boton_agregar_nueva_pareja;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_nueva_pareja Este parametro representa el nuevo valor
	 *                                   que va a tener el JButton != "".
	 */
	public void setBoton_agregar_nueva_pareja(JButton boton_agregar_nueva_pareja) {
		this.boton_agregar_nueva_pareja = boton_agregar_nueva_pareja;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de ImageIcon.
	 */
	public ImageIcon getImagen_boton() {
		return imagen_boton;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_boton Este parametro representa el nuevo valor que va a tener
	 *                     el ImageIcon != "".
	 */
	public void setImagen_boton(ImageIcon imagen_boton) {
		this.imagen_boton = imagen_boton;
	}

	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de Icon.
	 */
	public Icon getIcono_boton() {
		return icono_boton;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_boton Este parametro representa el nuevo valor que va a tener el
	 *                    Icon != "".
	 */
	public void setIcono_boton(Icon icono_boton) {
		this.icono_boton = icono_boton;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
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
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
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
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor al
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
	 * Este metodo devuelve el valor del JLabel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JLabel.
	 */
	public JLabel getLabel_cupo_restante() {
		return label_cupo_restante;
	}

	/**
	 * Este metodo establece el valor del JLabel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param label_cupo_restante Este parametro representa el nuevo valor que va a
	 *                            tener el JLabel != "".
	 */
	public void setLabel_cupo_restante(JLabel label_cupo_restante) {
		this.label_cupo_restante = label_cupo_restante;
	}

	/**
	 * Este metodo devuelve el valor del JDateChooser. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JDateChooser.
	 */
	public JDateChooser getCalendario() {
		return calendario;
	}

	/**
	 * Este metodo establece el valor del JDateChooser <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param calendario Este parametro representa el nuevo valor que va a tener el
	 *                   JDateChooser != "".
	 */
	public void setCalendario(JDateChooser calendario) {
		this.calendario = calendario;
	}

}
