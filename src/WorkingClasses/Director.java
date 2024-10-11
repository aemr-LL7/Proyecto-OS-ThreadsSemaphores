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

    private Company company;

    private ProjectManager PM; // Referencia al Project Manager
    private boolean hasCheckedThePM;
    private String status;

    private int dayDuration;

    private static int COMPUTER_PRICE;
    private int totalRevenue; // Ganancias totales por las computadoras enviadas
    private static int SALARY_PER_HOUR = 60;

    private final Warehouse wareHouse;

    private Random random = new Random();

    public Director(ProjectManager pm, Warehouse wareHouse, int dayDuration, Company company) {
        this.hasCheckedThePM = false;

        this.status = "Administrating";
        this.PM = pm;
        this.company = company;
        this.COMPUTER_PRICE = company.getCOMPUTERPrice();
        this.wareHouse = wareHouse;
        this.dayDuration = dayDuration;
        this.PM = pm;

    }

    @Override
    public void run() {

        while (true) {
            int randomHourToCheckPM = this.random.nextInt(24) + 1; // Hora aleatoria en la que Director revisara al PM
            this.status = "Administrating";
            try {
                for (int i = 0; i < 24; i++) {
                    
                    this.hasCheckedThePM = false;
                    if (this.getPm().getRemainingDays() == 0) {
                        Thread.sleep(this.dayDuration / 24);
                        this.status = "Sending";
                        this.getPm().getDayCounterSemaphore().acquire();
                        // Enviar computadoras a las distribuidoras (toma 24 horas)
                        this.sendComputers();
                        // Reiniciar el contador de días restantes
                        this.resetDaysCounter();
                        // Salir del ciclo ya que se enviaron computadoras
                        this.getPm().getDayCounterSemaphore().release();
                        this.status = "Administraring";
                    } else if (randomHourToCheckPM == i) {

                        this.status = "Checking PM";
                        Thread.sleep((long) ((this.dayDuration / 24) * 0.58));//35/60 == 0.58 como estamos dividiendo el dia en horas, podemos usar este calculo
                        this.checkProjectManager();
                        

                    } else {
                        this.status = "Administrating";
                    }
                    
                    this.status = "Administraring";
                }

                this.payMe();

            } catch (InterruptedException e) {
                System.out.println("Error en el director");
            }
        }

    }

    // Metodo para enviar las computadoras a las distribuidoras
    private void sendComputers() throws InterruptedException {

        this.wareHouse.getSemaphoreByType(5).acquire();
        System.out.println("Director esta enviando computadoras a las distribuidoras...");
        this.company.addBrute(this.wareHouse.getCOMPUTER_Count() * COMPUTER_PRICE); // Registrar las ganancias

        System.out.println("Ganancia registrada: $" + (this.wareHouse.getCOMPUTER_Count() * COMPUTER_PRICE));
        this.wareHouse.setCOMPUTER_Count(0); // Reiniciar el num de pcs completadas
        this.wareHouse.getSemaphoreByType(5).release();

        Thread.sleep(this.dayDuration);
    }

    // Metodo para reiniciar el contador de días restantes
    private void resetDaysCounter() {
        this.getPm().resetDayCount();
    }

    // Metodo para revisar al PM
    private void checkProjectManager() throws InterruptedException {
        if (!this.hasCheckedThePM) {
//            System.out.println("Director esta revisando al Project Manager...");
            // Verificar si el PM esta viendo anime
            if (this.PM.isWatchingAnime()) {
//                System.out.println("¡Falta! El PM fue descubierto viendo anime!");
                this.hasCheckedThePM = true;
                this.PM.incrementPenaltyCounter();
                this.status = "Administrating";
            } else {
//                System.out.println("El PM esta trabajando correctamente");
            }
        }
    }

    // Metodo para calcular el salario diario
    public int calculateDailySalary() {
        return getSALARY_PER_HOUR() * 24; // 24 horas trabajadas al dia
    }

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

    private void payMe() throws InterruptedException {
        this.wareHouse.getPaymentSemaphore().acquire();
        int payment = (24 * 60);
        this.wareHouse.addCost(payment);
        this.wareHouse.getPaymentSemaphore().release();
    }

    public String getStatus() {
        return status;
    }

}
