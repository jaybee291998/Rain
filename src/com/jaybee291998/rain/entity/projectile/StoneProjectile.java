package com.jaybee291998.rain.entity.projectile;

import com.jaybee291998.rain.entity.mob.Mob;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.level.Level;

public class StoneProjectile extends Projectile {

	public StoneProjectile(int x, int y, double angle, Mob mob) {
		super(x, y, angle, mob);
		range = 100;
		sprite = Sprite.stoneProjectile;
		speed = 2;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		level = Level.spawn;
	}
	


}
