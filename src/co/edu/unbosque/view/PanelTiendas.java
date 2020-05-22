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
	private JButton boton_eliminar, boton_agregar_tienda, boton_buscar,boton_buscar_pornombre,
			boton_ver_tiendas;
	private JSpinner spinner, spinner_apertura, spinner_cierre;
	private JScrollPane scroll1;

	private String[] cabecera = { "Nombre", "Dirección", "Horario apertura",
			"Horario cierre" };
	private DefaultTableModel model;
	private JTable tabla;

	public PanelTiendas(String nombre) {
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
		boton_ver_tiendas.setFont(new Font("Accidental Presidency", Font.BOLD,
				16));
		add(boton_ver_tiendas);
		
		boton_buscar_pornombre = new JButton("Buscar Tienda");
		boton_buscar_pornombre.setBounds(400, 150, 150, 30);
		boton_buscar_pornombre.setFont(new Font("Accidental Presidency", Font.BOLD,
				16));
		add(boton_buscar_pornombre);

		boton_eliminar = new JButton("Eliminar");
		boton_eliminar
				.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		boton_eliminar.setBounds(570, 200, 200, 25);
		add(boton_eliminar);

		// boton_buscar = new JButton("Buscar");
		// boton_buscar.setBounds(670,200,90,25);
		// boton_buscar.setFont(new Font("Accidental Presidency", Font.BOLD,
		// 16));
		// add(boton_buscar);

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
		campo_direccion
				.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_direccion.setBounds(36, 500, 200, 25);
		add(campo_direccion);

		spinner_apertura = new JSpinner();
		spinner_apertura.setModel(new SpinnerDateModel());
		spinner_apertura.setEditor(new JSpinner.DateEditor(spinner_apertura,
				"HH:mm"));
		spinner_apertura.setBounds(340, 470, 80, 30);
		add(spinner_apertura);

		spinner_cierre = new JSpinner();
		spinner_cierre.setModel(new SpinnerDateModel());
		spinner_cierre.setEditor(new JSpinner.DateEditor(spinner_cierre,
				"HH:mm"));
		spinner_cierre.setBounds(480, 470, 80, 30);
		add(spinner_cierre);

		boton_agregar_tienda = new JButton("Agregar");
		boton_agregar_tienda.setBounds(590, 470, 100, 30);
		boton_agregar_tienda.setFont(new Font("Accidental Presidency",
				Font.BOLD, 16));
		add(boton_agregar_tienda);

	}

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

	public JComboBox<String> getCombo_tiendas() {
		return combo_tiendas;
	}

	public void setCombo_tiendas(JComboBox<String> combo_tiendas) {
		this.combo_tiendas = combo_tiendas;
	}

	
	public JTextField getCampo_buscar() {
		return campo_buscar;
	}

	public void setCampo_buscar(JTextField campo_buscar) {
		this.campo_buscar = campo_buscar;
	}

	public JTextField getCampo_nombre() {
		return campo_nombre;
	}

	public void setCampo_nombre(JTextField campo_nombre) {
		this.campo_nombre = campo_nombre;
	}

	public JTextField getCampo_direccion() {
		return campo_direccion;
	}

	public void setCampo_direccion(JTextField campo_direccion) {
		this.campo_direccion = campo_direccion;
	}

	
	
	public JButton getboton_buscar_pornombre() {
		return boton_buscar_pornombre;
	}

	public void setboton_buscar_pornombre(JButton boton_buscar_pornombre) {
		this.boton_buscar_pornombre = boton_buscar_pornombre;
	}
	
	public JButton getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(JButton boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JSpinner getSpinner_apertura() {
		return spinner_apertura;
	}

	public void setSpinner_apertura(JSpinner spinner_apertura) {
		this.spinner_apertura = spinner_apertura;
	}

	public JSpinner getSpinner_cierre() {
		return spinner_cierre;
	}

	public void setSpinner_cierre(JSpinner spinner_cierre) {
		this.spinner_cierre = spinner_cierre;
	}

	public JButton getBoton_agregar_tienda() {
		return boton_agregar_tienda;
	}

	public void setBoton_agregar_tienda(JButton boton_agregar_tienda) {
		this.boton_agregar_tienda = boton_agregar_tienda;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JButton getBoton_buscar() {
		return boton_buscar;
	}

	public void setBoton_buscar(JButton boton_buscar) {
		this.boton_buscar = boton_buscar;
	}

	public JButton getBoton_ver_tiendas() {
		return boton_ver_tiendas;
	}

	public void setBoton_ver_tiendas(JButton boton_ver_tiendas) {
		this.boton_ver_tiendas = boton_ver_tiendas;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

}