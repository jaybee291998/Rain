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
		generateLevel();
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
		// establishing corner pins
		// get all the tiles that will be rendered
		int x0 = (xScroll >> 4);
		int x1 = ((xScroll + screen.width) >> 4) + 1;
		int y0 = (yScroll >> 4);
		int y1 = ((yScroll + screen.height) >> 4) + 1;
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x<<4, y<<4, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		switch(tiles[x + y * width]){
			case 0xff00ff00:
				return Tile.grass;
			case 0xff7f7f00:
				return Tile.stone;
			case 0xffffff00:
				return Tile.flower;
			case 3:
				return Tile.ice;
			default:
				return Tile.voidTile;
		}
	}

}
