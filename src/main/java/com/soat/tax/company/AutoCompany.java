package com.soat.tax.company;

import lombok.Data;

@Data
public class AutoCompany extends Company {

    public AutoCompany(String siret, String denomination) {
        super(siret, denomination);
    }

    @Override
    public float getTaxPercentage() {
        return 0.25f;
    }
}
