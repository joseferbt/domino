/**
 * 
 */
package juegoDomino;

import java.util.ArrayList;

/**
 * @author Usser
 *
 */
public class CrupierDomino extends UsuarioDomino {


		
	public CrupierDomino(int dinero) {
		super(dinero);
		// TODO Auto-generated constructor stub
		
	}
	
	protected void initGui() {
		for(int i=0;i<fichas.size();i++ ) {
			fichas.get(i).setImage(fichas.get(i).getDefecto());
			add(fichas.get(i));	
			}
	}

}
