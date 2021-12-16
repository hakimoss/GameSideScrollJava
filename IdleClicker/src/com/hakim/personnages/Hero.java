package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.idleClicker.Main;

public class Hero extends Personnage{
	
	private Image imgHero;
	private ImageIcon icoHero;
	private boolean saut; //true si le hero saute
	private int compteurSaut; // dur�e du saut et hauteur du saut
	
	public Hero(int x, int y) {
		super(x, y, 74, 106);
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		this.icoHero = new ImageIcon(getClass().getResource("/image/heroMarcheDroite.png"));
		this.imgHero = this.icoHero.getImage();
		this.saut = false;
		this.compteurSaut = 0;
	}
	
	//*** GETTERS ***//
	public Image getImgHero() {return imgHero;}

	public boolean isSaut() {return saut;}
	
	//*** SETTERS ***//
	public void setSaut(boolean saut) {this.saut = saut;}
	
	//*** METHODS ***//
	public Image saute() {
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteurSaut++;
		// mont� du saut
		if(this.compteurSaut <=100) {
			if(this.getY() > Main.scene.getHauteurPlafond()) {
				this.setY(this.getY() - 3);
			} else {
				this.compteurSaut = 101;
			}
			if(this.isVersDroite() == true) {
				str = "/image/heroJumpDroite.png";
			} else {
				str = "/image/heroJumpGauche.png";
			}				
		// retomb� du saut				
		} else if(this.getY() + this.getHauteur() < Main.scene.getySol()) {
			this.setY(this.getY() + 1);
			if(this.isVersDroite() == true) {
				str = "/image/heroJumpDroite.png";
			} else {
				str = "/image/heroJumpGauche.png";
			}
		// saut termin�
		} else {
			if(this.isVersDroite() == true) {
				str = "/image/heroArretDroite.png";
			} else {
				str = "/image/heroArretGauche.png";
			}
			this.saut = false;
			this.compteurSaut = 0;
		}
		// Affichage de l'image
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
		
	}
	
}