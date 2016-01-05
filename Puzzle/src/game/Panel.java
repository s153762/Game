package game;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Model;

public class Panel extends JPanel{
private Model model;
	
	public Panel(){
		model = new Model(this);
		GridLayout gLay = new GridLayout(1,1);
		this.setLayout(gLay);
		
		
		JLabel number1 = new JLabel("1");
		number1.setHorizontalAlignment(JLabel.CENTER);
		JLabel number2 = new JLabel("2");
		number2.setHorizontalAlignment(JLabel.CENTER);
		JLabel number3 = new JLabel("3");
		number3.setHorizontalAlignment(JLabel.CENTER);
		JLabel number4 = new JLabel("4");
		number4.setHorizontalAlignment(JLabel.CENTER);
		JLabel number5 = new JLabel("5");
		number5.setHorizontalAlignment(JLabel.CENTER);
		JLabel number6 = new JLabel("6");
		number6.setHorizontalAlignment(JLabel.CENTER);
		JLabel number7 = new JLabel("7");
		number7.setHorizontalAlignment(JLabel.CENTER);
		JLabel number8 = new JLabel("8");
		number8.setHorizontalAlignment(JLabel.CENTER);
		JLabel number0 = new JLabel(" ");
		JLabel number10 = new JLabel("32");
		
		this.add(number1, "Ceter");
		this.add(number2, "EAST");
		this.add(number3, "Center");
		this.add(number4, "Center");
		this.add(number5, "Center");
		this.add(number6, "Center");
		this.add(number7, "Center");
		this.add(number8, "Center");
		this.add(number0, "Center");
		this.add(number10, "Center");
	}
	
}
