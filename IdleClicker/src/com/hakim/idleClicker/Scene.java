package com.hakim.idleClicker;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hakim.objets.Box;
import com.hakim.objets.Chest;
import com.hakim.objets.Objet;
import com.hakim.objets.Piece;
import com.hakim.personnages.Civil;
import com.hakim.personnages.Hero;
import com.hakim.personnages.Voleur;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	private ImageIcon icoStart;
	private Image imgStart;
	private ImageIcon icoFin;
	private Image imgFin;
	
	
	private int xFond1;
	private int xFond2;
	private int dx;		// d�placement du fond
	private int xPos;   // position dans le jeu
	private int ySol;   // hauteur du sol
	private int hauteurPlafond;    // hauteur du plafond
	
	public Hero hero;
	public Voleur voleur;
	public Civil civil;
	
	public Box box1, box2, box3, box4, box5, box6, box7, box8;
	public Chest chest1, chest2, chest3, chest4, chest5;
	public Piece piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8;
	
	private ArrayList<Objet> tabObjets;
	private ArrayList<Piece> tabPieces;
	
	//******  CONSTRUCTOR  *******//
	public Scene() {
		super();
				
		this.xFond1 = 0;
		this.xFond2 = 900;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 326;
		this.hauteurPlafond = 0;
		
		icoFond=new ImageIcon(getClass().getResource("/image/backgrounds2.jpg"));
		this.imgFond1=this.icoFond.getImage();
		this.imgFond2=this.icoFond.getImage();
		
		icoStart=new ImageIcon(getClass().getResource("/image/start.png"));
		this.imgStart=this.icoStart.getImage();
		
		icoFin=new ImageIcon(getClass().getResource("/image/fin.png"));
		this.imgFin=this.icoFin.getImage();
		
		hero=new Hero(220, 600);
		hero.setX(300);
		voleur=new Voleur(220, 2900);
		voleur.setX(1200);
		civil=new Civil(220, 500);
		civil.setX(1400);
		
		box1=new Box(800, 255);
		box2=new Box(400, 30);
		box3=new Box(1100, 155);
		box4=new Box(1400, 30);
		box5=new Box(1600, 155);
		box6=new Box(1900, 155);
		box7=new Box(2050, 255);

		//chest1=new Chest(600, 255);
		chest2=new Chest(2200, 255);
		
		piece1=new Piece(550, 30);
		piece2=new Piece(600, 30);
		piece3=new Piece(650, 30);
		piece4=new Piece(700, 30);
		piece5=new Piece(750, 30);
		piece6=new Piece(800, 30);
		piece7=new Piece(850, 30);
		piece8=new Piece(900, 30);
		
		tabObjets = new ArrayList<Objet>();
		
		this.tabObjets.add(this.box1);
		this.tabObjets.add(this.box2);
		this.tabObjets.add(this.box3);
		this.tabObjets.add(this.box4);
		this.tabObjets.add(this.box5);
		this.tabObjets.add(this.box6);
		this.tabObjets.add(this.box7);

		//this.tabObjets.add(this.chest1);
		this.tabObjets.add(this.chest2 );
		
		tabPieces = new ArrayList<Piece>();
		
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
			
		Thread chronoEcran=new Thread(new Chrono());
		chronoEcran.start();
		
	}
	
	//******  GETTER  *******//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHauteurPlafond() {return hauteurPlafond;}

	//******  SETTER  *******//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}
	
	public void setySol(int ySol) {this.ySol = ySol;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}
	
	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}
	
	public void setHauteurPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	//******  METHODE  *******//
	public void deplacementFond() {	
		
		if(this.xPos >= 0 && this.xPos <= 2700) {
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;	
			this.xFond2 = this.xFond2 - this.dx;
		}
		
		if(this.xFond1 == -900) {this.xFond1 = 900;} 
		else if(this.xFond2 == -900) {this.xFond2 = 900;}
		else if(this.xFond1 == 900) {this.xFond1 = -900;} 
		else if(this.xFond2 == 900) {this.xFond2 = -900;}	
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2=(Graphics2D)g;
		
		//D�tection contacte avec objet
		for(int i = 0; i < this.tabObjets.size(); i++) {
			if(this.hero.proche(this.tabObjets.get(i))) {
				this.hero.contact(this.tabObjets.get(i));
			}
			if(this.voleur.proche(tabObjets.get(i))) {
				this.voleur.contact(this.tabObjets.get(i));
			}
			if(this.civil.proche(tabObjets.get(i))) {
				this.civil.contact(tabObjets.get(i));
			}
		}
		//D�tection contacte avec piece
		for(int i = 0; i < tabPieces.size(); i++) {
			if(this.hero.proche(this.tabPieces.get(i)) ) {
				if(this.hero.contactPiece(this.tabPieces.get(i))) {
					this.tabPieces.remove(i);
				}
			}
		}
		
		if(this.voleur.proche(civil)) {
			this.voleur.contact(civil);
		}
		if(this.civil.proche(voleur)) {
			this.civil.contact(voleur);
		}

		// d�placement des objet fixes
		
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 2700) {
			for(int i = 0; i < this.tabObjets.size(); i++) {
				this.tabObjets.get(i).deplacement();
			}	

			for(int i = 0; i < this.tabPieces.size(); i++) {
				this.tabPieces.get(i).deplacement();	
			}
			this.voleur.deplacement();
			this.civil.deplacement();
		}
		
		// image du fond1 et fond 2
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		//image de d�part et de fin
		g2.drawImage(this.imgStart, 0 - this.xPos, 170, null);
		g2.drawImage(this.imgFin, 2700 - this.xPos, 250, null);
		// image des objet
		for(int i = 0;i < this.tabObjets.size(); i++) {
			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
		}
		// image des piece
		for(int i = 0; i < this.tabPieces.size(); i++) {
			g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
		}
		// image du hero
		if(this.hero.isSaut()) {
			g2.drawImage(this.hero.saute(), this.hero.getX(), this.hero.getY(), null);
		} else {
			g2.drawImage(this.hero.marche("hero", 25), this.hero.getX(), this.hero.getY(), null);

		}
		// image du voleur
		g2.drawImage(this.voleur.marche("voleur", 45), this.voleur.getX(), this.voleur.getY(), null);
		// image du civil
		g2.drawImage(this.civil.marche("civil", 60), this.civil.getX(), this.civil.getY(), null);
	}
}
