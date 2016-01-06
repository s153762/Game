package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

import game.Panel;

public class Frame extends JFrame implements KeyListener{

	private int n = 5;
	private int x;
	private int y;
	private Panel panel = new Panel(n);
	public Frame(String str){
		this.setSize(500, 500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(str);		
		x = n-1;
		y=x;
		this.addKeyListener(this);
		this.getContentPane().add(panel, "Center");
		shuffle();
	
	}
	//Listener hej = new Listener();
	
	public boolean checkWinCondition()
	{
		
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
			if (y>n-2)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y+1][x].getText());
				panel.PuzzleArray()[y+1][x].setText("");
				y++;
				
			}
			break;
		case 1:
		
			if (y<1)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y-1][x].getText());
				panel.PuzzleArray()[y-1][x].setText("");
				y--;
			}
			break;
		case 2:
			if (x>n-2)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y][x+1].getText());
				panel.PuzzleArray()[y][x+1].setText("");
				x++;
				
			}
	
			break;
		case 3:
			if (x<1)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y][x-1].getText());
				panel.PuzzleArray()[y][x-1].setText("");
				x--;
			}
			break;
		}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		
		
		int c = e.getKeyCode();
		switch(c){
		case KeyEvent.VK_UP:
			if (y>n-2)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y+1][x].getText());
				panel.PuzzleArray()[y+1][x].setText("");
				y++;
				if(y==n-1 && x==n-1){
					if(checkWinCondition())
						System.out.println("You won!");
				}
			}
			break;
		case KeyEvent.VK_DOWN:
		
			if (y<1)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y-1][x].getText());
				panel.PuzzleArray()[y-1][x].setText("");
				y--;

			}
			break;
		case KeyEvent.VK_LEFT:
			if (x>n-2)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y][x+1].getText());
				panel.PuzzleArray()[y][x+1].setText("");
				x++;
				if(y==n-1 && x==n-1){
					if(checkWinCondition())
						System.out.println("You won!");
				}
			}
	
			break;
		case KeyEvent.VK_RIGHT:
			if (x<1)
			{
				break;
			}
			
			else{
				panel.PuzzleArray()[y][x].setText(panel.PuzzleArray()[y][x-1].getText());
				panel.PuzzleArray()[y][x-1].setText("");
				x--;

			}
			break;
		}

		
		
	}
	

	public void showIt(){
		this.setVisible(true);
		
		
	}
	
	public void hideIt() { 
		this.setVisible(false);
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
