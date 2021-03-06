package com.jaybee291998.rain.level;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	protected void loadLevel(String path) {		
	}

	protected void generateLevel() {
	}
	
	public void update() {
		
	}
	
	protected void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x<<4, y<<4, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		switch(tiles[x + y * width]){
			case 0:
				return Tile.grass;
			case 1:
				return Tile.stone;
			case 2:
				return Tile.flower;
			case 3:
				return Tile.ice;
			default:
				return Tile.voidTile;
		}
	}

}
