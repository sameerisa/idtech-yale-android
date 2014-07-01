package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

import com.framework.Screen;
import com.framework.implementation.AndroidGame;

public class GameStart extends AndroidGame  //DONE
{
	public static String map;
	boolean firstTimeCreate = true;

	@Override
	public Screen getInitScreen()
	{
		if(firstTimeCreate)
		{
			Assets.load(this);
			firstTimeCreate = false;
		}

		InputStream is = getResources().openRawResource(R.raw.map1);
		map = convertStreamToString(is);

		return new SplashLoadingScreen(this);
	}

	@Override
	public void onBackPressed()
	{
		getCurrentScreen().backButton();
	}

	private static String convertStreamToString(InputStream is)
	{

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try
		{
			while ((line = reader.readLine()) != null)
			{
				sb.append((line + "\n"));
			}
		}
		catch (IOException e)
		{
			Log.w("LOG", e.getMessage());
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				Log.w("LOG", e.getMessage());
			}
		}
		return sb.toString();
	}

	public void onResume()
	{
		super.onResume();
	}

	public void onPause()
	{
		super.onPause();
	}
}
