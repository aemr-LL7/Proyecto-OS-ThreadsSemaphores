/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;
import java.util.concurrent.Semaphore;

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

        this.populateWorkers();
    }

    private void populateWorkers() {
        for (int i = 0; i < this.MOBO.length; i++) {
            MOBO[i] = new Workers(0, this.wareHouse, this.dayDuration);
        }
        for (int i = 0; i < this.CPU.length; i++) {
            CPU[i] = new Workers(1, this.wareHouse, this.dayDuration);
        }
        for (int i = 0; i < this.RAM.length; i++) {
            RAM[i] = new Workers(2, this.wareHouse, this.dayDuration);
        }
        for (int i = 0; i < this.PSU.length; i++) {
            PSU[i] = new Workers(3, this.wareHouse, this.dayDuration);
        }
        for (int i = 0; i < this.GPU.length; i++) {
            GPU[i] = new Workers(4, this.wareHouse, this.dayDuration);
        }
    }

    private void startWorkers() {
        for (int i = 0; i < this.MOBO.length; i++) {
            MOBO[i].start();
        }
        for (int i = 0; i < this.CPU.length; i++) {
            CPU[i].start();
        }
        for (int i = 0; i < this.RAM.length; i++) {
            RAM[i].start();
        }
        for (int i = 0; i < this.PSU.length; i++) {
            PSU[i].start();
        }
        for (int i = 0; i < this.GPU.length; i++) {
            GPU[i].start();
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
