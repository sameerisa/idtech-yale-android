package com.game;

import android.graphics.Color;
import android.graphics.Paint;


import android.graphics.Rect;

import java.util.ArrayList;

public class Player  ///DONE
{
	private final static int MOVELINE = GameScreen.xResolution / 2;
	private final static double JUMPSPEED = -15;
	private final static double MOVESPEED = 8;
	private final static double ACCELERATION_CONST = .5;
	private final static double DECELERATION_MODIFIER = 1.5;
	
	private final static double GRAVITY = 0.6;
	
	private final static int GROUND = GameScreen.yResolution - 88;
	
	private static Background background1 = GameScreen.getBackground1();
	private static Background background2 = GameScreen.getBackground2();
	private static Background background3 = GameScreen.getBackground3();
	
	private double centerX;
	private double centerY;

	private boolean jumped;
	private boolean facingRight;
	private boolean movingRight;
	private boolean movingLeft;
	public static boolean ableToMove = true;
	public boolean dead = false;
	
	private double acceleration;
	private double speedX;  
	private double speedY;
	
	private Rect collisionBox;
	private Rect collisionSide;
	private Rect collisionCoin;
	
	//private Rectangle2D.Double collisionBox;
	//private Rectangle2D.Double collisionSide;
	//private Rectangle2D.Double collisionCoin;
	
	private int jumpCount = 0;

	private ArrayList<LaserProjectile> laserProjectiles;
	
	public Player()
	{
		
		centerX = MOVELINE;
		centerY = GROUND;  //approx 2 blocks high

		jumped = false;
		facingRight = true;
		movingRight = false;
		movingLeft = false;
		
		acceleration = 0;
		speedX = 0;   
		speedY = 0;
		
		collisionBox = new Rect();
		collisionSide = new Rect();
		collisionCoin = new Rect();
		
		laserProjectiles = new ArrayList<LaserProjectile>();
		
	}
	
	public void update()
	{	
		
		
		/*******************************Update X****************************************/
		/*
		 * 		Character stays in the middle of the screen, backgrounds and tiles scroll
		 * 		according to movespeed
		 */
	
		
		speedX += acceleration;
		
		if(acceleration != 0)
		{	
			
			if(Math.abs(speedX + acceleration) > MOVESPEED)
			{
				if(speedX < 0)
				{
					speedX = -MOVESPEED;
					
				}
				else if(speedX > 0)
				{
					speedX = MOVESPEED;
				}
			}
		}
		else
		{
			if(Math.abs(speedX) < DECELERATION_MODIFIER * ACCELERATION_CONST)
			{
				speedX = 0;
			}
			else
			{
				if(speedX < 0)
				{
					speedX += DECELERATION_MODIFIER * ACCELERATION_CONST;
					
				}
				else if(speedX > 0)
				{
					speedX -= DECELERATION_MODIFIER * ACCELERATION_CONST;
				}
			}
		}
	
	
		
		
			
			
		//System.out.println("SPEED: " + speedX);
		//System.out.println("LEFT: " + movingLeft);
		//System.out.println("RIGHT:" + movingRight);
		//System.out.println("ACC: " + acceleration);
		
		

		background1.setSpeedX(-speedX / 5);
	    background2.setSpeedX(-speedX / 5);
	    background3.setSpeedX(-speedX / 5);
	   
		
		//keep the character in a certain part of the screen
	    if(speedX != 0 && acceleration != 0)
	    {
	    	if(centerX < MOVELINE)
			{
					centerX += .5;
			}
			if(centerX > MOVELINE)
			{
					centerX -= .5;
			}
	    }
	    
	  
		
		
		/*******************************Update Y****************************************/
	
		centerY += speedY;
		speedY += GRAVITY;
		if(speedY > 3 * GRAVITY)  //if falling
		{
			jumped = true;
		}
		
		
		/**************************************COLLISION BOX*********************************/
		//collisionBox.setRect((centerX - 15),  (centerY - 32), 30, 80);
		//collisionSide.setRect(centerX - 24, centerY -26, 48, 64);
		//collisionCoin.setRect(centerX - 28, centerY - 44, 56, 92);
		collisionBox.set((int)centerX - 15, (int)centerY - 32, (int)centerX + 15, (int)centerY + 48);
		collisionCoin.set((int)centerX - 28, (int)centerY - 44, (int)centerX + 28, (int)centerY + 48);
		collisionSide.set((int)centerX - 24, (int)centerY - 26, (int)centerX + 24, (int)centerY + 38);
		
		
		if(centerY > GameScreen.yResolution + 100)
		{
			dead = true;
		}
	}
	
	public void shoot()
	{	
		if(facingRight)
		{
			laserProjectiles.add(new LaserProjectile(centerX - 10, centerY - 6, facingRight, Color.RED));
			laserProjectiles.add(new LaserProjectile(centerX + 10, centerY - 6, facingRight, Color.RED));
		}
		else
		{
			laserProjectiles.add(new LaserProjectile(centerX - 25, centerY - 6, facingRight, Color.RED));
			laserProjectiles.add(new LaserProjectile(centerX - 5, centerY - 6, facingRight, Color.RED));
		}
		
		
	}
	
	public void moveRight()
	{	
		facingRight = true;
		if(!movingLeft)
			acceleration = ACCELERATION_CONST;
		//System.out.println("right");
	}

	public void moveLeft()
	{	
		facingRight = false;
		if(!movingRight)
			acceleration = -ACCELERATION_CONST;
		//System.out.println("left");
	}
	

	public void stop()
	{	
		if(movingLeft)
		{	facingRight = false;
			acceleration = -ACCELERATION_CONST;
		}
		else if(movingRight)
		{	facingRight = true;
			acceleration = ACCELERATION_CONST;
		}
		else
			acceleration = 0;
		
		//System.out.println("stop");
	}

	public void jump()
	{	
		
		if(!jumped)
		{
			speedY = JUMPSPEED;
			jumped = true;
			jumpCount++;
		}

	}

	public double getCenterX()
	{
		return centerX;
	}

	public double getCenterY()
	{
		return centerY;
	}

	public boolean isJumped()
	{
		return jumped;
	}

	public boolean isFacingRight()
	{
		return facingRight;
	}

	public double getSpeedX()
	{
		return speedX;
	}

	public double getSpeedY()
	{
		return speedY;
	}

	public void setCenterX(double centerX)
	{
		this.centerX = centerX;
	}

	public void setCenterY(double centerY)
	{
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped)
	{
		this.jumped = jumped;
	}

	public void setFacingRight(boolean facingRight)
	{
		this.facingRight = facingRight;
	}

	public void setSpeedX(double speedX)
	{
		this.speedX = speedX;
	}

	public void setSpeedY(double speedY)
	{
		this.speedY = speedY;
	}

	public boolean isMovingRight()
	{
		return movingRight;
	}

	public boolean isMovingLeft()
	{
		return movingLeft;
	}

	public void setMovingRight(boolean movingRight)
	{
		this.movingRight = movingRight;
	}

	public void setMovingLeft(boolean movingLeft)
	{
		this.movingLeft = movingLeft;
	}

	
	public Rect getCollisionBox()
	{
		return collisionBox;
	}

	public void setCollisionBox(Rect collisionBox)
	{
		this.collisionBox = collisionBox;
	}

	public static double getGravity()
	{
		return GRAVITY;
	}

	public double getAcceleration()
	{
		return acceleration;
	}

	public void setAcceleration(double acceleration)
	{
		this.acceleration = acceleration;
	}

	public Rect getCollisionSide()
	{
		return collisionSide;
	}

	public void setCollisionSide(Rect collisionSide)
	{
		this.collisionSide = collisionSide;
	}

	public boolean isDead()
	{
		return dead;
	}

	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	public int getJumpCount()
	{
		return jumpCount;
	}

	public void setJumpCount(int jumpCount)
	{
		this.jumpCount = jumpCount;
	}

	public Rect getCollisionCoin()
	{
		return collisionCoin;
	}

	public void setCollisionCoin(Rect collisionCoin)
	{
		this.collisionCoin = collisionCoin;
	}
	
	public ArrayList<LaserProjectile> getLaserProjectiles()
	{
		return laserProjectiles;
	}
	
	
	
}
