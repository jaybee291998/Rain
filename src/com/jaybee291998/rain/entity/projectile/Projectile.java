package com.jaybee291998.rain.entity.projectile;

import com.jaybee291998.rain.entity.Entity;
import com.jaybee291998.rain.entity.mob.Mob;
import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;

public abstract class Projectile extends Entity {
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected double x, y;
	protected Sprite sprite;
	protected double nx ,ny;
	protected double speed, range, damage;
	// where this projectile comes from
	protected Mob mob;
	
	public Projectile(int x, int y, double angle, Mob mob) {
		xOrigin = x;
		yOrigin = y;
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.mob = mob;
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
		if(!level.tileCollision(x, y, nx, ny, 16)){
			x += nx;
			y += ny;
		}else {
			removed = true;
		}

	}
	
	public void render(Screen screen) {
		screen.renderProjectile((int) x - 8, (int) y - 8, this);
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.getWidth();
	}
}
