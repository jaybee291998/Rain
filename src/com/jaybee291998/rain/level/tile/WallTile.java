package com.jaybee291998.rain.level.tile;

import com.jaybee291998.rain.graphics.Sprite;

public class WallTile extends Tile {

	public WallTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean isSolid() {
		return true;
	}

}
