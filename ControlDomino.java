/**
 * 
 */
package juegoDomino;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class ControlDomino extends JPanel {
	private final Color fondo = new Color(158,22,22);
	private int juega ;
	private int[] condicion;
	private Random aleatorio;
	private BolsaFichas bolsaFichas;
	private UsuarioDomino usuarioDomino;
	private CrupierDomino crupierDomino;
	private Escuchas escucha;
	private EscuchaFichas escuchaFichas;
	private JPanel panelControl,panelFichas,panelCrupier,panelUsuario;
	private FichasDomino plantilla;
	
	public ControlDomino() {
		
		initGui();
		
		setPreferredSize(new Dimension(1000,700));
		
	}
	
	public void initGui() {
		aleatorio = new Random();
		escucha = new Escuchas();
		escuchaFichas = new EscuchaFichas();
		condicion = new int [2];
		
		plantilla = new FichasDomino(21,20);
		plantilla.setIcon(new ImageIcon("src/imagenes/panel.jpg"));
		plantilla.addMouseListener(escuchaFichas);
		
		this.setLayout(new BorderLayout());
		crupierDomino = new CrupierDomino(1000);
		panelCrupier = new JPanel();
		panelCrupier.setBackground(fondo);
		panelCrupier.setPreferredSize(new Dimension(1000,120));
		add(panelCrupier,BorderLayout.NORTH);
		
		bolsaFichas= new BolsaFichas();
		panelFichas = new JPanel();
		panelFichas.setLayout(new GridBagLayout());
		GridBagConstraints posiciones = new GridBagConstraints();
		panelFichas.setBackground(Color.LIGHT_GRAY);
		int contador=0;		
		for(int i=0;i<bolsaFichas.getBolsaFichas().size()/4;i++ ) {
			for (int j=0; j<getArrayFichas().size()/7;j++) {
				bolsaFichas.getBolsaFichas().get(contador).addMouseListener(escucha);
				posiciones.gridx=i;
				posiciones.gridy=j;
				panelFichas.add(bolsaFichas.getBolsaFichas().get(contador),posiciones);
				contador++;
				}
			}
		add(panelFichas,BorderLayout.CENTER);
		usuarioDomino = new UsuarioDomino(100);
		panelUsuario = new JPanel();
		panelUsuario.setBackground(fondo);
		panelUsuario.setPreferredSize(new Dimension(1000,120));
		add(panelUsuario,BorderLayout.SOUTH);
		
		panelControl = new JPanel();
		panelControl.setPreferredSize(new Dimension(200,500));
		panelControl.setBackground(fondo);
		add(panelControl,BorderLayout.EAST);
		
		
	}


	public void pintarUsuario() {
		for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
			usuarioDomino.getFichas().get(i).setImage( usuarioDomino.getFichas().get(i).getImagen());
			 panelUsuario.add(usuarioDomino.getFichas().get(i));
			 }
		}
	public void pintarCrupier() {
		for(int i = 0;i<crupierDomino.getFichas().size();i++) {
			 panelCrupier.add(crupierDomino.getFichas().get(i));
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
			int ran = aleatorio.nextInt(getArrayFichas().size());
			FichasDomino aux = getArrayFichas().get(ran);
			getArrayFichas().remove(ran);
			fichas.add(aux);
		}
		return fichas;
	}
	
	public FichasDomino darFicha() {
		int index = aleatorio.nextInt(getArrayFichas().size());
		FichasDomino aux =getArrayFichas().get(index);
		getArrayFichas().remove(index);
		return aux;
		}
	class Escuchas implements MouseListener, ActionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			// selecion de fichas
			FichasDomino fichaUsuario= (FichasDomino) e.getSource();
			fichaUsuario.setImage(fichaUsuario.getImagen());
			bolsaFichas.getBolsaFichas().remove(bolsaFichas.getBolsaFichas().indexOf(fichaUsuario));
			FichasDomino fichaCrupier = bolsaFichas.getBolsaFichas().get(aleatorio.nextInt(bolsaFichas.getBolsaFichas().size()));
			fichaCrupier.setImage(fichaCrupier.getImagen());
			bolsaFichas.getBolsaFichas().add(fichaUsuario);
			for(int i=0;i<bolsaFichas.getBolsaFichas().size();i++ ) {
				bolsaFichas.getBolsaFichas().get(i).removeMouseListener(escucha);
				//panelFichas.remove(bolsaFichas.getBolsaFichas().get(i));	
				}
			panelFichas.add(fichaCrupier);
			panelFichas.add(fichaUsuario);
			
			  if(fichaUsuario.getValorFicha()>fichaCrupier.getValorFicha()) {
				  juega=0;
				  panelFichas.setBackground(Color.pink);
				  JOptionPane.showMessageDialog(null, "El valor de tu ficha es mayor al de crupier"); }
			  else {
				  juega=1;
				  JOptionPane.showMessageDialog(null, "El valor de tu ficha es menor al de crupier");
				  panelFichas.setBackground(Color.yellow);}
			for(int i=0;i<bolsaFichas.getBolsaFichas().size();i++ ) {
				panelFichas.remove(bolsaFichas.getBolsaFichas().get(i));
				}
			fichaCrupier.setImage(fichaCrupier.getDefecto());
			fichaUsuario.setImage(fichaUsuario.getDefecto());
			usuarioDomino.setFichas(repartir());
			crupierDomino.setFichas(repartir());
			pintarUsuario();
			pintarCrupier();
			JButton pasar = new JButton("pasar");
			pasar.addActionListener(escucha);
			panelUsuario.add(pasar);
			
			if(juega==0) {
				for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
					usuarioDomino.getFichas().get(i).addMouseListener(escuchaFichas);
					 }
				GridBagConstraints posiciones = new GridBagConstraints();
				posiciones.gridx=5;
				posiciones.gridy=5;
				panelFichas.add(plantilla,posiciones);
				panelFichas.setBackground(Color.LIGHT_GRAY);
			}else {
				
				
			}
						
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(getArrayFichas().size()>0 && juega==0) {
				usuarioDomino.getFichas().add(darFicha());
				pintarUsuario();
				
				}
		}
	}

	private class EscuchaFichas implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		} 

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()== (FichasDomino)e.getSource()) {
				System.out.print(true);
			}
			System.out.print(false);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}
