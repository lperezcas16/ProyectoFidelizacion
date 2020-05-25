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
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Estadisticas {

	public int numInscritos(ArrayList<Usuario> usuario, String filtro) {
		int numIns = 0;
		for (int i = 0; i < usuario.size(); i++) {
			if (usuario.get(i).getNombre().equals(filtro)) {
				numIns++;
			} else if (filtro.equals("TOTAL")) {
				numIns++;
			} else {

			}
		}

		return numIns;
	}

	@SuppressWarnings("unused")
	public List<Integer> calcularModa(int[] numeros) {

		int c = 0;
		int veces = 0;
		int conteoMayor = 0;
		List<Integer> acumulado = new ArrayList<>();

		for (int j = 0; j <= 9; j++) {
			c = 0;
			for (int k = 0; k < numeros.length; k++) {

				if (j == numeros[k]) {
					c++;
				}
			}

			if (veces <= c) {
				veces = c;
				if (c > 1 && c < numeros.length) {
					if (acumulado.size() == 0
							|| (conteoMayor > 0 && conteoMayor == c)) {
						conteoMayor = c;
						acumulado.add(j);
					} else if (conteoMayor < c) {
						conteoMayor = c;
						acumulado.clear();
						acumulado.add(j);
					}
				}
			}
		}

		return acumulado;
	}

	public String calcularMedia(int[] numeros) {
		double valor = 0;
		String result = "(";
		for (int numero : numeros) {
			valor += (numero * 1.0);
			result += numero + " + ";
		}
		result = result.substring(0, result.length() - 2);
		result += ")/" + numeros.length + " = " + valor / numeros.length;

		return result;
	}

	public String calcularMediana(int[] numeros) {

		// Ordenamos los numeros de menor a mayor
		Arrays.sort(numeros);

		String result;

		if (numeros.length % 2 == 0) {
			int pos = (numeros.length - 2) / 2;
			result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
		} else {
			int pos = (numeros.length - 1) / 2;
			result = "" + numeros[pos];
		}

		return result;
	}

	/**/
	public double[] porcentajeRango(ArrayList<Usuario> usuarios, String filtro) {
		double porRan[] = new double[6];
		double aux = 0;
		double aux2 = 0;
		double aux3 = 0;
		double aux4 = 0;
		double aux5 = 0;
		double aux6 = 0;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNombre().equals(filtro)) {
				if (usuarios.get(i).getEdad() >= 18
						&& usuarios.get(i).getEdad() <= 25) {
					aux++;
				}
				if (usuarios.get(i).getEdad() >= 26
						&& usuarios.get(i).getEdad() <= 29) {
					aux2++;
				}
				if (usuarios.get(i).getEdad() >= 30
						&& usuarios.get(i).getEdad() <= 37) {
					aux3++;
				}
				if (usuarios.get(i).getEdad() >= 38
						&& usuarios.get(i).getEdad() <= 49) {
					aux4++;
				}
				if (usuarios.get(i).getEdad() >= 50
						&& usuarios.get(i).getEdad() <= 66) {
					aux5++;
				}
				if (usuarios.get(i).getEdad() >= 67) {
					aux6++;
				}
			} else {
				if (filtro.equals("TOTAL")) {
					if (usuarios.get(i).getEdad() >= 18
							&& usuarios.get(i).getEdad() <= 25) {
						aux++;
					}
					if (usuarios.get(i).getEdad() >= 26
							&& usuarios.get(i).getEdad() <= 29) {
						aux2++;
					}
					if (usuarios.get(i).getEdad() >= 30
							&& usuarios.get(i).getEdad() <= 37) {
						aux3++;
					}
					if (usuarios.get(i).getEdad() >= 38
							&& usuarios.get(i).getEdad() <= 49) {
						aux4++;
					}
					if (usuarios.get(i).getEdad() >= 50
							&& usuarios.get(i).getEdad() <= 66) {
						aux5++;
					}
					if (usuarios.get(i).getEdad() >= 67) {
						aux6++;
					}
				} else {

				}
			}
		}
		porRan[0] = (aux / usuarios.size()) * 100;
		porRan[1] = (aux2 / usuarios.size()) * 100;
		porRan[2] = (aux3 / usuarios.size()) * 100;
		porRan[3] = (aux4 / usuarios.size()) * 100;
		porRan[4] = (aux5 / usuarios.size()) * 100;
		porRan[5] = (aux6 / usuarios.size()) * 100;
		return porRan;
	}

	public DefaultPieDataset generarDatosGraficoEdadUsuarios(
			ArrayList<Usuario> lista_usuarios) {
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
			numElementosDato.add(i,
					Collections.frequency(lista_edad, lista_datos.get(i)));

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

	public void generarPDF(String titulo, String informacion,
			String mensajeFinal, JFreeChart chart, String salida, JTable jTable) {
		try {
			String rutaDeAlmacenamiento = salida;
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			File file = new File(".\\data\\grafico.jpeg");

			ChartUtilities.saveChartAsJPEG(file, chart, 600, 600, info);
			Document document = new Document(PageSize.A4, 40, 40, 30, 30);
			PdfWriter.getInstance(document, new FileOutputStream(salida
					+ ".pdf"));
			PdfPTable table = new PdfPTable(jTable.getColumnCount());

			PdfPCell columnHeader;
			for (int column = 0; column < jTable.getColumnCount(); column++) {
				columnHeader = new PdfPCell(new Phrase(
						jTable.getColumnName(column)));
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
			document.add(getTitulo(titulo));
			document.add(table);
			Image imagen = Image.getInstance(".\\data\\grafico.jpeg");
			imagen.scaleAbsolute(400, 400);
			imagen.setAlignment(Element.ALIGN_CENTER);
			document.add(imagen);
			document.add(getInformacion(informacion));
			document.add(getMensajeFinal(mensajeFinal));
			document.close();
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	private Paragraph getTitulo(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_CENTER);
		c.append(texto);
		Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
		c.setFont(fuente);
		p.add(c);
		return p;
	}

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

	private Paragraph getMensajeFinal(String texto) {
		Paragraph p = new Paragraph();
		Chunk c = new Chunk();
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		c.append(texto);
		Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);
		c.setFont(fuente);
		p.add(c);
		return p;
	}

	public void generarPDFEdadesUsuarios(ArrayList<Usuario> lista_usuarios,
			JFreeChart chart, String fileChooserGuardar,JTable jtable) {
		String mensajeFinal = "Solusoft";
		String informacion = "\n"
				+ "Las estadisticas de los usuarios que se encuentran registrados son las siguientes: "
				+ "\n" + "Media: " + calcularMedia(lista_usuarios) + "\n"
				+ "Moda: " + calcularModa(lista_usuarios) + "\n" + "Mediana: "
				+ calcularMediana(lista_usuarios);
		generarPDF("Estadisticas de la edad de los usuarios", informacion,
				mensajeFinal, chart, fileChooserGuardar, jtable);
	}

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

	private Double calcularMediana(ArrayList<Usuario> lista_usuarios) {
		ArrayList<Integer> lista_edad = new ArrayList<Integer>();
		Double mediana = 0.0;
		for (int i = 0; i < lista_usuarios.size(); i++) {
			lista_edad.add(i, lista_usuarios.get(i).getEdad());
		}
		if (lista_edad.size() % 2 == 0) {
			int suma = lista_edad.get(lista_edad.size() / 2)
					+ lista_edad.get((lista_edad.size() / 2) - 1);
			mediana = (double) (suma / 2);
		} else {
			mediana = Double.valueOf(lista_edad.get(lista_edad.size() / 2));
		}
		return mediana;
	}

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
