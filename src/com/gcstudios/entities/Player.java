package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.Camera;
import com.gcstudios.world.World;


public class Player extends Entity{
	
	public boolean isPressed = false;
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
	}
	
	public void tick(){
		depth =2;
		if(!isPressed)
		{
			y+=1;
		}else {
			y-=1;
		}
		
		if(y > Game.HEIGHT) {	
			World.restartGame();	
		}
		if(y < 0) {	
			World.restartGame();	
		}
		for(int i=0; i< Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e != this) {
				if(Entity.isColidding(this, e)) {
				 System.out.println("GameOver!");
				 World.restartGame();
				}
			}
		}
	}
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;		
		if(!isPressed) {
			
			g2.rotate(Math.toRadians(20), this.getX() + width/2, this.getY() +height/2);
			g2.drawImage(sprite, this.getX(), this.getY(),null);
			g2.rotate(Math.toRadians(-20), this.getX() + width/2, this.getY() +height/2);
			
		}else {
			g2.rotate(Math.toRadians(-20), this.getX() + width/2, this.getY() +height/2);
			g2.drawImage(sprite, this.getX(), this.getY(),null);
			g2.rotate(Math.toRadians(20), this.getX() + width/2, this.getY() +height/2);
		}
	}

	

	


}
