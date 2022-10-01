package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.input.Keyboard;

public class Player extends Mob{
	private Keyboard key;
	public Player(Keyboard key) {
		this.key = key;
		sprite = sprite.playerForward;
	}
	
	public Player(int x, int y, Keyboard key) {
		this.x = x;
		this.y = y;
		this.key = key;
		sprite = sprite.playerForward;
	}
	
	public void update() 
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
		// change player sprite based on the direction
		boolean xFlip = false;
		switch(dir) {
			case 0:
				sprite = sprite.playerBack;
				break;
			case 1:
				sprite = sprite.playerSide;
				break;
			case 2:
				sprite = sprite.playerForward;
				break;
			case 3:
				sprite = sprite.playerSide;
				xFlip = true;
				break;
		}
		screen.renderPlayer(x - 16, y -16, sprite, xFlip, false);
		
//		screen.renderPlayer(xx + 16, yy, sprite.player1);
//		screen.renderPlayer(xx, yy+16, sprite.player2);
//		screen.renderPlayer(xx + 16, yy + 16, sprite.player3);
	}
}
