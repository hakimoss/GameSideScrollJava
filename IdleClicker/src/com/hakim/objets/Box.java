package com.hakim.objets;


import javax.swing.ImageIcon;

public class Box extends Objet {
	
	
	

	public Box(int x, int y) {
		
		super(x, y, 71, 71);

		super.icoObjet = new ImageIcon(getClass().getResource("/image/boite.png"));
		super.imgObjet = this.icoObjet.getImage();
	}

	
	
}
