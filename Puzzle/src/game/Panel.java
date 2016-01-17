package game;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Panel extends JPanel {
	private Model model;
	private int n;
	private Frame frame;
	private boolean firstTime;
	private Listener list;
	private JLabel[][] puzzleArray;
	private InGamePanel inGamePanel;
	private Color color; 
	private int difficulty;
	private Highscores highscoreOver5, highscoreOn4, highscore;
	
	//contructor
	public Panel(int n, InGamePanel inGamePanel, Frame frame){
		this.n = n;
		this.inGamePanel = inGamePanel;
		this.frame = frame;
		
		//setting the conditions
		difficulty = frame.getDifficulty();
		model = new Model(this);
		model.setDifficulty(difficulty);
		puzzleArray = new JLabel[n][n];
		firstTime = true;
		list = new Listener(this,this.model);
		this.addKeyListener(list);
		
		
		//graphics
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		GridLayout gLay = new GridLayout(n,n,10-(n/5),10-(n/5));
		this.setLayout(gLay);
		colorOfLabels();
		
		//setting highscores
		highscoreOver5 = new Highscores("HighscoresOver10.dat");
		highscoreOn4 = new Highscores("HighscoresOver5.dat");
		highscore = new Highscores("Highscores.dat");
		
		//initializing game
		model.shuffle();
	}
	
	
	//deciding color of labels
	public void colorOfLabels(){
		switch(difficulty){
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
	
	//deciding font size on labels
	public Float FontSize(){
		double fontSize = Frame.size/(n*2);
		return (float) fontSize; 
	}
	
	//making and updating the labels
	public void updatePanel(){

		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				if(firstTime){
					
					if(model.getGameGrid()[i][j] != 0){
						
						puzzleArray[i][j] = new JLabel(""+model.getGameGrid()[i][j]);
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);
						
					} else{
						puzzleArray[i][j] = new JLabel("");
						this.add(puzzleArray[i][j]);
						puzzleArray[i][j].setHorizontalAlignment(JLabel.CENTER);
						puzzleArray[i][j].setFont (getFont ().deriveFont (FontSize()));	
						
					}
					
				} else{
					
					if(model.getGameGrid()[i][j] == 0){
						puzzleArray[i][j].setText("");
						puzzleArray[i][j].setOpaque(false);
						puzzleArray[i][j].setBackground(color);
						puzzleArray[i][j].setBorder(null);
						
					} else if(model.getGameGrid()[i][j] == n*n){
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);					
						puzzleArray[i][j].setText("");	
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
					}
					else{
						puzzleArray[i][j].setOpaque(true);
						puzzleArray[i][j].setBackground(color);
						puzzleArray[i][j].setText(""+model.getGameGrid()[i][j]);
						puzzleArray[i][j].setBorder(new LineBorder(Color.BLACK));
					}
				} 
			}	
			
		}
		firstTime = false;
		inGamePanel.updateMoveCount(model.getMoveCount());
		}
		
	
	//method run if you won the game
	public void youWon(){
		System.out.println("You won!");
		
		//stopping the timer
		inGamePanel.stopTimerWin();
		
		//updating the highscores and checking the highscore.
		if(n>=5){
			if(highscoreOver5.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10 in over 5! What is your name?",JOptionPane.OK_OPTION);
				highscoreOver5.addNewHighscore(name, inGamePanel.getTime());
			}
		} else if (n==4){
			if(highscoreOn4.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10 in over 4! What is your name?", JOptionPane.OK_OPTION);
				highscoreOn4.addNewHighscore(name, inGamePanel.getTime());
			}
		} else{
			if(highscore.isNewHighscore(inGamePanel.getTime())){
				String name = JOptionPane.showInputDialog("You set a new score on the top 10! What is your name?", JOptionPane.OK_OPTION);
				highscore.addNewHighscore(name, inGamePanel.getTime());
			}
		}
		
		//ending the game
		int choice = JOptionPane.showConfirmDialog(null,"You won the game! Do you want to play again?","You won!", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION){
			//hvad skal der ske hvis man vil spille igen
			frame.showMenu();
			frame.showGame();
		} else{
			frame.showMenu();
			
		}
	}
	
	//setters and getters
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	public InGamePanel getInGamePanel(){
		return inGamePanel;
	}

	public int getN() {
		return n;
	}
	
}
