package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.input.Keyboard;
import com.jaybee291998.rain.level.Level;

public class Player extends Mob{
	private Keyboard key;
	private int anim = 0;
	public Player(Keyboard key, Level level) {
		this.key = key;
		this.level = level;
		sprite = sprite.playerForward;
		x = (level.getWidth() / 2)<<4;
		y = (level.getHeight() / 2)<<4;
	}
	
	public Player(int x, int y, Keyboard key) {
		this.x = x;
		this.y = y;
		this.key = key;
		sprite = sprite.playerForward;
	}
	
	public void update() 
	{
		// animation counter
		if(anim < 10000) anim++;
		else anim = 0;
		// get the direction that the player is traveling with
		int xa = 0, ya = 0;
		if(key.up) ya -= 1;
		if(key.down) ya += 1;
		if(key.left) xa -= 1;
		if(key.right) xa += 1;
		
		if(xa != 0 || ya != 0) {
			move(xa ,ya);
			moving = true;
		}else {
			moving = false;
		}
	}
	
	public void render(Screen screen) {
		// change player sprite based on the direction
		boolean xFlip = false;
		switch(dir) {
			case 0:
				sprite = sprite.playerBack;
				if(moving) {
					if(anim % 40 > 10 && anim % 40 <= 30) sprite = sprite.playerBack1;
					if(anim % 40 > 30 && anim % 40 <= 40) sprite = sprite.playerBack2;
				}
				break;
			case 1:
				sprite = sprite.playerSide;
				if(moving) {
					if(anim % 40 > 10 && anim % 40 <= 30) sprite = sprite.playerSide1;
					if(anim % 40 > 30 && anim % 40 <= 40) sprite = sprite.playerSide2;
				}
				break;
			case 2:
				sprite = sprite.playerForward;
				if(moving) {
					if(anim % 40 > 10 && anim % 40 <= 30) sprite = sprite.playerForward1;
					if(anim % 40 > 30 && anim % 40 <= 40) sprite = sprite.playerForward2;
				}
				break;
			case 3:
				sprite = sprite.playerSide;
				if(moving) {
					if(anim % 40 > 10 && anim % 40 <= 30) sprite = sprite.playerSide1;
					if(anim % 40 > 30 && anim % 40 <= 40) sprite = sprite.playerSide2;
				}
				xFlip = true;
				break;
		}
		screen.renderPlayer(x - 16, y -16, sprite, xFlip, false);
		
//		screen.renderPlayer(xx + 16, yy, sprite.player1);
//		screen.renderPlayer(xx, yy+16, sprite.player2);
//		screen.renderPlayer(xx + 16, yy + 16, sprite.player3);
	}
}
