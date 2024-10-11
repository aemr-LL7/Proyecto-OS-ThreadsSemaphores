/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

/**
 *
 * @author B-St
 */
public class Company {

    private String companyName;

    private Warehouse inventoryWareHouse;

    private int brute;
    private int operationCost;
    private int netWins;

    private int COMPUTERPrice;

    public Company(String companyName, int COMPUTERPRICE) {
        this.companyName = companyName;
        this.inventoryWareHouse = this.createWarehouse();
        this.operationCost = 0;
        this.brute = 0;
        this.COMPUTERPrice = COMPUTERPRICE;
        this.netWins = 0;
    }

    private Warehouse createWarehouse() {
        Warehouse wa = new Warehouse(this.companyName);
        return wa;
    }

    public void addBrute(int newGains) {
        this.brute += newGains;
    }

    public void addOperationCost(int cost) {
        this.operationCost += cost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOperationCost() {
        return operationCost;
    }

    public void setOperationCost(int operationCost) {
        this.operationCost = operationCost;
    }

    public Warehouse getInventoryWareHouse() {
        return this.inventoryWareHouse;
    }

    public int getCOMPUTERPrice() {
        return this.COMPUTERPrice;
    }

    void calculateNetWins() {
        this.netWins = (this.brute - this.operationCost);//No necesitamos mutex porque el unico hilo que modifica esto es factory
    }

    public int getBrute() {
        return brute;
    }

    public int getNetWins() {
        return netWins;
    }
    
    

}
