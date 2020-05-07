package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelUsuarioInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	// hola 2
	private JTabbedPane pesta�as;
	private PanelAdmCuentas pnl_adm_cuentas;
	private PanelAsignarHorario pnl_asignar_horarios;
	private PanelVerHorarios pnl_ver_horarios;

	// https://www.discoduroderoer.es/como-crear-pestanas-con-la-clase-jtabbedpane-en-java/
	// https://www.adictosaltrabajo.com/2008/12/01/javamail/

	public PanelUsuarioInicio() {

		setLayout(new BorderLayout());
		setBounds(0, 0, 795, 572);

		pesta�as = new JTabbedPane();

		Color colorNaranja = new Color(255, 145, 77);

		pnl_adm_cuentas = new PanelAdmCuentas("/co/edu/unbosque/imagenes/fondo usuario 1.png");
		pnl_adm_cuentas.setBounds(0, 0, 790, 590);
		pnl_asignar_horarios = new PanelAsignarHorario("/co/edu/unbosque/imagenes/fondo_horario.png");
		pnl_asignar_horarios.setBounds(0, 0, 790, 590);
		pnl_ver_horarios = new PanelVerHorarios("/co/edu/unbosque/imagenes/fondo_ver_horario.png");
		pnl_ver_horarios.setBounds(0, 0, 790, 590);

		pesta�as.addTab("Administrar Cuenta", pnl_adm_cuentas);
		pesta�as.addTab("Asignar Horarios", pnl_asignar_horarios);
		pesta�as.addTab("Ver Horarios", pnl_ver_horarios);
		pnl_adm_cuentas.getBoton_ojo_oculto().setIcon(pnl_adm_cuentas.getIcono_ojo_oculto());
		pnl_adm_cuentas.getBoton_agregar_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_agregar());
		pnl_adm_cuentas.getBoton_info_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_info());
		pnl_asignar_horarios.getBoton_agregar_horario().setIcon(pnl_asignar_horarios.getIcon_boton());

		add(pesta�as);

		pesta�as.setBackground(colorNaranja);

		setVisible(true);

	}

	public JTabbedPane getPesta�as() {
		return pesta�as;
	}

	public PanelAdmCuentas getPnl_adm_cuentas() {
		return pnl_adm_cuentas;
	}

	public void setPnl_adm_cuentas(PanelAdmCuentas pnl_adm_cuentas) {
		this.pnl_adm_cuentas = pnl_adm_cuentas;
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
