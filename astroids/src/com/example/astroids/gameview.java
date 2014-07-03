package com.example.astroids;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class gameview extends SurfaceView implements SurfaceHolder.Callback {
	private gamethread thread;
	public Bitmap bitmap;
	private Spaceship spaceship;

	public gameview(Context context) {
		super(context);
		getHolder().addCallback((Callback) this);
		thread = new gamethread(getHolder(), this);
		setFocusable(true);
		spaceship = new Spaceship(BitmapFactory.decodeResource(getResources(),
				R.drawable.spaceship), 50, 50);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return true;
	}
public void draw(Canvas canvas) {
	canvas.drawBitmap(bitmap, 50, 50, null);
	x = x + xVelocity;
}
	@Override
	protected void onDraw(Canvas canvas) {
		
		 canvas.drawColor(Color.BLACK);
		    spaceship.draw(canvas);
	}

}