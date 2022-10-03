package com.jaybee291998.rain.entity.projectile;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;

public abstract class Projectile extends Entity {
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx ,ny;
	protected double speed, rateOfFire, range, damage;
	
	public Projectile(int x, int y, double angle) {
		xOrigin = x;
		yOrigin = y;
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	public void update() {
		int travDist = calculateTravelledDistance();
		removed = travDist > range;
		move();
	}
	
	// calculate the travelled distance of the tile from its origin to its present location
	private int calculateTravelledDistance() {
		double xSquared = Math.pow(x - xOrigin, 2);
		double ySquared = Math.pow(y - yOrigin, 2);
		
		return (int) Math.ceil(Math.sqrt(xSquared + ySquared));
	}
	
	public void move() {
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen) {
		screen.renderTile(x, y, sprite);
	}
}
