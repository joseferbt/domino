/**
 * 
 */
package juegoDomino;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class GuiDomino extends JFrame {
	private ControlDomino controlDomino;
	private String mensaje;

	
	public GuiDomino() {
	
		initGui();
		
		setSize(1000,700);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void initGui() {
		mensaje="Escoge una ficha para determinar quien inicia el juego";
		// container y layout
		//this.getContentPane().setLayout(new FlowLayout());
		//this.getContentPane().setLayout(new GridBagLayout());
		//GridBagConstraints constraints = new GridBagConstraints();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
	controlDomino = new ControlDomino();
	for(int i=0;i<controlDomino.getArrayFichas().size();i++ ) {
		panel.add(controlDomino.getArrayFichas().get(i));	
		}
	add(panel,BorderLayout.CENTER);
	
	add(controlDomino.getJugador(),BorderLayout.SOUTH);
	add(controlDomino.getMaquina(),BorderLayout.NORTH);
	add(controlDomino,BorderLayout.EAST);
	JOptionPane.showMessageDialog(null,mensaje);
		}
	
	
	
	}