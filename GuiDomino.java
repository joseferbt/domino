/**
 * 
 */
package juegoDomino;


import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class GuiDomino extends JFrame {
	private BolsaFichas bolsaFichas;
	private FichasDomino fichaDomino;
	private JPanel fichasJugador,fichasComputador,fichasJuego,estadoDelJuego;
	
	public GuiDomino() {
	
		initGui();
		
		setSize(500,500);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public void initGui() {
		// container y layout
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		bolsaFichas = new BolsaFichas();
		
		//add(jlabel);
		//add(bolsaFichas.getBolsaFichas().get(0));
		for(int i=0;i<28;i++ ) {
			add(bolsaFichas.getBolsaFichas().get(i));	
			}
		}
	}