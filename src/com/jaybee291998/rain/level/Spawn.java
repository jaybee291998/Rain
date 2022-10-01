package com.jaybee291998.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spawn extends Level{

	public Spawn(String path) {
		super(path);
		
	}
	
	public void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(Spawn.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Hey we cant find level file!!");
		}
	}
	
	public void generateLevel() {
		
	}

}
