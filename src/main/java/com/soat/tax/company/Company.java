package com.soat.tax.company;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public abstract class Company {
    private final String siret;
    private final String denomination;
    private final CompanyType companyType;

    public Company(String siret, String denomination, CompanyType companyType) {
        this.siret = siret;
        this.denomination = denomination;
        this.companyType = companyType;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public abstract float getTaxPercentage();
}
