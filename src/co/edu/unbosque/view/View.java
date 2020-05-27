package co.edu.unbosque.view;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;

	private Panel1 panel1 = new Panel1("/co/edu/unbosque/imagenes/fondo1.png");
	private PanelUsuarioInicio panel_us_inicio = new PanelUsuarioInicio();
	private PanelAdminInicio panel_admin = new PanelAdminInicio();
	private Informe informe = new Informe();
	private String nombrePareja;
	private int cantidad_cupo;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos, objetos y forma de organización del JFrame. De esta manera el
	 * objecto es creado con un valor inicial. Este método se llama automaticamente
	 * cuando se crea el objeto.<b>post</b> se genera la ventana con el panel
	 * seleccionado .<br>
	 */
	public View() {

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

	}

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param mensaje Es el mensaje que se recibe del controlador y con este se
	 *                muestra el JOption deseado != "".
	 */
	public void mostrarMensajes(String mensaje) {

		NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		if (mensaje.equalsIgnoreCase("USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO! REVISE SU CORREO");
		} else if (mensaje.equalsIgnoreCase("USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL USUARIO O CORREO INGRESADO YA EXISTE", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null, "LA TIENDA SE AGREGO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA DIRECCION DE LA TIENDA YA SE ENCUENTRA REGISTRADA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CAMPOS_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("NOMBRE_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL NOMBRE NO DEBE CONTENER NUMEROS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CONTRASEÑA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA CONTRASEÑA DEBE TENER MAS DE 8 CARACTERES", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CORREO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL CORREO INGRESADO NO ES VALIDO,  INGRESELO NUEVAMENTE", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "LOS HORARIOS DEFINIDOS NO SON VALIDOS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR LA TIENDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_TRUE")) {
			JOptionPane.showMessageDialog(null, "SE ELIMINÓ CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_TIENDA_VACIO")) {
			JOptionPane.showMessageDialog(null, "INTRODUZCA INFORMACION PARA INICIAR LA BUSQUEDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_VACIO")) {
			JOptionPane.showMessageDialog(null, "CAMPO VACIO", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR USUARIO", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELIMINAR_USUARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "SE PUDO ELIMINAR USUARIO CORRECTAMENTE");
		} else if (mensaje.equalsIgnoreCase("GENERO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SELECCIONE SU GENERO", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("INICIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SU USUARIO Y SU CONTRASEÑA NO COINCIDEN", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "SU CUPO YA FUE ESTABLECIDO", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("VALOR_CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL FORMATO INGRESADO PARA EL CUPO NO ES CORRECTO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CUPO ES CERO")) {
			JOptionPane.showMessageDialog(null, "ES NECESARIO PRIMERO ASIGNAR UN VALOR AL CUPO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("EDAD_FALSE")) {
			JOptionPane.showMessageDialog(null,
					"LA FECHA DE NACIMIENTO INGRESADA MUESTRA QUE SU PAREJA NO ES MAYOR DE EDAD", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CampoBuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION DE BUSQUEDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("BuscarUsuario_False")) {
			JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ORDENAMIENTO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE LOGRO ORDENAR PROBLEMA CON LA BASE DE DATOS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("EDAD_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA FECHA DE NACIMIENTO INGRESADA MUESTRA " + "QUE NO ES MAYOR DE EDAD",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("PAREJA_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE AGREGAR A SU PAREJA PARA CONTINUAR", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("FECHA_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE ELEGIR UNA FECHA", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("FECHA_PASADA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA FECHA SELECCIONADA YA PASO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORARIO_TRUE")) {
			JOptionPane.showMessageDialog(null, "EL HORARIO FUE ASIGNADO");
		} else if (mensaje.equalsIgnoreCase("HORARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE PUEDE ASIGNAR EL HORARIO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("DISPONIBILIDAD_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA TIENDA NO TIENE DISPONIBILIDAD EN EL HORARIO SELECCIONADO",
					"SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("HORA_PASADA_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA HORA SELECCIONADA YA PASO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("INFORMACION_FALSE")) {
			JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE LA INFORMACION SOLICITADA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("REGISTRO_PAREJAS_FALSE")) {
			JOptionPane.showMessageDialog(null, "ACTUALMENTE EL USUARIO NO TIENE REGISTRADO PAREJAS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELEGIR_USUARIO_FALSE")) {
			JOptionPane.showMessageDialog(null, "PORFAVOR SELECCIONAR PRIMERO UN USUARIO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ELEGIR_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "POR FAVOR PRIMERO SELECCIONE UNA TIENDA", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("NOMBRE_PAREJA_FALSE")) {
			JOptionPane.showMessageDialog(null, "YA SE HA REGISTRADO UNA PAREJA CON EL MISMO NOMBRE", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("PORCENTAJE_CUPO_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL PORCENTAJE INGRESADO DEBE ESTAR ENTRE EL 0% Y EL 100%", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL VALOR DE LA COMPRA SUPERA EL CUPO DISPONIBLE", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_TRUE")) {
			JOptionPane.showMessageDialog(null, "SU COMPRA HA SIDO TRAMITADA CON EXITO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("COMPRA_TRUE")) {
			JOptionPane.showMessageDialog(null, "SU COMPRA HA SIDO TRAMITADA CON EXITO");
		} else if (mensaje.equalsIgnoreCase("VALOR_COMPRA_FALSE")) {
			JOptionPane.showMessageDialog(null, "EL MONTO DE COMPRA NO ES VALIDO", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("SELECCION_TIENDA_FALSE")) {
			JOptionPane.showMessageDialog(null, "DEBE REGISTRAR UNA TIENDA PARA CONTINUAR", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("CONFIRMACION_CANTIDAD_CUPO")) {

		} else if (mensaje.equalsIgnoreCase("CONFIRMACION_CUPO_PAREJAS")) {
			JOptionPane.showMessageDialog(null,
					"El monto asignado a " + nombrePareja + " es " + "\n" + formatoImporte.format(cantidad_cupo),
					"Información", JOptionPane.INFORMATION_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("TIENDA_BUSCAR_FALSE")) {
			JOptionPane.showMessageDialog(null, "LA TIENDA NO EXISTE", "SOLUSOFT", JOptionPane.WARNING_MESSAGE);
		} else if (mensaje.equalsIgnoreCase("ORDENAMIENTO_TIENDAS_FALSE")) {
			JOptionPane.showMessageDialog(null, "NO SE LOGRO ORDENAR PROBLEMA CON LA BASE DE DATOS", "SOLUSOFT",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Este metodo devuelve el valor del Panel1. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 *@return panel1 Este parametro representa el nuevo valor del panel.
	 */
	public Panel1 getPanel1() {
		return panel1;
	}

	/**
	 * Este metodo establece el valor del Panel1. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param panel1 Este parametro representa el nuevo valor del panel.
	 */
	public void setPanel1(Panel1 panel1) {
		this.panel1 = panel1;
	}

	/**
	 * Este metodo devuelve el valor del PanelUsuarioInicio. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 *@return panel_us_inicio Este parametro representa el nuevo valor del panel.
	 */
	public PanelUsuarioInicio getPanel_us_inicio() {
		return panel_us_inicio;
	}

	/**
	 * Este metodo establece el valor del Panel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param panel_us_inicio Este parametro representa el nuevo valor del panel.
	 */
	public void setPanel_us_inicio(PanelUsuarioInicio panel_us_inicio) {
		this.panel_us_inicio = panel_us_inicio;
	}

	/**
	 * Este metodo devuelve el valor del PanelUsuarioInicio. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 *@return panel_admin Este parametro representa el nuevo valor del panel.
	 */
	public PanelAdminInicio getPanel_admin() {
		return panel_admin;
	}

	/**
	 * Este metodo establece el valor del Panel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param panel_admin Este parametro representa el nuevo valor del panel.
	 */
	public void setPanel_admin(PanelAdminInicio panel_admin) {
		this.panel_admin = panel_admin;
	}

	/**
	 * Este metodo devuelve el valor del PanelUsuarioInicio. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 *@return informe Este parametro representa el nuevo valor del panel.
	 */
	public Informe getInforme() {
		return informe;
	}

	/**
	 * Este metodo establece el valor del Panel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param informe Este parametro representa el nuevo valor del panel.
	 */
	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	/**
	 * Este metodo devuelve el valor del PanelUsuarioInicio. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 *@return nombrePareja Este parametro representa el nuevo valor del panel.
	 */
	public String getNombrePareja() {
		return nombrePareja;
	}

	/**
	 * Este metodo establece el valor del Panel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombrePareja Este parametro representa el nuevo valor del panel.
	 */
	public void setNombrePareja(String nombrePareja) {
		this.nombrePareja = nombrePareja;
	}

	/**
	 * Este metodo devuelve el valor del PanelUsuarioInicio. <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 *@return cantidad_cupo Este parametro representa el nuevo valor del panel.
	 */
	public int getCantidad_cupo() {
		return cantidad_cupo;
	}

	/**
	 * Este metodo establece el valor del Panel. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param cantidad_cupo Este parametro representa el nuevo valor del panel.
	 */
	public void setCantidad_cupo(int cantidad_cupo) {
		this.cantidad_cupo = cantidad_cupo;
	}

}
