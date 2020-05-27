package co.edu.unbosque.view;

import java.awt.Color;
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

public class PanelVerInfoPareja extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton_regresar;
	private Icon icono_boton_regresar;
	private JButton boton_regresar;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String[] nombre_columnas = { "Nombre o Alias", "Edad", "Porcentaje del Cupo",
			"Monto asignado" , "Monto restante"};

	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos asi como el método de crear tabla . De esta manera el objecto es creado
	 *  con un valor inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se hace visible el panel cuando es llamado por la ventana.<br>
	
	 * @param nombre se permite agregar un String al panel cuando es inicializado en ventana
	 * y esto sirve para agregar la imagen de fondo desde la carptea imagenes  != "".
	 */
	public PanelVerInfoPareja(String nombre) {
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

		boton_regresar = new JButton();
		boton_regresar.setBounds(596, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(
				imagen_boton_regresar.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH));
	}
/**
 * Este es el metodo crearTable el cual se inicianilizan las tablas 
 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
 *   y se agrega el panel 
 *  Este método se llama automaticamente cuando se crea el objeto del panel   que lo contiene .
 * 
 */
	public void crearTabla() {

		table = new JTable();
		model = new DefaultTableModel(nombre_columnas, 0);
		table = new JTable(model);
		table.setModel(model);

		Color color_azul = new Color(36, 67, 87);
		table.setForeground(color_azul);

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
		scroll.setBounds(43, 150, 700, 300);
		add(scroll);
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
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return boton_regresar Este parametro representa el  
	 * 				valor del JButton. si no hay retorna null
	 */
	public JButton getBoton_regresar() {
		return boton_regresar;
	}
	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el JButton.!= ""
	 */
	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del ImageIcon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return c_usuario_inicio Este parametro representa el  valor del JTextField. si no hay retorna null
	 */
	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del imagen_boton_regresar <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param imagen_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener elimagen_boton_regresar.!= ""
	 */

	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del Icon. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return c_usuario_inicio Este parametro representa 
	 * el  valor del Icon. si no hay retorna null
	 */
	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}
	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param icono_boton_regresar Este parametro representa el nuevo valor
	 *                 que va a tener el Icon. != ""
	 */
	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}
	/**
	 * Este metodo devuelve el valor del table. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return table Este parametro representa el  valor del table. si no hay retorna null
	 */
	public JTable getTable() {
		return table;
	}
	/**
	 * Este metodo establece el valor del table <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param table Este parametro representa el nuevo valor
	 *                 que va a tener el table.!= ""
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	/**
	 * Este metodo devuelve el valor del scroll. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return scroll Este parametro representa el  valor del scroll. si no hay retorna null
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * Este metodo establece el valor del scroll <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param scroll Este parametro representa el nuevo valor que va a tener el
	 *               scroll.!= ""
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
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
	 * Este metodo establece el valor del model <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model Este parametro representa el nuevo valor
	 *                 que va a tener el model.!= ""
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	/**
	 * Este metodo devuelve el valor del String[]. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return nombre_columnas Este parametro representa el  valor del String[] si no hay retorna null
	 */
	public String[] getNombre_columnas() {
		return nombre_columnas;
	}
	/**
	 * Este metodo establece el valor del c_usuario_inicio <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre_columnas Este parametro representa el nuevo valor
	 *                 que va a tener el nombre_columnas de inicio.!= ""
	 */
	public void setNombre_columnas(String[] nombre_columnas) {
		this.nombre_columnas = nombre_columnas;
	}

}
