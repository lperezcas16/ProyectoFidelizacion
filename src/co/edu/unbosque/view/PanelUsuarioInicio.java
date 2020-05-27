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
	private PanelVerHorarios pnl_ver_horarios = new PanelVerHorarios("/co/edu/unbosque/imagenes/fondo_ver_horario.png");

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos . De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se hace visible el panel cuando es llamado por la ventana.<br>
	 */
	public PanelUsuarioInicio() {

		setLayout(new BorderLayout());
		setBounds(0, 0, 795, 572);
		inicializarComponentes();
		setVisible(false);
	}

	/**
	 * Este es el metodo inicializarComponente el cual se inicianilizan los
	 * componentes De esta manera cada componente se crea con una ubicacion, u se le
	 * agregar una imagen si es el caso y se agrega el panel Este método se llama
	 * automaticamente cuando se crea el objeto del panel que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {
		pestañas = new JTabbedPane();
		pestañas.addTab("Administrar Cuenta", pnl_adm_cuentas);
		pestañas.addTab("Asignar Horarios", pnl_asignar_horarios);
		pestañas.addTab("Ver Horarios", pnl_ver_horarios);
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

	/**
	 * Este metodo devuelve el valor del JTabbedPane. <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param pestañas Este parametro representa el valor del JTabbedPane.!= ""
	 */
	public JTabbedPane getPestañas() {
		return pestañas;
	}

	/**
	 * Este metodo devuelve el valor del PanelAdmCuentas. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_adm_cuentas Este parametro representa el valor del
	 *                        PanelAdmCuentas.!= ""
	 */
	public PanelAdmCuentas getPnl_adm_cuentas() {
		return pnl_adm_cuentas;
	}

	/**
	 * Este metodo establece el valor del PanelAdmCuentas <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_adm_cuentas Este parametro representa el nuevo valor que va a
	 *                        tener el PanelAdmCuentas.!= ""
	 */
	public void setPnl_adm_cuentas(PanelAdmCuentas pnl_adm_cuentas) {
		this.pnl_adm_cuentas = pnl_adm_cuentas;
	}

	/**
	 * Este metodo devuelve el valor del PanelAsignarHorario. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_asignar_horarios Este parametro representa el valor del
	 *                             PanelAsignarHorario.!= ""
	 */
	public PanelAsignarHorario getPnl_asignar_horarios() {
		return pnl_asignar_horarios;
	}

	/**
	 * Este metodo establece el valor del PanelAsignarHorario <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_asignar_horarios Este parametro representa el nuevo valor que va a
	 *                             tener el PanelAsignarHorario.!= ""
	 */
	public void setPnl_asignar_horarios(PanelAsignarHorario pnl_asignar_horarios) {
		this.pnl_asignar_horarios = pnl_asignar_horarios;
	}

	/**
	 * Este metodo establece el valor del JTabbedPane <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param pestañas Este parametro representa el nuevo valor que va a tener el
	 *                 JTabbedPane.!= ""
	 */
	public void setPestañas(JTabbedPane pestañas) {
		this.pestañas = pestañas;
	}

	/**
	 * Este metodo devuelve el valor del PanelInfoSolusoft. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_info_solusoft Este parametro representa el valor del
	 *                          PanelInfoSolusoft.!= ""
	 */
	public PanelInfoSolusoft getPnl_info_solusoft() {
		return pnl_info_solusoft;
	}

	/**
	 * Este metodo establece el valor del PanelInfoSolusoft <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_info_solusoft Este parametro representa el nuevo valor que va a
	 *                          tener el PanelInfoSolusoft.!= ""
	 */
	public void setPnl_info_solusoft(PanelInfoSolusoft pnl_info_solusoft) {
		this.pnl_info_solusoft = pnl_info_solusoft;
	}

	/**
	 * Este metodo devuelve el valor del PanelVerHorarios. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param getPnl_ver_horarios Este parametro representa el valor del
	 *                            PanelVerHorarios.!= ""
	 */
	public PanelVerHorarios getPnl_ver_horarios() {
		return pnl_ver_horarios;
	}

	/**
	 * Este metodo establece el valor del PanelVerHorarios <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_info_solusoft Este parametro representa el nuevo valor que va a
	 *                          tener el PanelVerHorarios.!= ""
	 */
	public void setPnl_ver_horarios(PanelVerHorarios pnl_ver_horarios) {
		this.pnl_ver_horarios = pnl_ver_horarios;
	}

}
