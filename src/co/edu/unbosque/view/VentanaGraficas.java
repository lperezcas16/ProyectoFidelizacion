package co.edu.unbosque.view;


import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class VentanaGraficas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel, panel2, panelAux;
	public JScrollPane scrollPane;

	/**
	 * 
	 * Este es el metodo constructor el cual se le asigna la inicialización de los
	 * atributos y objectos. De esta manera el objecto es creado con un valor
	 * inicial. Este método se llama automaticamente cuando se crea el objeto.
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 */
	public VentanaGraficas(){
		
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		inicializarComponentes();
	}
	
	
	
	/**
	 * Este es el metodo inicializarComponentes el cual se inicianilizan los componentes
	 *  De esta manera cada componente se crea con una ubicacion, u se le agregar una imagen si es el caso
	 *   y se agrega el panel 
	 *  Este método se llama automaticamente cuando se crea el objeto de la ventana  
	 * <b>post</b>se hacen visibles los componentes del la ventana y se le agregan los paneles .<br>
	 */
	public void inicializarComponentes(){
		panel= new JPanel();
	
		panelAux= new JPanel();
		scrollPane= new JScrollPane();
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		getContentPane().add(panel);
	
		getContentPane().add(scrollPane);
	}
	
	/**
	 * Este es el metodo agregarGrafico el cual se ponen los gráficos en el panel 
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param panel  se agregar el panel != "".
	 */
	public void agregarGraficos(ChartPanel panel){
		this.panel.add(panel);
	
		panelAux.setLayout(new FlowLayout());
		panelAux.add(this.panel);
		
		scrollPane.setViewportView(panelAux);
	}


	/**
	 * Este es el metodo generarGraficoTorta el cual se ponen los gráficos en el panel 
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	
	 * @param titulo se le pone un titulo al gráfico de tortas  != "".
	 * 
	 * @param data Se le asignan los datos que van a estar en el gráfico != "".
	 */
	public JFreeChart generarGraficoTorta(String titulo,DefaultPieDataset data) {
		JFreeChart chart = ChartFactory.createPieChart(titulo, data, true,
				true, true);
		ChartPanel panel_Grafico = new ChartPanel(chart);
		panel_Grafico.setBounds(0, 0, 694, 471);
		panel_Grafico.setVisible(true);
		getContentPane().add(panel_Grafico);
		return chart; 
	}
	/**
	 * Este es el metodo generarGraficoBarras el cual se ponen los gráficos en el panel 
	 * <b>post</b>Se llama al método y se le asignan los datos para mostrar la gráfica con ellos .<br>
	
	 * @param titulo se le pone un titulo al gráfico de tortas  != "".
	 * 
	 * @param data Se le asignan los datos que van a estar en el gráfico != "".
	 * 
	 * @param ejeX Se le asigna la coordenada en el eje x al diagrama != "".
	 * 
	 * @param ejeY Se le asigna una coordenada del eje y al diagrama != "".
	 * @return chart la grafica , si no hay retorna null
	 */
	public JFreeChart generarGraficoBarras(String titulo,String ejeX,String ejeY,DefaultCategoryDataset data) {
		JFreeChart chart = ChartFactory.createBarChart3D(titulo,ejeX,ejeY, data,PlotOrientation.VERTICAL,true,true,true);
		ChartPanel panel_Grafico = new ChartPanel(chart);
		panel_Grafico.setBounds(0, 0, 694, 471);
		panel_Grafico.setVisible(true);
		getContentPane().add(panel_Grafico);
		return chart; 
	}
	
	/**
	 * Este es el metodo fileChooseGuardar el cual se guarda el archivo en pdf es la dirección establecida por el usuario 
	 * <b>post</b>Se debe llamar el metodo y dar un valor a los parametros a la hora
	 * de generar un nuevo horario.<br>
	 * @return " " vacio 
	 * */
	public String fileChooserGuardar() {
		JFileChooser direccion = new JFileChooser();
		if(direccion.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
		
		File direccionArchivo = direccion.getSelectedFile();
		return direccionArchivo.toString();
		}else{
			return "";
		}
	}
	}