package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;

import com.framework.Game;
import com.framework.Graphics;
import com.framework.Image;
import com.framework.Input.TouchEvent;
import com.framework.Screen;



public class GameScreen extends Screen
{
	public enum GameState
	{
		Ready, Running, Paused, GameOver
	}
	
	GameState state = GameState.Ready;
	/**************************************Instance Variables***********************/
	
	public final static int xResolution = 1280;
	public final static int yResolution = 720;
	
	private static int score = 0;
	
	private static Player player;
	
	private Image currentSprite;
	private Image background;
	private Image characterFront;
	private Image characterLeft;
	private Image characterRight;
	private Image characterLeftJump;
	private Image characterRightJump;
	
	
	private Animation leftAnim, rightAnim;
	
	private static ArrayList<FixedTile> fixedTiles;
	private static ArrayList<CoinTile> coinTiles;
	private static ArrayList<JumpTile> jumpTiles;
	private static ArrayList<HorizontalBounceTile> horizontalBounceTiles;
	
	private ArrayList<LaserProjectile> laserProjectiles;
	 
	private static Background background1;
	private static Background background2;
	private static Background background3;
	
	Paint paint, paint2;
	
	

	/******************************************************************************/
	
	
	public static Background getBackground1()
	{
		return background1;
	}

	public static Background getBackground2()
	{
		return background2;
	}
	
	public static Background getBackground3()
	{
		return background3;
	}
	
	public static Player getPlayer()
	{
		return player;
	}
	
	public static ArrayList<FixedTile> getFixedTiles()
	{
		return fixedTiles;
	}
	
	public static int getScore()
	{
		return score;
	}
	
	public static void addToScore(int add)
	{
		score += add;
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}
	
	
	/*********************************************************************************/

	public GameScreen(Game game)
	{
		super(game);
		// TODO Auto-generated constructor stub
		//game objects here
		background1 = new Background(-1280, 0);
		background2 = new Background(0, 0);
		background3 = new Background(1280, 0);
		
		player = new Player();
		laserProjectiles = player.getLaserProjectiles();
		
		fixedTiles = new ArrayList<FixedTile>();
		coinTiles = new ArrayList<CoinTile>();
		jumpTiles = new ArrayList<JumpTile>();
		horizontalBounceTiles = new ArrayList<HorizontalBounceTile>();
		//images/ animation frames here
		
		characterFront = Assets.characterFront;
        characterLeft = Assets.characterLeft;
        characterRight = Assets.characterRight;
        characterLeftJump = Assets.characterLeftJump;
        characterRightJump = Assets.characterRightJump;
  
        currentSprite = characterFront;
        
        leftAnim = new Animation();
        
        leftAnim.addFrame(characterLeft, 50);
        leftAnim.addFrame(Assets.leftWalk2, 75);
        leftAnim.addFrame(Assets.leftWalk3, 75);
        leftAnim.addFrame(Assets.leftWalk4, 75);
        leftAnim.addFrame(Assets.leftWalk5, 75);
        leftAnim.addFrame(Assets.leftWalk6, 75);
        leftAnim.addFrame(Assets.leftWalk7, 75);
        leftAnim.addFrame(Assets.leftWalk8, 75);
        leftAnim.addFrame(Assets.leftWalk9, 75);
        leftAnim.addFrame(Assets.leftWalk10, 75);
        leftAnim.addFrame(characterLeft, 25);
        
        rightAnim = new Animation();
        
        rightAnim.addFrame(characterRight, 50);
        rightAnim.addFrame(Assets.rightWalk2, 75);
        rightAnim.addFrame(Assets.rightWalk3, 75);
        rightAnim.addFrame(Assets.rightWalk4, 75);
        rightAnim.addFrame(Assets.rightWalk5, 75);
        rightAnim.addFrame(Assets.rightWalk6, 75);
        rightAnim.addFrame(Assets.rightWalk7, 75);
        rightAnim.addFrame(Assets.rightWalk8, 75);
        rightAnim.addFrame(Assets.rightWalk9, 75);
        rightAnim.addFrame(Assets.rightWalk10, 75);
        rightAnim.addFrame(characterRight, 25);

        
        background = Assets.background;
		
		
		//load stuff
		loadMap();

		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);

		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);

	
	}
	
	private void loadMap()
	{
		ArrayList<String> lines = new ArrayList<String>();
		int screenWidth = 0;
		int screenHeight = 0;
		
		Scanner scanner = new Scanner(GameStart.map);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			// no more lines to read
			if (line == null) {
				break;
			}

			if (!line.startsWith("!")) {
				lines.add(line);
				screenWidth = Math.max(screenWidth, line.length());

			}
		}
		
		screenHeight = lines.size();
		
		for(int i = 0; i < screenHeight; i++)
		{	
			String line = lines.get(i);
			for(int j = -10; j < screenWidth; j++)
			{
				if(j + 10  < line.length())
				{
					char type = line.charAt(j + 10);
					
					switch(type)
					{
						case 'A':
							fixedTiles.add(new FixedTile(j, i, Assets.block));
							break;
						case 'B':
							fixedTiles.add(new FixedTile(j, i, Assets.ground));
							break;
						case 'C':
							fixedTiles.add(new FixedTile(j, i, Assets.ground_dirt));
							break;
						case 'D':
							fixedTiles.add(new FixedTile(j, i, Assets.ground_cave));
							break;
						case 'E':
							fixedTiles.add(new FixedTile(j, i, Assets.ground_rock));
							break;
						case 'F':
							fixedTiles.add(new FixedTile(j, i, Assets.ground_sand));
							break;
						
						case '^':
							jumpTiles.add(new JumpTile(j, i, Assets.jump_off, Assets.jump_on));
							break;
						/*case '>':
							horizontalBounceTiles.add(new HorizontalBounceTile(j, i, Assets.bounceRight_off, Assets.bounceRight_on, type));
							break;
						case '<':
							horizontalBounceTiles.add(new HorizontalBounceTile(j, i, Assets.bounceLeft_off, Assets.bounceLeft_on, type));
							break;
						*/
						case 'X':
							coinTiles.add(new CoinTile(j, i, Assets.coin_bronze, type));
							break;
						case 'Y':
							coinTiles.add(new CoinTile(j, i, Assets.coin_silver, type));
							break;
						case 'Z':
							coinTiles.add(new CoinTile(j, i, Assets.coin_gold, type));
							break;
							
							
					}
				}
			}
		}
		
		
	}
	
	
	
	
	/***********************************************************************************/
	
	
	public void animateEntities()
	{
		if(player.isFacingRight())
		{
			if(player.isJumped())
			{
				currentSprite = characterRightJump;
			}
			else
			{	
				if(player.isMovingRight())
				{	
					
					currentSprite = rightAnim.getImage();
				}
				else
				{
					currentSprite = characterRight;
				}
					
			}
		}
		else
		{

			if(player.isJumped())
			{
				currentSprite = characterLeftJump;
			}
			else
			{
				if(player.isMovingLeft())
				{	
					
					currentSprite = leftAnim.getImage();
				}
				else
				{
					currentSprite = characterLeft;
				}
			}
		}
		
		
		
		leftAnim.update(30);
		rightAnim.update(30);
	}
	
	public void updateTiles()
	{
		
		
		for(int i = 0; i < fixedTiles.size(); i++)
		{	
			FixedTile t = fixedTiles.get(i);
			t.update();
		}
		
		for(int i = 0; i < coinTiles.size(); i++)
		{	
			CoinTile t = coinTiles.get(i);
			t.update();
		}
		
		for(int i = 0; i < jumpTiles.size(); i++)
		{	
			JumpTile t = jumpTiles.get(i);
			t.update();
		}
		
		/*for(int i = 0; i < horizontalBounceTiles.size(); i++)
		{	
			HorizontalBounceTile t = horizontalBounceTiles.get(i);
			t.update();
		}
		*/
		for(int i = 0; i < laserProjectiles.size(); i++)
		{
			LaserProjectile t = laserProjectiles.get(i);
			t.update();
		}
	}
	
	
	
	public void updateGame()  //calculations inside gameloop
	{
		player.update();
		animateEntities();
		
		updateTiles();
		background1.update();
		background2.update();
		background3.update();
		
	
	}
	

	@Override
	public void update(float deltaTime)
	{
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		// We have four separate update methods in this example.
		// Depending on the state of the game, we call different update methods.
		// Refer to Unit 3's code. We did a similar thing without separating the
		// update methods.

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
		
	}
	

	private void updateReady(List<TouchEvent> touchEvents) {

		// This example starts with a "Ready" screen.
		// When the user touches the screen, the game begins.
		// state now becomes GameState.Running.
		// Now the updateRunning() method will be called!

		if (touchEvents.size() > 0)
			state = GameState.Running;
	}
	
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime)
	{

		// This is identical to the update() method from our Unit 2/3 game.

		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++)
		{
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_DOWN)
			{	
				if(event.y < (2 * yResolution / 3))
				{
					player.jump(); 
				}
				else
				{
					if(event.x > xResolution - 400)
					{
						// Move right.
						player.moveRight();
						player.setMovingRight(true);

					}
					else if(event.x < 400)
					{
						player.moveLeft();
						player.setMovingLeft(true);
					}
					else
					{
						player.shoot();
					}
				}

				

			}

			if(event.type == TouchEvent.TOUCH_UP)
			{

				if(event.y < (2 * yResolution / 3))
				{
					
				}
				else
				{
					if(event.x > xResolution / 2)
					{
						
						player.setMovingRight(false);
						player.stop();

					}
					else
					{
						player.setMovingLeft(false);
						player.stop();
					}
				}
			}

		}

		// 2. Check miscellaneous events like death:

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, robot.update();
		
		updateGame();

		if(player.getCenterY() > 900)
		{
			state = GameState.GameOver;
		}
	}
	
	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					android.os.Process.killProcess(android.os.Process.myPid());

					goToMenu();
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 1280, 720)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					android.os.Process.killProcess(android.os.Process.myPid());
					return;
				}
			}
		}

	}
	
	private void nullify()
	{
		paint = null;
		background1 = null;
		background2 = null;
		background3 = null;
		player = null;
		currentSprite = null;
		characterLeft = null;
		characterRight = null;
		characterLeftJump = null;
		characterRightJump = null;
		
		laserProjectiles = null;
		
		fixedTiles = null;
		coinTiles = null;
		jumpTiles = null;
		horizontalBounceTiles = null;
		
		leftAnim = null;
		rightAnim = null;
		
		System.gc();
	}
	/****************************************************************************************/
	

	private void drawReadyUI()
	{
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap to Start.", 400, 240, paint);

	}

	private void drawRunningUI()
	{

	}

	private void drawPausedUI()
	{
		Graphics g = game.getGraphics();
		// Darken the entire screen so you can display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Exit", 400, 360, paint2);

	}

	private void drawGameOverUI()
	{
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("GAME OVER.", 400, 240, paint2);
		g.drawString("Tap to exit.", 400, 290, paint);

	}
	
	

	/***************************************************************************************/

	@Override
	public void paint(float deltaTime)
	{
		Graphics g = game.getGraphics();
		g.drawImage(background, (int) background1.getBackgroundX(),(int) background1.getBackgroundY());
		g.drawImage(background,(int) background2.getBackgroundX(), (int)background2.getBackgroundY());
		g.drawImage(background,(int) background3.getBackgroundX(), (int)background3.getBackgroundY());
		
		paintTiles(g);
		
		
		//draw character
		g.drawImage(currentSprite,(int) player.getCenterX() - 37,(int) player.getCenterY() - 48);
		
		//draw projectiles
		
		paintProjectiles(g);
		
		//draw UI
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();

	}
	
	public void paintTiles(Graphics g)
	{
		for(int i = 0; i < fixedTiles.size(); i++)
		{	
			FixedTile t = fixedTiles.get(i);
			g.drawImage(t.getImage(),(int) t.getX(),(int) t.getY());

			//g2d.draw(t.getCollisionBox());
		}
		
		for(int i = 0; i < coinTiles.size(); i++)
		{	
			CoinTile t = coinTiles.get(i);	
			if(!t.isTaken())
			{
				g.drawImage(t.getImage(),(int) t.getX(),(int) t.getY());
				//g2d.draw(t.getCollisionBox());
				
			}
			
		}
		
		for(int i = 0; i < jumpTiles.size(); i++)
		{	
			JumpTile t = jumpTiles.get(i);
			g.drawImage(t.getImage(),(int) t.getX(),(int) t.getY());
			//g2d.draw(t.getTopLine());
		}
		
		
		//THis next loop causes an error for some reason
		/*for(int i = 0; i < horizontalBounceTiles.size(); i++)
		{	
			HorizontalBounceTile t = horizontalBounceTiles.get(i);
			g.drawImage(Assets.bonus, (int)t.getX(), (int)t.getY());
			
			
			
		}*/
		
	}
	
	public void paintProjectiles(Graphics g)
	{
		for(int i = 0; i < laserProjectiles.size(); i++)
		{
			LaserProjectile t = laserProjectiles.get(i);
			if(t.isVisible())
			{
				g.drawRect((int)t.getX(), (int)t.getY(), 20, 8, Color.RED);
				g.drawRect((int)t.getX(), (int)t.getY() + 2, 20, 4, Color.RED);
				g.drawRect((int)t.getX(), (int)t.getY() + 3, 20, 2, Color.WHITE);
				
			}
		}
		
	}
	@Override
	public void pause()
	{
		if(state == GameState.Running)
			state = GameState.Paused;

	}

	@Override
	public void resume()
	{
		if(state == GameState.Paused)
			state = GameState.Running;
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void backButton()
	{
		pause();
	}
	
	private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));

	}

}
