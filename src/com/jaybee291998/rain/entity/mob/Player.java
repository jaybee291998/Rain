package com.jaybee291998.rain.entity.mob;

import com.jaybee291998.rain.Game;
import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.input.Keyboard;
import com.jaybee291998.rain.input.Mouse;
import com.jaybee291998.rain.level.Level;

public class Player extends Mob{
	// the higher the slower the shooting
	public static final int FIRE_RATE = 20; // max number of ticks before next fire
	private Keyboard key;
	private int anim = 0;
	// remaining ticks before we can fire again
	private int time_before_another_shot = FIRE_RATE;
	public Player(Keyboard key, Level level, int x, int y) {
		this.key = key;
		this.level = level;
		sprite = sprite.playerForward;
		this.x = x;
		this.y = y;
	}
	
	public Player(int x, int y, Keyboard key) {
		this.x = x;
		this.y = y;
		this.key = key;
		sprite = sprite.playerForward;
	}
	
	public void update() 
	{
		if(time_before_another_shot >= 0) time_before_another_shot--;
		if(Mouse.getButton() == 1){
			if(time_before_another_shot <= 0) {
				time_before_another_shot = FIRE_RATE;
				updateShooting();
			}
			
		}
		// animation counter
		if(anim < 10000) anim++;
		else anim = 0;
		// get the direction that the player is traveling with
		int xa = 0, ya = 0;
		if(key.up) ya -= 1;
		if(key.down) ya += 1;
		if(key.left) xa -= 1;
		if(key.right) xa += 1;
		setSprint(key.shift);
		
		if(xa != 0 || ya != 0) {
			move(xa ,ya);
			moving = true;
		}else {
			moving = false;
		}
	}
	
	private void updateShooting() {
		double dx = Mouse.getX() - Game.getWindowWidth() / 2; 
		double dy = Mouse.getY() - Game.getWindowHeight() / 2;
		double dir = Math.atan2(dy, dx);
		shoot(dir);
		
	}

	public void render(Screen screen) {
		// change player sprite based on the direction
		boolean xFlip = false;
		// number of cycles to complete the animation
		int cycles = 40;
		if(sprinting) cycles /= sprintMultiplier; 
		int d = cycles / 4;
		int anim_mod_cycles = anim % cycles;
		
		boolean cycle1 = anim_mod_cycles > d && anim_mod_cycles <= cycles - d;
		boolean cycle2 = anim_mod_cycles > cycles - d && anim_mod_cycles <= cycles;
		Sprite[] spritePack = Sprite.playerForwardSprites;
		switch(dir) {
			case 0:
				sprite = Sprite.playerBack;
				if(moving) {
					spritePack = Sprite.playerBackSprites;
				}
				break;
			case 1:
				sprite = Sprite.playerSide;
				if(moving) {
					spritePack = Sprite.playerSideSprites;
				}
				break;
			case 2:
				sprite = Sprite.playerForward;
				if(moving) {
					spritePack = Sprite.playerForwardSprites;
				}
				break;
			case 3:
				sprite = Sprite.playerSide;
				if(moving) {
					spritePack = Sprite.playerSideSprites;
				}
				xFlip = true;
				break;
		}
		if(moving) {
			if(cycle1) sprite = spritePack[1];
			if(cycle2) sprite = spritePack[2];
		}	
		screen.renderPlayer(x - 16, y -16, sprite, xFlip, false);
		
	}
}
