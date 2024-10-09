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
    private static int SALARY_PER_HOUR = 40;
    private int salaryPenalty = 0;
    private Semaphore semaphore; // Semáforo para sincronización
    
    private Company company; 

    public ProjectManager(int initialRemainingDays, Semaphore semaphore, Company company) {
        this.remainingDays = initialRemainingDays;
        this.watchingAnime = false;
        this.semaphore = semaphore;
        this.company = company;
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
                
                hoursWorked += 24;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void watchAnime() throws InterruptedException {
        this.semaphore.acquire();
        this.watchingAnime = true;
        System.out.println("Project Manager esta viendo anime...");
        Thread.sleep(500); // Simula 30 minutos viendo anime
        this.semaphore.release();
    }

    private void work() throws InterruptedException {
        this.semaphore.acquire();
        this.watchingAnime = false;
        System.out.println("Project Manager esta trabajando");
        Thread.sleep(500); // Simula 30 minutos trabajando
        this.semaphore.release();
    }

    private void updateDaysCounter() throws InterruptedException {
        this.semaphore.acquire();
        this.remainingDays--;
        System.out.println("Project Manager actualizo el contador. Dias restantes: " + this.remainingDays);
        this.semaphore.release();
    }

    public int calculateDailySalary() {
        return (SALARY_PER_HOUR * 24) - this.salaryPenalty;
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
     * @return the salaryPenalty
     */
    public int getSalaryPenalty() {
        return salaryPenalty;
    }

    /**
     * @param amount the salaryPenalty to set
     */
    public void setSalaryPenalty(int amount) {
        this.salaryPenalty += amount;
        System.out.println("Penalizacion aplicada: $" + amount);
    }

}
