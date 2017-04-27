// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

//HUD for new level for the Male player just minor changes, with player names

package com.neet.DiamondHunter.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.neet.DiamondHunter.Entity.Diamond2;
import com.neet.DiamondHunter.Entity.Player3;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.Manager.Content;

public class Hud3 {
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage diamond;
	private BufferedImage boat;
	private BufferedImage axe;
	
	private Player3 player3;
	
	private int numDiamonds;
	
	private Font font;
	private Color textColor; 
	
	public Hud3(Player3 p3, ArrayList<Diamond2> diamonds) {
		
		player3 = p3;
		numDiamonds = diamonds.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		diamond = Content.DIAMOND[0][0];
		boat = Content.ITEMS[0][0];
		axe = Content.ITEMS[0][1];
		
		font = new Font("Arial", Font.PLAIN, 10);
		textColor = new Color(47, 64, 126);
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw hud
		g.drawImage(bar, 0, yoffset, null);
		
		// draw diamond bar
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(28.0 * player3.numDiamonds() / numDiamonds), 4);
		
		// draw diamond amount
		g.setColor(textColor);
		g.setFont(font);
		String s = player3.numDiamonds() + "/" + numDiamonds;
		Content.drawString(g, s, 40, yoffset + 3);
		if(player3.numDiamonds() >= 10) g.drawImage(diamond, 80, yoffset, null);
		else g.drawImage(diamond, 72, yoffset, null);
		
		// draw items
		if(player3.hasBoat3()) g.drawImage(boat, 100, yoffset, null);
		if(player3.hasAxe3()) g.drawImage(axe, 112, yoffset, null);
		
		// draw time
		int minutes = (int) (player3.getTicks() / 1800);
		int seconds = (int) ((player3.getTicks() / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 85, 3);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, minutes + ":" + seconds, 85, 3);
		}
		
		
		
	}
	
}
