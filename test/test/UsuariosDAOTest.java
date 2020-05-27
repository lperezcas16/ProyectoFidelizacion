package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;
import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.Parejas;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.ArchivoUsuario;
import co.edu.unbosque.model.persistence.UsuarioDAO;

public class UsuariosDAOTest extends TestCase {

	File file = new File(".\\dataTest\\baseDatosTest.out");
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
		usuario2 = new Usuario("Pitufo", "Hombre", "correo", "papaPitufo",
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

		assertEquals("La cantidad de usuarios debe ser 3", 3,
				lista_usuarios.size());

	}

	public void testBuscarUsuario() throws FileNotFoundException {

		setupEscenario();

		assertEquals("Juan",
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
		assertTrue(file.exists());
	}

	public void testEscribirArchivo() throws IOException {
		setupEscenario();
		file.delete();
		file.createNewFile();
		usuarios.agregarUsuario("Ana", "Mujer", "correo", "ana", "098765432",
				"12356247581745392107", 0, lista_parejas, lista_compras,
				"Usuario", 22, lista_usuarios);
		boolean vacio = true;
		if (file.length() != 0) {
			vacio = false;
		}
		assertEquals(true, file.canWrite());
		assertEquals(false, vacio);
	}

	public void testLeerArchivo() throws IOException {
		setupEscenario();
		assertEquals(true, file.canRead());

	}

	public void testComprobarUsuario() throws FileNotFoundException {
		setupEscenario();

	}

	public void testAgregarPareja() {

	}

	public void testAgregarCompra() {

	}

	public void testAgregarHorarioCompra() {

	}
}
