package com.pao.model;

public class Angajat extends Persoana {

    private String dataAngajare;

    private String nrTelefon;

    private int salariu;

    public String getData_angajare() {
        return dataAngajare;
    }


    public String getNrTelefon() {
        return nrTelefon;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public void setData_angajare(String data_angajare) {
        this.dataAngajare = data_angajare;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public Angajat(String nume, String prenume, int varsta, String data_angajare, String nrTelefon, int salariu) {
        super(nume, prenume, varsta);
        this.dataAngajare = data_angajare;
        this.nrTelefon = nrTelefon;
        this.salariu = salariu;
    }

    public Angajat(String nume, String prenume, int varsta) {
        super(nume, prenume, varsta);
    }

}
