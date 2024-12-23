/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author B-St
 */
public class Workers extends Thread {

    private int tipe; // Identifica el tipo de trabajador: 0=Placa Base, 1=CPU, 2=RAM, 3=Fuente, 4=Tarjeta Grafica
    private int salaryPerHour;
    private int productionTime; // Tiempo necesario para producir un componente (en días)
    private Warehouse wareHouse; //Almacen de la compania
    private Semaphore storageSemaphore; // Semaforo para controlar el acceso al almacén
    private Semaphore paymentSemaphore; //semaforo para registrar costos
    private int dayDuration;

    public Workers(int type, Warehouse wareHouse, int dayDuration) {
        this.tipe = type;
        this.wareHouse = wareHouse;
        this.storageSemaphore = wareHouse.getSemaphoreByType(type);
        this.paymentSemaphore = wareHouse.getPaymentSemaphore();
        this.dayDuration = dayDuration;
        // Configurar los valores dependiendo del tipo: USANDO X=9
        switch (type) {
            case 0: // Placa base
                this.salaryPerHour = 20;
                this.productionTime = 4; // Días para producir
                break;
            case 1: // CPU
                this.salaryPerHour = 26;
                this.productionTime = 4;
                break;
            case 2: // RAM
                this.salaryPerHour = 40;
                this.productionTime = 1;
                break;
            case 3: // Fuente de Alimentacion
                this.salaryPerHour = 16;
                this.productionTime = 1; // -> Como se producen 5 rams en un dia, se multiplica la produccion * 5
                break;
            case 4: // Tarjeta grafica
                this.salaryPerHour = 34;
                this.productionTime = 2;
                break;
            case 5: // ensamblador
                this.salaryPerHour = 50;
                this.productionTime = 2;
                break;
            default:
                throw new IllegalArgumentException("Tipo de trabajador no valido");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.payMe(); // Cobro fijo por el período de ensamblaje
                this.work();  // Intentar ensamblar una computadora
                Thread.sleep(this.dayDuration * this.productionTime); // Simular los 2 dias de ensamblaje
            } catch (InterruptedException e) {
                System.out.println("Producción interrumpida para el ensamblador.");
            }
        }
    }

    public void work() throws InterruptedException {
        if (this.tipe == 5) { // Ensamblador
            boolean success = this.wareHouse.tryToAssembleComputer();
            if (success) {
                System.out.println("Ensamblador creo una computadora para " + this.wareHouse.getCompanyName() + " Cantidad NORMAL: " + this.wareHouse.getCOMPUTER_Count() + " Cantidad CON GPU: " + this.wareHouse.getGPUCOMPUTER_Count());
                
            } else {
                System.out.println("Ensamblador no pudo ensamblar una computadora: recursos insuficientes.");
            }
        } else { // Productores
            if (this.getCurrentStock() < this.getStorageCapacity()) {
                this.increment();
            } else {
                System.out.println("Almacen lleno para tipo " + getType() + ". No se puede producir mas.");
            }
        }
        
    }

//    public void makeCompter() throws InterruptedException {
//
//        if (this.tipe == 5) {
//            // Intentar acceder al almacen (usando el semaforo)
//
//            if (this.wareHouse.getCompanyName().equals("MSI") && this.wareHouse.getMOBO_Count() > 2 && this.wareHouse.getCPU_Count() > 3 && this.wareHouse.getRAM_Count() > 4 && this.wareHouse.getPSU_Count() > 6) {
//                this.wareHouse.decrementCounterByType(0);
//                this.wareHouse.decrementCounterByType(1);
//                this.wareHouse.decrementCounterByType(2);
//                this.wareHouse.decrementCounterByType(3);
//                this.wareHouse.decrementCounterByType(4);
//                this.wareHouse.decrementCounterByType(5);
//            } else if (this.wareHouse.getCompanyName().equals("HP") && this.wareHouse.getMOBO_Count() > 1 && this.wareHouse.getCPU_Count() > 1 && this.wareHouse.getRAM_Count() > 2 && this.wareHouse.getPSU_Count() > 4) {
//                this.wareHouse.decrementCounterByType(0);
//                this.wareHouse.decrementCounterByType(1);
//                this.wareHouse.decrementCounterByType(2);
//                this.wareHouse.decrementCounterByType(3);
//                this.wareHouse.decrementCounterByType(4);
//                this.wareHouse.decrementCounterByType(5);
//            }
//
//            this.wareHouse.addComputer();
//
//        } else {
//            System.out.println("No se pudo ensamblar computadora");
//        }
//    }

    public void payMe() throws InterruptedException {
        this.getPaymentSemaphore().acquire();
        int payment = this.salaryPerHour * 24 * this.productionTime; // Cobro fijo por el tiempo de produccion
        this.wareHouse.addCost(payment);
        this.getPaymentSemaphore().release();
    }

    public void increment() throws InterruptedException {
        this.wareHouse.incrementCounterByType(this.tipe);
    }

//    public void decrement() throws InterruptedException {
//        this.wareHouse.decrementCounterByType(this.tipe);
//   }

    public void setCurrentStock() {
        try {
            this.wareHouse.incrementCounterByType(this.tipe);
        } catch (InterruptedException ex) {
            Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the type
     */
    public int getType() {
        return tipe;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.tipe = type;
    }

    /**
     * @return the salaryPerHour
     */
    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    /**
     * @param salaryPerHour the salaryPerHour to set
     */
    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    /**
     * @return the productionTime
     */
    public int getProductionTime() {
        return productionTime;
    }

    /**
     * @param productionTime the productionTime to set
     */
    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    /**
     * @return the storageCapacity
     */
    public int getStorageCapacity() {
        return this.wareHouse.getCapacityByType(this.tipe);
    }

    /**
     * @return the currentStock
     */
    public int getCurrentStock() {
        return this.wareHouse.getStockByType(this.tipe);
    }

//    /**
//     * @return the storageSemaphore
//     */
//    public Semaphore getStorageSemaphore() {
//        return storageSemaphore;
//    }
    /**
     * @param storageSemaphore the storageSemaphore to set
     */
    public void setStorageSemaphore(Semaphore storageSemaphore) {
        this.storageSemaphore = storageSemaphore;
    }

    public Semaphore getPaymentSemaphore() {
        return paymentSemaphore;
    }

}
