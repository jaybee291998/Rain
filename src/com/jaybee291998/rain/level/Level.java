package com.jaybee291998.rain.level;

import com.jaybee291998.rain.graphics.Screen;

public class Level {
	
	private int width, height;
	private int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	private void loadLevel(String path) {		
	}

	private void generateLevel() {
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
	}

}
