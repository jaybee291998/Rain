package com.jaybee291998.rain.entity;

import java.util.Random;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		// remove the entuty from the level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
