// Diamond class.
// May contain a list of tileChanges.
// These tileChanges are used to modify
// the tile map upon collection.

// for new map, minor changes 

package com.neet.DiamondHunter.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.TileMap2.TileMap2;

public class Diamond2 extends Entity2 {
	
	private BufferedImage[] sprites;
	
	private ArrayList<int[]> tileChanges;
	
	public Diamond2(TileMap2 tm2) {

		super(tm2);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		sprites = Content.DIAMOND[0];
		animation.setFrames(sprites);
		animation.setDelay(10);
		
		tileChanges = new ArrayList<int[]>();
		
	}
	
	public void addChange(int[] i) {
		tileChanges.add(i);
	}
	public ArrayList<int[]> getChanges() {
		return tileChanges;
	}
	
	public void update() {
		animation.update();
		
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
