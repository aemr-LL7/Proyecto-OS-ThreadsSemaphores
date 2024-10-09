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

    private Workers[] MOBO;
    private Workers[] CPU;
    private Workers[] RAM;
    private Workers[] PSU;
    private Workers[] GPU;

    private Company company;

    private WareHouse wareHouse;

    public Factory(int dayDuration, int MOBOWorkersAmmount, int CPUWorkersAmmount, int RAMWorkersAmmount, int PSUWorkersAmmount, int GPUWorkersAmmount, Company company, WareHouse wareHouse) {
        this.dayDuration = dayDuration;
        this.MOBO = new Workers[MOBOWorkersAmmount];      
        this.CPU = new Workers[CPUWorkersAmmount];      
        this.RAM = new Workers[RAMWorkersAmmount];      
        this.PSU = new Workers[PSUWorkersAmmount];      
        this.GPU = new Workers[GPUWorkersAmmount];      
        
        this.company = company;
        this.wareHouse = wareHouse;
    }

    private void createWorkers(WareHouse warehouse, int dayDuration) {
        
    }

    private void startWorkers() {

        for (int i = 0; i < this.MOBOWorkersAmmount; i++) {

        }

    }

    private void createWarehouse() {
        this.wareHouse = new WareHouse(this.company.getCompanyName());
    }

    @Override
    public void run() {
        System.out.println("estoy funcionando");
    }

}
