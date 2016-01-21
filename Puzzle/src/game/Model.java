package game;

import java.util.Random;

import game.Panel;

public class Model {
	private Panel panel;
	private int n;
	private int x;
	private int y;
	private int moveCount;
	private boolean isShuffling;
	private int difficulty;

	private static int[][] gameGrid;
	
	//constructor
	public Model(Panel panel){
		//setting conditions
		this.panel = panel;
		this.n = panel.getN();
		this.x = n-1;
		this.y = n-1;
		gameGrid = new int[n][n];
		
		//making/filling the game grid
		int temp = 1;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				gameGrid[i][j] = temp;
				temp++;
			}
		}
		gameGrid[n-1][n-1] = 0;

	}
	

	//checking if the game grid array is in the correct positions
	public boolean checkWinCondition(){
		int tempx=0;
		int tempy=0;
		for(int i = 1;i<n*n;i++){
			if(tempx==n-1){
				if(gameGrid[tempy][tempx]!= i){
					return false;
				}
				tempx=0;
				tempy++;
			}
			else{
				if(gameGrid[tempy][tempx]!= i){
					return false;
				}
				tempx++;
			}
		}
		return true;
	}

	//moving the numbers in the array randomly to shuffle
	public void shuffle(){
		isShuffling=true;
		Random random = new Random();
		for (int i = 0; i<n*n*100;i++){
			int c= random.nextInt(4)+37;
			movement(c);
		}
		panel.updatePanel();
		isShuffling = false;
	}
	
	//when making a move, this method updates the number array, by switching two positions.
	public void updateArray(int y, int x, int movey, int movex){
		int temp = gameGrid[y][x];
		gameGrid[y][x] = gameGrid[movey][movex];
		gameGrid[movey][movex] = temp;
		this.y=movey;
		this.x=movex;
		
		if(!isShuffling){	
			if(difficulty != 0)
				harderArray();
			else
				panel.updatePanel();
			moveCount++;
			}
	}

	//this decides which positions are to be switched given the case/move (up, down, left, right) 
	//and checking if the wincondition is true
	public void movement(int c){
		switch(c){
		// move up
	case 38:
		if (!(y>n-2)){
			updateArray(y, x, y+1, x);
			if(y==n-1 && x==n-1 && gameGrid[n-1][n-2]==n*n-1){
				if(!isShuffling && checkWinCondition())
					panel.youWon();
			}
			
		}
		break;
	
	case 40:
		//move down
		if (!(y<1)){
			updateArray(y, x, y-1, x);
		}
		break;
	case 37:
		//move left
		if (!(x>n-2)){
			updateArray(y, x, y, x+1);
			if(y==n-1 && x==n-1 && gameGrid[n-1][n-2]==(n*n-1)){
				if(!isShuffling && checkWinCondition())
					panel.youWon();
			}
		}

		break;
	case 39:
		//move right
		if (!(x<1)){
			updateArray(y, x, y, x-1);
		}
		break;
		}
			
	}	
	
	//making array, where a random number is set to n*n
	public void harderArray(){
		int diff = 0;
		if(difficulty == 1)
			diff = n/2;
		else
			diff = n-1;
		
		//making a temp array, that looks like our gamegrid to save the original numbers
		int[][] tempArray = new int[n][n];
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				tempArray[i][j]=gameGrid[i][j];
			}
		}
		
		//temp posistions
		int tempx;
		int tempy;
		
		//loop, where a random position in the gamegrid is set to n*n
		Random r = new Random();
		for(int i = 0 ; i< diff;i++){
			tempx = r.nextInt(n);
			tempy = r.nextInt(n);
			if(gameGrid[tempy][tempx]!=0 && gameGrid[tempy][tempx]!=n*n )
			{
				gameGrid[tempy][tempx]=n*n;
				
			}
			else{
				i--;
			}
		}
		panel.updatePanel();
		//changing the game grid back
		gameGrid = tempArray;
		
	}

	//getters and setters
	public int[][] getGameGrid(){
		return gameGrid;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getN() {
		return n;
	}
	
	public int getMoveCount(){
		return moveCount;
	}
	public void setDifficulty(int difficulty){
		this.difficulty=difficulty;
	}


}
