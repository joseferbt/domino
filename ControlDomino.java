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
import java.awt.Point;
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
	private int juega, x1, y1,x2,y2,cualCondicion, contador;
	private boolean cambio=false, cumple0,cumple1;
	private int[] condicion;
	private Random aleatorio;
	private BolsaFichas bolsaFichas;
	private UsuarioDomino usuarioDomino;
	private CrupierDomino crupierDomino;
	private Escuchas escucha;
	private EscuchaFichas escuchaFichas;
	private JPanel panelControl,panelFichas,panelCrupier,panelUsuario;
	private FichasDomino plantilla1, plantilla2, fichaUsuario,fichaCrupier;
	private GridBagConstraints posiciones = new GridBagConstraints();
	public ControlDomino() {
		
		initGui();
		
		setPreferredSize(new Dimension(1000,700));
		
	}
	
	public void initGui() {
		aleatorio = new Random();
		escucha = new Escuchas();
		escuchaFichas = new EscuchaFichas();
		condicion = new int [2];
		condicion[1]=-1;
		condicion[0]=-1;
		
		plantilla1 = new FichasDomino(21,20);
		plantilla1.setIcon(new ImageIcon("src/imagenes/panel.jpg"));
		plantilla1.addMouseListener(escuchaFichas);
		plantilla2 = new FichasDomino(21,20);
		plantilla2.setIcon(new ImageIcon("src/imagenes/panel.jpg"));
		plantilla2.addMouseListener(escuchaFichas);
		
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
	
	public void ponerFicha(int[] condicion) {
		if(condicion[0]==-1) {
			FichasDomino aux = crupierDomino.getFichas().get(aleatorio.nextInt(crupierDomino.getFichas().size()));
			fichaCrupier= aux ;
		}else {
			for(int i=0;i<crupierDomino.getFichas().size();i++) {
				FichasDomino aux = crupierDomino.getFichas().get(i);
				for (int j=0;j<crupierDomino.getFichas().size();j++) {
					if (condicion[i]==aux.getValores()[j]) {
						fichaCrupier = aux;
					}
				}						
			}
		}
}
	
	public void revisarCondicion(int[] valores) {
		cumple0=false;
		cumple1=false;
		for(int i=0;i<condicion.length;i++) {
			for(int j=0;j<condicion.length;j++) {
				if (condicion[i]==valores[j]) {
					if(i==0) {
						cumple0=true;
					}else {
						cumple1=true;
					}
					cualCondicion=j;
				}
			}
		}
		
	}
	
	public void setPlantilla() {
		contador=0;
		x1=5;y1=5;x2=5;y2=5;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if (panelFichas.getComponentAt(new Point(i,j))!= new JLabel()) {
					x1=i;x2=i;
					y1=j;y2=j;
					}
				}
			}
		posiciones.gridx=x1;
		posiciones.gridy=y1;
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
			fichaUsuario = (FichasDomino) e.getSource();
			fichaUsuario.setImage(fichaUsuario.getImagen());
			bolsaFichas.getBolsaFichas().remove(bolsaFichas.getBolsaFichas().indexOf(fichaUsuario));
			fichaCrupier = bolsaFichas.getBolsaFichas().get(aleatorio.nextInt(bolsaFichas.getBolsaFichas().size()));
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
				
				JOptionPane.showMessageDialog(null, "El valor de tu ficha es mayor al de crupier"); }
			else {
				juega=1;
				JOptionPane.showMessageDialog(null, "El valor de tu ficha es menor al de crupier");
				}
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
			panelFichas.updateUI();
			
			if(juega==0) {
				for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
					usuarioDomino.getFichas().get(i).addMouseListener(escuchaFichas);
					 }
				for(int i=0;i<10;i++ ) {
					for (int j=0; j<10;j++) {
							posiciones.gridx=i;
							posiciones.gridy=j;
							panelFichas.add(new JLabel(),posiciones);
							}
					setPlantilla();
					panelFichas.add(plantilla1,posiciones);
							
						}
				juega=2;
			}else {
				
				int aux = aleatorio.nextInt(crupierDomino.getFichas().size());
				fichaCrupier = crupierDomino.getFichas().get(aux);
				fichaCrupier.setImage(fichaCrupier.getImagen());
				for(int i=0;i<10;i++ ) {
					for (int j=0; j<10;j++) {
						posiciones.gridx=i;
						posiciones.gridy=j;
						panelFichas.add(new JLabel(),posiciones);}
					}
				setPlantilla();
				
				panelFichas.add(fichaCrupier,posiciones);
				condicion[0]=fichaCrupier.getValores()[0];
				condicion[1]=fichaCrupier.getValores()[1];
				posiciones.gridx=x2-1;
				posiciones.gridy=y2;
				panelFichas.add(plantilla2,posiciones);
				posiciones.gridx=x1+1;
				posiciones.gridy=y1;
				panelFichas.add(plantilla1,posiciones);
				juega=3;
				
			}
			
			if(juega==3) {
				for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
					usuarioDomino.getFichas().get(i).addMouseListener(escuchaFichas);
					 }
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
			
			if(cambio) {
				if (e.getSource()==plantilla1 && cumple0 ) {
					plantilla1.setIcon(fichaUsuario.getImagen());
					}else if(e.getSource()==plantilla2 && cumple1)
					{ plantilla2.setIcon(fichaUsuario.getImagen());}
				condicion[0]=fichaUsuario.getValores()[0];
				condicion[1]=fichaUsuario.getValores()[1];
				plantilla1.removeMouseListener(escuchaFichas);
				plantilla2.removeMouseListener(escuchaFichas);
				}
			}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			fichaUsuario = (FichasDomino)e.getSource();
			revisarCondicion(fichaUsuario.getValores());
			if(condicion[0] == -1 && !cambio) {
				fichaUsuario = (FichasDomino)e.getSource();
				cambio=true;
				usuarioDomino.getFichas().remove(fichaUsuario);
				panelUsuario.remove(fichaUsuario);
				
				for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
					usuarioDomino.getFichas().get(i).removeMouseListener(escuchaFichas);
					}
				}else if(cumple0||cumple1){
					fichaUsuario = (FichasDomino)e.getSource();
					cambio=true;
					usuarioDomino.getFichas().remove(fichaUsuario);
					panelUsuario.remove(fichaUsuario);
					System.out.println(usuarioDomino.getFichas().size());
					for(int i = 0;i<usuarioDomino.getFichas().size();i++) {
						usuarioDomino.getFichas().get(i).removeMouseListener(escuchaFichas);
						 }
					
				}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}