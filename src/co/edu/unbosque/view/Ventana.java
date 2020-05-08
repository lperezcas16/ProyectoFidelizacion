package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	private Panel1 panel1 = new Panel1("/co/edu/unbosque/imagenes/fondo1.png");
	private PanelUsuarioInicio panel_us_inicio;
	private PanelAdminInicio panel_admin;

	public Ventana() {
		
		setLayout(null);
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		
		add(panel1);
		
		panel_us_inicio = new PanelUsuarioInicio();
		add(panel_us_inicio);
		
//		panel_admin = new PanelAdminInicio();
//		add(panel_admin);
//	

	}
	
	public void  mostrarMensajes(String mensaje)
	{
		if(mensaje.equalsIgnoreCase("USUARIO_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "EL USUARIO YA EXISTE EN EL SISTEMA");
		}
		else if(mensaje.equalsIgnoreCase("CAMPOS_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "DEBE DIGITAR TODOS LOS CAMPOS");
		}
		else if(mensaje.equalsIgnoreCase("NOMBRE_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "DEBE DIGITAR TODOS LOS CAMPOS");
		}else if(mensaje.equalsIgnoreCase("CONTRASEÑA_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "LA CONTRASEÑA DEBE TENER MAS DE 8 DIGITOS");
		}
	}

	public Panel1 getPanel1() {
		return panel1;
	}

	public void setPanel1(Panel1 panel1) {
		this.panel1 = panel1;
	}

	public PanelUsuarioInicio getPanel_us_inicio() {
		return panel_us_inicio;
	}

	public void setPanel_us_inicio(PanelUsuarioInicio panel_us_inicio) {
		this.panel_us_inicio = panel_us_inicio;
	}

}
