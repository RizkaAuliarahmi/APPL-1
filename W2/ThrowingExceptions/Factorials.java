/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThrowingExceptions;

/**
 *
 * @author HP
 */
// **************************************************************** 
// Factorials.java 
// 
// Reads integers from the user and prints the factorial of each. 
// 
// **************************************************************** 
import java.util.Scanner; 
public class Factorials 
{ 
 public static void main(String[] args) throws IllegalArgumentException
 { 
 String keepGoing = "y"; 
 Scanner scan = new Scanner(System.in); 
 while (keepGoing.equals("y") || keepGoing.equals("Y")) 
 { 
 System.out.print("Enter an integer: "); 
 int val = scan.nextInt(); 
try {
  if (val < 0){
      throw new IllegalArgumentException("value tidak boleh negatif");
  } else if (val > 16){
      throw new IllegalArgumentException("value tidak boleh lebih dari 16");
  }
System.out.println("Factorial(" + val + ") = "+ MathUtils.factorial(val));
}
catch(IllegalArgumentException e){
  if (val < 0){
     System.out.println("value tidak boleh negatif");
  } else if (val > 16){
      System.out.println("value tidak boleh lebih dari 16");
  }
}
 System.out.print("Another factorial? (y/n) "); 
 keepGoing = scan.next(); 
 } 
 } 
} 
