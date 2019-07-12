/**
 * 
 */
package juegoDomino;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
			imagen = new ImageIcon("src/imagenes/0-6.jpg");
			this.bolsaFichas.add(ficha06 = new FichasDomino(0,6,imagen));	
			imagen = new ImageIcon("src/imagenes/0-5.jpg");
			this.bolsaFichas.add(ficha05 = new FichasDomino(0,5,imagen));
			imagen = new ImageIcon("src/imagenes/0-4.jpg");
			this.bolsaFichas.add(ficha04 = new FichasDomino(0,4,imagen));
			imagen = new ImageIcon("src/imagenes/0-3.jpg");
			this.bolsaFichas.add(ficha03 = new FichasDomino(0,3,imagen));
			imagen = new ImageIcon("src/imagenes/0-2.jpg");
			this.bolsaFichas.add(ficha02 = new FichasDomino(0,2,imagen));
			imagen = new ImageIcon("src/imagenes/0-1.jpg");
			this.bolsaFichas.add(ficha01 = new FichasDomino(0,1,imagen));
			imagen = new ImageIcon("src/imagenes/0-0.jpg");
			this.bolsaFichas.add(ficha00 = new FichasDomino(0,0,imagen));
			//fichas 1-x
			imagen = new ImageIcon("src/imagenes/1-6.jpg");
			this.bolsaFichas.add(ficha16 = new FichasDomino(1,6,imagen));	
			imagen = new ImageIcon("src/imagenes/1-5.jpg");
			this.bolsaFichas.add(ficha15 = new FichasDomino(1,5,imagen));
			imagen = new ImageIcon("src/imagenes/1-4.jpg");
			this.bolsaFichas.add(ficha14 = new FichasDomino(1,4,imagen));
			imagen = new ImageIcon("src/imagenes/1-3.jpg");
			this.bolsaFichas.add(ficha13 = new FichasDomino(1,3,imagen));
			imagen = new ImageIcon("src/imagenes/1-2.jpg");
			this.bolsaFichas.add(ficha12 = new FichasDomino(1,2,imagen));
			imagen = new ImageIcon("src/imagenes/1-2.jpg");
			this.bolsaFichas.add(ficha11 = new FichasDomino(1,1,imagen));
			
			//fichas 2-x
			imagen = new ImageIcon("src/imagenes/2-6.jpg");
			this.bolsaFichas.add(ficha26 = new FichasDomino(2,6,imagen));	
			imagen = new ImageIcon("src/imagenes/2-5.jpg");
			this.bolsaFichas.add(ficha25 = new FichasDomino(2,5,imagen));
			imagen = new ImageIcon("src/imagenes/2-4.jpg");
			this.bolsaFichas.add(ficha24 = new FichasDomino(2,4,imagen));
			imagen = new ImageIcon("src/imagenes/2-3.jpg");
			this.bolsaFichas.add(ficha23 = new FichasDomino(2,3,imagen));
			imagen = new ImageIcon("src/imagenes/2-2.jpg");
			this.bolsaFichas.add(ficha22 = new FichasDomino(2,2,imagen));
			//fichas 3-x
			imagen = new ImageIcon("src/imagenes/3-6.jpg");
			this.bolsaFichas.add(ficha36 = new FichasDomino(3,6,imagen));	
			imagen = new ImageIcon("src/imagenes/3-5.jpg");
			this.bolsaFichas.add(ficha35 = new FichasDomino(3,5,imagen));
			imagen = new ImageIcon("src/imagenes/3-4.jpg");
			this.bolsaFichas.add(ficha34 = new FichasDomino(3,4,imagen));
			imagen = new ImageIcon("src/imagenes/3-3.jpg");
			this.bolsaFichas.add(ficha33 = new FichasDomino(3,3,imagen));
			//fichas 4-x
			imagen = new ImageIcon("src/imagenes/4-6.jpg");
			this.bolsaFichas.add(ficha46 = new FichasDomino(4,6,imagen));
			imagen = new ImageIcon("src/imagenes/4-5.jpg");
			this.bolsaFichas.add(ficha45 = new FichasDomino(4,5,imagen));
			imagen = new ImageIcon("src/imagenes/4-4.jpg");
			this.bolsaFichas.add(ficha44 = new FichasDomino(4,4,imagen));
			//fichas 5-X
			imagen = new ImageIcon("src/imagenes/5-6.jpg");
			this.bolsaFichas.add(ficha56 = new FichasDomino(5,6,imagen));
			imagen = new ImageIcon("src/imagenes/5-5.jpg");
			this.bolsaFichas.add(ficha55 = new FichasDomino(5,5,imagen));
			//fichas 6-x
			imagen = new ImageIcon("src/imagenes/6-6.jpg");
			this.bolsaFichas.add(ficha66 = new FichasDomino(6,6,imagen));
			revolver();
		}
	
	public void revolver() {
		for(int i=0;i<42;i++) {
			int valor =aleatorio.nextInt(27);
			FichasDomino aux = bolsaFichas.get(valor);
			bolsaFichas.remove(valor);
			int valor1 =aleatorio.nextInt(27);
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
