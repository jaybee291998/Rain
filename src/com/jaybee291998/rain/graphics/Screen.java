package com.jaybee291998.rain.graphics;
import java.util.Random;
public class Screen {
	private int width, height;
	public int[] pixels;
	int pos = 0;
	private Random random = new Random();
	private final int MAP_SIZE = 8;
	private final int MAP_SIZE_MASK = MAP_SIZE - 1;
	private int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	// a preformance hack, instead of dividing were just gonna shift to the right
	private int shiftRight = 4;
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if(yp < 0 || yp >= height) continue;
			for(int x= 0; x < width; x++) {
				int xp = x + xOffset;
				if(xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}		
	}
}
