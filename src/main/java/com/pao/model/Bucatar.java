package com.pao.model;

public class Bucatar extends Angajat{

    private String specializare;

    private int experienta;

    public String getSpecializare() {
        return specializare;
    }

    public int getExperienta() {
        return experienta;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    public Bucatar(String nume, String prenume, int varsta, String data_angajare, String nrTelefon, int salariu, String specializare, int experienta) {
        super(nume, prenume, varsta, data_angajare, nrTelefon, salariu);
        this.specializare = specializare;
        this.experienta = experienta;
    }

    public Bucatar(String nume, String prenume, int varsta, String data_angajare, String nrTelefon, int salariu) {
        super(nume, prenume, varsta, data_angajare, nrTelefon, salariu);
    }
}
