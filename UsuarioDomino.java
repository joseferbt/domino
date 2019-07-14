/**
 * 
 */
package juegoDomino;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class UsuarioDomino extends JPanel {
	protected ArrayList<FichasDomino> fichas;
	protected int dinero;
	
	public UsuarioDomino(int dinero ){
		this.dinero = dinero;
		this.setPreferredSize(new Dimension(100, 120));
		setBackground(Color.LIGHT_GRAY);
		
	}
	
	protected void initGui() {
		for(int i=0;i<fichas.size();i++ ) {
			add(fichas.get(i));	
			}
	}
	
	public void setFichas(ArrayList<FichasDomino>  ficha) {
		fichas= ficha;
	}
	
}
