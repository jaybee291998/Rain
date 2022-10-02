package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.tile.Tile;

public class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
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
		// check for collision on the x axis
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
	
//	private boolean collision(int xa, int ya) {
//		int xPlus = (x + xa + 8)>>4;
//		int xMinus = (x + xa - 8)>>4;
//		int yPlus = (y + ya + 15)>>4;
//		int yMinus = (y + ya - 15)>>4;
//		
//		Tile cornerTile1 = level.getTile(xMinus, yMinus);
//		Tile cornerTile2 = level.getTile(xPlus, yMinus);
//		Tile cornerTile3 = level.getTile(xPlus, yPlus);
//		Tile cornerTile4 = level.getTile(xMinus, yPlus);
//
//		return cornerTile1.isSolid() || cornerTile2.isSolid() || cornerTile3.isSolid() || cornerTile4.isSolid();
//	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c%2 * 2 * 8 - 8) >> 4;
			int yt = ((y + ya) + c/2 * 2 * 15 - 15) >> 4;
			if(level.getTile(xt, yt).isSolid()) {
				solid = true;
				break;
			}
		}
		return solid;
	}
}
