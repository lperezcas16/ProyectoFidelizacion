package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

public class PanelAsignarHorario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Object> combobox_parejas;
	private JDateChooser calendario;
	private JButton boton_agregar_horario, boton_seleccionar_tienda;
	private String nombre;
	private ImageIcon imagen, imagen_boton, imagen_boton_tienda;
	private Icon icon_boton, icon_boton_tienda;
	private Color color_azul = new Color(36, 67, 87);
	private Color color_naranja = new Color(255, 145, 77);
	private JSpinner spinner;

	private PanelSeleccionarTienda pnl_seleccionar_tienda;

	public PanelAsignarHorario(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		setBackground(color_azul);
		inicializarComponentes();
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

		combobox_parejas = new JComboBox<Object>();
		combobox_parejas.setBounds(100, 210, 200, 30);
		combobox_parejas.setBackground(Color.white);
		add(combobox_parejas);

		boton_agregar_horario = new JButton();
		boton_agregar_horario.setBounds(490, 400, 175, 30);
		boton_agregar_horario.setEnabled(false);
		add(boton_agregar_horario);

		imagen_boton = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_horario.png"));
		icon_boton = new ImageIcon(imagen_boton.getImage().getScaledInstance(185, 30, Image.SCALE_SMOOTH));

		boton_seleccionar_tienda = new JButton("Seleccionar Tienda");
		boton_seleccionar_tienda.setBounds(490, 330, 175, 30);
		add(boton_seleccionar_tienda);

		imagen_boton_tienda = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_seleccionar_tienda.png"));
		icon_boton_tienda = new ImageIcon(
				imagen_boton_tienda.getImage().getScaledInstance(185, 30, Image.SCALE_SMOOTH));

		calendario = new JDateChooser("dd-MM-yyyy", "####-##-##", '_');
		calendario.setBounds(100, 360, 200, 30);
		calendario.setOpaque(true);
		calendario.setBackground(Color.WHITE);
		calendario.setMinSelectableDate(new Date());
		calendario.setDateFormatString("dd-MM-yyyy");
		Calendar fecha = new GregorianCalendar();
		calendario.setCalendar(fecha);
		add(calendario);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel());
		spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm"));
		spinner.setBounds(480, 210, 200, 30);
		add(spinner);

		pnl_seleccionar_tienda = new PanelSeleccionarTienda("/co/edu/unbosque/imagenes/fondo_seleccionar_tienda.png");
		pnl_seleccionar_tienda.setBounds(0, 0, 795, 572);
		add(pnl_seleccionar_tienda);

		pnl_seleccionar_tienda.getBoton_agregar_nueva_tienda().setIcon(pnl_seleccionar_tienda.getIcon_boton_nueva());
		pnl_seleccionar_tienda.getBoton_agregar_tienda().setIcon(pnl_seleccionar_tienda.getIcon_boton_tienda());
		pnl_seleccionar_tienda.getBoton_regresar().setIcon(pnl_seleccionar_tienda.getIcon_boton_regresar());

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

	public JButton getBoton_agregar_horario() {
		return boton_agregar_horario;
	}

	public void setBoton_agregar_horario(JButton boton_agregar) {
		this.boton_agregar_horario = boton_agregar;
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

	public Color getColor_azul() {
		return color_azul;
	}

	public void setColor_azul(Color color_azul) {
		this.color_azul = color_azul;
	}

	public Color getColor_naranja() {
		return color_naranja;
	}

	public void setColor_naranja(Color color_naranja) {
		this.color_naranja = color_naranja;
	}

	public ImageIcon getImagen_boton() {
		return imagen_boton;
	}

	public void setImagen_boton(ImageIcon imagen_boton) {
		this.imagen_boton = imagen_boton;
	}

	public Icon getIcon_boton() {
		return icon_boton;
	}

	public void setIcon_boton(Icon icon_boton) {
		this.icon_boton = icon_boton;
	}

	public JButton getBoton_seleccionar_tienda() {
		return boton_seleccionar_tienda;
	}

	public void setBoton_seleccionar_tienda(JButton boton_seleccionar_tienda) {
		this.boton_seleccionar_tienda = boton_seleccionar_tienda;
	}

	public ImageIcon getImagen_boton_tienda() {
		return imagen_boton_tienda;
	}

	public void setImagen_boton_tienda(ImageIcon imagen_boton_tienda) {
		this.imagen_boton_tienda = imagen_boton_tienda;
	}

	public Icon getIcon_boton_tienda() {
		return icon_boton_tienda;
	}

	public void setIcon_boton_tienda(Icon icon_boton_tienda) {
		this.icon_boton_tienda = icon_boton_tienda;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public PanelSeleccionarTienda getPnl_seleccionar_tienda() {
		return pnl_seleccionar_tienda;
	}

	public void setPnl_seleccionar_tienda(PanelSeleccionarTienda pnl_seleccionar_tienda) {
		this.pnl_seleccionar_tienda = pnl_seleccionar_tienda;
	}
	public void visibilidadComponentes(boolean b) {
		combobox_parejas.setVisible(b);
		boton_agregar_horario.setVisible(b);
		boton_seleccionar_tienda.setVisible(b);
		calendario.setVisible(b);
		spinner.setVisible(b);
	}
}
