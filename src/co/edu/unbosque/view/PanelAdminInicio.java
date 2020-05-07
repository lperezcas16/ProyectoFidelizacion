package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class PanelAdminInicio extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane pestanas;
	private PanelInfo panel_info;
	private PanelInformes panel_informe;
	private PanelUsuarios panel_usuarios;
	private PanelTiendas panel_tiendas;
	
	public PanelAdminInicio() {
		
		setLayout(new BorderLayout());
		setBounds(0,0,795,572);
		
		pestanas= new JTabbedPane();
		
		Color colorNaranja = new Color(225,145,77);
		
		panel_info = new PanelInfo("/co/edu/unbosque/imagenes/fondo_mi_info.png");
		panel_info.setBounds(0,0,790,590);
		panel_informe = new PanelInformes("/co/edu/unbosque/imagenes/fondo-informe.png");
		panel_informe.setBounds(0,0,790,590);
		panel_usuarios = new PanelUsuarios("/co/edu/unbosque/imagenes/fondo_usuario.png");
		panel_usuarios.setBounds(0,0,790,590);
		panel_tiendas = new PanelTiendas();
		panel_tiendas.setBounds(0,0,790,590);
		
		pestanas.addTab("Informes", panel_informe);
		pestanas.addTab("Usuarios", panel_usuarios);
		pestanas.addTab("Mi información", panel_info);
		pestanas.addTab("Tiendas", panel_tiendas);
		
		add(pestanas);
		
		pestanas.setBackground(colorNaranja);
		
		setVisible(true);
		
		
	}

	public JTabbedPane getPestanas() {
		return pestanas;
	}

	public void setPestanas(JTabbedPane pestanas) {
		this.pestanas = pestanas;
	}

	public PanelInfo getPanel_info() {
		return panel_info;
	}

	public void setPanel_info(PanelInfo panel_info) {
		this.panel_info = panel_info;
	}

	public PanelInformes getPanel_informe() {
		return panel_informe;
	}

	public void setPanel_informe(PanelInformes panel_informe) {
		this.panel_informe = panel_informe;
	}

	public PanelUsuarios getPanel_usuarios() {
		return panel_usuarios;
	}

	public void setPanel_usuarios(PanelUsuarios panel_usuarios) {
		this.panel_usuarios = panel_usuarios;
	}
	
	
	
	

}
