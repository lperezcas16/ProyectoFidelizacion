package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo_buscar;
	private JButton boton_as_op1, boton_des_op1, boton_as_op2, boton_des_op2,
			boton_eliminar, boton_ver_usuarios;
	private JTextField campo_buscar;
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1, scroll2;

	private DefaultTableModel model1, model2;
	private JTable tabla1, tabla2;

	private String[] cabecera1 = { "Nombre", "Alias", "Correo", "Genero",
			"Numero de Tarjeta" };
	private String[] cabecera2 = { "Nombre", "Porcentaje de cupo" };

	public PanelUsuarios(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTablas();
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

		combo_buscar = new JComboBox<String>();
		combo_buscar.addItem("Nombre");
		combo_buscar.addItem("Correo");
		combo_buscar.addItem("Alias");
		combo_buscar.addItem("Número de tarjeta");
		combo_buscar.setBounds(36, 150, 150, 25);
		combo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(combo_buscar);

		campo_buscar = new JTextField("");
		campo_buscar.setBounds(200, 150, 250, 25);
		campo_buscar.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_buscar);

		boton_eliminar = new JButton("Eliminar usuario");
		boton_eliminar.setBounds(500, 150, 250, 25);
		boton_eliminar
				.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_eliminar);

		boton_ver_usuarios = new JButton("Ver usuarios");
		boton_ver_usuarios.setBounds(500, 100, 250, 25);
		boton_ver_usuarios.setFont(new Font("Accidental Presidency", Font.BOLD,
				16));
		add(boton_ver_usuarios);

		boton_as_op1 = new JButton("Ordenar ascendente Opción 1");
		boton_as_op1.setBounds(76, 440, 300, 25);
		boton_as_op1.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_as_op1);

		boton_des_op2 = new JButton("Ordenar descendente Opción 1");
		boton_des_op2.setBounds(76, 470, 300, 25);
		boton_des_op2.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_des_op2);

		boton_as_op2 = new JButton("Ordenar ascendente Opción 2");
		boton_as_op2.setBounds(400, 440, 300, 25);
		boton_as_op2.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_as_op2);

		boton_des_op2 = new JButton("Ordenar descendente Opción 2");
		boton_des_op2.setBounds(400, 470, 300, 25);
		boton_des_op2.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(boton_des_op2);

	}

	public void crearTablas() {
		tabla1 = new JTable();
		model1 = new DefaultTableModel(cabecera1, 0);
		tabla1 = new JTable(model1);
		tabla1.setModel(model1);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla1.setPreferredSize(new Dimension(700, 700));
		tabla1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		for (int i = 0; i < cabecera1.length; i++) {
			tabla1.getColumnModel().getColumn(i).setCellRenderer(Alinear);
			TableColumnModel columnModel = tabla1.getColumnModel();
			columnModel.getColumn(i).setPreferredWidth(200);

			// /////////////////////////////////////////////////////////////
			tabla2 = new JTable();
			model2 = new DefaultTableModel(cabecera2, 0);
			tabla2 = new JTable(model2);
			tabla2.setModel(model2);

			DefaultTableCellRenderer Alinear2 = new DefaultTableCellRenderer();
			Alinear2.setHorizontalAlignment(SwingConstants.CENTER);
			tabla2.setPreferredSize(new Dimension(700, 700));
			tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			for (int j = 0; j < cabecera2.length; j++) {
				tabla2.getColumnModel().getColumn(j).setCellRenderer(Alinear2);
				TableColumnModel columnModel2 = tabla2.getColumnModel();
				columnModel2.getColumn(j).setPreferredWidth(200);
			}

		}

		scroll2 = new JScrollPane(tabla2);
		scroll2.setViewportView(tabla2);
		scroll2.setBounds(36, 320, 700, 100);
		add(scroll2);

		scroll1 = new JScrollPane(tabla1);
		scroll1.setViewportView(tabla1);
		scroll1.setBounds(36, 200, 700, 70);
		add(scroll1);
	}

	public JComboBox<String> getCombo_buscar() {
		return combo_buscar;
	}

	public void setCombo_buscar(JComboBox<String> combo_buscar) {
		this.combo_buscar = combo_buscar;
	}

	public JButton getBoton_as_op1() {
		return boton_as_op1;
	}

	public void setBoton_as_op1(JButton boton_as_op1) {
		this.boton_as_op1 = boton_as_op1;
	}

	public JButton getBoton_des_op1() {
		return boton_des_op1;
	}

	public void setBoton_des_op1(JButton boton_des_op1) {
		this.boton_des_op1 = boton_des_op1;
	}

	public JButton getBoton_as_op2() {
		return boton_as_op2;
	}

	public void setBoton_as_op2(JButton boton_as_op2) {
		this.boton_as_op2 = boton_as_op2;
	}

	public JButton getBoton_des_op2() {
		return boton_des_op2;
	}

	public void setBoton_des_op2(JButton boton_des_op2) {
		this.boton_des_op2 = boton_des_op2;
	}

	public JButton getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(JButton boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}

	public JTextField getCampo_buscar() {
		return campo_buscar;
	}

	public void setCampo_buscar(JTextField campo_buscar) {
		this.campo_buscar = campo_buscar;
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

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}

	public DefaultTableModel getModel2() {
		return model2;
	}

	public void setModel2(DefaultTableModel model2) {
		this.model2 = model2;
	}

	public JTable getTabla1() {
		return tabla1;
	}

	public void setTabla1(JTable tabla1) {
		this.tabla1 = tabla1;
	}

	public JTable getTabla2() {
		return tabla2;
	}

	public void setTabla2(JTable tabla2) {
		this.tabla2 = tabla2;
	}

	public JButton getBoton_ver_usuarios() {
		return boton_ver_usuarios;
	}

	public void setBoton_ver_usuarios(JButton boton_ver_usuarios) {
		this.boton_ver_usuarios = boton_ver_usuarios;
	}

}
