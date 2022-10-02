package com.jaybee291998.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	public int[] pixels;
	public int x, y;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 5, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite ice = new Sprite(16, 5, 3, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0xd2691e);
	
	// spawn sprites
	public static Sprite spawnGrass = new Sprite(16, 0, 5, SpriteSheet.tiles);
	public static Sprite spawnWall1 = new Sprite(16, 2, 3, SpriteSheet.tiles);
	public static Sprite spawnWall2 = new Sprite(16, 2, 4, SpriteSheet.tiles);
	public static Sprite spawnFloor = new Sprite(16, 4, 4, SpriteSheet.tiles);
	public static Sprite spawnWater = new Sprite(16, 5, 2, SpriteSheet.tiles);
	// player tiles
	public static Sprite playerForward = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerBack = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerSide = new Sprite(32, 1, 5, SpriteSheet.tiles);
	
	public static Sprite playerForward1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerForward2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	public static Sprite playerBack1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerBack2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite playerSide1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		// staring coordinate of the sprite
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	public void setColor(int color) {
		for(int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int row = 0; row < SIZE; row++) {
			for(int col = 0; col < SIZE; col++) {
				pixels[col + row * SIZE] = sheet.pixels[(x+col) + (y + row) * sheet.SIZE];
			}
		}
	}
	
	private Sprite flipHorizontally() {
		// flip a sprite horizontally
		int n = SIZE;
		Sprite flippedSprite = new Sprite(n, 0);
		int halfSize = n / 2;
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < halfSize; x++) {
				flippedSprite.pixels[x + y * n] = pixels[(n - x - 1) + y * n];
				flippedSprite.pixels[(n-x-1) + y*n] = pixels[x + y * n];
			}
		}
		
		return flippedSprite;
	}
}
