package game;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import javax.swing.JLabel;

import game.Panel;

public class Model {
	private Panel panel;
	private int n;
	private int x;
	private int y;
	private int moveCount;
	private boolean isShuffling;

	private static int[][] gameGrid;
	
	public Model(Panel view){
		this.panel = view;
		this.n = panel.getN();
		this.x = n-1;
		this.y = this.x;
		gameGrid = new int[n][n];
		
		int temp = 1;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				gameGrid[i][j] = temp;
				
				temp++;
			}
		}
		gameGrid[n-1][n-1] = 0;

	}
	
	public void startShuffle(){
		int temp = 1;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<n;j++){
				gameGrid[i][j] = temp;
				
				temp++;
			}
		}
		gameGrid[n-1][n-1] = 0;
		gameGrid[0][0] = 2;
		gameGrid[0][1] = 3;
		gameGrid[0][2] = 1;
		panel.updatePanel();
	}
	
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
	
	public void updateArray(int y, int x, int movey, int movex){
		int temp = gameGrid[y][x];
		gameGrid[y][x] = gameGrid[movey][movex];
		gameGrid[movey][movex] = temp;
		this.y=movey;
		this.x=movex;
		if(!isShuffling)
			moveCount++;
	}

	public void movement(int c){
		
		switch(c){
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
		if (!(y<1)){
			updateArray(y, x, y-1, x);
		}
		break;
	case 37:
		if (!(x>n-2)){
			updateArray(y, x, y, x+1);
			if(y==n-1 && x==n-1 && gameGrid[n-1][n-2]==(n*n-1)){
				if(!isShuffling && checkWinCondition())
					panel.youWon();
			}
		}

		break;
	case 39:
		if (!(x<1)){
			updateArray(y, x, y, x-1);
		}
		break;
		}
		
		panel.updatePanel();
	}	
	

	public int[][] PuzzleArray(){
		
		return gameGrid;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getMoveCount(){
		return moveCount;
	}
	
	//public void setX(int x) {
		//this.x = x;
	//}
	
//	public void setY(int y) {
//		this.y = y;
//	}

}
