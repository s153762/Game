package game;


import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import startMenu.ButtonListener;

public class InGamePanel extends JPanel{
	private Frame frame;
	private JLabel timer, moveCounter;
	private JButton pause;
	private float count;
	private Timer time;
	private boolean paused;
	
	
	public InGamePanel(Frame frame){
		this.frame=frame;
		
		//setting layout and Listener
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 90,0));
		ButtonListener buttonList = new ButtonListener(frame, this);
		
		//adding pause button
		pause = new JButton("Pause");
		add(pause, "West");
		pause.addActionListener(buttonList);
		
		//adding moveCounter label
		moveCounter = new JLabel("Moves: ");
		moveCounter.setHorizontalAlignment(JLabel.CENTER);
		add(moveCounter, "Center");
		
		//adding timer.
		Listener list = new Listener(this);
		time = new Timer(1000/100, list);
		timer = new JLabel("Time: ");
		add(timer, "Center");
		
		//adding back to menu button
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, "East");
		backButton.addActionListener(buttonList);
		
		paused = false;
	}
	
	//starting the timer
	public void startGame(){
		time.start();
		count = 0;
	}
	
	//stopping timer
	public void stopTimerWin(){
		time.stop();
	}
	
	//method for pause button
	public void pause(){
		if (paused) {
			time.start();
			pause.setText("Pause");
		} else {
			time.stop();
			pause.setText("Resume");
		}
		frame.getPanel().requestFocus();
		paused = !paused;
	}
	
	//updating the time-label text and counting the moves
	public void updatePanel(){
		count += 0.01;
	
		BigDecimal bd = new BigDecimal(count);
		bd = bd.setScale(2,  RoundingMode.HALF_UP);
		count=bd.floatValue();			
			
		timer.setText("Time: "+count);
	}
	//updating the move-label text
	public void updateMoveCount(int n) {
		moveCounter.setText("Moves: "+ n);
	}
	
	
	//getters
	public boolean getPaused(){
		return paused;
	}
	
	public float getTime(){
		return count;
	}
}

