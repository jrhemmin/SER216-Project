package com.neet.DiamondHunter.JUnit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.neet.DiamondHunter.Manager.Data;

public class DataTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSetTime() {
		assertTrue(Data.time == 0);
		assertTrue(Data.time == 1);

	}

	@Test
	public void testGetTime() {
		assertEquals(Data.time, Data.time);
		assertEquals(0, Data.time);
		assertTrue(Data.time > 0);
	}

}
