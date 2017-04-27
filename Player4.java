// The only subclass the fully utilizes the
// Entity superclass (no other class requires
// movement in a tile based map).
// Contains all the gameplay associated with
// the Player.

// for the female player for second map just minor changes, with player names

package com.neet.DiamondHunter.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.TileMap2.TileMap2;

public class Player4 extends Entity2 {
	
	// sprites
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	private BufferedImage[] downBoatSprites;
	private BufferedImage[] leftBoatSprites;
	private BufferedImage[] rightBoatSprites;
	private BufferedImage[] upBoatSprites;
	
	// animation
	private static final int DOWN = 0; //changed the field to static
	private static final int LEFT = 1;   //changed the field to static
	private static final int RIGHT = 2;   //changed the field to static
	private static final int UP = 3;   //changed the field to static
	private static final int DOWNBOAT = 4;  //changed the field to static
	private static final int LEFTBOAT = 5;  //changed the field to static
	private static final int RIGHTBOAT = 6;  //changed the field to static
	private static final int UPBOAT = 7;  //changed the field to static
	
	// gameplay
	private int numDiamonds;
	private int totalDiamonds;
	private boolean hasBoat4;
	private boolean hasAxe4;
	private boolean onWater;
	private long ticks;
	
	public Player4(TileMap2 tm2) {
		 
		super(tm2);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		moveSpeed = 2;
		
		numDiamonds = 0;
		
		downSprites = Content.PLAYER2[0];
		leftSprites = Content.PLAYER2[1];
		rightSprites = Content.PLAYER2[2];
		upSprites = Content.PLAYER2[3];
		downBoatSprites = Content.PLAYER2[4];
		leftBoatSprites = Content.PLAYER2[5];
		rightBoatSprites = Content.PLAYER2[6];
		upBoatSprites = Content.PLAYER2[7];
		
		animation.setFrames(downSprites);
		animation.setDelay(10);
		
	}
	
	private void setAnimation(int i, BufferedImage[] bi, int d) {
		currentAnimation = i;
		animation.setFrames(bi);
		animation.setDelay(d);
	}
	
	public void collectedDiamond() { numDiamonds++; }
	public int numDiamonds() { return numDiamonds; }
	public int getTotalDiamonds() { return totalDiamonds; }
	public void setTotalDiamonds(int i) { totalDiamonds = i; }
	
	public void gotBoat4() { hasBoat4 = true; tileMap2.replace(22, 4); }
	public void gotAxe4() { hasAxe4 = true; }
	public boolean hasBoat4() { return hasBoat4; }
	public boolean hasAxe4() { return hasAxe4; }
	
	// Used to update time.
	public long getTicks() { return ticks; }
	
	// Keyboard input. Moves the player.
	public void setDown() {
		super.setDown();
	}
	public void setLeft() {
		super.setLeft();
	}
	public void setRight() {
		super.setRight();
	}
	public void setUp() {
		super.setUp();
	}
	
	// Keyboard input.
	// If Player has axe, dead trees in front
	// of the Player will be chopped down.
	public void setAction() {
		if(hasAxe4) {
			if(currentAnimation == UP && tileMap2.getIndex(rowTile - 1, colTile) == 21) {
				tileMap2.setTile(rowTile - 1, colTile, 1);
				JukeBox.play("tilechange");
			}
			if(currentAnimation == DOWN && tileMap2.getIndex(rowTile + 1, colTile) == 21) {
				tileMap2.setTile(rowTile + 1, colTile, 1);
				JukeBox.play("tilechange");
			}
			if(currentAnimation == LEFT && tileMap2.getIndex(rowTile, colTile - 1) == 21) {
				tileMap2.setTile(rowTile, colTile - 1, 1);
				JukeBox.play("tilechange");
			}
			if(currentAnimation == RIGHT && tileMap2.getIndex(rowTile, colTile + 1) == 21) {
				tileMap2.setTile(rowTile, colTile + 1, 1);
				JukeBox.play("tilechange");
			}
		}
	}
	
	public void update() {
		
		ticks++;
		
		// check if on water
		boolean current = onWater;
		if(tileMap2.getIndex(ydest / tileSize, xdest / tileSize) == 4) {
			onWater = true;
		}
		else {
			onWater = false;
		}
		// if going from land to water
		if(!current && onWater) {
			JukeBox.play("splash");
		}
		
		// set animation
		if(down) {
			if(onWater && currentAnimation != DOWNBOAT) {
				setAnimation(DOWNBOAT, downBoatSprites, 10);
			}
			else if(!onWater && currentAnimation != DOWN) {
				setAnimation(DOWN, downSprites, 10);
			}
		}
		if(left) {
			if(onWater && currentAnimation != LEFTBOAT) {
				setAnimation(LEFTBOAT, leftBoatSprites, 10);
			}
			else if(!onWater && currentAnimation != LEFT) {
				setAnimation(LEFT, leftSprites, 10);
			}
		}
		if(right) {
			if(onWater && currentAnimation != RIGHTBOAT) {
				setAnimation(RIGHTBOAT, rightBoatSprites, 10);
			}
			else if(!onWater && currentAnimation != RIGHT) {
				setAnimation(RIGHT, rightSprites, 10);
			}
		}
		if(up) {
			if(onWater && currentAnimation != UPBOAT) {
				setAnimation(UPBOAT, upBoatSprites, 10);
			}
			else if(!onWater && currentAnimation != UP) {
				setAnimation(UP, upSprites, 10);
			}
		}
		
		// update position
		super.update();
		
	}
	
	// Draw Player.
	public void draw(Graphics2D g) {
		super.draw(g);
	}


	
}