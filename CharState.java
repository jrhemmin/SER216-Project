package com.neet.DiamondHunter.Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.GameState.GameState;

public class CharState extends GameState{
	
	private BufferedImage bg;
	private BufferedImage playersprites;
	private BufferedImage playersprites2;
	private BufferedImage diamond;
	
	private int currentOption = 0;
	private String[] options = {
		"MALE", //option to change character 
		"FEMALE",
	};
	
	public CharState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		playersprites = Content.PLAYER[0][0];
		playersprites2 = Content.PLAYER2[0][0];
		diamond = Content.DIAMOND[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		g.drawImage(playersprites, 75, 72, null);
		g.drawImage(playersprites2, 75, 92, null);
		
		Content.drawString(g, options[0], 15, 76);
		Content.drawString(g, options[1], 15, 96);
		
		if(currentOption == 0) g.drawImage(diamond, 0, 72, null);
		else if(currentOption == 1) g.drawImage(diamond, 0, 92, null); 

		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
			JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if(currentOption == 1) {  // Added option for choosing character
			gsm.setState(GameStateManager.PLAY2);
		}

		
	}

}
