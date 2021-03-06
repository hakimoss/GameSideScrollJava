package com.hakim.idleClicker;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

import com.hakim.affichage.CompteARebours;
import com.hakim.affichage.Score;
import com.hakim.audio.Audio;
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
	private int dx;		// déplacement du fond
	private int xPos;   // position dans le jeu
	private int ySol;   // hauteur du sol
	private int hauteurPlafond;    // hauteur du plafond
	private boolean ok;
	
	public Hero hero;
	
	public Box box1, box2, box3, box4, box5, box6, box7, box8;
	public Chest chest1, chest2, chest3, chest4, chest5;
	public Piece piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8;
	public Voleur voleur1, voleur2, voleur3;
	public Civil civil1, civil2, civil3, civil4;
	
	private ArrayList<Objet> tabObjets;
	private ArrayList<Piece> tabPieces;
	private ArrayList<Voleur> tabVoleur;
	private ArrayList<Civil> tabCivil;
	
	private Score score;
	private Font police;
	private CompteARebours compteARebours;
	
	//******  CONSTRUCTOR  *******//
	public Scene() {
		super();
				
		this.xFond1 = 0;
		this.xFond2 = 900;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 326;
		this.hauteurPlafond = 0;
		this.ok = true;
		
		icoFond=new ImageIcon(getClass().getResource("/image/backgrounds2.jpg"));
		this.imgFond1=this.icoFond.getImage();
		this.imgFond2=this.icoFond.getImage();
		
		icoStart=new ImageIcon(getClass().getResource("/image/start.png"));
		this.imgStart=this.icoStart.getImage();
		
		icoFin=new ImageIcon(getClass().getResource("/image/fin.png"));
		this.imgFin=this.icoFin.getImage();
		
		hero=new Hero(220, 600);
		hero.setX(300);
		
		voleur1=new Voleur(220, 1200);
		voleur2=new Voleur(220, 1800);
		voleur3=new Voleur(220, 2300);
		voleur1.setX(1200);
		voleur2.setX(1800);
		voleur3.setX(2300);
		
		civil1=new Civil(220, 500);
		civil2=new Civil(220, 800);
		civil3=new Civil(220, 1300);
		civil4=new Civil(220, 2500);
		civil1.setX(500);
		civil2.setX(800);
		civil3.setX(1400);
		civil4.setX(2500);
		
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
		
		tabVoleur = new ArrayList<Voleur>();
		
		this.tabVoleur.add(this.voleur1);
		this.tabVoleur.add(this.voleur2);
		this.tabVoleur.add(this.voleur3);
		
		tabCivil = new ArrayList<Civil>();
		
		this.tabCivil.add(this.civil1);
		this.tabCivil.add(this.civil2);
		this.tabCivil.add(this.civil3);
		this.tabCivil.add(this.civil4);

		
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
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		compteARebours = new CompteARebours();

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
	
	private boolean partieGagnee() {
		if(this.compteARebours.getCompteurTemps() > 0 && this.hero.isVivant() == true && this.score.getNbPieces() == 8 && this.xPos > 2700) {
			if(this.ok == true) {
				Audio.playSound("/audio/win.wav");
				this.ok = false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	private boolean partiePerdu() {
		if(this.hero.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean finDePartie() {
		if(this.partieGagnee() == true || this.partiePerdu() == true ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2=(Graphics2D)g;
		
		//Détection contacte avec objet
		for(int i = 0; i < this.tabObjets.size(); i++) {
			if(this.hero.proche(this.tabObjets.get(i))) {
				this.hero.contact(this.tabObjets.get(i));
			}
			for(int x = 0; x < this.tabVoleur.size();x++) {
				if(x != i) {
					if(this.tabVoleur.get(x).proche(this.tabObjets.get(i))) {
						this.tabVoleur.get(x).contact(this.tabObjets.get(i));
					}
				}
			
			}
			for(int x = 0; x < this.tabCivil.size(); x++) {
				if(x != i) {
					if(this.tabCivil.get(x).proche(this.tabObjets.get(i))) {
						this.tabCivil.get(x).contact(this.tabObjets.get(i));
					}
				}
				
			}

		}
		//Détection contacte avec piece
		for(int i = 0; i < tabPieces.size(); i++) {
			if(this.hero.proche(this.tabPieces.get(i)) ) {
				if(this.hero.contactPiece(this.tabPieces.get(i))) {
					this.score.setNbPieces(this.score.getNbPieces() + 1);
					this.tabPieces.remove(i);
					Audio.playSound("/audio/coin.wav");
				}
			}
		}
		// detection contacte entre npc
		for(int i = 0; i < tabVoleur.size(); i++) {
			for(int j = 0; j < tabCivil.size(); j++) {
				if(j != i) {
					if(this.tabVoleur.get(i).proche(tabCivil.get(j))) {
						this.tabVoleur.get(i).contact(tabCivil.get(j));
					}
				}
			}
			for(int j = 0; j < tabVoleur.size(); j++) {
				if(j != i) {
					if(this.tabVoleur.get(j).proche(tabVoleur.get(i))) {
						this.tabVoleur.get(j).contact(tabVoleur.get(i));
					}
				}	
			}
			
		}
		for(int i = 0; i < tabCivil.size(); i++) {
			for(int c = 0; c < tabCivil.size(); c++) {
				if(c != i) {
					if(this.tabCivil.get(c).proche(tabCivil.get(i))) {
						this.tabCivil.get(c).contact(tabCivil.get(i));
					}	
				}
					

			}
			for(int v = 0; v < tabVoleur.size(); v++) {
				if(v != i) {
					if(this.tabVoleur.get(v).proche(tabCivil.get(i))) {
						this.tabVoleur.get(v).contact(tabCivil.get(i));
					}
				}
				
			}
		}
		// contact avec le hero et les npc
		for(int i = 0; i < tabVoleur.size(); i++) {
			if(this.hero.proche(tabVoleur.get(i)) && this.tabVoleur.get(i).isVivant() == true) {
				this.hero.contact(tabVoleur.get(i));
				if(this.tabVoleur.get(i).isVivant() == false) {
					Audio.playSound("/audio/ecrase.wav");
				}
			}
		}
		for(int i = 0; i < tabCivil.size(); i++) {
			if(this.hero.proche(tabCivil.get(i)) && this.tabCivil.get(i).isVivant() == true) {
				this.hero.contact(tabCivil.get(i));
				if(this.tabCivil.get(i).isVivant() == false) {
					Audio.playSound("/audio/ecrase.wav");
				}
			}
		}
		

		// déplacement des objet fixes
		
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 2700) {
			for(int i = 0; i < this.tabObjets.size(); i++) {
				this.tabObjets.get(i).deplacement();
			}	

			for(int i = 0; i < this.tabPieces.size(); i++) {
				this.tabPieces.get(i).deplacement();	
			}
			
			for(int i = 0; i < tabVoleur.size(); i++) {
				this.tabVoleur.get(i).deplacement();
			}
			for(int i = 0; i < tabCivil.size(); i++) {
				this.tabCivil.get(i).deplacement();
			}

		}
		
		// image du fond1 et fond 2
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		//image de départ et de fin
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
		if(this.hero.isVivant() == true) {
			if(this.hero.isSaut()) {
				g2.drawImage(this.hero.saute(), this.hero.getX(), this.hero.getY(), null);
			} else {
				g2.drawImage(this.hero.marche("hero", 25), this.hero.getX(), this.hero.getY(), null);

			}
		} else {
			g2.drawImage(this.hero.meurt(), this.hero.getX(), this.hero.getY(), null);
		}
		
		// image des voleurs
		for(int i = 0; i < tabVoleur.size(); i++) {
			if(this.tabVoleur.get(i).isVivant() == true) {
				g2.drawImage(this.tabVoleur.get(i).marche("voleur", 45), this.tabVoleur.get(i).getX(), this.tabVoleur.get(i).getY(), null);

			} else {
				g2.drawImage(this.tabVoleur.get(i).meurt(), this.tabVoleur.get(i).getX(), this.tabVoleur.get(i).getY(), null);
			}
		}
		//image des Civils
		for(int i = 0; i < tabCivil.size(); i++) {
			if(this.tabCivil.get(i).isVivant() == true) {
				g2.drawImage(this.tabCivil.get(i).marche("civil", 60), this.tabCivil.get(i).getX(), this.tabCivil.get(i).getY(), null);
			} else {
				g2.drawImage(this.tabCivil.get(i).meurt(), this.tabCivil.get(i).getX(), this.tabCivil.get(i).getY(), null);
			}
		
		
		}
		System.out.println(this.xPos);
		//mise a jour du score
		g2.setFont(police);
		g2.drawString(this.score.getNbPieces() + " pičce(s) trouvée(s) sur " + this.score.getNB_TOTAL_PIECES(), 660, 25);
		
		// compte a rebours
		g2.drawString(this.compteARebours.getStr(), 5, 25);

		//fin de partie
		if(finDePartie() == true) {
			Font policeFin = new Font("Arial", Font.BOLD, 50);
			g2.setFont(policeFin);
			if(partieGagnee() == true) {
				g2.drawString("Vous avez gagné !", 220, 180);
			} else {
				g2.drawString("Vous avez perdu ...", 220, 180);
			}
		}
		
	}
}
