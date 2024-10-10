/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseJobPage extends JPanel implements ActionListener{
    Games mainFrame;
    JButton jbtChooseP1Hero = new JButton("HEROS");
    JButton jbtChooseP1Devil = new JButton("DEVILS");
    JButton backButton = new JButton("Back to Start");
    JButton NextButton = new JButton("Next");
    JLabel ShowMessage = new JLabel();
    
    
    
    class DrawChracter extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponents(g);
        }
    }
    
    
    
    
    
    
    

    public ChooseJobPage(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference
        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();
        if(mainFrame.player1.getName()=="Heroes"){
            
        }
        
        ShowMessage.setText("Choose a character"); // Initial message       
        BgChoose.add(ShowMessage);
        
        BgChoose.add(jbtChooseP1Hero);
        BgChoose.add(jbtChooseP1Devil);
        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        add(BgChoose,BorderLayout.CENTER);
        add(Bg2,BorderLayout.SOUTH);
        backButton.addActionListener(this);
        NextButton.addActionListener(this);
        jbtChooseP1Hero.addActionListener(this); 
        jbtChooseP1Devil.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

}
