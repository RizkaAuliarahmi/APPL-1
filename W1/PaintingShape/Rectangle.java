/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;

 

public class Rectangle extends Shapes
{
    private final double length;
    private final double width;
     
    public Rectangle (double l, double w)
    {
        super("Rectangle");
        length = l;
        width = w;
    }

    @Override
    public double area()
    {
        return length * width;
    }
    
    @Override
    public String toString(){
       return super.toString() + "of length" + length + " of width " + width;
   }
}

