package com.soat.tax.company;

import com.soat.tax.exceptions.CompanyTypeNotDefinedException;

public class DaoTaxPercentage {

    public float getPercentage(Company company) {

        CompanyType companyType = company.getCompanyType();

        switch(companyType){
            case AutoCompany:
                return 0.25f;
            case SASCompany:
                return 0.33f;
            default:
                throw new CompanyTypeNotDefinedException();
        }
    }
}
