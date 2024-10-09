/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andre El almacrn se comparte entre diferentes empleados, y su
 * capacidad será limitada. El acceso sera controlado mediante semaforos para no
 * sobrepasar la capacidad al producir nuevos elementos
 */
public class Warehouse {

    private String companyName;

    private static final int maxReadyMobos = 25;
    private static final int maxReadyCPUs = 20;
    private static final int maxReadyRAMs = 55;
    private static final int maxReadyPSUs = 35;
    private static final int maxReadyGPUs = 10;

    private int MOBO_Count;
    private int CPU_Count;
    private int RAM_Count;
    private int PSU_Count;
    private int GPU_Count;


    // Semaforos para controlar el acceso concurrente
    private final Semaphore moboSemaphore = new Semaphore(1);
    private final Semaphore cpuSemaphore = new Semaphore(1);
    private final Semaphore ramSemaphore = new Semaphore(1);
    private final Semaphore psuSemaphore = new Semaphore(1);
    private final Semaphore gpuSemaphore = new Semaphore(1);

    public Warehouse(String company) {
        this.companyName = company;
        this.MOBO_Count = 0;
        this.CPU_Count = 0;
        this.RAM_Count = 0;
        this.PSU_Count = 0;
        this.GPU_Count = 0;
    }

    public boolean isCounterTypeFull(int counterType) {
        switch (counterType) {
            case 0:
                if (this.MOBO_Count == maxReadyMobos) {
                    System.out.println("Esta lleno el almacen de MOBOs de: " + this.companyName);
                    return true;
                }   break;
            case 1:
                if (this.CPU_Count == maxReadyCPUs) {
                    System.out.println("Esta lleno el almacen de CPUs de: " + this.companyName);
                    return true;
                }   break;
            case 2:
                if (this.RAM_Count == maxReadyRAMs) {
                    System.out.println("Esta lleno el almacen de RAMs de: " + this.companyName);
                    return true;
                }   break;
            case 3:
                if (this.PSU_Count == maxReadyPSUs) {
                    System.out.println("Esta lleno el almacen de PSUs de: " + this.companyName);
                    return true;
                }   break;
            case 4:
                if (this.GPU_Count == maxReadyGPUs) {
                    System.out.println("Esta lleno el almacen de GPUs de: " + this.companyName);
                    return true;
                }   break;
            default:
                break;
        }

        return false;
    }

    public void incrementCounterByType(int counterType) throws InterruptedException {
        Semaphore semaphoreToUse = null;

        // Determinamos el semaforo a utilizar segun el tipo de componente
        switch (counterType) {
            case 0 ->
                semaphoreToUse = moboSemaphore;
            case 1 ->
                semaphoreToUse = cpuSemaphore;
            case 2 ->
                semaphoreToUse = ramSemaphore;
            case 3 ->
                semaphoreToUse = psuSemaphore;
            case 4 ->
                semaphoreToUse = gpuSemaphore;
        }

        // Si el semaforo corresponde a un tipo de componente
        if (semaphoreToUse != null) {
            semaphoreToUse.acquire(); // Asegurar exclusion mutua

            // Verificar si el almacen esta lleno antes de incrementar
            if (!isCounterTypeFull(counterType)) {
                switch (counterType) {
                    case 1 ->
                        this.MOBO_Count++;
                    case 2 ->
                        this.CPU_Count++;
                    case 3 ->
                        this.RAM_Count++;
                    case 4 ->
                        this.PSU_Count++;
                    case 5 ->
                        this.GPU_Count++;
                }
                System.out.println("Se ha incrementado el componente " + counterType + " en la compañia " + this.companyName);
            } else {
                System.out.println("No se pudo incrementar el componente " + counterType + " porque el almacen esta lleno");
            }

            semaphoreToUse.release(); // Liberar despues de actualizar
        }
    }

    public String getCompany() {
        return companyName;
    }

    public static int getMaxReadyMobos() {
        return maxReadyMobos;
    }

    public static int getMaxReadyCPUs() {
        return maxReadyCPUs;
    }

    public static int getMaxReadyRAMs() {
        return maxReadyRAMs;
    }

    public static int getMaxReadyPSUs() {
        return maxReadyPSUs;
    }

    public static int getMaxReadyGPUs() {
        return maxReadyGPUs;
    }

    public int getMOBO_Count() {
        return MOBO_Count;
    }

    public int getCPU_Count() {
        return CPU_Count;
    }

    public int getRAM_Count() {
        return RAM_Count;
    }

    public int getPSU_Count() {
        return PSU_Count;
    }

    public int getGPU_Count() {
        return GPU_Count;
    }

}
