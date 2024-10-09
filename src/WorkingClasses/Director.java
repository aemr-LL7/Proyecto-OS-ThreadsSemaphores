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
    private int remainingDays;
    private int completedComputers;
    private int totalRevenue; // Ganancias totales por las computadoras enviadas
    private static int SALARY_PER_HOUR = 60;
    private static int COMPUTER_PRICE = 1000;
    private Semaphore semaphore;

    private Random random = new Random();

    public Director(ProjectManager pm, int initialRemainingDays, int initialComputers, Semaphore semaphore) {
        this.PM = pm;
        this.remainingDays = initialRemainingDays;
        this.completedComputers = initialComputers;
        this.totalRevenue = 0;
        this.semaphore = semaphore;
    }

     @Override
    public void run() {
        int hoursWorked = 0;
        int randomHourToCheckPM = this.random.nextInt(24); // Hora aleatoria en la que Director revisara al PM
        boolean hasCheckedPM = false;

        while (hoursWorked < 24) {
            try {
                this.semaphore.acquire();
                
                if (this.remainingDays == 0) {
                    // Enviar computadoras a las distribuidoras (toma 24 horas)
                    this.sendComputers();
                    // Reiniciar el contador de días restantes
                    this.resetDaysCounter();
                    // Salir del ciclo ya que se enviaron computadoras
                    break; 
                } else {
                    this.semaphore.release();
                    // Realizar labores administrativas
                    this.performAdministrativeTasks();

                    // Revisar al Project Manager en una hora aleatoria del dia
                    if (!hasCheckedPM && hoursWorked == randomHourToCheckPM) {
                        this.checkProjectManager();
                        hasCheckedPM = true; // Solo revisa al PM una vez al dia
                    }

                    // Incrementar horas trabajadas y simular una hora de trabajo
                    hoursWorked++;
                    Thread.sleep(1000); // Simulacion de 1 hora
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Dia completo para el Director");
    }

    // Metodo para enviar las computadoras a las distribuidoras
    private void sendComputers() {
        System.out.println("Director esta enviando computadoras a las distribuidoras...");
        this.totalRevenue += this.completedComputers * COMPUTER_PRICE; // Registrar las ganancias
        
        System.out.println("Ganancia registrada: $" + (completedComputers * COMPUTER_PRICE));
        this.completedComputers = 0; // Reiniciar el num de pcs completadas
    }

    // Metodo para reiniciar el contador de días restantes
    private void resetDaysCounter() {
        this.remainingDays = 10; // nuevo plazo es de 10 dias probando (puedes cambiar este valor)
        System.out.println("Reiniciando contador de dias restantes: " + this.remainingDays);
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
            this.PM.setSalaryPenalty(100); // Aplicar penalizacion de $100 al PM
        } else {
            System.out.println("El PM esta trabajando correctamente");
        }
    }

    // Metodo para calcular el salario diario
    public int calculateDailySalary() {
        return getSALARY_PER_HOUR() * 24; // 24 horas trabajadas al dia
    }

    /**
     * @return the PM
     */
    public ProjectManager getPM() {
        return PM;
    }

    /**
     * @param PM the PM to set
     */
    public void setPM(ProjectManager PM) {
        this.PM = PM;
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

}
