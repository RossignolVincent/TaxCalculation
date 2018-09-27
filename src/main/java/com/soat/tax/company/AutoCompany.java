package com.soat.tax.company;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AutoCompany extends Company {

    public AutoCompany(){super(null, null, CompanyType.AutoCompany);}

    public AutoCompany(String siret, String denomination) {
        super(siret, denomination, CompanyType.AutoCompany);
    }

    @Override
    public float getTaxPercentage() {
        return 0.25f;
    }
}
