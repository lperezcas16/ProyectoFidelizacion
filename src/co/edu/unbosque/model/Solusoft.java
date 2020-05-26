package co.edu.unbosque.model;

import java.util.ArrayList;
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

	public Solusoft(String usuario_Inicio) {
		usuario_inicio = usuario_Inicio;
	}

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

	public void enviarCorreo(Usuario nuevo) {

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
			String asunto = "SOLUSOFT GRACIAS POR REGISTRARTE";
			String mensaje = "Gracias por confiar en nosotros " + nuevo.getNombre()
					+ " ahora puedes empezar a disfrutar de nuestros servicios: " + "\n" + "usuario: "
					+ nuevo.getUsuario() + "\nContraseña: " + nuevo.getContraseña() + "\nTarjeta de credito numero: "
					+ nuevo.getNumeroTarjeta();

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
			// multiParte.addBodyPart(adjunto);

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
				mensaje = "Señora " + usuario.getNombre() + "\n" + "Se ha añadido un nuevo horario en " + tienda
						+ " el dia " + fecha + " a las " + hora + " con " + pareja;
			} else if (genero.equals("Hombre")) {
				mensaje = "Señor " + usuario.getNombre() + "\n" + "Se ha añadido un nuevo horario en " + tienda
						+ " el dia " + fecha + " a las " + hora + " con " + pareja;
			}

			// CONSTRUIMOS EL CUERPO DEL CORREO
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			// CONSTRUIMOS EL ADJUNTO
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("/co/edu/unbosque/imagenes/Correo.jpg")));
			adjunto.setFileName("CONTACTO");

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			// multiParte.addBodyPart(adjunto);

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
			t.sendMessage(mensajesesion, mensajesesion.getRecipients(Message.RecipientType.TO));
			t.close();

		} catch (AddressException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	public void valorCupo(int valorCupo) {
		this.valorCupo = valorCupo;
	}

	public void valorVariable(double valorVariable) {
		this.valorVariable = valorVariable;
	}

	public String getUsuario_inicio() {
		return usuario_inicio;
	}

	public void setUsuario_inicio(String usuario_inicio) {
		this.usuario_inicio = usuario_inicio;
	}

	public int getValorCupo() {
		return valorCupo;
	}

	public void setValorCupo(int valorCupo) {
		this.valorCupo = valorCupo;
	}

	public double getValorVariable() {
		return valorVariable;
	}

	public void setValorVariable(double valorVariable) {
		this.valorVariable = valorVariable;
	}

}
