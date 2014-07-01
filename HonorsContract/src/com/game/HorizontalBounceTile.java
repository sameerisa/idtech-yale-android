package com.game;

import com.framework.Image;

public class HorizontalBounceTile extends Tile
{	
	private static double PUSHSPEED = 30;
	private Image image2;
	private boolean activated;
	private int frames;
	
	private char type;
	
	public HorizontalBounceTile(double x, double y, Image image, Image image2, char type)
	{
		super(x, y, image);
		this.image2 = image2;
		
		this.type = type;
		activated = false;
		frames = 0;
	}
	
	public void update()
	{
		speedX = background1.getSpeedX() * 5;
		x += speedX;
		
		
		centerX = x + 20;
		
		if(type == '<')
			//leftLine.setLine(x + 0, y + 1, x + 40, y + 38);
			leftLine.set((int)x + 0,(int) y + 1, (int)x + 1, (int)y + 38);
		else if(type == '>')
			//rightLine.setLine(x + 39, y + 1, x + 39, y + 38);
			rightLine.set((int)x + 38, (int)y + 1, (int)x + 39, (int)y + 38);
		
		checkCollision();
	}

	@Override
	public void checkVerticalCollision()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkHorizontalCollision()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkCollision()
	{	
		if(type == '<')
		{
			if(player.getCollisionSide().intersect(leftLine))
			{	
				
				activated = true;
				player.setSpeedX(-PUSHSPEED);
				
				frames = 0;
			}
			else
			{
				frames++;   //delay in animation
				if(frames > 12)
				{
					frames = 0;
					activated = false;
				}
			}
		}
		else if(type == '>')
		{
			if(player.getCollisionSide().intersect(rightLine))
			{	
				
				activated = true;
				player.setSpeedX(PUSHSPEED);
				
				frames = 0;
			}
			else
			{
				frames++;   //delay in animation
				if(frames > 12)
				{
					frames = 0;
					activated = false;
				}
			}
		}
		
	}
	
	public Image getImage()
	{
		/*if(activated)
			return image2;
		else*/
			return image;
		
	}
	
	public char getType()
	{
		return type;
	}

	public Image getImage2()
	{
		return image2;
	}

	public boolean isActivated()
	{
		return activated;
	}

	public void setImage2(Image image2)
	{
		this.image2 = image2;
	}

	public void setActivated(boolean activated)
	{
		this.activated = activated;
	}

}
