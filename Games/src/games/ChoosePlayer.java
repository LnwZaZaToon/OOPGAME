package games;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoosePlayer extends JPanel implements ActionListener  {
    JButton jbtChooseP1Hero = new JButton("HEROS");
    JButton jbtChooseP1Devil = new JButton("DEVILS");
    JButton backButton = new JButton("Back to Start");
    JButton NextButton = new JButton("Next");
    Games mainFrame; // Reference to the main Games instance
    

    public ChoosePlayer(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference
        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();
        BgChoose.add(jbtChooseP1Hero);
        BgChoose.add(jbtChooseP1Devil);
        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        add(BgChoose,BorderLayout.CENTER);
        add(Bg2,BorderLayout.SOUTH);
        backButton.addActionListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToMainMenu(); // Call the method to switch back
        }
    }
}
