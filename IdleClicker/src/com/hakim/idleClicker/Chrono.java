package com.hakim.idleClicker;

public class Chrono implements Runnable{

	private final int PAUSE = 3; // temps d'attente entre 2 tours de boucle
	
	@Override
	public void run() {
		while(true) {
			
			Main.scene.repaint();
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
