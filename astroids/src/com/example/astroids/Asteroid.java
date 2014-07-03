package com.example.astroids;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class Asteroid {
	public Bitmap bitmap;
	public int x;
	public int y;
	public int xVelocity;
	private gamethread thread;
	private Spaceship spaceship;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Integer> asteroidsToRemove;
	public Asteroid(Bitmap decodeResource, int startingXPosition, int i) {
		// TODO Auto-generated constructor stub
	}
	public void draw(Canvas canvas) {
	    canvas.drawBitmap(bitmap, x, y, null);
	    y = y + 5;
	}
	public void surfaceCreated(SurfaceHolder holder) {
	    thread.setRunning(true);
	    thread.start();
	 
	    asteroids = new ArrayList<Asteroid>();
	    asteroidsToRemove = new ArrayList<Integer>();
	    Timer t = new Timer();
	    t.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            Random generator = new Random();
	            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
	            int startingXPosition = generator.nextInt(getWidth() - bitmap.getWidth());
	            Asteroid asteroid = new Asteroid(BitmapFactory.decodeResource(getResources(),
	                                                         R.drawable.asteroid), startingXPosition, 0);
	            asteroids.add(asteroid);
	        }
	    }, 0, 2000);
	}
	protected int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	protected Resources getResources() {
		// TODO Auto-generated method stub
		return null;
	}
	protected void onDraw(Canvas canvas) {
	    canvas.drawColor(Color.BLACK);
	    spaceship.draw(canvas);
	 
	    for (Asteroid asteroid:asteroids) {
	        asteroid.draw(canvas);
	        if (asteroid.getY() > getHeight()){
	            Integer integer = Integer.valueOf(asteroids.indexOf(asteroid));
	            asteroidsToRemove.add(integer);
	            
	        }
	    }
	    for (Asteroid asteroid:asteroids) {
	        asteroid.draw(canvas);
	        if (asteroid.getY() > getHeight()) {
	            Integer integer = Integer.valueOf(asteroids.indexOf(asteroid));
	            asteroidsToRemove.add(integer);
	        }
	    }
	     
	    for (Integer integer:asteroidsToRemove) {
	        asteroids.remove(integer.intValue());
	    }
	     
	    asteroidsToRemove.clear();
	}
	private int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setGetHeight(int getHeight) {
		this.y = y;
	}
	private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setY(int y) {
		this.y = y;
	}

}
