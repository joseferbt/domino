/**
 * 
 */
package juegoDomino;


import java.util.ArrayList;

/**
 * @author Usser
 *
 */
public class UsuarioDomino  {
	protected ArrayList<FichasDomino> fichas;
	protected int dinero;
	
	public UsuarioDomino(int dinero ){
		this.dinero = dinero;
		
		
	}
	
	public ArrayList<FichasDomino> getFichas(){
		return fichas;
	}
	
	public void setFichas(ArrayList<FichasDomino>  ficha) {
		fichas= ficha;
	}
	
}
