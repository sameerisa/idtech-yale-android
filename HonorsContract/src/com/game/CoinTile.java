package com.game;

import com.framework.Image;

public class CoinTile extends Tile
{
	private boolean taken;
	private char type;
	
	public CoinTile(double x, double y, Image image, char type)
	{
		super(x, y, image);
		
		this.y = this.y - 15; // floating 
		
		this.taken = false;
		this.type = type;
		
		
		
		//TYPE KEY
		// X - BRONZE
		// Y - SILVER
		// Z - GOLD
		
	}
	
	public void update()
	{
		super.update();
		
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
		if(player.getCollisionCoin().intersect(collisionBox) && !taken)
		{
			taken = true;
			switch (type)
			{
				case 'X':
					GameScreen.addToScore(10);
					break;
				case 'Y':
					GameScreen.addToScore(25);
					break;
				case 'Z':
					GameScreen.addToScore(50);
					break;
			}
		}
		
	}

	public boolean isTaken()
	{
		return taken;
	}

	public void setTaken(boolean taken)
	{
		this.taken = taken;
	}
	
	
	
}
