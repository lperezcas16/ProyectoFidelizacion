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
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_ojo_oculto()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_agregar_pareja()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_info_pareja()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_cerrar_sesion()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_adm_cuota()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getBoton_compra()
				.addActionListener(controller);
		// LISTENERS ASIGNAR HORARIOS
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_agregar_horario().addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getBoton_seleccionar_tienda().addActionListener(controller);
		// LISTENERS PANEL SELECCIONAR TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_nueva_tienda()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_agregar_tienda()
				.addActionListener(controller);
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_validar_nueva_tienda().addActionListener(controller);
		// LISTENERS PANEL VER INFO PAREJA
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_ver_info_pareja()
				.getBoton_regresar().addActionListener(controller);
		// LISTENERS PANEL INFORMACION
		getPanel_admin().getPanel_info().getBoton_cerrar()
				.addActionListener(controller);

		// LISTENERS PANEL INFORME
		
		getPanel_admin().getPanel_informe().getCampo_usuario()
				.addActionListener(controller);
		getPanel_admin().getPanel_informe().getBoton()
				.addActionListener(controller);
		getPanel_admin().getPanel_informe().getBoton_vista_previa()
				.addActionListener(controller);
		getPanel_admin().getPanel_informe().getCombo_estadistica()
				.addActionListener(controller);
		// LISTENERS PANEL TIENDA
		getPanel_admin().getPanel_tiendas().getBoton_eliminar()
				.addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getBoton_agregar_tienda()
				.addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getCombo_tiendas()
				.addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getBoton_ver_tiendas()
				.addActionListener(controller);
		getPanel_admin().getPanel_tiendas().getboton_buscar_pornombre()
				.addActionListener(controller);

		// PANEL ADMINISTRACION USUARIOS
		getPanel_admin().getPanel_usuarios().getBoton_eliminar()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getBoton_ver_usuarios()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getver_parejas()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_buscar_usuario()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_aliasu()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_nombreu()
				.addActionListener(controller);
		getPanel_admin().getPanel_usuarios().getboton_orden_correou()
				.addActionListener(controller);
		// PANEL AGREGAR PAREJA
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja()
				.getBoton_regresar().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_agregar_pareja()
				.getBoton_agregar_nueva_pareja().addActionListener(controller);
		// PANEL SELECCIONAR TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getBoton_regresar()
				.addActionListener(controller);
		// PANEL NUEVA TIENDA
		getPanel_us_inicio().getPnl_asignar_horarios()
				.getPnl_seleccionar_tienda().getPnl_nueva_tienda()
				.getBoton_regresar().addActionListener(controller);

		// PANEL ADM CUPO
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
				.getBoton_regresar().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_adm_cupo()
				.getBoton_validar_cupo().addActionListener(controller);

		// PANEL COMPRAS
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_historial().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_ingresar_compra().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getBoton_regresar().addActionListener(controller);
		getPanel_us_inicio().getPnl_adm_cuentas().getPnl_compras()
				.getPnl_ingresar_compra().getBoton_agregar_compra()
				.addActionListener(controller);
	}

	public void mostrarMensajes(String mensaje) {
		if (mensaje.equalsIgnoreCase("USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null,
					"REGISTRO EXITOSO! REVISE SU CORREO");
		} else if (mensaje.equalsIgnoreCase("USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL USUARIO O CORREO INGRESADO YA EXISTE", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null,
					"LA TIENDA SE AGREGO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA DIRECCION DE LA TIENDA YA SE ENCUENTRA REGISTRADA",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CAMPOS_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("NOMBRE_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL NOMBRE NO DEBE CONTENER NUMEROS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CONTRASEÑA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA CONTRASEÑA DEBE TENER MAS DE 8 CARACTERES", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CORREO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL CORREO INGRESADO NO ES VALIDO,  INGRESELO NUEVAMENTE",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORARIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LOS HORARIOS DEFINIDOS NO SON VALIDOS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"NO SE PUEDE ELIMINAR LA TIENDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_VACIO")) {
			JOptionPane.showMessageDialog(null,
					"INTRODUZCA INFORMACION PARA INICIAR LA BUSQUEDA",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_VACIO")) {
			JOptionPane.showMessageDialog(null, "CAMPO VACIO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR USUARIO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null,
					"SE PUDO ELIMINAR USUARIO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("GENERO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SELECCIONE SU GENERO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("INICIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"SU USUARIO Y SU CONTRASEÑA NO COINCIDEN", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SU CUPO YA FUE ESTABLECIDO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("VALOR_CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL FORMATO INGRESADO PARA EL CUPO NO ES CORRECTO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CUPO ES CERO")) {
			JOptionPane.showMessageDialog(null,
					"ES NECESARIO PRIMERO ASIGNAR UN VALOR AL CUPO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("EDAD_FALSE")) {
			JOptionPane
					.showMessageDialog(
							null,
							"LA FECHA DE NACIMIENTO INGRESADA MUESTRA QUE SU PAREJA NO ES MAYOR DE EDAD",
							"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CampoBuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null,
					"SELECCIONE UNA OPCION DE BUSQUEDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("BuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ORDENAMIENTO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"NO SE LOGRO ORDENAR PROBLEMA CON LA BASE DE DATOS",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("EDAD_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA FECHA DE NACIMIENTO INGRESADA MUESTRA "
							+ "QUE NO ES MAYOR DE EDAD", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("PAREJA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"DEBE AGREGAR A SU PAREJA PARA CONTINUAR", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("FECHA_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE ELEGIR UNA FECHA",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("FECHA_PASADA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA FECHA SELECCIONADA YA PASO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "EL HORARIO FUE ASIGNADO");
		} else if (mensaje.equalsIgnoreCase("HORARIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"NO SE PUEDE ASIGNAR EL HORARIO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("DISPONIBILIDAD_FALSE")) {
			JOptionPane
					.showMessageDialog(
							null,
							"LA TIENDA NO TIENE DISPONIBILIDAD EN EL HORARIO SELECCIONADO",
							"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORA_PASADA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA HORA SELECCIONADA YA PASO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("INFORMACION_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"POR FAVOR INGRESE LA INFORMACION SOLICITADA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("REGISTRO_PAREJAS_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"ACTUALMENTE EL USUARIO NO TIENE REGISTRADO PAREJAS",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELEGIR_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"PORFAVOR SELECCIONAR PRIMERO UN USUARIO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELEGIR_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"POR FAVOR PRIMERO SELECCIONE UNA TIENDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("NOMBRE_PAREJA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"YA SE HA REGISTRADO UNA PAREJA CON EL MISMO NOMBRE",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("PORCENTAJE_CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL PORCENTAJE INGRESADO DEBE ESTAR ENTRE EL 0% Y EL 100%",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL VALOR DE LA COMPRA SUPERA EL CUPO DISPONIBLE",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_TRUE")) {
			JOptionPane.showMessageDialog(null,
					"SU COMPRA HA SIDO TRAMITADA CON EXITO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_TRUE")) {
			JOptionPane.showMessageDialog(null,
					"SU COMPRA HA SIDO TRAMITADA CON EXITO");
		} else if (mensaje.equalsIgnoreCase("VALOR_COMPRA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"EL MONTO DE COMPRA NO ES VALIDO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("SELECCION_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"DEBE REGISTRAR UNA TIENDA PARA CONTINUAR", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
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
