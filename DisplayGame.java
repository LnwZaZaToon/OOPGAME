/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Toon
 */
public class DisplayGame extends JPanel {

    URL imgBgURL = getClass().getResource("Bg.png"); // Replace with your actual image path
    Image imgBg = new ImageIcon(imgBgURL).getImage();

    URL imgActorURLhero = getClass().getResource("Protect.png");
    URL imgActorURLdevil = getClass().getResource("Protect_skel.png");
    URL imgActorURLhero2 = getClass().getResource("idlewizard.png");
    Image imgActorHero1 = new ImageIcon(imgActorURLhero).getImage();
    Image imgActorHero2 = new ImageIcon(imgActorURLhero2).getImage();
    Image imgActorDevil = new ImageIcon(imgActorURLdevil).getImage();
    Image imgActor1;
    Image imgActor2;
    Games mainFrame;
    int x1 = 20;
    int y1 = 700;
    int x2 = x1;
    int y2 = y1;

    private boolean isJumping1 = false;
    private boolean isJumping2 = false;
    private int jumpHeight1 = 0;
    private int jumpHeight2 = 0;
    private final int JUMP_LIMIT = 150; // Limit for jump height
    private final int GRAVITY = 5; // Gravity effect

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(imgBg, 0, 0, getWidth(), getHeight(), this);
        // Draw player 1's image normally
        if (imgActor1 != null) {
            g2d.drawImage(imgActor1, x1, y1, 100, 100, this);
        }
        // Draw player 2's image mirrored
        if (imgActor2 != null) {
            AffineTransform transform = new AffineTransform();
            // Flip the image horizontally
            transform.translate(getWidth() - x2 - 50, y2);
            transform.scale(-1, 1); // Flip horizontally
            transform.translate(-50, 0); // Adjust for the flipped image's width

            g2d.drawImage(imgActor2, transform, this);
        }
    }

    public DisplayGame(Games mainFrame) {
        this.mainFrame = mainFrame;
        imgActor1 = CheckPlayer(mainFrame.player1);
        imgActor2 = CheckPlayer(mainFrame.player2);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    /*     case KeyEvent.VK_W:
                        if (!isJumping2) {
                            isJumping2 = true; // Start jumping
                        }
                        break;*/
                    case KeyEvent.VK_A:
                        x2 = x2 - 10;
                        break;
                    case KeyEvent.VK_D:
                        x2 = x2 + 10;
                        break;
              /*      case KeyEvent.VK_UP:
                        if (!isJumping1) {
                            isJumping1 = true; // Start jumping
                        }
                        break;*/
                    case KeyEvent.VK_LEFT:
                        x1 = x1 - 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x1 = x1 + 10;
                        break;
                    default:
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        mainFrame.revalidate();
    }

    public Image CheckPlayer(Player player) {
        if (player.getRole().equals("Knight")) {
            return imgActorHero1;
        } else if (player.getRole().equals("Wizard")) {
            return imgActorHero2;
        } else if (player.getRole().equals("King of Skelleton")) {
            return imgActorDevil;
        } else {
            return null;
        }
    }

}
