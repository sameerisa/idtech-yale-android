package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

public class canvas extends View {
	private int paintcolor=0x00000000;

	private Bitmap map;
	private Canvas canvas;
	private Path drawPath;
	private Paint drawPaint;
	private Paint canvasPaint;
	private float brushsize;
	
	
	public canvas(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setupdrawing();
	}
	public void setupdrawing()
	{
		drawPath=new Path();
		drawPaint=new Paint();
		drawPaint.setColor(0x000000);
		drawPaint.setAntiAlias(true);
		drawPaint.setStrokeWidth(20);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
		
		canvasPaint = new Paint(Paint.DITHER_FLAG);
	}
	public void setpaintcolor(int newcolor)
	{
		paintcolor=newcolor;
	}
	
	public int getpaintcolor()
	{
		return paintcolor;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(map,  0, 0, canvasPaint);
		canvas.drawPath(drawPath, drawPaint);
	
	
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		map = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(map);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float touchX = event.getX();
		float touchY = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			drawPath.moveTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_MOVE:
			drawPath.lineTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_UP:
			canvas.drawPath(drawPath, drawPaint);
			drawPath.reset();
			break;
			
		default:
			return false;
		}
	
		invalidate();
		return true;
	}
	public void setBrushSize(float newSize) {
		float pixellAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,newSize, getResources().getDisplayMetrics());
		brushsize=pixellAmount;
		drawPaint.setStrokeWidth(20);
		
	}
	

}

