package com.soat.tax.company;

public abstract class Company {
    private final String siret;
    private final String denomination;

    public Company(String siret, String denomination) {
        this.siret = siret;
        this.denomination = denomination;
    }

    public abstract float getTaxPercentage();
}
