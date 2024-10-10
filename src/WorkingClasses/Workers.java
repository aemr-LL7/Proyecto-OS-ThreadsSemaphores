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
    private WareHouse wareHouse; //Almacen de la compania
    private Semaphore storageSemaphore; // Semaforo para controlar el acceso al almacén
    private Semaphore paymentSemaphore;
    private int dayDuration;

    public Workers(int type, WareHouse wareHouse, int dayDuration) {
        this.tipe = type;
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
                this.payMe();
                this.work();
                // Simulacion del tiempo de producción (en días)
                Thread.sleep(this.getProductionTime() * this.dayDuration);
            } catch (InterruptedException e) {
                System.out.println("Produccion interrumpida para el trabajador de tipo " + getType());
            }
        }
    }

    public void work() throws InterruptedException {

        // Intentar acceder al almacen (usando el semaforo)
        this.getStorageSemaphore().acquire();
        if (this.getCurrentStock() < this.getStorageCapacity()) {
            if (this.tipe == 3) {
                this.wareHouse.incrementPSUCounter();
            } else if (this.tipe == 5) {
                this.makeCompter();
                System.out.println("Se ensamblo una computadora para: " + this.wareHouse.getCompany());
            } else {
                this.increment();
                System.out.println("Trabajador de tipo " + getType() + " ha producido un componente. Stock actual: " + getCurrentStock());
            }

        } else {
            System.out.println("Almacen de tipo " + getType() + " lleno. No se puede producir mas");

        }
        this.getStorageSemaphore().release();
    }

    public void makeCompter() throws InterruptedException {

        if (this.tipe == 5) {
            // Intentar acceder al almacen (usando el semaforo)
            this.getStorageSemaphore().acquire();
            if (this.wareHouse.isReadyForPcConstruction()) {

                this.wareHouse.getSemaphoreByType(0).acquire();
                this.wareHouse.getSemaphoreByType(1).acquire();
                this.wareHouse.getSemaphoreByType(2).acquire();
                this.wareHouse.getSemaphoreByType(3).acquire();
                this.wareHouse.getSemaphoreByType(4).acquire();
                this.wareHouse.getSemaphoreByType(5).acquire();

                this.wareHouse.decrementCounterByType(0);
                this.wareHouse.decrementCounterByType(1);
                this.wareHouse.decrementCounterByType(2);
                this.wareHouse.decrementCounterByType(3);
                this.wareHouse.decrementCounterByType(4);
                this.wareHouse.decrementCounterByType(5);

                this.wareHouse.addComputer();

                this.wareHouse.getSemaphoreByType(0).release();
                this.wareHouse.getSemaphoreByType(1).release();
                this.wareHouse.getSemaphoreByType(2).release();
                this.wareHouse.getSemaphoreByType(3).release();
                this.wareHouse.getSemaphoreByType(4).release();
                this.wareHouse.getSemaphoreByType(5).release();
            }
            this.getStorageSemaphore().release();
        } else {
            
        }
    }

    public void payMe() throws InterruptedException {
        this.getPaymentSemaphore().acquire();
        int payment = this.productionTime * (24 * 40);
        this.wareHouse.addCost(payment);
        this.getPaymentSemaphore().release();
    }

    public void increment() throws InterruptedException {
        this.wareHouse.incrementCounterByType(this.tipe);
    }

    public void decrement() throws InterruptedException {
        this.wareHouse.decrementCounterByType(this.tipe);
    }

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

    /**
     * @return the storageSemaphore
     */
    public Semaphore getStorageSemaphore() {
        return storageSemaphore;
    }

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
