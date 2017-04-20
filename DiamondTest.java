package com.neet.DiamondHunter.Entity;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetChanges() {
		assertTrue(Diamond.getChanges() == Diamond.tileChanges);
	}

}
