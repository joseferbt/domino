/**
 * @author Jose Fernando Botina 
 */
package juegoDomino;


import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *@author Jose Fernando Botina Lopez
 *
 *
 */
public class FichasDomino extends JLabel{
	private static final ImageIcon defecto = new ImageIcon("src/imagenes/ficha.jpg");
	private int posicionX;
	private int posicionY;
	private int valorUno;
	private int valorDos;
	private int valorFicha;
	private ImageIcon imagen,imagen1;
	
	

	public FichasDomino(int valorUno,int valorDos) {

	this.valorUno=valorUno;
	this.valorDos=valorDos;
	this.valorFicha = valorUno+valorDos;
	this.imagen = new ImageIcon("src/imagenes/"+valorUno+"-"+valorDos+".jpg");
	this.imagen1 = new ImageIcon("src/imagenes/"+valorDos+"-"+valorUno+".jpg");
	this.setIcon(defecto);
	setBackground(Color.black);
	}

	
	public void setImage(ImageIcon imagen) {
		this.setIcon(imagen);
	}
	
	public ImageIcon getDefecto() {
		return defecto;
		
	}
	
	public ImageIcon getImagen(int n) {
		if(n==0) {
		return imagen;}else {
			return imagen1;
		}
		
	}
	
	public int getValorFicha() {
		return valorFicha;
	}
	
	public int[] getValores() {
		int[] valores = {valorUno,valorDos};
		return valores;
	}
	

	
}

