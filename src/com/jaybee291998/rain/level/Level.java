package com.jaybee291998.rain.level;

import com.jaybee291998.rain.graphics.Screen;

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
	
	protected void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
	}

}
