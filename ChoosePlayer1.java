package games;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoosePlayer1 extends JPanel implements ActionListener  {
    JButton jbtChooseP1Hero = new JButton("HEROS");
    JButton jbtChooseP1Devil = new JButton("DEVILS");
    JButton backButton = new JButton("Back to Start");
    JButton NextButton = new JButton("Next");
    Games mainFrame; // Reference to the main Games instance
    JLabel ShowMessage = new JLabel();
    

    public ChoosePlayer1(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference
        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        
        
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();
        
        
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
        
        BgChoose.setOpaque(false); // Make this panel transparent
        Bg2.setOpaque(false); // Make this panel transparent
        setOpaque(false); // Make the main panel transparent
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToMainMenu(); // Call the method to switch back
        }
        else if (e.getSource() == NextButton) {
            mainFrame.switchToChoosePlayer2();
        }
        else if (e.getSource() == jbtChooseP1Hero) {
            Player player1 = new Player("Hero");
            mainFrame.setPlayer1(player1); // Set Player 2 as Hero
            ShowMessage.setText(player1.getName());
            
        } else if (e.getSource() == jbtChooseP1Devil) {
            Player player1 = new Player("Devil");
            mainFrame.setPlayer1(player1); // Set Player 2 as Devil
            ShowMessage.setText(player1.getName());
            
            
        }       
    }
}
