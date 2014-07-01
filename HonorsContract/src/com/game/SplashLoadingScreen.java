package com.game;

import com.framework.Game;
import com.framework.Graphics;
import com.framework.Screen;
import com.framework.Graphics.ImageFormat;

public class SplashLoadingScreen extends Screen //DONE
{
	public SplashLoadingScreen(Game game)
	{
		super(game);
	}

	@Override
	public void update(float deltaTime)
	{
		Graphics g = game.getGraphics();
		
		Assets.splash = g.newImage("data/splash.png", ImageFormat.RGB565);
		
		game.setScreen(new LoadingScreen(game));

	}

	@Override
	public void paint(float deltaTime)
	{
		// TODO Auto-generated method stub

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
