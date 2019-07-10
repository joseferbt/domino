/**
 * 
 */
package juegoDomino;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Usser
 *
 */
public class ControlDomino {
	private int juega ;
	//private FichasDomino ficha;
	private Random aleatorio;
	private ArrayList<FichasDomino> arrayFichas;
	private UsuarioDomino jugador;
	private CrupierDomino maquina;
	private Escuchas escucha;
	
	public ControlDomino() {
		arrayFichas = new ArrayList<FichasDomino>(28);
		
	}
	
	
	public boolean gano() {
		return false;
	}
	
	
	private class Escuchas implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
