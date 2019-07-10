/**
 * 
 */
package juegoDomino;

import java.awt.EventQueue;

import javax.swing.UIManager;



/**
 * @author Usser
 *
 */
public class PrincipalDomino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  try { 
			  String className = UIManager.getCrossPlatformLookAndFeelClassName();
			  UIManager.setLookAndFeel(className); 
			  } 
		  catch (Exception e) {}
		  
		  EventQueue.invokeLater(new Runnable() {public void run() { GuiDomino myWindow =
		  new GuiDomino(); }});

	}
	

}
