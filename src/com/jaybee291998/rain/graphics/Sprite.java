package com.jaybee291998.rain.graphics;

public class Sprite {
	
	private final int width, height;
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
	
	// projectile sprites
	public static Sprite stoneProjectile = new Sprite(16, 3, 0, SpriteSheet.tiles);
	// sprites associated to players direction
	//
	public static Sprite[] playerForwardSprites = {playerForward, playerForward1, playerForward2};
	public static Sprite[] playerBackSprites = {playerBack, playerBack1, playerBack2};
	public static Sprite[] playerSideSprites = {playerSide, playerSide1, playerSide2};
	
	public static Sprite orangeWall = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite redWall = new Sprite(16, 2, 1, SpriteSheet.tiles);

	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		width = size;
		height = size;
		pixels = new int[width * height];
		// staring coordinate of the sprite
		this.x = x * width;
		this.y = y * height;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		width = size;
		height = size;
		pixels = new int[width * height];
		setColor(color);
	}
	
	public void setColor(int color) {
		for(int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				pixels[col + row * width] = sheet.pixels[(x+col) + (y + row) * sheet.SIZE];
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
