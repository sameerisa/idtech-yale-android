package com.example.astroids;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

@SuppressLint("WrongCall")
public class gamethread extends Thread {
	private SurfaceHolder surfaceHolder;
	private gameview gameView;
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	public gamethread(SurfaceHolder surfaceHolder, gameview gameView)

	{
		super();
		this.surfaceHolder = surfaceHolder;
		this.gameView = gameView;
	}

	@Override
	public void run() {
		Canvas canvas;
		while (running) {
			canvas = null;
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					this.gameView.onDraw(canvas);
				}
			} finally {
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
					
			}
		}
	}
}