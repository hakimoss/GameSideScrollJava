package com.hakim.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Box extends Objet {
	
	private Image imgBox;
	private ImageIcon icoBox;
	

	public Box(int x, int y) {
		
		super(x, y, 71, 71);

		this.icoBox = new ImageIcon(getClass().getResource("/image/boite.png"));
		this.imgBox = icoBox.getImage();
	}

	//*** GETTERS ***//
	public Image getImgBox() {return imgBox;}
	
}
