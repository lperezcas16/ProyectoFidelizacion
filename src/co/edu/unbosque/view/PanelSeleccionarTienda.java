package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelSeleccionarTienda extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton boton_agregar_tienda, boton_agregar_nueva_tienda,
			boton_regresar;
	private String nombre;
	private ImageIcon imagen, imagen_boton_tienda, imagen_boton_nueva,
			imagen_boton_regresar;
	private Icon icon_boton_tienda, icon_boton_nueva, icon_boton_regresar;
	private JTable table;
	private String[] nombre_columnas = { "Nombre", "Direccion",
			"Horario de Apertura", "Horario de Cierre" };
	private JScrollPane scroll;
	private DefaultTableModel model;

	private PanelNuevaTienda pnl_nueva_tienda;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectosy . De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel con las respectivas propiedades != "".
	 */
	public PanelSeleccionarTienda(String nombre) {
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
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los componentes
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto de la ventana  que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {

		boton_agregar_tienda = new JButton();
		boton_agregar_tienda.setBounds(105, 390, 250, 30);
		boton_agregar_tienda.setEnabled(false);
		add(boton_agregar_tienda);

		imagen_boton_tienda = new ImageIcon(getClass().getResource(
				"/co/edu/unbosque/imagenes/boton_confirmar_seleccion.png"));
		icon_boton_tienda = new ImageIcon(imagen_boton_tienda.getImage()
				.getScaledInstance(250, 30, Image.SCALE_SMOOTH));

		boton_agregar_nueva_tienda = new JButton();
		boton_agregar_nueva_tienda.setBounds(450, 390, 250, 30);
		add(boton_agregar_nueva_tienda);

		imagen_boton_nueva = new ImageIcon(getClass().getResource(
				"/co/edu/unbosque/imagenes/boton_agregar_nueva_tienda.png"));
		icon_boton_nueva = new ImageIcon(imagen_boton_nueva.getImage()
				.getScaledInstance(250, 30, Image.SCALE_SMOOTH));

		pnl_nueva_tienda = new PanelNuevaTienda(
				"/co/edu/unbosque/imagenes/fondo_nueva_tienda.png");
		pnl_nueva_tienda.setBounds(0, 0, 795, 572);
		add(pnl_nueva_tienda);

		pnl_nueva_tienda.getBoton_validar_nueva_tienda().setIcon(
				pnl_nueva_tienda.getIcono_boton_añadir());
		pnl_nueva_tienda.getBoton_regresar().setIcon(
				pnl_nueva_tienda.getIcono_boton_regresar());

		boton_regresar = new JButton();
		boton_regresar.setBounds(596, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource(
				"/co/edu/unbosque/imagenes/boton_regresar.png"));
		icon_boton_regresar = new ImageIcon(imagen_boton_regresar.getImage()
				.getScaledInstance(200, 30, Image.SCALE_SMOOTH));
	}
	/**
	 * Este es el metodo crearTabla el cual se dejan todos los
	 *  campos vacios en el panel1 cuando es llamado 
	 * objeto.<b>post</b> Las tablas con creadas en el panel.<br>
	 */
	public void crearTabla() {

		table = new JTable();
		model = new DefaultTableModel(nombre_columnas, 0);
		table = new JTable(model);
		table.setModel(model);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		table.setPreferredSize(new Dimension(700, 200));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < nombre_columnas.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(Alinear);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(i).setPreferredWidth(200);

		}

		scroll = new JScrollPane(table);
		scroll.setViewportView(table);
		scroll.setBounds(43, 150, 700, 170);
		add(scroll);
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_tienda Este parametro representa el  valor del JButton.!=""
	 */
	public JButton getBoton_agregar_tienda() {
		return boton_agregar_tienda;
	}
	/**
	 * Este metodo establece el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_tienda Este parametro representa el nuevo valor 
	 * 				que va a tener el JButton. != "".
	 */
	public void setBoton_agregar_tienda(JButton boton_agregar_tienda) {
		this.boton_agregar_tienda = boton_agregar_tienda;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_nueva_tienda Este parametro representa el  valor del JButton.!=""
	 */
	public JButton getBoton_agregar_nueva_tienda() {
		return boton_agregar_nueva_tienda;
	}
	/**
	 * Este metodo establece el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_nueva_tienda Este parametro representa el nuevo valor 
	 * 				que va a tener el JButton. != "".
	 */
	public void setBoton_agregar_nueva_tienda(JButton boton_agregar_nueva_tienda) {
		this.boton_agregar_nueva_tienda = boton_agregar_nueva_tienda;
	}
	/**
	 * Este metodo devuelve el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el  valor del String.!=""
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Este metodo establece el valor del String. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor 
	 * 				que va a tener el String. != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el  valor del ImageIcon !="".
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	/**
	 * Este metodo establece el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor 
	 * 				que va a tener el ImageIcon. != "".
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param table Este parametro representa el  valor del JTable.!=""
	 */
	public JTable getTable() {
		return table;
	}
	/**
	 * Este metodo establece el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param table Este parametro representa el nuevo valor 
	 * 				que va a tener el JTable. != "".
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	/**
	 * Este metodo devuelve el valor del String[]. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre_columnas Este parametro representa el  valor del String[].!=""
	 */
	public String[] getNombre_columnas() {
		return nombre_columnas;
	}
	/**
	 * Este metodo establece el valor del String[]. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre_columnas Este parametro representa el nuevo valor 
	 * 				que va a tener el String[]. != "".
	 */
	public void setNombre_columnas(String[] nombre_columnas) {
		this.nombre_columnas = nombre_columnas;
	}
	/**
	 * Este metodo devuelve el valor del JScrollPane. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param scroll Este parametro representa el  valor del JScrollPane!="".
	 */
	public JScrollPane getScroll() {
		return scroll;
	}
	/**
	 * Este metodo establece el valor del JScrollPane. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param scroll Este parametro representa el nuevo valor 
	 * 				que va a tener el JScrollPane. != "".
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_tienda Este parametro representa el  valor del ImageIcon.
	 */
	public ImageIcon getImagen_boton_tienda() {
		return imagen_boton_tienda;
	}
	/**
	 * Este metodo establece el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_tienda Este parametro representa el nuevo valor 
	 * 				que va a tener el ImageIcon. != "".
	 */
	public void setImagen_boton_tienda(ImageIcon imagen_boton_tienda) {
		this.imagen_boton_tienda = imagen_boton_tienda;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_nueva Este parametro representa el  valor del ImageIcon.
	 */
	public ImageIcon getImagen_boton_nueva() {
		return imagen_boton_nueva;
	}
	/**
	 * Este metodo establece el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_nueva Este parametro representa el nuevo valor 
	 * 				que va a tener el ImageIcon. != "".
	 */
	public void setImagen_boton_nueva(ImageIcon imagen_boton_nueva) {
		this.imagen_boton_nueva = imagen_boton_nueva;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_tienda Este parametro representa el  valor del Icon!="".
	 */
	public Icon getIcon_boton_tienda() {
		return icon_boton_tienda;
	}
	/**
	 * Este metodo establece el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_tienda Este parametro representa el nuevo valor 
	 * 				que va a tener el Icon. != "".
	 */
	public void setIcon_boton_tienda(Icon icon_boton_tienda) {
		this.icon_boton_tienda = icon_boton_tienda;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_nueva Este parametro representa el  valor del Icon.
	 */
	public Icon getIcon_boton_nueva() {
		return icon_boton_nueva;
	}
	/**
	 * Este metodo establece el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_nueva Este parametro representa el nuevo valor 
	 * 				que va a tener el Icon. != "".
	 */
	public void setIcon_boton_nueva(Icon icon_boton_nueva) {
		this.icon_boton_nueva = icon_boton_nueva;
	}
	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model Este parametro representa el  valor del DefaultTableModel.
	 */
	public DefaultTableModel getModel() {
		return model;
	}
	/**
	 * Este metodo establece el valor del DefaultTableModel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model Este parametro representa el nuevo valor 
	 * 				que va a tener el DefaultTableModel. != "".
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	/**
	 * Este metodo devuelve el valor del PanelNuevaTienda. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_nueva_tienda Este parametro representa el  valor del PanelNuevaTienda !="".
	 */
	public PanelNuevaTienda getPnl_nueva_tienda() {
		return pnl_nueva_tienda;
	}
	/**
	 * Este metodo establece el valor del PanelNuevaTienda. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param pnl_nueva_tienda Este parametro representa el nuevo valor 
	 * 				que va a tener el PanelNuevaTienda. != "".
	 */
	public void setPnl_nueva_tienda(PanelNuevaTienda pnl_nueva_tienda) {
		this.pnl_nueva_tienda = pnl_nueva_tienda;
	}
	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el  valor del JButton!="".
	 */
	public JButton getBoton_regresar() {
		return boton_regresar;
	}
	/**
	 * Este metodo establece el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el nuevo valor 
	 * 				que va a tener el JButton. != "".
	 */
	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el  valor del ImageIcon !="".
	 */

	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el nuevo valor 
	 * 				que va a tener el ImageIcon. != "".
	 */
	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_regresar Este parametro representa el  valor del Icon.!=""
	 */
	public Icon getIcon_boton_regresar() {
		return icon_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icon_boton_regresar Este parametro representa el nuevo valor 
	 * 				que va a tener el Icon. != "".
	 */
	public void setIcon_boton_regresar(Icon icon_boton_regresar) {
		this.icon_boton_regresar = icon_boton_regresar;
	}
	/**
	 * Este es el metodo visibilidadComponentes el cual permite que se vean
	 * o no los componentes seleccionados
	 * o.<b>post</b>componentes agregados al panel.<br>
	 * @param b es un booleana que informa cuando se ve los componentes y cuando no 
	 */

	public void visibilidadComponentes(boolean b) {
		table.setVisible(b);
		boton_agregar_nueva_tienda.setVisible(b);
		boton_agregar_tienda.setVisible(b);
		scroll.setVisible(b);
	}

}
