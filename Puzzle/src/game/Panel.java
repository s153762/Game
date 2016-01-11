package game;

import java.util.*;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import game.*;

public class Panel extends JPanel {
	private Model model;
	private int n;
	private int x;
	private int y;
	private boolean firstTime;
	private JLabel[][] puzzleArray;
	
	public Panel(int n){
		this.x = n-1;
		this.y = n-1;
		this.n = n;
		this.model = new Model(this);
		this.puzzleArray = new JLabel[n][n];
		this.firstTime = true;
		this.setBackground(Color.cyan);
		
		Listener list = new Listener(this,this.model);
		this.addKeyListener(list);
		Timer timer = new Timer(1000/100, list);
		GridLayout gLay = new GridLayout(n,n);
		this.setLayout(gLay);
		timer.start();
		//model.shuffle();
		model.startShuffle();
		
	}
	
	public Float FontSize(){
		double fontSize = Frame.size/(n*3);
		return (float) fontSize; 
	}
	
	public void updatePanel(){
		
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				if(firstTime){
					if(model.PuzzleArray()[i][j] != 0){
						puzzleArray[i][j] = new JLabel(""+model.PuzzleArray()[i][j]);
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
					} else{
						puzzleArray[i][j] = new JLabel("");
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));		
					}
				} else{
					if(model.PuzzleArray()[i][j] != 0){
						puzzleArray[i][j].setText(""+model.PuzzleArray()[i][j]);
					} else{
						puzzleArray[i][j].setText("");		
					}
				} 
			}	
			
		}
		firstTime = false;
		}
		
	
	
//	public JLabel[][] PuzzleArray(){
		//return gameGrid;
	//}
	

	
	
	public void youWon(){
		updatePanel();
		System.out.println("You won!");
		this.removeAll();
		JLabel won = new JLabel("You won!");
		won.setHorizontalAlignment(JLabel.CENTER);
		won.setFont (getFont ().deriveFont (100f));
		this.add(won, "Center");
		System.out.println("again");
	}
	
	public int getN() {
		return n;
	}
	
}
