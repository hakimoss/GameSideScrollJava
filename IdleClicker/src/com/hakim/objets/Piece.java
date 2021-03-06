package com.hakim.objets;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Piece extends Objet implements Runnable{
	
	private int compteur;
	private final int PAUSE = 15;

	public Piece(int x, int y) {
		super(x, y, 43, 42);

		super.icoObjet = new ImageIcon(getClass().getResource("/image/piece1.png"));
		super.imgObjet = super.icoObjet.getImage();
	
	}
	
	
	//   METHODE   //
	
	public Image bouge() {
		String str;
		ImageIcon ico;
		Image img;
		
		this.compteur++;
		if(this.compteur / 100 == 0) {
			str = "/image/piece1.png";
		} else {
			str = "/image/piece2.png";
		}
		if(this.compteur == 200) {
			this.compteur = 0;
		}
		
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(true) {
			this.bouge();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

}
