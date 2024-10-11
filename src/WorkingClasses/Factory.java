/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import EDD.SimpleList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author B-St
 */
public class Factory extends Thread {

    private int daysTillShipement;
    private int dayDuration;

    private Workers[] MOBO;
    private Workers[] CPU;
    private Workers[] RAM;
    private Workers[] PSU;
    private Workers[] GPU;
    private Workers[] ASMBLY;

    private ProjectManager PM;
    private Director director;

    private Company company;

    private Warehouse wareHouse;

    public Factory(int dayDuration, int MOBOWorkersAmmount, int CPUWorkersAmmount, int RAMWorkersAmmount, int PSUWorkersAmmount, int GPUWorkersAmmount, int ASMBLYWorkersAmmount, Company company, int daysTillShipement) {
        this.dayDuration = dayDuration;
        this.daysTillShipement = daysTillShipement;
        this.MOBO = new Workers[MOBOWorkersAmmount];
        this.CPU = new Workers[CPUWorkersAmmount];
        this.RAM = new Workers[RAMWorkersAmmount];
        this.PSU = new Workers[PSUWorkersAmmount];
        this.GPU = new Workers[GPUWorkersAmmount];
        this.ASMBLY = new Workers[ASMBLYWorkersAmmount];
        this.company = company;
        
        this.wareHouse = this.company.getInventoryWareHouse();
        this.PM = new ProjectManager(this.daysTillShipement, this.company, this.dayDuration);
        this.director = new Director(this.PM, this.wareHouse, this.dayDuration, this.company);

        this.populateWorkers();
//        this.start();//Corremos esta mierda si o k hpta 
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
        for (int i = 0; i < this.ASMBLY.length; i++) {
            ASMBLY[i] = new Workers(5, this.wareHouse, this.dayDuration);
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
        for (int i = 0; i < this.ASMBLY.length; i++) {
            ASMBLY[i].start();
        }

    }
    
    private void startExecutives(){
        this.PM.start();
        this.director.start();
    }

    public void registerCosts() throws InterruptedException {
        this.wareHouse.getPaymentSemaphore().acquire();
        this.company.addOperationCost(this.wareHouse.getAccumulatedProductionCost());
        this.wareHouse.cleanHouse();
        this.wareHouse.getPaymentSemaphore().release();
    }

    public void getWorkersCountByType() {
        System.out.println("Cantidad de trabajadores presentes:");
        System.out.println("MOBO: " + MOBO.length);
        System.out.println("CPU: " + CPU.length);
        System.out.println("RAM: " + RAM.length);
        System.out.println("PSU: " + PSU.length);
        System.out.println("GPU: " + GPU.length);
        System.out.println("ASMBLY: " + ASMBLY.length);
    }

    @Override
    public void run() {
        this.startWorkers();
        this.startExecutives();

        while (true) {
            try {
                Thread.sleep(dayDuration); // Esperar un día (simulado)
                this.registerCosts(); //agregamos los gastos de los workers, el sistema de control de las entradas las lleva el director.
                this.company.calculateNetWins();
                System.out.println("==================================================PASO UN PINSHY DIA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ProjectManager getPM() {
        return PM;
    }

    public int getDaysTillShipement() {
        return daysTillShipement;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public Director getDirector() {
        return director;
    }

    public Company getCompany() {
        return company;
    }

    public Warehouse getWareHouse() {
        return wareHouse;
    }
    
    
    
}
