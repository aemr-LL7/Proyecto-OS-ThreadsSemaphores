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
    
    private WareHouse inventoryWareHouse;
    
    private int brute;
    private int operationCost;
    private int netWins;
    

    private int COMPUTERPrice;

    public Company(String companyName, WareHouse inventoryWareHouse, int COMPUTERPRICE) {
        this.companyName = companyName;
        this.inventoryWareHouse = inventoryWareHouse;
        this.operationCost = 0;
        this.brute = 0;
        this.COMPUTERPrice = COMPUTERPRICE;
        this.netWins = 0;
    }
    
    public void addBrute(int newGains){
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

    public WareHouse getInventoryWareHouse() {
        return inventoryWareHouse;
    }

    public int getCOMPUTERPrice() {
        return this.COMPUTERPrice;
    }

    void calculateNetWins() {
        this.netWins = (this.brute - this.operationCost);//No necesitamos mutex porque el unico hilo que modifica esto es factory
    }
    
}
