/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;


public class Cylinder extends Shapes
{
    private final double radius;
    private final double height;
     

    public Cylinder (double r, double h)

    {
        super("Cylinder");
        radius = r;
        height = h;
    }
     

    @Override
    public double area()
    {
        return (2*Math.PI * radius * radius)+(2*Math.PI*radius*height);
    }
    
    @Override
    public String toString(){
       return super.toString() + "of radius " + radius + " of height" + height;
   }
}

