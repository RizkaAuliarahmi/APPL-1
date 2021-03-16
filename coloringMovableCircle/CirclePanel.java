/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coloringMovableCircle;

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
import javax.swing.JColorChooser;
public class CirclePanel extends JPanel
{
private final int CIRCLE_SIZE = 50;
private int x,y;
private Color c;
//---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------
public CirclePanel(int width, int height)
{
// Set coordinates so circle starts in middle
x = (width/2)-(CIRCLE_SIZE/2);
y = (height/2)-(CIRCLE_SIZE/2);
c = Color.green;// Need a border layout to get the buttons on the bottom
this.setLayout(new BorderLayout());
// Create buttons to move the circle
JButton left = new JButton("Left");
JButton right = new JButton("Right");
JButton up = new JButton("Up");
JButton down = new JButton("Down");
JButton red = new JButton("Red");
JButton yellow = new JButton("Yellow");
JButton blue = new JButton("Blue");
JButton black = new JButton("Black");
JButton ChooseColor = new JButton("Choose Color");
// Add listeners to the buttons
left.addActionListener(new MoveListener(-20,0));
right.addActionListener(new MoveListener(20,0));
up.addActionListener(new MoveListener(0,-20));
down.addActionListener(new MoveListener(0,20));
red.addActionListener(new RedButtonListener());
yellow.addActionListener(new YellowButtonListener());
blue.addActionListener(new BlueButtonListener());
black.addActionListener(new BlackButtonListener());
ChooseColor.addActionListener(new ChooseColorListener());
// Need a panel to put the buttons on or they'll be on
//top of each other.
JPanel buttonPanel = new JPanel();
buttonPanel.add(left);
buttonPanel.add(right);
buttonPanel.add(up);
buttonPanel.add(down);
// Add the button panel to the bottom of the main panel
this.add(buttonPanel, "South");

JPanel buttonPane2 = new JPanel();
buttonPane2.add(red);
buttonPane2.add(yellow);
buttonPane2.add(ChooseColor);
buttonPane2.add(blue);
buttonPane2.add(black);
this.add(buttonPane2, "North");

red.setForeground(Color.red);
yellow.setForeground(Color.yellow);
blue.setForeground(Color.blue);
black.setForeground(Color.black);
}
//---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------
public void paintComponent(Graphics page)
{
super.paintComponent(page);
page.setColor(c);
page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
}
//---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------
private class MoveListener implements ActionListener {
private int dx;
private int dy;
//---------------------------------------------------------------
//Parameters tell how to move circle at click.
//---------------------------------------------------------------
public MoveListener(int dx, int dy)
{
this.dx = dx;
this.dy = dy;
}
//--------------------------------------------------------------- 
//Change x and y coordinates and repaint.
//---------------------------------------------------------------
public void actionPerformed(ActionEvent e)
{
x += dx;
y += dy;
repaint();
}
}

private class RedButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        c = Color.red;
        repaint();
    }
}

private class YellowButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        c = Color.yellow;
        repaint();
    }
}

private class BlueButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        c = Color.blue;
        repaint();
    }
}

private class BlackButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        c = Color.black;
        repaint();
    }
}

private class ChooseColorListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        Color initialcolor=Color.RED;    
        Color color = JColorChooser.showDialog(null,"Select a color",initialcolor);  
        c = Color.getColor("", color);
        repaint(); 
    }
}
}