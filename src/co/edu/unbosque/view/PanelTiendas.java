package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PanelTiendas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo_tiendas;
	private String [][] datos= new String[1][3];
	private String[] cabecera =  {"Nombre","Horario apertura", "Horario cierre"};
	private JTextField campo_buscar, campo_nombre, campo_direccion;
	private ImageIcon imagen;
	private String nombre;
	private JButton boton_eliminar, boton_agregar_tienda;
	private JSpinner spinner, spinner_apertura, spinner_cierre;
	private JScrollPane scroll1;
	
	public PanelTiendas(String nombre) {
		this.nombre=nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
		
		
	}
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}
	
	public void inicializarComponentes() {
		combo_tiendas =new JComboBox<String>();
		combo_tiendas.addItem("Selecciona");
		combo_tiendas.addItem("Por horario de apertura");
		combo_tiendas.addItem("Por horario de cierre");
		combo_tiendas.addItem("Por nombre");
		combo_tiendas.setBounds(46,200,250,25);
		combo_tiendas.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(combo_tiendas);
		
		campo_buscar = new JTextField();
		campo_buscar.setBounds(350,200,180,25);
		campo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_buscar.setVisible(false);
		add(campo_buscar);
		
		boton_eliminar = new JButton("Eliminar");
		boton_eliminar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		boton_eliminar.setBounds(550,200,100,25);
		add(boton_eliminar);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel());
		spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));
		spinner.setBounds(350, 200, 150, 30);
		add(spinner);
		spinner.setVisible(false);
		
		JTable tabla = new JTable(datos,cabecera);
//		tabla.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		tabla = new JTable(datos,cabecera);
		tabla.setBackground(Color.LIGHT_GRAY);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
	
		tabla.setPreferredSize(new Dimension(700,120));
		scroll1 = new JScrollPane(tabla);
		scroll1.setViewportView(tabla);
		scroll1.setBounds(36,250,700,110);
		add(scroll1);
		
		
		campo_nombre =  new JTextField();
		campo_nombre.setBounds(36,450,200,25);
		campo_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_nombre);
		
		campo_direccion = new JTextField();
		campo_direccion.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_direccion.setBounds(36,500,200,25);
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
		boton_agregar_tienda.setBounds(590,470,100,30);
		boton_agregar_tienda.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_agregar_tienda);
		
	}
	public JComboBox<String> getCombo_tiendas() {
		return combo_tiendas;
	}
	public void setCombo_tiendas(JComboBox<String> combo_tiendas) {
		this.combo_tiendas = combo_tiendas;
	}
	public String[][] getDatos() {
		return datos;
	}
	public void setDatos(String[][] datos) {
		this.datos = datos;
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
	
	

}