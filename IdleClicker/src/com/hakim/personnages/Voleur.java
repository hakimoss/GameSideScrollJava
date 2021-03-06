package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.objets.Objet;

public class Voleur extends Personnage implements Runnable{
	
	private Image imgVoleur;
	private ImageIcon icoVoleur;

	private final int PAUSE = 15;
	private int dxVoleur;

	public Voleur(int x, int y) {
		super(x, y, 66, 103);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxVoleur = 1;
		
		icoVoleur = new ImageIcon(getClass().getResource("/image/voleurArretDroite.png"));
		imgVoleur = icoVoleur.getImage();
		
		Thread chronoVoleur = new Thread(this);
		chronoVoleur.start();
	}

	//   GETTERS   //
	public Image getImgVoleur() {return imgVoleur;}


	//   METHODE   //
	public void bouge() {
		if(super.isVersDroite() ==  true) {
			this.dxVoleur = 1;
		} else {
			this.dxVoleur = -1;
		}
		super.setX(super.getX() + this.dxVoleur);
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(true) {
			if(this.vivant == true) {
				this.bouge();
				try {
					Thread.sleep(PAUSE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		
	}

	public void contact(Objet objet) {
		if(super.contactAvant(objet) == true && isVersDroite() == true ) {
			super.setVersDroite(false);
			this.dxVoleur = -1;
		} else if (super.contactArriere(objet) ==  true && isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxVoleur = 1;
		}
	}
	
	public void contact(Personnage personnage) {
		if(super.contactAvant(personnage) == true && isVersDroite() == true ) {
			super.setVersDroite(false);
			this.dxVoleur = -1;
		} else if (super.contactArriere(personnage) ==  true && isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxVoleur = 1;
		}
	}
	
	public Image meurt() {
		String str;
		Image img;
		ImageIcon ico;
	
		if(this.isVersDroite() == true ) {
			str = "/image/voleurMeurtDroite.png";
		} else {
			str = "/image/voleurMeurtGauche.png";
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img;
	}
	
	
}

