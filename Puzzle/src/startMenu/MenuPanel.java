package startMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import startMenu.ButtonListener;
import game.Frame;
import game.Panel;


public class MenuPanel extends JPanel{
	
	public MenuPanel(Frame frame){
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.CYAN);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		JLabel head = new JLabel(frame.getN()*frame.getN()-1+" Sliding Puzzle");
		head.setFont(head.getFont().deriveFont(60f));
		this.add(head, gbc);
		
		ButtonListener buttonList = new ButtonListener(frame);
		JButton playButton = new JButton("Play");
		this.add(playButton,gbc);
		playButton.addActionListener(buttonList);
		
		JButton settingsButton = new JButton("Settings");
		this.add(settingsButton, gbc);
		settingsButton.addActionListener(buttonList);
	
		JButton highscoreButton = new JButton("Highscore");
		this.add(highscoreButton, gbc);
		highscoreButton.addActionListener(buttonList);
	
		JButton exitButton = new JButton("Exit");
		this.add(exitButton, gbc);
		exitButton.addActionListener(buttonList);
	}
}
