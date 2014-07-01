package com.game;

import com.framework.Image;
import android.graphics.Rect;

public abstract class Tile      //Blueprint for all tile objects in the game
{
	protected double x;			//coordinate
	protected double y;
	protected double centerX;
	protected double centerY;
	protected double speedX;

	protected Image image;

	protected Rect topLine;
	protected Rect leftLine;
	protected Rect rightLine;
	protected Rect bottomLine;
	
	protected Rect collisionBox;
	
	protected static Background background1 = GameScreen.getBackground1();
	
	protected static Player player = GameScreen.getPlayer();


	public Tile(double x, double y, Image image)
	{
		this.x = x * 40;
		this.y = y * 40;
		centerX = this.x + 20;
		centerY = this.y + 20;
		this.image = image;
		
		topLine = new Rect();
		leftLine = new Rect();
		rightLine = new Rect();
		bottomLine = new Rect();
		
		collisionBox = new Rect();
	}

	public void update()
	{
		speedX = background1.getSpeedX() * 5;
		x += speedX;
		
		centerX = x + 20;
		//topLine.setLine(x + 1, y, x + 38, y);
		//leftLine.setLine(x, y + 1, x, y + 38);
		//rightLine.setLine(x + 39, y + 1, x + 39, y + 38);
		//bottomLine.setLine(x + 1, y + 39, x + 38, y + 39);
		
		topLine.set((int)x + 1, (int)y,(int)x + 38, (int)y + 1);
		leftLine.set((int)x, (int)y + 1,(int)x + 1, (int)y + 38);
		rightLine.set((int)x + 38, (int)y + 1,(int)x + 39, (int)y + 38);
		bottomLine.set((int)x + 1, (int)y + 38,(int)x + 38, (int)y + 39);
		
		collisionBox.set((int)x, (int)y, (int)x + 40, (int)y + 40);
	}
	
	public abstract void checkVerticalCollision();
	
	public abstract void checkHorizontalCollision();
	
	public abstract void checkCollision();

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

	public Image getImage()
	{
		return image;
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

	public void setImage(Image image)
	{
		this.image = image;
	}

	public Rect getTopLine()
	{
		return topLine;
	}

	public Rect getLeftLine()
	{
		return leftLine;
	}

	public Rect getRightLine()
	{
		return rightLine;
	}

	public Rect getBottomLine()
	{
		return bottomLine;
	}

	public void setTopLine(Rect topLine)
	{
		this.topLine = topLine;
	}

	public void setLeftLine(Rect leftLine)
	{
		this.leftLine = leftLine;
	}

	public void setRightLine(Rect rightLine)
	{
		this.rightLine = rightLine;
	}

	public void setBottomLine(Rect bottomLine)
	{
		this.bottomLine = bottomLine;
	}

	public Rect getCollisionBox()
	{
		return collisionBox;
	}

	public void setCollisionBox(Rect collisionBox)
	{
		this.collisionBox = collisionBox;
	}
	
	

}
