/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import static javax.swing.JOptionPane.showMessageDialog;

public class ChooseJobPage2 extends JPanel implements ActionListener {

    Games mainFrame;
    JButton jbtChooseRoleHero1 = new JButton();
    JButton jbtChooseRoleHero2 = new JButton();
    JButton jbtChooseRoleDevil = new JButton();
    JButton backButton = new JButton("Back to Start");
    JButton NextButton = new JButton("Select");
    JLabel ShowMessage = new JLabel();
    URL imgBgURLhero = getClass().getResource("Protect.png");
    URL imgBgURLdevil = getClass().getResource("Protect_skel.png");
    URL imgBgURLhero2 = getClass().getResource("idlewizard.png");
    String RoleType;

    public ChooseJobPage2(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference

        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons
        JPanel BgChoose = new JPanel();

        ShowMessage.setText("Player 2 Choose a Role of " + mainFrame.player2.getName()); // Initial message       
        BgChoose.add(ShowMessage);

        if (mainFrame.player2.getName().equals("Hero")) {
            if (imgBgURLhero != null) {
                ImageIcon heroIcon = new ImageIcon(imgBgURLhero);
                jbtChooseRoleHero1.setIcon(heroIcon);

            }
            if (imgBgURLhero2 != null) {
                ImageIcon hero2Icon = new ImageIcon(imgBgURLhero2);
                jbtChooseRoleHero2.setIcon(hero2Icon);
            }
            BgChoose.add(jbtChooseRoleHero1);
            BgChoose.add(jbtChooseRoleHero2);
        } else if (mainFrame.player2.getName().equals("Devil")) {
            if (imgBgURLdevil != null) {
                ImageIcon devilIcon = new ImageIcon(imgBgURLdevil);
                jbtChooseRoleDevil.setIcon(devilIcon);
            }
            BgChoose.add(jbtChooseRoleDevil);
        }

        //    BgChoose.add(jbtChooseP2Hero);
        //   BgChoose.add(jbtChooseP2Devil);
        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        add(BgChoose, BorderLayout.CENTER);
        add(Bg2, BorderLayout.SOUTH);
        jbtChooseRoleHero1.addActionListener(this);
        jbtChooseRoleHero2.addActionListener(this);
        jbtChooseRoleDevil.addActionListener(this);
        backButton.addActionListener(this);
        NextButton.addActionListener(this);

        BgChoose.setOpaque(false); // Make this panel transparent
        Bg2.setOpaque(false); // Make this panel transparent
        setOpaque(false); // Make the main panel transparent
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToChoosePlayer2();
        } else if (e.getSource() == jbtChooseRoleHero1) {
            RoleType = "Knight";

        } else if (e.getSource() == jbtChooseRoleHero2) {
            RoleType = "Wizard";
        }else if (e.getSource() == jbtChooseRoleDevil) {
            RoleType = "King of Skelleton";
        } else if (e.getSource() == NextButton) {
            mainFrame.player2.setRole(RoleType);
            System.out.println(mainFrame.player2.getRole());
            mainFrame.switchToChoosePlayGame();
        }
    }

}



class StartGame extends JPanel implements ActionListener {

    Games mainFrame;
    JButton backButton = new JButton("Back");
    JButton NextButton = new JButton("Play");

    String RoleType;

    public StartGame(Games mainFrame) {
        this.mainFrame = mainFrame; // Initialize the main frame reference

        setLayout(new BorderLayout()); // Set layout manager to BorderLayout
        JPanel Bg2 = new JPanel(); // Create a panel for buttons


        Bg2.add(backButton); // Add the back button
        Bg2.add(NextButton);
        
        add(Bg2, BorderLayout.SOUTH);

        backButton.addActionListener(this);
        NextButton.addActionListener(this);

        
        Bg2.setOpaque(false); // Make this panel transparent
        setOpaque(false); // Make the main panel transparent
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            mainFrame.switchToChooseJobPage2();
        } 
    }
}
