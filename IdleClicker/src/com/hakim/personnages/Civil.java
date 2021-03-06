package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.objets.Objet;

public class Civil extends Personnage implements Runnable {

	private Image imgCivil;
	private ImageIcon icoCivil;
	
	private int dxCivil;
	private final int PAUSE = 15;
	
	public Civil(int x, int y) {
		super(x, y, 57, 107);
		
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxCivil = 1;
		
		this.icoCivil = new ImageIcon(getClass().getResource("/image/civilArretDroite.png"));
		this.imgCivil = this.icoCivil.getImage();
		
		Thread chronoCivil = new Thread(this);
		chronoCivil.start();
	}
	
	//   GETTERS   //
	public Image getImgCivil() {return imgCivil;}
	
	//   METHODS   //
	
	public void bouge() {
		if(super.isVersDroite() == true) {
			this.dxCivil = 1;
		} else {
			this.dxCivil = -1;
		}
		super.setX(super.getX() + this.dxCivil);
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
			this.dxCivil = -1;
		} else if (super.contactArriere(objet) ==  true && isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxCivil = 1;
		}
	}
	
	public void contact(Personnage personnage) {
		if(super.contactAvant(personnage) == true && isVersDroite() == true ) {
			super.setVersDroite(false);
			this.dxCivil = -1;
		} else if (super.contactArriere(personnage) ==  true && isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxCivil = 1;
		}
	}
	
	public Image meurt() {
		String str;
		Image img;
		ImageIcon ico;
	
		if(this.isVersDroite() == true ) {
			str = "/image/civilMeurtDroite.png";
		} else {
			str = "/image/civilMeurtGauche.png";
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img;
	}

}
