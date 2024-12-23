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
    private int daysElapsed;

    private Workers[] MOBO;
    private Workers[] CPU;
    private Workers[] RAM;
    private Workers[] PSU;
    private Workers[] GPU;
    private Workers[] ASMBLY;
    private int maxCapacity;

    private ProjectManager PM;
    private Director director;

    private Company company;

    private Warehouse wareHouse;

    public Factory(int dayDuration, int MOBOWorkersAmmount, int CPUWorkersAmmount, int RAMWorkersAmmount, int PSUWorkersAmmount, int GPUWorkersAmmount, int ASMBLYWorkersAmmount, int maxCapacity, Company company, int daysTillShipement) {
        this.dayDuration = dayDuration;
        this.daysTillShipement = daysTillShipement;
        this.MOBO = new Workers[MOBOWorkersAmmount];
        this.CPU = new Workers[CPUWorkersAmmount];
        this.RAM = new Workers[RAMWorkersAmmount];
        this.PSU = new Workers[PSUWorkersAmmount];
        this.GPU = new Workers[GPUWorkersAmmount];
        this.ASMBLY = new Workers[ASMBLYWorkersAmmount];
        this.maxCapacity = maxCapacity;
        this.company = company;

        this.wareHouse = this.company.getInventoryWareHouse();
        this.PM = new ProjectManager(this.daysTillShipement, this.company, this.dayDuration);
        this.director = new Director(this.PM, this.wareHouse, this.dayDuration, this.company);

        this.populateWorkers();
//        this.start();//Corremos esta mierda si o k hpta ===> el diavlo (0_=)
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

    private void startExecutives() {
        this.PM.start();
        this.director.start();
    }

    // Detener a todos los hilos de trabajadores
    private void stopAllWorkers() {
        for (int i = 0; i < this.MOBO.length; i++) {
            MOBO[i].stopWorking();
        }
        for (int i = 0; i < this.CPU.length; i++) {
            CPU[i].stopWorking();
        }
        for (int i = 0; i < this.RAM.length; i++) {
            RAM[i].stopWorking();
        }
        for (int i = 0; i < this.PSU.length; i++) {
            PSU[i].stopWorking();
        }
        for (int i = 0; i < this.GPU.length; i++) {
            GPU[i].stopWorking();
        }
        for (int i = 0; i < this.ASMBLY.length; i++) {
            ASMBLY[i].stopWorking();
        }
    }

    // Crear un arreglo de trabajadores segun su tipo
    private Workers[] createWorkers(int count, int type) {
        
        Workers[] workersArray = new Workers[count];
        for (int i = 0; i < count; i++) {
            workersArray[i] = new Workers(type, this.wareHouse, this.dayDuration);
        }
        return workersArray;
    }

    // Cargar nuevos trabajadores en los atrray
    private void loadNewWorkers(String[] workerValues) {
        try {
            this.MOBO = createWorkers(Integer.parseInt(workerValues[0]), 0); // Tipo 0: MOBO
            this.CPU = createWorkers(Integer.parseInt(workerValues[1]), 1); // Tipo 1: CPU
            this.RAM = createWorkers(Integer.parseInt(workerValues[2]), 2); // Tipo 2: RAM
            this.PSU = createWorkers(Integer.parseInt(workerValues[3]), 3); // Tipo 3: PSU
            this.GPU = createWorkers(Integer.parseInt(workerValues[4]), 4); // Tipo 4: GPU
            this.ASMBLY = createWorkers(Integer.parseInt(workerValues[5]), 5); // Tipo 5: ASMBLY
        } catch (NumberFormatException e) {
            System.out.println("Error: Los valores de trabajadores no son validossssss");
        }
    }

    // Método sincronizado para actualizar los trabajadores
    public synchronized void updateWorkers(String[] workerValues) {

        this.stopAllWorkers();

        // 2-> Actualizar los arreglos de trabajadores
        this.loadNewWorkers(workerValues);

        this.startWorkers();
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

    public int getWorkersCountByType(int type) {
        switch (type) {
            case 0:
                for (Workers MOBO1 : MOBO) {
                    return MOBO.length;
                }

            case 1:
                for (Workers CPU1 : CPU) {
                    return CPU.length;
                }
            case 2:
                for (Workers RAM1 : RAM) {
                    return RAM.length;
                }
            case 3:
                for (Workers PSU1 : PSU) {
                    return PSU.length;
                }
            case 4:
                for (Workers GPU1 : GPU) {
                    return GPU.length;
                }
            case 5:
                for (Workers ASM1 : ASMBLY) {
                    return ASMBLY.length;
                }
            default:
                System.out.println("No se ha encontrado el tipo de trabajador requerido.");
                return -1;
        }
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
                // Reporte diario al final de cada día de simulación
                System.out.println("============================================ Pinshy Dia completado: " + (this.getPM().getRemainingDays()));

                if (this.getPM().getRemainingDays() == 0) {
                    System.out.println("Simulación terminada: Todos los dias de envio completados.");
                    System.out.println("Costos operativos: $" + this.company.getOperationCost());
                    System.out.println("Ganancias brutas: $" + this.company.getBrute());
                    System.out.println("Ganancias netas: $$$" + this.company.getNetWins());
                }

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

    /**
     * @return the daysElapsed
     */
    public int getDaysElapsed() {
        return daysElapsed;
    }

    /**
     * @param daysElapsed the daysElapsed to set
     */
    public void setDaysElapsed(int daysElapsed) {
        this.daysElapsed = daysElapsed;
    }

    /**
     * @return the maxCapacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @param maxCapacity the maxCapacity to set
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}
