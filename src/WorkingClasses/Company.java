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
    
    private String companyName;
    
    private int MOBOWorkersAmmount; 
    private int CPUWorkersAmmount; 
    private int RAMWorkersAmmount; 
    private int PSUWorkersAmmount; 
    private int GPUWorkersAmmount; 
    
    private int dayDuration;
   
    private Worker MOBO;
    private Worker CPU;
    private Worker RAM;
    private Worker PSU;
    private Worker GPU;
    
    private WareHouse inventoryWareHouse;
    private int readyComputers = 0;
    
    private int daysTillShipement;  

    public Company(String companyName, int MOBOWorkersAmmount, int CPUWorkersAmmount, int RAMWorkersAmmount, int PSUWorkersAmmount, int GPUWorkersAmmount, WareHouse inventoryWareHouse, int daysTillShipement, int dayDuration) {
        this.companyName = companyName;
        this.MOBOWorkersAmmount = MOBOWorkersAmmount;
        this.CPUWorkersAmmount = CPUWorkersAmmount;
        this.RAMWorkersAmmount = RAMWorkersAmmount;
        this.PSUWorkersAmmount = PSUWorkersAmmount;
        this.GPUWorkersAmmount = GPUWorkersAmmount;
        this.inventoryWareHouse = inventoryWareHouse;
        this.daysTillShipement = daysTillShipement;
        this.dayDuration = dayDuration;
    }
    
    
    
    
}
