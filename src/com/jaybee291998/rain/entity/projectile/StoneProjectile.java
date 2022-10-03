package com.jaybee291998.rain.entity.projectile;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.Level;

public class StoneProjectile extends Projectile {

	public StoneProjectile(int x, int y, double angle) {
		super(x, y, angle);
		// TODO Auto-generated constructor stub
		sprite = Sprite.stone;
		speed = 2;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		level = Level.spawn;
	}
	


}
