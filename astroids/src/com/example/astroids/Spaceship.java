package com.example.astroids;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Spaceship {
	
	private Bitmap bitmap;
	private int x;
	private int y;
	private int xVelocity;

	public Spaceship(Bitmap bitmap, int x, int y) {
		this.bitmap = bitmap;
		this.x = x;
		this.setY(y);
	}

public Bitmap getBitmap() {
    return bitmap;
}
public void setBitmap(Bitmap bitmap) {
    this.bitmap = bitmap;
	}



	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x, y, null);
		x = x + xVelocity;
	
}
	public int getXVelocity(){
		return xVelocity;
	}
	public void setXVelocity(int xVelocity){
		this.xVelocity=xVelocity;
	}
public int getX(){
	return x;
}
public void setX(int x){
this.x = x;
}


	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}