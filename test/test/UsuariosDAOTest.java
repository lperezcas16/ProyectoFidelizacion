package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;
import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.Parejas;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.UsuarioDAO;

public class UsuariosDAOTest extends TestCase {

	File file = new File(".\\dataTest\\baseDatosUsuariosTest.out");
	UsuarioDAO usuarios;
	ArchivoUsuario archivo_usuarios;
	ArrayList<Usuario> lista_usuarios;
	ArrayList<Parejas> lista_parejas;
	ArrayList<Compra> lista_compras;
	Usuario usuario1, usuario2;

	public void setupEscenario() throws FileNotFoundException {
		archivo_usuarios = new ArchivoUsuario(file);
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista_usuarios = new ArrayList<Usuario>();
		usuarios = new UsuarioDAO(archivo_usuarios);
		lista_parejas = new ArrayList<Parejas>();
		lista_compras = new ArrayList<Compra>();
		usuario1 = new Usuario("Juan", "Hombre", "correo", "juan", "12345678",
				"1253745328735672385632", 19, 0, lista_parejas, "Usuario",
				lista_compras);
		usuario2 = new Usuario("Pablo", "Hombre", "correo", "CorreoPablo",
				"agseyrvgrf", "125374534386585632", 25, 0, lista_parejas,
				"Usuario", lista_compras);
		lista_usuarios.add(usuario1);
		lista_usuarios.add(usuario2);
		archivo_usuarios.escribirEnArchivo(lista_usuarios);
	}

	public void testUsuarioDAO() throws FileNotFoundException {
		setupEscenario();

		assertEquals("La cantidad de usuarios debe ser 2", 2,
				lista_usuarios.size());
	}

	public void testAgregarUsuario() throws FileNotFoundException {
		setupEscenario();
		usuarios.agregarUsuario("Ana", "Mujer", "correo", "ana", "098765432",
				"12356247581745392107", 0, lista_parejas, lista_compras,
				"Usuario", 22, lista_usuarios);

		assertEquals(
				"Se agrega otro usuario y la cantidad de usuarios debe ser 3",
				3, lista_usuarios.size());

	}

	public void testBuscarUsuario() throws FileNotFoundException {

		setupEscenario();

		assertEquals("Se encuentra al usuario con nombre Juan", "Juan",
				usuarios.buscarUsuario(usuario1.getUsuario(), lista_usuarios)
						.getNombre());
	}

	public void testEliminarUsuario() throws FileNotFoundException {
		setupEscenario();
		usuarios.eliminarUsuario(usuario1.getUsuario(), lista_usuarios);
		assertEquals("La cantidad de jugadores debe ser 1", 1,
				lista_usuarios.size());
	}

	public void testExistenciaArchivo() throws FileNotFoundException {
		setupEscenario();
		assertTrue("El archivo existe", file.exists());
	}

	public void testEscribirArchivo() throws IOException {
		setupEscenario();
		file.delete();
		file.createNewFile();
		usuarios.agregarUsuario("Ana", "Mujer", "correo", "ana", "098765432",
				"12356247581745392107", 0, lista_parejas, lista_compras,
				"Usuario", 22, lista_usuarios);
		boolean vacio = false;
		if (file.length() != 0) {
			vacio = true;
		}
		assertEquals("El programa puede escribir en el archivo", true,
				file.canWrite());
		assertEquals("El archivo no esta vacio", true, vacio);
	}

	public void testLeerArchivo() throws IOException {
		setupEscenario();
		assertEquals("El programa puede leer el archivo", true, file.canRead());
	}

	public void testComprobarUsuario() throws FileNotFoundException {
		setupEscenario();
		assertTrue(
				"El programa puede encontrar el usuario",
				usuarios.comprobarUsuario(usuario1.getUsuario(),
						usuario1.getContraseña(), lista_usuarios));
	}

	public void testAgregarPareja() throws FileNotFoundException {
		setupEscenario();
		usuarios.agregarParejas(usuario2.getUsuario(), "Pareja1", 0, 0, 0, 19,
				lista_usuarios);
		assertEquals(
				"El programa puede verificar que el usuario 2 tiene 1 pareja",
				1, lista_usuarios.get(1).getParejas().size());
	}

	public void testAgregarCompra() throws FileNotFoundException {
		setupEscenario();
		usuarios.agregarParejas(usuario1.getUsuario(), "Pareja", 0, 500, 500,
				19, lista_usuarios);
		usuarios.agregarCompras(usuario1.getUsuario(), usuario1.getParejas()
				.get(0).getNombre(), "Tiendita", 200);
		lista_usuarios = archivo_usuarios.leerArchivo();
		assertEquals(
				"El programa puede verificar que el usuario realizo una compra y se le descontaron 200 a la pareja",
				300.0, lista_usuarios.get(0).getParejas().get(0)
						.getCantidad_cupo_restante());
	}

	public void testAgregarHorarioCompra() throws FileNotFoundException {
		setupEscenario();
		Tiendas tienda = new Tiendas("Tiendita", "Cra 3", "08:00", "16:00");
		usuarios.agregarParejas(usuario2.getUsuario(), "Pareja", 0, 500, 500,
				19, lista_usuarios);
		assertTrue(
				"El programa verifica que se haya podido agregar el horario de compra",
				usuarios.agregarHorariosCompras(usuario2.getUsuario(), tienda,
						usuario2.getParejas().get(0).getNombre(), "26-08-2020",
						"10:00"));

	}
}
