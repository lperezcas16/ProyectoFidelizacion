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
	private PanelInfoSolusoft pnl_info_solusoft = new PanelInfoSolusoft(
			"/co/edu/unbosque/imagenes/fondo_info_solusoft.png");

	public PanelUsuarioInicio() {

		setLayout(new BorderLayout());
		setBounds(0, 0, 795, 572);
		inicializarComponentes();
		setVisible(false);
	}

	public void inicializarComponentes() {
		pestañas = new JTabbedPane();
		pestañas.addTab("Administrar Cuenta", pnl_adm_cuentas);
		pestañas.addTab("Asignar Horarios", pnl_asignar_horarios);
		pestañas.addTab("Info. Solusoft", pnl_info_solusoft);
		add(pestañas);
		Color colorNaranja = new Color(255, 145, 77);
		pestañas.setBackground(colorNaranja);

		pnl_adm_cuentas.setBounds(0, 0, 790, 590);
		pnl_asignar_horarios.setBounds(0, 0, 790, 590);

		pnl_adm_cuentas.getBoton_ojo_oculto().setIcon(pnl_adm_cuentas.getIcono_ojo_oculto());
		pnl_adm_cuentas.getBoton_agregar_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_agregar());
		pnl_adm_cuentas.getBoton_info_pareja().setIcon(pnl_adm_cuentas.getIcono_boton_info());
		pnl_asignar_horarios.getBoton_agregar_horario().setIcon(pnl_asignar_horarios.getIcon_boton());
		pnl_asignar_horarios.getBoton_seleccionar_tienda().setIcon(pnl_asignar_horarios.getIcon_boton_tienda());
		pnl_adm_cuentas.getBoton_cerrar_sesion().setIcon(pnl_adm_cuentas.getIcono_sesion());
		pnl_adm_cuentas.getBoton_adm_cuota().setIcon(pnl_adm_cuentas.getIcono_adm_cupo());
		pnl_adm_cuentas.getBoton_compra().setIcon(pnl_adm_cuentas.getIcono_boton_compra());
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

	public void setPestañas(JTabbedPane pestañas) {
		this.pestañas = pestañas;
	}

	public PanelInfoSolusoft getPnl_info_solusoft() {
		return pnl_info_solusoft;
	}

	public void setPnl_info_solusoft(PanelInfoSolusoft pnl_info_solusoft) {
		this.pnl_info_solusoft = pnl_info_solusoft;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
