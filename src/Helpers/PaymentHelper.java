/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import WorkingClasses.Company;

/**
 *
 * @author B-St
 */
public class PaymentHelper {
    
    private Company company;
    
    public void addcost(int cost){
        this.company.addOperationCost(cost);
    }
    
}
