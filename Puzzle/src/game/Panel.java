package game;

import java.util.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import game.*;

public class Panel extends JPanel{
	private Model model;
	private int n;
	private int x;
	private int y;

	private JLabel[][] gameGrid;
	
	public Panel(int n){
		this.model = new Model(this);
		
		this.n = n;
		this.setBackground(Color.white);
		
		GridLayout gLay = new GridLayout(n,n);
		this.setLayout(gLay);
		
		gameGrid = new JLabel[n][n];
		int temp = 1;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				gameGrid[i][j] = new JLabel(""+temp);
				gameGrid[i][j].setHorizontalAlignment(JLabel.CENTER);
				gameGrid[i][j].setFont (getFont ().deriveFont (64.0f));
				gameGrid[i][j].setBorder(new LineBorder(Color.BLACK));
				this.add(gameGrid[i][j], "Center");
				temp++;
			}
		}
		gameGrid[n-1][n-1].setText("");
		model.shuffle();
	}
	
	public JLabel[][] PuzzleArray(){
		return gameGrid;
	}
	
	public void updateArray(int y, int x, int movey, int movex){
		this.PuzzleArray()[y][x].setText(this.PuzzleArray()[movey][movex].getText());
		this.PuzzleArray()[movey][movex].setText("");
		this.y=movey;
		this.x=movex;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				this.remove(gameGrid[i][j]);
				this.add(gameGrid[i][j], "Center");
			}
		}
		
	}
	
}
