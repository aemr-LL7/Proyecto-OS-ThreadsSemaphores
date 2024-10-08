/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

/**
 *
 * @author B-St
 */
public class Worker extends Thread{
    
    private String type;
    private int hourlyPay;
    private int workersQuantity;
    
    @Override 
    public void run(){
        System.out.println("Toy trabajandito mano");
    };
}
