package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class Informe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelInformeUsuario panel_informe_usuarios = new PanelInformeUsuario("/co/edu/unbosque/imagenes/reporte.png");
	private InformeUsuariosParejas informe_usuario_pareja = new InformeUsuariosParejas("/co/edu/unbosque/imagenes/reporte.png");
	
	
	public Informe(Controller controller) {
		
		setLayout(null);
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(true);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultLookAndFeelDecorated(false);
		setVisible(false);
		add(panel_informe_usuarios);
		add(informe_usuario_pareja);
		actionListener(controller);
	}

	private void actionListener(Controller controller) {
		//LISTENER INFORMES
		getPanel_informe().getBoton_imprimir().addActionListener(controller);
		
	}

	public PanelInformeUsuario getPanel_informe() {
		return panel_informe_usuarios;
	}

	public void setPanel_informe(PanelInformeUsuario panel_informe_usuarios) {
		this.panel_informe_usuarios = panel_informe_usuarios;
	}

	public PanelInformeUsuario getPanel_informe_usuarios() {
		return panel_informe_usuarios;
	}

	public void setPanel_informe_usuarios(PanelInformeUsuario panel_informe_usuarios) {
		this.panel_informe_usuarios = panel_informe_usuarios;
	}

	public InformeUsuariosParejas getInforme_usuario_pareja() {
		return informe_usuario_pareja;
	}

	public void setInforme_usuario_pareja(InformeUsuariosParejas informe_usuario_pareja) {
		this.informe_usuario_pareja = informe_usuario_pareja;
	}

	
}
