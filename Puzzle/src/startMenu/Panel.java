package startMenu;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import startMenu.Listener;
import startMenu.Model;

public class Panel extends JPanel{
	
	public Panel(){
		
		JButton playButton = new JButton("Play");
		this.add(playButton, "center");
		playButton.addActionListener(new Listener());
		
		JButton settingsButton = new JButton("Settings");
		this.add(settingsButton);
		settingsButton.addActionListener(new Listener());
		
		JButton highscoreButton = new JButton("Highscore");
		this.add(highscoreButton);
		highscoreButton.addActionListener(new Listener());
		
		JButton exitButton = new JButton("Exit");
		this.add(exitButton);
		exitButton.addActionListener(new Listener());
	}
	
}
