// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

//Player state for the girl for the new map just minor changes, with player names

package com.neet.DiamondHunter.GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.neet.DiamondHunter.Entity.Diamond2;
import com.neet.DiamondHunter.Entity.Item2;
import com.neet.DiamondHunter.Entity.Player4;
import com.neet.DiamondHunter.Entity.Sparkle2;
import com.neet.DiamondHunter.HUD.Hud4;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.Manager.Data;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.Manager.Keys;
import com.neet.DiamondHunter.TileMap2.TileMap2;

public class PlayStateGirl2 extends GameState {
	
	// player
	private Player4 player4;
	
	// tilemap
	private TileMap2 tileMap2;
	
	// diamonds
	private ArrayList<Diamond2> diamonds;
	
	// items
	private ArrayList<Item2> items;
	
	// sparkles
	private ArrayList<Sparkle2> sparkles;
	
	// camera position
	private int xsector;
	private int ysector;
	private int sectorSize; 
	
	// hud
	private Hud4 hud4;
	
	// events
	private boolean blockInput;
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
	
	// transition box
	private ArrayList<Rectangle> boxes;
	
	public PlayStateGirl2(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		// create lists
		diamonds = new ArrayList<Diamond2>();
		sparkles = new ArrayList<Sparkle2>();
		items = new ArrayList<Item2>();
		
		// load map
		tileMap2 = new TileMap2(16);
		tileMap2.loadTiles("/Tilesets/testtileset.gif");
		try {
			tileMap2.loadMap("/Maps/testmap2.map");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create player
		player4 = new Player4(tileMap2);
		
		// fill lists
		populateDiamonds();
		populateItems();
		
		// initialize player
		player4.setTilePosition(17, 17);
		player4.setTotalDiamonds(diamonds.size());
		
		// set up camera position
		sectorSize = GamePanel.WIDTH;
		xsector = player4.getx() / sectorSize;
		ysector = player4.gety() / sectorSize;
		tileMap2.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
		
		// load hud
		hud4 = new Hud4(player4, diamonds);
		
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
		
		Diamond2 d2;
		
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(20, 20);
		d2.addChange(new int[] { 23, 19, 1 });
		d2.addChange(new int[] { 23, 20, 1 });
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(12, 36);
		d2.addChange(new int[] { 31, 17, 1 });
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(28, 4);
		d2.addChange(new int[] {27, 7, 1});
		d2.addChange(new int[] {28, 7, 1});
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(4, 34);
		d2.addChange(new int[] { 31, 21, 1 });
		diamonds.add(d2);
		
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(28, 19);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(35, 26);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(38, 36);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(27, 28);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(20, 30);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(14, 25);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(4, 21);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(9, 14);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(4, 3);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(20, 14);
		diamonds.add(d2);
		d2 = new Diamond2(tileMap2);
		d2.setTilePosition(13, 20);
		diamonds.add(d2);
		
	}
	
	private void populateItems() {
		Random rand = new Random();
		Item2 item2;
		// Note, the co-ordinates for valid positions of boat
		// and axe are obtained by running game and taking
		// co-ordinates of the valid positions at which
		// boat and axe can be placed
		int [] axe_pos_x = {18, 26, 29, 28, 20, 18, 12, 29};
		int [] axe_pos_y = {18, 20, 28, 34, 28, 36, 35, 14};
		int [] boat_pos_x = {12, 9, 13, 30, 25, 13, 17};
		int [] boat_pos_y = {4, 9, 5, 21, 28, 25, 27};
		int ind = rand.nextInt(7);

		item2 = new Item2(tileMap2);
		item2.setType(Item2.AXE);
		item2.setTilePosition(axe_pos_x[ind], axe_pos_y[ind]);
		items.add(item2);
		
		ind = rand.nextInt(7);
		item2 = new Item2(tileMap2);
		item2.setType(Item2.BOAT);
		item2.setTilePosition(boat_pos_x[ind], boat_pos_y[ind]);
		items.add(item2);	
	}
	
	public void update() {
		
		// check keys
		handleInput();
		
		// check events
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
		
		if(player4.numDiamonds() == player4.getTotalDiamonds()) {
			eventFinish = blockInput = true;
		}
		
		// update camera
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player4.getx() / sectorSize;
		ysector = player4.gety() / sectorSize;
		tileMap2.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap2.update();
		
		if(oldxs != xsector || oldys != ysector) {
			JukeBox.play("mapmove");
		}
		
		if(tileMap2.isMoving()) return;
		
		// update player
		player4.update();
		
		// update diamonds
		for(int i = 0; i < diamonds.size(); i++) {
			
			Diamond2 d2 = diamonds.get(i);
			d2.update();
			
			// player collects diamond
			if(player4.intersects(d2)) {
				
				// remove from list
				diamonds.remove(i);
				i--;
				
				// increment amount of collected diamonds
				player4.collectedDiamond();
				
				// play collect sound
				JukeBox.play("collect");
				
				// add new sparkle
				Sparkle2 s2 = new Sparkle2(tileMap2);
				s2.setPosition(d2.getx(), d2.gety());
				sparkles.add(s2);
				
				// make any changes to tile map
				ArrayList<int[]> ali = d2.getChanges();
				for(int[] j : ali) {
					tileMap2.setTile(j[0], j[1], j[2]);
				}
				if(ali.size() != 0) {
					JukeBox.play("tilechange");
				}
				
			}
		}
		
		// update sparkles
		for(int i = 0; i < sparkles.size(); i++) {
			Sparkle2 s2 = sparkles.get(i);
			s2.update();
			if(s2.shouldRemove()) {
				sparkles.remove(i);
				i--;
			}
		}
		
		// update items
		for(int i = 0; i < items.size(); i++) {
			Item2 item2 = items.get(i);
			if(player4.intersects(item2)) {
				items.remove(i);
				i--;
				item2.collected(player4);
				JukeBox.play("collect");
				Sparkle2 s2 = new Sparkle2(tileMap2);
				s2.setPosition(item2.getx(), item2.gety());
				sparkles.add(s2);
			}
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap2.draw(g);
		
		// draw player
		player4.draw(g);
		
		// draw diamonds
		for(Diamond2 d2 : diamonds) {
			d2.draw(g);
		}
		
		// draw sparkles
		for(Sparkle2 s : sparkles) {
			s.draw(g);
		}
		
		// draw items
		for(Item2 i : items) {
			i.draw(g);
		}
		
		// draw hud
		hud4.draw(g);
		
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
		if(Keys.isDown(Keys.LEFT)) player4.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player4.setRight();
		if(Keys.isDown(Keys.UP)) player4.setUp();
		if(Keys.isDown(Keys.DOWN)) player4.setDown();
		if(Keys.isPressed(Keys.SPACE)) player4.setAction();
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
				Data.setTime(player4.getTicks());
				gsm.setState(GameStateManager.GAMEOVER);
			}
		}
	}
	
}
