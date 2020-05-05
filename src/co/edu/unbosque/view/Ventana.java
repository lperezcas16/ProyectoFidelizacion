package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel1 panel1 = new Panel1("/co/edu/unbosque/imagenes/fondo1.png");
	
	public Ventana() {
		setLayout(null);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);// CENTRAR LA VENTANA EN LA PANTALLA
		setResizable(false);// IMPIDE QUE EL USUARIO MODIFIQUE EL TAMAÑO DE LA
							// VENTANA
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		add(panel1);
	}
	
	public Panel1 getPanel1() {
		return panel1;
	}

	public void setPanel1(Panel1 panel1) {
		this.panel1 = panel1;
	}

	

}
