package com.jaybee291998.rain.level.tile.spawn;

import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.tile.Tile;

public class SpawnWall extends Tile {

	public SpawnWall(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}
}
