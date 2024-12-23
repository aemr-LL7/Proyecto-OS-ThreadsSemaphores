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

    private static int maxReadyMobos = 25;
    private static int maxReadyCPUs = 20;
    private static int maxReadyRAMs = 55;
    private static int maxReadyPSUs = 35;
    private static int maxReadyGPUs = 10;

    private int MOBO_Count;
    private int CPU_Count;
    private int RAM_Count;
    private int PSU_Count;
    private int GPU_Count;
    private int COMPUTER_Count;
    private int GPUCOMPUTER_Count;

    // Semaforos para controlar el acceso concurrente
    private Semaphore moboSemaphore = new Semaphore(1);
    private Semaphore cpuSemaphore = new Semaphore(1);
    private Semaphore ramSemaphore = new Semaphore(1);
    private Semaphore psuSemaphore = new Semaphore(1);
    private Semaphore gpuSemaphore = new Semaphore(1);

    private Semaphore paymentSemaphore = new Semaphore(1);
    private Semaphore computerSemaphore = new Semaphore(1);
    private Semaphore assemblySemaphore = new Semaphore(1);
    private Semaphore daysRemainigSemaphore = new Semaphore(1);

    private int accumulatedProductionCost;

    public Warehouse(String company) {
        this.companyName = company;
        this.MOBO_Count = 0;
        this.CPU_Count = 0;
        this.RAM_Count = 0;
        this.PSU_Count = 0;
        this.GPU_Count = 0;
        this.COMPUTER_Count = 0;
        this.GPUCOMPUTER_Count = 0;
        this.accumulatedProductionCost = 0;
    }

    public boolean isCounterTypeFull(int counterType) {
        switch (counterType) {
            case 0:
                if (this.getMOBO_Count() == getMaxReadyMobos()) {
                    return true;
                }
                break;
            case 1:
                if (this.getCPU_Count() == getMaxReadyCPUs()) {
                    return true;
                }
                break;
            case 2:
                if (this.getRAM_Count() == getMaxReadyRAMs()) {
                    return true;
                }
                break;
            case 3:
                if (this.getPSU_Count() == getMaxReadyPSUs()) {
                    return true;
                }
                break;
            case 4:
                if (this.getGPU_Count() == getMaxReadyGPUs()) {
                    return true;
                }
                break;
            case 5:
                return false;
            default:
                break;
        }

        return false;
    }

    public boolean isReadyForPcConstruction() {
        if (getMOBO_Count() > 0 && getCPU_Count() > 0 && getRAM_Count() > 0 && getPSU_Count() > 0) {
            return true;
        }

        return false;
    }

    public void incrementCounterByType(int counterType) throws InterruptedException {
        Semaphore semaphoreToUse = this.getSemaphoreByType(counterType);

        // Si el semaforo corresponde a un tipo de componente
        if (semaphoreToUse != null) {

            semaphoreToUse.acquire(); // Asegurar exclusion mutua
            System.out.println("Semaforo tomado por trabajador tipo: " + counterType + " permits: " + semaphoreToUse.availablePermits());

            // Verificar si el almacen esta lleno antes de incrementar
            if (!isCounterTypeFull(counterType)) {

                switch (counterType) {
                    case 0:
                        this.setMOBO_Count(this.getMOBO_Count() + 1);

                    case 1:
                        this.setCPU_Count(this.getCPU_Count() + 1);

                    case 2:
                        this.setRAM_Count(this.getRAM_Count() + 1);

                    case 3:
                        this.setPSU_Count(this.getPSU_Count() + 1);

                    case 4:
                        this.setGPU_Count(this.getGPU_Count() + 1);

                }

                System.out.println("Se ha incrementado el componente " + counterType + " en la compañia " + this.getCompanyName());
            } else {
                System.out.println("No se pudo incrementar el componente " + counterType + " porque el almacen esta lleno");
            }

            semaphoreToUse.release(); // Liberar despues de actualizar
            System.out.println("Soltando Semaforo del trabajador tipo: " + counterType + "permits: " + semaphoreToUse.availablePermits());
        }
    }

    //caso especial PSU, 5 en un dia
    public void incrementPSUCounter() throws InterruptedException {

        this.getPsuSemaphore().acquire();

        int difference = this.getCapacityByType(3) - this.getPSU_Count();

        if (difference > 5) {
            for (int i = 5; 0 < i; i--) {
                this.setPSU_Count(this.getPSU_Count() + 1);
            }
        } else {
            for (int i = difference; i > 0; i--) {
                this.setPSU_Count(this.getPSU_Count() + 1);
            }
            System.out.println("Se botaron: " + (5 - difference) + "PSUs en la ultima produccion de: " + this.getCompanyName());
        }

        this.getPsuSemaphore().release();

    }

    public void decrementCounterByType(int counterType, int qtyToDecrease, boolean withGPU) throws InterruptedException {
        Semaphore semaphoreToUse = null;

        // Determinamos el semaforo a utilizar segun el tipo de componente
        switch (counterType) {
            case 0 ->
                semaphoreToUse = getMoboSemaphore();
            case 1 ->
                semaphoreToUse = getCpuSemaphore();
            case 2 ->
                semaphoreToUse = getRamSemaphore();
            case 3 ->
                semaphoreToUse = getPsuSemaphore();
            case 4 ->
                semaphoreToUse = getGpuSemaphore();
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
                        this.setMOBO_Count(this.getMOBO_Count() - qtyToDecrease);
                    case 1 ->
                        this.setCPU_Count(this.getCPU_Count() - qtyToDecrease);
                    case 2 ->
                        this.setRAM_Count(this.getRAM_Count() - qtyToDecrease);
                    case 3 ->
                        this.setPSU_Count(this.getPSU_Count() - qtyToDecrease);
                    case 4 ->
                        this.setGPU_Count(this.getGPU_Count() - qtyToDecrease);
//                    case 5 -> {
//
//                        if (withGPU) {
//                            this.setGPUCOMPUTER_Count(this.getGPUCOMPUTER_Count() + 1);
//                        } else {
//                            this.setCOMPUTER_Count(this.getCOMPUTER_Count() + 1);
//                        }
//                    }

                }

                System.out.println("Se ha reducido el componente " + counterType + " en la compañia " + this.getCompanyName());
            }

            semaphoreToUse.release(); // Liberar despues de actualizar
        }
    }

//    public void decrementCounterByType(int counterType) throws InterruptedException {
//        Semaphore semaphoreToUse = null;
//
//        // Determinamos el semaforo a utilizar segun el tipo de componente
//        switch (counterType) {
//            case 0 ->
//                semaphoreToUse = getMoboSemaphore();
//            case 1 ->
//                semaphoreToUse = getCpuSemaphore();
//            case 2 ->
//                semaphoreToUse = getRamSemaphore();
//            case 3 ->
//                semaphoreToUse = getPsuSemaphore();
//            case 4 ->
//                semaphoreToUse = getGpuSemaphore();
//            case 5 ->
//                semaphoreToUse = getComputerSemaphore();
//        }
//
//        // Si el semaforo corresponde a un tipo de componente
//        if (semaphoreToUse != null) {
//            semaphoreToUse.acquire(); // Asegurar exclusion mutua
//
//            // Verificar si el almacen esta lleno antes de incrementar
//            if (this.getStockByType(counterType) == 0) {
//                System.out.println("No se pudo restar el componente " + counterType + " porque el almacen esta vacio");
//
//            } else {
//
//                switch (counterType) {
//                    case 0 ->
//                        this.setMOBO_Count(this.getMOBO_Count() - 1);
//                    case 1 ->
//                        this.setCPU_Count(this.getCPU_Count() - 1);
//                    case 2 ->
//                        this.setRAM_Count(this.getRAM_Count() - 1);
//                    case 3 ->
//                        this.setPSU_Count(this.getPSU_Count() - 1);
//                    case 4 ->
//                        this.setGPU_Count(this.getGPU_Count() - 1);
//                    case 5 ->
//                        this.setCOMPUTER_Count(this.getCOMPUTER_Count() - 1);
//                }
//
//                System.out.println("Se ha reducido el componente " + counterType + " en la compañia " + this.getCompanyName());
//            }
//
//            semaphoreToUse.release(); // Liberar despues de actualizar
//        }
//    }
    public Semaphore getSemaphoreByType(int tipe) {

        Semaphore semaphoreToUse = null;

        // Determinamos el semaforo a utilizar segun el tipo de componente
        switch (tipe) {
            case 0 ->
                semaphoreToUse = this.getMoboSemaphore();
            case 1 ->
                semaphoreToUse = this.getCpuSemaphore();
            case 2 ->
                semaphoreToUse = this.getRamSemaphore();
            case 3 ->
                semaphoreToUse = this.getPsuSemaphore();
            case 4 ->
                semaphoreToUse = this.getGpuSemaphore();
            case 5 ->
                semaphoreToUse = this.getComputerSemaphore();
        }

        return semaphoreToUse;
    }

    public int getCapacityByType(int type) {

        if (type == 0) {
            return this.getMaxReadyMobos();
        } else if (type == 1) {
            return this.getMaxReadyCPUs();
        } else if (type == 2) {
            return this.getMaxReadyRAMs();
        } else if (type == 3) {
            return this.getMaxReadyPSUs();
        } else if (type == 4) {
            return this.getMaxReadyGPUs();
        } else if (type == 5) {
            return 999;
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
        } else if (type == 5) {
            return this.getCOMPUTER_Count();
        }

        System.out.println("Error al obtener la cantidad por tipo");
        return -1;

    }

    // Politica para computadoras GPU basada en la compañia
    private int graphicsCardRequirement() {
        switch (companyName) {
            case "Apple":
                return this.COMPUTER_Count % 5 == 0 ? 2 : 0;
            case "Dell":
                return this.COMPUTER_Count % 3 == 0 ? 1 : 0;
            case "HP":
                return this.COMPUTER_Count % 2 == 0 ? 3 : 0;
            case "MSI":
                return this.COMPUTER_Count % 6 == 0 ? 5 : 0;
            default:
                return 0; // Sin política especifica
        }
    }

    public boolean tryToAssembleComputer() throws InterruptedException {
        boolean withGraphicsCard = graphicsCardRequirement() > 0;
        boolean success = assembleComputerWithSemaphore(withGraphicsCard);

        return success;
    }

    public boolean assembleComputerWithSemaphore(boolean withGraphicsCard) throws InterruptedException {
        assemblySemaphore.acquire();
        boolean success = assembleComputer(withGraphicsCard);
        assemblySemaphore.release();
        return success;
    }

    public synchronized boolean assembleComputer(boolean withGraphicsCard) throws InterruptedException {
        // Define los requisitos ssegun si incluye tarjeta grafica
        Semaphore semaphorePC = this.getSemaphoreByType(5);
        int requiredGPUs = withGraphicsCard ? graphicsCardRequirement() : 0;

        semaphorePC.acquire();
        // Verifica si hay suficientes recursos para ensamblar
        if (this.getCompanyName().equals("MSI") && MOBO_Count >= 2 && CPU_Count >= 3 && RAM_Count >= 4 && PSU_Count >= 6 && GPU_Count >= requiredGPUs) {
            decrementCounterByType(0, 2, false);
            decrementCounterByType(1, 3, false);
            decrementCounterByType(2, 4, false);
            decrementCounterByType(3, 6, false);
//            decrementCounterByType(5);

            if (withGraphicsCard) {
                decrementCounterByType(4, requiredGPUs, true);
                this.GPUCOMPUTER_Count++;
            }
            this.COMPUTER_Count++;
            semaphorePC.release();

            return true; // Ensamblaje exitoso
        } else if (this.getCompanyName().equals("HP") && MOBO_Count >= 1 && CPU_Count >= 1 && RAM_Count >= 2 && PSU_Count >= 4 && GPU_Count >= requiredGPUs) {
            decrementCounterByType(0, 1, false);
            decrementCounterByType(1, 1, false);
            decrementCounterByType(2, 2, false);
            decrementCounterByType(3, 4, false);
//            decrementCounterByType(5);

            if (withGraphicsCard) {
                decrementCounterByType(4, requiredGPUs, true);
                this.GPUCOMPUTER_Count++;
            }
            this.COMPUTER_Count++;
            semaphorePC.release();

            return true; // Ensamblaje exitoso
        }
        semaphorePC.release();
        return false; // Recursos insuficientes
    }

    public void addCost(int cost) {
        this.setAccumulatedProductionCost(this.getAccumulatedProductionCost() + cost);
    }

    public void cleanHouse() {
        this.setAccumulatedProductionCost(0);
//        this.COMPUTER_Count = 0;
//        this.GPUCOMPUTER_Count = 0;
    }

    public void addComputer() {
        this.setCOMPUTER_Count(this.getCOMPUTER_Count() + 1);
    }

    public void addGraphicsComputer() {
        this.setGPUCOMPUTER_Count(this.getCOMPUTER_Count() + 1);
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the maxReadyMobos
     */
    public static int getMaxReadyMobos() {
        return maxReadyMobos;
    }

    /**
     * @param aMaxReadyMobos the maxReadyMobos to set
     */
    public static void setMaxReadyMobos(int aMaxReadyMobos) {
        maxReadyMobos = aMaxReadyMobos;
    }

    /**
     * @return the maxReadyCPUs
     */
    public static int getMaxReadyCPUs() {
        return maxReadyCPUs;
    }

    /**
     * @param aMaxReadyCPUs the maxReadyCPUs to set
     */
    public static void setMaxReadyCPUs(int aMaxReadyCPUs) {
        maxReadyCPUs = aMaxReadyCPUs;
    }

    /**
     * @return the maxReadyRAMs
     */
    public static int getMaxReadyRAMs() {
        return maxReadyRAMs;
    }

    /**
     * @param aMaxReadyRAMs the maxReadyRAMs to set
     */
    public static void setMaxReadyRAMs(int aMaxReadyRAMs) {
        maxReadyRAMs = aMaxReadyRAMs;
    }

    /**
     * @return the maxReadyPSUs
     */
    public static int getMaxReadyPSUs() {
        return maxReadyPSUs;
    }

    /**
     * @param aMaxReadyPSUs the maxReadyPSUs to set
     */
    public static void setMaxReadyPSUs(int aMaxReadyPSUs) {
        maxReadyPSUs = aMaxReadyPSUs;
    }

    /**
     * @return the maxReadyGPUs
     */
    public static int getMaxReadyGPUs() {
        return maxReadyGPUs;
    }

    /**
     * @param aMaxReadyGPUs the maxReadyGPUs to set
     */
    public static void setMaxReadyGPUs(int aMaxReadyGPUs) {
        maxReadyGPUs = aMaxReadyGPUs;
    }

    /**
     * @return the MOBO_Count
     */
    public int getMOBO_Count() {
        return MOBO_Count;
    }

    /**
     * @param MOBO_Count the MOBO_Count to set
     */
    public void setMOBO_Count(int MOBO_Count) {
        this.MOBO_Count = MOBO_Count;
    }

    /**
     * @return the CPU_Count
     */
    public int getCPU_Count() {
        return CPU_Count;
    }

    /**
     * @param CPU_Count the CPU_Count to set
     */
    public void setCPU_Count(int CPU_Count) {
        this.CPU_Count = CPU_Count;
    }

    /**
     * @return the RAM_Count
     */
    public int getRAM_Count() {
        return RAM_Count;
    }

    /**
     * @param RAM_Count the RAM_Count to set
     */
    public void setRAM_Count(int RAM_Count) {
        this.RAM_Count = RAM_Count;
    }

    /**
     * @return the PSU_Count
     */
    public int getPSU_Count() {
        return PSU_Count;
    }

    /**
     * @param PSU_Count the PSU_Count to set
     */
    public void setPSU_Count(int PSU_Count) {
        this.PSU_Count = PSU_Count;
    }

    /**
     * @return the GPU_Count
     */
    public int getGPU_Count() {
        return GPU_Count;
    }

    /**
     * @param GPU_Count the GPU_Count to set
     */
    public void setGPU_Count(int GPU_Count) {
        this.GPU_Count = GPU_Count;
    }

    /**
     * @return the COMPUTER_Count
     */
    public int getCOMPUTER_Count() {
        return COMPUTER_Count;
    }

    /**
     * @param COMPUTER_Count the COMPUTER_Count to set
     */
    public void setCOMPUTER_Count(int COMPUTER_Count) {
        this.COMPUTER_Count = COMPUTER_Count;
    }

    /**
     * @return the GPUCOMPUTER_Count
     */
    public int getGPUCOMPUTER_Count() {
        return GPUCOMPUTER_Count;
    }

    /**
     * @param GPUCOMPUTER_Count the GPUCOMPUTER_Count to set
     */
    public void setGPUCOMPUTER_Count(int GPUCOMPUTER_Count) {
        this.GPUCOMPUTER_Count = GPUCOMPUTER_Count;
    }

    /**
     * @return the moboSemaphore
     */
    public Semaphore getMoboSemaphore() {
        return moboSemaphore;
    }

    /**
     * @param moboSemaphore the moboSemaphore to set
     */
    public void setMoboSemaphore(Semaphore moboSemaphore) {
        this.moboSemaphore = moboSemaphore;
    }

    /**
     * @return the cpuSemaphore
     */
    public Semaphore getCpuSemaphore() {
        return cpuSemaphore;
    }

    /**
     * @param cpuSemaphore the cpuSemaphore to set
     */
    public void setCpuSemaphore(Semaphore cpuSemaphore) {
        this.cpuSemaphore = cpuSemaphore;
    }

    /**
     * @return the ramSemaphore
     */
    public Semaphore getRamSemaphore() {
        return ramSemaphore;
    }

    /**
     * @param ramSemaphore the ramSemaphore to set
     */
    public void setRamSemaphore(Semaphore ramSemaphore) {
        this.ramSemaphore = ramSemaphore;
    }

    /**
     * @return the psuSemaphore
     */
    public Semaphore getPsuSemaphore() {
        return psuSemaphore;
    }

    /**
     * @param psuSemaphore the psuSemaphore to set
     */
    public void setPsuSemaphore(Semaphore psuSemaphore) {
        this.psuSemaphore = psuSemaphore;
    }

    /**
     * @return the gpuSemaphore
     */
    public Semaphore getGpuSemaphore() {
        return gpuSemaphore;
    }

    /**
     * @param gpuSemaphore the gpuSemaphore to set
     */
    public void setGpuSemaphore(Semaphore gpuSemaphore) {
        this.gpuSemaphore = gpuSemaphore;
    }

    /**
     * @return the paymentSemaphore
     */
    public Semaphore getPaymentSemaphore() {
        return paymentSemaphore;
    }

    /**
     * @param paymentSemaphore the paymentSemaphore to set
     */
    public void setPaymentSemaphore(Semaphore paymentSemaphore) {
        this.paymentSemaphore = paymentSemaphore;
    }

    /**
     * @return the computerSemaphore
     */
    public Semaphore getComputerSemaphore() {
        return computerSemaphore;
    }

    /**
     * @param computerSemaphore the computerSemaphore to set
     */
    public void setComputerSemaphore(Semaphore computerSemaphore) {
        this.computerSemaphore = computerSemaphore;
    }

    /**
     * @return the daysRemainigSemaphore
     */
    public Semaphore getDaysRemainigSemaphore() {
        return daysRemainigSemaphore;
    }

    /**
     * @param daysRemainigSemaphore the daysRemainigSemaphore to set
     */
    public void setDaysRemainigSemaphore(Semaphore daysRemainigSemaphore) {
        this.daysRemainigSemaphore = daysRemainigSemaphore;
    }

    /**
     * @return the accumulatedProductionCost
     */
    public int getAccumulatedProductionCost() {
        return accumulatedProductionCost;
    }

    /**
     * @param accumulatedProductionCost the accumulatedProductionCost to set
     */
    public void setAccumulatedProductionCost(int accumulatedProductionCost) {
        this.accumulatedProductionCost = accumulatedProductionCost;
    }

    /**
     * @return the assemblySemaphore
     */
    public Semaphore getAssemblySemaphore() {
        return assemblySemaphore;
    }

    /**
     * @param assemblySemaphore the assemblySemaphore to set
     */
    public void setAssemblySemaphore(Semaphore assemblySemaphore) {
        this.assemblySemaphore = assemblySemaphore;
    }

}
