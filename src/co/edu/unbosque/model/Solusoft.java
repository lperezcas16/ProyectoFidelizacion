package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Solusoft {

	public Solusoft() {

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

	public void enviarCorreo(Usuario nuevo) {
		

		try {

			Properties prop = new Properties();
			prop.setProperty("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.auth", "true");

			Session sesion = Session.getDefaultInstance(prop);
			// correo que envia
			String correoremitente = "solusoftunbosque@gmail.com";
			String pasremitente = "proyectocorte3";

			String asunto = "Bienvenido a SOLUSOFT!";
			String mensaje = "Gracias por registrarse " + nuevo.getNombre() + "\n" + "usuario: " + nuevo.getUsuario()
					+ "\nContraseña: " + nuevo.getContraseña() + "\nNumero de tarjeta: " + nuevo.getNumeroTarjeta()
					+ "\nCupo actual de su tarjeta credito: " + nuevo.getCupoTarjeta();

			MimeMessage mensajesesion = new MimeMessage(sesion);

			mensajesesion.setFrom(new InternetAddress(correoremitente));

			mensajesesion.addRecipient(Message.RecipientType.TO, new InternetAddress(nuevo.getCorreo()));
			mensajesesion.setSubject(asunto);
			mensajesesion.setText(mensaje);

			Transport t = sesion.getTransport("smtp");
			t.connect(correoremitente, pasremitente);
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

}
