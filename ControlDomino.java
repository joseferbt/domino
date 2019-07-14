/**
 * 
 */
package juegoDomino;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class ControlDomino extends JPanel {
	private int juega ;
	private Random aleatorio;
	private BolsaFichas bolsaFichas;
	private UsuarioDomino jugador;
	private CrupierDomino maquina;
	private Escuchas escucha;
	
	public ControlDomino() {
		bolsaFichas= new BolsaFichas();
		jugador = new UsuarioDomino(100);
		maquina = new CrupierDomino(1000);
		setPreferredSize(new Dimension(250,200));
		setBackground(Color.blue);
	}
	
	
	public boolean gano() {
		return false;
	}
	
	public ArrayList<FichasDomino> getArrayFichas(){
		return bolsaFichas.getBolsaFichas();
	}
	
	public ArrayList<FichasDomino> repartir() {
		ArrayList<FichasDomino> fichas =new ArrayList<FichasDomino>();
		for(int i=0;i<7;i++) {
			FichasDomino aux = getArrayFichas().get(i);
			getArrayFichas().remove(i);
			fichas.add(aux);
		}
		return fichas;
	}
	
	
	
	
	public int getJuega() {
		return juega;
	}


	public Random getAleatorio() {
		return aleatorio;
	}


	public BolsaFichas getBolsaFichas() {
		return bolsaFichas;
	}


	public UsuarioDomino getJugador() {
		return jugador;
	}


	public CrupierDomino getMaquina() {
		return maquina;
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
