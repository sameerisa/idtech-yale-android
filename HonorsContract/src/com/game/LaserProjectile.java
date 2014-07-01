package com.game;

import android.graphics.Color;
import android.graphics.Rect;


public class LaserProjectile //DONE
{	
	private static final double SPEED = 10;
	
	
	private double x, y, speedX;
	private boolean goingRight;
	private boolean visible;
	private int color;
	private Rect collisionBox;
	
	public LaserProjectile(double x, double y, boolean goingRight,  int color)
	{
		this.x = x;
		this.y = y;
		this.goingRight = goingRight;
		visible = true;
		this.color = color;
		if(goingRight)
		{
			speedX = SPEED;
		}
		else
		{
			speedX = -SPEED;
		}
		
		collisionBox = new Rect();
	}
	
	public void update()
	{
		x += speedX;
		//collisionBox.setRect(x, y, 20, 8);
		collisionBox.set((int)x, (int)y, (int)x + 20, (int)y + 8);
		
		if(!(x < GameScreen.xResolution && x > 0))
		{
			visible = false;
		}
		else
		{
			checkCollision();
		}
	}
	
	public void checkCollision()
	{
		
	}

	public static double getSpeed()
	{
		return SPEED;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getSpeedX()
	{
		return speedX;
	}

	public boolean isGoingRight()
	{
		return goingRight;
	}

	public boolean isVisible()
	{
		return visible;
	}

	public Rect getCollisionBox()
	{
		return collisionBox;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public void setSpeedX(double speedX)
	{
		this.speedX = speedX;
	}

	public void setGoingRight(boolean goingRight)
	{
		this.goingRight = goingRight;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	public void setCollisionBox(Rect collisionBox)
	{
		this.collisionBox = collisionBox;
	}

	public int getColor()
	{
		return color;
	}

	public void setColor(int color)
	{
		this.color = color;
	}
	
	
	
}
