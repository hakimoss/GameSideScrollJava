package com.hakim.idleClicker;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;

	public static void main(String[] args) {
		
		JFrame fenetre=new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(900, 400);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		scene=new Scene();
		
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
	}

}
