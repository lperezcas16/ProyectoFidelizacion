package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;
import co.edu.unbosque.model.Tiendas;
import co.edu.unbosque.model.persistence.ArchivoTienda;
import co.edu.unbosque.model.persistence.TiendaDAO;

public class TiendaDAOTest extends TestCase {

	File file = new File(".\\dataTest\\baseDatosTiendasTest.out");
	TiendaDAO tiendas;
	ArchivoTienda archivo_tienda;
	Tiendas tienda1, tienda2;
	ArrayList<Tiendas> lista_tiendas;

	public void setupEscenario() throws FileNotFoundException {
		archivo_tienda = new ArchivoTienda(file);
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lista_tiendas = new ArrayList<Tiendas>();
		tiendas = new TiendaDAO(archivo_tienda);
		tienda1 = new Tiendas("Tiendita", "Cra 3", "07:00", "16:00");
		tienda2 = new Tiendas("Tienda", "Cra 58 #2", "09:00", "23:00");
		lista_tiendas.add(tienda1);
		lista_tiendas.add(tienda2);
		archivo_tienda.escribirEnArchivo(lista_tiendas);
	}

	/**
	 * @throws FileNotFoundException La excepcion se compone en que si no se
	 *                               encuentra un archivo, entonces salta la
	 *                               excepcion.
	 */
	public void testUsuarioDAO() throws FileNotFoundException {
		setupEscenario();

		assertEquals("La cantidad de tiendas debe ser 2", 2, lista_tiendas.size());
	}

	public void testAgregarTienda() throws FileNotFoundException {
		setupEscenario();
		assertTrue(tiendas.agregarTienda("D1", "Calle 9", "08:00", "20:30", lista_tiendas));
		assertEquals("Se agrega otra tienda y la cantidad de tiendas debe ser 3", 3, lista_tiendas.size());
	}

	public void testEliminarTienda() throws FileNotFoundException {
		setupEscenario();
		tiendas.eliminarTienda(tienda1.getNombre(), lista_tiendas);
		assertEquals("La cantidad de tiendas debe ser 1", 1, lista_tiendas.size());
	}

	public void testExistenciaArchivo() throws FileNotFoundException {
		setupEscenario();
		assertTrue("El archivo existe", file.exists());
	}

	public void testEscribirArchivo() throws IOException {
		setupEscenario();
		file.delete();
		file.createNewFile();
		tiendas.agregarTienda("D1", "Calle 9", "08:00", "20:30", lista_tiendas);
		boolean vacio = false;
		if (file.length() != 0) {
			vacio = true;
		}
		assertEquals("El programa puede escribir en el archivo", true, file.canWrite());
		assertEquals("El archivo no esta vacio", true, vacio);
	}

	public void testLeerArchivo() throws IOException {
		setupEscenario();
		assertEquals("El programa puede leer el archivo", true, file.canRead());
	}

}
