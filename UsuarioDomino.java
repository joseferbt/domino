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
public class UsuarioDomino  {
	protected ArrayList<FichasDomino> fichas;
	protected int dinero;
	
	public UsuarioDomino(int dinero ){
		this.dinero = dinero;
		
		
	
		
	}
	
	
	
	public void setFichas(ArrayList<FichasDomino>  ficha) {
		fichas= ficha;
	}
	
}
