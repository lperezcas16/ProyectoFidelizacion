package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo_buscar;
	private JButton boton_orden_nombreu, boton_orden_aliasu, boton_orden_correou, boton_orden_nombrep, boton_eliminar,
			boton_ver_usuarios, ver_parejas, boton_buscar_usuario;
	private JTextField campo_buscar;
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1, scroll2;

	private DefaultTableModel model1, model2;
	private JTable tabla1, tabla2;

	private String[] cabecera1 = { "Nombre", "Alias", "Correo", "Edad", "Genero", "Numero de Tarjeta", "Cupo" };
	private String[] cabecera2 = { "Nombre", "Valor cupo" };

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel
	 *  con las respectivas propiedades != "".!= ""
	 */
	public PanelUsuarios(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTablas();
		setVisible(true);

	}
	/**
	 * Este es el metodo Gráfico el cual se le asigna la inicialización de los
	 * atributos y objectos que asignan el fondo al panel 
	 * . De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto en la ventana .
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param g  se agregar una imagen al fondo del
	 *  panel con las respectivas propiedades != "".
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

		combo_buscar = new JComboBox<String>();
		combo_buscar.addItem("Seleccione");
		combo_buscar.addItem("Nombre");
		combo_buscar.addItem("Correo");
		combo_buscar.addItem("Alias");
		combo_buscar.setBounds(36, 150, 150, 25);
		combo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(combo_buscar);

		campo_buscar = new JTextField("");
		campo_buscar.setBounds(200, 150, 250, 25);
		campo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_buscar);

		boton_eliminar = new JButton("Eliminar usuario");
		boton_eliminar.setBounds(500, 150, 250, 25);
		boton_eliminar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_eliminar);

		ver_parejas = new JButton("Ver Parejas");
		ver_parejas.setBounds(490, 280, 250, 25);
		ver_parejas.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(ver_parejas);

		boton_ver_usuarios = new JButton("Ver usuarios");
		boton_ver_usuarios.setBounds(500, 100, 250, 25);
		boton_ver_usuarios.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_ver_usuarios);

		boton_buscar_usuario = new JButton("Buscar usuario");
		boton_buscar_usuario.setBounds(280, 100, 200, 25);
		boton_buscar_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_buscar_usuario);

		boton_orden_nombreu = new JButton("Ordenar Nombres De Usuarios");
		boton_orden_nombreu.setBounds(76, 440, 300, 25);
		boton_orden_nombreu.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_orden_nombreu);

		boton_orden_aliasu = new JButton("Ordenar Alias De Usuarios");
		boton_orden_aliasu.setBounds(76, 470, 300, 25);
		boton_orden_aliasu.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_orden_aliasu);

		boton_orden_correou = new JButton("Ordenar Usuarios Por Correo");
		boton_orden_correou.setBounds(400, 440, 300, 25);
		boton_orden_correou.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_orden_correou);

		boton_orden_nombrep = new JButton("Ordenar Parejas Por Nombres");
		boton_orden_nombrep.setBounds(400, 470, 300, 25);
		boton_orden_nombrep.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_orden_nombrep);

	}

	/**
	 * Este es el metodo crearTABLAS el cual se muestran las tablas 
	 * .<b>post</b> Las tablas son mostradas en el pannel cuando son llamadas .<br>
	 */
	public void crearTablas() {
		tabla1 = new JTable();
		model1 = new DefaultTableModel(cabecera1, 0);
		tabla1 = new JTable(model1);
		tabla1.setModel(model1);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla1.setPreferredSize(new Dimension(700, 700));
		tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < cabecera1.length; i++) {
			tabla1.getColumnModel().getColumn(i).setCellRenderer(Alinear);
			TableColumnModel columnModel = tabla1.getColumnModel();
			columnModel.getColumn(i).setPreferredWidth(200);

			// /////////////////////////////////////////////////////////////
			tabla2 = new JTable();
			model2 = new DefaultTableModel(cabecera2, 0);
			tabla2 = new JTable(model2);
			tabla2.setModel(model2);

			DefaultTableCellRenderer Alinear2 = new DefaultTableCellRenderer();
			Alinear2.setHorizontalAlignment(SwingConstants.CENTER);
			tabla2.setPreferredSize(new Dimension(700, 700));
			tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			for (int j = 0; j < cabecera2.length; j++) {
				tabla2.getColumnModel().getColumn(j).setCellRenderer(Alinear2);
				TableColumnModel columnModel2 = tabla2.getColumnModel();
				columnModel2.getColumn(j).setPreferredWidth(200);
			}

		}

		scroll2 = new JScrollPane(tabla2);
		scroll2.setViewportView(tabla2);
		scroll2.setBounds(36, 320, 700, 100);
		add(scroll2);

		scroll1 = new JScrollPane(tabla1);
		scroll1.setViewportView(tabla1);
		scroll1.setBounds(36, 200, 700, 70);
		add(scroll1);
	}
	/**
	 * Este metodo devuelve el valor del JComboBox<String>. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return combo_buscar Este parametro representa el  valor del JComboBox<String>. si no hay retorna null
	 * 
	 */
	public JComboBox<String> getCombo_buscar() {
		return combo_buscar;
	}
	/**
	 * Este metodo establece el valor del JComboBox<String> <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param combo_buscar Este parametro representa el nuevo valor
	 *                 que va a tener el JComboBox<String>.!= ""
	 */
	public void setCombo_buscar(JComboBox<String> combo_buscar) {
		this.combo_buscar = combo_buscar;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return ver_parejas Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getver_parejas() {
		return ver_parejas;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param ver_parejas Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.
	 */
	public void setver_parejas(JButton ver_parejas) {
		this.ver_parejas = ver_parejas;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_orden_nombreu Este parametro representa 
	 * el  valor del JButton. si no hay retorna null
	 */
	public JButton getboton_orden_nombreu() {
		return boton_orden_nombreu;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_orden_nombreu Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_orden_nombreu(JButton boton_orden_nombreu) {
		this.boton_orden_nombreu = boton_orden_nombreu;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_orden_aliasu Este parametro representa el  valor del JButton. si no hay retorna null
	 * 
	 */
	
	public JButton getboton_orden_aliasu() {
		return boton_orden_aliasu;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_orden_aliasu Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_orden_aliasu(JButton boton_orden_aliasu) {
		this.boton_orden_aliasu = boton_orden_aliasu;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_orden_correou Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getboton_orden_correou() {
		return boton_orden_correou;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_orden_correou Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_orden_correou(JButton boton_orden_correou) {
		this.boton_orden_correou = boton_orden_correou;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_orden_nombrep Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getboton_orden_nombrep() {
		return boton_orden_nombrep;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_orden_nombrep Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_orden_nombrep(JButton boton_orden_nombrep) {
		this.boton_orden_nombrep = boton_orden_nombrep;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_buscar_usuario Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getboton_buscar_usuario() {
		return boton_buscar_usuario;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_buscar_usuario Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_buscar_usuario(JButton boton_buscar_usuario) {
		this.boton_buscar_usuario = boton_buscar_usuario;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_eliminar Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getBoton_eliminar() {
		return boton_eliminar;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_eliminar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_eliminar(JButton boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}
	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return campo_buscar Este parametro representa el  valor del JTextField. si no hay retorna null
	 */
	public JTextField getCampo_buscar() {
		return campo_buscar;
	}
	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param campo_buscar Este parametro representa el nuevo valor
	 *                 que va a tener el JTextField.!= ""
	 */
	public void setCampo_buscar(JTextField campo_buscar) {
		this.campo_buscar = campo_buscar;
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
	 *                 que va a tener el String.!= ""
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return imagen Este parametro representa el  valor del ImageIcon. si no hay retorna null
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor
	 *                 que va a tener el ImageIcon.!= ""
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return model1 Este parametro representa el  valor del DefaultTableModel. si no hay retorna null
	 */
	public DefaultTableModel getModel1() {
		return model1;
	}
	/**
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model1 Este parametro representa el nuevo valor
	 *                 que va a tener el DefaultTableModel.!= ""
	 */
	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}
	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return model2 Este parametro representa el  valor del DefaultTableModel. si no hay retorna null
	 */
	public DefaultTableModel getModel2() {
		return model2;
	}
	/**
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model2 Este parametro representa el nuevo valor
	 *                 que va a tener el DefaultTableModel.!= ""
	 */
	public void setModel2(DefaultTableModel model2) {
		this.model2 = model2;
	}
	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return tabla1 Este parametro representa el  valor del JTable. si no hay retorna null
	 */
	public JTable getTabla1() {
		return tabla1;
	}
	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param tabla1 Este parametro representa el nuevo valor
	 *                 que va a tener el JTable.!= ""
	 */
	public void setTabla1(JTable tabla1) {
		this.tabla1 = tabla1;
	}
	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return tabla2 Este parametro representa el  valor del JTable. si no hay retorna null
	 */
	public JTable getTabla2() {
		return tabla2;
	}
	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param tabla2 Este parametro representa el nuevo valor
	 *                 que va a tener el JTable.!= ""
	 */
	public void setTabla2(JTable tabla2) {
		this.tabla2 = tabla2;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_ver_usuarios Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getBoton_ver_usuarios() {
		return boton_ver_usuarios;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ver_usuarios Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_ver_usuarios(JButton boton_ver_usuarios) {
		this.boton_ver_usuarios = boton_ver_usuarios;
	}

}
