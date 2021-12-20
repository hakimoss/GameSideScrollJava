package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.idleClicker.Main;
import com.hakim.objets.Objet;
import com.hakim.objets.Piece;

public class Hero extends Personnage{
	
	private Image imgHero;
	private ImageIcon icoHero;
	private boolean saut; //true si le hero saute
	private int compteurSaut; // dur�e du saut et hauteur du saut
	
	public Hero(int x, int y) {
		super(x, y, 74, 106);
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
	
	@Override
	public Image marche(String nom, int frequence) {

		String str;
		ImageIcon ico;
		Image img;

		if(this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 2700) {
			if(this.versDroite == true) {
				str = "/image/" + nom + "ArretDroite.png";
			} else {
				str = "/image/" + nom + "ArretGauche.png";
			} 
	
		} else {
			this.compteur++;
			if(this.compteur / frequence == 0) {
				if(this.versDroite == true) {
					str = "/image/" + nom + "ArretDroite.png";
				} else {
					str = "/image/" + nom + "ArretGauche.png";
				}
			} else {
				if(this.versDroite == true) {
					str = "/image/" + nom + "MarcheDroite.png";
				} else {
					str = "/image/" + nom + "MarcheGauche.png";
				}
			}
			if(this.compteur == 2 * frequence) {
				this.compteur = 0;
			}
		}
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}

	public void contact(Objet objet) {
		//contact horizontal
		if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)) {
			Main.scene.setDx(0);
			this.setMarche(false);
		}
		// contact avec un objet en dessous
		if(super.contactDessous(objet) == true && this.saut == true) {
			Main.scene.setySol(0);
			this.setMarche(false);
		} else if(super.contactDessous(objet) == false) {
			Main.scene.setySol(326);
			if(this.saut == false) {
				this.setY(220);
			}
		}
		//contact avec un objet au-dessus
		if(super.contactDessus(objet) == true) {
			Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur());	
		} else if(super.contactDessus(objet) == false && this.saut == false) {
			Main.scene.setHauteurPlafond(0);
		}
	}
	
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
	
	
	public boolean contactPiece(Piece piece) {
		
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || this.contactDessus(piece) == true) {
			return true;
		} else {
			return false;
		}
	}
}
