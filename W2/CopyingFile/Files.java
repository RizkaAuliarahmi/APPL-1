/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CopyingFile;

/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.Scanner;
public class Files {
    public static void main (String[] args) throws IOException{
        System.out.println("input file name");
        Scanner name = new Scanner(System.in);
        String filename = name.next();
        FileWriter writer = new FileWriter("C:\\Users\\Dell\\Documents\\NetBeansProjects\\w2\\src\\CopyingFile\\Copyfile.txt");
        FileReader file = new FileReader("C:\\Users\\Dell\\Documents\\NetBeansProjects\\w2\\src\\CopyingFile\\"+filename);
        Scanner myReader = new Scanner(file);
        try {
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                writer.write(data);
            }
            writer.close();
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
