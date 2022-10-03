package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.tile.Tile;

public class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean sprinting = false;
	protected int sprintMultiplier = 4;
	
	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		// 0 - north, 1 = east, 2 = south, 3 = west
		//determine the direction of the player based on the movement
		if(xa < 0) dir = 3;
		if(xa > 0) dir = 1;
		if(ya < 0) dir = 0;
		if(ya > 0) dir = 2;
		// move the mob proportional to the sprint multiplier
		if(sprinting) {
			xa *= sprintMultiplier;
			ya *= sprintMultiplier;
		}
		if(!collision(xa, ya)) {
			// move the mob
			x += xa;
			y += ya;
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}

	protected void shoot(double dir) {
		dir = dir * (180 / Math.PI);
		System.out.println("Angle: " + dir);
	}
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		// get the 4 corner tile,  check if any of those corner tiles are solid
		for(int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c%2 * 2 * 7 - 7) >> 4;
			int yt = ((y + ya) + c/2 * 2 * 15 - 15) >> 4;
			if(level.getTile(xt, yt).isSolid()) {
				solid = true;
				break;
			}
		}
		return solid;
	}
	
	protected void setSprint(boolean isSprinting) {
		sprinting = isSprinting;
	}
}
