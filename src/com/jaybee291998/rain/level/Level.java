package com.jaybee291998.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public static Level spawn = new Spawn("/levels/new_spawn.png");
	
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
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(Spawn.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Hey we cant find level file!!");
		}
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
			case Tile.colSpawnGrass:
				return Tile.spawnGrass;
			case Tile.colSpawnFloor:
				return Tile.spawnFloor;
			case Tile.colSpawnWall1:
				return Tile.spawnWall1;
			case Tile.colSpawnWall2:
				return Tile.spawnWall2;
			case Tile.colSpawnWater:
				return Tile.spawnWater;
			default:
				return Tile.voidTile;
		}
	}

}
