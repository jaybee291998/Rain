package com.jaybee291998.rain.level.tile;

import com.jaybee291998.rain.graphics.Sprite;

public class StoneTile extends Tile{
	
	public StoneTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean isSolid() {
		System.out.println("Hit a rock");
		return true;
	}
}
