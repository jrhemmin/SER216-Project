// Simple class that plays animation
// once and is removed.

//New sparkle class for the new map, minor changes 

package com.neet.DiamondHunter.Entity;

import java.awt.Graphics2D;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.TileMap2.TileMap2;

public class Sparkle2 extends Entity2 { //extends Entity2 not entity
	
	private boolean remove;
	
	public Sparkle2(TileMap2 tm2) { //TileMap2 not TileMap, tm2 not tm
		super(tm2);
		animation.setFrames(Content.SPARKLE[0]);
		animation.setDelay(5);
		width = height = 16;
	}
	
	public boolean shouldRemove() {
		return remove;
	}
	
	public void update() {
		animation.update();
		if(animation.hasPlayedOnce()) remove = true;
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
