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
	private Frame frame;
	
	public InGamePanel( Frame frame){
		this.setLayout(new BorderLayout());
		ButtonListener buttonList = new ButtonListener(frame);
		
		JButton pause = new JButton("Pause");
		this.add(pause, "West");
		pause.addActionListener(buttonList);
		
		JLabel timer = new JLabel("");
		timer.setHorizontalAlignment(JLabel.CENTER);
		this.add(timer, "Center");
	
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, "East");
		backButton.addActionListener(buttonList);
	}
}

