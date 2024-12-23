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

//    private int COMPUTERPrice;
    private int standardPCPrice;
    private int pcWithGPUPrice;

    public Company(String companyName, int normalPCPrice, int gpuPCPrice) {
        this.companyName = companyName;
        this.inventoryWareHouse = this.createWarehouse();
        this.brute = 0;
        this.operationCost = 0;
        this.netWins = 0;
        this.standardPCPrice = normalPCPrice;
        this.pcWithGPUPrice = gpuPCPrice;

    }

    private Warehouse createWarehouse() {
        Warehouse wa = new Warehouse(this.getCompanyName());
        return wa;
    }

    public void addBruteGains(int newGains) {
        this.setBrute(this.getBrute() + newGains);
    }

    public void addOperationCost(int cost) {
        this.setOperationCost(this.getOperationCost() + cost);
    }

    void calculateNetWins() {
        this.setNetWins(this.getBrute() - this.getOperationCost());//No necesitamos mutex porque el unico hilo que modifica esto es factory
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the inventoryWareHouse
     */
    public Warehouse getInventoryWareHouse() {
        return inventoryWareHouse;
    }

    /**
     * @param inventoryWareHouse the inventoryWareHouse to set
     */
    public void setInventoryWareHouse(Warehouse inventoryWareHouse) {
        this.inventoryWareHouse = inventoryWareHouse;
    }

    /**
     * @return the brute
     */
    public int getBrute() {
        return brute;
    }

    /**
     * @param brute the brute to set
     */
    public void setBrute(int brute) {
        this.brute = brute;
    }

    /**
     * @return the operationCost
     */
    public int getOperationCost() {
        return operationCost;
    }

    /**
     * @param operationCost the operationCost to set
     */
    public void setOperationCost(int operationCost) {
        this.operationCost = operationCost;
    }

    /**
     * @return the netWins
     */
    public int getNetWins() {
        return netWins;
    }

    /**
     * @param netWins the netWins to set
     */
    public void setNetWins(int netWins) {
        this.netWins = netWins;
    }

    /**
     * @return the standardPCPrice
     */
    public int getStandardPCPrice() {
        return standardPCPrice;
    }

    /**
     * @param standardPCPrice the standardPCPrice to set
     */
    public void setStandardPCPrice(int standardPCPrice) {
        this.standardPCPrice = standardPCPrice;
    }

    /**
     * @return the pcWithGPUPrice
     */
    public int getPcWithGPUPrice() {
        return pcWithGPUPrice;
    }

    /**
     * @param pcWithGPUPrice the pcWithGPUPrice to set
     */
    public void setPcWithGPUPrice(int pcWithGPUPrice) {
        this.pcWithGPUPrice = pcWithGPUPrice;
    }

}
