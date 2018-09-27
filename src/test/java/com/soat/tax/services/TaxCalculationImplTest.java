package com.soat.tax.services;

import com.soat.tax.company.AutoCompany;
import com.soat.tax.company.Company;
import com.soat.tax.company.DaoTaxPercentage;
import com.soat.tax.company.SASCompany;
import com.soat.tax.exceptions.IllegalSalesRevenueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculationImplTest {

    @Mock
    DaoTaxPercentage daoTaxPercentage;

    @Test
    public void should_return_25_percent_of_sales_revenue() {
        // given
        Company autoCompany = new AutoCompany("012345", "Soat");
        // when
        TaxCalculation t = new TaxCalculationImpl(daoTaxPercentage);
        Mockito.when(daoTaxPercentage.getPercentage(autoCompany)).thenReturn(0.25f);
        float tax = t.calculateTax(autoCompany, 1000f);
        // then
        verify(daoTaxPercentage, times(1)).getPercentage(autoCompany);
        assertEquals(250f, tax, 0);
    }

    @Test
    public void should_return_33_percent_of_sales_revenue() {
        // given
        Company sasCompany = new SASCompany("012345", "Soat", "Rue des frigos");
        // when
        TaxCalculation t = new TaxCalculationImpl(daoTaxPercentage);
        Mockito.when(daoTaxPercentage.getPercentage(sasCompany)).thenReturn(0.33f);
        float tax = t.calculateTax(sasCompany, 1000f);
        // then
        verify(daoTaxPercentage, times(1)).getPercentage(sasCompany);
        assertEquals(330f, tax, 0);

    }

    @Test(expected = IllegalSalesRevenueException.class)
    public void should_throw_illegal_sales_revenue_exception() {
        Company autoCompany = new AutoCompany("012345", "Soat");
        TaxCalculation t = new TaxCalculationImpl(daoTaxPercentage);
        t.calculateTax(autoCompany, -1000f);
    }

    @Test
    public void should_throw_illegal_argument_exception() {
        Company autoCompany = null;
        TaxCalculation t = new TaxCalculationImpl(daoTaxPercentage);
        try {
            t.calculateTax(autoCompany, 1000f);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void should_throw_company_type_not_defined_exception() {

    }
}