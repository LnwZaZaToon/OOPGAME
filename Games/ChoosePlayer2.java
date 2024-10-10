package games;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChoosePlayer2 extends JPanel implements ActionListener {
    JButton jbtChooseP2Hero = new JButton("Choose Hero for Player 2");
    JButton jbtChooseP2Devil = new JButton("Choose Devil for Player 2");
    JButton backButton = new JButton("Back to Player 1 Selection");
    JButton NextButton = new JButton("Next");
    Games mainFrame; // Reference to the main Games instance

    public ChoosePlayer2(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference
        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();
        BgChoose.add(jbtChooseP2Hero);
        BgChoose.add(jbtChooseP2Devil);
        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        add(BgChoose,BorderLayout.CENTER);
        add(Bg2,BorderLayout.SOUTH);
        backButton.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToChoosePlayer1();
            
        } else if (e.getSource() == jbtChooseP2Hero) {
            System.out.println("Hero selected for Player 2.");
        }
    }
}