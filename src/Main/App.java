/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import FileManager.FileManager;
import GUI.Home;
import WorkingClasses.ChartManager;
import WorkingClasses.Factory;
import java.io.File;

/**
 *
 * @author Windows 11
 */
public class App {

    private static App app;

    // Archivos params
    private static String originPath = ".saved//data.txt";
    private static File selectedFile = new File(getOriginPath());
    private static FileManager fileManager = new FileManager();

    // General params
    private static int dayDuration;
    private static int deadline;

    // General variables
    private static Factory factory0; //HP
    private static Factory factory1;    //MSI
    private static ChartManager chartManager;

    public static synchronized App getAppInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }

    public void initSimulation() {
        // Cargar valores iniciales ==> Leer data.txt en .saved (raiz del proyecto)
        this.getFileManager().savedDirectoryExists();
        this.getFileManager().loadParamsFromTxt();  // Crea las factories

        System.out.println("COMPANIA 1: " + this.getFactory0().getCompany().getCompanyName());
        this.getFactory0().getWorkersCountByType();
        System.out.println("COMPANIA 2: " + this.getFactory1().getCompany().getCompanyName());
        this.getFactory1().getWorkersCountByType();

        System.out.println("\nDuration: " + this.getDayDuration());
        System.out.println("Deadline: " + this.getDeadline());
        // Inicializar hilos
        this.getFactory0().start();
        this.getFactory1().start();
        this.chartManager = new ChartManager();

        // Abrir ventana del programa
        Home home = new Home();
        home.setVisible(true);
    }

    /**
     * @return the app
     */
    public static App getApp() {
        return app;
    }

    /**
     * @param aApp the app to set
     */
    public static void setApp(App aApp) {
        app = aApp;
    }

    /**
     * @return the originPath
     */
    public static String getOriginPath() {
        return originPath;
    }

    /**
     * @param aOriginPath the originPath to set
     */
    public static void setOriginPath(String aOriginPath) {
        originPath = aOriginPath;
    }

    /**
     * @return the selectedFile
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

    /**
     * @param aSelectedFile the selectedFile to set
     */
    public static void setSelectedFile(File aSelectedFile) {
        selectedFile = aSelectedFile;
    }

    /**
     * @return the fileManager
     */
    public static FileManager getFileManager() {
        return fileManager;
    }

    /**
     * @param aFileManager the fileManager to set
     */
    public static void setFileManager(FileManager aFileManager) {
        fileManager = aFileManager;
    }

    /**
     * @return the dayDuration
     */
    public static int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param aDayDuration the dayDuration to set
     */
    public static void setDayDuration(int aDayDuration) {
        dayDuration = aDayDuration;
    }

    /**
     * @return the deadline
     */
    public static int getDeadline() {
        return deadline;
    }

    /**
     * @param aDeadline the deadline to set
     */
    public static void setDeadline(int aDeadline) {
        deadline = aDeadline;
    }

    /**
     * @return the factory0
     */
    public static Factory getFactory0() {
        return factory0;
    }

    /**
     * @param aFactory0 the factory0 to set
     */
    public static void setFactory0(Factory aFactory0) {
        factory0 = aFactory0;
    }

    /**
     * @return the factory1
     */
    public static Factory getFactory1() {
        return factory1;
    }

    /**
     * @param aFactory1 the factory1 to set
     */
    public static void setFactory1(Factory aFactory1) {
        factory1 = aFactory1;
    }

    /**
     * @return the chartManager
     */
    public static ChartManager getChartManager() {
        return chartManager;
    }

    /**
     * @param aChartManager the chartManager to set
     */
    public static void setChartManager(ChartManager aChartManager) {
        chartManager = aChartManager;
    }

}
