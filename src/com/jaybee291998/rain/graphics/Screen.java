package com.jaybee291998.rain.graphics;
import java.util.Random;
public class Screen {
	private int width, height;
	public int[] pixels;
	int pos = 0;
	private Random random = new Random();
	private int tileWidth = 16;
	private int tileHeight = 16;
	private int tilesWidth = 64;
	private int tilesHeight = 64;
	private int[] tiles = new int[tilesWidth * tilesHeight];
	// a preformance hack, instead of dividing were just gonna shift to the right
	private int shiftRight = 4;
	
	private int offsetX = 0;
	private int pixelOffsetX = 0;
	private int everyX = 60;

	private int offsetY = 0;
	private int pixelOffsetY = 0;
	private int everyY = 60;
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < tilesWidth*tilesHeight; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
		if(offsetX >= tilesWidth) offsetX=0;
		if(offsetY >= tilesHeight) offsetY=0;
		if(pixelOffsetX >= tileWidth) {
			pixelOffsetX = 0;
			offsetX++;
		}
		if(pixelOffsetY >= tileHeight) {
			pixelOffsetY = 0;
			offsetY++;
		}
		if(everyX >= 60) everyX=0;
		if(everyY >= 60) everyY=0;
		for(int y = 0; y < height; y++) {
			int yy = y + pixelOffsetY;
//			if(yy < 0 || yy >= height) break;
			for(int x= 0; x < width; x++) {
				int xx = x+pixelOffsetX;
//				if(xx < 0 || xx >= width) break;
//				int tileIndex = (xx>>shiftRight)+offsetX + ((yy>>shiftRight)+offsetY)*tilesHeight;
				int tileIndex = (((xx>>shiftRight)+offsetX)&tilesWidth-1) + (((yy>>shiftRight)+offsetY)&tilesHeight-1)*tilesHeight;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
		everyX++;
		everyY++;
		if(everyX >= 60) pixelOffsetX++;
		if(everyY >= 60) pixelOffsetY++;
		
	}
}
