package com.soat.tax.services;

import com.soat.tax.company.Company;

public class TaxCalculationImpl implements TaxCalculation {

    @Override
    public float calculateTax(Company company, float salesRevenue) {
        return company.getTaxPercentage() * salesRevenue;
    }
}
