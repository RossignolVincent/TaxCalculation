package com.soat.tax.company;

import lombok.Data;

@Data
public class SASCompany extends Company {
    private String address;

    public SASCompany(String siret, String denomination, String address) {
        super(siret, denomination);
        this.address = address;
    }

    @Override
    public float getTaxPercentage() {
        return 0.33f;
    }
}
