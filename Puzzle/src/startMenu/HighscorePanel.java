package startMenu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Frame;
import game.Highscores;

public class HighscorePanel extends JPanel {
	
	public HighscorePanel(Frame frame){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		headerLabel.setText("Control in action: JTextArea")
		
		JLabel score = new JLabel("Highscores");
		JLabel score5 = new JLabel("Highscores in over gridsize 5");
		JLabel score10 = new JLabel("Highscores  in over gridsize 10");
		
		Highscores highscore = new Highscores("Highscores.dat");
		Highscores highscore5 = new Highscores("HighscoresOver5.dat");
		Highscores highscore10 = new Highscores("HighscoresOver10.dat");
		JLabel

		
		
		
		
		ButtonListener buttonList = new ButtonListener(frame);
		JButton backButton = new JButton("Back to menu");
		this.add(backButton,gbc);
		backButton.addActionListener(buttonList);
	}

	
}
