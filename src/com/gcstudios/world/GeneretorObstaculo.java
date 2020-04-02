package com.gcstudios.world;

import com.gcstudios.entities.Entity;
import com.gcstudios.entities.Obstaculo;
import com.gcstudios.main.Game;

public class GeneretorObstaculo {
	
	public int time = 0;
	public int time2 = 0;
	public int targetTime = 60;
	
	public void tick() {
		time++;
		time2++;
		if(time==60) {
			//
			int altura1 = Entity.rand.nextInt(65 - 30)+30;
			Obstaculo obstaculo1 = new Obstaculo(Game.WIDTH,0,20,altura1,1,Game.spritesheet.getSprite(16, 0, 16, 16));
			
			
			int altura2 = Entity.rand.nextInt(65 - 30)+30;
			Obstaculo obstaculo2 = new Obstaculo(Game.WIDTH,Game.HEIGHT-altura2,20,altura2,1,null);
			Game.entities.add(obstaculo1);

			
			time =0;
		}
		if(time2==50) {
			int altura2 = Entity.rand.nextInt(65 - 30)+30;
			Obstaculo obstaculo2 = new Obstaculo(Game.WIDTH,Game.HEIGHT-altura2,20,altura2,1,Game.spritesheet.getSprite(0, 16, 16, 16));
					//Game.WIDTH,Game.HEIGHT-altura2,20,altura2,1,null);
			Game.entities.add(obstaculo2);
			time2=0;
		}
		
	}
}
