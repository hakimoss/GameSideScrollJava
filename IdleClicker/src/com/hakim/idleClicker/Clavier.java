package com.hakim.idleClicker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

	

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(Main.scene.getxPos() == -1) {
				Main.scene.setxPos(0);
				Main.scene.setxFond1(0);
				Main.scene.setxFond2(900);
			}
			Main.scene.hero.setMarche(true);
			Main.scene.hero.setVersDroite(true);
			Main.scene.setDx(1);
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Main.scene.hero.setMarche(true);
			Main.scene.hero.setVersDroite(false);
			Main.scene.setDx(-1);
		}
		// hero saute
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.scene.hero.setSaut(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.hero.setMarche(false);
		Main.scene.setDx(0);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
}
