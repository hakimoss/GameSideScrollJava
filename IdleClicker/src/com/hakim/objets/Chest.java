package com.hakim.objets;


import javax.swing.ImageIcon;

public class Chest extends Objet {

	

	public Chest(int x, int y) {
		
		super(x, y, 71, 71);

		super.icoObjet = new ImageIcon(getClass().getResource("/image/chestFermer.png"));
		super.imgObjet = this.icoObjet.getImage();
	}

	
}
