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

    private int MOBOWorkersAmmount;
    private int CPUWorkersAmmount;
    private int RAMWorkersAmmount;
    private int PSUWorkersAmmount;
    private int GPUWorkersAmmount;

    private int operationCost;

    private WareHouse inventoryWareHouse;
    private int readyComputers = 0;

    private int daysTillShipement;

    public Company(String companyName, int MOBOWorkersAmmount, int CPUWorkersAmmount, int RAMWorkersAmmount, int PSUWorkersAmmount, int GPUWorkersAmmount, WareHouse inventoryWareHouse, int daysTillShipement) {
        this.companyName = companyName;
        this.MOBOWorkersAmmount = MOBOWorkersAmmount;
        this.CPUWorkersAmmount = CPUWorkersAmmount;
        this.RAMWorkersAmmount = RAMWorkersAmmount;
        this.PSUWorkersAmmount = PSUWorkersAmmount;
        this.GPUWorkersAmmount = GPUWorkersAmmount;
        this.inventoryWareHouse = inventoryWareHouse;
        this.daysTillShipement = daysTillShipement;
        this.operationCost = 0;
    }

    public void addOperationCost(int cost) {
        this.operationCost += cost;
    }

    public String getCompanyName() {
        return companyName;
    }

    
    
}
