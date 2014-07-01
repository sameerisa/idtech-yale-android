package com.game;

public class Background  //DONE
{
	private double backgroundX;
	private double backgroundY;
	private double speedX;
	

	public Background(double backgroundX, double backgroundY)
	{
		this.backgroundX = backgroundX;
		this.backgroundY = backgroundY;
		speedX = 0;
		
	}

	public void update()
	{	
		backgroundX += speedX;
		
		if(backgroundX <= -1920)
		{
			backgroundX +=3840;
		}
		else if(backgroundX >= 1920)
		{
			backgroundX -= 3840;
		}
	}

	public double getBackgroundX()
	{
		return backgroundX;
	}

	public double getBackgroundY()
	{
		return backgroundY;
	}

	public double getSpeedX()
	{
		return speedX;
	}

	public void setBackgroundX(double backgroundX)
	{
		this.backgroundX = backgroundX;
	}

	public void setBackgroundY(double backgroundY)
	{
		this.backgroundY = backgroundY;
	}

	public void setSpeedX(double speedX)
	{
		this.speedX = speedX;
	}
	
	


}
