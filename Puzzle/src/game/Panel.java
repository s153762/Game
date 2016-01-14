package game;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import game.*;

public class Panel extends JPanel {
	private Model model;
	private int n;
	private int x;
	private int y;
	private Frame frame;
	private boolean firstTime;
	private Listener list;
	private JLabel[][] puzzleArray;
	private InGamePanel inGamePanel;
	
	public Panel(int n, InGamePanel inGamePanel, Frame frame){
		this.x = n-1;
		this.y = n-1;
		this.n = n;
		this.model = new Model(this);
		this.puzzleArray = new JLabel[n][n];
		this.firstTime = true;
		this.setBackground(Color.cyan);
		this.inGamePanel = inGamePanel;
		this.frame = frame;
		
		list = new Listener(this,this.model);
		this.addKeyListener(list);
//		Timer timer = new Timer(1000/100, list);
		GridLayout gLay = new GridLayout(n,n);
		this.setLayout(gLay);
//		timer.start();
		//model.shuffle();
		model.startShuffle();
		
		
	}
	
	public Float FontSize(){
		double fontSize = Frame.size/(n*2);
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
						//puzzleArray[i][j].setBackground(Color.black);
						//puzzleArray[i][j].setOpaque(true);
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));		
					}
				} else{
					if(model.PuzzleArray()[i][j] == 0){
						puzzleArray[i][j].setText("");
						puzzleArray[i][j].setOpaque(false);
						puzzleArray[i][j].setBackground(Color.cyan);
					
						
						
					} else if(model.PuzzleArray()[i][j] == n*n){
						puzzleArray[i][j].setBackground(Color.black);
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setText("");	
					}
					else{
						puzzleArray[i][j].setOpaque(false);
						puzzleArray[i][j].setBackground(Color.cyan);
						puzzleArray[i][j].setText(""+model.PuzzleArray()[i][j]);
					}
				} 
			}	
			
		}
		firstTime = false;
		inGamePanel.updateMoveCount(model.getMoveCount());
		}
		
	
	
//	public JLabel[][] PuzzleArray(){
		//return gameGrid;
	//}
	

	public void setDifficulty(int hardMode){
		model.setHardMode(hardMode);
	}
	
	public void youWon(){
		updatePanel();
		System.out.println("You won!");
		//this.removeKeyListener(list);
		//this.removeAll();
//		JLabel won = new JLabel("You won!");
//		
//		won.setHorizontalAlignment(JLabel.CENTER);
//		won.setFont (getFont ().deriveFont (100f));
//		this.add(won, "Center");
		inGamePanel.stopTimerWin();
		
		Highscore highscore = new Highscore(inGamePanel.getTime());
		highscore.updateScore();
		
		int choice = JOptionPane.showConfirmDialog(null,"You won the game! Do you want to play again?");
		if (choice == JOptionPane.YES_OPTION){
			//hvad skal der ske hvis man vil spille igen
			frame.showMenu();
			frame.showGame();
		} else if(choice == JOptionPane.CANCEL_OPTION){
			frame.showMenu();
		}else{
			System.exit(0);
			
		}
	}
	
	public int getN() {
		return n;
	}
	
}
