package com.game;

import com.framework.Game;
import com.framework.Graphics;
import com.framework.Graphics.ImageFormat;
import com.framework.Screen;




public class LoadingScreen extends Screen //DONE
{

	public LoadingScreen(Game game)
	{
		super(game);
	}

	@Override
	public void update(float deltaTime)
	{
		Graphics g = game.getGraphics();
		
		Assets.menu = g.newImage("data/menu.png", ImageFormat.RGB565);
		Assets.background = g.newImage("data/background.png", ImageFormat.RGB565);
		
		Assets.characterFront = g.newImage("data/front.png", ImageFormat.ARGB4444);
		Assets.characterLeft = g.newImage("data/left/walk0001.png", ImageFormat.ARGB4444);
		Assets.characterRight = g.newImage("data/right/walk0001.png", ImageFormat.ARGB4444);
		Assets.characterLeftJump = g.newImage("data/left/jump.png", ImageFormat.ARGB4444);
		Assets.characterRightJump = g.newImage("data/right/jump.png", ImageFormat.ARGB4444);
		
		Assets.leftWalk1 = g.newImage("data/left/walk0001.png", ImageFormat.ARGB4444);
		Assets.leftWalk2 = g.newImage("data/left/walk0002.png", ImageFormat.ARGB4444);
		Assets.leftWalk3 = g.newImage("data/left/walk0003.png", ImageFormat.ARGB4444);
		Assets.leftWalk4 = g.newImage("data/left/walk0004.png", ImageFormat.ARGB4444);
		Assets.leftWalk5 = g.newImage("data/left/walk0005.png", ImageFormat.ARGB4444);
		Assets.leftWalk6 = g.newImage("data/left/walk0006.png", ImageFormat.ARGB4444);
		Assets.leftWalk7 = g.newImage("data/left/walk0007.png", ImageFormat.ARGB4444);
		Assets.leftWalk8 = g.newImage("data/left/walk0008.png", ImageFormat.ARGB4444);
		Assets.leftWalk9 = g.newImage("data/left/walk0009.png", ImageFormat.ARGB4444);
		Assets.leftWalk10 = g.newImage("data/left/walk0010.png", ImageFormat.ARGB4444);
		
		Assets.rightWalk1 = g.newImage("data/right/walk0001.png", ImageFormat.ARGB4444);
		Assets.rightWalk2 = g.newImage("data/right/walk0002.png", ImageFormat.ARGB4444);
		Assets.rightWalk3 = g.newImage("data/right/walk0003.png", ImageFormat.ARGB4444);
		Assets.rightWalk4 = g.newImage("data/right/walk0004.png", ImageFormat.ARGB4444);
		Assets.rightWalk5 = g.newImage("data/right/walk0005.png", ImageFormat.ARGB4444);
		Assets.rightWalk6 = g.newImage("data/right/walk0006.png", ImageFormat.ARGB4444);
		Assets.rightWalk7 = g.newImage("data/right/walk0007.png", ImageFormat.ARGB4444);
		Assets.rightWalk8 = g.newImage("data/right/walk0008.png", ImageFormat.ARGB4444);
		Assets.rightWalk9 = g.newImage("data/right/walk0009.png", ImageFormat.ARGB4444);
		Assets.rightWalk10 = g.newImage("data/right/walk0010.png", ImageFormat.ARGB4444);
		
		Assets.block = g.newImage("data/tiles/block.png", ImageFormat.ARGB4444);
		Assets.bonus_used = g.newImage("data/tiles/bonus_used.png", ImageFormat.ARGB4444);
		Assets.bonus = g.newImage("data/tiles/bonus.png", ImageFormat.ARGB4444);
		Assets.bounceLeft_off = g.newImage("data/tiles/bounceLeft_off.png", ImageFormat.ARGB4444);
		Assets.bounceLeft_on = g.newImage("data/tiles/bounceLeft_on.png", ImageFormat.ARGB4444);
		Assets.coin_bronze = g.newImage("data/tiles/coin_bronze.png", ImageFormat.ARGB4444);
		Assets.coin_gold = g.newImage("data/tiles/coin_gold.png", ImageFormat.ARGB4444);
		Assets.coin_silver = g.newImage("data/tiles/coin_silver.png", ImageFormat.ARGB4444);
		Assets.crate = g.newImage("data/tiles/crate.png", ImageFormat.ARGB4444);
		Assets.ground_cave = g.newImage("data/tiles/ground_cave.png", ImageFormat.ARGB4444);
		Assets.ground_dirt = g.newImage("data/tiles/ground_dirt.png", ImageFormat.ARGB4444);
		Assets.ground_rock = g.newImage("data/tiles/ground_rock.png", ImageFormat.ARGB4444);
		Assets.ground_sand = g.newImage("data/tiles/ground_sand.png", ImageFormat.ARGB4444);
		Assets.ground = g.newImage("data/tiles/ground.png", ImageFormat.ARGB4444);
		Assets.jump_off = g.newImage("data/tiles/jump_off.png", ImageFormat.ARGB4444);
		Assets.jump_on = g.newImage("data/tiles/jump_on.png", ImageFormat.ARGB4444);
		
		
		game.setScreen(new MainMenuScreen(game));
		
		
	}

	@Override
	public void paint(float deltaTime)
	{
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton()
	{
		// TODO Auto-generated method stub
		
	}

}
