package com.neet.DiamondHunter.Entity;


import java.awt.Graphics;
import java.awt.Graphics2D;

import org.junit.Test;

import com.neet.DiamondHunter.Entity.Item;
import com.neet.DiamondHunter.Entity.Player;
import com.neet.DiamondHunter.TileMap.TileMap;

public class ItemTest {
	static TileMap tm = new TileMap(40);
	
	@Test
	public void testStetType_validInput_noException(){
		Item it = new Item(tm);
		it.setType(Item.AXE);
		it.setType(Item.BOAT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetType_invalidInput_throwsException() {
		Item it = new Item(tm);
		it.setType(2);
	}
	
	@Test(expected = NullPointerException.class)
	public void testcollected_invalidInput_throwsException(){
		Item it = new Item(tm);
		it.collected(null);
	}
	
	@Test
	public void testcollected_validInput(){
		Item it = new Item(tm);
		Player p = new Player(tm);
		it.setType(Item.AXE);
		it.collected(p);
		
		it.setType(Item.BOAT);
		it.collected(p);
	}
	
}