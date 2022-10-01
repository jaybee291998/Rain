package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.input.Keyboard;

public class Player extends Mob{
	public Player() {
		
	}
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(Keyboard key) 
	{
		// get the direction that the player is traveling with
		int xa = 0, ya = 0;
		if(key.up) ya -= 1;
		if(key.down) ya += 1;
		if(key.left) xa -= 1;
		if(key.right) xa += 1;
		
		if(xa != 0 || ya != 0) move(xa ,ya);
	}
	
	public void render(Screen screen) {
		screen.renderPlayer(x, y, sprite.player0);
	}
}
