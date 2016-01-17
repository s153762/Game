package startMenu;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import game.Frame;

public class SettingsPanel extends JPanel implements ChangeListener, ActionListener {
	private Frame frame;
	private int n = 4;
	
	public SettingsPanel(Frame frame, int n){
		this.n = n;
		this.frame = frame;
		this.setBackground(Color.lightGray);
		
		//Setting layout
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipady = 30;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		//making the difficulty Label
		JLabel diff = new JLabel("Difficulty:");
		diff.setFont(diff.getFont().deriveFont(20f));
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(diff, gbc);
		
		//making the difficulty dropdown menu
		String[] difficultyStrings = { "Easy", "Medium", "Hard" };
		JComboBox<String> difficultyList = new JComboBox<String>(difficultyStrings);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(difficultyList, gbc);
	    
		//making the grid size label
		JLabel grid = new JLabel("Set size of grid:                ");
		grid.setFont(grid.getFont().deriveFont(20f));
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(grid, gbc);
		
		//making the grid size slider
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 3, 20, n);
	    slider.setPaintLabels(true);
	    slider.setPaintTicks(true);  
	    slider.setMinorTickSpacing(1);
	    slider.setMajorTickSpacing(1);
		difficultyList.setSelectedIndex(frame.getDifficulty());
		
	    // We'll just use the standard numeric labels
	    slider.setLabelTable(slider.createStandardLabels(1,3));
	    slider.addChangeListener(this);
	    difficultyList.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(slider, gbc);
	    slider.setOpaque(false);
		
	    //making the back to menu button
	    ButtonListener buttonList = new ButtonListener(frame);
		JButton backButton = new JButton("Back to menu");
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.PAGE_END;
		add(backButton, gbc);
		backButton.addActionListener(buttonList);
	}

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        
        if (!source.getValueIsAdjusting()) {
            int n = (int) source.getValue();
            frame.setN(n);
        }
    }

	public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String difficulty = (String)cb.getSelectedItem();
        switch(difficulty){
        case "Easy":
        	frame.setDifficulty(0);
        	break;
        case "Medium":
        	frame.setDifficulty(1);
        	break;
        case "Hard":
        	frame.setDifficulty(2);
        	break;
        	
        }
	}
 

}
