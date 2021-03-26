/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadingFormAndWritingToTextFiles;

/**
 *
 * @author Dell
 */
// **************************************************************************** 
// Warning.java 
// 
// Reads student data from a text file and writes data to another text file. 
// **************************************************************************** 
import java.util.Scanner; 
import java.io.*; 
import java.io.FileOutputStream;  
public class Warning 
{ 
 // -------------------------------------------------------------------- 
 // Reads student data (name, semester hours, quality points) from a 
 // text file, computes the GPA, then writes data to another file 
 // if the student is placed on academic warning. 
 // -------------------------------------------------------------------- 
    
 public static void main (String[] args) 
 { 
 int creditHrs; // number of semester hours earned 
 double qualityPts; // number of quality points earned 
 double gpa; // grade point (quality point) average 
 String line, name, inputName = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\w2\\src\\ReadingFormAndWritingToTextFiles\\student.dat"; 
 String outputName = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\w2\\src\\ReadingFormAndWritingToTextFiles\\warning.dat"; 
 Scanner inFile;
 PrintWriter outFile;
try 
 { 
 // Set up scanner to input file 
 inFile = new Scanner(new FileReader (inputName));
 // Set up the output file stream 
 outFile = new PrintWriter(new FileWriter(outputName));
 // Print a header to the output file 
 outFile.println(); 
 outFile.println("Students on Academic Warning"); 
 outFile.println (); 
 // Process the input file, one token at a time 
 
 while (inFile.hasNextLine()) 
 { 
 // Get the credit hours and quality points and 
      name = inFile.next();
      creditHrs = inFile.nextInt();
      qualityPts = inFile.nextDouble();
     
     gpa = qualityPts/creditHrs;
 // determine if the student is on warning. If so, 
    if ((gpa < 1.5 && creditHrs < 30) || (gpa < 1.75 && creditHrs < 60) || (gpa < 2.0))
         outFile.println(name + " " + creditHrs + " " + gpa);   
 // write the student data to the output file. 
 } 
 // Close output file 
 outFile.close();
 } catch (FileNotFoundException exception) 
 { 
 System.out.println ("The file " + inputName + " was not found."); 
 } 
 catch (IOException exception) 
 { 
 System.out.println ("something else goes wrong with the input or output stream"); 
 } 
 catch (NumberFormatException e) 
 { 
 System.out.println ("Format error in input file: "); 
 } 
 } 
} 
