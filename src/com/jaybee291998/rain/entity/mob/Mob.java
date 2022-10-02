package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.graphics.Sprite;

public class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
		// 0 - north, 1 = east, 2 = south, 3 = west
		//determine the direction of the player based on the movement
		if(xa < 0) dir = 3;
		if(xa > 0) dir = 1;
		if(ya < 0) dir = 0;
		if(ya > 0) dir = 2;
		// check for collision
		if(!collision()) {
			// move the mob
			x += xa;
			y += ya;
		}else {
			if(dir == 0) y += 1;
			if(dir == 2) y -= 1;
			if(dir == 1) x -= 1;
			if(dir == 3) x += 1;
			System.out.println("push back");
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	private boolean collision() {
//		System.out.println("detect collison");
		return level.getTile(x>>4,  y>>4).isSolid();
	}
}
