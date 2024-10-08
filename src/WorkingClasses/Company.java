/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

/**
 *
 * @author B-St
 */
public class Company extends Thread{
    
    private static final int normalWorkers = 21; 
    
    private WareHouse inventoryWareHouse;
    private int readyComputers = 0;
    
    private int daysTillShipement;  
}
