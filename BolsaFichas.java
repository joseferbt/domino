/**
 * 
 */
package juegoDomino;


import java.util.ArrayList;
import java.util.Random;

/**
 * @author Usser
 *
 */
public class BolsaFichas {
	
	private ArrayList<FichasDomino> bolsaFichas;
	private Random aleatorio;
	
	
	public BolsaFichas() {
		aleatorio = new Random();
		bolsaFichas= new ArrayList<FichasDomino>(28);  
		obtener();
	}
	
	public  void obtener() {
		
			//fichas 0-x
			
			this.bolsaFichas.add(   new FichasDomino(0,6 ));	
			this.bolsaFichas.add(   new FichasDomino(0,5 ));
			this.bolsaFichas.add(   new FichasDomino(0,4 ));
			this.bolsaFichas.add(   new FichasDomino(0,3 ));
			this.bolsaFichas.add(   new FichasDomino(0,2 ));
			this.bolsaFichas.add(   new FichasDomino(0,1 ));
			this.bolsaFichas.add(   new FichasDomino(0,0 ));
			//fichas 1-x
			this.bolsaFichas.add(   new FichasDomino(1,6 ));
			this.bolsaFichas.add(   new FichasDomino(1,5 ));
			this.bolsaFichas.add(   new FichasDomino(1,4 ));
			this.bolsaFichas.add(   new FichasDomino(1,3 ));
			this.bolsaFichas.add(   new FichasDomino(1,2 ));
			this.bolsaFichas.add(   new FichasDomino(1,1 ));
			//fichas 2-x
			this.bolsaFichas.add(   new FichasDomino(2,6 ));
			this.bolsaFichas.add(   new FichasDomino(2,5 ));
			this.bolsaFichas.add(   new FichasDomino(2,4 ));
			this.bolsaFichas.add(   new FichasDomino(2,3 ));
			this.bolsaFichas.add(   new FichasDomino(2,2 ));
			//fichas 3-x
			this.bolsaFichas.add(   new FichasDomino(3,6 ));
			this.bolsaFichas.add(   new FichasDomino(3,5 ));
			this.bolsaFichas.add(   new FichasDomino(3,4 ));
			this.bolsaFichas.add(   new FichasDomino(3,3 ));
			//fichas 4-x
			this.bolsaFichas.add(   new FichasDomino(4,6 ));
			this.bolsaFichas.add(   new FichasDomino(4,5 ));
			this.bolsaFichas.add(   new FichasDomino(4,4 ));
			//fichas 5-X
			this.bolsaFichas.add(   new FichasDomino(5,6 ));
			this.bolsaFichas.add(   new FichasDomino(5,5 ));
			//fichas 6-x
			this.bolsaFichas.add(   new FichasDomino(6,6 ));
			revolver();
		}
	
	public void revolver() {
		for(int i=0;i<42;i++) {
			int valor =aleatorio.nextInt(bolsaFichas.size());
			FichasDomino aux = bolsaFichas.get(valor);
			bolsaFichas.remove(valor);
			int valor1 = aleatorio.nextInt(bolsaFichas.size());
			FichasDomino aux1 =  bolsaFichas.get(valor1);
			bolsaFichas.remove(valor1);
			bolsaFichas.add(valor1, aux);
			bolsaFichas.add(valor, aux1);
		}
	}
	
	public ArrayList<FichasDomino> getBolsaFichas(){
		return bolsaFichas;
	}

		
}