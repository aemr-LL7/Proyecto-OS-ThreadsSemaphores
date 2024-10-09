/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

/**
 *
 * @author B-St
 */
public class Factory extends Thread {
    
    private int dayDuration;
    private Workers MOBO;
    private Workers CPU;
    private Workers RAM;
    private Workers PSU;
    private Workers GPU;
    
    private Company company;
    
    private WareHouse wareHouse; 

    public Factory(int dayDuration, Company company) {
        this.dayDuration = dayDuration;
        this.company = company;
    }
    
    private void createWorkers(WareHouse warehouse, int dayDuration){
        this.MOBO = new Workers(0, this.wareHouse, this.dayDuration); 
        this.CPU = new Workers(1, this.wareHouse, this.dayDuration); 
        this.RAM = new Workers(2, this.wareHouse, this.dayDuration); 
        this.PSU = new Workers(3, this.wareHouse, this.dayDuration); 
        this.GPU = new Workers(4, this.wareHouse, this.dayDuration); 
    }
    
    private void createWarehouse(){
        this.wareHouse = new WareHouse(this.company.getCompanyName());
    }
    
    @Override
    public void run(){
        System.out.println("estoy funcionando");
    }
    
}
