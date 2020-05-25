package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
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

public class InformeUsuariosParejas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton boton_imprimir, boton_cancelar;
	private ImageIcon imagen_imprimir;
	private Icon icono_imprimir;
	
	
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1, scroll2;

	private DefaultTableModel model1, model2;
	private JTable tabla1, tabla2;

	private String[] cabecera1 = { "Nombre", "Alias", "Correo", "Edad", "Genero", "Numero de Tarjeta", "Cupo" };
	private String[] cabecera2 = { "Nombre", "Valor cupo" };

	public InformeUsuariosParejas(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		crearTablas();
		setVisible(false);
		setBounds(0,0,900,650);

	}

	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

	public void inicializarComponentes() {

		boton_imprimir = new JButton();
		boton_imprimir.setBounds(400,500,50,50);
		imagen_imprimir = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_imprimir.png"));
		icono_imprimir = new ImageIcon(imagen_imprimir.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		boton_imprimir.setHorizontalAlignment(SwingConstants.CENTER);
		boton_imprimir.setVerticalAlignment(SwingConstants.CENTER);
		boton_imprimir.setContentAreaFilled(false);
		boton_imprimir.setBorderPainted(false);
		boton_imprimir.setIcon(icono_imprimir);
		add(boton_imprimir);
		

	}

	public void crearTablas() {
		tabla1 = new JTable();
		model1 = new DefaultTableModel(cabecera1, 0);
		tabla1 = new JTable(model1);
		tabla1.setModel(model1);

		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);
		tabla1.setPreferredSize(new Dimension(780, 76));
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
			tabla2.setPreferredSize(new Dimension(780, 146));
			tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			for (int j = 0; j < cabecera2.length; j++) {
				tabla2.getColumnModel().getColumn(j).setCellRenderer(Alinear2);
				TableColumnModel columnModel2 = tabla2.getColumnModel();
				columnModel2.getColumn(j).setPreferredWidth(200);
			}

		}

		scroll2 = new JScrollPane(tabla2);
		scroll2.setViewportView(tabla2);
		scroll2.setBounds(36, 350, 800, 150);
		add(scroll2);

		scroll1 = new JScrollPane(tabla1);
		scroll1.setViewportView(tabla1);
		scroll1.setBounds(36, 200, 800, 100);
		add(scroll1);
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



}
