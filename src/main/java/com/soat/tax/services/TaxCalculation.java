package com.soat.tax.services;

import com.soat.tax.company.Company;

public interface TaxCalculation {

    float calculateTax(Company company, float salesRevenue);

}
