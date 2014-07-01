package com.game;

import com.framework.Image;
import java.util.ArrayList;

public class Animation //DONE
{

	private ArrayList frames;
	private int currentFrame;
	private long animTime;
	private long totalDuration;

	public Animation()
	{
		frames = new ArrayList();
		totalDuration = 0;

		animTime = 0;
		currentFrame = 0;
		
	}

	public void addFrame(Image image, long duration)
	{
		totalDuration += duration;
		frames.add(new AnimFrame(image, totalDuration));
	}
	
	public void resetCurrentFrame()
	{
		currentFrame = 0;
	}

	public void update(long elapsedTime)
	{
		if (frames.size() > 1)
		{
			animTime += elapsedTime;
			if (animTime >= totalDuration)
			{
				animTime = animTime % totalDuration;
				currentFrame = 0;

			}

			while (animTime > getFrame(currentFrame).endTime)
			{
				currentFrame++;

			}
		}
	}

	public Image getImage()
	{
		if (frames.size() == 0)
		{
			return null;
		}
		else
		{
			return getFrame(currentFrame).image;
		}
	}

	private AnimFrame getFrame(int i)
	{
		return (AnimFrame) frames.get(i);
	}

	private class AnimFrame
	{

		Image image;
		long endTime;

		public AnimFrame(Image image, long endTime)
		{
			this.image = image;
			this.endTime = endTime;
		}
	}
}
