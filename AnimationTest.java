package com.neet.DiamondHunter.JUnit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.neet.DiamondHunter.Entity.Animation;

public class AnimationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAnimation() {
		assertTrue(Animation.timesPlayed == 0);
		assertFalse(Animation.timesPlayed == 1);
		assertEquals(0, Animation.timesPlayed);
		
	}

	@Test
	public void testSetDelay() {
		assertTrue(Animation.delay == -1);
	}
 
	@Test
	public void testSetFrame() {
	
		assertTrue(Animation.currentFrame == 0);
		assertFalse(Animation.currentFrame == 1);
		assertEquals(0, Animation.currentFrame);
		assertEquals(Animation.currentFrame, Animation.currentFrame);
	}

	@Test
	public void testSetNumFrames() {
		assertTrue(Animation.numFrames == 0);
		assertTrue(Animation.numFrames != 0);
		
	}

	@Test
	public void testUpdate() {
		assertTrue(Animation.delay == -1); 

	}
 
	@Test
	public void testGetFrame() {
		assertTrue(Animation.currentFrame == 0);
		assertFalse(Animation.currentFrame == 0);
	}

	@Test
	public void testGetCount() {
		assertTrue(Animation.count == 1);
	}

	@Test
	public void testHasPlayedOnce() {
		
		assertTrue(Animation.timesPlayed > 0);
	}

	@Test
	public void testHasPlayed() {
		assertTrue(Animation.timesPlayed == 0);
		assertTrue(Animation.timesPlayed == 1);
	} 

}
