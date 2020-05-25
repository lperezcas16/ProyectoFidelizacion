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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class PanelInformeUsuario extends JPanel   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model1, model2;
	private JTable tabla1, tabla2;
	private JLabel etiqueta_usuario, etiqueta_tienda;
	private String[] cabecera1 = { "Nombre", "Alias", "Correo", "Edad", "Genero", "Numero de Tarjeta", "Cupo" };
	private String[] cabecera2 = { "Nombre", "Dirección", "Horario apertura",
	"Horario cierre" };
	private String nombre;
	private ImageIcon imagen;
	private JScrollPane scroll1, scroll2;
	;
	private JButton boton_imprimir, boton_cancelar;
	private ImageIcon imagen_imprimir;
	private Icon icono_imprimir;
	
	public PanelInformeUsuario(String nombre) {
		
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
		boton_imprimir.setBounds(400,500,50,50);
		imagen_imprimir = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_imprimir.png"));
		icono_imprimir = new ImageIcon(imagen_imprimir.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		boton_imprimir.setHorizontalAlignment(SwingConstants.CENTER);
		boton_imprimir.setVerticalAlignment(SwingConstants.CENTER);
		boton_imprimir.setContentAreaFilled(false);
		boton_imprimir.setBorderPainted(false);
		boton_imprimir.setIcon(icono_imprimir);
		add(boton_imprimir);
		
//		etiqueta_parejas = new JLabel("Parejas");
//		etiqueta_parejas.setBackground(Color.green);
//		etiqueta_parejas.setBounds(36, 280, 130, 100);
//		etiqueta_parejas.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
//		add(etiqueta_parejas);
//		
		
	}
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

				 /////////////////////////////////////////////////////////////
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

		
		public DefaultTableModel getModel1() {
			return model1;
		}

		public JScrollPane getScroll1() {
			return scroll1;
		}

		public void setScroll1(JScrollPane scroll1) {
			this.scroll1 = scroll1;
		}

		public JScrollPane getScroll2() {
			return scroll2;
		}

		public void setScroll2(JScrollPane scroll2) {
			this.scroll2 = scroll2;
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

	

		public JLabel getEtiqueta_tienda() {
			return etiqueta_tienda;
		}

		public void setEtiqueta_tienda(JLabel etiqueta_tienda) {
			this.etiqueta_tienda = etiqueta_tienda;
		}

		public JButton getBoton_imprimir() {
			return boton_imprimir;
		}

		public void setBoton_imprimir(JButton boton_imprimir) {
			this.boton_imprimir = boton_imprimir;
		}

		public JButton getBoton_cancelar() {
			return boton_cancelar;
		}

		public void setBoton_cancelar(JButton boton_cancelar) {
			this.boton_cancelar = boton_cancelar;
		}

		public JLabel getEtiqueta_usuario() {
			return etiqueta_usuario;
		}

		public void setEtiqueta_usuario(JLabel etiqueta_usuario) {
			this.etiqueta_usuario = etiqueta_usuario;
		}

	
		
		
}
