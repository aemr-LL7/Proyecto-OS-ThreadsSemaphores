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
    private int operationCost;
    private WareHouse inventoryWareHouse;
    private int readyComputers;

    private int daysTillShipement;

    public Company(String companyName, WareHouse inventoryWareHouse) {
        this.companyName = companyName;
        this.inventoryWareHouse = inventoryWareHouse;
        this.operationCost = 0;
        this.readyComputers = 0;
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

    public int getReadyComputers() {
        return readyComputers;
    }

    public void setReadyComputers(int readyComputers) {
        this.readyComputers = readyComputers;
    }

    
}
