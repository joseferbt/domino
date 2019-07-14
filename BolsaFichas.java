/**
 * 
 */
package juegoDomino;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Usser
 *
 */
public class BolsaFichas {
	private ImageIcon imagen;
	private FichasDomino ficha06,ficha05,ficha04,ficha03,ficha02, ficha01,ficha00,
						 ficha16, ficha15, ficha14, ficha13, ficha12, ficha11,
						 ficha26, ficha25, ficha24, ficha23, ficha22,
						 ficha36, ficha35, ficha34, ficha33,
						 ficha46, ficha45, ficha44,
						 ficha56, ficha55,
						 ficha66;
	private ArrayList<FichasDomino> bolsaFichas;
	private Random aleatorio;
	
	
	public BolsaFichas() {
		aleatorio = new Random();
		bolsaFichas= new ArrayList<FichasDomino>(28);  
		obtener();
	}
	
	public  void obtener() {
		
			//fichas 0-x
			
			this.bolsaFichas.add(ficha06 = new FichasDomino(0,6 ));	
			this.bolsaFichas.add(ficha05 = new FichasDomino(0,5 ));
			this.bolsaFichas.add(ficha04 = new FichasDomino(0,4 ));
			this.bolsaFichas.add(ficha03 = new FichasDomino(0,3 ));
			this.bolsaFichas.add(ficha02 = new FichasDomino(0,2 ));
			this.bolsaFichas.add(ficha01 = new FichasDomino(0,1 ));
			this.bolsaFichas.add(ficha00 = new FichasDomino(0,0 ));
			//fichas 1-x
			this.bolsaFichas.add(ficha16 = new FichasDomino(1,6 ));
			this.bolsaFichas.add(ficha15 = new FichasDomino(1,5 ));
			this.bolsaFichas.add(ficha14 = new FichasDomino(1,4 ));
			this.bolsaFichas.add(ficha13 = new FichasDomino(1,3 ));
			this.bolsaFichas.add(ficha12 = new FichasDomino(1,2 ));
			this.bolsaFichas.add(ficha11 = new FichasDomino(1,1 ));
			//fichas 2-x
			this.bolsaFichas.add(ficha26 = new FichasDomino(2,6 ));
			this.bolsaFichas.add(ficha25 = new FichasDomino(2,5 ));
			this.bolsaFichas.add(ficha24 = new FichasDomino(2,4 ));
			this.bolsaFichas.add(ficha23 = new FichasDomino(2,3 ));
			this.bolsaFichas.add(ficha22 = new FichasDomino(2,2 ));
			//fichas 3-x
			this.bolsaFichas.add(ficha36 = new FichasDomino(3,6 ));
			this.bolsaFichas.add(ficha35 = new FichasDomino(3,5 ));
			this.bolsaFichas.add(ficha34 = new FichasDomino(3,4 ));
			this.bolsaFichas.add(ficha33 = new FichasDomino(3,3 ));
			//fichas 4-x
			this.bolsaFichas.add(ficha46 = new FichasDomino(4,6 ));
			this.bolsaFichas.add(ficha45 = new FichasDomino(4,5 ));
			this.bolsaFichas.add(ficha44 = new FichasDomino(4,4 ));
			//fichas 5-X
			this.bolsaFichas.add(ficha56 = new FichasDomino(5,6 ));
			this.bolsaFichas.add(ficha55 = new FichasDomino(5,5 ));
			//fichas 6-x
			this.bolsaFichas.add(ficha66 = new FichasDomino(6,6 ));
			revolver();
		}
	
	public void revolver() {
		for(int i=0;i<42;i++) {
			int valor =aleatorio.nextInt(bolsaFichas.size());
			FichasDomino aux = bolsaFichas.get(valor);
			bolsaFichas.remove(valor);
			int valor1 =aleatorio.nextInt(bolsaFichas.size());
			FichasDomino aux1 = bolsaFichas.get(valor1);
			bolsaFichas.remove(valor1);
			bolsaFichas.add(valor1, aux);
			bolsaFichas.add(valor, aux1);
		}
	}
	
	public ArrayList<FichasDomino> getBolsaFichas(){
		return bolsaFichas;
	}

		
}