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
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
import java.util.Scanner;

public class IntegerList
{
int[] list; //values in the list
//-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------
public IntegerList(int size)
{
list = new int[size];
}
//-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------
public void randomize()
{
for (int i=0; i<list.length; i++)
list[i] = (int)(Math.random() * 100) + 1;
}
//-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------
public void print()
{
for (int i=0; i<list.length; i++)
System.out.println(i + ":\t" + list[i]);
}
//------------------------------------------------------- 
//return the index of the first occurrence of target in the list. 
//return -1 if target does not appear in the list
//-------------------------------------------------------
public int search(int target)
{
int location = -1;
for (int i=0; i<list.length && location == -1; i++) if(list[i] == target)
location = i;
return location;
}
//------------------------------------------------------- 
//sort the list into ascending order using the selection sort algorithm
//------------------------------------------------------- 
public void selectionSort()
{
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

for (int i=0; i<list.length; i++)
System.out.println(i + ":\t" + list[i]);
}

public void replaceFirst(int oldVal, int newVal){
   try {
       int newIndex = -1;
   newIndex = search(oldVal);
   list[newIndex] = newVal;
    } catch(ArrayIndexOutOfBoundsException e){
        System.out.println("angka yang ingin diganti tidak ada");
    }
for (int i=0; i<list.length; i++)
System.out.println(i + ":\t" + list[i]);
}

public void replaceAll(int oldVal, int newVal){
       int Index;
       for (Index = 0; Index < list.length; Index++){
           if (list[Index] == oldVal)
               list[Index] = newVal;
       }
for (int i=0; i<list.length; i++)
System.out.println(i + ":\t" + list[i]);
}

public void sortDecreasing()
{
int maxIndex;
for (int i=0; i < list.length-1; i++)
{
//find largest element in list starting at location i
maxIndex = i;
for (int j = i+1; j < list.length; j++)
if (list[j] > list[maxIndex])
maxIndex = j;
//swap list[i] with largest element
int temp = list[i];

list[i] = list[maxIndex];
list[maxIndex] = temp;
}

for (int i=0; i<list.length; i++)
System.out.println(i + ":\t" + list[i]);
}

 public void binarySearchD(int target)
  {
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
    if (list[mid] == target)
       System.out.println("angka berada di posisi ke" + mid);
    else
      System.out.println("angka tidak ditemukan");
  }
}

