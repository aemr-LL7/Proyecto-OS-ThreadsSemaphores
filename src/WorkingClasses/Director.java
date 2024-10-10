/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author andre Director se encarga de la administración general
 */
public class Director extends Thread {

    private ProjectManager PM; // Referencia al Project Manager
    private boolean hasCheckedThePm;

    private int dayDuration;

    private static int COMPUTER_PRICE = 1000;
    private int totalRevenue; // Ganancias totales por las computadoras enviadas
    private static int SALARY_PER_HOUR = 60;

    private WareHouse wareHouse;

    private Semaphore penaltySemaphore;

    private Random random = new Random();

    public Director(ProjectManager pm, WareHouse wareHouse, int dayDuration) {
        this.hasCheckedThePm = false;

        this.PM = pm;
        this.wareHouse = wareHouse;
        this.dayDuration = dayDuration;
        this.PM = pm;

        this.penaltySemaphore = this.PM.getPenaltySemaphore();
    }

    @Override
    public void run() {
        int randomHourToCheckPM = this.random.nextInt(24)+1; // Hora aleatoria en la que Director revisara al PM

        while (true) {
            try {
                for (int i = 0 ; i<24; i++){
                    Thread.sleep(this.dayDuration/24);
                    this.work(randomHourToCheckPM, i);
                }
                
            } catch (InterruptedException e) {
            }
        }

    }

    private void work(int checkHour, int currentTime) throws InterruptedException {

        if (this.getPm().getRemainingDays() == 0) {
            this.getPm().getDayCounterSemaphore().acquire();
            // Enviar computadoras a las distribuidoras (toma 24 horas)
            this.sendComputers();
            // Reiniciar el contador de días restantes
            this.resetDaysCounter();
            // Salir del ciclo ya que se enviaron computadoras
            this.getPm().getDayCounterSemaphore().release();
        } else {
            if (checkHour == currentTime){
                //joderPM
            }
        }
    }

    // Metodo para enviar las computadoras a las distribuidoras
    private void sendComputers() throws InterruptedException {
        this.wareHouse.getSemaphoreByType(5).acquire();
        System.out.println("Director esta enviando computadoras a las distribuidoras...");
        this.totalRevenue += this.wareHouse.getCOMPUTER_Count() * COMPUTER_PRICE; // Registrar las ganancias

        System.out.println("Ganancia registrada: $" + (this.wareHouse.getCOMPUTER_Count() * COMPUTER_PRICE));
        this.wareHouse.setCOMPUTER_Count(0); // Reiniciar el num de pcs completadas
        this.wareHouse.getSemaphoreByType(5).release();

        Thread.sleep(this.dayDuration);
    }

    // Metodo para reiniciar el contador de días restantes
    private void resetDaysCounter() {
        this.getPm().resetDayCount();
    }

    // Metodo para realizar labores administrativas
    private void performAdministrativeTasks() {
        System.out.println("Director está realizando tareas administrativas");
    }

    // Metodo para revisar al PM
    private void checkProjectManager() {
        System.out.println("Director esta revisando al Project Manager...");
        // Verificar si el PM esta viendo anime
        if (this.PM.isWatchingAnime()) {
            System.out.println("¡Falta! El PM fue descubierto viendo anime");

        } else {
            System.out.println("El PM esta trabajando correctamente");
        }
    }

    // Metodo para calcular el salario diario
    public int calculateDailySalary() {
        return getSALARY_PER_HOUR() * 24; // 24 horas trabajadas al dia
    }

    /**
     * @return the remainingDays
     */
    public int getRemainingDays() {
        return remainingDays;
    }

    /**
     * @param remainingDays the remainingDays to set
     */
    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    /**
     * @return the completedComputers
     */
    public int getCompletedComputers() {
        return completedComputers;
    }

    /**
     * @param completedComputers the completedComputers to set
     */
    public void setCompletedComputers(int completedComputers) {
        this.completedComputers = completedComputers;
    }

    /**
     * @return the totalRevenue
     */
    public int getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * @param totalRevenue the totalRevenue to set
     */
    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * @return the SALARY_PER_HOUR
     */
    public static int getSALARY_PER_HOUR() {
        return SALARY_PER_HOUR;
    }

    /**
     * @param aSALARY_PER_HOUR the SALARY_PER_HOUR to set
     */
    public static void setSALARY_PER_HOUR(int aSALARY_PER_HOUR) {
        SALARY_PER_HOUR = aSALARY_PER_HOUR;
    }

    /**
     * @return the COMPUTER_PRICE
     */
    public static int getCOMPUTER_PRICE() {
        return COMPUTER_PRICE;
    }

    /**
     * @param aCOMPUTER_PRICE the COMPUTER_PRICE to set
     */
    public static void setCOMPUTER_PRICE(int aCOMPUTER_PRICE) {
        COMPUTER_PRICE = aCOMPUTER_PRICE;
    }

    private ProjectManager getPm() {
        return this.PM;
    }

}
