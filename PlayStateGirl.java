	// The main playing GameState for the female player.
	// Contains everything you need for game play:
	// Player2, TileMap, Diamonds, etc.
	// Updates and draws all game objects.
package com.neet.DiamondHunter.GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.neet.DiamondHunter.Entity.Diamond;
import com.neet.DiamondHunter.Entity.Item;
import com.neet.DiamondHunter.Entity.Player2;
import com.neet.DiamondHunter.Entity.Sparkle;
import com.neet.DiamondHunter.HUD.Hud2;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.Manager.Data;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.Manager.Keys;
import com.neet.DiamondHunter.TileMap.TileMap;
	
public class PlayStateGirl extends GameState {

	// player
	private Player2 player2;
		
	// tilemap
	private TileMap tileMap;
		
	// diamonds
	private ArrayList<Diamond> diamonds;
		
	// items
	private ArrayList<Item> items;
		
	// sparkles
	private ArrayList<Sparkle> sparkles;
	
	// camera position
	private int xsector;
	private int ysector;
	private int sectorSize; 
		
	// hud
	private Hud2 hud2;
		
	// events
	private boolean blockInput;
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
		
	// transition box
	private ArrayList<Rectangle> boxes;
		
	public PlayStateGirl(GameStateManager gsm) {
			super(gsm);
	}
		
	public void init() {
			
		// create lists
		diamonds = new ArrayList<Diamond>();
		sparkles = new ArrayList<Sparkle>();
		items = new ArrayList<Item>();
			
		// load map
		tileMap = new TileMap(16);
		tileMap.loadTiles("/Tilesets/testtileset.gif");
		try {
			tileMap.loadMap("/Maps/testmap.map");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// create player
		player2 = new Player2(tileMap);
			
		// fill lists
		populateDiamonds();
		populateItems();
			
		// initialize player
		player2.setTilePosition(17, 17);
		player2.setTotalDiamonds(diamonds.size());
			
		// set up camera position
		sectorSize = GamePanel.WIDTH;
		xsector = player2.getx() / sectorSize;
		ysector = player2.gety() / sectorSize;
		tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
			
		// load hud
		hud2 = new Hud2(player2, diamonds);
			
		// load music
		JukeBox.load("/Music/bgmusic.mp3", "music1");
		JukeBox.setVolume("music1", -10);
		JukeBox.loop("music1", 1000, 1000, JukeBox.getFrames("music1") - 1000);
		JukeBox.load("/Music/finish.mp3", "finish");
		JukeBox.setVolume("finish", -10);
			
		// load sfx
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/mapmove.wav", "mapmove");
		JukeBox.load("/SFX/tilechange.wav", "tilechange");
		JukeBox.load("/SFX/splash.wav", "splash");
			
		// start event
		boxes = new ArrayList<Rectangle>();
		eventStart = true;
		eventStart();
				
		}
		
	private void populateDiamonds() {
		
		Diamond d;
			
		d = new Diamond(tileMap);
		d.setTilePosition(20, 20);
		d.addChange(new int[] { 23, 19, 1 });
		d.addChange(new int[] { 23, 20, 1 });
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(12, 36);
		d.addChange(new int[] { 31, 17, 1 });
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(28, 4);
		d.addChange(new int[] {27, 7, 1});
		d.addChange(new int[] {28, 7, 1});
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(4, 34);
		d.addChange(new int[] { 31, 21, 1 });
		diamonds.add(d);
			
		d = new Diamond(tileMap);
		d.setTilePosition(28, 19);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(35, 26);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(38, 36);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(27, 28);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(20, 30);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(14, 25);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(4, 21);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(9, 14);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(4, 3);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(20, 14);
		diamonds.add(d);
		d = new Diamond(tileMap);
		d.setTilePosition(13, 20);
		diamonds.add(d);
			
	}
		
	private void populateItems() {
		Random rand = new Random();
		Item item;
		// Note, the co-ordinates for valid positions of boat
		// and axe are obtained by running game and taking
		// co-ordinates of the valid positions at which
		// boat and axe can be placed
		int [] axe_pos_x = {18, 26, 29, 28, 20, 18, 12, 29};
		int [] axe_pos_y = {18, 20, 28, 34, 28, 36, 35, 14};
		int [] boat_pos_x = {12, 9, 13, 30, 25, 13, 17};
		int [] boat_pos_y = {4, 9, 5, 21, 28, 25, 27};
		int ind = rand.nextInt(7);

		item = new Item(tileMap);
		item.setType(Item.AXE);
		item.setTilePosition(axe_pos_x[ind], axe_pos_y[ind]);
		items.add(item);
			
		ind = rand.nextInt(7);
		item = new Item(tileMap);
		item.setType(Item.BOAT);
		item.setTilePosition(boat_pos_x[ind], boat_pos_y[ind]);
		items.add(item);	
	}
		
	public void update() {
			
		// check keys
		handleInput();
			
		// check events
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
			
		if(player2.numDiamonds() == player2.getTotalDiamonds()) {
			eventFinish = blockInput = true;
		}
			
		// update camera
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player2.getx() / sectorSize;
		ysector = player2.gety() / sectorSize;
		tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap.update();
			
		if(oldxs != xsector || oldys != ysector) {
			JukeBox.play("mapmove");
		}
			
		if(tileMap.isMoving()) return;
			
		// update player
		player2.update();
			
		// update diamonds
		for(int i = 0; i < diamonds.size(); i++) {
				
			Diamond d = diamonds.get(i);
			d.update();
				
			// player collects diamond
			if(player2.intersects(d)) {
					
				// remove from list
				diamonds.remove(i);
				i--;
					
				// increment amount of collected diamonds
				player2.collectedDiamond();
					
				// play collect sound
				JukeBox.play("collect");
					
				// add new sparkle
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(d.getx(), d.gety());
				sparkles.add(s);
					
				// make any changes to tile map
				ArrayList<int[]> ali = d.getChanges();
				for(int[] j : ali) {
					tileMap.setTile(j[0], j[1], j[2]);
				}
				if(ali.size() != 0) {
					JukeBox.play("tilechange");
				}
					
			}
		}
			
		// update sparkles
		for(int i = 0; i < sparkles.size(); i++) {
			Sparkle s = sparkles.get(i);
			s.update();
			if(s.shouldRemove()) {
				sparkles.remove(i);
				i--;
			}
		}
			
		// update items
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(player2.intersects(item)) {
				items.remove(i);
				i--;
				item.collected(player2);
				JukeBox.play("collect");
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(item.getx(), item.gety());
				sparkles.add(s);
			}
		}
			
	}
		
	public void draw(Graphics2D g) {
			
		// draw tilemap
		tileMap.draw(g);
			
		// draw player
		player2.draw(g);
			
		// draw diamonds
		for(Diamond d : diamonds) {
			d.draw(g);
		}
			
		// draw sparkles
		for(Sparkle s : sparkles) {
			s.draw(g);
		}
			
		// draw items
		for(Item i : items) {
			i.draw(g);
		}
			
		// draw hud
		hud2.draw(g);
			
		// draw transition boxes
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < boxes.size(); i++) {
			g.fill(boxes.get(i));
		}
			
	}
		
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			JukeBox.stop("music1");
			gsm.setPaused(true);
		}
		if(blockInput) return;
		if(Keys.isDown(Keys.LEFT)) player2.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player2.setRight();
		if(Keys.isDown(Keys.UP)) player2.setUp();
		if(Keys.isDown(Keys.DOWN)) player2.setDown();
		if(Keys.isPressed(Keys.SPACE)) player2.setAction();
	}
		
	//===============================================
		
	private void eventStart() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				boxes.add(new Rectangle(0, i * 16, GamePanel.WIDTH, 16));
			}
		}
		if(eventTick > 1 && eventTick < 32) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					r.x -= 4;
				}
				else {
					r.x += 4;
				}
			}
		}
		if(eventTick == 33) {
			boxes.clear();
			eventStart = false;
			eventTick = 0;
		}
	}
		
	private void eventFinish() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				if(i % 2 == 0) boxes.add(new Rectangle(-128, i * 16, GamePanel.WIDTH, 16));
				else boxes.add(new Rectangle(128, i * 16, GamePanel.WIDTH, 16));
			}
			JukeBox.stop("music1");
			JukeBox.play("finish");
		}
		if(eventTick > 1) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					if(r.x < 0) r.x += 4;
				}
				else {
					if(r.x > 0) r.x -= 4;
				}
			}
		}
		if(eventTick > 33) {
			if(!JukeBox.isPlaying("finish")) {
				Data.setTime(player2.getTicks());
				gsm.setState(GameStateManager.GAMEOVER);
			}
		}
	}
		
}
