package com.soat.tax.services;

import com.soat.tax.company.Company;
import com.soat.tax.exceptions.IllegalSalesRevenueException;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculationImpl implements TaxCalculation {

    @Override
    public float calculateTax(Company company, float salesRevenue) {
        if(salesRevenue < 0){
            throw new IllegalSalesRevenueException();
        }

        if(company == null){
            throw new IllegalArgumentException();
        }

        return company.getTaxPercentage() * salesRevenue;
    }
}
