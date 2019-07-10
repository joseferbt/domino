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
	private int posicionX;
	private int posicionY;
	private int valorUno;
	private int valorDos;
	private int valorFicha;
	private ImageIcon imagen;
	
	

	public FichasDomino(int valorUno,int valorDos,ImageIcon imagen) {
		/*
		 * this.posicionX=posicionX; this.posicionY=posicionY;
		 */
	this.valorUno=valorUno;
	this.valorDos=valorDos;
	this.valorFicha = valorUno+valorDos;
	this.imagen = imagen;
	this.setIcon(imagen);
	setBackground(Color.black);
	}
/*	
public class FichasDomino extends JLabel{
	//private int[] ficha;
	private int[][] fichas;
	//private ArrayList<int[]>  fichas;
	private Random aleatorio;

	public FichasDomino(int x ,int y, int val1,int val2) {
	//	ficha =new int[2];
		fichas = new int[28][2];
		aleatorio = new Random();
		//fichas = new ArrayList<int[]>(28);
		obtener();
	}*/
	

	
	public void revolver() {
		
	}
	
	
}

