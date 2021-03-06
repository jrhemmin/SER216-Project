// Congratulations for finishing the game.
// Gives you a rank based on how long it took
// you to beat the game.

// Under two minutes = Speed Demon
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Bumbling Idiot

package com.neet.DiamondHunter.GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.Data;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.Manager.Keys;

public class GameOverState extends GameState {
	
	private Color color;
	
	private BufferedImage diamond; // added diamond image
	
	
	private int rank;
	private long ticks;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		diamond = Content.DIAMOND[0][0]; // added diamond
		color = new Color(164, 198, 222);
		ticks = Data.getTime();
		if(ticks < 3600) rank = 1;
		else if(ticks < 5400) rank = 2;
		else if(ticks < 7200) rank = 3;
		else rank = 4;
	}
	
	private int currentOption = 0;
	private String[] options =  // added options menu to be 
		{ "Level 2", //able to change maps
			"Quit",
				};
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "finish time", 20, 36);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 44, 48);
			else Content.drawString(g, minutes + ":" + seconds, 44, 48);
		}
		
		Content.drawString(g, "rank", 48, 66);
		if(rank == 1) Content.drawString(g, "speed demon", 20, 78);
		else if(rank == 2) Content.drawString(g, "adventurer", 24, 78);
		else if(rank == 3) Content.drawString(g, "beginner", 32, 78);
		else if(rank == 4) Content.drawString(g, "bumbling idiot", 8, 78);
		
		Content.drawString(g, options[0] ,25, 110); //draw lettering for options
		Content.drawString(g, options[1] ,25, 120);
		
		if(currentOption == 0) g.drawImage(diamond, 10, 108, null); //draw diamond
		if(currentOption == 1) g.drawImage(diamond, 10, 118, null);
	}
	public void handleInput() { //handle the key inputs
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length -1)
		{
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0)
		{
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER))
		{
			JukeBox.play("collect");
			selectOption();
		}
	}

	
	private void selectOption() //handle the selections from the menu
	{
		if(currentOption == 0)
		{
			gsm.setState(GameStateManager.LEVEL_2);
		}
		if(currentOption == 1)
		{
			System.exit(1);
		}
		
	}
	
	
}