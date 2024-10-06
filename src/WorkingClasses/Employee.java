/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andre Employee es la clase base para los diferentes tipos de
 * empleados
 */
public abstract class Employee extends Thread {

    protected String name;
    protected int salaryPerHour;
    protected int productionTimeInDays;
    protected int storageCapacity;  // Capacidad maxima de almacen
    protected int producedItems;
    protected int totalHoursWorked;
    protected Semaphore storageSemaphore;   // Semaforo que controla el acceso al almacen

    public Employee(String name, int salaryPerHour, int productionTimeInDays, int storageCapacity, Semaphore storageSemaphore) {
        this.name = name;
        this.salaryPerHour = salaryPerHour;
        this.productionTimeInDays = productionTimeInDays;
        this.storageCapacity = storageCapacity;
        this.storageSemaphore = storageSemaphore;
        this.producedItems = 0;
        this.totalHoursWorked = 0;
    }

    // Metodo para la produccion de un componente (abstract - se implementa en las clases hijas)
    protected abstract void produceComponent();

    // El hilo para la produccion continua
    @Override
    public void run() {
    
    }

    public int getSalary() {
        return salaryPerHour * totalHoursWorked;
    }
}
