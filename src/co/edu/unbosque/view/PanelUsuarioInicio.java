package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelUsuarioInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTabbedPane pestañas;
	private PanelAdmCuentas pnl_adm_cuentas = new PanelAdmCuentas("/co/edu/unbosque/imagenes/fondo usuario 1.png");
	private PanelAsignarHorario pnl_asignar_horarios = new PanelAsignarHorario(
			"/co/edu/unbosque/imagenes/fondo_horario.png");
	private PanelVerHorarios pnl_ver_horarios = new PanelVerHorarios("/co/edu/unbosque/imagenes/fondo_ver_horario.png");

	// https://www.discoduroderoer.es/como-crear-pestanas-con-la-clase-jtabbedpane-en-java/
	// https://www.adictosaltrabajo.com/2008/12/01/javamail/

	public PanelUsuarioInicio() {

		setLayout(new BorderLayout());
		setBounds(0, 0, 795, 572);
		setVisible(true);
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		pestañas = new JTabbedPane();
		pestañas.addTab("Administrar Cuenta", pnl_adm_cuentas);
		pestañas.addTab("Asignar Horarios", pnl_asignar_horarios);
		pestañas.addTab("Ver Horarios", pnl_ver_horarios);
		add(pestañas);
		Color colorNaranja = new Color(255, 145, 77);
		pestañas.setBackground(colorNaranja);

		pnl_adm_cuentas.setBounds(0, 0, 790, 590);
		pnl_asignar_horarios.setBounds(0, 0, 790, 590);
		pnl_ver_horarios.setBounds(0, 0, 790, 590);

		pnl_adm_cuentas.getBoton_ojo_oculto().setIcon(pnl_adm_cuentas.getIcono_ojo_oculto());
		pnl_adm_cuentas.getBoton_agregar_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_agregar());
		pnl_adm_cuentas.getBoton_info_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_info());
		pnl_asignar_horarios.getBoton_agregar_horario().setIcon(pnl_asignar_horarios.getIcon_boton());
		pnl_asignar_horarios.getBoton_seleccionar_tienda().setIcon(pnl_asignar_horarios.getIcon_boton_tienda());
	}

	public JTabbedPane getPestañas() {
		return pestañas;
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

	public void setPestañas(JTabbedPane pestañas) {
		this.pestañas = pestañas;
	}

}
