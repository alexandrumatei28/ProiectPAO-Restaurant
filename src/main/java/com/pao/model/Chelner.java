package com.pao.model;

public class Chelner extends Angajat{

    private int experienta;

    private String tip;

    public int getExperienta() {
        return experienta;
    }

    public String getTip() {
        return tip;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Chelner(String nume, String prenume, int varsta, String data_angajare, String nrTelefon, int salariu, int experienta, String tip) {
        super(nume, prenume, varsta, data_angajare, nrTelefon, salariu);
        this.experienta = experienta;
        this.tip = tip;
    }

    public Chelner(String nume, String prenume, int varsta, String data_angajare, String nrTelefon, int salariu) {
        super(nume, prenume, varsta, data_angajare, nrTelefon, salariu);
    }
}
