package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelInfoSolusoft extends JPanel {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ImageIcon imagen;

	public PanelInfoSolusoft(String nombre) {
		this.nombre = nombre;
		setLayout(null);
		setVisible(true);

	}

	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);

	}

}
