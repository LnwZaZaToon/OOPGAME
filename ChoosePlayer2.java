package games;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class ChoosePlayer2 extends JPanel implements ActionListener {

    JButton jbtChooseP2Hero = new JButton("Choose Hero for Player 2");
    JButton jbtChooseP2Devil = new JButton("Choose Devil for Player 2");
    JButton backButton = new JButton("Back to Player 1 Selection");
    JButton NextButton = new JButton("Next");
    Games mainFrame; // Reference to the main Games instance
    JLabel ShowMessage = new JLabel();

    public ChoosePlayer2(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference
        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();

        ShowMessage.setText("Choose a character"); // Initial message       
        BgChoose.add(ShowMessage);

        BgChoose.add(jbtChooseP2Hero);
        BgChoose.add(jbtChooseP2Devil);
        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        add(BgChoose, BorderLayout.CENTER);
        add(Bg2, BorderLayout.SOUTH);
        backButton.addActionListener(this);
        NextButton.addActionListener(this);
        jbtChooseP2Hero.addActionListener(this);
        jbtChooseP2Devil.addActionListener(this);
        
        BgChoose.setOpaque(false); // Make this panel transparent
        Bg2.setOpaque(false); // Make this panel transparent
        setOpaque(false); // Make the main panel transparent
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToChoosePlayer1();
        } else if (e.getSource() == NextButton) {
            if(mainFrame.player1 != null && mainFrame.player2!=null)
                mainFrame.switchToChooseJobPage();
            else
                showMessageDialog(null, "you still yet to choose player");
        } else if (e.getSource() == jbtChooseP2Hero) {
            Player player2 = new Player("Hero");
            mainFrame.setPlayer2(player2); // Set Player 2 as Hero
            ShowMessage.setText(player2.getName());
        } else if (e.getSource() == jbtChooseP2Devil) {
            Player player2 = new Player("Devil");
            mainFrame.setPlayer2(player2); // Set Player 2 as Devil
            ShowMessage.setText(player2.getName());
            
        }
    }
}
