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
		
		ButtonListener buttonList = new ButtonListener();
		
		JButton pause = new JButton("Pause");
		this.add(pause, "West");
		pause.addActionListener(buttonList);
		
		JLabel timer = new JLabel("Timer");
		timer.setHorizontalAlignment(JLabel.CENTER);
		this.add(timer, "Center");
	
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, "East");
		backButton.addActionListener(buttonList);
	}
}

