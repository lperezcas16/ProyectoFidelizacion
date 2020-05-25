package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ImageIcon imagen;
	private JTextField campo_usuario,campo_tienda;
	private JComboBox<String>  combo_eleccion, combo_estadistica;
	private JLabel etiqueta;
	private JButton boton_generar_pfd, boton_vista_previa;


	public PanelInformes(String nombre) {
		this.nombre = nombre;
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

	

		etiqueta = new JLabel("Introducir nombre del usuario");
		etiqueta.setForeground(Color.white);
		etiqueta.setBounds(290,270,250,45);
		etiqueta.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(etiqueta);
		
		

		campo_usuario = new JTextField();
		campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_usuario.setBounds(310, 330, 200, 40);
		add(campo_usuario);
	

		combo_estadistica = new JComboBox<String>();
		combo_estadistica.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		combo_estadistica.setBounds(350, 390, 110, 45);
		combo_estadistica.addItem("Selecciona");
		combo_estadistica.addItem("Edad");
		combo_estadistica.addItem("Total");
	
		add(combo_estadistica);
		
		boton_generar_pfd = new JButton("Generar informe");
		boton_generar_pfd.setBounds(150, 460, 200, 45);
		boton_generar_pfd.setFont(new Font("Accidental Presidency", Font.BOLD,16));
		add(boton_generar_pfd);
		boton_generar_pfd.setVisible(false);

		boton_vista_previa = new JButton("Vista previa de gráficas");
		boton_vista_previa.setBounds(420, 460, 300, 45);
		boton_vista_previa.setFont(new Font("Accidental Presidency", Font.BOLD,
				16));
		add(boton_vista_previa);
		boton_vista_previa.setVisible(false);

	}

	public JTextField getCampo_usuario() {
		return campo_usuario;
	}

	public void setCampo_usuario(JTextField campo_usuario) {
		this.campo_usuario = campo_usuario;
	}

	

	public JComboBox<String> getCombo_eleccion() {
		return combo_eleccion;
	}

	public void setCombo_eleccion(JComboBox<String> combo_eleccion) {
		this.combo_eleccion = combo_eleccion;
	}



	public JButton getBoton() {
		return boton_generar_pfd;
	}

	public void setBoton(JButton boton) {
		this.boton_generar_pfd = boton;
	}

	public JButton getBoton_vista_previa() {
		return boton_vista_previa;
	}

	public void setBoton_vista_previa(JButton boton_vista_previa) {
		this.boton_vista_previa = boton_vista_previa;
	}

	public JButton getBoton_generar_pfd() {
		return boton_generar_pfd;
	}

	public void setBoton_generar_pfd(JButton boton_generar_pfd) {
		this.boton_generar_pfd = boton_generar_pfd;
	}
	

	public JTextField getCampo_tienda() {
		return campo_tienda;
	}

	public void setCampo_tienda(JTextField campo_tienda) {
		this.campo_tienda = campo_tienda;
	}

	
	public JComboBox<String> getCombo_estadistica() {
		return combo_estadistica;
	}

	public void setCombo_estadistica(JComboBox<String> combo_estadistica) {
		this.combo_estadistica = combo_estadistica;
	}
	

	public void visibilidadComponentes(boolean b) {
	
		boton_generar_pfd.setVisible(b);
		boton_vista_previa.setVisible(b);
	}

	
}