/**
 * 
 */
package juegoDomino;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Usser
 *
 */
public class GuiDomino extends JFrame {
	private BolsaFichas bolsaFichas;
	private FichasDomino fichaDomino;
	private JLabel jlabel;
	
	public GuiDomino() {
	
		initGui();
		
		setSize(1000,500);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public void initGui() {
		
		this.getContentPane().setLayout(new FlowLayout());
		bolsaFichas = new BolsaFichas();
		
		//add(jlabel);
		//add(bolsaFichas.getBolsaFichas().get(0));
		for(int i=0;i<5;i++ ) {
			add(bolsaFichas.getBolsaFichas().get(i));	
			jlabel = new JLabel("puta");
		add(jlabel,BorderLayout.SOUTH);
	}
		}
}