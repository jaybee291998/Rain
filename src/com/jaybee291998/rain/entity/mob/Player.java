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
		// center the player
		int xx = x - 16, yy = y - 16;
		// change player sprite based on the direction
		switch(dir) {
			case 0:
				screen.renderPlayer(xx, yy, sprite.playerUp);
				break;
			case 1:
				screen.renderPlayer(xx, yy, sprite.playerRight);
				break;
			case 2:
				screen.renderPlayer(xx, yy, sprite.playerDown);
				break;
			case 3:
				screen.renderPlayer(xx, yy, sprite.playerLeft);
				break;
		}
		
//		screen.renderPlayer(xx + 16, yy, sprite.player1);
//		screen.renderPlayer(xx, yy+16, sprite.player2);
//		screen.renderPlayer(xx + 16, yy + 16, sprite.player3);
	}
}
