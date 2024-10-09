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

public class Worker extends Thread {

    private int tipe; // Identifica el tipo de trabajador: 0=Placa Base, 1=CPU, 2=RAM, 3=Fuente, 4=Tarjeta Grafica
    private double salaryPerHour;
    private int productionTime; // Tiempo necesario para producir un componente (en días)
    private WareHouse wareHouse; //Almacen de la compania
    private Semaphore storageSemaphore; // Semaforo para controlar el acceso al almacén
    private int dayDuration;

    public Worker(int type, WareHouse wareHouse) {
        this.tipe = type;
        this.storageSemaphore = wareHouse.getSemaphoreByType(type);

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
                this.productionTime = 1;
                break;
            case 4: // Tarjeta grafica
                this.salaryPerHour = 34;
                this.productionTime = 2;
                break;
            default:
                throw new IllegalArgumentException("Tipo de trabajador no valido");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Simulacion del tiempo de producción (en días)
                Thread.sleep(this.getProductionTime() * this.dayDuration); // Por simplicidad, un día = 1000 ms en la simulacion

                // Intentar acceder al almacen (usando el semaforo)
                this.getStorageSemaphore().acquire();
                if (this.getCurrentStock() < this.getStorageCapacity()) {
//                    this.setCurrentStock(this.getCurrentStock() + 1); -> cambiar para usar Warehouse
                    System.out.println("Trabajador de tipo " + getType() + " ha producido un componente. Stock actual: " + getCurrentStock());
                } else {
                    System.out.println("Almacen de tipo " + getType() + " lleno. No se puede producir mas");
                }
                this.getStorageSemaphore().release();
            }
        } catch (InterruptedException e) {
            System.out.println("Produccion interrumpida para el trabajador de tipo " + getType());
        }
    }
    
    public void decrement() throws InterruptedException{
        this.wareHouse.decrementCounterByType(this.tipe);
    }

    public void setCurrentStock(){
        try {
            this.wareHouse.incrementCounterByType(this.tipe);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
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
    public void setSalaryPerHour(float salaryPerHour) {
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

}
