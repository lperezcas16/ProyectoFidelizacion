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

public class PanelVerInfoPareja extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_boton_regresar;
	private Icon icono_boton_regresar;
	private JButton boton_regresar;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String[] nombre_columnas = { "Nombre o Alias", "Porcentaje del Cupo" };

	public PanelVerInfoPareja(String nombre) {
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

		boton_regresar = new JButton();
		boton_regresar.setBounds(600, 480, 150, 30);
		add(boton_regresar);

		imagen_boton_regresar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_regresar.png"));
		icono_boton_regresar = new ImageIcon(
				imagen_boton_regresar.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH));
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

		scroll = new JScrollPane(table);
		scroll.setViewportView(table);
		scroll.setBounds(43, 150, 700, 300);
		add(scroll);
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Icon getIcono_boton_regresar() {
		return icono_boton_regresar;
	}

	public void setIcono_boton_regresar(Icon icono_boton_regresar) {
		this.icono_boton_regresar = icono_boton_regresar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public String[] getNombre_columnas() {
		return nombre_columnas;
	}

	public void setNombre_columnas(String[] nombre_columnas) {
		this.nombre_columnas = nombre_columnas;
	}

}
