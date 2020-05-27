package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelInformeUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model1, model2;
	private JTable tabla1, tabla2;
	private JLabel etiqueta_usuario, etiqueta_tienda;
	private String[] cabecera1 = { "Nombre", "Alias", "Correo", "Edad", "Genero", "Numero de Tarjeta", "Cupo" };
	private String[] cabecera2 = { "Nombre", "Dirección", "Horario apertura", "Horario cierre" };
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1, scroll2;;
	private JButton boton_imprimir, boton_cancelar;
	private ImageIcon imagen_imprimir;
	private Icon icono_imprimir;

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
	public PanelInformeUsuario(String nombre) {

		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTablas();
		setVisible(false);
		setBounds(0, 0, 900, 650);
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

		etiqueta_usuario = new JLabel("Usuarios");
		etiqueta_usuario.setBackground(Color.green);
		etiqueta_usuario.setBounds(36, 100, 130, 100);
		etiqueta_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		etiqueta_usuario.setVisible(false);
		add(etiqueta_usuario);

		etiqueta_tienda = new JLabel("Tiendas");
		etiqueta_tienda.setBackground(Color.green);
		etiqueta_tienda.setBounds(36, 100, 130, 100);
		etiqueta_tienda.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		etiqueta_tienda.setVisible(false);
		add(etiqueta_tienda);

		boton_imprimir = new JButton();
		boton_imprimir.setBounds(400, 500, 50, 50);
		imagen_imprimir = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_imprimir.png"));
		icono_imprimir = new ImageIcon(imagen_imprimir.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		boton_imprimir.setHorizontalAlignment(SwingConstants.CENTER);
		boton_imprimir.setVerticalAlignment(SwingConstants.CENTER);
		boton_imprimir.setContentAreaFilled(false);
		boton_imprimir.setBorderPainted(false);
		boton_imprimir.setIcon(icono_imprimir);
		add(boton_imprimir);

	}

	/**
	 * Este es el metodo crearTablas el cual se inicianilizan las tablas De esta
	 * manera cada componente se crea con una ubicacion, u se le agregar una imagen
	 * si es el caso y se agrega el panel Este método se llama automaticamente
	 * cuando se crea el objeto del panel que lo contiene .
	 * 
	 */
	public void crearTablas() {
		tabla1 = new JTable();
		model1 = new DefaultTableModel(cabecera1, 0);
		tabla1 = new JTable(model1);
		tabla1.setModel(model1);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla1.setPreferredSize(new Dimension(780, 296));
		tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < cabecera1.length; i++) {
			tabla1.getColumnModel().getColumn(i).setCellRenderer(Alinear);
			TableColumnModel columnModel = tabla1.getColumnModel();
			columnModel.getColumn(i).setPreferredWidth(200);

			// ///////////////////////////////////////////////////////////
			tabla2 = new JTable();
			model2 = new DefaultTableModel(cabecera2, 0);
			tabla2 = new JTable(model2);
			tabla2.setModel(model2);

			DefaultTableCellRenderer Alinear2 = new DefaultTableCellRenderer();
			Alinear2.setHorizontalAlignment(SwingConstants.CENTER);
			tabla2.setPreferredSize(new Dimension(780, 296));
			tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			for (int j = 0; j < cabecera2.length; j++) {
				tabla2.getColumnModel().getColumn(j).setCellRenderer(Alinear2);
				TableColumnModel columnModel2 = tabla2.getColumnModel();
				columnModel2.getColumn(j).setPreferredWidth(200);
			}

		}

		scroll2 = new JScrollPane(tabla2);
		scroll2.setViewportView(tabla2);
		scroll2.setBounds(36, 200, 800, 300);
		scroll2.setVisible(false);
		add(scroll2);

		scroll1 = new JScrollPane(tabla1);
		scroll1.setViewportView(tabla1);
		scroll1.setBounds(36, 200, 800, 300);
		scroll1.setVisible(false);
		add(scroll1);

	}

	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato DefaultTableModel.
	 */
	public DefaultTableModel getModel1() {
		return model1;
	}

	/**
	 * Este metodo devuelve el valor del JScrollPane. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JScrollPane.
	 */
	public JScrollPane getScroll1() {
		return scroll1;
	}

	/**
	 * Este metodo establece el valor del JScrollPane <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param scroll1 Este parametro representa el nuevo valor que va a tener el
	 *                JScrollPane != "".
	 */
	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}

	/**
	 * Este metodo devuelve el valor del JScrollPane. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JScrollPane.
	 */
	public JScrollPane getScroll2() {
		return scroll2;
	}

	/**
	 * Este metodo establece el valor del JScrollPane <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param scroll2 Este parametro representa el nuevo valor que va a tener el
	 *                JScrollPane != "".
	 */
	public void setScroll2(JScrollPane scroll2) {
		this.scroll2 = scroll2;
	}

	/**
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param model1 Este parametro representa el nuevo valor que va a tener el
	 *               DefaultTableModel != "".
	 */
	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}

	/**
	 * Este metodo devuelve el valor del DefaultTableModel. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato DefaultTableModel.
	 */
	public DefaultTableModel getModel2() {
		return model2;
	}

	/**
	 * Este metodo establece el valor del DefaultTableModel <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param model2 Este parametro representa el nuevo valor que va a tener el
	 *               DefaultTableModel != "".
	 */
	public void setModel2(DefaultTableModel model2) {
		this.model2 = model2;
	}

	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JTable.
	 */
	public JTable getTabla1() {
		return tabla1;
	}

	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param tabla1 Este parametro representa el nuevo valor que va a tener el
	 *               JTable != "".
	 */
	public void setTabla1(JTable tabla1) {
		this.tabla1 = tabla1;
	}

	/**
	 * Este metodo devuelve el valor del JTable. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JTable.
	 */
	public JTable getTabla2() {
		return tabla2;
	}

	/**
	 * Este metodo establece el valor del JTable <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param tabla2 Este parametro representa el nuevo valor que va a tener el
	 *               JTable != "".
	 */
	public void setTabla2(JTable tabla2) {
		this.tabla2 = tabla2;
	}

	/**
	 * Este metodo devuelve el valor del JLabel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JLabel.
	 */
	public JLabel getEtiqueta_tienda() {
		return etiqueta_tienda;
	}

	/**
	 * Este metodo establece el valor del JLabel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param etiqueta_tienda Este parametro representa el nuevo valor que va a
	 *                        tener el JLabel != "".
	 */
	public void setEtiqueta_tienda(JLabel etiqueta_tienda) {
		this.etiqueta_tienda = etiqueta_tienda;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_imprimir() {
		return boton_imprimir;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_imprimir Este parametro representa el nuevo valor que va a tener
	 *                       el JButton != "".
	 */
	public void setBoton_imprimir(JButton boton_imprimir) {
		this.boton_imprimir = boton_imprimir;
	}

	/**
	 * Este metodo devuelve el valor del JButton. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_cancelar() {
		return boton_cancelar;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_cancelar Este parametro representa el nuevo valor que va a tener
	 *                       el JButton != "".
	 */
	public void setBoton_cancelar(JButton boton_cancelar) {
		this.boton_cancelar = boton_cancelar;
	}

	/**
	 * Este metodo devuelve el valor del JLabel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JLabel.
	 */
	public JLabel getEtiqueta_usuario() {
		return etiqueta_usuario;
	}

	/**
	 * Este metodo establece el valor del JLabel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param etiqueta_usuario Este parametro representa el nuevo valor que va a
	 *                         tener el JLabel != "".
	 */
	public void setEtiqueta_usuario(JLabel etiqueta_usuario) {
		this.etiqueta_usuario = etiqueta_usuario;
	}

}
