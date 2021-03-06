/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchSortIntegerList;

/**
 *
 * @author HP
 */
// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// ****************************************************************
import java.util.Scanner;
public class IntegerListTest
{
static IntegerList list = new IntegerList(10);
static Scanner scan = new Scanner(System.in);
static IntegerList sortedList = new IntegerList(10);
//------------------------------------------------------- 
//Create a list, then repeatedly print the menu and do what the 
//user asks until they quit
//-------------------------------------------------------
public static void main(String[] args)
{
printMenu();
int choice = scan.nextInt();
while (choice != 0)
{
dispatch(choice);
printMenu();
choice = scan.nextInt();
}}
//-------------------------------------------------------
// Do what the menu item calls for
//-------------------------------------------------------
public static void dispatch(int choice)
{
int loc;
switch(choice)
{
case 0:
System.out.println("Bye!");
break;
case 1:
System.out.println("How big should the list be?"); int size
= scan.nextInt();
list = new IntegerList(size);
list.randomize();
break;
case 2:
list.selectionSort();
break;
case 3:
System.out.print("Enter the value to look for: "); loc =
list.search(scan.nextInt());

if (loc != -1)
System.out.println("Found at location " + loc); else
System.out.println("Not in list");
break;
case 4:
list.print();
break;

case 5:
System.out.println("masukkan angka yang ingin diganti :");
int oldVal = scan.nextInt();
System.out.println("masukkan angka baru yang akan mengganti angka lama : ");
int newVal = scan.nextInt();
list.replaceFirst(oldVal, newVal);
break;

case 6:
System.out.println("masukkan angka yang ingin diganti :");
int oldValue = scan.nextInt();
System.out.println("masukkan angka baru yang akan mengganti angka lama : ");
int newValue = scan.nextInt();
list.replaceAll(oldValue, newValue);
break;

case 7:
list.sortDecreasing();
break;

case 8:
System.out.println("masukan angka yang ingin dicari :");
int target = scan.nextInt();
list.sortDecreasing();
list.binarySearchD(target);
break;
default:
System.out.println("Sorry, invalid choice");
}
}
//-------------------------------------------------------
// Print the user's choices
//-------------------------------------------------------
public static void printMenu()
{
System.out.println("\n Menu ");
System.out.println(" ====");
System.out.println("0: Quit");
System.out.println("1: Create a new list (** do this first!! **)");
System.out.println("2: Sort the list using selection sort");
System.out.println("3: Find an element in the list using linear search");
System.out.println("4: Print the list");
System.out.println("5: Replace first value");
System.out.println("6: Replace all value");
System.out.println("7: Decresion sort list");
System.out.println("8: Binary search");
System.out.print("\nEnter your choice: ");
}
}
