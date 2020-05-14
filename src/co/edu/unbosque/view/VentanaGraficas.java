package co.edu.unbosque.view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class VentanaGraficas extends JFrame{
	
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  JPanel panel;
    public  VentanaGraficas() throws IOException {
	
        setTitle("Grafica 3D");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(false);
        init();
    }
 
    @SuppressWarnings("deprecation")
	private void init() throws IOException {
        panel = new JPanel();
        getContentPane().add(panel);
        
        // Fuente de Datos
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset(); 
        defaultpiedataset.setValue("algo1", new Double(41)); 
        defaultpiedataset.setValue("algo2", new Double(11)); 
        defaultpiedataset.setValue("algo3", new Double(19.5)); 
        defaultpiedataset.setValue("algo4", new Double(30.5)); 
        defaultpiedataset.setValue("algo5", new Double(2.0)); 
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart3D("Tematicas Blog", defaultpiedataset, true, true, false); 
        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
        pieplot3d.setDepthFactor(0.5); 
        pieplot3d.setStartAngle(290D); 
        pieplot3d.setDirection(Rotation.CLOCKWISE); 
        pieplot3d.setForegroundAlpha(0.5F); 
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        
         
        ChartUtilities.saveChartAsJPEG(new File(".\\data\\grafico.jpg"), chart, 500, 500);
        
       
    }

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
    
   
}
