package com.soat.tax.services;

import com.soat.tax.company.AutoCompany;
import com.soat.tax.company.Company;
import com.soat.tax.company.SASCompany;
import com.soat.tax.exceptions.IllegalSalesRevenueException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaxCalculationImplTest {

    @Test
    public void should_return_25_percent_of_sales_revenue() {
        // given
        Company autoCompany = new AutoCompany("012345", "Soat");
        // when
        TaxCalculation t = new TaxCalculationImpl();
        float tax = t.calculateTax(autoCompany, 1000f);
        // then
        assertEquals(250f, tax, 0);
    }

    @Test
    public void should_return_33_percent_of_sales_revenue() {
        // given
        Company sasCompany = new SASCompany("012345", "Soat", "Rue des frigos");
        // when
        TaxCalculation t = new TaxCalculationImpl();
        float tax = t.calculateTax(sasCompany, 1000f);
        // then
        assertEquals(330f, tax, 0);

    }

    @Test(expected = IllegalSalesRevenueException.class)
    public void should_throw_illegal_sales_revenue_exception() {
        Company autoCompany = new AutoCompany("012345", "Soat");
        TaxCalculation t = new TaxCalculationImpl();
        t.calculateTax(autoCompany, -1000f);
    }

    @Test
    public void should_throw_illegal_argument_exception() {
        Company autoCompany = null;
        TaxCalculation t = new TaxCalculationImpl();
        try {
            t.calculateTax(autoCompany, 1000f);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}