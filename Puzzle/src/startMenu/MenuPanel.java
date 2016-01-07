package startMenu;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import startMenu.Listener;

public class MenuPanel extends JPanel{
	
	public MenuPanel(){

		this.setLayout(new BorderLayout(15, 15));
		
			JPanel test = new JPanel();
			test.setLayout(new GridLayout(4,3));
			
			JButton playButton = new JButton("Play");
			playButton.setSize(new Dimension(15,15));
			test.add(playButton);
			playButton.addActionListener(new Listener());
		
			JButton settingsButton = new JButton("Settings");
			test.add(settingsButton);
			settingsButton.addActionListener(new Listener());
		
			JButton highscoreButton = new JButton("Highscore");
			test.add(highscoreButton);
			highscoreButton.addActionListener(new Listener());
		
			JButton exitButton = new JButton("Exit");
			test.add(exitButton);
			exitButton.addActionListener(new Listener());
			
		this.add(test, "Center");
		
		
	}
	
}
