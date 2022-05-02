package com.jaybee291998.rain.graphics;

public class Sprite {
	
	private final int SIZE;
	private int[] pixels;
	public int x, y;
	private SpriteSheet sheet;
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		load();
	}
	
	private void load() {
		for(int row = 0; row < SIZE; row++) {
			for(int col = 0; col < SIZE; col++) {
				pixels[col + row * SIZE] = sheet.pixels[(x+col) + (y + row) * sheet.SIZE];
			}
		}
	}
}
