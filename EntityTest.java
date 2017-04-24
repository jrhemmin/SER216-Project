package com.neet.DiamondHunter.Entity;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetx() {
		assertTrue(Entity.x == 0);
		assertFalse(Entity.x == 1);
	}

	@Test
	public void testGety() {
		assertTrue(Entity.y == 0);
		assertFalse(Entity.y == 1);
	}

	@Test
	public void testGetRow() {
		assertTrue(Entity.rowTile == 0);
		assertFalse(Entity.rowTile == 1);
	}

	@Test
	public void testGetCol() {
		assertTrue(Entity.colTile == 0);
		assertFalse(Entity.colTile == 1);
	}

	@Test
	public void testSetPosition() {
		assertEquals(0, Entity.xdest);
		assertEquals(0, Entity.ydest);
	}

	@Test
	public void testSetMapPosition() { 
		assertEquals(0, Entity.xmap);
		assertEquals(0, Entity.ymap);
	}

	@Test
	public void testSetTilePosition() {
		assertEquals(Entity.x, Entity.xdest);
		assertEquals(Entity.y, Entity.ydest);
	}

	@Test
	public void testSetLeft() {
		assertTrue(Entity.moving == false);
		assertTrue(Entity.left == false);
		assertFalse(Entity.moving == true);
		assertFalse(Entity.left == true);
	}

	@Test
	public void testSetRight() {
		assertTrue(Entity.moving == false);
		assertTrue(Entity.right == false);
		assertFalse(Entity.moving == true);
		assertFalse(Entity.right == true);
	}

	@Test
	public void testSetUp() {
		assertTrue(Entity.moving == false);
		assertTrue(Entity.up == false);
		assertFalse(Entity.moving == true);
		assertFalse(Entity.up == true);
	}

	@Test
	public void testSetDown() {
		assertTrue(Entity.moving == false);
		assertTrue(Entity.down == false);
		assertFalse(Entity.moving == true);
		assertFalse(Entity.down == true);
	}

	@Test
	public void testValidateNextPosition() {
		assertTrue(Entity.moving == false);
		assertTrue(Entity.up == false);
		assertTrue(Entity.down == false);
		assertTrue(Entity.left == false);
		assertTrue(Entity.right == false);
		assertFalse(Entity.moving == true);
		assertFalse(Entity.up == true);
		assertFalse(Entity.down == true);
		assertFalse(Entity.left == true);
		assertFalse(Entity.right == true);
	}

	@Test
	public void testGetNextPosition() {
		assertTrue(Entity.left == false);
		assertTrue(Entity.right == false);
		assertTrue(Entity.up == false);
		assertTrue(Entity.down == false);
		assertFalse(Entity.left == true);
		assertFalse(Entity.right == true);
		assertFalse(Entity.up == true);
		assertFalse(Entity.down == true);
	}

	@Test
	public void testUpdate() {
		assertTrue(Entity.moving == false);
		assertFalse(Entity.moving == true);
	}

}
