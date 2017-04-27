// Possibly redundant subclass of Entity.
// There are two types of items: Axe and boat.
// Upon collection, informs the Player
// that the Player does indeed have the item.

//for second map of the game just minor changes with names and labels

package com.neet.DiamondHunter.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Entity.Player3;
import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.TileMap2.TileMap2;

public class Item2 extends Entity2{ 
	
	private BufferedImage sprite;
	private int type;
	public static final int BOAT = 0;
	public static final int AXE = 1;
	
	public Item2(TileMap2 tm2) {
		super(tm2);
		type = -1;
		width = height = 16;
		cwidth = cheight = 12;
	}
	
	public void setType(int i) {
		type = i;
		if(type == BOAT) {
			sprite = Content.ITEMS[1][0];
		}
		else if(type == AXE) {
			sprite = Content.ITEMS[1][1];
		}
	}
	
	public void collected(Player3 player3) {
		if(type == BOAT) {
			player3.gotBoat3();
		}
		if(type == AXE) {
			player3.gotAxe3();
		}
	}
	public void collected(Player4 player4) {
		if(type == BOAT) {
			player4.gotBoat4();
		}
		if(type == AXE) {
			player4.gotAxe4()
			; 
		}
	}
	
	public void draw(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}
	
}
