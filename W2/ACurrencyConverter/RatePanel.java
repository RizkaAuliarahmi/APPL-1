/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACurrencyConverter;

/**
 *
 * @author HP
 */
// ****************************************************************** 
// RatePanel.java 
// 
// Panel for a program that converts different currencies to 
// U.S. Dollars 
// ****************************************************************** 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class RatePanel extends JPanel 
{ 
 private double[] rate; // exchange rates 
 private String[] currencyName; 
 private JLabel result; 
 private JComboBox box;
 JTextField text;
 // ------------------------------------------------------------ 
 // Sets up a panel to convert cost from one of 6 currencies 
 // into U.S. Dollars. The panel contains a heading, a text 
 // field for the cost of the item, a combo box for selecting 
 // the currency, and a label to display the result. 
 // ------------------------------------------------------------ 
 public RatePanel () 
 { 
 JLabel title = new JLabel ("How much is that in dollars? "); 
 title.setAlignmentX (Component.CENTER_ALIGNMENT); 
 title.setFont (new Font ("Helvetica", Font.BOLD, 20)); 
 // Set up the arrays for the currency conversions 
 currencyName = new String[] {"Select the currency..", 
 "European Euro", "Canadian Dollar", 
 "Japanese Yen", "Australian Dollar", 
 "Indian Rupee", "Mexican Peso"}; 
 rate = new double [] {0.0, 1.2103, 0.7351, 
 0.0091, 0.6969, 
 0.0222, 0.0880}; 
 
 result = new JLabel (" ------------ "); 
 JPanel pane1 = new JPanel();
 pane1.add (title); 
 pane1.add (result); 
 add(pane1,"north");
 //combo box for currency
 JComboBox box = new JComboBox(currencyName);
 box.addActionListener(new ComboListener());
 
 
 text = new JTextField(10);
 text.addActionListener(new ComboListener());
 //cost user input
 JLabel cost = new JLabel();
 String c = cost.getText();
 System.out.println(c);
 JPanel pane2 = new JPanel();
 pane2.add(box);
 pane2.add(cost);
 pane2.add(text);
 add(pane2,"south");
 } 
 // ****************************************************** 
 // Represents an action listener for the combo box. 
 // ****************************************************** 
 private class ComboListener implements ActionListener 
 {  
 // -------------------------------------------------- 
 // Determines which currency has been selected and 
 // the value in that currency then computes and 
 // displays the value in U.S. Dollars. 
 // -------------------------------------------------- 
 public void actionPerformed (ActionEvent event) 
 { 
     JComboBox box = (JComboBox)event.getSource();
     double cst = Double.parseDouble(text.getText());
     int index = (int)box.getSelectedIndex(); 
     try{
    result.setText (cst + currencyName[index] +  " = " + 
         rate[index]*cst + " U.S. Dollars"); 
     }catch(ArrayIndexOutOfBoundsException e){
    System.out.println("whyyy");}
 } 
 } 
}

