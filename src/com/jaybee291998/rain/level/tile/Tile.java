package com.jaybee291998.rain.level.tile;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.tile.spawn.SpawnFloor;
import com.jaybee291998.rain.level.tile.spawn.SpawnGrass;
import com.jaybee291998.rain.level.tile.spawn.SpawnWall;
import com.jaybee291998.rain.level.tile.spawn.SpawnWater;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile stone = new StoneTile(Sprite.stone);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile ice = new IceTile(Sprite.ice);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawnGrass = new SpawnGrass(Sprite.spawnGrass);
	public static Tile spawnWall1 = new SpawnWall(Sprite.spawnWall1);
	public static Tile spawnWall2 = new SpawnWall(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloor(Sprite.spawnFloor);
	public static Tile spawnWater = new SpawnWater(Sprite.spawnWater);
	
	// corresponding pixel color to a tile
	public static final int colSpawnGrass = 0xff00ff00;
	public static final int colSpawnWall1 = 0xff7f7f7f;
	public static final int colSpawnWall2 = 0xff6e6e6e;
	public static final int colSpawnFloor = 0xff9c8141;
	public static final int colSpawnWater = 0xff3555a8;
	
	
	public  Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this.sprite);
	}
	
	public boolean isSolid() {
		return false;
	}
}
