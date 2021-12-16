package com.hakim.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Chest extends Objet {
	
	private Image imgChest;
	private ImageIcon icoChest;
	

	public Chest(int x, int y) {
		
		super(x, y, 43, 65);

		this.icoChest = new ImageIcon(getClass().getResource("/image/chestFermer.png"));
		this.imgChest = icoChest.getImage();
	}

	//*** GETTERS ***//
	public Image getImgChest() {return imgChest;}
	
}
