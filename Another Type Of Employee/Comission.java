/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1;

/**
 *
 * @author hp
 */
public class Comission extends Hourly 
{
    protected double totalsale;
    protected double comissionrate;
    
    public Comission (String eName, String eAddress, String ePhone,String socSecNumber, double rate, double cmsrate){
    super(eName, eAddress, ePhone, socSecNumber, rate);
    comissionrate = cmsrate;
    }
    
    public void AddSales(double totalSales){
    totalsale=totalSales;
    }
    
    @Override
    public double pay(){
        payRate=super.pay();
        payRate += totalsale*comissionrate;
        totalsale=0;
        return payRate;
    }
    
    @Override
    public String toString(){
    String result = super .toString(); 
    result += "\nTotal Sale: " + totalsale;
    return result;
    }
}

