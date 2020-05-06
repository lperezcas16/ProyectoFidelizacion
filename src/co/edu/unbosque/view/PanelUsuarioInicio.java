package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelUsuarioInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTabbedPane pesta�as;
	private PanelAdmParejas pnl_adm_parejas;
	private PanelAsignarHorario pnl_asignar_horarios;
	private PanelVerHorarios pnl_ver_horarios;

	// https://www.discoduroderoer.es/como-crear-pestanas-con-la-clase-jtabbedpane-en-java/
	// https://www.adictosaltrabajo.com/2008/12/01/javamail/

	public PanelUsuarioInicio() {

		setLayout(new BorderLayout());
		setBounds(0, 0, 795, 572);

		pesta�as = new JTabbedPane();

		Color colorNaranja = new Color(255, 145, 77);

		pnl_adm_parejas = new PanelAdmParejas("/co/edu/unbosque/imagenes/fondo usuario 1.png");
		pnl_adm_parejas.setBounds(0, 0, 790, 590);
		pnl_asignar_horarios = new PanelAsignarHorario();
		pnl_asignar_horarios.setBounds(0, 0, 790, 590);
		pnl_ver_horarios = new PanelVerHorarios();
		pnl_ver_horarios.setBounds(0, 0, 790, 590);

		pesta�as.addTab("Administrar Cuenta", pnl_adm_parejas);
		pesta�as.addTab("Asignar Horarios", pnl_asignar_horarios);
		pesta�as.addTab("Ver Horarios", pnl_ver_horarios);
		
		pesta�as.setIconAt(0, pnl_adm_parejas.getIcono_ojo_oculto());
		
		add(pesta�as);
		
		pesta�as.setBackground(colorNaranja);

		setVisible(true);

	}

	public JTabbedPane getPesta�as() {
		return pesta�as;
	}

	public PanelAdmParejas getPnl_adm_parejas() {
		return pnl_adm_parejas;
	}

	public void setPnl_adm_parejas(PanelAdmParejas pnl_adm_parejas) {
		this.pnl_adm_parejas = pnl_adm_parejas;
	}

	public PanelAsignarHorario getPnl_asignar_horarios() {
		return pnl_asignar_horarios;
	}

	public void setPnl_asignar_horarios(PanelAsignarHorario pnl_asignar_horarios) {
		this.pnl_asignar_horarios = pnl_asignar_horarios;
	}

	public PanelVerHorarios getPnl_ver_horarios() {
		return pnl_ver_horarios;
	}

	public void setPnl_ver_horarios(PanelVerHorarios pnl_ver_horarios) {
		this.pnl_ver_horarios = pnl_ver_horarios;
	}

	public void setPesta�as(JTabbedPane pesta�as) {
		this.pesta�as = pesta�as;
	}

}
