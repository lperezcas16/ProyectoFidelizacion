package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;

public class Panel1 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField campo_usuario,  campo_nombre, campo_numCedula, campo_correo;
	private JPasswordField campo_contrasena;
	private JButton boton_entrar, boton_registrar;
	private ButtonGroup grupo;
	private JRadioButton c1, c2;
	private ImageIcon imagen, imagen_entrar, imagen_registar;
	private Icon icono_entrar, icono_registrar;
	private String nombre;

	public Panel1(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		setVisible(true);
		inicializarComponentes();
		setBounds(0, 0, 790, 590);

	}

	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

	public void inicializarComponentes() {

		campo_usuario = new JTextField();
		campo_usuario.setBounds(340, 35, 250, 25);
		campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_usuario);

		campo_contrasena = new JPasswordField();
		campo_contrasena.setBounds(340, 100, 250, 25);
		campo_contrasena.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		add(campo_contrasena);

		boton_entrar = new JButton();
		boton_entrar.setBounds(620, 55, 100, 50);
		add(boton_entrar);
		
		imagen_entrar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_entrada.png"));
		icono_entrar = new ImageIcon(imagen_entrar.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		boton_entrar.setHorizontalAlignment(SwingConstants.CENTER);
		boton_entrar.setVerticalAlignment(SwingConstants.CENTER);
		boton_entrar.setContentAreaFilled(false);
		boton_entrar.setBorderPainted(false);
		boton_entrar.setIcon(icono_entrar);

		campo_nombre = new JTextField();
		campo_nombre.setBounds(36, 220, 250, 25);
		campo_nombre.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_nombre.setBorder(null);
		add(campo_nombre);


		Color colorA = new Color(36, 67, 87);
		grupo = new ButtonGroup();
		c1 = new JRadioButton("Mujer");
		c1.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		c1.setBackground(colorA);
		c1.setForeground(Color.white);

		c2 = new JRadioButton("Hombre");
		c2.setBackground(colorA);
		c2.setForeground(Color.white);
		c2.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
	
		c1.setBounds(66, 320, 100, 20);
		c2.setBounds(180, 320, 100, 20);
		grupo.add(c1);
		grupo.add(c2);
		add(c1);
		add(c2);

		campo_correo = new JTextField("1");
		campo_correo.setBounds(40, 430, 250, 25);
		campo_correo.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_correo.setBorder(null);
		add(campo_correo);

		campo_usuario = new JTextField();
		campo_usuario.setBounds(420, 220, 250, 25);
		campo_usuario.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_usuario.setBorder(null);
		add(campo_usuario);

		

		campo_contrasena = new JPasswordField();
		campo_contrasena.setBounds(420, 330, 250, 25);
		campo_contrasena.setFont(new Font("Accidental Presidency", Font.BOLD, 16));
		campo_contrasena.setBorder(null);
		add(campo_contrasena);

		boton_registrar = new JButton();
		boton_registrar.setBounds(320, 490, 150, 50);
		add(boton_registrar);
		
		imagen_registar = new ImageIcon(getClass().getResource("/co/edu/unbosque/imagenes/boton_registrar.png"));
		icono_registrar = new ImageIcon(imagen_registar.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH));
		boton_registrar.setHorizontalAlignment(SwingConstants.CENTER);
		boton_registrar.setVerticalAlignment(SwingConstants.CENTER);
		boton_registrar.setContentAreaFilled(false);
		boton_registrar.setBorderPainted(false);
		boton_registrar.setIcon(icono_registrar);
	}
	
	

	public void limpiarCampos() {
		
		campo_contrasena.setText("");
		campo_correo.setText("");
		campo_nombre.setText("");
		campo_numCedula.setText("");
		campo_usuario.setText("");

	}

	public JTextField getCampo_usuario() {
		return campo_usuario;
	}

	public void setCampo_usuario(JTextField campo_usuario) {
		this.campo_usuario = campo_usuario;
	}

	

	public JTextField getCampo_nombre() {
		return campo_nombre;
	}

	public void setCampo_nombre(JTextField campo_nombre) {
		this.campo_nombre = campo_nombre;
	}

	public JTextField getCampo_numCedula() {
		return campo_numCedula;
	}

	public void setCampo_numCedula(JTextField campo_numCedula) {
		this.campo_numCedula = campo_numCedula;
	}

	public JTextField getCampo_correo() {
		return campo_correo;
	}

	public void setCampo_correo(JTextField campo_correo) {
		this.campo_correo = campo_correo;
	}

	public JPasswordField getCampo_contrasena() {
		return campo_contrasena;
	}

	public void setCampo_contrasena(JPasswordField campo_contrasena) {
		this.campo_contrasena = campo_contrasena;
	}

	public JButton getBoton_registrar() {
		return boton_registrar;
	}

	public void setBoton_registrar(JButton boton_registrar) {
		this.boton_registrar = boton_registrar;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

	public JRadioButton getC1() {
		return c1;
	}

	public void setC1(JRadioButton c1) {
		this.c1 = c1;
	}

	public JRadioButton getC2() {
		return c2;
	}

	public void setC2(JRadioButton c2) {
		this.c2 = c2;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public ImageIcon getImagen_entrar() {
		return imagen_entrar;
	}

	public void setImagen_entrar(ImageIcon imagen_entrar) {
		this.imagen_entrar = imagen_entrar;
	}

	public ImageIcon getImagen_registar() {
		return imagen_registar;
	}

	public void setImagen_registar(ImageIcon imagen_registar) {
		this.imagen_registar = imagen_registar;
	}

	public Icon getIcono_entrar() {
		return icono_entrar;
	}

	public void setIcono_entrar(Icon icono_entrar) {
		this.icono_entrar = icono_entrar;
	}

	public Icon getIcono_registrar() {
		return icono_registrar;
	}

	public void setIcono_registrar(Icon icono_registrar) {
		this.icono_registrar = icono_registrar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public JButton getBoton_entrar() {
		return boton_entrar;
	}

	public void setBoton_entrar(JButton boton_entrar) {
		this.boton_entrar = boton_entrar;
	}

}
