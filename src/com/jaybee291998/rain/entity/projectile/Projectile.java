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
		move();
	}
	
	public void move() {
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen) {
		screen.renderTile(x, y, sprite);
	}
}
