package com.example.paint;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private final int DIALOG_SINGLE_CHOICE=0;	
	//ImageView imgView; 
	TextView test;
	int color=0;
	canvas drawing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawing=(canvas)findViewById(R.id.canvas);
		
		//imgView = (ImageView)findViewById(R.id.imageview);
		//imgView.setBackgroundResource(R.drawable.visiblespectrum);
		
		test = (TextView)findViewById(R.id.test);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		/*try{
		
		imgView.setDrawingCacheEnabled(true);
		Bitmap temBitmap = imgView.getDrawingCache();
		color= temBitmap.getPixel((int)event.getX(), (int)event .getY());
		setpaintcolor();
		
		} catch(Exception e) {
			
		}*/
		
		
		return super.onTouchEvent(event);
	}

	private void setpaintcolor() {
		// TODO Auto-generated method stub
		drawing.setpaintcolor(color);
		Integer newColor = color;
		test.setText(newColor.toString());
	}
	
}
