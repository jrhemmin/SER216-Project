package com.neet.DiamondHunter.JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neet.DiamondHunter.Entity.Sparkle;
import com.neet.DiamondHunter.TileMap.TileMap;

public class SparkleTest {

	@Test
	public void testSparkleConstructor() {
		TileMap tm = new TileMap(16);
		Sparkle sparkle = new Sparkle(tm);
		
		assertTrue(sparkle.height == 16);
		assertTrue(sparkle.width == 16);
		assertFalse(sparkle.height == 0);
		assertFalse(sparkle.width == 0);
	}

	@Test
	public void testShouldRemove(){
		assertTrue(Sparkle.shouldRemove() == false);
		assertFalse(Sparkle.shouldRemove() == true);
		}
}