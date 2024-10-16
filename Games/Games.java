package games;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Games extends JFrame implements ActionListener {

    JButton jbtstart = new JButton("START");
    JPanel BG1 = new JPanel();
    DrawBG drawBG; // Keep a reference to the DrawBG panel
    ChoosePlayer1 choosePlayer1Panel; // Declare the ChoosePlayer1 panel
    ChoosePlayer2 choosePlayer2Panel;

    public Games() {
        // Load background image
        URL imgBgURL = getClass().getResource("Bg.png");
        if (imgBgURL == null) {
            System.err.println("Background image not found!");
            return;
        }

        Image imgBg = new ImageIcon(imgBgURL).getImage();
        drawBG = new DrawBG(imgBg); // Initialize the background panel
        drawBG.setLayout(new BorderLayout());
        BG1.setOpaque(false); // Make the BG1 panel transparent
        BG1.add(jbtstart, BorderLayout.CENTER); // Add START button to BG1
        drawBG.add(BG1, BorderLayout.CENTER); // Add BG1 to the DrawBG panel

        add(drawBG); // Add the DrawBG panel to the frame
        jbtstart.addActionListener(this); // Add action listener to START button
    }

    static class DrawBG extends JPanel {
        Image imgBg;

        public DrawBG(Image imgBg) {
            this.imgBg = imgBg;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgBg, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtstart) {
            switchToChoosePlayer1(); // Switch to the ChoosePlayer panel
        }
    }

    public void switchToChoosePlayer1() {
        if (choosePlayer2Panel != null) {
            drawBG.remove(choosePlayer2Panel);
        }
        drawBG.remove(BG1); // Remove the main menu panel
        choosePlayer1Panel = new ChoosePlayer1(this); // Create a new ChoosePlayer1 instance
        drawBG.add(choosePlayer1Panel, BorderLayout.CENTER); // Add ChoosePlayer1 panel
        drawBG.revalidate(); // Refresh the layout
        drawBG.repaint(); // Repaint to show the new panel
    }

    public void switchToChoosePlayer2() {
        // Remove the ChoosePlayer1 panel and add ChoosePlayer2 panel
        drawBG.remove(choosePlayer1Panel); // Remove ChoosePlayer1 panel
        choosePlayer2Panel = new ChoosePlayer2(this); // Create a new ChoosePlayer2 instance
        drawBG.add(choosePlayer2Panel, BorderLayout.CENTER); // Add ChoosePlayer2 panel
        drawBG.revalidate(); // Refresh the layout
        drawBG.repaint(); // Repaint to show the new panel
    }
    
    public void switchToMainMenu() {
        drawBG.remove(choosePlayer1Panel); // Remove the ChoosePlayer panel
        drawBG.add(BG1, BorderLayout.CENTER); // Add BG1 back
        drawBG.revalidate(); // Refresh the layout
        drawBG.repaint(); // Repaint to show the main menu
    }

    public static void main(String[] args) {
        Games f = new Games(); // Use Games instead of JFrame
        f.setTitle("Heroes of Empire");
        f.setSize(1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


/*


package games;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Games extends JFrame implements ActionListener {

    JButton jbtstart = new JButton("START");
    JPanel BG1 = new JPanel();
    DrawBG drawBG; // Keep a reference to the DrawBG panel
    ChoosePlayer choosePlayerPanel; // Declare the ChoosePlayer panel

    public Games() {
        // Load background image
        URL imgBgURL = getClass().getResource("Bg.png");
        if (imgBgURL == null) {
            System.err.println("Background image not found!");
            return;
        }

        Image imgBg = new ImageIcon(imgBgURL).getImage();
        drawBG = new DrawBG(imgBg); // Initialize the background panel
        drawBG.setLayout(new BorderLayout());
        BG1.setOpaque(false); // Make the BG1 panel transparent
        BG1.add(jbtstart, BorderLayout.CENTER); // Add START button to BG1
        drawBG.add(BG1, BorderLayout.CENTER); // Add BG1 to the DrawBG panel

        add(drawBG); // Add the DrawBG panel to the frame
        jbtstart.addActionListener(this); // Add action listener to START button
    }

    static class DrawBG extends JPanel {
        Image imgBg;

        public DrawBG(Image imgBg) {
            this.imgBg = imgBg;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgBg, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtstart) {
            switchToChoosePlayer1(); // Switch to the ChoosePlayer panel
        }
    }

    private void switchToChoosePlayer1() {
        // Remove the BG1 panel and add ChoosePlayer panel
        drawBG.remove(BG1); // Remove the main menu panel
        choosePlayerPanel = new ChoosePlayer(this); // Create a new ChoosePlayer instance
        drawBG.add(choosePlayerPanel, BorderLayout.CENTER); // Add ChoosePlayer panel
        drawBG.revalidate(); // Refresh the layout
        drawBG.repaint(); // Repaint to show the new panel
    }

    public void switchToMainMenu() {
        drawBG.remove(choosePlayerPanel); // Remove the ChoosePlayer panel
        drawBG.add(BG1, BorderLayout.CENTER); // Add BG1 back
        drawBG.revalidate(); // Refresh the layout
        drawBG.repaint(); // Repaint to show the main menu
    }

    public static void main(String[] args) {
        Games f = new Games(); // Use Games instead of JFrame
        f.setTitle("Heroes of Empire");
        f.setSize(1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
*/