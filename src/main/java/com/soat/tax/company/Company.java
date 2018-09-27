package com.soat.tax.company;

public abstract class Company {
    private String siret;
    private String denomination;

    public Company(String siret, String denomination) {
        this.siret = siret;
        this.denomination = denomination;
    }

    public abstract float getTaxPercentage();
}
