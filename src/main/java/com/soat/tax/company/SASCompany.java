package com.soat.tax.company;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SASCompany extends Company {
    private String address;

    public SASCompany(){super(null, null, CompanyType.SASCompany);}

    public SASCompany(String siret, String denomination, String address) {
        super(siret, denomination, CompanyType.SASCompany);
        this.address = address;
    }

    @Override
    public float getTaxPercentage() {
        return 0.33f;
    }
}
