package game;

import java.awt.event.*;
import game.*;

public class Listener implements KeyListener{
	private Model model;
	private int n;
	private int x;
	private int y;
	private Panel panel;
	
	public Listener(Panel panel){
		this.panel = panel;
		this.x = panel.getX();
		this.y = panel.getY();
		this.n = panel.getN();
	}
	
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		switch(c){
		case KeyEvent.VK_UP:
			if (!(y>n-2)){
				panel.updateArray(y, x, y+1, x);
				//if(y==n-1 && x==n-1 && panel.PuzzleArray()[n-1][n-2].getText().equals(Integer.toString(n*n-1))){
					//if(model.checkWinCondition())
						//System.out.println("You won!");
				//}
			}
			break;
		
		case KeyEvent.VK_DOWN:
			if (!(y<1)){
				panel.updateArray(y, x, y-1, x);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (!(x>n-2)){
				panel.updateArray(y, x, y, x+1);
				if(y==n-1 && x==n-1 && panel.PuzzleArray()[n-1][n-2].getText().equals(Integer.toString(n*n-1))){
					if(model.checkWinCondition())
						System.out.println("You won!");
				}
			}
	
			break;
		case KeyEvent.VK_RIGHT:
			if (!(x<1)){
				panel.updateArray(y, x, y, x-1);
			}
			break;
		}	
		this.x = panel.getX();
		this.y = panel.getY();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
