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
			"Total", "Cupo Restante de la Pareja" };

	public PanelVerHistorial() {
		Color color_azul = new Color(36, 67, 87);
		setLayout(null);
		setBackground(color_azul);
		inicializarComponentes();
		setVisible(false);
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void visibilidadComponentes(boolean b) {
		table.setVisible(b);
		scroll.setVisible(b);
	}

}
