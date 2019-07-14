/**
 * 
 */
package juegoDomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class ControlDomino extends JPanel {
	private final Color fondo = new Color(158,59,32);
	private int juega ;
	private Random aleatorio;
	private BolsaFichas bolsaFichas;
	private UsuarioDomino jugador;
	private CrupierDomino maquina;
	private Escuchas escucha;
	private JPanel panelControl,panelFichas,panelCrupier,panelUsuario;
	
	public ControlDomino() {
		
		initGui();
		
		setPreferredSize(new Dimension(1000,700));
		
	}
	
	public void initGui() {
		escucha = new Escuchas();
		
		this.setLayout(new BorderLayout());
		maquina = new CrupierDomino(1000);
		panelCrupier = new JPanel();
		panelCrupier.setBackground(fondo);
		panelCrupier.setPreferredSize(new Dimension(750,120));
		add(panelCrupier,BorderLayout.NORTH);
		
		bolsaFichas= new BolsaFichas();
		panelFichas = new JPanel();
		//panelFichas.setLayout();
		panelFichas.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<bolsaFichas.getBolsaFichas().size();i++ ) {
			bolsaFichas.getBolsaFichas().get(i).addMouseListener(escucha);
			panelFichas.add(bolsaFichas.getBolsaFichas().get(i));	
		}
		add(panelFichas,BorderLayout.CENTER);
		jugador = new UsuarioDomino(100);
		panelUsuario = new JPanel();
		panelUsuario.setBackground(fondo);
		panelUsuario.setPreferredSize(new Dimension(750,120));
		add(panelUsuario,BorderLayout.SOUTH);
		
		panelControl = new JPanel();
		panelControl.setPreferredSize(new Dimension(200,500));
		panelControl.setBackground(new Color(158,59,32));
		add(panelControl,BorderLayout.EAST);
		
		
	}


protected void initGuia() {
	for(int i=0;i<bolsaFichas.getBolsaFichas().size();i++ ) {
		add(bolsaFichas.getBolsaFichas().get(i));	
		}
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
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			FichasDomino origen= (FichasDomino) e.getSource();
			origen.setImage(origen.getImagen());
			
		
			
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
