package game;

import java.util.*;
import java.awt.*;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import game.Listener;
import game.Model;

public class Panel extends JPanel{
private Model model;
private int number;

	private JLabel[][] gameGrid;
	
	public Panel(int number){
		model = new Model(this);
		GridLayout gLay = new GridLayout(number,number);
		this.setLayout(gLay);
		
		this.number = number;
		gameGrid = new JLabel[number][number];
		this.setBackground(Color.white);
		int temp = 1;
		for(int i = 0; i<number;i++){
			for(int j = 0;j<number;j++){
				gameGrid[i][j] = new JLabel(""+temp);
				gameGrid[i][j].setHorizontalAlignment(JLabel.CENTER);
				gameGrid[i][j].setFont (getFont ().deriveFont (64.0f));
				
				gameGrid[i][j].setBorder(new LineBorder(Color.BLACK));
				this.add(gameGrid[i][j], "Center");
				temp++;
			}
		}
		gameGrid[number-1][number-1].setText("");
		

	}
	public JLabel[][] PuzzleArray()
	{
		return gameGrid;
	}
}
