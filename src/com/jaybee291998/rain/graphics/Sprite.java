package com.jaybee291998.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	public int[] pixels;
	public int x, y;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite ice = new Sprite(16, 3, 5, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
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
