package com.jaybee291998.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.jaybee291998.rain.entity.mob.Player;
import com.jaybee291998.rain.graphics.Screen;
import com.jaybee291998.rain.graphics.Sprite;
import com.jaybee291998.rain.input.Keyboard;
import com.jaybee291998.rain.input.Mouse;
import com.jaybee291998.rain.level.Level;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	public static String title = "Rain";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Mouse mouse;
//	private RandomLevel randomLevel;
	private Level level;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private int xOffset = 0;
	private int yOffset = 0;
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		mouse = new Mouse();
//		randomLevel = new RandomLevel(32, 32);
		level = Level.testLevel;
		player = new Player(key, level, level.getWidth()*8 + 10, level.getHeight()*8 + 10);
		
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1_000_000_000.0/60.0;
		double delta = 0;
		double elapsed = 0;
		int frames = 0;
		int updates = 0;
		while(running) {
			long now = System.nanoTime();
			elapsed = now - lastTime;
			delta += elapsed/ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				delta--;
				updates++;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update() {
		key.update();
		player.update();
		level.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
//		screen.render(xOffset, yOffset);
		int xScroll = player.x - width/2;
		int yScroll = player.y - height/2;
		level.render(xScroll, yScroll, screen);
		Random rand = new Random();
		Sprite sprite = new Sprite(2, 0xff00ff);
		for(int i = 0; i < 10; i++) {
			int x = rand.nextInt(10) + 80;
			int y = rand.nextInt(10) + 80;
			screen.renderSprite(x, y, sprite, false);
		}
		player.render(screen);
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
//		g.fillRect(mouse.getX() - 4,  mouse.getY() - 4, 8, 8);
		g.dispose();
		bs.show();
	}
	
	public static int getWindowWidth() {
		return width * scale;
	}
	
	public static int getWindowHeight() {
		return height * scale;
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.requestFocusInWindow(true);
		
		game.start();
		
	}
}
