// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package com.neet.DiamondHunter.Manager;

import java.awt.Graphics2D;

import com.neet.DiamondHunter.GameState.GameOverState;
import com.neet.DiamondHunter.GameState.GameState;
import com.neet.DiamondHunter.GameState.IntroState;
import com.neet.DiamondHunter.GameState.MenuState;
import com.neet.DiamondHunter.GameState.PauseState;
import com.neet.DiamondHunter.GameState.PlayState;
import com.neet.DiamondHunter.GameState.PlayState2;
import com.neet.DiamondHunter.GameState.PlayStateGirl;
import com.neet.DiamondHunter.GameState.PlayStateGirl2;
import com.neet.DiamondHunter.TileMap2.TileMap2;


public class GameStateManager {
	
	private boolean paused;
	private PauseState pauseState;
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 9;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int CHAR = 2;
	public static final int PLAY = 3;
	public static final int PLAY2 = 4;
	public static final int GAMEOVER = 5;
	public static final int LEVEL_2 = 6;
	public static final int PLAY3 = 7;
	public static final int PLAY4 = 8;
	
	
	public GameStateManager() {
		
		JukeBox.init();
		
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
		
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == INTRO) {
			gameStates[i] = new IntroState(this);
			gameStates[i].init();
		}
		else if(i == MENU) {
			gameStates[i] = new MenuState(this);
			gameStates[i].init();
		}
		else if(i == CHAR)
		{
			gameStates[i] = new CharState(this);
			gameStates[i].init();
		}
		else if(i == PLAY) {
			gameStates[i] = new PlayState(this);
			gameStates[i].init();
		}
		else if(i == PLAY2) {
			gameStates[i] = new PlayStateGirl(this);
			gameStates[i].init();
		}
		else if(i == GAMEOVER) {
			gameStates[i] = new GameOverState(this);
			gameStates[i].init();
		}
		else if(i == LEVEL_2)
		{
			gameStates[i] = new CharState(this);
			gameStates[i].init();
		}
		else if(i == PLAY3) {
			gameStates[i] = new PlayState2(this);
			gameStates[i].init();
		}
		else if(i == PLAY4) {
			gameStates[i] = new PlayStateGirl2(this);
			gameStates[i].init();
		}
	}
	
	public void unloadState(int i) {
		gameStates[i] = null;
	}
	
	public void setPaused(boolean b) {
		paused = b;
	}
	
	public void update() {
		if(paused) {
			pauseState.update();
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}
	
	public void draw(Graphics2D g) {
		if(paused) {
			pauseState.draw(g);
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}
	
}
