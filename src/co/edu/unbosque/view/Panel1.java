package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class Panel1 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField c_usuario_inicio, campo_usuario, campo_nombre, campo_numCedula, campo_correo;
	private JPasswordField c_contrasena_inicio, campo_contrasena;
	private JButton boton_entrar, boton_registrar;
	private ButtonGroup grupo;
	private JRadioButton c1, c2;
	private ImageIcon imagen, imagen_entrar, imagen_registar;
	private Icon icono_entrar, icono_registrar;
	private String nombre;
	private JDateChooser calendario;

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
	public Panel1(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		setBounds(0, 0, 790, 590);
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

		// 1
		c_usuario_inicio = new JTextField();
		c_usuario_inicio.setBounds(340, 35, 250, 25);
		c_usuario_inicio.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(c_usuario_inicio);

		c_contrasena_inicio = new JPasswordField();
		c_contrasena_inicio.setBounds(340, 100, 250, 25);
		c_contrasena_inicio.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(c_contrasena_inicio);

		boton_entrar = new JButton();
		boton_entrar.setBounds(620, 55, 100, 50);
		add(boton_entrar);

		imagen_entrar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_entrada.png"));
		icono_entrar = new ImageIcon(imagen_entrar.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		boton_entrar.setHorizontalAlignment(SwingConstants.CENTER);
		boton_entrar.setVerticalAlignment(SwingConstants.CENTER);
		boton_entrar.setContentAreaFilled(false);
		boton_entrar.setBorderPainted(false);
		boton_entrar.setIcon(icono_entrar);

		// 2
		campo_nombre = new JTextField();
		campo_nombre.setBounds(36, 210, 250, 25);
		campo_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_nombre.setBorder(null);
		add(campo_nombre);

		Color colorA = new Color(36, 67, 87);
		grupo = new ButtonGroup();
		c1 = new JRadioButton("Mujer");
		c1.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		c1.setBackground(colorA);
		c1.setForeground(Color.white);

		c2 = new JRadioButton("Hombre");
		c2.setBackground(colorA);
		c2.setForeground(Color.white);
		c2.setFont(new Font("Accidental Presidency", Font.BOLD, 16));

		c1.setBounds(66, 300, 100, 20);
		c2.setBounds(180, 300, 100, 20);
		grupo.add(c1);
		grupo.add(c2);
		add(c1);
		add(c2);

		// 1
		campo_correo = new JTextField();
		campo_correo.setBounds(40, 410, 250, 25);
		campo_correo.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_correo.setBorder(null);
		add(campo_correo);

		campo_usuario = new JTextField();
		campo_usuario.setBounds(410, 210, 250, 25);
		campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_usuario.setBorder(null);
		add(campo_usuario);

		campo_contrasena = new JPasswordField();
		campo_contrasena.setBounds(410, 300, 250, 25);
		campo_contrasena.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_contrasena.setBorder(null);
		add(campo_contrasena);

		boton_registrar = new JButton();
		boton_registrar.setBounds(320, 490, 150, 50);
		add(boton_registrar);

		imagen_registar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_registrar.png"));
		icono_registrar = new ImageIcon(imagen_registar.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH));
		boton_registrar.setHorizontalAlignment(SwingConstants.CENTER);
		boton_registrar.setVerticalAlignment(SwingConstants.CENTER);
		boton_registrar.setContentAreaFilled(false);
		boton_registrar.setBorderPainted(false);
		boton_registrar.setIcon(icono_registrar);

		calendario = new JDateChooser("dd-MM-yyyy", "####-##-##", '_');
		calendario.setBounds(435, 410, 200, 30);
		calendario.setOpaque(true);
		calendario.setBackground(Color.WHITE);
		calendario.setMaxSelectableDate(new Date());
		calendario.setDateFormatString("dd-MM-yyyy");
		Calendar fecha = new GregorianCalendar();
		calendario.setCalendar(fecha);
		add(calendario);

	}

	/**
	 * Este es el metodo limpiarCampos el cual se dejan todos los campos vacios en
	 * el panel1 cuando es llamado objeto.<b>post</b> quedan vacios los campos del
	 * panel .<br>
	 */

	public void limpiarCampos() {
		campo_usuario.setText("");
		campo_contrasena.setText("");
		campo_correo.setText("");
		campo_nombre.setText("");
		c_usuario_inicio.setText("");
		c_contrasena_inicio.setText("");
		grupo.clearSelection();

	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */
	public JTextField getC_usuario_inicio() {
		return c_usuario_inicio;
	}

	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param c_usuario_inicio Este parametro representa el nuevo valor que va a
	 *                         tener el JTextField != "".
	 */
	public void setC_usuario_inicio(JTextField c_usuario_inicio) {
		this.c_usuario_inicio = c_usuario_inicio;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */
	public JTextField getCampo_usuario() {
		return campo_usuario;
	}

	/**
	 * Este metodo establece el valor del campo_usuario <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_usuario Este parametro representa el nuevo valor que va a tener
	 *                      el usuario. != "".
	 */
	public void setCampo_usuario(JTextField campo_usuario) {
		this.campo_usuario = campo_usuario;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */
	public JTextField getCampo_nombre() {
		return campo_nombre;
	}

	/**
	 * Este metodo establece el valor del campo_nombre. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_nombre Este parametro representa el nuevo valor que va a tener
	 *                     el nombre. != "".
	 */

	public void setCampo_nombre(JTextField campo_nombre) {
		this.campo_nombre = campo_nombre;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */
	public JTextField getCampo_numCedula() {
		return campo_numCedula;
	}

	/**
	 * Este metodo establece el valor del numero de cédula. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param campo_numCedula Este parametro representa el nuevo valor que va a
	 *                        tener el campo de texto del numero de la cedula.
	 *                        campo_numCedula != null, campo_numCedula != "".
	 */
	public void setCampo_numCedula(JTextField campo_numCedula) {
		this.campo_numCedula = campo_numCedula;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JTextField.
	 */
	public JTextField getCampo_correo() {
		return campo_correo;
	}

	/**
	 * Este metodo establece el valor del correo. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param campo_correo Este parametro representa el nuevo valor que va a tener
	 *                     el correo. != "".
	 */
	public void setCampo_correo(JTextField campo_correo) {
		this.campo_correo = campo_correo;
	}

	/**
	 * Este metodo devuelve el valor del JPasswordField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JPasswordField.
	 */
	public JPasswordField getC_contrasena_inicio() {
		return c_contrasena_inicio;
	}

	/**
	 * Este metodo establece el valor del la contraseña. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param c_contrasena_inicio Este parametro representa el nuevo valor que va a
	 *                            tener la contraseña. != "".
	 */
	public void setC_contrasena_inicio(JPasswordField c_contrasena_inicio) {
		this.c_contrasena_inicio = c_contrasena_inicio;
	}

	/**
	 * Este metodo devuelve el valor del JPasswordField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JPasswordField.
	 */
	public JPasswordField getCampo_contrasena() {
		return campo_contrasena;
	}

	/**
	 * Este metodo establece el valor del la contraseña. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param campo_contrasena Este parametro representa el nuevo valor que va a
	 *                         tener la contraseña. != "".
	 */
	public void setCampo_contrasena(JPasswordField campo_contrasena) {
		this.campo_contrasena = campo_contrasena;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JButton.
	 */
	public JButton getBoton_entrar() {
		return boton_entrar;
	}

	/**
	 * Este metodo establece el valor del nombre. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_entrar Este parametro representa el nuevo valor que va a tener
	 *                     el boton entrar . != "".
	 */
	public void setBoton_entrar(JButton boton_entrar) {
		this.boton_entrar = boton_entrar;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JButton.
	 */
	public JButton getBoton_registrar() {
		return boton_registrar;
	}

	/**
	 * Este metodo establece el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_registrar Este parametro representa el nuevo valor que va a
	 *                        tener el JButton. != "".
	 */
	public void setBoton_registrar(JButton boton_registrar) {
		this.boton_registrar = boton_registrar;
	}

	/**
	 * Este metodo devuelve el valor del ButtonGroup. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de ButtonGroup.
	 */
	public ButtonGroup getGrupo() {
		return grupo;
	}

	/**
	 * Este metodo establece el valor del ButtonGroup. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param grupo Este parametro representa el nuevo valor que va a tener el
	 *              ButtonGroup. != "".
	 */
	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JRadioButton.
	 */
	public JRadioButton getC1() {
		return c1;
	}

	/**
	 * Este metodo establece el valor del JRadioButton. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param c1 Este parametro representa el nuevo valor que va a tener el
	 *           JRadioButton. != "".
	 */
	public void setC1(JRadioButton c1) {
		this.c1 = c1;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JRadioButton.
	 */
	public JRadioButton getC2() {
		return c2;
	}

	/**
	 * Este metodo establece el valor del JRadioButton. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param c2 Este parametro representa el nuevo valor que va a tener el
	 *           JRadioButton. != "".
	 */
	public void setC2(JRadioButton c2) {
		this.c2 = c2;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de cadena de caracteres.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo establece el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor que va a tener el
	 *               String. != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato de JDateChooser.
	 */
	public JDateChooser getCalendario() {
		return calendario;
	}

	/**
	 * Este metodo establece el valor del JDateChooser. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param calendario Este parametro representa el nuevo valor que va a tener el
	 *                   JDateChooser. != "".
	 */
	public void setCalendario(JDateChooser calendario) {
		this.calendario = calendario;
	}

}
