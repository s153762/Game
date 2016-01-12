package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import startMenu.ButtonListener;

public class InGamePanel extends JPanel{
//	private Frame frame;
//	private Model model;
	private JLabel timer;
	private JButton pause;
	private float count;
	private Timer time;
	private boolean paused;
	
	
	public InGamePanel(Frame frame){
		
		this.setLayout(new BorderLayout());
		ButtonListener buttonList = new ButtonListener(frame, this);
		
		
		this.pause = new JButton("Pause");
		this.add(pause, "West");
		pause.addActionListener(buttonList);
		
		Listener list = new Listener(this);
		time = new Timer(1000/100, list);
		timer = new JLabel("Time: ");
		timer.setHorizontalAlignment(JLabel.CENTER);
		this.add(timer, "Center");
		
		
		JButton backButton = new JButton("Back to menu");
		this.add(backButton, "East");
		backButton.addActionListener(buttonList);
		
		time.start();
		paused = false;
	}
	
	public void pause(){
		if (paused)
		{
			time.start();
			pause.setText("Pause");
		}
		else{
			time.stop();
			
			pause.setText("Resume");
		}
		paused = !paused;
	}
	
	public void updatePanel()
	{
		count += 0.01;
	
		BigDecimal bd = new BigDecimal(count);
		bd = bd.setScale(2,  RoundingMode.HALF_UP);
		count=bd.floatValue();			
			
		timer.setText("Time: "+count);
	}
	
	public float getTime(){
		return count;
	}
}

