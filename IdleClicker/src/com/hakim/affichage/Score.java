package com.hakim.affichage;

public class Score {
	
	private final int NB_TOTAL_PIECES = 8;
	private int nbPieces;
	
	public Score() {
		this.nbPieces = 0;
	}

	
	//   GETTERS   //
	public int getNbPieces() {return nbPieces;}
	
	public int getNB_TOTAL_PIECES() {return NB_TOTAL_PIECES;}

	//  SETTERS   //
	public void setNbPieces(int nbPieces) {this.nbPieces = nbPieces;}

}
