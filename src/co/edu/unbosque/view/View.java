package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Panel1 panel1 = new Panel1("/co/edu/unbosque/imagenes/fondo1.png");
	private PanelUsuarioInicio panel_us_inicio = new PanelUsuarioInicio();
	private PanelAdminInicio panel_admin = new PanelAdminInicio();

	public View(Controller controller) {

		setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		add(panel1);
		add(panel_us_inicio);
		add(panel_admin);
		actionListener(controller);
	}

	public void actionListener(Controller controller) {

		// LISTENER PANEL PRINCIPAL
		getPanel1().getBoton_entrar().addActionListener(controller);
		getPanel1().getBoton_registrar().addActionListener(controller);
		// LISTENERS PANEL USUARIOS
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_cerrar_sesion().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_adm_cuota().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_compra().addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		getPanel_us_inicio().getPnl_asignar_horarios().getBoton_agregar_horario().addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios().getBoton_seleccionar_tienda().addActionListener(controller);
		// LISTENERS PANEL SELECCIONAR TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda().addActionListener(controller);
		// LISTENERS PANEL VER INFO PAREJA
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja().getBoton_regresar()
				.addActionListener(controller);
		// LISTENERS PANEL INFORME
		getPanel_admin().getPanel_informe().getCombo_eleccion().addActionListener(controller);
		getPanel_admin().getPanel_informe().getCombo_Fecha().addActionListener(controller);
		getPanel_admin().getPanel_informe().getCombo_hora().addActionListener(controller);
		getPanel_admin().getPanel_informe().getCombo_tienda().addActionListener(controller);
		getPanel_admin().getPanel_informe().getCampo_usuario().addActionListener(controller);
		getPanel_admin().getPanel_informe().getBoton().addActionListener(controller);
		getPanel_admin().getPanel_informe().getBoton_vista_previa().addActionListener(controller);

		// LISTENERS PANEL TIENDA
		getPanel_admin().getPanel_tiendas().getBoton_eliminar().addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getBoton_agregar_tienda().addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getCombo_tiendas().addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getBoton_ver_tiendas().addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getboton_buscar_pornombre().addActionListener(controller);

		// PANEL ADMINISTRACION USUARIOS
		getPanel_admin().getPanel_usuarios().getBoton_eliminar().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getBoton_ver_usuarios().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getver_parejas().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_buscar_usuario().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_aliasu().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_nombreu().addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_correou().addActionListener(controller);
		// PANEL AGREGAR PAREJA
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja().getBoton_regresar()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja().getBoton_agregar_nueva_pareja()
				.addActionListener(controller);
		// PANEL SELECCIONAR TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getBoton_regresar()
				.addActionListener(controller);
		// PANEL NUEVA TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios().getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_regresar().addActionListener(controller);

		// PANEL ADM CUPO
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo().getBoton_regresar().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo().getBoton_validar_cupo()
				.addActionListener(controller);

		// PANEL COMPRAS
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras().getBoton_historial().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras().getBoton_ingresar_compra()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras().getBoton_regresar().addActionListener(controller);

	}

	public void mostrarMensajes(String mensaje) {
		if (mensaje.equalsIgnoreCase("USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO! REVISE SU CORREO");
		} else if (mensaje.equalsIgnoreCase("USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL USUARIO O CORREO INGRESADO YA EXISTE");
		} else if (mensaje.equalsIgnoreCase("TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null, "LA TIENDA SE AGREGO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL NOMBRE Y LA DIRECCION DE LA TIENDA YA SE ENCUENTRA REGISTRADA");
		} else if (mensaje.equalsIgnoreCase("CAMPOS_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
		} else if (mensaje.equalsIgnoreCase("NOMBRE_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL NOMBRE NO DEBE CONTENER NUMEROS");
		} else if (mensaje.equalsIgnoreCase("CONTRASEÑA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA CONTRASEÑA DEBE TENER MAS DE 8 CARACTERES");
		} else if (mensaje.equalsIgnoreCase("CORREO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL CORREO INGRESADO NO ES VALIDO,  INGRESELO NUEVAMENTE");
		} else if (mensaje.equalsIgnoreCase("HORARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "LOS HORARIOS DEFINIDOS NO SON VALIDOS");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR LA TIENDA");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMEMTE");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_VACIO")) {
			JOptionPane.showMessageDialog(null, "INTRODUZCA INFORMACION PARA INICIAR LA BUSQUEDA");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_VACIO")) {
			JOptionPane.showMessageDialog(null, "CAMPO VACIO");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR USUARIO");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "SE PUDO ELIMINAR USUARIO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("GENERO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SELECCIONE SU GENERO");
		} else if (mensaje.equalsIgnoreCase("INICIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SU USUARIO Y SU CONTRASEÑA NO COINCIDEN");
		} else if (mensaje.equalsIgnoreCase("CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SU CUPO YA FUE ESTABLECIDO");
		} else if (mensaje.equalsIgnoreCase("VALOR_CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL FORMATO INGRESADO PARA EL CUPO NO ES CORRECTO");
		} else if (mensaje.equalsIgnoreCase("CUPO ES CERO")) {
			JOptionPane.showMessageDialog(null, "ES NECESARIO PRIMERO ASINGAR UN VALOR AL CUPO");
		} else if (mensaje.equalsIgnoreCase("EDAD_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA FECHA DE NACIMIENTO INGRESADA MUESTRA QUE SU PAREJA NO ES MAYOR DE EDAD");
		} else if (mensaje.equalsIgnoreCase("CampoBuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION DE BUSQUEDA");
		} else if (mensaje.equalsIgnoreCase("BuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE");
		} else if (mensaje.equalsIgnoreCase("ORDENAMIENTO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE LOGRO ORDENAR PROBLEMA CON LA BASE DE DATOS");
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

	public PanelAdminInicio getPanel_admin() {
		return panel_admin;
	}

	public void setPanel_admin(PanelAdminInicio panel_admin) {
		this.panel_admin = panel_admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
