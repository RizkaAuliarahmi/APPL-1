/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polymorphic Sorting;


import java.util.Scanner;

public class Strings{
    
    public static void main(String[] args){
        String[] Str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many string do you want to sort?");
        int ukuran = scanner.nextInt();
        Str = new String[ukuran];
        System.out.println("Enter the string");
        for(int i = 0; i < Str.length; i++){
            Str[i] = scanner.next();
        }
        
        Sorting.selectionSort(Str);
        System.out.println("Your String in sorted order");
        for(int i = 0; i < Str.length; i++){
            System.out.println(Str[i] + " ");
            System.out.println();
        }
    }
}


