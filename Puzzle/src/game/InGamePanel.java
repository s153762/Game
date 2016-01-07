package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import startMenu.ButtonListener;

public class InGamePanel extends JPanel{
	
	public InGamePanel(){
		this.setLayout(new BorderLayout());
		
		JButton pause = new JButton("Pause");
		this.add(pause, "West");
		//playButton.addActionListener(buttonList);
		
		JLabel timer = new JLabel("Timer");
		timer.setHorizontalAlignment(JLabel.CENTER);
		this.add(timer, "Center");
		//settingsButton.addActionListener(buttonList);
	
		JButton exitButton = new JButton("Exit");
		this.add(exitButton, "East");
		//exitButton.addActionListener(buttonList);
	}
}

