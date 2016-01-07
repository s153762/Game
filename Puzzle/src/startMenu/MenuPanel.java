package startMenu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

<<<<<<< HEAD
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
	
}
