package startMenu;

<<<<<<< HEAD
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

<<<<<<< HEAD
import startMenu.Listener;
=======

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import startMenu.ButtonListener;
import game.Frame;

>>>>>>> Making-Highscore

public class MenuPanel extends JPanel{
	
	public MenuPanel(Frame frame){
		this.setLayout(new GridBagLayout());
		this.setSize((int) (frame.size*1.25),(int) frame.size);
		
		//setting the layout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		//Adding title
		JLabel head = new JLabel(frame.getN()*frame.getN()-1+" Sliding Puzzle");
		head.setFont(head.getFont().deriveFont(60f));
		add(head, gbc);
		
<<<<<<< HEAD
			JButton exitButton = new JButton("Exit");
			test.add(exitButton);
			exitButton.addActionListener(new Listener());
			
		this.add(test, "Center");
=======
public class MenuPanel extends JPanel implements ActionListener{
	
	public MenuPanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
>>>>>>> 8bd4123ae77a812314611db38c629a1b68713ac7
		
		JButton playButton = new JButton("Play");
		this.add(playButton,gbc);
		playButton.addActionListener(this);
		
		JButton settingsButton = new JButton("Settings");
		this.add(settingsButton, gbc);
		settingsButton.addActionListener(this);
	
		JButton highscoreButton = new JButton("Highscore");
		this.add(highscoreButton, gbc);
		highscoreButton.addActionListener(this);
	
		JButton exitButton = new JButton("Exit");
		this.add(exitButton, gbc);
		exitButton.addActionListener(this);
	}
		public void actionPerformed(ActionEvent event){
			String keyPressed = event.getActionCommand();
			
			switch(keyPressed){
				case "Play": System.out.println("Play");
				break;
				
				case "Settings": System.out.println("Settings");
				break;
				
				case "Highscore": System.out.println("Highscore");
				break;
				
				case "Exit": System.out.println("Exit");
			}
		}
=======
		//adding Listener
		ButtonListener buttonList = new ButtonListener(frame);
		
		//adding play button
		JButton playButton = new JButton("Play");
		add(playButton,gbc);
		playButton.addActionListener(buttonList);
		
		//adding settings button
		JButton settingsButton = new JButton("Settings");
		this.add(settingsButton, gbc);
		settingsButton.addActionListener(buttonList);
	
		//adding highscore button
		JButton highscoreButton = new JButton("Highscore");
		this.add(highscoreButton, gbc);
		highscoreButton.addActionListener(buttonList);
>>>>>>> Making-Highscore
	
		//adding exit button
		JButton exitButton = new JButton("Exit");
		this.add(exitButton, gbc);
		exitButton.addActionListener(buttonList);
	}
}
