package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAdmCuentas extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private ImageIcon imagen, imagen_ojo_oculto, imagen_ojo, imagen_boton_agregar, imagen_boton_info, imagen_sesion,
			imagen_adm_cupo, imagen_boton_compra;
	private JButton boton_agregar_pareja, boton_info_pareja, boton_cerrar_sesion, boton_ojo_oculto, boton_adm_cuota,
			boton_compra;
	private JLabel label_tarjeta, label_cupo;
	private Icon icono_ojo_oculto, icono_ojo, icono_boton_agregar, icono_boton_info, icono_sesion, icono_adm_cupo,
			icono_boton_compra;

	private PanelAgregarPareja pnl_agregar_pareja;
	private PanelVerInfoPareja pnl_ver_info_pareja;
	private PanelAdmCupo pnl_adm_cupo;
	private PanelCompras pnl_compras;

	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * 
	 * @param nombre se agregar una imagen al fondo del panel con las respectivas
	 *               propiedades != "".
	 */
	public PanelAdmCuentas(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		inicializarComponentes();
		setVisible(true);

	}

	/**
	 * Este es el metodo Gráfico el cual se le asigna la inicialización de los
	 * atributos y objectos que asignan el fondo al panel . De esta manera el
	 * objecto es creado con un valor inicial. Este método se llama automaticamente
	 * cuando se crea el objeto en la ventana . <b>post</b>Se debe llamar el metodo
	 * y dar un valor a los parametros a la hora de generar un nuevo horario.<br>
	 * 
	 * @param g se agregar una imagen al fondo del panel con las respectivas
	 *          propiedades != "".
	 */
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

	/**
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los
	 * componentes De esta manera cada componente se crea con una ubicacion, u se le
	 * agregar una imagen si es el caso y se agrega el panel Este método se llama
	 * automaticamente cuando se crea el objeto de la ventana que lo contiene .
	 * <b>post</b>se hacen visibles los componentes del panel.<br>
	 */
	public void inicializarComponentes() {

		Color color_azul = new Color(36, 67, 87);
		Color color_naranja = new Color(255, 145, 77);

		label_cupo = new JLabel("$0");
		label_cupo.setBackground(color_azul);
		label_cupo.setForeground(color_naranja);
		label_cupo.setFont(new Font("Accidental Presidency", Font.BOLD, 60));
		label_cupo.setBounds(150, 320, 500, 50);
		add(label_cupo);

		label_tarjeta = new JLabel("", SwingConstants.RIGHT);
		label_tarjeta.setText("");
		label_tarjeta.setBackground(color_azul);
		label_tarjeta.setForeground(color_naranja);
		label_tarjeta.setFont(new Font("Accidental Presidency", Font.BOLD, 30));
		label_tarjeta.setBounds(120, 190, 290, 30);
		add(label_tarjeta);

		boton_ojo_oculto = new JButton();
		boton_ojo_oculto.setBounds(430, 185, 40, 40);
		boton_ojo_oculto.setBorderPainted(false);
		add(boton_ojo_oculto);

		imagen_ojo_oculto = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/ojo oculto.png"));
		icono_ojo_oculto = new ImageIcon(imagen_ojo_oculto.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		imagen_ojo = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/ojo.png"));
		icono_ojo = new ImageIcon(imagen_ojo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		boton_agregar_pareja = new JButton();
		boton_agregar_pareja.setBounds(60, 400, 300, 30);
		add(boton_agregar_pareja);

		boton_info_pareja = new JButton();
		boton_info_pareja.setBounds(420, 400, 300, 30);
		add(boton_info_pareja);

		imagen_boton_agregar = new ImageIcon(
				getClass().getResource("/co/edu/unbosque/imagenes/boton_agregar_pareja.png"));
		icono_boton_agregar = new ImageIcon(
				imagen_boton_agregar.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		imagen_boton_info = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_ver_info.png"));
		icono_boton_info = new ImageIcon(imagen_boton_info.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		pnl_agregar_pareja = new PanelAgregarPareja("/co/edu/unbosque/imagenes/fondo_agregar_pareja.png");
		pnl_agregar_pareja.setBounds(0, 0, 795, 572);
		add(pnl_agregar_pareja);

		pnl_agregar_pareja.getBoton_agregar_nueva_pareja().setIcon(pnl_agregar_pareja.getIcono_boton());
		pnl_agregar_pareja.getBoton_regresar().setIcon(pnl_agregar_pareja.getIcono_boton_regresar());

		pnl_ver_info_pareja = new PanelVerInfoPareja("/co/edu/unbosque/imagenes/fondo_ver_info_parejas.png");
		pnl_ver_info_pareja.setBounds(0, 0, 795, 572);
		add(pnl_ver_info_pareja);

		pnl_ver_info_pareja.getBoton_regresar().setIcon(pnl_ver_info_pareja.getIcono_boton_regresar());

		boton_cerrar_sesion = new JButton();
		boton_cerrar_sesion.setBounds(596, 120, 150, 30);
		add(boton_cerrar_sesion);

		imagen_sesion = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_cerrar_sesion.png"));
		icono_sesion = new ImageIcon(imagen_sesion.getImage().getScaledInstance(210, 30, Image.SCALE_SMOOTH));

		boton_adm_cuota = new JButton();
		boton_adm_cuota.setBounds(60, 460, 300, 30);
		add(boton_adm_cuota);

		imagen_adm_cupo = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_administrar_cupo.png"));
		icono_adm_cupo = new ImageIcon(imagen_adm_cupo.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		pnl_adm_cupo = new PanelAdmCupo("/co/edu/unbosque/imagenes/fondo_adm_cupo.png");
		pnl_adm_cupo.setBounds(0, 0, 795, 572);
		add(pnl_adm_cupo);

		pnl_adm_cupo.getBoton_regresar().setIcon(pnl_adm_cupo.getIcono_boton_regresar());
		pnl_adm_cupo.getBoton_validar_cupo().setIcon(pnl_adm_cupo.getIcono_validar_cupo());

		boton_compra = new JButton();
		boton_compra.setBounds(420, 460, 300, 30);
		add(boton_compra);

		imagen_boton_compra = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_compra.png"));
		icono_boton_compra = new ImageIcon(
				imagen_boton_compra.getImage().getScaledInstance(300, 30, Image.SCALE_SMOOTH));

		pnl_compras = new PanelCompras("/co/edu/unbosque/imagenes/fondo_compras.png");
		pnl_compras.setBounds(0, 0, 795, 572);
		add(pnl_compras);

		pnl_compras.getBoton_historial().setIcon(pnl_compras.getIcono_boton_historial());
		pnl_compras.getBoton_ingresar_compra().setIcon(pnl_compras.getIcono_boton_ingresar_compra());
		pnl_compras.getBoton_regresar().setIcon(pnl_compras.getIcono_boton_regresar());

	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen Este parametro representa el nuevo valor que va a tener el
	 *               ImageIcon != "".
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_agregar_pareja() {
		return boton_agregar_pareja;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_agregar_pareja Este parametro representa el nuevo valor que va a
	 *                             tener el JButton != "".
	 */
	public void setBoton_agregar_pareja(JButton boton_agregar_pareja) {
		this.boton_agregar_pareja = boton_agregar_pareja;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_info_pareja() {
		return boton_info_pareja;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_info_pareja Este parametro representa el nuevo valor que va a
	 *                          tener el JButton != "".
	 */
	public void setBoton_info_pareja(JButton boton_info_pareja) {
		this.boton_info_pareja = boton_info_pareja;
	}

	/**
	 * Este metodo devuelve el valor del JLabel <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JLabel.
	 */
	public JLabel getLabel_tarjeta() {
		return label_tarjeta;
	}

	/**
	 * Este metodo establece el valor del JLabel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param label_tarjeta Este parametro representa el nuevo valor que va a tener
	 *                      el JLabel != "".
	 */
	public void setLabel_tarjeta(JLabel label_tarjeta) {
		this.label_tarjeta = label_tarjeta;
	}

	/**
	 * Este metodo devuelve el valor del JLabel <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JLabel.
	 */
	public JLabel getLabel_cupo() {
		return label_cupo;
	}

	/**
	 * Este metodo establece el valor del JLabel <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param label_cupo Este parametro representa el nuevo valor que va a tener el
	 *                   JLabel != "".
	 */
	public void setLabel_cupo(JLabel label_cupo) {
		this.label_cupo = label_cupo;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_ojo_oculto() {
		return imagen_ojo_oculto;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_ojo_oculto Este parametro representa el nuevo valor que va a
	 *                          tener el ImageIcon != "".
	 */
	public void setImagen_ojo_oculto(ImageIcon imagen_ojo_oculto) {
		this.imagen_ojo_oculto = imagen_ojo_oculto;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_ojo() {
		return imagen_ojo;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_ojo Este parametro representa el nuevo valor que va a tener el
	 *                   ImageIcon != "".
	 */
	public void setImagen_ojo(ImageIcon imagen_ojo) {
		this.imagen_ojo = imagen_ojo;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_ojo_oculto() {
		return icono_ojo_oculto;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_ojo_oculto Este parametro representa el nuevo valor que va a
	 *                         tener el Icon != "".
	 */
	public void setIcono_ojo_oculto(Icon icono_ojo_oculto) {
		this.icono_ojo_oculto = icono_ojo_oculto;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_ojo() {
		return icono_ojo;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_ojo Este parametro representa el nuevo valor que va a tener el
	 *                  Icon != "".
	 */
	public void setIcono_ojo(Icon icono_ojo) {
		this.icono_ojo = icono_ojo;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_ojo_oculto() {
		return boton_ojo_oculto;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_ojo_oculto Este parametro representa el nuevo valor que va a
	 *                         tener el JButton != "".
	 */
	public void setBoton_ojo_oculto(JButton boton_ojo_oculto) {
		this.boton_ojo_oculto = boton_ojo_oculto;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_boton_agregar() {
		return imagen_boton_agregar;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_boton_agregar Este parametro representa el nuevo valor que va a
	 *                             tener el ImageIcon != "".
	 */
	public void setImagen_boton_agregar(ImageIcon imagen_boton_agregar) {
		this.imagen_boton_agregar = imagen_boton_agregar;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_boton_info() {
		return imagen_boton_info;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_boton_info Este parametro representa el nuevo valor que va a
	 *                          tener el ImageIcon != "".
	 */
	public void setImagen_boton_info(ImageIcon imagen_boton_info) {
		this.imagen_boton_info = imagen_boton_info;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_boton_agregar() {
		return icono_boton_agregar;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_boton_agregar Este parametro representa el nuevo valor que va a
	 *                            tener el Icon != "".
	 */
	public void setIcono_boton_agregar(Icon icono_boton_agregar) {
		this.icono_boton_agregar = icono_boton_agregar;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_boton_info() {
		return icono_boton_info;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_boton_info Este parametro representa el nuevo valor que va a
	 *                         tener el Icon != "".
	 */
	public void setIcono_boton_info(Icon icono_boton_info) {
		this.icono_boton_info = icono_boton_info;
	}

	/**
	 * Este metodo devuelve el valor del PanelAgregarPareja <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato PanelAgregarPareja.
	 */
	public PanelAgregarPareja getPnl_agregar_pareja() {
		return pnl_agregar_pareja;
	}

	/**
	 * Este metodo establece el valor del PanelAgregarPareja <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_agregar_pareja Este parametro representa el nuevo valor que va a
	 *                           tener el PanelAgregarPareja != "".
	 */
	public void setPnl_agregar_pareja(PanelAgregarPareja pnl_agregar_pareja) {
		this.pnl_agregar_pareja = pnl_agregar_pareja;
	}

	/**
	 * Este metodo devuelve el valor del String <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato String.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo establece el valor del String <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param nombre Este parametro representa el nuevo valor que va a tener el
	 *               String != "".
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo devuelve el valor del PanelVerInfoPareja <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato PanelVerInfoPareja.
	 */
	public PanelVerInfoPareja getPnl_ver_info_pareja() {
		return pnl_ver_info_pareja;
	}

	/**
	 * Este metodo establece el valor del PanelVerInfoPareja <b>post</b>Se fija un
	 * nuevo valor al atributo.<br>
	 * 
	 * @param pnl_ver_info_pareja Este parametro representa el nuevo valor que va a
	 *                            tener el PanelVerInfoPareja != "".
	 */
	public void setPnl_ver_info_pareja(PanelVerInfoPareja pnl_ver_info_pareja) {
		this.pnl_ver_info_pareja = pnl_ver_info_pareja;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_cerrar_sesion() {
		return boton_cerrar_sesion;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_cerrar_sesion Este parametro representa el nuevo valor que va a
	 *                            tener el JButton != "".
	 */
	public void setBoton_cerrar_sesion(JButton boton_cerrar_sesion) {
		this.boton_cerrar_sesion = boton_cerrar_sesion;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_sesion() {
		return imagen_sesion;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_sesion Este parametro representa el nuevo ImageIcon que va a
	 *                      tener el Icon != "".
	 */
	public void setImagen_sesion(ImageIcon imagen_sesion) {
		this.imagen_sesion = imagen_sesion;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_sesion() {
		return icono_sesion;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_sesion Este parametro representa el nuevo valor que va a tener
	 *                     el Icon != "".
	 */
	public void setIcono_sesion(Icon icono_sesion) {
		this.icono_sesion = icono_sesion;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_adm_cuota() {
		return boton_adm_cuota;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_adm_cuota Este parametro representa el nuevo valor que va a
	 *                        tener el JButton != "".
	 */
	public void setBoton_adm_cuota(JButton boton_adm_cuota) {
		this.boton_adm_cuota = boton_adm_cuota;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_adm_cupo() {
		return imagen_adm_cupo;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_adm_cupo Este parametro representa el nuevo valor que va a
	 *                        tener el ImageIcon != "".
	 */
	public void setImagen_adm_cupo(ImageIcon imagen_adm_cupo) {
		this.imagen_adm_cupo = imagen_adm_cupo;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_adm_cupo() {
		return icono_adm_cupo;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_adm_cupo Este parametro representa el nuevo valor que va a tener
	 *                       el Icon != "".
	 */
	public void setIcono_adm_cupo(Icon icono_adm_cupo) {
		this.icono_adm_cupo = icono_adm_cupo;
	}

	/**
	 * Este metodo devuelve el valor del PanelAdmCupo <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato PanelAdmCupo.
	 */
	public PanelAdmCupo getPnl_adm_cupo() {
		return pnl_adm_cupo;
	}

	/**
	 * Este metodo establece el valor del PanelAdmCupo <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param pnl_adm_cupo Este parametro representa el nuevo valor que va a tener
	 *                     el PanelAdmCupo != "".
	 */
	public void setPnl_adm_cupo(PanelAdmCupo pnl_adm_cupo) {
		this.pnl_adm_cupo = pnl_adm_cupo;
	}

	/**
	 * Este metodo devuelve el valor del ImageIcon <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato ImageIcon.
	 */
	public ImageIcon getImagen_boton_compra() {
		return imagen_boton_compra;
	}

	/**
	 * Este metodo establece el valor del ImageIcon <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param imagen_boton_compra Este parametro representa el nuevo valor
	 *                            imagen_boton_compraque va a tener el ImageIcon !=
	 *                            "".
	 */
	public void setImagen_boton_compra(ImageIcon imagen_boton_compra) {
		this.imagen_boton_compra = imagen_boton_compra;
	}

	/**
	 * Este metodo devuelve el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato JButton.
	 */
	public JButton getBoton_compra() {
		return boton_compra;
	}

	/**
	 * Este metodo establece el valor del JButton <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param boton_compra Este parametro representa el nuevo valor que va a tener
	 *                     el JButton != "".
	 */
	public void setBoton_compra(JButton boton_compra) {
		this.boton_compra = boton_compra;
	}

	/**
	 * Este metodo devuelve el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @return Retorna el atributo en formato Icon.
	 */
	public Icon getIcono_boton_compra() {
		return icono_boton_compra;
	}

	/**
	 * Este metodo establece el valor del Icon <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param icono_boton_compra Este parametro representa el nuevo valor que va a
	 *                           tener el Icon != "".
	 */
	public void setIcono_boton_compra(Icon icono_boton_compra) {
		this.icono_boton_compra = icono_boton_compra;
	}

	/**
	 * Este metodo devuelve el valor del PanelCompras <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @return Retorna el atributo en formato PanelCompras.
	 */
	public PanelCompras getPnl_compras() {
		return pnl_compras;
	}

	/**
	 * Este metodo establece el valor del PanelCompras <b>post</b>Se fija un nuevo
	 * valor al atributo.<br>
	 * 
	 * @param pnl_compras Este parametro representa el nuevo valor que va a tener el
	 *                    PanelCompras != "".
	 */
	public void setPnl_compras(PanelCompras pnl_compras) {
		this.pnl_compras = pnl_compras;
	}

	/**
	 * Este es el metodo visibilidadComponentes el cual permite que los campos sean
	 * visibles cuaando el método es llamado objeto.<b>post</b> quedan vacios los
	 * campos del panel .<br>
	 * 
	 * @param b booleano que resive si son visibles o no los componentes
	 *          seleccinados
	 */

	public void visibilidadComponentes(boolean b) {
		label_cupo.setVisible(b);
		label_tarjeta.setVisible(b);
		boton_adm_cuota.setVisible(b);
		boton_agregar_pareja.setVisible(b);
		boton_cerrar_sesion.setVisible(b);
		boton_info_pareja.setVisible(b);
		boton_ojo_oculto.setVisible(b);
		boton_compra.setVisible(b);
	}
}
