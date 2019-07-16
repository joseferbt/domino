/**
 * 
 */
package juegoDomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class GuiDomino extends JFrame {
	private ControlDomino controlDomino;
	private String mensaje;
	private JButton jugar;
	private Escucha escucha;
	private JPanel panelBoton, panelFichas;
	private JLabel titulo;

	public GuiDomino() {
		initGui();
		setSize(1000,700);
		setTitle("Domino");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGui() {
		
		//escucha
		escucha = new Escucha();
		
		// control
		controlDomino = new ControlDomino();
		init();
		/*
		titulo = new JLabel(new ImageIcon("src/imagenes/Titulo.png"));
		add(titulo,BorderLayout.NORTH);
		
		panelBoton = new JPanel();
		jugar = new JButton("jugar");
		jugar.addActionListener(escucha);
		panelBoton.add(jugar);
		add(panelBoton);
		*/
		
	}
	
	public void init() {
	
		mensaje="Escoge una ficha para determinar quien inicia el juego";
		controlDomino = new ControlDomino();
		//controlDomino.setVisible(false);
		add(controlDomino);
	}
	
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			titulo.setVisible(false);
			panelBoton.setVisible(false);
		//	panelFichas.setVisible(true);
			controlDomino.setVisible(true);
		//	controlDomino.getJugador().setVisible(true);
		//	controlDomino.getMaquina().setVisible(true);
		}
		
	}
	
	
}
