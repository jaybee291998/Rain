package com.jaybee291998.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	private List<Entity> entities = new LinkedList<Entity>();
	
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
		for(Entity entity : entities) entity.update();
		removeUnusedEntity();
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
		
		for(Entity entity : entities) entity.render(screen);
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
	/**
	 * 
	 * @param x  position of the prjectile
	 * @param y y position of the projectile
	 * @param xa where its going
	 * @param ya
	 * @return whether there is a collison in any of the corner
	 */
	public boolean tileCollision(double x, double y, double xa, double ya, int size) {
		boolean solid = false;
		int projectileSize = 4;
		// get the 4 corner tile,  check if any of those corner tiles are solid
		for(int c = 0; c < 4; c++) {
			double xt = ((x + xa) + c%2 * 2 * projectileSize - projectileSize) / size;
			double yt = ((y + ya) + c/2 * 2 * projectileSize - projectileSize) / size;
			if(getTile((int)xt, (int)yt).isSolid()) {
				solid = true;
				break;
			}
		}
		return solid;
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
		entity.initLevel(this);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	public void removeUnusedEntity() {
		List<Entity> entitiesToRemove = new LinkedList<Entity>();
		for(Entity entity : entities) {
			if(entity.isRemoved()) entitiesToRemove.add(entity);
		}
		
		for(Entity entity : entitiesToRemove) entities.remove(entity);
	}

}
