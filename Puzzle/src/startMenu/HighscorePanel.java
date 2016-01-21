package startMenu;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import game.Frame;
import game.Highscores;

public class HighscorePanel extends JPanel {
	
	
	public HighscorePanel(Frame frame){

		//setting layout
		this.setLayout(new BorderLayout());
		
		//adding title
		JLabel head = new JLabel("Highscores");
		head.setFont(head.getFont().deriveFont(30f));
		this.add(head, "North");

		//adding listener
		ButtonListener buttonList = new ButtonListener(frame);
		
		//creating highscore objects
		Highscores highscore = new Highscores("Highscores.dat");
		Highscores highscoreOn4 = new Highscores("HighscoresOver5.dat");
		Highscores highscoreOver5 = new Highscores("HighscoresOver10.dat");
		
		//making titles for a columns-array
		String[] columnNames = {"Highscores in gridsize 3:", "Highscores in gridsize 4:", "Highscores in gridsize 5:"};
		
		//filling columns-array for table
		Object[][] data = new Object[10][3];
		for(int i = 0;i<10;i++){
			 if(i < highscore.getHighscores().size()){
				 data[i][0] = highscore.getHighscores().get(i);
			 }else{
				 data[i][0] = "";
			 }
			 if (i < highscoreOn4.getHighscores().size()){
				 data[i][1] = highscoreOn4.getHighscores().get(i);
			 } else{
				 data[i][1] = "";
			 }
			 if (i < highscoreOver5.getHighscores().size()){
				 data[i][2] = highscoreOver5.getHighscores().get(i);
			 } else{
				 data[i][2] = "";
			 }
		 }
		
		//adding table to panel
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		tableContainer.setOpaque(false);
		tableContainer.getViewport().setOpaque(false);
		//adding back to menu button
		buttonList = new ButtonListener(frame);
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, BorderLayout.SOUTH);
		backButton.addActionListener(buttonList);
	}

	
}
