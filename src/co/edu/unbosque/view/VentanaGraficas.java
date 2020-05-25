package co.edu.unbosque.view;


import java.awt.FlowLayout;
import javax.swing.JDialog;
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

	public VentanaGraficas(){
		
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		inicializarComponentes();
	}
	
	
	
	
	public void inicializarComponentes(){
		panel= new JPanel();
	
		panelAux= new JPanel();
		scrollPane= new JScrollPane();
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		getContentPane().add(panel);
	
		getContentPane().add(scrollPane);
	}
	
	public void agregarGraficos(ChartPanel panel){
		this.panel.add(panel);
	
		panelAux.setLayout(new FlowLayout());
		panelAux.add(this.panel);
		
		scrollPane.setViewportView(panelAux);
	}
	

	
	public ChartPanel graficoEdad(double r1, double r2, double r3, double r4, double r5, double r6){
		panel.removeAll();
		DefaultPieDataset datos= new DefaultPieDataset();
		JFreeChart grafica;
		ChartPanel panelGrafica;
		
		datos.setValue("RANGO 1", r1);
		datos.setValue("RANGO 2", r2);
		datos.setValue("RANGO 3", r3);
		datos.setValue("RANGO 4", r4);
		datos.setValue("RANGO 5", r5);
		datos.setValue("RANGO 6", r6);
		
		grafica =  ChartFactory.createPieChart("Rangos", datos, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
//		grafica= ChartFactory.createPieChart("RANGOS", datos);
		panelGrafica= new ChartPanel(grafica);
		panel.add(panelGrafica);
		return panelGrafica;
	}
}
//	public VentanaGraficas() throws IOException {
//
//		setTitle("Grafica 3D");
//		setSize(800, 600);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setResizable(false);
//		inicializarComponentes();
//		setVisible(false);
//
//	}
//
//	private void inicializarComponentes() throws IOException {
//		panel = new JPanel();
//		getContentPane().add(panel);
//
//		// Fuente de Datos
//		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
//		defaultpiedataset.setValue("algo1", new Double(500));
//		defaultpiedataset.setValue("algo2", new Double(11));
//		defaultpiedataset.setValue("algo3", new Double(19.5));
//		defaultpiedataset.setValue("algo4", new Double(30.5));
//		defaultpiedataset.setValue("algo5", new Double(2.0));
//
//		// Creando el Grafico
//		JFreeChart chart = ChartFactory.createPieChart3D("Gráfica",defaultpiedataset, true, true, false);
//		PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
//		pieplot3d.setDepthFactor(0.5);
//		pieplot3d.setStartAngle(290D);
//		pieplot3d.setDirection(Rotation.CLOCKWISE);
//		pieplot3d.setForegroundAlpha(0.5F);
//
//		// Mostrar Grafico
//		ChartPanel chartPanel = new ChartPanel(chart);
//		panel.add(chartPanel);
//
//		ChartUtilities.saveChartAsJPEG(new File(".\\data\\grafico.jpg"), chart,
//				500, 500);
//
//	}
//
//	public JPanel getPanel() {
//		return panel;
//	}
//
//	public void setPanel(JPanel panel) {
//		this.panel = panel;
//	}
//	
//
//}
