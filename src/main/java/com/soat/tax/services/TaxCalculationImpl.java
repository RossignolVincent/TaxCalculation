package com.soat.tax.services;

import com.soat.tax.company.Company;
import com.soat.tax.exceptions.IllegalSalesRevenueException;

public class TaxCalculationImpl implements TaxCalculation {

    @Override
    public float calculateTax(Company company, float salesRevenue) {
        if(salesRevenue < 0){
            throw new IllegalSalesRevenueException();
        }
        return company.getTaxPercentage() * salesRevenue;
    }
}
