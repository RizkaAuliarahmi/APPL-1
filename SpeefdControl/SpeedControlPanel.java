/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeefdControl;

/**
 *
 * @author HP
 */
// ******************************************************************
// SpeedControlPanel.java
//
// The panel for the bouncing ball. Similar to
// ReboundPanel.java in Listing 8.16 in the text, except a circle
// rather than a happy face is rebounding off the edges of the //window.
// ******************************************************************
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JSlider;
public class SpeedControlPanel extends JPanel
{
private final int WIDTH = 600;
private final int HEIGHT = 400;
private final int BALL_SIZE = 50;
private Circle bouncingBall; // the object that moves
private Timer timer;
private int moveX, moveY;
private Object label;
private Object slider;
private JPanel contentPanel;
Dimension height;// increment to move each time
// ---------------------------------------------
// Sets up the panel, including the timer
// for the animation
// ---------------------------------------------
public SpeedControlPanel ()
{
timer = new Timer(30, new ReboundListener());
this.setLayout (new BorderLayout());
bouncingBall = new Circle(BALL_SIZE);
moveX = moveY = 5;
// Set up a slider object here
setPreferredSize (new Dimension (WIDTH, HEIGHT));
setBackground(Color.black);
timer.start();

JSlider slider = new JSlider(0,200,30);
slider.setMajorTickSpacing(40);
slider.setMinorTickSpacing(10); 
slider.setPaintTicks(true); 
slider.setPaintLabels(true); 
slider.setAlignmentX(LEFT_ALIGNMENT);
slider.addChangeListener(new SlideListener());

JLabel label = new JLabel();
label.setText("Timer Delay");
label.setAlignmentX(LEFT_ALIGNMENT);
    
contentPanel = new JPanel();
contentPanel.add(slider);
contentPanel.setLayout(new FlowLayout());
contentPanel.add(label);
this.add(contentPanel, "South");

   
 
    
    
}
// --------------------
// Draw the ball
// --------------------
public void paintComponent (Graphics page)
{
super.paintComponent (page);
bouncingBall.draw(page);
}
// ***************************************************
// An action listener for the timer
// ***************************************************
public class ReboundListener implements ActionListener {
// ----------------------------------------------------
// actionPerformed is called by the timer -- it updates 
//the position of the bouncing ball
// ----------------------------------------------------
public void actionPerformed(ActionEvent action) {
bouncingBall.move(moveX, moveY);
// change direction if ball hits a side 
int x = bouncingBall.getX();
int y = bouncingBall.getY();
try {
int slidePanelHt = contentPanel.getSize().height;
if (x < 0 || x >= WIDTH - BALL_SIZE) 
    moveX = moveX * -1;
if (y <= 0 || y >= HEIGHT - slidePanelHt - BALL_SIZE)
    moveY = moveY * -1;
} catch(NullPointerException e){
       System.out.println("");
    }   
repaint();}
}
// *****************************************************
// A change listener for the slider.
// *****************************************************
private class SlideListener implements ChangeListener {
// ------------------------------------------------- 
//Called when the state of the slider has changed; 
//resets the delay on the timer.
// -------------------------------------------------
public void stateChanged (ChangeEvent event) {
    JSlider source = (JSlider)event.getSource();
    try {
    if (!source.getValueIsAdjusting()) {
            timer.stop();
        int delay = 0;
        int newDelay = (int)source.getValue();
            timer.setDelay(newDelay);
            timer.start();
    } 
    }  catch(ArithmeticException e){
       System.out.println("");
    }   
    JLabel label = new JLabel();
    label.setText("Timer Delay"+source.getValue());
    }
    }
}