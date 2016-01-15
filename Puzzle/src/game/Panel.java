package game;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
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
	Color color; 
	int hardMode;
	
	
	public Panel(int n, InGamePanel inGamePanel, Frame frame){
		this.hardMode = frame.getHardMode();
		this.x = n-1;
		this.y = n-1;
		this.n = n;
		this.model = new Model(this);
		this.puzzleArray = new JLabel[n][n];
		this.firstTime = true;
		this.setBackground(Color.white);
		this.inGamePanel = inGamePanel;
		this.frame = frame;
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		list = new Listener(this,this.model);
		this.addKeyListener(list);
//		Timer timer = new Timer(1000/100, list);
		GridLayout gLay = new GridLayout(n,n,10-(n/5),10-(n/5));
		this.setLayout(gLay);
//		timer.start();
		
		color();
		model.shuffle();
		model.setHardMode(hardMode);
		//model.startShuffle();
		
		
	}
	
	
	public void color(){
		switch(hardMode){
		case 0:
			color = new Color(0,153,0);
			break;
		case 1: 
			color = new Color(0,204,204);
			break;
		case 2: 
			color = new Color(204,0,0);
			break;
		}
		
		
		
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
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);
					} else{
						puzzleArray[i][j] = new JLabel("");
						//puzzleArray[i][j].setBackground(Color.black);
						//puzzleArray[i][j].setOpaque(true);
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));
						//puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));		
					}
				} else{
					if(model.PuzzleArray()[i][j] == 0){
						puzzleArray[i][j].setText("");
						puzzleArray[i][j].setOpaque(false);
						puzzleArray[i][j].setBackground(color);
						puzzleArray[i][j].setBorder(null);
					
						
						
					} else if(model.PuzzleArray()[i][j] == n*n){
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);					
						puzzleArray[i][j].setText("");	
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
					}
					else{
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);
						puzzleArray[i][j].setText(""+model.PuzzleArray()[i][j]);
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
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
	
	
	public void youWon(){
		updatePanel();
		System.out.println("You won!");
		inGamePanel.stopTimerWin();
		

		Highscores highscoreOver10 = new Highscores("HighscoresOver10.dat");
		Highscores highscoreOver5 = new Highscores("HighscoresOver5.dat");
		Highscores highscore = new Highscores("Highscores.dat");
		
		if(n>=5){
			if(highscoreOver10.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10 in over 5! What is your name?");
				highscoreOver10.addNewHighscore(name, inGamePanel.getTime());
				for(int i = 0; i<highscoreOver10.getHighscores().size();i++){
					System.out.println(highscoreOver10.getHighscores().get(i));
				}
			}
		} else if (n==4){
			if(highscoreOver5.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10 in over 4! What is your name?");
				highscoreOver5.addNewHighscore(name, inGamePanel.getTime());
				for(int i = 0; i<highscoreOver5.getHighscores().size();i++){
					System.out.println(highscoreOver5.getHighscores().get(i));
				}
			}
		} else{
			if(highscore.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10! What is your name?");
				highscore.addNewHighscore(name, inGamePanel.getTime());
				for(int i = 0; i<highscore.getHighscores().size();i++){
					System.out.println(highscore.getHighscores().get(i));
				}
			}
		}
		
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
