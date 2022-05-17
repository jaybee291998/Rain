package com.jaybee291998.rain.level.tile;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;

public class VoidTile extends Tile{

	public VoidTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
