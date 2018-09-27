package com.soat.tax.services;

import com.soat.tax.company.AutoCompany;
import com.soat.tax.company.Company;
import com.soat.tax.company.SASCompany;
import com.soat.tax.exceptions.IllegalSalesRevenueException;
import org.junit.Assert;
import org.junit.Test;

public class TaxCalculationImplTest {

    @Test
    public void should_return_25_percent_of_sales_revenue() {
        Company autoCompany = new AutoCompany("012345", "Soat");
        TaxCalculation t = new TaxCalculationImpl();
        Assert.assertEquals(250f, t.calculateTax(autoCompany, 1000f), 0);
    }

    @Test
    public void should_return_33_percent_of_sales_revenue() {
        Company sasCompany = new SASCompany("012345", "Soat", "Rue des frigos");
        TaxCalculation t = new TaxCalculationImpl();
        Assert.assertEquals(330f, t.calculateTax(sasCompany, 1000f), 0);
    }

    @Test(expected = IllegalSalesRevenueException.class)
    public void should_throw_illegal_sales_revenue_exception() {
        Company autoCompany = new AutoCompany("012345", "Soat");
        TaxCalculation t = new TaxCalculationImpl();
        t.calculateTax(autoCompany, -1000f);
    }
}