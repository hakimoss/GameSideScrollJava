package com.hakim.idleClicker;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hakim.objets.Box;
import com.hakim.objets.Chest;
import com.hakim.personnages.Hero;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	private ImageIcon icoStart;
	private Image imgStart;
	
	private int xFond1;
	private int xFond2;
	private int dx;		// déplacement du fond
	private int xPos;   // position dans le jeu
	private int ySol;   // hauteur du sol
	private int hauteurPlafond;    // hauteur du plafond
	
	public Hero hero;
	public Box box1, box2;
	public Chest chest1;
	
	
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
		
		hero=new Hero(220, 600);
		box1=new Box(800, 255);
		box2=new Box(400, 30);
		chest1=new Chest(200, 255);
		
		
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
	
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}
	
	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}
	
	//******  METHODE  *******//
	public void deplacementFond() {	
		
		if(this.xPos >= 0) {
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
		
		//Détection contacte
		if(this.hero.contactAvant(box1) == true) {
			this.hero.setMarche(false);
			this.dx = 0;
		}
		if(this.hero.contactAvant(box2) == true) {
			this.hero.setMarche(false);
			this.dx = 0;
		}
		
		// déplacement des objet fixes
		this.deplacementFond();
		this.box1.deplacement();
		this.box2.deplacement();
		
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		//g2.drawImage(this.hero.marche("hero", 25), 100, 220, null);
		
		g2.drawImage(this.imgStart, 0 - this.xPos, 170, null);
		
		g2.drawImage(this.box1.getImgBox(), this.box1.getX(), this.box1.getY(), null);
		g2.drawImage(this.box2.getImgBox(), this.box2.getX(), this.box2.getY(), null);

		g2.drawImage(this.chest1.getImgChest(), this.chest1.getX() - this.xPos, this.chest1.getY(), null);
		
		if(this.hero.isSaut()) {
			g2.drawImage(this.hero.saute(), this.hero.getX(), this.hero.getY(), null);
		} else {
			g2.drawImage(this.hero.marche("hero", 25), this.hero.getX(), this.hero.getY(), null);

		}
	}
}
