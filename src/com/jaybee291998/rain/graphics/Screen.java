package com.jaybee291998.rain.graphics;
import java.util.Random;

import com.jaybee291998.rain.entity.projectile.Projectile;
import com.jaybee291998.rain.level.tile.Tile;
public class Screen {
	public int width, height;
	private int xOffset, yOffset;
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
	
	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite playerSprite, boolean xFlip, boolean yFlip) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < playerSprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if(yFlip) ys = playerSprite.SIZE - 1 - y;
			for(int x = 0; x < playerSprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				if(xFlip) xs = playerSprite.SIZE - 1 - x;
				if(xa < -playerSprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int color = playerSprite.pixels[xs + ys * playerSprite.SIZE];
				// don render background which is pink
				if(color != 0xffff00ff) pixels[xa + ya * width] = color;
				
			}
		}
	}
	
	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			for(int x = 0; x < p.getSpriteSize(); x++) {
				int xa = x + xp;
				if(xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int color = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if(color != 0xffff00ff) pixels[xa + ya * width] = color;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
