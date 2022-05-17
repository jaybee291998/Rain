package com.jaybee291998.rain.level.tile;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile stone = new StoneTile(Sprite.stone);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile ice = new IceTile(Sprite.ice);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public  Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
}
