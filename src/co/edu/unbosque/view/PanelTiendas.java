package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelTiendas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo_tiendas;
	private JTextField campo_buscar, campo_nombre, campo_direccion;
	private ImageIcon imagen;
	private String nombre;
	private JButton boton_eliminar, boton_agregar_tienda, boton_buscar, boton_buscar_pornombre, boton_ver_tiendas,
			boton_ordenar;
	private JSpinner spinner, spinner_apertura, spinner_cierre;
	private JScrollPane scroll1;

	private String[] cabecera = { "Nombre", "Dirección", "Horario apertura", "Horario cierre" };
	private DefaultTableModel model;
	private JTable tabla;

	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos asi como el método de crear tabla . De esta manera el objecto es creado
	 *  con un valor inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se hace visible el panel cuando es llamado por la ventana.<br>
	
	 * @param nombre se permite agregar un String al panel cuando es inicializado en ventana
	 * y esto sirve para agregar la imagen de fondo desde la carptea imagenes  != "".
	 */
	public PanelTiendas(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTabla();
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
	 * Este es el metodo inicializarComponente el cual se inicianilizan los componentes
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto del panel  que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {
		combo_tiendas = new JComboBox<String>();
		combo_tiendas.addItem("Selecciona");
		combo_tiendas.addItem("Por nombre");
		combo_tiendas.setBounds(46, 200, 250, 25);
		combo_tiendas.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(combo_tiendas);

		campo_buscar = new JTextField();
		campo_buscar.setBounds(330, 200, 180, 25);
		campo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_buscar.setVisible(true);
		add(campo_buscar);

		boton_ver_tiendas = new JButton("Ver tiendas");
		boton_ver_tiendas.setBounds(570, 150, 200, 30);
		boton_ver_tiendas.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_ver_tiendas);

		boton_ordenar = new JButton("Ordenar por Nombre");
		boton_ordenar.setBounds(570, 400, 200, 30);
		boton_ordenar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_ordenar);

		boton_buscar_pornombre = new JButton("Buscar Tienda");
		boton_buscar_pornombre.setBounds(400, 150, 150, 30);
		boton_buscar_pornombre.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_buscar_pornombre);

		boton_eliminar = new JButton("Eliminar");
		boton_eliminar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		boton_eliminar.setBounds(570, 200, 200, 25);
		add(boton_eliminar);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel());
		spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));
		spinner.setBounds(350, 200, 150, 30);
		add(spinner);
		spinner.setVisible(false);

		campo_nombre = new JTextField();
		campo_nombre.setBounds(36, 450, 200, 25);
		campo_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 16));

		add(campo_nombre);

		campo_direccion = new JTextField();
		campo_direccion.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_direccion.setBounds(36, 500, 200, 25);
		add(campo_direccion);

		spinner_apertura = new JSpinner();
		spinner_apertura.setModel(new SpinnerDateModel());
		spinner_apertura.setEditor(new JSpinner.DateEditor(spinner_apertura, "HH:mm"));
		spinner_apertura.setBounds(340, 470, 80, 30);
		add(spinner_apertura);

		spinner_cierre = new JSpinner();
		spinner_cierre.setModel(new SpinnerDateModel());
		spinner_cierre.setEditor(new JSpinner.DateEditor(spinner_cierre, "HH:mm"));
		spinner_cierre.setBounds(480, 470, 80, 30);
		add(spinner_cierre);

		boton_agregar_tienda = new JButton("Agregar");
		boton_agregar_tienda.setBounds(590, 470, 100, 30);
		boton_agregar_tienda.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_agregar_tienda);

	}
	/**
	 * Este es el metodo crearTable el cual se inicianilizan las tablas 
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto del panel   que lo contiene .
	 *  <b>post</b>Se crea a tabla en el panel<br>
	 */
	public void crearTabla() {

		tabla = new JTable();
		model = new DefaultTableModel(cabecera, 0);
		tabla = new JTable(model);
		tabla.setModel(model);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.setPreferredSize(new Dimension(700, 700));
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < cabecera.length; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(Alinear);
			TableColumnModel columnModel = tabla.getColumnModel();
			columnModel.getColumn(i).setPreferredWidth(200);

		}

		scroll1 = new JScrollPane(tabla);
		scroll1.setViewportView(tabla);
		scroll1.setBounds(43, 240, 700, 130);
		add(scroll1);
	}

	/**
	 * Este metodo devuelve el valor del JComboBox<String>. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return combo_tiendas Este parametro representa el  valor del JComboBox<String>. si no hay retorna null
	 */
	public JComboBox<String> getCombo_tiendas() {
		return combo_tiendas;
	}
	/**
	 * Este metodo establece el valor del JComboBox<String> <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param combo_tiendas Este parametro representa el nuevo valor
	 *                 que va a tener el JComboBox<String>.!= ""
	 */
	public void setCombo_tiendas(JComboBox<String> combo_tiendas) {
		this.combo_tiendas = combo_tiendas;
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
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return campo_nombre Este parametro representa el  valor del JTextField. si no hay retorna null
	 */
	public JTextField getCampo_nombre() {
		return campo_nombre;
	}
	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param campo_nombre Este parametro representa el nuevo valor
	 *                 que va a tener el JTextField.!= ""
	 */
	public void setCampo_nombre(JTextField campo_nombre) {
		this.campo_nombre = campo_nombre;
	}
	/**
	 * Este metodo devuelve el valor del JTextField. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return campo_direccion Este parametro representa el  valor del JTextField. si no hay retorna null
	 */
	public JTextField getCampo_direccion() {
		return campo_direccion;
	}
	/**
	 * Este metodo establece el valor del JTextField <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param campo_direccioncampo_direccion Este parametro representa el nuevo valor
	 *                 que va a tener el JTextField.!= ""
	 */
	public void setCampo_direccion(JTextField campo_direccion) {
		this.campo_direccion = campo_direccion;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_buscar_pornombre Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getboton_buscar_pornombre() {
		return boton_buscar_pornombre;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_buscar_pornombre Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setboton_buscar_pornombre(JButton boton_buscar_pornombre) {
		this.boton_buscar_pornombre = boton_buscar_pornombre;
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
	 * Este metodo devuelve el valor del JSpinner. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return spinner Este parametro representa el  valor del JSpinner. si no hay retorna null
	 */
	public JSpinner getSpinner() {
		return spinner;
	}
	/**
	 * Este metodo establece el valor del JSpinner <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param spinner Este parametro representa el nuevo valor
	 *                 que va a tener el JSpinner.!= ""
	 */
	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
	/**
	 * Este metodo devuelve el valor del JSpinner. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return spinner_apertura Este parametro representa el  valor del JSpinner. si no hay retorna null
	 */
	public JSpinner getSpinner_apertura() {
		return spinner_apertura;
	}
	/**
	 * Este metodo establece el valor del JSpinner <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param spinner_apertura Este parametro representa el nuevo valor
	 *                 que va a tener el JSpinner.!= ""
	 */
	public void setSpinner_apertura(JSpinner spinner_apertura) {
		this.spinner_apertura = spinner_apertura;
	}
	/**
	 * Este metodo devuelve el valor del JSpinner. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return spinner_cierre Este parametro representa el  valor del JSpinner. si no hay retorna null
	 */
	public JSpinner getSpinner_cierre() {
		return spinner_cierre;
	}
	/**
	 * Este metodo establece el valor del JSpinner <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param spinner_cierre Este parametro representa el nuevo valor
	 *                 que va a tener el JSpinner.!= ""
	 */
	public void setSpinner_cierre(JSpinner spinner_cierre) {
		this.spinner_cierre = spinner_cierre;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_agregar_tienda Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getBoton_agregar_tienda() {
		return boton_agregar_tienda;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_tienda Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_agregar_tienda(JButton boton_agregar_tienda) {
		this.boton_agregar_tienda = boton_agregar_tienda;
	}
	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return model Este parametro representa el  valor del DefaultTableModel. si no hay retorna null
	 */
	public DefaultTableModel getModel() {
		return model;
	}
	/**
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model Este parametro representa el nuevo valor
	 *                 que va a tener el DefaultTableModel.!= ""
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_buscar Este parametro representa el  valor del JButton. si no hay retorna null
	 */
	public JButton getBoton_buscar() {
		return boton_buscar;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_buscar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_buscar(JButton boton_buscar) {
		this.boton_buscar = boton_buscar;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_ver_tiendas Este parametro representa el  valor del JButton si no hay retorna null
	 */
	public JButton getBoton_ver_tiendas() {
		return boton_ver_tiendas;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ver_tiendas Este parametro representa el nuevo JButton
	 *                 que va a tener el String.!= ""
	 */
	public void setBoton_ver_tiendas(JButton boton_ver_tiendas) {
		this.boton_ver_tiendas = boton_ver_tiendas;
	}
	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return tabla Este parametro representa el  valor del JTable. si no hay retorna null
	 */
	public JTable getTabla() {
		return tabla;
	}
	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param tabla Este parametro representa el nuevo valor
	 *                 que va a tener el JTable.!= ""
	 */
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_buscar_pornombre Este parametro representa el  valor del JButton si no hay retorna null
	 */
	public JButton getBoton_buscar_pornombre() {
		return boton_buscar_pornombre;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_buscar_pornombre Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_buscar_pornombre(JButton boton_buscar_pornombre) {
		this.boton_buscar_pornombre = boton_buscar_pornombre;
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
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_ordenar Este parametro representa el  valor del JButton si no hay retorna null
	 * */
	public JButton getBoton_ordenar() {
		return boton_ordenar;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ordenar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_ordenar(JButton boton_ordenar) {
		this.boton_ordenar = boton_ordenar;
	}
	/**
	 * Este metodo devuelve el valor del JScrollPane. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return scroll1 Este parametro representa el  valor del JScrollPane. si no hay retorna null
	 */
	public JScrollPane getScroll1() {
		return scroll1;
	}
	/**
	 * Este metodo establece el valor del JScrollPane <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param scroll1 Este parametro representa el nuevo valor
	 *                 que va a tener el JScrollPane.!= ""
	 */
	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}
	/**
	 * Este metodo devuelve el valor del String[]. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return cabecera Este parametro representa el  valor del String[]. si no hay retorna null
	 */
	public String[] getCabecera() {
		return cabecera;
	}
	/**
	 * Este metodo establece el valor del String[] <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param cabecera Este parametro representa el nuevo valor
	 *                 que va a tener el String[].!= ""
	 */
	public void setCabecera(String[] cabecera) {
		this.cabecera = cabecera;
	}


}