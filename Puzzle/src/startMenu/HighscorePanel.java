package startMenu;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import game.Frame;
import game.Highscores;

public class HighscorePanel extends JPanel {
	
	
	
	public HighscorePanel(Frame frame){

		this.setLayout(new BorderLayout());
		this.setBackground(Color.cyan);
		
		JLabel head = new JLabel("Highscores");
		head.setFont(head.getFont().deriveFont(30f));
		this.add(head, "North");

		String[] columnNames = {"Highscores in gridsize 3:", "Highscores in gridsize 4:", "Highscores in gridsize 5:"};
		
		Highscores highscore = new Highscores("Highscores.dat");
		Highscores highscore5 = new Highscores("HighscoresOver5.dat");
		Highscores highscore10 = new Highscores("HighscoresOver10.dat");
		ButtonListener buttonList = new ButtonListener(frame);
		Object[][] data = new Object[10][3];
		for(int i = 0;i<10;i++){
			 if(i < highscore.getHighscores().size()){
				 data[i][0] = highscore.getHighscores().get(i);
			 }else{
				 data[i][0] = "";
			 }
			 if (i < highscore5.getHighscores().size()){
				 data[i][1] = highscore5.getHighscores().get(i);
			 } else{
				 data[i][1] = "";
			 }
			 if (i < highscore10.getHighscores().size()){
				 data[i][2] = highscore10.getHighscores().get(i);
			 } else{
				 data[i][2] = "";
			 }
		 }
		
		JTable table = new JTable(data, columnNames);
		JScrollPane tableContainer = new JScrollPane(table);
		this.add(tableContainer, BorderLayout.CENTER);
		
		buttonList = new ButtonListener(frame);
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, BorderLayout.SOUTH);
		backButton.addActionListener(buttonList);
	}

	
}
