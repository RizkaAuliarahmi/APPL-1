/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnhancingAMovableCircle;

/**
 *
 * @author HP
 */
// ****************************************************************** 
// CirclePanel.java 
// 
// A panel with a circle drawn in the center and buttons on the 
// bottom that move the circle. 
// ****************************************************************** 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.event.KeyEvent;
import java.awt.Point;
//import java.time.Clock.System(ZoneId);
public class CirclePanel extends JPanel 
{ 
 private final int CIRCLE_SIZE = 50; 
 private int x,y; 
 private Color c; 
 private JButton left;
 private JButton right;
 private JButton up;
 private JButton down;
 //--------------------------------------------------------------- 
 // Set up circle and buttons to move it. 
 //--------------------------------------------------------------- 
 public CirclePanel(int width, int height) { 
 // Set coordinates so circle starts in middle 
 x = (width/2)-(CIRCLE_SIZE/2); 
 y = (height/2)-(CIRCLE_SIZE/2); 
 c = Color.green; 
 // Need a border layout to get the buttons on the bottom 
 this.setLayout(new BorderLayout()); 
 // Create buttons to move the circle 
 left = new JButton("Left"); 
 right = new JButton("Right"); 
 up = new JButton("Up"); 
 down = new JButton("Down"); 
 //setMnemonic button
 left.setMnemonic(KeyEvent.VK_ALT);
 left.setMnemonic(KeyEvent.VK_L);
 right.setMnemonic(KeyEvent.VK_ALT);
 right.setMnemonic(KeyEvent.VK_R);
 up.setMnemonic(KeyEvent.VK_ALT);
 up.setMnemonic(KeyEvent.VK_U);
 down.setMnemonic(KeyEvent.VK_ALT);
 down.setMnemonic(KeyEvent.VK_D);
 //tooltip text 
 left.setToolTipText("ke kanan sebanyak 20 langkah");
 right.setToolTipText("ke kiri sebanyak 20 langkah");
 up.setToolTipText("ke atas sebanyak 20 langkah");
 down.setToolTipText("ke bawah sebanyak 20 langkah");
 // Add listeners to the buttons 
 left.addActionListener(new MoveListener(-20,0)); 
 right.addActionListener(new MoveListener(20,0)); 
 up.addActionListener(new MoveListener(0,-20)); 
 down.addActionListener(new MoveListener(0,20)); 
 // Need a panel to put the buttons on or they'll be on 
 //JLabel label = new JLabel();
 System.out.println(left.getLocation());
 // top of each other. 
 JPanel buttonPanel = new JPanel(); 
 buttonPanel.add(left); 
 buttonPanel.add(right); 
 buttonPanel.add(up); 
 buttonPanel.add(down); 
 // Add the button panel to the bottom of the main panel 
 this.add(buttonPanel, "South"); 
 
 } 
 //--------------------------------------------------------------- 
 // Draw circle on CirclePanel 
 //--------------------------------------------------------------- 
 public void paintComponent(Graphics page) 
 { super.paintComponent(page); 
 page.setColor(c); 
 page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE); 
 } 
 //--------------------------------------------------------------- 
 // Class to listen for button clicks that move circle. 
 //--------------------------------------------------------------- 
 private class MoveListener implements ActionListener 
 { 
 private int dx; 
 private int dy; 
 
 //--------------------------------------------------------------- 
 // Parameters tell how to move circle at click. 
 //--------------------------------------------------------------- 
 public MoveListener(int dx, int dy) 
 { 
 this.dx = dx; 
 this.dy = dy; 
 } 
 //--------------------------------------------------------------- 
 // Change x and y coordinates and repaint. 
 //--------------------------------------------------------------- 
 public void actionPerformed(ActionEvent e) 
 { 
 x += dx; 
 y += dy; 
 repaint(); 
 
 if (x > 305) right.setEnabled(false); else right.setEnabled(true);
 if (x < 25) left.setEnabled(false); else left.setEnabled(true);
 if (y > 160) down.setEnabled(false); else down.setEnabled(true);
 if (y < 25) up.setEnabled(false); else up.setEnabled(true);
 }
 } 
} 
