package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	private Panel1 panel1 = new Panel1("/co/edu/unbosque/imagenes/fondo1.png");
	private PanelUsuarioInicio panel_us_inicio = new PanelUsuarioInicio();
	private PanelAdminInicio panel_admin = new PanelAdminInicio();

	public Ventana() {

		setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		//add(panel1);
		add(panel_us_inicio);
		add(panel_admin);

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
					"DE LA FECHA DE NACIMIENTO INGRESADA SE MUESTRA QUE NO ES MAYOR DE EDAD");
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
