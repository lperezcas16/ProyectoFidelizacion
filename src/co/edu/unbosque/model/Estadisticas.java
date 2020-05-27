package co.edu.unbosque.model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Estadisticas {

	
	/**
	 * Este metodo  genera la gráfica con los dato obtenidos del controlador 
	 *  <b>post</b> se genéra el gráfico con los datos recibidos  <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca en la lista  para luego
	 * buscar su edad   != "".
	 */
	
	public DefaultPieDataset generarDatosGraficoEdadUsuarios(ArrayList<Usuario> lista_usuarios) {
		DefaultPieDataset data = new DefaultPieDataset();

		ArrayList<Integer> lista_edad = new ArrayList<Integer>();
		for (int i = 0; i < lista_usuarios.size(); i++) {
			lista_edad.add(i, lista_usuarios.get(i).getEdad());
		}
		ArrayList<Integer> lista_datos = new ArrayList<Integer>();
		ArrayList<Integer> numElementosDato = new ArrayList<Integer>();
		for (int i = 0; i < lista_edad.size(); i++) {
			lista_datos.add(i, lista_edad.get(i));
		}
		Set<Integer> hasSet = new HashSet<Integer>(lista_datos);
		lista_datos.clear();
		lista_datos.addAll(hasSet);
		for (int i = 0; i < lista_datos.size(); i++) {
			numElementosDato.add(i, Collections.frequency(lista_edad, lista_datos.get(i)));

		}
		int[][] matriz = new int[lista_datos.size()][2];
		for (int i = 0; i < lista_datos.size(); i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					matriz[i][j] = lista_datos.get(i);
				} else if (j == 1) {
					matriz[i][j] = numElementosDato.get(i);
				}
			}
		}
		for (int i = 0; i < matriz.length; i++) {
			data.setValue(String.valueOf(matriz[i][0]), matriz[i][1]);
		}
		return data;
	}

	/**
	 * Este metodo  genera la gráfica con los dato obtenidos del controlador 
	 *  <b>post</b> se genéra el gráfico con los datos recibidos  <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca en la lista  para luego
	 * 						buscar su genero   != "".
	 */
	public DefaultCategoryDataset generarDatosGraficoGeneroUsuarios(ArrayList<Usuario> lista_usuarios) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		int cantidadMujeres = 0;
		int cantidadHombres = 0;
		for (int i = 0; i < lista_usuarios.size(); i++) {
			if (lista_usuarios.get(i).getGenero().equals("Mujer")) {
				cantidadMujeres++;
			} else {
				cantidadHombres++;
			}
		}
		data.setValue(cantidadMujeres, "MUJERES", "");
		data.setValue(cantidadHombres, "HOMBRES", "");

		return data;
	}

	/**
	 * Este metodo  genera el pdf de las tablas y los gráficos generados anteriormente
	 *  <b>post</b> se genéra el gráfico con los datos recibidos  <br>
	 * 
	 * @param tituloInicio Este parametro representa el titulo que se  le asigna al pdf   != "".
	 * 
	 *  @param titulo_grafico Este parametro representa el titulo que se pone al gráfico   != "".
	 * 
	 *  @param informacion Este parametro representa la informacion que contiene el pdf != "".
	 *  
	 * *@param chart Este parametro representa la gráfica que se visualiza en el pdf != "".
	 * 
	 * @param salida Este parametro representa la salida de los datos para el pdf   != "".
	 * 
	 * @param jTable Este parametro representa las tablas que se agregan al pdf  != "".
	 * 
	 * 
	 * 
	 */
	public void generarPDF(String tituloInicio, String titulo_grafico, String informacion, JFreeChart chart,
			String salida, JTable jTable) {
		try {
			String rutaDeAlmacenamiento = salida;
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			File file = new File(".\\data\\grafico.jpeg");

			ChartUtilities.saveChartAsJPEG(file, chart, 600, 600, info);
			Document document = new Document(PageSize.A4, 40, 40, 30, 30);
			PdfWriter.getInstance(document, new FileOutputStream(rutaDeAlmacenamiento + ".pdf"));
			PdfPTable table = new PdfPTable(jTable.getColumnCount());
			PdfPCell columnHeader;
			for (int column = 0; column < jTable.getColumnCount(); column++) {
				columnHeader = new PdfPCell(new Phrase(jTable.getColumnName(column)));
				columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(columnHeader);
			}
			table.setHeaderRows(1);
			for (int row = 0; row < jTable.getRowCount(); row++) {
				for (int column = 0; column < jTable.getColumnCount(); column++) {
					table.addCell(jTable.getValueAt(row, column).toString());
				}
			}
			document.open();
			document.add(getTitulo(tituloInicio));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			Image imagen = Image.getInstance(".\\data\\grafico.jpeg");
			imagen.scaleAbsolute(400, 400);
			imagen.setAlignment(Element.ALIGN_CENTER);
			document.add(getTitulo(titulo_grafico));
			document.add(imagen);
			document.add(Chunk.NEWLINE);
			document.add(getInformacion(informacion));
			document.addAuthor("Solusoft");
			document.addCreator("Solusoft");
			document.close();
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	/**
	 * Este metodo  genera el titulo con los dato obtenidos del controlador 
	 *  <b>post</b> se genéra el titulo con los datos recibidos  <br>
	 * 
	 * @param texto Este parametro representa el texto que se va a poner en pdf  != "".
	 */
	private Paragraph getTitulo(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_CENTER);
		c.append(texto);
		Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLUE);
		c.setFont(fuente);
		p.add(c);
		return p;
	}
	/**
	 * Este metodo  genera el text con los dato obtenidos del controlador 
	 *  <b>post</b> se genéran los datos según la especificaciones <br>
	 * 
	 * @param texto Este parametro representa el texto que se va a poner en pdf  != "".
	 */
	private Paragraph getInformacion(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		c.append(texto);
		Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
		c.setFont(fuente);
		p.add(c);
		return p;
	}
	/**
	 * Este metodo  genera el pdf con las edades  obtenidas
	 *  <b>post</b> se genéra el pdf que contiene la gráfica de las edades y se abre un filechooser para 
	 *  guardar el documento pdf <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca  != "".
	 * 
	 * @param chart Este parametro representa la gráfica a poner en pdf  != "".
	 * 
	 * @param fileChooserGuardar Este parametro representa el archivo que se guardará pdf  != "".
	 * 
	 *  @param jtable Este parametro representa la tabla que se va a poner en pdf  != "".
	 */
	public void generarPDFEdadesUsuarios(ArrayList<Usuario> lista_usuarios, JFreeChart chart, String fileChooserGuardar,
			JTable jtable) {
		String informacion = "\n"
				+ "Las estadisticas de los usuarios que se encuentran registrados son las siguientes: " + "\n"
				+ "Media: " + calcularMedia(lista_usuarios) + "\n" + "Moda: " + calcularModa(lista_usuarios) + "\n"
				+ "Mediana: " + calcularMediana(lista_usuarios);
		generarPDF("Estadisticas de la edad de los usuarios", "Estadisticas", informacion, chart, fileChooserGuardar,
				jtable);
	}

	/**
	 * Este metodo  genera el pdf con los usuarios  obtenidas
	 *  <b>post</b> se genéra el pdf que contiene la gráfica de los  usuarios  y se abre un filechooser para 
	 *  guardar el documento pdf <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca  != "".
	 * 
	 * @param chart Este parametro representa la gráfica a poner en pdf  != "".
	 * 
	 * @param fileChooserGuardar Este parametro representa el archivo que se guardará pdf  != "".
	 * 
	 *  @param jtable Este parametro representa la tabla que se va a poner en pdf  != "".
	 */
	public void generarPDFUsuarios(ArrayList<Usuario> lista_usuarios, JFreeChart chart, String fileChooserGuardar,
			JTable jtable) {
		generarPDF("Reporte de usuarios", "Grafico de genero", "", chart, fileChooserGuardar, jtable);
	}
	/**
	 * Este metodo  genera uncalculo de las edades de los usuarios para buscar la moda
	 *  <b>post</b> Se en cuentra la moda de la edad de todos los usuarios  <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca  != "".

	 */
	private int calcularModa(ArrayList<Usuario> lista_usuarios) {
		ArrayList<Integer> lista_edad = new ArrayList<Integer>();

		for (int i = 0; i < lista_usuarios.size(); i++) {
			lista_edad.add(i, lista_usuarios.get(i).getEdad());
		}
		int moda = 0;
		int conteoMaximo = 0;

		for (int i = 0; i < lista_edad.size(); ++i) {
			int conteo = 0;
			for (int j = 0; j < lista_edad.size(); ++j) {
				if (lista_edad.get(j) == lista_edad.get(i))
					++conteo;
			}
			if (conteo > conteoMaximo) {
				conteoMaximo = conteo;
				moda = lista_edad.get(i);
			}
		}

		return moda;
	}
	/**
	 * Este metodo  genera uncalculo de las edades de los usuarios para buscar la mediana
	 *  <b>post</b> Se en cuentra la mediana de la edad de todos los usuarios  <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca  != "".

	 */
	private Double calcularMediana(ArrayList<Usuario> lista_usuarios) {
		ArrayList<Integer> lista_edad = new ArrayList<Integer>();
		Double mediana = 0.0;
		for (int i = 0; i < lista_usuarios.size(); i++) {
			lista_edad.add(i, lista_usuarios.get(i).getEdad());
		}
		if (lista_edad.size() % 2 == 0) {
			int suma = lista_edad.get(lista_edad.size() / 2) + lista_edad.get((lista_edad.size() / 2) - 1);
			mediana = (double) (suma / 2);
		} else {
			mediana = Double.valueOf(lista_edad.get(lista_edad.size() / 2));
		}
		return mediana;
	}

	/**
	 * Este metodo  genera uncalculo de las edades de los usuarios para buscar la media
	 *  <b>post</b> Se en cuentra la media de la edad de todos los usuarios  <br>
	 * 
	 * @param lista_usuarios Este parametro representa el usuario que se busca  != "".

	 */
	private double calcularMedia(ArrayList<Usuario> lista_usuarios) {
		int sumaEdades = 0;
		double media = 0;
		ArrayList<Integer> lista_edad = new ArrayList<Integer>();
		for (int i = 0; i < lista_usuarios.size(); i++) {
			lista_edad.add(i, lista_usuarios.get(i).getEdad());
		}
		for (int i = 0; i < lista_edad.size(); i++) {
			sumaEdades += lista_edad.get(i);
		}
		media = sumaEdades / lista_edad.size();
		return media;
	}

}
