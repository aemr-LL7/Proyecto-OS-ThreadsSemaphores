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

public class Worker extends Thread {

    private int type; // Identifica el tipo de trabajador: 0=Placa Base, 1=CPU, 2=RAM, 3=Fuente, 4=Tarjeta Grafica
    private double salaryPerHour;
    private int productionTime; // Tiempo necesario para producir un componente (en días)
    private int storageCapacity; // Capacidad max del almacen
    private int currentStock;
    private Semaphore storageSemaphore; // Semaforo para controlar el acceso al almacén

    public Worker(int type, Semaphore storageSemaphore) {
        this.type = type;
        this.storageSemaphore = storageSemaphore;
        this.currentStock = 0; // Inicialmente esta vacio

        // Configurar los valores dependiendo del tipo: USANDO X=9
        switch (type) {
            case 0: // Placa base
                this.salaryPerHour = 20;
                this.productionTime = 4; // Días para producir
                this.storageCapacity = 25;
                break;
            case 1: // CPU
                this.salaryPerHour = 26;
                this.productionTime = 4;
                this.storageCapacity = 20;
                break;
            case 2: // RAM
                this.salaryPerHour = 40;
                this.productionTime = 1;
                this.storageCapacity = 55;
                break;
            case 3: // Fuente de Alimentacion
                this.salaryPerHour = 16;
                this.productionTime = 1;
                this.storageCapacity = 35;
                break;
            case 4: // Tarjeta grafica
                this.salaryPerHour = 34;
                this.productionTime = 2;
                this.storageCapacity = 10;
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
                Thread.sleep(this.getProductionTime() * 1000); // Por simplicidad, un día = 1000 ms en la simulacion

                // Intentar acceder al almacen (usando el semaforo)
                this.getStorageSemaphore().acquire();
                if (this.getCurrentStock() < this.getStorageCapacity()) {
                    this.setCurrentStock(this.getCurrentStock() + 1);
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

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
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
        return storageCapacity;
    }

    /**
     * @param storageCapacity the storageCapacity to set
     */
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * @return the currentStock
     */
    public int getCurrentStock() {
        return currentStock;
    }

    /**
     * @param currentStock the currentStock to set
     */
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
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
