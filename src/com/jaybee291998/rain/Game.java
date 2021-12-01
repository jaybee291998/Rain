package com.jaybee291998.rain;

public class Game implements Runnable {
	public static int width = 300;
	public static int heigth = width / 16 * 9;
	public static int scale = 3;
	
	private Thread thread;
	
	public synchronized void start() {
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
