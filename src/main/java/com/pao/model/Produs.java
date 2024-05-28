package com.pao.model;

public class Produs {

    private String categorie;
    private String denumire;

    private int pret;

    public String getCategorie() {
        return categorie;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getPret() {
        return pret;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Produs(String categorie, String denumire, int pret) {
        this.categorie = categorie;
        this.denumire = denumire;
        this.pret = pret;
    }

    public Produs() {
    }

    @Override
    public String toString(){
        return "Categorie: " + categorie +", Denumire: " + denumire + ", Pret: " + pret;
    }
}
