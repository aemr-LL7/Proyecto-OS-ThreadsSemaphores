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
public class WareHouse {

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
    
    private int accumulatedProductionCost;

    public WareHouse(String company) {
        this.companyName = company;
        this.MOBO_Count = 0;
        this.CPU_Count = 0;
        this.RAM_Count = 0;
        this.PSU_Count = 0;
        this.GPU_Count = 0;
        this.accumulatedProductionCost = 0;
    }

    public boolean isCounterTypeFull(int counterType) {
        switch (counterType) {
            case 0:
                if (this.MOBO_Count == maxReadyMobos) {
                    return true;
                }
                break;
            case 1:
                if (this.CPU_Count == maxReadyCPUs) {
                    return true;
                }
                break;
            case 2:
                if (this.RAM_Count == maxReadyRAMs) {
                    return true;
                }
                break;
            case 3:
                if (this.PSU_Count == maxReadyPSUs) {
                    return true;
                }
                break;
            case 4:
                if (this.GPU_Count == maxReadyGPUs) {
                    return true;
                }
                break;
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
                    case 0 ->
                        this.MOBO_Count++;
                    case 1 ->
                        this.CPU_Count++;
                    case 2 ->
                        this.RAM_Count++;
                    case 3 ->
                        this.PSU_Count++;
                    case 4 ->
                        this.GPU_Count++;
                }
                System.out.println("Se ha incrementado el componente " + counterType + " en la compañia " + this.companyName);
            } else {
                System.out.println("No se pudo incrementar el componente " + counterType + " porque el almacen esta lleno");
            }

            semaphoreToUse.release(); // Liberar despues de actualizar
        }
    }

    //caso especial PSU, 5 en un dia
    public void incrementPSUCounter(){
        
        int difference = this.getCapacityByType(3) - this.getPSU_Count();
        
        if (difference > 5) {
            for (int i=5; 0<i; i--){
                this.PSU_Count++;
            }
        } else {
            for (int i=difference; i>0; i--){
                this.PSU_Count++;
            }
            System.out.println("Se boto: " + (5-difference) + "PSUs en la ultima produccion de: " + this.companyName);
        }
        
        
    }
    
    public void decrementCounterByType(int counterType) throws InterruptedException {
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
            if (this.getStockByType(counterType) == 0) {
                System.out.println("No se pudo restar el componente " + counterType + " porque el almacen esta vacio");
                
            } else {

                switch (counterType) {
                    case 0 ->
                        this.MOBO_Count--;
                    case 1 ->
                        this.CPU_Count--;
                    case 2 ->
                        this.RAM_Count--;
                    case 3 ->
                        this.PSU_Count--;
                    case 4 ->
                        this.GPU_Count--;
                }
                
                System.out.println("Se ha reducido el componente " + counterType + " en la compañia " + this.companyName);
            }

            semaphoreToUse.release(); // Liberar despues de actualizar
        }
    }

    public Semaphore getSemaphoreByType(int tipe) {

        Semaphore semaphoreToUse = null;

        // Determinamos el semaforo a utilizar segun el tipo de componente
        switch (tipe) {
            case 0 ->
                semaphoreToUse = this.moboSemaphore;
            case 1 ->
                semaphoreToUse = this.cpuSemaphore;
            case 2 ->
                semaphoreToUse = this.ramSemaphore;
            case 3 ->
                semaphoreToUse = this.psuSemaphore;
            case 4 ->
                semaphoreToUse = this.gpuSemaphore;
        }

        return semaphoreToUse;
    }

    public int getCapacityByType(int type) {

        if (type == 0) {
            return this.getMOBO_Count();
        } else if (type == 1) {
            return this.getCPU_Count();
        } else if (type == 2) {
            return this.getRAM_Count();
        } else if (type == 3) {
            return this.getPSU_Count();
        } else if (type == 4) {
            return this.getGPU_Count();
        }

        System.out.println("Error al obtener capacidad por tipo");
        return -1;

    }

    public int getStockByType(int type) {

        if (type == 0) {
            return this.getMOBO_Count();
        } else if (type == 1) {
            return this.getCPU_Count();
        } else if (type == 2) {
            return this.getRAM_Count();
        } else if (type == 3) {
            return this.getPSU_Count();
        } else if (type == 4) {
            return this.getGPU_Count();
        }

        System.out.println("Error al obtener la cantidad por tipo");
        return -1;

    }

    public void addCost(int cost){
        this.accumulatedProductionCost += cost;
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
