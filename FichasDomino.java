/**
 * @author Jose Fernando Botina 
 */
package juegoDomino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *@author Jose Fernando Botina Lopez
 *
 *
 */
public class FichasDomino {
	//private int[] ficha;
	private int[][] fichas;
	//private ArrayList<int[]>  fichas;
	private Random aleatorio;

	public FichasDomino() {
	//	ficha =new int[2];
		fichas = new int[28][2];
		aleatorio = new Random();
		//fichas = new ArrayList<int[]>(28);
		obtener();
	}
	
	private void obtener() {
		int primero=0;
		int segundo =6;
		for(int i=0;i<28;i++){
			if(primero == segundo){
			//	ficha[0]=primero;
			//	ficha[1]=segundo;
				
				fichas[i][0]= primero;
				fichas[i][1]= segundo;
				primero++;
				segundo=6;
				}
			else if(primero!= segundo) {
				
			//		ficha[0]=primero;
			//		ficha[1]=segundo;
					
					fichas[i][0]=primero;
					fichas[i][1]=segundo;
					segundo--;
					}
		//	fichas.add(i,ficha);
			System.out.println(i+" " +Arrays.toString(fichas[i]));
			
			}
		System.out.println(0+" " +Arrays.toString(fichas[0]));
		System.out.println(1+" " +Arrays.toString(fichas[1]));
		System.out.println(2+" " +Arrays.toString(fichas[2]));
		}
	
	public void revolver() {
		
	}
	
	
	
	public String getarray(int i) {
		return Arrays.toString(fichas[i]);
	}
	
}

