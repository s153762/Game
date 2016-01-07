package startMenu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener{
	
	public MenuPanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
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
	
}
