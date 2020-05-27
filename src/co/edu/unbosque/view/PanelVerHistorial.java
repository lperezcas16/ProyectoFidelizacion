package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelVerHistorial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String[] nombre_columnas = { "Pareja", "Tienda",
			"Valor de compra"};
	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param nombre  se agregar una imagen al fondo del panel con las respectivas propiedades != ""
	 */
	public PanelVerHistorial() {
		Color color_azul = new Color(36, 67, 87);
		setLayout(null);
		setBackground(color_azul);
		inicializarComponentes();
		setVisible(false);
	}
	/**
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los componentes
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto de la ventana  que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {

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

		// table.setFont(new Font("Accidental Presidency", Font.BOLD, 12));

		scroll = new JScrollPane(table);
		scroll.setViewportView(table);
		scroll.setBounds(43, 30, 700, 270);
		add(scroll);
	}
	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return table Este parametro representa el  valor del JTable si no hay retorna null
	 */
	public JTable getTable() {
		return table;
	}
	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param table Este parametro representa el nuevo valor
	 *                 que va a tener la tabla.!= ""
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	/**
	 * Este metodo devuelve el valor del JScrollPane. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return scroll Este parametro representa el  valor del JScrollPane. si no hay retorna null
	 */
	public JScrollPane getScroll() {
		return scroll;
	}
	/**
	 * Este metodo establece el valor del JScrollPane <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param scroll Este parametro representa el nuevo valor
	 *                 que va a tener el scroll.!= ""
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
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param model Este parametro representa el nuevo valor
	 *                 que va a tener el model.!= ""
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	/**
	 * Este es el metodo visibilidadComponentes el cual se dejan todos los
	 *  campos vacios en el panel1 cuando es llamado 
	 * objeto.<b>post</b> quedan vacios los campos del panel .<br>
	 * 
	 * @param b se le pasa un booleano para que se
	 * an visibles las tablas o no != ""
	 */

	public void visibilidadComponentes(boolean b) {
		table.setVisible(b);
		scroll.setVisible(b);
	}

}
