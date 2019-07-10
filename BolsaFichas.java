/**
 * 
 */
package juegoDomino;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author Usser
 *
 */
public class BolsaFichas {
	private static final String direccion = "src/imagen/Fichas.png" ;
	private final int fichaAncho=47;
	private final int fichaAlto=27;
	private final int espacio = 7 ;
	private FichasDomino ficha06,ficha05,ficha04,ficha03,ficha02, ficha01,ficha00,
						 ficha16, ficha15, ficha14, ficha13, ficha12, ficha11,
						 ficha26, ficha25, ficha24, ficha23, ficha22,
						 ficha36, ficha35, ficha34, ficha33,
						 ficha46, ficha45, ficha44,
						 ficha56, ficha55,
						 ficha66;
	private ArrayList<FichasDomino> bolsaFichas;
	private Random aleatorio;
	private BufferedImage bufferImage = null;
	
	public BolsaFichas() {
		bufferImage = ImageIO.read(new File(direccion));
		bolsaFichas= new ArrayList<FichasDomino>(28);  
	}
	
	public  void obtener() {
		for(int i=0;i<=6;i++) {
			for(int j=6;j>=0;j--) {
				if(i<=j) {
					int x,y=0;
					
					BufferedImage subImage= bufferImage.getSubimage(x, y, fichaAncho, fichaAlto);
					ImageIcon fichaImage = new ImageIcon(subImage);
					this.bolsaFichas.add(ficha06 = new FichasDomino(5,6,0,6,fichaImage));
				}
					}
				}
			}
		

	private void obteneras() {
		int primero=0;
		int segundo =6;
		for(int i=0;i<28;i++){
			if(primero == segundo){
			//	ficha[0]=primero;
			//	ficha[1]=segundo;
				
				this.bolsaFichas.add(new FichasDomino(1,1,primero,segundo,));
				
				primero++;
				segundo=6;
				}
			else if(primero!= segundo) {
					this.bolsaFichas.add(new FichasDomino(aleatorio.nextInt(),1,primero,segundo));
					
					segundo--;
					}
			}
	
		
}
