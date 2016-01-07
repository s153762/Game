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
	}
	
public boolean checkWinCondition(){
		int tempx=0;
		int tempy=0;
		System.out.println(Integer.parseInt(panel.PuzzleArray()[tempy][tempx].getText()));
		for(int i = 1;i<n*n;i++)
		{
			if(tempx==n-1)
			{
				if(Integer.parseInt(panel.PuzzleArray()[tempy][tempx].getText())!= i)
				{
					return false;
				}
				tempx=0;
				tempy++;
			}
			else{
				if(Integer.parseInt(panel.PuzzleArray()[tempy][tempx].getText())!= i)
				{
					return false;
				}
				tempx++;
			}
		}
			
		return true;
	}

public void shuffle(){
	for (int i = 0; i<n*100;i++){
	int c;
	Random random = new Random();
	c= random.nextInt(4);
	
	switch(c){
	case 0:
		if (!(y>n-2)){
			panel.updateArray(y, x, y+1, x);
			y++;
		}
		break;
	case 1:
		if (!(y<1)){
			panel.updateArray(y, x, y-1, x);
			y--;
		}
		break;
	case 2:
		if (!(x>n-2)){
			panel.updateArray(y, x, y, x+1);
			x++;	
		}
		break;
	case 3:
		if (!(x<1)){
			panel.updateArray(y, x, y, x-1);
			x--;
		}
		break;
	}
	}
}

}
