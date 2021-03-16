/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingSearchingSorting;

/**
 *
 * @author HP
 */
// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
import java.util.Scanner;
public class IntegerList
{
int[] list; //values in the list
//------------------------------------------------------------
// Constructor -- takes an integer and creates a list of that // size. All elements default to value 0.
//------------------------------------------------------------
public IntegerList(int size){
list = new int[size];
}
//------------------------------------------------------------
// randomize -- fills the array with randomly generated integers 
//between 1 and 100, inclusive
//------------------------------------------------------------
public void randomize()
{
int max = list.length;
for (int i=0; i<list.length; i++)
list[i] = (int)(Math.random() * max) + 1; }
//------------------------------------------------------------
// fillSorted -- fills the array with sorted values
//------------------------------------------------------------
public void fillSorted()
{
for (int i=0; i<list.length; i++)
list[i] = i + 2;
}
//------------------------------------------------------------
// print -- prints array elements with indices, one per line
//------------------------------------------------------------
public String toString()
{
String s = "";
for (int i=0; i<list.length; i++)
s += i + ":\t" + list[i] + "\n";
return s;
}
//------------------------------------------------------------
// linearSearch -- takes a target value and returns the index 
//of the first occurrence of target in the list. Returns -1 
// if target does not appear in the list
//------------------------------------------------------------
public int linearSearch(int target)
{
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
int location = -1;
for (int i=0; i<list.length && location == -1; i++) if
(list[i] == target)
location = i;
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
return location;
}
//------------------------------------------------------------
// sortIncreasing -- uses selection sort
//------------------------------------------------------------
public void sortIncreasing()
{
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
int minIndex;
for (int i=0; i < list.length-1; i++)
{
//find smallest element in list starting at location i
minIndex = i;
for (int j = i+1; j < list.length; j++)
if (list[j] < list[minIndex])
minIndex = j;
//swap list[i] with smallest element
int temp = list[i];

list[i] = list[minIndex];
list[minIndex] = temp;
}
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
}

public void sortDecreasing(){
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
for (int i=0; i < list.length-1; i++){
    int key = list[i];
    int j = i - 1;
    
while (j >= 0 && list[j] > key) {
    list[j + 1] = list[j];
                j = j - 1;
}

list[j + 1] = key;
}
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
}

public void binarySearch(int target){
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
    int low, mid, high;
    low = 0;
    high = (list.length - 1);
    mid = (low + high) / 2;
    while (list[mid] != target && low <= high)
    {
      if (target < list[mid])
        low = mid + 1;
      else
        high = mid - 1;
      
      mid = (low + high) / 2;

    }
    if (list[mid] == target){
       System.out.println("angka berada di posisi ke " + mid);
    }else{
      System.out.println("angka tidak ditemukan");
    }
    
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis()); 
  }
}