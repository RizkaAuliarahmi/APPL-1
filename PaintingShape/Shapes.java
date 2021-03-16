/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaintingShapes;

/**
 *
 * @author hp
 */
public abstract class Shapes {
protected String shapeName;

public Shapes(String shapename){
    shapeName = shapename;
}

abstract double area();

@Override
public String toString(){
     return "Shape Name : "+ shapeName;
}

    
}
