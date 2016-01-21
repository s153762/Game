package startMenu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import startMenu.ButtonListener;
import game.Frame;


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
	
		//adding exit button
		JButton exitButton = new JButton("Exit");
		this.add(exitButton, gbc);
		exitButton.addActionListener(buttonList);
	}
}
