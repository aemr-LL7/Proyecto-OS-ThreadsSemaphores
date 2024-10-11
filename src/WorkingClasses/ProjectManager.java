/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andre - PM Gestiona el proyecto y el contador
 */
public class ProjectManager extends Thread {

    private int remainingDays; // Contador de dias restantes para la entrega
    private boolean watchingAnime; // Indica si esta viendo anime
    private int daysTillShipement;
    private int dayDuration;
    private int productionTime;
    private int penaltyCounter;

    private Company company;
    private Warehouse wareHouse;

    private static Semaphore penaltySemaphore = new Semaphore(1);
    private Semaphore dayCounterSemaphore; //semaforo para modificar el contador de dias restantes

    private int accumulatedSalary;

    public ProjectManager(int daysTillShipement, Company company, int dayDuration) {
        this.daysTillShipement = daysTillShipement;
        this.remainingDays = daysTillShipement;
        this.watchingAnime = false;
        this.dayDuration = dayDuration;
        this.accumulatedSalary = 0;
        this.productionTime = 1;
        this.company = company;
        this.wareHouse = company.getInventoryWareHouse();
        this.dayCounterSemaphore = this.wareHouse.getDaysRemainigSemaphore();
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i <= 24; i++) {
                    // Ciclo de 30 minutos viendo anime y 30 minutos trabajando
                    if (i < 16){
                        this.watchAnime(); // Ver anime por 30 minutos
                        this.work(); // Trabajar por 30 minutos
                    }
                    
                    if (i>16 && i<24){
                        this.work();
                        this.work();
                    }
                    
                    if (i == 24){
                        this.updateDaysCounter();
                    }
                    
                }
                // Trabaja las últimas 8 horas actualizando el contador de días
                this.payMe();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void watchAnime() throws InterruptedException {

        this.watchingAnime = true;
//        System.out.println("Project Manager esta viendo anime...");
        Thread.sleep((this.dayDuration / 24) / 2); // Simula 30 minutos viendo anime

    }

    private void work() throws InterruptedException {

        this.watchingAnime = false;
//        System.out.println("Project Manager esta trabajando");
        Thread.sleep((this.dayDuration / 24) / 2);

    }

    private void updateDaysCounter() throws InterruptedException {

        this.getDayCounterSemaphore().acquire();
        if (this.remainingDays >= 1) {
            this.remainingDays--;
            System.out.println("Project Manager actualizo el contador. Dias restantes: " + this.remainingDays);
        }
        this.getDayCounterSemaphore().release();

    }

    private void payMe() throws InterruptedException {
        this.wareHouse.getPaymentSemaphore().acquire();
        this.getPenaltySemaphore().acquire();

        int payment = this.productionTime * (24 * 40);
        payment -= this.penaltyCounter;

        this.wareHouse.addCost(payment);
        this.penaltyCounter = 0;
        this.getPenaltySemaphore().release();
        this.wareHouse.getPaymentSemaphore().release();
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
     * @return the watchingAnime
     */
    public boolean isWatchingAnime() {
        return watchingAnime;
    }

    /**
     * @param watchingAnime the watchingAnime to set
     */
    public void setWatchingAnime(boolean watchingAnime) {
        this.watchingAnime = watchingAnime;
    }

    public static Semaphore getPenaltySemaphore() {
        return penaltySemaphore;
    }

    public Semaphore getDayCounterSemaphore() {
        return dayCounterSemaphore;
    }

    public void incrementPenaltyCounter() throws InterruptedException {
        this.getPenaltySemaphore().acquire();
        this.penaltyCounter += 100;
        this.getPenaltySemaphore().release();
    }

    public void resetDayCount() {
        this.remainingDays = this.daysTillShipement;
    }

}
