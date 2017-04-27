package com.neet.DiamondHunter.JUnit;

import static org.junit.Assert.*;
import org.junit.Test;

import com.neet.DiamondHunter.Entity.Player;

public class PlayerTest {

	@Test
	public void testNumDiamonds() {
	
		
		assertTrue(Player.numDiamonds == 0);
		assertFalse(Player.numDiamonds  ==3);
	}
	
	@Test
	public void testGetTotalDiamonds(){
		assertTrue(Player.getTotalDiamonds() == Player.totalDiamonds);
		assertFalse(Player.getTotalDiamonds() ==1);
	}
	
	@Test
	public void testSetTotalDiamonds(){
		
		Player.setTotalDiamonds(3);
		assertTrue(Player.getTotalDiamonds() == 3);
		assertFalse(Player.getTotalDiamonds() == 4);
	}

	@Test
	public void testHasAxe(){
		assertTrue(Player.hasAxe == false);
		assertFalse(Player.hasAxe == true);
	}
	@Test
	public void testHasBoat(){
		assertTrue(Player.hasBoat == false);
		assertFalse(Player.hasBoat == true);
	}
	@Test
	public void testGetTicks(){
		assertTrue(Player.getTicks() == Player.ticks);
		assertFalse(Player.getTicks() != Player.ticks);
	}
}