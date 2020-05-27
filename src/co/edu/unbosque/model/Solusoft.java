package co.edu.unbosque.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Solusoft {

	private String usuario_inicio;
	private int valorCupo;
	private double valorVariable;

	/**
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el
	 * objeto.<b>post</b>Se debe llamar el metodo y dar un valor a los parametros a
	 * la hora de generar un nuevo registro de compra.<br>
	 * 
	 * @param usuario_Inicio Este paramentro representa el alias del usuario que
	 *                       ingresa en el sistema, dandole cada vez un valor al
	 *                       atributo frente al diferente alias. usuario_Inicio !=
	 *                       null, usuario_Inicio != "".
	 */
	public Solusoft(String usuario_Inicio) {
		usuario_inicio = usuario_Inicio;
	}

	/**
	 * En este metodo se crea cada vez una nueva secuencia de dieciseis numeros para
	 * la tarjeta de credito de cada usuario al registrarse. <b>post</b>Se asigna un
	 * numero de tarjeta de credito al momento del registro del usuario<br>
	 * 
	 * @param lista_usuarios Hace referencia al arraylist de los usuarios ya
	 *                       creados. lista_usuario != null, lista_usuarios != "".
	 * @return El valor de retorno es string representando aquel numero de tarjeta
	 *         creado.
	 */
	public String generarNumeroCuenta(ArrayList<Usuario> lista_usuarios) {
		int M = 10000000;
		int N = 99999999;
		int valor1 = (int) Math.floor(Math.random() * (N - M + 1) + M);
		int valor2 = (int) Math.floor(Math.random() * (N - M + 1) + M);
		String numeroTargeta = Integer.toString(valor1) + Integer.toString(valor2);
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getNumeroTarjeta().equals(numeroTargeta)) {
				valor1 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				valor2 = (int) Math.floor(Math.random() * (N - M + 1) + M);
				numeroTargeta = Integer.toString(valor1) + Integer.toString(valor2);
			}
		}
		return numeroTargeta;
	}

	/**
	 * Este metodo se llama en el momento del registro del usuario para asegurarse
	 * que no se esten ingresado los valores del correo y el alias de un usuario ya
	 * registrado.<b>post</b>Se valida si el usuario ingresado para registrarse ya
	 * se encuentra o no en el sistema<br>
	 * 
	 * @param correo         Es el correo ingresado a la hora del registro. correo
	 *                       != null, correo != "".
	 * @param usuario        Representa el usuario o alias ingresado a la hora del
	 *                       registro. usuario != null, usuario != "".
	 * @param lista_usuarios Es la lista de usuarios ya registrados en el sistema.
	 *                       Es frente a estos que se valida que el nuevo usuario no
	 *                       esta dentro de aquella lista para poder proceder con el
	 *                       correcto registro. lista_usuarios != null,
	 *                       lista_usuario != "".
	 * @return El valor de retorno puede ser verdadero o falso representando la
	 *         validacion de la existencia del nuevo usuario a registrar en el
	 *         sistema.
	 */
	public boolean comprobarExistenciaUsuario(String correo, String usuario, ArrayList<Usuario> lista_usuarios) {
		boolean comprobar = true;

		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getCorreo().equals(correo)
					|| lista_usuarios.get(i).getUsuario().equals(usuario)) {
				comprobar = false;
			}
		}

		return comprobar;
	}

	/**
	 * Este metodo se llama en el momento del registro de una nueva tienda para
	 * asegurarse que no exista otro igual en el sistema.<b>post</b>Se valida si el
	 * usuario ingresado para registrarse ya se encuentra o no en el sistema<br>
	 * 
	 * @param nombre        Es el nombre ingresado a la hora de crear una nueva
	 *                      tienda. nombre != null, nombre != "".
	 * @param direccion     Es la direccion ingresada a la hora de crear una nueva
	 *                      tienda. direccion != null, direccion != "".
	 * @param lista_tiendas Es la lista de tiendas ya registradas en el sistema. Es
	 *                      frente a estos que se valida que la nueva tienda no esta
	 *                      ya inscrita para proceder con la adiccion de ella.
	 *                      lista_tiendas != null, lista_tiendas != "".
	 * @return El valor de retorno puede ser verdadero o falso representando la
	 *         validacion de la existencia de la nueva tienda a registrar en el
	 *         sistema.
	 */
	public boolean comprobarExistenciaTienda(String nombre, String direccion, ArrayList<Tiendas> lista_tiendas) {
		boolean comprobar = true;

		for (int i = 0; i < lista_tiendas.size(); i++) {
			if (lista_tiendas.get(i).getNombre().equals(nombre)
					&& lista_tiendas.get(i).getDireccion().equals(direccion)) {
				comprobar = false;
			}
		}

		return comprobar;
	}

	/**
	 * Este metodo se llama a la hora de la creacion de un nuevo usuario para que se
	 * le envie correctamente un correo de confirmacion y bienvenida. <b>pre</b>Con
	 * anterioridad, se debio de validar que no hayan existencias del nuevo usuario
	 * en el sistema, con el resto de la informacion.<br>
	 * <b>post</b>Se envia el correo al correo ingresado.<br>
	 * 
	 * @param nuevo Este parametro es el nuevo usuario registrado, el cual contiene
	 *              toda la informacion como nombre, correo, alias, entre otros.
	 *              nuevo != null, nuevo != "".
	 */
	public void enviarCorreo(Usuario nuevo) {

		try {

			// creamos y rellenamos la variable propieties
			Properties prop = new Properties();

			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.auth", "true");

			// creamos una instancia de para abrir la sesion
			Session sesion = Session.getDefaultInstance(prop);
			// Datos para enviar
			String correoremitente = "solusoftunbosque@gmail.com";
			String pasremitente = "proyectocorte3";
			String asunto = "SOLUSOFT GRACIAS POR REGISTRARTE";
			String mensaje = "Gracias por confiar en nosotros " + nuevo.getNombre()
					+ " ahora puedes empezar a disfrutar de nuestros servicios: " + "\n" + "\n" + "usuario: "
					+ nuevo.getUsuario() + "\nContraseña: " + nuevo.getContraseña() + "\nNúmero de Tarjeta de Crédito: "
					+ nuevo.getNumeroTarjeta() + "\n" + "\n"
					+ "En caso de no haberlo solicitado, ponte en contacto con nosotros inmediatamente.";

			// CONSTRUIMOS EL CUERPO DEL CORREO
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// CONSTRUIMOS EL ADJUNTO
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("./src/co/edu/unbosque/imagenes/correo.jpg")));
			adjunto.setFileName("CONTACTO");

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);

			// CONSTRUIMOS EL CORREO
			MimeMessage mensajesesion = new MimeMessage(sesion);
			// INDICAMOS EL CORREO DESDE DONDE SE ENVIA
			mensajesesion.setFrom(new InternetAddress(correoremitente));
			// INDICAMOS EL CORREO QUE RECIBE
			mensajesesion.addRecipient(Message.RecipientType.TO, new InternetAddress(nuevo.getCorreo()));
			// INDICAMOS EL ASUNTO
			mensajesesion.setSubject(asunto);
			// INDICAMOS EL CUERPO DEL CORREO
			mensajesesion.setContent(multiParte);
			// CREAMOS INSTANCIA TRANSPORT ENCARGADA DEL ENVIO DEL CORREO
			Transport t = sesion.getTransport("smtp");
			t.connect(correoremitente, pasremitente);
			t.sendMessage(mensajesesion, mensajesesion.getAllRecipients());
			t.close();

		} catch (AddressException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo se llama a la hora de la creacion de un nuevo horario para que se
	 * le envie correctamente un correo de confirmacion. <b>pre</b>Con anterioridad,
	 * ya se debió de registrar el usuario y tener al menos una pareja.<br>
	 * <b>post</b>Se envia el correo al correo guardado.<br>
	 * 
	 * @param usuario Este parametro es el usuario que ha ingresado en la cuenta y
	 *                esta creando un nuevo horario, el cual contiene toda la
	 *                informacion como nombre, correo, alias, entre otros. usuario
	 *                != null, usuario != "".
	 * @param fecha   Representa la fecha del horario creado. fecha != null, fecha
	 *                != "".
	 * @param hora    Representa la hora del horario creado. hora != null, hora !=
	 *                "".
	 * @param pareja  Representa el nombre de la pareja con la cual se ha registrado
	 *                el horario. pareja != null, pareja != "".
	 * @param tienda  Representa el nombre de la tienda registrada en el horario.
	 *                tienda != null, tienda != "".
	 * @param genero  Representa el genero del usuario. genero != null, genero !=
	 *                "".
	 */
	public void enviarCorreoHorario(Usuario usuario, String fecha, String hora, String pareja, String tienda,
			String genero) {

		try {

			// rellenamos la variable propieties
			Properties prop = new Properties();

			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.auth", "true");

			// creamos una instancia de para abrir la sesion
			Session sesion = Session.getDefaultInstance(prop);
			// Datos para enviar
			String correoremitente = "solusoftunbosque@gmail.com";
			String pasremitente = "proyectocorte3";
			String asunto = "Creación de un nuevo horario";
			String mensaje = "";
			if (genero.equals("Mujer")) {
				mensaje = "Señora " + usuario.getNombre() + "\n" + "\n" + "Se ha añadido un nuevo horario en " + tienda
						+ " el dia " + fecha + " a las " + hora + " con " + pareja + "\n" + "\n"
						+ "En caso tal que el horario no te pertenezca agradecemos comunicarte por medio de nuestra línea de atención al"
						+ " cliente o a través de nuestro email de atención, con el fin de brindarte una asesoría inmediata y oportuna"
						+ " de los movimientos realizados con tu cuenta.";
				;
			} else if (genero.equals("Hombre")) {
				mensaje = "Señor " + usuario.getNombre() + "\n" + "\n" + "Se ha añadido un nuevo horario en " + tienda
						+ " el dia " + fecha + " a las " + hora + " con " + pareja + "\n" + "\n"
						+ "En caso tal que el horario no te pertenezca agradecemos comunicarte por medio de nuestra línea de atención al"
						+ " cliente o a través de nuestro email de atención, con el fin de brindarte una asesoría inmediata y oportuna"
						+ " de los movimientos realizados con tu cuenta.";
				;
			}

			// CONSTRUIMOS EL CUERPO DEL CORREO
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// CONSTRUIMOS EL ADJUNTO
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("./src/co/edu/unbosque/imagenes/correo.jpg")));
			adjunto.setFileName("CONTACTO");

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);

			// CONSTRUIMOS EL CORREO
			MimeMessage mensajesesion = new MimeMessage(sesion);
			// INDICAMOS EL CORREO DESDE DONDE SE ENVIA
			mensajesesion.setFrom(new InternetAddress(correoremitente));
			// INDICAMOS EL CORREO QUE RECIBE
			mensajesesion.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getCorreo()));
			// INDICAMOS EL ASUNTO
			mensajesesion.setSubject(asunto);
			// INDICAMOS EL CUERPO DEL CORREO
			mensajesesion.setContent(multiParte);
			// CREAMOS INSTANCIA TRANSPORT ENCARGADA DEL ENVIO DEL CORREO
			Transport t = sesion.getTransport("smtp");
			t.connect(correoremitente, pasremitente);
			t.sendMessage(mensajesesion, mensajesesion.getAllRecipients());
			t.close();

		} catch (AddressException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo se llama a la hora de la creacion de una nueva compra para que se
	 * le envie correctamente un correo de confirmacion. <b>pre</b>Con anterioridad,
	 * ya se debió de registrar el usuario y tener al menos una pareja.<br>
	 * <b>post</b>Se envia el correo al correo guardado.<br>
	 * 
	 * @param usuario     Este parametro es el usuario que ha ingresado en la cuenta
	 *                    y esta creando un nuevo registro de compra, el cual
	 *                    contiene toda la informacion como nombre, correo, alias,
	 *                    entre otros. usuario != null, usuario != "".
	 * @param genero      Representa el genero del usuario. genero != null, genero
	 *                    != "".
	 * @param pareja      Representa el nombre de la pareja con la cual se ha
	 *                    registrado la compra. pareja != null, pareja != "".
	 * @param tienda      Representa el nombre de la tienda registrada en la compra.
	 *                    tienda != null, tienda != "".
	 * @param valorCompra Representa el valor total de la compra. valorCompra !=
	 *                    null, valorCompra != "".
	 */
	public void enviarCorreoCompra(Usuario usuario, String genero, String pareja, String tienda, double valorCompra) {
		try {

			// rellenamos la variable propieties
			Properties prop = new Properties();

			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.auth", "true");

			// creamos una instancia de para abrir la sesion
			Session sesion = Session.getDefaultInstance(prop);
			// Datos para enviar
			String correoremitente = "solusoftunbosque@gmail.com";
			String pasremitente = "proyectocorte3";
			String asunto = "Creación de un nuevo registro de compra";
			String mensaje = "";
			NumberFormat formatoImporte = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

			if (genero.equals("Mujer")) {
				mensaje = "Señora " + usuario.getNombre() + "\n" + "\n"
						+ "Solusoft informa que el día de hoy realizaste un nuevo registro de compra: " + "\n"
						+ "Tienda: " + tienda + "\n" + "Pareja: " + pareja + "\n" + "Total Compra: "
						+ formatoImporte.format(valorCompra) + "\n" + "\n"
						+ "En caso tal que el registro no te pertenezca agradecemos comunicarte por medio de nuestra línea de atención al"
						+ " cliente o a través de nuestro email de atención, con el fin de brindarte una asesoría inmediata y oportuna"
						+ " de los movimientos realizados con tu cuenta.";

			} else if (genero.equals("Hombre")) {
				mensaje = "Señor " + usuario.getNombre() + "\n" + "\n"
						+ "Solusoft informa que el día de hoy realizaste un nuevo registro de compra: " + "\n"
						+ "Tienda: " + tienda + "\n" + "Pareja: " + pareja + "\n" + "Total Compra: "
						+ formatoImporte.format(valorCompra) + "\n" + "\n"
						+ "En caso tal que el registro no te pertenezca agradecemos comunicarte por medio de nuestra línea de atención al"
						+ " cliente o a través de nuestro email de atención, con el fin de brindarte una asesoría inmediata y oportuna"
						+ " de los movimientos realizados con tu cuenta.";

			}

			// CONSTRUIMOS EL CUERPO DEL CORREO
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// CONSTRUIMOS EL ADJUNTO
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("./src/co/edu/unbosque/imagenes/correo.jpg")));
			adjunto.setFileName("CONTACTO");

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);

			// CONSTRUIMOS EL CORREO
			MimeMessage mensajesesion = new MimeMessage(sesion);
			// INDICAMOS EL CORREO DESDE DONDE SE ENVIA
			mensajesesion.setFrom(new InternetAddress(correoremitente));
			// INDICAMOS EL CORREO QUE RECIBE
			mensajesesion.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getCorreo()));
			// INDICAMOS EL ASUNTO
			mensajesesion.setSubject(asunto);
			// INDICAMOS EL CUERPO DEL CORREO
			mensajesesion.setContent(multiParte);
			// CREAMOS INSTANCIA TRANSPORT ENCARGADA DEL ENVIO DEL CORREO
			Transport t = sesion.getTransport("smtp");
			t.connect(correoremitente, pasremitente);
			t.sendMessage(mensajesesion, mensajesesion.getAllRecipients());
			t.close();

		} catch (AddressException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo se llama para darle un valor al atributo cada vez que un usuario
	 * inicia sesion. Esto quiere decir que esta valor cambia frente al usuario y a
	 * // * las acciones hecha por este.<b>post</b>Se asigna un valor al atributo en
	 * una instancia inicial.<br>
	 * 
	 * @param valorCupo Este parametro hace referencia al valor cuantitiativo que
	 *                  tiene el cupo en una instancia inicial. valorCupo != null,
	 *                  valorCupo != "".
	 */
	public void valorCupo(int valorCupo) {
		this.valorCupo = valorCupo;
	}

	/**
	 * Este metodo se llama para darle un valor al atributo cada vez que un usuario
	 * inicia sesion. Esta variable hace referencia al cupo restante que tiene el
	 * usuario, al ir reduciendose cada vez que agrega una nueva
	 * pareja.<b>post</b>Se asigna un valor al atributo en una instancia
	 * inicial.<br>
	 * 
	 * @param valorVariable Este parametro hace referencia al cupo restante que
	 *                      tiene el usuario. valorVariable != null, valorVariable
	 *                      != "".
	 */
	public void valorVariable(double valorVariable) {
		this.valorVariable = valorVariable;
	}

	/**
	 * Este metodo devuelve el valor del atributo correspondiente al alias del
	 * usuario que acabó de ingresar al sistema. <b>post</b>Se devuelve el valor
	 * guardado en el atributo.<br>
	 * 
	 * @return Retorna el usuario o alias en formato de cadena de caracteres.
	 */
	public String getUsuario_inicio() {
		return usuario_inicio;
	}

	/**
	 * Este metodo establece el valor del atributo correspondiente al alias del
	 * usuario que acabó de ingresar al sistema. <b>post</b>Se fija un nuevo valor
	 * al atributo.<br>
	 * 
	 * @param usuario_inicio Este parametro representa el nuevo valor en formato de
	 *                       cadena de caracteres que va a tener el alias del
	 *                       usuario. usuario_inicio != null, usuario_inicio != "".
	 */
	public void setUsuario_inicio(String usuario_inicio) {
		this.usuario_inicio = usuario_inicio;
	}

	/**
	 * Este metodo devuelve el valor del cupo. <b>post</b>Se devuelve el valor
	 * guardado en el atributo.<br>
	 * 
	 * @return Retorna el valor del cupo disponible en formato entero.
	 */
	public int getValorCupo() {
		return valorCupo;
	}

	/**
	 * Este metodo establece el valor del cupo. <b>post</b>Se fija un nuevo valor al
	 * atributo.<br>
	 * 
	 * @param valorCupo Este parametro representa el nuevo valor en formato entero
	 *                  que va a tener el cupo del usuario que acabo de ingresar en
	 *                  su cuenta. valorCupo != null, valorCupo != "".
	 */
	public void setValorCupo(int valorCupo) {
		this.valorCupo = valorCupo;
	}

	/**
	 * Este metodo devuelve el valor del cupo restante. <b>post</b>Se devuelve el
	 * valor guardado en el atributo.<br>
	 * 
	 * @return Retorna el cupo restante en formato de cadena de caracteres.
	 */
	public double getValorVariable() {
		return valorVariable;
	}

	/**
	 * Este metodo establece el valor del cupo restante del usuario. <b>post</b>Se
	 * fija un nuevo valor al atributo.<br>
	 * 
	 * @param valorVariable Este parametro representa el nuevo valor en formato
	 *                      double que va a tener el cupo restante del que acabo de
	 *                      ingresar en su cuenta. valorVariable != null,
	 *                      valorVariable != "".
	 */
	public void setValorVariable(double valorVariable) {
		this.valorVariable = valorVariable;
	}

}
