package com.game;

import com.framework.Image;

public class JumpTile extends Tile
{	
	private static double JUMPSPEED = -21;
	
	private Image image2;
	private boolean activated;
	private int frames;
	
	
	public JumpTile(double x, double y, Image image, Image image2)
	{
		super(x, y, image);
		
		this.image2 = image2;
		activated = false;
		frames = 0;
	}
	
	public void update()
	{
		speedX = background1.getSpeedX() * 5;
		x += speedX;
		
		centerX = x + 20;
		//topLine.setLine(x + 1, y + 4, x + 38, y + 4);
		topLine.set((int)x + 1, (int)y + 4, (int)x + 38, (int)y + 5);
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
		if(player.getCollisionBox().intersect(topLine))
		{		
			activated = true;
			player.setSpeedY(JUMPSPEED);
			player.setJumped(true);
			frames = 0;
		
		}
		else
		{
			frames++;   //delay in animation
			if(frames > 6)
			{
				frames = 0;
				activated = false;
			}
		}
			
		
			
		
	}
	
	@Override
	public Image getImage()
	{
		if(activated)
			return image2;
		else
			return image;
		
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
