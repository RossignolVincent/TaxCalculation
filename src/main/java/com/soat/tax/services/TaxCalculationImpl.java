package com.soat.tax.services;

import com.soat.tax.company.Company;
import com.soat.tax.company.DaoTaxPercentage;
import com.soat.tax.exceptions.IllegalSalesRevenueException;
import org.springframework.stereotype.Service;


public class TaxCalculationImpl implements TaxCalculation {

    public TaxCalculationImpl(DaoTaxPercentage daoTaxPercentage) {
        this.daoTaxPercentage = daoTaxPercentage;
    }

    private DaoTaxPercentage daoTaxPercentage;

    @Override
    public float calculateTax(Company company, float salesRevenue) {
        if(salesRevenue < 0){
            throw new IllegalSalesRevenueException();
        }

        if(company == null){
            throw new IllegalArgumentException();
        }

        float percentage = daoTaxPercentage.getPercentage(company);

        return percentage * salesRevenue;
    }
}
