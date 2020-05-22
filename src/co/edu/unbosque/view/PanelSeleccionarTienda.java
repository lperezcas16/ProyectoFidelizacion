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

	public PanelSeleccionarTienda(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTabla();

		setVisible(false);
	}

	public void paint(Graphics g) {

		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);
	}

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

		// table.setFont(new Font("Accidental Presidency", Font.BOLD, 12));

		scroll = new JScrollPane(table);
		scroll.setViewportView(table);
		scroll.setBounds(43, 150, 700, 170);
		add(scroll);
	}

	public JButton getBoton_agregar_tienda() {
		return boton_agregar_tienda;
	}

	public void setBoton_agregar_tienda(JButton boton_agregar_tienda) {
		this.boton_agregar_tienda = boton_agregar_tienda;
	}

	public JButton getBoton_agregar_nueva_tienda() {
		return boton_agregar_nueva_tienda;
	}

	public void setBoton_agregar_nueva_tienda(JButton boton_agregar_nueva_tienda) {
		this.boton_agregar_nueva_tienda = boton_agregar_nueva_tienda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String[] getNombre_columnas() {
		return nombre_columnas;
	}

	public void setNombre_columnas(String[] nombre_columnas) {
		this.nombre_columnas = nombre_columnas;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public ImageIcon getImagen_boton_tienda() {
		return imagen_boton_tienda;
	}

	public void setImagen_boton_tienda(ImageIcon imagen_boton_tienda) {
		this.imagen_boton_tienda = imagen_boton_tienda;
	}

	public ImageIcon getImagen_boton_nueva() {
		return imagen_boton_nueva;
	}

	public void setImagen_boton_nueva(ImageIcon imagen_boton_nueva) {
		this.imagen_boton_nueva = imagen_boton_nueva;
	}

	public Icon getIcon_boton_tienda() {
		return icon_boton_tienda;
	}

	public void setIcon_boton_tienda(Icon icon_boton_tienda) {
		this.icon_boton_tienda = icon_boton_tienda;
	}

	public Icon getIcon_boton_nueva() {
		return icon_boton_nueva;
	}

	public void setIcon_boton_nueva(Icon icon_boton_nueva) {
		this.icon_boton_nueva = icon_boton_nueva;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public PanelNuevaTienda getPnl_nueva_tienda() {
		return pnl_nueva_tienda;
	}

	public void setPnl_nueva_tienda(PanelNuevaTienda pnl_nueva_tienda) {
		this.pnl_nueva_tienda = pnl_nueva_tienda;
	}

	public JButton getBoton_regresar() {
		return boton_regresar;
	}

	public void setBoton_regresar(JButton boton_regresar) {
		this.boton_regresar = boton_regresar;
	}

	public ImageIcon getImagen_boton_regresar() {
		return imagen_boton_regresar;
	}

	public void setImagen_boton_regresar(ImageIcon imagen_boton_regresar) {
		this.imagen_boton_regresar = imagen_boton_regresar;
	}

	public Icon getIcon_boton_regresar() {
		return icon_boton_regresar;
	}

	public void setIcon_boton_regresar(Icon icon_boton_regresar) {
		this.icon_boton_regresar = icon_boton_regresar;
	}

	public void visibilidadComponentes(boolean b) {
		table.setVisible(b);
		boton_agregar_nueva_tienda.setVisible(b);
		boton_agregar_tienda.setVisible(b);
		scroll.setVisible(b);
	}

}
