package com.example.paint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class canvas extends View {
	private int paintcolor=0x00000000;

	public canvas(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setupdrawing();
	}
	public void setupdrawing()
	{
		
	}
	public void setpaintcolor(int newcolor)
	{
		paintcolor=newcolor;
	}
	
	public int getpaintcolor()
	{
		return paintcolor;
	}
}

