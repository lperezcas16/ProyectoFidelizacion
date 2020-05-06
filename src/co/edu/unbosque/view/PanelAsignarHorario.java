package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class PanelAsignarHorario extends JPanel {
	
	//fkadjflkajdfk

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> combobox_tiendas, combobox_parejas;
	private JDateChooser calendario;

	public PanelAsignarHorario() {

	}

	public JComboBox<Object> getCombobox_tiendas() {
		return combobox_tiendas;
	}

	public void setCombobox_tiendas(JComboBox<Object> combobox_tiendas) {
		this.combobox_tiendas = combobox_tiendas;
	}

	public JComboBox<Object> getCombobox_parejas() {
		return combobox_parejas;
	}

	public void setCombobox_parejas(JComboBox<Object> combobox_parejas) {
		this.combobox_parejas = combobox_parejas;
	}

	public JDateChooser getCalendario() {
		return calendario;
	}

	public void setCalendario(JDateChooser calendario) {
		this.calendario = calendario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
