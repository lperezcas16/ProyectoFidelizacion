package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class PanelUsuarios extends JPanel{
	
	private JComboBox<String> combo_buscar;
	private JButton boton_as_op1, boton_des_op1, boton_as_op2, boton_des_op2, boton_eliminar;
	private JTextField campo_buscar;
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1,scroll2 ;
	private String[][] datos = new String[1][5];
	private String[][] datos2 = new String[1][2];
	private String [] cabecera= {"Nombre","Alias", "Correo","Genero", "Numero de Tarjeta"};
	private String [] cabecera2= {"Nombre", "Porcentaje de cupo"};
	
	public PanelUsuarios(String nombre) {
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
	
	public void inicializarComponentes(){
		
		combo_buscar = new JComboBox<String>();
		combo_buscar.addItem("Nombre");
		combo_buscar.addItem("Correo");
		combo_buscar.addItem("Alias");
		combo_buscar.addItem("Número de tarjeta");
		combo_buscar.setBounds(36,150,150,25);
		combo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(combo_buscar);
		
		campo_buscar = new JTextField();
		campo_buscar.setBounds(200,150,250,25);
		campo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_buscar);
		
		boton_eliminar = new JButton("Eliminar usuario");
		boton_eliminar.setBounds(500,150,250,25);
		boton_eliminar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_eliminar);
		
		JTable tabla = new JTable(datos,cabecera);
//		tabla.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		tabla = new JTable(datos,cabecera);
		tabla.setBackground(Color.LIGHT_GRAY);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
		tabla.setPreferredSize(new Dimension(700,50));
		scroll1 = new JScrollPane(tabla);
		scroll1.setViewportView(tabla);
		scroll1.setBounds(36,200,700,70);
		add(scroll1);
		
		JTable tabla2 = new JTable(datos2,cabecera2);
		tabla2 = new JTable(datos2,cabecera2);
		tabla2.setBackground(Color.LIGHT_GRAY);
		tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla2.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla2.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		tabla2.setPreferredSize(new Dimension(700,50));
		scroll2 = new JScrollPane(tabla2);
		scroll2.setViewportView(tabla2);
		scroll2.setBounds(36,320,700,100);
		add(scroll2);
		
		
		
		
		
	}
	
	

}
