package game;

import java.util.Random;

import game.Panel;

public class Model {
	private Panel panel;
	private int n;
	private int x;
	private int y;
	
	public Model(Panel view){
		this.panel = view;
		this.x = panel.getX();
		this.y = panel.getY();
		this.n= panel.getN();
	}
	
public boolean checkWinCondition(){
		int tempx=0;
		int tempy=0;
		for(int i = 1;i<n*n;i++){
			if(tempx==n-1){
				if(Integer.parseInt(panel.PuzzleArray()[tempy][tempx].getText())!= i){
					return false;
				}
				tempx=0;
				tempy++;
			}
			else{
				if(Integer.parseInt(panel.PuzzleArray()[tempy][tempx].getText())!= i){
					return false;
				}
				tempx++;
			}
		}
		return true;
	}

public void shuffle(){
	for (int i = 0; i<n*100;i++){
	Random random = new Random();
	int c= random.nextInt(4);
	switch(c){
	case 0:
		if (!(y>n-2)){
			panel.updateArray(y, x, y+1, x);
		}
		break;
	case 1:
		if (!(y<1)){
			panel.updateArray(y, x, y-1, x);
		}
		break;
	case 2:
		if (!(x>n-2)){
			panel.updateArray(y, x, y, x+1);
		}
		break;
	case 3:
		if (!(x<1)){
			panel.updateArray(y, x, y, x-1);
		}
		break;
	}
	this.x = panel.getX();
	this.y = panel.getY();
	}
}

}
