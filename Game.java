// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.DiamondHunter.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.neet.DiamondHunter.Manager.JukeBox;

public class Game {
	
	public static boolean enabled = true;
	public static void main(String[] args) {
		
		
		JFrame window = new JFrame("Diamond Hunter");
		final JMenuBar menuBar = new JMenuBar();
		JMenuItem menu = new JMenuItem("Help"); //adding help menu
		JMenuItem score = new JMenuItem("Scoring"); //adding scoring menu
		final JMenuItem music = new JMenuItem("Music On");
		menuBar.add(score);
		menuBar.add(menu);
		
		menuBar.add(menu);
		menuBar.add(music);
		
		music.addActionListener(new ActionListener() { 
			public void actionPerformed(final ActionEvent event){
			
				
			
				if(enabled == true){
				JukeBox.setVolume("music1", -80);
				music.setText("Music off");
				enabled = false;
				}
				
				else{
					JukeBox.setVolume("music1", -10);

					music.setText("Music on");
					enabled = true;
				}
				
			}
			
		});
		
		menu.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ev){
				
				JFrame helpWindow = new JFrame("Help"); 
				
				JLabel label = new JLabel("<html> Welcome to Diamond Hunter!<br><br> "
						+ " After clicking start, navigate the map with your arrow keys"
						+ " (up, down, left, right). <br><br>When you encounter obstacles such"
						+ " as trees, you can use the axe to cut the tree down (if you"
						+ " have collected the axe) by pressing the space bar. <br><br>"
						+ " The objective is to collect all 15 Diamonds. <br><br> "
						+ " To pause, use the escape key. <br><br>"
						+ " Good Luck!</html>");
					
				label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
				helpWindow.add(label, BorderLayout.NORTH);
				helpWindow.setSize(new Dimension(500,350)); //size of the box, width by height
				helpWindow.setVisible(true);
			}
		});
		
			score.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent ev){
				JFrame scoreWindow = new JFrame("Scoring");
				
				JLabel label1 = new JLabel("<html><br>  Scoring Ranks:<br><br>" 
						+ "  Speed Demon: Under 2 Minutes <br>"
						+ "  Adventurer: Under 3 Minutes <br>"
						+ "  Beginner: Under 4 Minutes <br>"
						+ "  Bumbling Idiot: Over 4 Minutes </html>");

				
				label1.setFont(new Font("TimesRoman",Font.PLAIN, 20));
				scoreWindow.add(label1, BorderLayout.NORTH);
				scoreWindow.setSize(new Dimension(300,200)); //size of the box, width by height
				scoreWindow.setVisible(true);
			}
			
		});

		window.add(new GamePanel());
		window.add(menuBar, BorderLayout.NORTH);

		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}