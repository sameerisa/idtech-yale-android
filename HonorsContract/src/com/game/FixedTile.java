package com.game;

import com.framework.Image;
import java.util.ArrayList;

public class FixedTile extends Tile
{
	
	
	public FixedTile(double x, double y, Image image)
	{
		super(x, y, image);
	
		
	}
	
	public void update()
	{
		super.update();
		
		checkCollision();
	}

	@Override
	public void checkVerticalCollision()
	{	
		
		if(player.getCenterY() > centerY)
		{	
			player.setSpeedY(0);
			player.setCenterY(y + 76);
			
		}
		if(player.getCenterY() < centerY)
		{	
			player.setSpeedY(0);
			player.setJumpCount(0);
			player.setJumped(false);
			player.setCenterY(y - 48);
			
		}
	}

	@Override
	public void checkHorizontalCollision()
	{
		
		player.setSpeedX(0);
		if(player.getCenterX() > centerX)
		{	
			player.setCenterX(x + 65);//66
			
		}
		else
		{	
			player.setCenterX(x - 25);//26
	
		}
		
	}	

	@Override
	public void checkCollision()
	{
		if(player.getCollisionBox().intersect(collisionBox))
		{	
			 
			checkVerticalCollision();
		}
		else if(player.getCollisionSide().intersect(collisionBox) && !player.getCollisionBox().intersect(collisionBox))
		{
			
			checkHorizontalCollision();
		}
		
	
		
	}
	
	

}
