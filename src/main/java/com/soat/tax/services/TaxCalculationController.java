package com.soat.tax.services;

import com.soat.tax.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax")
public class TaxCalculationController {

    @Autowired
    private TaxCalculation taxCalculation;

    public float calculate(Company company, float salesRevenue) {
        return taxCalculation.calculateTax(company, salesRevenue);
    }
}
