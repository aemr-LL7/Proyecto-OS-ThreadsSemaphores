/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andre
 */
public class Assembler extends Thread {

    private double salaryPerHour;  // Salario por hora
    private int assemblyTime;      // Tiempo para ensamblar una computadora (2 días)
    private Semaphore storageSemaphore;  // Semáforo para controlar el acceso al almacén
    private Workers[] workers;      // Los trabajadores (productores) que proporcionan las piezas
    private int computersAssembled; // Número de computadoras ensambladas
    private int computersWithoutGPU; // Contador de computadoras sin tarjeta gráfica ensambladas
    private int maxWithoutGPU; // Número máximo de computadoras sin tarjeta gráfica que se pueden ensamblar antes de añadir una con tarjeta gráfica
    private boolean needsGraphicsCard; // Indicador de si la siguiente computadora debe tener tarjeta gráfica

    public Assembler(Workers[] workers, Semaphore storageSemaphore, int maxWithoutGPU) {
        this.salaryPerHour = 50;
        this.assemblyTime = 2; // Días para ensamblar una computadora
        this.storageSemaphore = storageSemaphore;
        this.workers = workers;
        this.computersAssembled = 0;
        this.computersWithoutGPU = 0;
        this.maxWithoutGPU = maxWithoutGPU; // Política especial de la empresa
        this.needsGraphicsCard = false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Intentar ensamblar
                this.storageSemaphore.acquire(); // Acceso exclusivo al almacen

                // Verificar si hay suficientes piezas para ensamblar una pc
                if (this.canAssemblePC()) {
                    this.takePartsForAssembly();

                    // Simular el tiempo de ensamblaje (2 dias simplificado a 2000 ms)
                    Thread.sleep(this.assemblyTime * 2000);

                    // Ensamblar la computadora
                    this.computersAssembled++;

                    // Verificar la política de tarjetas graficas
                    if (this.needsGraphicsCard) {
                        System.out.println("Ensamblando una computadora CON tarjeta grafica");
                        this.needsGraphicsCard = false;
                        this.computersWithoutGPU = 0; // Reiniciar contador
                    } else {
                        System.out.println("Ensamblando una computadora SIN tarjeta grafica");
                        this.computersWithoutGPU++;
                        if (this.computersWithoutGPU >= maxWithoutGPU) {
                            this.needsGraphicsCard = true;
                        }
                    }

                    System.out.println("Computadoras ensambladas: " + computersAssembled);

                } else {
                    System.out.println("No hay suficientes piezas para ensamblar una computadora.");
                }

                storageSemaphore.release(); // Liberar el acceso al almacén
            }
        } catch (InterruptedException e) {
            System.out.println("Ensamblaje interrumpido.");
        }
    }

    /*
    *   Metodo para verificar si se puede ensamblar una computadora
    *   Requiere al menos 1 de cada parte para ensamblar, y puede o no necesitar una tarjeta grafica
     */
    private boolean canAssemblePC() {
        if (this.workers[0].getCurrentStock() <= 0) {
            return false; // Placa base
        }
        if (this.workers[1].getCurrentStock() <= 0) {
            return false; // CPU
        }
        if (this.workers[2].getCurrentStock() <= 0) {
            return false; // RAM
        }
        if (this.workers[3].getCurrentStock() <= 0) {
            return false; // Fuente de alimentación
        }
        // Si necesita una tarjeta grafica, también debe haber stock suficiente
        if (this.needsGraphicsCard && this.workers[4].getCurrentStock() <= 0) {
            return false;
        }
        // Hay suficientes partes
        return true;
    }


    /*
    *   Metodo para tomar las piezas necesarias del almacen
     */
    private void takePartsForAssembly() throws InterruptedException {
        // Obtener el stock actual, decrementar y actualizar el valor
        this.workers[0].decrement(); // Placa base
        this.workers[1].decrement(); // CPU
        this.workers[2].decrement(); // RAM
        this.workers[3].decrement(); // Fuente de alimentacion

        if (this.needsGraphicsCard) {
            this.workers[4].decrement(); // Tarjeta grafica
        }
    }

}
