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
    private int elapsedDays;
    private int dayDuration;
    private int productionTime;
    private int penaltyCounter;

    private static Semaphore penaltySemafore = new Semaphore(1);

    private int accumulatedSalary;

    private WareHouse wareHouse;

    private Semaphore dayCounterSemaphore;

    public ProjectManager(int daysTillShipement, Semaphore semaphore, Company company, int dayDuration, WareHouse wareHouse) {
        this.daysTillShipement = daysTillShipement;
        this.remainingDays = this.daysTillShipement;
        this.watchingAnime = false;
        this.dayDuration = dayDuration;
        this.accumulatedSalary = 0;
        this.elapsedDays = 0;
        this.productionTime = 1;

        this.dayCounterSemaphore = this.wareHouse.getDaysRemainigSemaphore();
    }

    @Override
    public void run() {
        int hoursWorked = 0;
        while (hoursWorked < 24) {
            try {
                // Ciclo de 30 minutos viendo anime y 30 minutos trabajando
                for (int i = 0; i < 16; i++) {
                    this.watchAnime(); // Ver anime por 30 minutos
                    this.work(); // Trabajar por 30 minutos
                }
                // Trabaja las últimas 8 horas actualizando el contador de días
                this.updateDaysCounter();
                this.payMe();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void watchAnime() throws InterruptedException {

        this.watchingAnime = true;
        System.out.println("Project Manager esta viendo anime...");
        Thread.sleep((this.dayDuration / 24) / 2); // Simula 30 minutos viendo anime

    }

    private void work() throws InterruptedException {

        this.watchingAnime = false;
        System.out.println("Project Manager esta trabajando");
        Thread.sleep((this.dayDuration / 24) / 2);

    }

    private void updateDaysCounter() throws InterruptedException {

        this.elapsedDays++;
        if (this.remainingDays > 1) {
            this.remainingDays = (this.daysTillShipement - elapsedDays);
            System.out.println("Project Manager actualizo el contador. Dias restantes: " + this.remainingDays);
        }

    }

    private void payMe() throws InterruptedException {
        this.wareHouse.getPaymentSemaphore().acquire();
        this.getPenaltySemafore().acquire();

        int payment = this.productionTime * (24 * 40);
        payment -= this.penaltyCounter;

        this.wareHouse.addCost(payment);
        this.penaltyCounter = 0;
        this.getPenaltySemafore().release();
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

    public static Semaphore getPenaltySemafore() {
        return penaltySemafore;
    }

}
